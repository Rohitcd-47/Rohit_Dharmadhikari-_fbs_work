<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myntra.model.User, com.myntra.model.CartItem, com.myntra.service.CartService, com.myntra.serviceImpl.CartServiceImpl, java.util.List" %>

<%
    User user = (User) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("login.jsp?error=Login to access checkout.");
        return;
    }
    CartService cartService = new CartServiceImpl();
    List<CartItem> cartItems = cartService.getUserCart(user.getUserId());
    double checkoutTotal = 0.0;
    for (CartItem item : cartItems) {
        checkoutTotal += item.getProduct().getPrice() * item.getQuantity();
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Myntra Clone - Checkout</title>
<style>
:root {
    --primary: #0071e3;
    --bg: #f5f5f7;
    --surface: #ffffff;
    --text: #1d1d1f;
    --muted: #6e6e73;
    --border: #e5e5ea;
}

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: -apple-system, 'SF Pro Text', 'Helvetica Neue', sans-serif;
    background: var(--bg);
    color: var(--text);
}

.shell {
    max-width: 1200px;
    margin: 0 auto;
    padding: 24px 20px 48px;
}

.topbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    gap: 16px;
    margin-bottom: 32px;
    padding-bottom: 16px;
    border-bottom: 0.5px solid var(--border);
}

