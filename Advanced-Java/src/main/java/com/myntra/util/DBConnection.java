package com.myntra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
    private static final String URL = "jdbc:mysql://localhost:3306/myntra_db";
    private static final String USERNAME = "root"; 
    private static final String PASSWORD = "fbs31"; 

    static 
    {
        try {
            // Explicitly load the MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found! Ensure the JAR is in src/main/webapp/WEB-INF/lib/");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}