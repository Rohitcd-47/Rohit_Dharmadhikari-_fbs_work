package com.myntra.controller;

import com.myntra.model.User;
import com.myntra.service.UserService;
import com.myntra.serviceImpl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/AuthController")
public class AuthController extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String role = request.getParameter("role");

            User user = userService.login(email, password, role);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", user);
                session.setAttribute("userName", user.getName());
                session.setAttribute("userRole", user.getRole());

                if ("Admin".equals(user.getRole())) {
                    response.sendRedirect("adminDashboard.jsp");
                } else {
                    response.sendRedirect("home.jsp");
                }
            } else {
                request.setAttribute("error", "Invalid credentials or chosen role.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } else if ("register".equals(action)) {
            User user = new User();
            user.setName(request.getParameter("name"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setPhoneNumber(request.getParameter("phone"));
            user.setShippingAddress(request.getParameter("address"));
            user.setRole(request.getParameter("role"));

            boolean isRegistered = userService.register(user);

            if (isRegistered) {
                request.setAttribute("error", "Registration successful! Please login.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Registration failed. Email might already exist.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } else if ("logout".equals(action)) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect("login.jsp?error=Successfully logged out.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}