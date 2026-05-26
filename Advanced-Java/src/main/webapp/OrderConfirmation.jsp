<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="com.myntra.model.User"%>
<%@ page import="java.net.URLDecoder"%>

<%
User user = (User) session.getAttribute("currentUser");
if(user == null){
    response.sendRedirect("login.jsp");
    return;
}

String orderId = request.getParameter("orderId");
String fullName = request.getParameter("fullName");
String phone = request.getParameter("phone");
String house = request.getParameter("house");
String area = request.getParameter("area");
String city = request.getParameter("city");
String state = request.getParameter("state");
String pincode = request.getParameter("pincode");

String address = "";

if(house != null && !house.isEmpty() && house != "null"){
    address = house + ", " + area + ", " + city + ", " + state + " - " + pincode;
} else {
    address = user.getShippingAddress();
    if(fullName == null || fullName.isEmpty()) fullName = user.getName();
    if(phone == null || phone.isEmpty()) phone = user.getPhoneNumber();
}

try {
    address = URLDecoder.decode(address, "UTF-8");
} catch(Exception e) {}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Myntra Clone - Order Confirmed</title>
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
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    padding: 20px;
}

.card {
    background: white;
    width: 100%;
    max-width: 560px;
    padding: 48px 40px;
    border-radius: 28px;
    text-align: center;
    box-shadow: 0 12px 32px rgba(0, 0, 0, 0.08);
}

.icon {
    font-size: 64px;
    margin-bottom: 20px;
}

.title {
    color: #059669;
    font-size: 32px;
    font-weight: 590;
    letter-spacing: -0.3px;
    margin-bottom: 12px;
}

.subtitle {
    font-size: 17px;
    color: #6e6e73;
    margin-bottom: 28px;
}

.order-id-box {
    background: #f5f5f7;
    padding: 14px;
    border-radius: 16px;
    margin-bottom: 24px;
    font-size: 16px;
}

.order-id-box strong {
    color: #0071e3;
    font-weight: 590;
}

.box {
    background: #f5f5f7;
    border-radius: 20px;
    padding: 24px;
    text-align: left;
}

.box h2 {
    font-size: 17px;
    font-weight: 590;
    margin-bottom: 16px;
    color: #1d1d1f;
}

.box p {
    margin-bottom: 12px;
    font-size: 15px;
    color: #1d1d1f;
}

.box p b {
    color: #6e6e73;
    font-weight: 500;
}

.btn {
    display: inline-block;
    margin-top: 28px;
    text-decoration: none;
    background: #0071e3;
    color: white;
    padding: 14px 32px;
    border-radius: 980px;
    font-size: 16px;
    font-weight: 500;
    transition: all 0.2s ease;
}

.btn:hover {
    background: #0077ed;
    transform: scale(0.98);
}

@media (max-width: 480px) {
    .card {
        padding: 32px 24px;
    }
    .title {
        font-size: 28px;
    }
}
</style>
</head>
<body>

<div class="container">
    <div class="card">
        <div class="icon">✅</div>
        <div class="title">Order Placed!</div>
        <div class="subtitle">Thank you for shopping with us, <b><%= fullName != null ? fullName : "" %></b></div>

        <% if(orderId != null && !orderId.isEmpty()) { %>
        <div class="order-id-box">
            🆔 Order #<strong><%= orderId %></strong>
        </div>
        <% } %>

        <div class="box">
            <h2>Delivery Address</h2>
            <p><b>Name:</b> <%= fullName != null ? fullName : "" %></p>
            <p><b>Phone:</b> <%= phone != null ? phone : "" %></p>
            <p><b>Address:</b> <%= address != null ? address : "" %></p>
        </div>

        <a href="home.jsp" class="btn">Continue Shopping →</a>
    </div>
</div>
</body>
</html>