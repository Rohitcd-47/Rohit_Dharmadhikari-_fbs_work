package com.myntra.daoImpl;

import com.myntra.dao.OrderDAO;
import com.myntra.model.CartItem;
import com.myntra.model.Order;
import com.myntra.model.OrderItem;
import com.myntra.model.Product;
import com.myntra.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public int placeOrder(Order order, List<CartItem> cartItems) throws SQLException {
        Connection conn = null;
        PreparedStatement orderStmt = null;
        PreparedStatement itemStmt = null;
        ResultSet generatedKeys = null;
        int orderId = -1;
        
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); // Start transaction
            
            // 1. Insert into orders table
            String orderQuery = "INSERT INTO orders (user_id, total_amount, card_holder_name, shipping_address, phone_number, status, order_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
            orderStmt = conn.prepareStatement(orderQuery, Statement.RETURN_GENERATED_KEYS);
            orderStmt.setInt(1, order.getUserId());
            orderStmt.setDouble(2, order.getTotalAmount());
            orderStmt.setString(3, order.getCardHolderName());
            orderStmt.setString(4, order.getShippingAddress());
            orderStmt.setString(5, order.getPhoneNumber());
            orderStmt.setString(6, order.getStatus() != null ? order.getStatus() : "Pending");
            orderStmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            
            int affectedRows = orderStmt.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Creating order failed, no rows affected.");
            }
            
            generatedKeys = orderStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                orderId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Creating order failed, no ID obtained.");
            }
            
            // 2. Insert into order_items table
            String itemQuery = "INSERT INTO order_items (order_id, product_id, quantity, price_at_purchase, is_cancelled) VALUES (?, ?, ?, ?, 0)";
            itemStmt = conn.prepareStatement(itemQuery);
            
            for (CartItem cartItem : cartItems) {
                itemStmt.setInt(1, orderId);
                itemStmt.setInt(2, cartItem.getProduct().getProductId());
                itemStmt.setInt(3, cartItem.getQuantity());
                itemStmt.setDouble(4, cartItem.getProduct().getPrice());
                itemStmt.addBatch();
            }
            
            itemStmt.executeBatch();
            
            // 3. Update product stock quantities (optional - implement if needed)
            String updateStockQuery = "UPDATE products SET stock_quantity = stock_quantity - ? WHERE product_id = ?";
            PreparedStatement stockStmt = conn.prepareStatement(updateStockQuery);
            for (CartItem cartItem : cartItems) {
                stockStmt.setInt(1, cartItem.getQuantity());
                stockStmt.setInt(2, cartItem.getProduct().getProductId());
                stockStmt.addBatch();
            }
            stockStmt.executeBatch();
            stockStmt.close();
            
            conn.commit(); // Commit transaction
            return orderId;
            
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            throw e;
        } finally {
            if (generatedKeys != null) generatedKeys.close();
            if (orderStmt != null) orderStmt.close();
            if (itemStmt != null) itemStmt.close();
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) throws SQLException {
        List<OrderItem> orderItems = new ArrayList<>();
        String query = "SELECT * FROM order_items WHERE order_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                OrderItem item = new OrderItem();
                item.setOrderItemId(rs.getInt("order_item_id"));
                item.setOrderId(rs.getInt("order_id"));
                item.setProductId(rs.getInt("product_id"));
                item.setQuantity(rs.getInt("quantity"));
                item.setPriceAtPurchase(rs.getDouble("price_at_purchase"));
                try {
                    item.setCancelled(rs.getBoolean("is_cancelled"));
                } catch (SQLException e) {
                    item.setCancelled(false);
                }
                orderItems.add(item);
            }
        }
        return orderItems;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders WHERE user_id = ? ORDER BY order_date DESC";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("order_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setOrderDate(rs.getTimestamp("order_date"));
                order.setCardHolderName(rs.getString("card_holder_name"));
                order.setShippingAddress(rs.getString("shipping_address"));
                order.setPhoneNumber(rs.getString("phone_number"));
                try {
                    order.setStatus(rs.getString("status"));
                } catch (SQLException e) {
                    order.setStatus("Pending");
                }
                orders.add(order);
            }
        }
        return orders;
    }

    @Override
    public boolean cancelOrder(int orderId) throws SQLException {
        String query = "UPDATE orders SET status = 'Cancelled' WHERE order_id = ? AND status != 'Cancelled'";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            int rowsAffected = stmt.executeUpdate();
            
            // Also mark all items as cancelled
            if (rowsAffected > 0) {
                String updateItemsQuery = "UPDATE order_items SET is_cancelled = 1 WHERE order_id = ?";
                try (PreparedStatement itemStmt = conn.prepareStatement(updateItemsQuery)) {
                    itemStmt.setInt(1, orderId);
                    itemStmt.executeUpdate();
                }
            }
            
            return rowsAffected > 0;
        }
    }

    @Override
    public boolean cancelOrderItem(int orderId, int orderItemId) throws SQLException {
        // First check if order is not already fully cancelled
        String checkOrderQuery = "SELECT status FROM orders WHERE order_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkOrderQuery)) {
            checkStmt.setInt(1, orderId);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                String status = rs.getString("status");
                if ("Cancelled".equalsIgnoreCase(status)) {
                    return false; // Order already cancelled, cannot cancel individual items
                }
            }
        }
        
        // Cancel the specific item
        String query = "UPDATE order_items SET is_cancelled = 1 WHERE order_item_id = ? AND order_id = ? AND is_cancelled = 0";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderItemId);
            stmt.setInt(2, orderId);
            int rowsAffected = stmt.executeUpdate();
            
            // Check if all items in this order are now cancelled
            if (rowsAffected > 0) {
                String checkAllCancelledQuery = "SELECT COUNT(*) as total, SUM(is_cancelled) as cancelled FROM order_items WHERE order_id = ?";
                try (PreparedStatement checkStmt = conn.prepareStatement(checkAllCancelledQuery)) {
                    checkStmt.setInt(1, orderId);
                    ResultSet rs = checkStmt.executeQuery();
                    if (rs.next()) {
                        int totalItems = rs.getInt("total");
                        int cancelledItems = rs.getInt("cancelled");
                        if (totalItems == cancelledItems) {
                            // All items are cancelled, update order status
                            String updateOrderQuery = "UPDATE orders SET status = 'Cancelled' WHERE order_id = ?";
                            try (PreparedStatement updateStmt = conn.prepareStatement(updateOrderQuery)) {
                                updateStmt.setInt(1, orderId);
                                updateStmt.executeUpdate();
                            }
                        }
                    }
                }
            }
            
            return rowsAffected > 0;
        }
    }

    @Override
    public List<OrderItem> getOrderItemsWithProducts(int orderId) throws SQLException {
        List<OrderItem> orderItems = new ArrayList<>();
        String query = "SELECT oi.order_item_id, oi.order_id, oi.product_id, oi.quantity, oi.price_at_purchase, " +
                       "COALESCE(oi.is_cancelled, 0) as is_cancelled, " +
                       "p.name, p.image_path, p.price, p.description, p.category " +
                       "FROM order_items oi " +
                       "JOIN products p ON oi.product_id = p.product_id " +
                       "WHERE oi.order_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                OrderItem item = new OrderItem();
                item.setOrderItemId(rs.getInt("order_item_id"));
                item.setOrderId(rs.getInt("order_id"));
                item.setProductId(rs.getInt("product_id"));
                item.setQuantity(rs.getInt("quantity"));
                item.setPriceAtPurchase(rs.getDouble("price_at_purchase"));
                item.setCancelled(rs.getBoolean("is_cancelled"));
                
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setImagePath(rs.getString("image_path"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                try {
                    product.setCategory(rs.getString("category"));
                } catch (SQLException e) {
                    product.setCategory("General");
                }
                item.setProduct(product);
                
                orderItems.add(item);
            }
        }
        return orderItems;
    }

    @Override
    public Order getOrderById(int orderId) throws SQLException {
        String query = "SELECT * FROM orders WHERE order_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("order_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setOrderDate(rs.getTimestamp("order_date"));
                order.setCardHolderName(rs.getString("card_holder_name"));
                order.setShippingAddress(rs.getString("shipping_address"));
                order.setPhoneNumber(rs.getString("phone_number"));
                try {
                    order.setStatus(rs.getString("status"));
                } catch (SQLException e) {
                    order.setStatus("Pending");
                }
                return order;
            }
        }
        return null;
    }

    @Override
    public boolean updateOrderStatus(int orderId, String status) throws SQLException {
        String query = "UPDATE orders SET status = ? WHERE order_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setInt(2, orderId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    @Override
    public List<Order> getAllOrdersWithUserDetails() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT o.*, u.name as user_name, u.email as user_email " +
                       "FROM orders o " +
                       "JOIN users u ON o.user_id = u.user_id " +
                       "ORDER BY o.order_date DESC";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("order_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setOrderDate(rs.getTimestamp("order_date"));
                order.setCardHolderName(rs.getString("card_holder_name"));
                order.setShippingAddress(rs.getString("shipping_address"));
                order.setPhoneNumber(rs.getString("phone_number"));
                order.setStatus(rs.getString("status"));
                
                // Set additional user info (you may need to add these fields to Order model)
                // For now, we'll store in request attributes in the servlet
                orders.add(order);
            }
        }
        return orders;
    }
    
    
}