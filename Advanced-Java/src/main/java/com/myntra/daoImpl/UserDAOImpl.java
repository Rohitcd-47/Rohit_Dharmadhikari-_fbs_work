package com.myntra.daoImpl;

import com.myntra.dao.UserDAO;
import com.myntra.model.User;
import com.myntra.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO 
{

	@Override
	public boolean registerUser(User user) {

	    String query =
	    "INSERT INTO users (name, email, password, role, phone_number, shipping_address) VALUES (?, ?, ?, ?, ?, ?)";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {

	        ps.setString(1, user.getName());
	        ps.setString(2, user.getEmail());
	        ps.setString(3, user.getPassword());
	        ps.setString(4, user.getRole());
	        ps.setString(5, user.getPhoneNumber());
	        ps.setString(6, user.getShippingAddress());

	        return ps.executeUpdate() > 0;

	    } catch (SQLException e) {

	        if(e.getMessage().contains("Duplicate entry")) {
	            System.out.println("Email already exists!");
	        } else {
	            e.printStackTrace();
	        }

	        return false;
	    }
	}

    @Override
    public User loginUser(String email, String password, String role) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ? AND password = ? AND role = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, role);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("phone_number"),
                        rs.getString("shipping_address")
                    );
                }
            }
        }
        return null; // Return null if user matching criteria isn't found
    }
}