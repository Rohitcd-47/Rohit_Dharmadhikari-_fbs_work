<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="com.myntra.model.User"%>

<%
User user = (User) session.getAttribute("currentUser");
if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
String paymentMethod = request.getParameter("method");
if(paymentMethod == null) paymentMethod = "COD";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Myntra Clone - Delivery Address</title>
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
    max-width: 520px;
    background: white;
    border-radius: 28px;
    padding: 40px;
    box-shadow: 0 8px 28px rgba(0, 0, 0, 0.08);
}

h1 {
    text-align: center;
    font-size: 28px;
    font-weight: 590;
    letter-spacing: -0.3px;
    margin-bottom: 8px;
    color: #1d1d1f;
}

.sub {
    text-align: center;
    color: #6e6e73;
    margin-bottom: 28px;
    font-size: 15px;
}

.payment-badge {
    text-align: center;
    padding: 12px;
    border-radius: 980px;
    margin-bottom: 28px;
    font-weight: 500;
    font-size: 14px;
}

.upi-badge {
    background: #ecfdf5;
    color: #059669;
}

.cod-badge {
    background: #fef3c7;
    color: #d97706;
}

.form-group {
    margin-bottom: 20px;
}

label {
    display: block;
    margin-bottom: 6px;
    font-weight: 500;
    font-size: 14px;
    color: #6e6e73;
}

input {
    width: 100%;
    padding: 14px 16px;
    border: 0.5px solid #d2d2d6;
    border-radius: 14px;
    font-size: 15px;
    font-family: inherit;
    transition: all 0.2s ease;
}

input:focus {
    outline: none;
    border-color: #0071e3;
    box-shadow: 0 0 0 4px rgba(0, 113, 227, 0.1);
}

.btn {
    width: 100%;
    padding: 14px 24px;
    border: none;
    background: #0071e3;
    color: white;
    border-radius: 980px;
    cursor: pointer;
    font-size: 16px;
    font-weight: 500;
    margin-top: 8px;
    transition: all 0.2s ease;
}

.btn:hover {
    background: #0077ed;
    transform: scale(0.98);
}

@media (max-width: 480px) {
    .card {
        padding: 28px 24px;
    }
}
</style>
</head>
<body>

<div class="container">
    <div class="card">
        <h1>Delivery Address</h1>
        <div class="sub">Enter your shipping details</div>
        
        <div class="payment-badge <%= paymentMethod.equals("UPI") ? "upi-badge" : "cod-badge" %>">
            <% if(paymentMethod.equals("UPI")) { %>
                💳 Paying via UPI
            <% } else { %>
                💵 Paying via Cash on Delivery
            <% } %>
        </div>

        <form action="CODController" method="POST">
            <input type="hidden" name="paymentMethod" value="<%= paymentMethod %>">
            <div class="form-group">
                <label>Full Name</label>
                <input type="text" name="fullName" required pattern="[A-Za-z ]{3,50}" placeholder="Enter full name">
            </div>
            <div class="form-group">
                <label>Phone Number</label>
                <input type="text" name="phone" required maxlength="10" pattern="[6-9]{1}[0-9]{9}" placeholder="10-digit mobile number">
            </div>
            <div class="form-group">
                <label>House / Flat No.</label>
                <input type="text" name="house" required placeholder="Flat No / House No">
            </div>
            <div class="form-group">
                <label>Area / Street</label>
                <input type="text" name="area" required placeholder="Area or street">
            </div>
            <div class="form-group">
                <label>City</label>
                <input type="text" name="city" required pattern="[A-Za-z ]{2,30}" placeholder="City">
            </div>
            <div class="form-group">
                <label>State</label>
                <input type="text" name="state" required pattern="[A-Za-z ]{2,30}" placeholder="State">
            </div>
            <div class="form-group">
                <label>Pincode</label>
                <input type="text" maxlength="6" pattern="[0-9]{6}" name="pincode" required placeholder="6-digit pincode">
            </div>
            <button type="submit" class="btn">Place Order →</button>
        </form>
    </div>
</div>
</body>
</html>