<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="com.myntra.model.User"%>

<%
User user = (User) session.getAttribute("currentUser");
if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Myntra Clone - UPI Payment</title>
<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: -apple-system, 'SF Pro Text', 'Helvetica Neue', sans-serif;
    background: #f5f5f7;
}

.container {
    width: 100%;
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 20px;
}

.card {
    width: 100%;
    max-width: 440px;
    background: white;
    border-radius: 32px;
    padding: 44px 40px;
    box-shadow: 0 12px 32px rgba(0, 0, 0, 0.08);
}

.logo {
    font-size: 56px;
    text-align: center;
    margin-bottom: 16px;
}

.title {
    text-align: center;
    font-size: 28px;
    font-weight: 590;
    letter-spacing: -0.3px;
    margin-bottom: 8px;
    color: #1d1d1f;
}

.subtitle {
    text-align: center;
    color: #6e6e73;
    margin-bottom: 32px;
    font-size: 15px;
}

.form-group {
    margin-bottom: 28px;
}

label {
    display: block;
    margin-bottom: 8px;
    font-size: 14px;
    font-weight: 500;
    color: #6e6e73;
}

input {
    width: 100%;
    padding: 14px 16px;
    border: 0.5px solid #d2d2d6;
    border-radius: 14px;
    font-size: 18px;
    font-family: inherit;
    text-align: center;
    letter-spacing: 4px;
}

input:focus {
    outline: none;
    border-color: #0071e3;
    box-shadow: 0 0 0 4px rgba(0, 113, 227, 0.1);
}

.btn {
    width: 100%;
    border: none;
    background: #0071e3;
    color: white;
    padding: 14px 24px;
    border-radius: 980px;
    font-size: 16px;
    font-weight: 500;
    cursor: pointer;
    transition: all 0.2s ease;
}

.btn:hover {
    background: #0077ed;
    transform: scale(0.98);
}

.error {
    background: #fef2f2;
    border: 0.5px solid #fecaca;
    color: #dc2626;
    padding: 14px 18px;
    border-radius: 14px;
    margin-bottom: 24px;
    font-size: 14px;
    text-align: center;
}

@media (max-width: 480px) {
    .card {
        padding: 32px 24px;
    }
}
</style>
</head>
<body>

<div class="container">
    <div class="card">
        <div class="logo">📱</div>
        <div class="title">UPI Payment</div>
        <div class="subtitle">Enter your secure UPI PIN</div>

        <% if(request.getParameter("error") != null){ %>
            <div class="error"><%= request.getParameter("error") %></div>
        <% } %>

        <form action="UpiPaymentController" method="POST">
            <div class="form-group">
                <label>UPI PIN</label>
                <input type="password" name="upiPin" required maxlength="6" pattern="^([0-9]{4}|[0-9]{6})$" placeholder="••••••">
            </div>
            <button type="submit" class="btn">Verify & Pay →</button>
        </form>
    </div>
</div>

</body>
</html>