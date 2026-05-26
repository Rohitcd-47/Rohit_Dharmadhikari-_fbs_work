package com.myntra.controller;

import com.myntra.service.OrderService;
import com.myntra.serviceImpl.OrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        System.out.println("OrderController called with action: " + action); // Debug log
        
        if ("cancelOrderItem".equals(action)) {
            String orderIdParam = request.getParameter("orderId");
            String orderItemIdParam = request.getParameter("orderItemId");
            
            System.out.println("Cancel Item Request - OrderId: " + orderIdParam + ", OrderItemId: " + orderItemIdParam);
            
            if (orderIdParam != null && orderItemIdParam != null) {
                try {
                    int orderId = Integer.parseInt(orderIdParam);
                    int orderItemId = Integer.parseInt(orderItemIdParam);
                    boolean success = orderService.cancelOrderItem(orderId, orderItemId);
                    
                    if (success) {
                        out.print("{\"success\": true, \"message\": \"Item cancelled successfully\"}");
                    } else {
                        out.print("{\"success\": false, \"message\": \"Item could not be cancelled. It may already be cancelled.\"}");
                    }
                } catch (NumberFormatException e) {
                    out.print("{\"success\": false, \"message\": \"Invalid order ID or item ID\"}");
                }
            } else {
                out.print("{\"success\": false, \"message\": \"Missing orderId or orderItemId parameter\"}");
            }
        } else if ("cancelOrder".equals(action)) {
            String orderIdParam = request.getParameter("orderId");
            
            if (orderIdParam != null) {
                try {
                    int orderId = Integer.parseInt(orderIdParam);
                    boolean success = orderService.cancelOrder(orderId);
                    
                    if (success) {
                        out.print("{\"success\": true, \"message\": \"Order cancelled successfully\"}");
                    } else {
                        out.print("{\"success\": false, \"message\": \"Order could not be cancelled\"}");
                    }
                } catch (NumberFormatException e) {
                    out.print("{\"success\": false, \"message\": \"Invalid order ID\"}");
                }
            } else {
                out.print("{\"success\": false, \"message\": \"Missing orderId parameter\"}");
            }
        } else {
            System.out.println("Unknown action: " + action);
            out.print("{\"success\": false, \"message\": \"Invalid action: " + (action != null ? action : "null") + "\"}");
        }
        out.flush();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}