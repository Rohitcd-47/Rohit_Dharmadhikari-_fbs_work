package com.myntra.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.myntra.model.User;
import com.myntra.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/UpiPaymentController")
public class UpiPaymentController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String upiPin = request.getParameter("upiPin");

        // Validate PIN
        if (upiPin == null || !(upiPin.matches("\\d{4}") || upiPin.matches("\\d{6}"))) {
            response.sendRedirect("upiPayment.jsp?error=Invalid UPI PIN");
            return;
        }

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement checkStmt = con.prepareStatement("SELECT * FROM upi_payment WHERE user_id=?");
            checkStmt.setInt(1, user.getUserId());
            ResultSet rs = checkStmt.executeQuery();

            boolean paymentSuccess = false;

            if (rs.next()) {
                String dbPin = rs.getString("upi_pin");
                if (dbPin.equals(upiPin)) {
                    paymentSuccess = true;
                } else {
                    response.sendRedirect("upiPayment.jsp?error=Incorrect UPI PIN");
                    return;
                }
            } else {
                PreparedStatement insertStmt = con.prepareStatement(
                        "INSERT INTO upi_payment(user_id, upi_pin) VALUES(?,?)");
                insertStmt.setInt(1, user.getUserId());
                insertStmt.setString(2, upiPin);
                insertStmt.executeUpdate();
                paymentSuccess = true;
            }

            rs.close();
            checkStmt.close();
            con.close();

            // SUCCESS → GO TO ADDRESS PAGE with payment method parameter
            if (paymentSuccess) {
                // Send parameter to identify this is from UPI payment
                response.sendRedirect("address.jsp?method=UPI");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("upiPayment.jsp?error=Something went wrong");
        }
    }
}