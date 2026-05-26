package com.myntra.service;

import com.myntra.model.CartItem;
import java.util.List;

public interface CartService 
{
    boolean addItem(int userId, int productId, int quantity);
    List<CartItem> getUserCart(int userId);
    boolean removeItem(int cartId);
    boolean updateItemQuantity(int cartId, int quantity);
    boolean emptyCart(int userId);
	boolean clearCart(int userId);
}