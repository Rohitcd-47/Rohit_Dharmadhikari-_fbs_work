package com.myntra.daoImpl;

import com.myntra.dao.CartDAO;
import com.myntra.model.CartItem;
import com.myntra.model.Product;
import com.myntra.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl implements CartDAO {

    @Override
    public boolean addToCart(int userId, int productId, int quantity) throws SQLException {
        // First check: Does this product already exist inside this user's persistent cart?
        String checkQuery = "SELECT cart_id, quantity FROM cart WHERE user_id = ? AND product_id = ?";
        try (Connection conn = DBConnection.getConnection()) {
            try (PreparedStatement psCheck = conn.prepareStatement(checkQuery)) {
                psCheck.setInt(1, userId);
                psCheck.setInt(2, productId);
                try (ResultSet rs = psCheck.executeQuery()) {
                    if (rs.next()) {
                        // If it exists, gracefully increment the quantity rather than creating a messy duplicate row
                        int existingQty = rs.getInt("quantity");
                        String updateQuery = "UPDATE cart SET quantity = ? WHERE cart_id = ?";
                        try (PreparedStatement psUpdate = conn.prepareStatement(updateQuery)) {
                            psUpdate.setInt(1, existingQty + quantity);
                            psUpdate.setInt(2, rs.getInt("cart_id"));
                            return psUpdate.executeUpdate() > 0;
                        }
                    }
                }
            }
            
            // Item is new to the cart, run standard insert script
            String insertQuery = "INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, ?)";
            try (PreparedStatement psInsert = conn.prepareStatement(insertQuery)) {
                psInsert.setInt(1, userId);
                psInsert.setInt(2, productId);
                psInsert.setInt(3, quantity);
                return psInsert.executeUpdate() > 0;
            }
        }
    }

    @Override
    public List<CartItem> getCartByUser(int userId) throws SQLException {
        List<CartItem> cartList = new ArrayList<>();
        // SQL Join operation matching cart item entries directly with product catalog info
        String query = "SELECT c.cart_id, c.user_id, c.quantity, p.product_id, p.name, p.description, p.price, p.category, p.stock_quantity, p.image_path " +
                       "FROM cart c JOIN products p ON c.product_id = p.product_id WHERE c.user_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product prod = new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("category"),
                        rs.getInt("stock_quantity"),
                        rs.getNString("image_path")
                    );
                    
                    cartList.add(new CartItem(
                        rs.getInt("cart_id"),
                        rs.getInt("user_id"),
                        prod,
                        rs.getInt("quantity")
                    ));
                }
            }
        }
        return cartList;
    }

    @Override
    public boolean removeFromCart(int cartId) throws SQLException {
        String query = "DELETE FROM cart WHERE cart_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, cartId);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateCartQuantity(int cartId, int quantity) throws SQLException {
        String query = "UPDATE cart SET quantity = ? WHERE cart_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, quantity);
            ps.setInt(2, cartId);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean clearCart(int userId) throws SQLException {
        String query = "DELETE FROM cart WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, userId);
            return ps.executeUpdate() > 0;
        }
    }
}