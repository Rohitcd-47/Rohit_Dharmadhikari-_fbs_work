package com.myntra.serviceImpl;

import com.myntra.dao.CartDAO;
import com.myntra.daoImpl.CartDAOImpl;
import com.myntra.model.CartItem;
import com.myntra.service.CartService;
import com.myntra.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDAO cartDAO = new CartDAOImpl();

    @Override
    public boolean addItem(int userId, int productId, int quantity) {
        try {
            return cartDAO.addToCart(userId, productId, quantity);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CartItem> getUserCart(int userId) {
        try {
            return cartDAO.getCartByUser(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean removeItem(int cartId) {
        try {
            return cartDAO.removeFromCart(cartId);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateItemQuantity(int cartId, int quantity) {
        try {
            return cartDAO.updateCartQuantity(cartId, quantity);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean emptyCart(int userId) {
        try {
            return cartDAO.clearCart(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean clearCart(int userId) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM cart WHERE user_id = ?");
            stmt.setInt(1, userId);
            int result = stmt.executeUpdate();
            return result > 0;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}