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
<title>Myntra Clone - Payment</title>
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

.wrapper {
    max-width: 900px;
    margin: 60px auto;
    padding: 20px;
}

.heading {
    font-size: 34px;
    font-weight: 600;
    letter-spacing: -0.5px;
    color: #1d1d1f;
    margin-bottom: 8px;
}

.subheading {
    color: #6e6e73;
    margin-bottom: 40px;
    font-size: 17px;
}

.payment-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
    gap: 24px;
}

.card {
    background: white;
    border-radius: 24px;
    padding: 32px 28px;
    border: 0.5px solid #e5e5ea;
    transition: all 0.3s ease;
    text-decoration: none;
    color: inherit;
    display: block;
}

.card:hover {
    transform: translateY(-6px);
    box-shadow: 0 20px 32px -12px rgba(0, 0, 0, 0.12);
    border-color: #0071e3;
}

.icon {
    font-size: 48px;
    margin-bottom: 20px;
}

.title {
    font-size: 20px;
    font-weight: 590;
    margin-bottom: 10px;
    color: #1d1d1f;
}

.desc {
    color: #8e8e93;
    font-size: 14px;
    line-height: 1.4;
}

@media (max-width: 640px) {
    .wrapper {
        margin: 40px auto;
    }
    .heading {
        font-size: 28px;
    }
}
</style>
</head>
<body>

<div class="wrapper">
    <div class="heading">Choose Payment Method</div>
    <div class="subheading">Select your preferred payment option</div>

    <div class="payment-grid">
        <a href="upiPayment.jsp" class="card">
            <div class="icon">📱</div>
            <div class="title">UPI Payment</div>
            <div class="desc">Pay instantly using your UPI app</div>
        </a>

        <a href="Checkout.jsp" class="card">
            <div class="icon">💳</div>
            <div class="title">Card Payment</div>
            <div class="desc">Credit or Debit card payment</div>
        </a>

        <a href="address.jsp" class="card">
            <div class="icon">📦</div>
            <div class="title">Cash on Delivery</div>
            <div class="desc">Pay when you receive your order</div>
        </a>
    </div>
</div>

</body>
</html>	