package com.myntra.controller;

import com.myntra.model.CartItem;
import com.myntra.model.Order;
import com.myntra.model.User;
import com.myntra.service.CartService;
import com.myntra.service.OrderService;
import com.myntra.serviceImpl.CartServiceImpl;
import com.myntra.serviceImpl.OrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/CheckoutController")
public class CheckoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CartService cartService = new CartServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            response.sendRedirect("login.jsp?error=Session timed out. Please login.");
            return;
        }

        // Fetch user's persistent cart items
        List<CartItem> items = cartService.getUserCart(user.getUserId());
        if (items.isEmpty()) {
            response.sendRedirect("viewCart.jsp?error=Your shopping bag is empty!");
            return;
        }

        // Compute transaction total amount
        double grandTotal = 0.0;
        for (CartItem item : items) {
            grandTotal += item.getProduct().getPrice() * item.getQuantity();
        }

        // Capture payment metadata details
        String cardHolderName = request.getParameter("cardName");
        String alternativeAddress = request.getParameter("address");
        String alternativePhone = request.getParameter("phone");

        // Construct complete Order entity
        Order order = new Order();
        order.setUserId(user.getUserId());
        order.setTotalAmount(grandTotal);
        order.setCardHolderName(cardHolderName);
        order.setShippingAddress(alternativeAddress);
        order.setPhoneNumber(alternativePhone);

        // Execute processing transaction
        int orderId = orderService.placeNewOrder(order, items);

        if (orderId > 0) {
            // Success: Pass the tracking ID forward to the final summary invoice view
            response.sendRedirect("orderConfirmation.jsp?orderId=" + orderId);
        } else {
            response.sendRedirect("checkout.jsp?error=Payment Gateway Failure. Transaction Aborted.");
        }
    }
}