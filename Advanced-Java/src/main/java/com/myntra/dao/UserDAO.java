package com.myntra.dao;

import com.myntra.model.User;
import java.sql.SQLException;

public interface UserDAO 
{
    boolean registerUser(User user) throws SQLException;
    User loginUser(String email, String password, String role) throws SQLException;
}