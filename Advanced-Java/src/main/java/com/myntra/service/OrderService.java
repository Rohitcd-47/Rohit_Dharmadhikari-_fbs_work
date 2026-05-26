package com.myntra.service;

import com.myntra.model.CartItem;
import com.myntra.model.Order;
import com.myntra.model.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    int placeNewOrder(Order order, List<CartItem> cartItems);
    List<OrderItem> getItemsForOrder(int orderId);
    List<Order> getOrdersByUserId(int userId);
    boolean cancelOrder(int orderId);
    boolean cancelOrderItem(int orderId, int orderItemId);  // ADD THIS
    List<OrderItem> getOrderItemsWithProducts(int orderId);
 // Add to OrderService interface
    List<Order> getAllOrdersWithUserDetails() throws SQLException;
}