.brand {
    font-size: 24px;
    font-weight: 600;
    letter-spacing: -0.3px;
    background: linear-gradient(135deg, #1d1d1f 0%, #3a3a3c 100%);
    -webkit-background-clip: text;
    background-clip: text;
    color: transparent;
}

.back-btn {
    padding: 8px 18px;
    border-radius: 980px;
    font-weight: 500;
    font-size: 14px;
    text-decoration: none;
    color: var(--text);
    border: 0.5px solid var(--border);
    transition: all 0.2s ease;
}

.back-btn:hover {
    background: var(--primary);
    border-color: var(--primary);
    color: white;
}

.layout {
    display: grid;
    grid-template-columns: 1.6fr 0.9fr;
    gap: 28px;
    align-items: start;
}

.panel {
    background: var(--surface);
    border-radius: 24px;
    overflow: hidden;
    box-shadow: 0 2px 12px rgba(0, 0, 0, 0.04);
}

.checkout-panel {
    padding: 28px;
}

.summary-panel {
    padding: 0;
    position: sticky;
    top: 20px;
}

.panel h2 {
    font-size: 24px;
    font-weight: 590;
    margin-bottom: 24px;
}

.section {
    margin-bottom: 32px;
}

.section-title {
    font-size: 17px;
    font-weight: 590;
    margin-bottom: 20px;
    padding-bottom: 10px;
    border-bottom: 0.5px solid var(--border);
}

.form-group {
    margin-bottom: 18px;
}

.form-group label {
    display: block;
    margin-bottom: 6px;
    font-size: 13px;
    font-weight: 500;
    color: var(--muted);
}

.form-group input,
.form-group textarea {
    width: 100%;
    border: 0.5px solid var(--border);
    border-radius: 14px;
    padding: 14px 16px;
    font-size: 15px;
    font-family: inherit;
    background: #fff;
    transition: all 0.2s ease;
}

.form-group input:focus,
.form-group textarea:focus {
    outline: none;
    border-color: var(--primary);
    box-shadow: 0 0 0 4px rgba(0, 113, 227, 0.1);
}

.secure-note {
    display: flex;
    align-items: center;
    gap: 10px;
    background: #ecfdf5;
    color: #059669;
    padding: 12px 16px;
    border-radius: 14px;
    font-size: 13px;
    margin-bottom: 24px;
}

.form-grid {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 16px;
}

.summary-title {
    padding: 20px 24px;
    font-size: 14px;
    font-weight: 500;
    letter-spacing: 0.3px;
    color: var(--muted);
    border-bottom: 0.5px solid var(--border);
}

.order-item {
    display: flex;
    justify-content: space-between;
    padding: 14px 24px;
    border-bottom: 0.5px solid var(--border);
}

.product-name {
    font-weight: 500;
    font-size: 14px;
}

.product-qty {
    font-size: 13px;
    color: var(--muted);
}

.product-price {
    font-weight: 500;
}

.price-details {
    padding: 20px 24px;
}

.price-row {
    display: flex;
    justify-content: space-between;
    margin-bottom: 12px;
    font-size: 14px;
    color: var(--muted);
}

.total-row {
    display: flex;
    justify-content: space-between;
    padding-top: 16px;
    margin-top: 16px;
    border-top: 0.5px solid var(--border);
    font-size: 17px;
    font-weight: 590;
}

.cta {
    width: 100%;
    margin-top: 8px;
    border: none;
    border-radius: 980px;
    background: var(--primary);
    color: white;
    font-size: 16px;
    font-weight: 500;
    padding: 14px 24px;
    cursor: pointer;
    transition: all 0.2s ease;
}

.cta:hover {
    background: #0077ed;
    transform: scale(0.98);
}

.alert {
    background: #fef2f2;
    border: 0.5px solid #fecaca;
    color: #dc2626;
    padding: 14px 18px;
    border-radius: 14px;
    margin-bottom: 24px;
    font-size: 14px;
}

@media (max-width: 780px) {
    .layout {
        grid-template-columns: 1fr;
    }
    .summary-panel {
        position: static;
    }
    .form-grid {
        grid-template-columns: 1fr;
    }
    .checkout-panel {
        padding: 20px;
    }
}
</style>
</head>
<body>

<div class="shell">
    <div class="topbar">
        <div>
            <div class="brand">MYNTRA CLONE</div>
        </div>
        <div>
            <a href="viewcart.jsp" class="back-btn">← Back to Bag</a>
        </div>
    </div>

    <div class="layout">
        <section class="panel checkout-panel">
            <h2>Checkout</h2>
            <div class="secure-note">🔒 Secure payment powered by encrypted checkout</div>

            <% if (request.getParameter("error") != null) { %>
                <div class="alert"><%= request.getParameter("error") %></div>
            <% } %>

            <form action="CardPaymentController" method="POST">
                <div class="section">
                    <h3 class="section-title">Delivery Details</h3>
                    <div class="form-group">
                        <label>Contact Mobile</label>
                        <input type="tel" name="phone" required value="<%= user.getPhoneNumber() != null ? user.getPhoneNumber() : "" %>">
                    </div>
                    <div class="form-group">
                        <label>Shipping Address</label>
                        <textarea name="address" required rows="3"><%= user.getShippingAddress() != null ? user.getShippingAddress() : "" %></textarea>
                    </div>
                </div>

                <div class="section">
                    <h3 class="section-title">Payment Information</h3>
                    <div class="form-group">
                        <label>Cardholder Name</label>
                        <input type="text" name="cardName" required placeholder="Name on card">
                    </div>
                    <div class="form-group">
                        <label>Card Number</label>
                        <input type="text" maxlength="16" name="cardNumber" required placeholder="0000 0000 0000 0000">
                    </div>
                    <div class="form-grid">
                        <div class="form-group">
                            <label>Expiry Date</label>
                            <input type="text" name="expiry" maxlength="4" required placeholder="MM/YY">
                        </div>
                        <div class="form-group">
                            <label>CVV</label>
                            <input type="password" name="cvv" maxlength="3" required placeholder="***">
                        </div>
                    </div>
                </div>
                <button type="submit" class="cta">Pay ₹<%= String.format("%.2f", checkoutTotal) %></button>
            </form>
        </section>

        <aside class="panel summary-panel">
            <div class="summary-title">PRICE DETAILS</div>
            <% for (CartItem item : cartItems) { %>
                <div class="order-item">
                    <div>
                        <div class="product-name"><%= item.getProduct().getName() %></div>
                        <div class="product-qty">Qty: <%= item.getQuantity() %></div>
                    </div>
                    <div class="product-price">₹<%= String.format("%.2f", item.getProduct().getPrice() * item.getQuantity()) %></div>
                </div>
            <% } %>
            <div class="price-details">
                <div class="price-row"><span>Total MRP</span><span>₹<%= String.format("%.2f", checkoutTotal) %></span></div>
                <div class="price-row"><span>Discount</span><span style="color:#059669;">−₹0</span></div>
                <div class="price-row"><span>Shipping</span><span style="color:#059669;">Free</span></div>
                <div class="total-row"><span>Total Amount</span><span>₹<%= String.format("%.2f", checkoutTotal) %></span></div>
            </div>
        </aside>
    </div>
</div>
</body>
</html>