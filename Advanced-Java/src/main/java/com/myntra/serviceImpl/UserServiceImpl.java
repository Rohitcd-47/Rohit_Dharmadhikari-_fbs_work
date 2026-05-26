package com.myntra.serviceImpl;
import com.myntra.dao.UserDAO;
import com.myntra.daoImpl.UserDAOImpl;
import com.myntra.model.User;
import com.myntra.service.UserService;
import java.sql.SQLException;

public class UserServiceImpl implements UserService 
{
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean register(User user) {
        try {
            // Business Rule: Check if fields aren't completely empty lines
            if(user.getEmail().trim().isEmpty() || user.getPassword().trim().isEmpty()) {
                return false;
            }
            return userDAO.registerUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User login(String email, String password, String role) {
        try {
            return userDAO.loginUser(email, password, role);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}