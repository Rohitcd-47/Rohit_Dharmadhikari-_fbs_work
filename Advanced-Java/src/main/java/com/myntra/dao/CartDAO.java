package com.myntra.dao;

import com.myntra.model.CartItem;
import java.sql.SQLException;
import java.util.List;

public interface CartDAO 
{
    boolean addToCart(int userId, int productId, int quantity) throws SQLException;
    List<CartItem> getCartByUser(int userId) throws SQLException;
    boolean removeFromCart(int cartId) throws SQLException;
    boolean updateCartQuantity(int cartId, int quantity) throws SQLException;
    boolean clearCart(int userId) throws SQLException;
}