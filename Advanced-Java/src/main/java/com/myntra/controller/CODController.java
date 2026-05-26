package com.myntra.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
@WebServlet("/CODController")
public class CODController extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");

        if(user == null){
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            // Get payment method from hidden field
            String paymentMethod = request.getParameter("paymentMethod");
            
            // Get address from form parameters
            String fullName = request.getParameter("fullName");
            String phone = request.getParameter("phone");
            String house = request.getParameter("house");
            String area = request.getParameter("area");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String pincode = request.getParameter("pincode");
            
            // Build complete address
            String completeAddress = "";
            if(house != null && !house.trim().isEmpty()){
                completeAddress = house + ", " + area + ", " + city + ", " + state + " - " + pincode;
            } else {
                completeAddress = user.getShippingAddress();
                phone = user.getPhoneNumber();
                fullName = user.getName();
            }

            CartService cartService = new CartServiceImpl();
            OrderService orderService = new OrderServiceImpl();

            List<CartItem> cartItems = cartService.getUserCart(user.getUserId());
            
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
            order.setCardHolderName(fullName != null ? fullName : user.getName());
            order.setShippingAddress(completeAddress);
            order.setPhoneNumber(phone != null ? phone : user.getPhoneNumber());
            order.setTotalAmount(totalAmount);
            order.setStatus("Pending");

            int orderId = orderService.placeNewOrder(order, cartItems);
            
            if(orderId > 0){
                Connection conn = DBConnection.getConnection();
                PreparedStatement clearCartStmt = conn.prepareStatement("DELETE FROM cart WHERE user_id = ?");
                clearCartStmt.setInt(1, user.getUserId());
                clearCartStmt.executeUpdate();
                clearCartStmt.close();
                conn.close();
                
                session.removeAttribute("cart");
                
                // Show different message based on payment method
                String successMessage = "";
                if("UPI".equals(paymentMethod)) {
                    successMessage = "✅ Payment Successful! Order placed via UPI.";
                } else {
                    successMessage = "✅ Order placed successfully with Cash On Delivery!";
                }
                
                response.getWriter().println(
                    "<script>"
                    + "alert('" + successMessage + "');"
                    + "window.location='OrderConfirmation.jsp?orderId=" + orderId
                    + "&fullName=" + (fullName != null ? fullName : user.getName())
                    + "&phone=" + (phone != null ? phone : user.getPhoneNumber())
                    + "&house=" + (house != null ? house : "")
                    + "&area=" + (area != null ? area : "")
                    + "&city=" + (city != null ? city : "")
                    + "&state=" + (state != null ? state : "")
                    + "&pincode=" + (pincode != null ? pincode : "")
                    + "';"
                    + "</script>"
                );
            } else {
                response.getWriter().println(
                    "<script>alert('Failed to place order. Please try again.');window.location='viewcart.jsp';</script>"
                );
            }

        } catch(Exception e){
            e.printStackTrace();
            response.getWriter().println(
                "<script>alert('Error placing order: " + e.getMessage().replace("'", "\\'") + "');window.location='viewcart.jsp';</script>"
            );
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}