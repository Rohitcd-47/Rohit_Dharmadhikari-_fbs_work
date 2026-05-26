package com.myntra.dao;

import com.myntra.model.CartItem;
import com.myntra.model.Order;
import com.myntra.model.OrderItem;
import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    
    // Place a new order with all cart items
    int placeOrder(Order order, List<CartItem> cartItems) throws SQLException;
    
    // Get all order items for a specific order (without product details)
    List<OrderItem> getOrderItemsByOrderId(int orderId) throws SQLException;
    
    // Get all orders for a specific user
    List<Order> getOrdersByUserId(int userId) throws SQLException;
    
    // Cancel an entire order
    boolean cancelOrder(int orderId) throws SQLException;
    
    // Cancel a single item from an order
    boolean cancelOrderItem(int orderId, int orderItemId) throws SQLException;
    
    // Get order items with full product details (including images)
    List<OrderItem> getOrderItemsWithProducts(int orderId) throws SQLException;
    
    // Get a single order by ID
    Order getOrderById(int orderId) throws SQLException;
    
    // Update order status
    boolean updateOrderStatus(int orderId, String status) throws SQLException;
    
 // Add this method to your existing OrderDAO interface
    List<Order> getAllOrdersWithUserDetails() throws SQLException;
}