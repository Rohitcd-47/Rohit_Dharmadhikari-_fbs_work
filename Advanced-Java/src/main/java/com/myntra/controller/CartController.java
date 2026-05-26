package com.myntra.controller;

import com.myntra.model.User;
import com.myntra.service.CartService;
import com.myntra.serviceImpl.CartServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/CartController")
public class CartController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CartService cartService = new CartServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        
        // Error Prevention Guard: Verify the session identity token exists
        if (currentUser == null) {
            response.sendRedirect("login.jsp?error=Session expired. Please re-authenticate.");
            return;
        }

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            // Default increment setting to one single unique item per click action
            boolean success = cartService.addItem(currentUser.getUserId(), productId, 1);
            
            if (success) {
                response.sendRedirect("home.jsp?msg=Item safely added to your bag!");
            } else {
                response.sendRedirect("home.jsp?error=Inventory tracking fault. Try again.");
            }
            
        } else if ("remove".equals(action)) {
            int cartId = Integer.parseInt(request.getParameter("cartId"));
            boolean success = cartService.removeItem(cartId);
            
            if (success) {
                response.sendRedirect("viewcart.jsp?msg=Item removed from bag.");
            } else {
                response.sendRedirect("viewcart.jsp?error=Could not process removal.");
            }
        } else if ("updateQty".equals(action)) {
            int cartId = Integer.parseInt(request.getParameter("cartId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if (quantity < 1) {
                response.sendRedirect("viewcart.jsp?error=Quantity must be at least 1.");
                return;
            }
            boolean success = cartService.updateItemQuantity(cartId, quantity);
            
            if (success) {
                response.sendRedirect("viewcart.jsp?msg=Quantity updated.");
            } else {
                response.sendRedirect("viewcart.jsp?error=Could not update quantity.");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward get actions straight to Post router context uniformly
        doPost(request, response);
    }
}