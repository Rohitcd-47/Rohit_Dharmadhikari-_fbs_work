package com.myntra.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.myntra.model.CartItem;
import com.myntra.model.Order;
import com.myntra.model.User;
import com.myntra.service.CartService;
import com.myntra.service.OrderService;
import com.myntra.serviceImpl.CartServiceImpl;
import com.myntra.serviceImpl.OrderServiceImpl;
import com.myntra.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/CardPaymentController")
public class CardPaymentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");

        if(user == null){
            response.sendRedirect("login.jsp");
            return;
        }

        String cardNumber = request.getParameter("cardNumber");

        if(cardNumber == null || !cardNumber.matches("\\d{16}")){
            response.sendRedirect("Checkout.jsp?error=Invalid Card Number");
            return;
        }

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement checkStmt = con.prepareStatement("SELECT * FROM card_payment WHERE user_id=?");
            checkStmt.setInt(1, user.getUserId());
            ResultSet rs = checkStmt.executeQuery();

            boolean paymentSuccess = false;

            if(rs.next()){
                String dbCard = rs.getString("card_number");
                if(dbCard.equals(cardNumber)){
                    paymentSuccess = true;
                }else{
                    response.sendRedirect("Checkout.jsp?error=Incorrect Card Number");
                    return;
                }
            }else{
                PreparedStatement insertStmt = con.prepareStatement("INSERT INTO card_payment(user_id, card_number) VALUES(?,?)");
                insertStmt.setInt(1, user.getUserId());
                insertStmt.setString(2, cardNumber);
                insertStmt.executeUpdate();
                paymentSuccess = true;
            }
            
            rs.close();
            checkStmt.close();
            con.close();

            if(paymentSuccess){
                // Get address from form submission
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String cardName = request.getParameter("cardName");

                CartService cartService = new CartServiceImpl();
                OrderService orderService = new OrderServiceImpl();

                List<CartItem> cartItems = cartService.getUserCart(user.getUserId());
                
                // IMPORTANT: Check if cart is empty
                if(cartItems == null || cartItems.isEmpty()){
                    response.getWriter().println(
                        "<script>alert('Your cart is empty!');window.location='viewcart.jsp';</script>"
                    );
                    return;
                }

                double totalAmount = 0;
                for(CartItem item : cartItems){
                    totalAmount += item.getProduct().getPrice() * item.getQuantity();
                }

                Order order = new Order();
                order.setUserId(user.getUserId());
                order.setCardHolderName(cardName != null ? cardName : user.getName());
                order.setShippingAddress(address != null ? address : user.getShippingAddress());
                order.setPhoneNumber(phone != null ? phone : user.getPhoneNumber());
                order.setTotalAmount(totalAmount);
                order.setStatus("Pending");

                int orderId = orderService.placeNewOrder(order, cartItems);
                
                // CRITICAL FIX: Clear the cart after successful order placement
                if(orderId > 0){
                    // Delete cart items from database
                    Connection conn = DBConnection.getConnection();
                    PreparedStatement clearCartStmt = conn.prepareStatement("DELETE FROM cart WHERE user_id = ?");
                    clearCartStmt.setInt(1, user.getUserId());
                    clearCartStmt.executeUpdate();
                    clearCartStmt.close();
                    conn.close();
                    
                    // Also remove from session cart if exists
                    session.removeAttribute("cart");
                    
                    response.getWriter().println(
                        "<script>"
                        + "alert('Payment Successful! Order placed successfully.');"
                        + "window.location='OrderConfirmation.jsp?orderId=" + orderId
                        + "&fullName=" + (cardName != null ? cardName : user.getName())
                        + "&phone=" + (phone != null ? phone : user.getPhoneNumber())
                        + "&address=" + (address != null ? address : user.getShippingAddress())
                        + "';"
                        + "</script>"
                    );
                } else {
                    response.getWriter().println(
                        "<script>alert('Failed to place order. Please try again.');window.location='viewcart.jsp';</script>"
                    );
                }
            }

        } catch(Exception e){
            e.printStackTrace();
            response.sendRedirect("Checkout.jsp?error=Something went wrong: " + e.getMessage());
        }
    }
}