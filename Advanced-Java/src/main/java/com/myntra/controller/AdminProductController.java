package com.myntra.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myntra.model.Order;
import com.myntra.model.OrderItem;
import com.myntra.model.Product;
import com.myntra.model.User;
import com.myntra.service.OrderService;
import com.myntra.service.ProductService;
import com.myntra.serviceImpl.OrderServiceImpl;
import com.myntra.serviceImpl.ProductServiceImpl;
import com.myntra.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminProductController")
public class AdminProductController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductService productService = new ProductServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        // Handle actions
        if ("add".equals(action)) {
            addProduct(request, response);
        } else if ("update".equals(action)) {
            updateProduct(request, response);
        } else if ("delete".equals(action)) {
            deleteProduct(request, response);
        } else {
            response.sendRedirect("adminDashboard.jsp?error=Invalid Action");
        }
    }
    
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        // Handle GET requests (like viewAllOrders)
        if ("viewAllOrders".equals(action)) {
            viewAllOrders(request, response);
        } else {
            response.sendRedirect("adminDashboard.jsp");
        }
    }
    
    // =========================
    // ADD PRODUCT
    // =========================
    private void addProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Product product = new Product();
            product.setName(request.getParameter("name"));
            product.setDescription(request.getParameter("description"));
            product.setPrice(Double.parseDouble(request.getParameter("price")));
            product.setCategory(request.getParameter("category"));
            product.setStockQuantity(Integer.parseInt(request.getParameter("stock")));
            product.setImagePath(request.getParameter("imagePath"));

            boolean success = productService.addProduct(product);

            if (success) {
                response.sendRedirect("adminDashboard.jsp?msg=Product Added Successfully");
            } else {
                response.sendRedirect("adminDashboard.jsp?error=Failed to Add Product");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("adminDashboard.jsp?error=Error: " + e.getMessage());
        }
    }
    
    // =========================
    // UPDATE PRODUCT
    // =========================
    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Product product = new Product();
            product.setProductId(Integer.parseInt(request.getParameter("productId")));
            product.setName(request.getParameter("name"));
            product.setDescription(request.getParameter("description"));
            product.setPrice(Double.parseDouble(request.getParameter("price")));
            product.setCategory(request.getParameter("category"));
            product.setStockQuantity(Integer.parseInt(request.getParameter("stock")));
            product.setImagePath(request.getParameter("imagePath"));

            boolean success = productService.updateProduct(product);

            if (success) {
                response.sendRedirect("adminDashboard.jsp?msg=Product Updated Successfully");
            } else {
                response.sendRedirect("adminDashboard.jsp?error=Failed To Update Product");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("adminDashboard.jsp?error=Error: " + e.getMessage());
        }
    }
    
    // =========================
    // DELETE PRODUCT
    // =========================
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            boolean success = productService.deleteProduct(productId);

            if (success) {
                response.sendRedirect("adminDashboard.jsp?msg=Product Deleted Successfully");
            } else {
                response.sendRedirect("adminDashboard.jsp?error=Failed To Delete Product");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("adminDashboard.jsp?error=Error: " + e.getMessage());
        }
    }
    
    // =========================
    // VIEW ALL ORDERS (NEW FEATURE)
    // =========================
    private void viewAllOrders(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        
        // Check if admin is logged in
        if (user == null) {
            response.sendRedirect("login.jsp?error=Please login first");
            return;
        }
        
        try {
            // Get all orders with user details
            List<Order> allOrders = orderService.getAllOrdersWithUserDetails();
            
            if (allOrders == null) {
                allOrders = new java.util.ArrayList<>();
            }
            
            // Get order items for each order
            Map<Integer, List<OrderItem>> orderItemsMap = new HashMap<>();
            Map<Integer, String> userNamesMap = new HashMap<>();
            Map<Integer, String> userEmailsMap = new HashMap<>();
            
            for (Order order : allOrders) {
                try {
                    // Get order items with product details
                    List<OrderItem> items = orderService.getOrderItemsWithProducts(order.getOrderId());
                    if (items == null) items = new java.util.ArrayList<>();
                    orderItemsMap.put(order.getOrderId(), items);
                    
                    // Get user details
                    getUserDetails(order.getUserId(), userNamesMap, userEmailsMap);
                } catch (Exception e) {
                    System.err.println("Error processing order " + order.getOrderId() + ": " + e.getMessage());
                }
            }
            
            request.setAttribute("allOrders", allOrders);
            request.setAttribute("orderItemsMap", orderItemsMap);
            request.setAttribute("userNamesMap", userNamesMap);
            request.setAttribute("userEmailsMap", userEmailsMap);
            
            request.getRequestDispatcher("adminOrders.jsp").forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("adminDashboard.jsp?error=Failed to load orders: " + e.getMessage());
        }
    }
    
    // =========================
    // GET USER DETAILS HELPER METHOD
    // =========================
    private void getUserDetails(int userId, Map<Integer, String> names, Map<Integer, String> emails) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        java.sql.ResultSet rs = null;
        
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT name, email FROM users WHERE user_id = ?");
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                names.put(userId, rs.getString("name"));
                emails.put(userId, rs.getString("email"));
            } else {
                names.put(userId, "Unknown User");
                emails.put(userId, "No email");
            }
        } catch (Exception e) {
            System.err.println("Error fetching user details for ID " + userId + ": " + e.getMessage());
            names.put(userId, "Error loading");
            emails.put(userId, "Error loading");
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}