package com.myntra.serviceImpl;

import com.myntra.dao.OrderDAO;
import com.myntra.daoImpl.OrderDAOImpl;
import com.myntra.model.CartItem;
import com.myntra.model.Order;
import com.myntra.model.OrderItem;
import com.myntra.service.OrderService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public int placeNewOrder(Order order, List<CartItem> cartItems) {
        try {
            if (cartItems == null || cartItems.isEmpty()) return -1;
            return orderDAO.placeOrder(order, cartItems);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<OrderItem> getItemsForOrder(int orderId) {
        try {
            return orderDAO.getOrderItemsByOrderId(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        try {
            return orderDAO.getOrdersByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean cancelOrder(int orderId) {
        try {
            return orderDAO.cancelOrder(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean cancelOrderItem(int orderId, int orderItemId) {
        try {
            return orderDAO.cancelOrderItem(orderId, orderItemId);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<OrderItem> getOrderItemsWithProducts(int orderId) {
        try {
            return orderDAO.getOrderItemsWithProducts(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    @Override
    public List<Order> getAllOrdersWithUserDetails() throws SQLException {
        try {
            return orderDAO.getAllOrdersWithUserDetails();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}