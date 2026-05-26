<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myntra.model.User, com.myntra.model.CartItem, com.myntra.service.CartService, com.myntra.serviceImpl.CartServiceImpl, java.util.ArrayList, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Myntra Clone - Your Bag</title>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        font-family: -apple-system, 'SF Pro Text', 'Helvetica Neue', sans-serif;
        background: #f5f5f7;
        color: #1d1d1f;
    }

    .page {
        max-width: 1200px;
        margin: 0 auto;
        padding: 20px 24px 48px;
    }

    .header {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        align-items: center;
        gap: 16px;
        margin-bottom: 32px;
        padding-bottom: 16px;
        border-bottom: 0.5px solid #d2d2d6;
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

    .nav-links {
        display: flex;
        gap: 12px;
    }

    .nav-links a {
        padding: 8px 18px;
        border-radius: 980px;
        font-weight: 500;
        font-size: 14px;
        text-decoration: none;
        color: #1d1d1f;
        border: 0.5px solid #d2d2d6;
        transition: all 0.2s ease;
    }

    .nav-links a:hover {
        background: #0071e3;
        border-color: #0071e3;
        color: white;
    }

    .layout {
        display: grid;
        grid-template-columns: 1.6fr 0.9fr;
        gap: 28px;
    }

    .panel {
        background: white;
        border-radius: 24px;
        overflow: hidden;
        box-shadow: 0 2px 12px rgba(0, 0, 0, 0.04);
    }

    .panel h2 {
        padding: 20px 24px;
        font-size: 20px;
        font-weight: 590;
        border-bottom: 0.5px solid #e5e5ea;
    }

    .status-success, .status-error {
        margin: 16px 24px;
        padding: 14px 18px;
        border-radius: 14px;
        font-size: 14px;
    }

    .status-success {
        background: #ecfdf5;
        color: #059669;
        border: 0.5px solid #a7f3d0;
    }

    .status-error {
        background: #fef2f2;
        color: #dc2626;
        border: 0.5px solid #fecaca;
    }

    .empty {
        text-align: center;
        padding: 60px 24px;
        color: #8e8e93;
    }

    .cart-item {
        display: grid;
        grid-template-columns: 100px 1fr;
        gap: 18px;
        padding: 20px 24px;
        border-bottom: 0.5px solid #e5e5ea;
        align-items: center;
    }

    .cart-item img {
        width: 100%;
        height: 100px;
        border-radius: 16px;
        object-fit: cover;
        background: #f5f5f7;
    }

    .item-title {
        font-size: 16px;
        font-weight: 590;
        margin-bottom: 4px;
    }

    .item-subtitle {
        color: #8e8e93;
        font-size: 13px;
        margin-bottom: 8px;
    }

    .price-label {
        font-weight: 500;
        color: #1d1d1f;
        margin-bottom: 12px;
    }

    .actions {
        display: flex;
        gap: 16px;
        align-items: center;
        flex-wrap: wrap;
    }

    .qty-control {
        display: inline-flex;
        align-items: center;
        border: 0.5px solid #d2d2d6;
        border-radius: 12px;
        overflow: hidden;
    }

    .qty-control button {
        width: 36px;
        height: 36px;
        border: none;
        background: white;
        font-size: 18px;
        cursor: pointer;
        transition: background 0.2s;
    }

    .qty-control button:hover {
        background: #f5f5f7;
    }

    .qty-count {
        min-width: 40px;
        text-align: center;
        font-weight: 500;
    }

    .remove-button {
        background: none;
        border: none;
        color: #dc2626;
        font-weight: 500;
        cursor: pointer;
        font-size: 14px;
    }

    /* Summary Panel */
    .summary-heading {
        padding: 20px 24px;
        font-size: 14px;
        font-weight: 500;
        letter-spacing: 0.3px;
        color: #8e8e93;
        border-bottom: 0.5px solid #e5e5ea;
    }

    .price-details {
        padding: 20px 24px;
    }

    .price-row {
        display: flex;
        justify-content: space-between;
        margin-bottom: 14px;
        font-size: 14px;
        color: #6e6e73;
    }

    .price-divider {
        border-top: 0.5px solid #e5e5ea;
        margin: 16px 0;
    }

    .price-total {
        display: flex;
        justify-content: space-between;
        font-size: 16px;
        font-weight: 590;
        color: #1d1d1f;
    }

    .checkout-wrapper {
        padding: 0 24px 24px;
    }

    .checkout-btn {
        width: 100%;
        border: none;
        border-radius: 980px;
        padding: 14px 24px;
        background: #0071e3;
        color: white;
        font-size: 16px;
        font-weight: 500;
        cursor: pointer;
        transition: all 0.2s ease;
    }

    .checkout-btn:hover {
        background: #0077ed;
        transform: scale(0.98);
    }

    .checkout-btn:disabled {
        background: #a1a1a6;
        cursor: not-allowed;
    }

    @media (max-width: 780px) {
        .layout {
            grid-template-columns: 1fr;
        }
        .cart-item {
            grid-template-columns: 80px 1fr;
        }
        .cart-item img {
            height: 80px;
        }
    }
</style>
</head>
<body>
<%
    User currentUser = (User) session.getAttribute("currentUser");
    CartService cartService = new CartServiceImpl();
    List<CartItem> cartItems = new ArrayList<>();
    double cartTotal = 0.0;
    int totalQty = 0;
    String message = request.getParameter("msg");
    String error = request.getParameter("error");
    if (currentUser != null) {
        cartItems = cartService.getUserCart(currentUser.getUserId());
        for (CartItem item : cartItems) {
            cartTotal += item.getProduct().getPrice() * item.getQuantity();
            totalQty += item.getQuantity();
        }
    }
%>

<div class="page">
    <div class="header">
        <div class="brand">MYNTRA CLONE</div>
        <div class="nav-links">
            <a href="home.jsp">Shop</a>
            <a href="Checkout.jsp">Checkout</a>
            <a href="AuthController?action=logout">Logout</a>
        </div>
    </div>

    <div class="layout">
        <section class="panel">
            <h2>Your Bag</h2>
            <% if (message != null) { %>
                <div class="status-success"><%= message %></div>
            <% } else if (error != null) { %>
                <div class="status-error"><%= error %></div>
            <% } %>

            <% if (currentUser == null) { %>
                <div class="empty">Please log in to manage your bag.</div>
            <% } else if (cartItems.isEmpty()) { %>
                <div class="empty">Your bag is empty. Browse products to add your favorites.</div>
            <% } else {
                    for (CartItem item : cartItems) {
                        double itemTotal = item.getProduct().getPrice() * item.getQuantity();
                        int cartId = item.getCartId();
                        int qty = item.getQuantity();
            %>
            <div class="cart-item">
                <img src="<%= item.getProduct().getImagePath() %>" alt="<%= item.getProduct().getName() %>">
                <div>
                    <div class="item-title"><%= item.getProduct().getName() %></div>
                    <div class="item-subtitle"><%= item.getProduct().getCategory() %></div>
                    <div class="price-label">₹<%= String.format("%.2f", itemTotal) %></div>
                    <div class="actions">
                        <div class="qty-control">
                            <button onclick="updateQuantity(<%= cartId %>, <%= Math.max(1, qty - 1) %>)" <%= qty == 1 ? "disabled" : "" %>>−</button>
                            <span class="qty-count"><%= qty %></span>
                            <button onclick="updateQuantity(<%= cartId %>, <%= qty + 1 %>)">+</button>
                        </div>
                        <button class="remove-button" onclick="removeCartItem(<%= cartId %>)">Remove</button>
                    </div>
                </div>
            </div>
            <%   }
            } %>
        </section>

        <aside class="panel">
            <div class="summary-heading">PRICE DETAILS (<%= totalQty %> Items)</div>
            <div class="price-details">
                <div class="price-row"><span>Total MRP</span><span>₹<%= String.format("%.2f", cartTotal) %></span></div>
                <div class="price-row"><span>Discount</span><span style="color:#059669;">−₹0</span></div>
                <div class="price-row"><span>Platform Fee</span><span>₹20</span></div>
                <div class="price-row"><span>Shipping</span><span style="color:#059669;">Free</span></div>
                <div class="price-divider"></div>
                <div class="price-total"><span>Total</span><span>₹<%= String.format("%.2f", cartTotal + 20) %></span></div>
            </div>
            <div class="checkout-wrapper">
                <button class="checkout-btn" onclick="window.location.href='paymentOptions.jsp'" <%= (currentUser == null || cartItems.isEmpty()) ? "disabled" : "" %>>Checkout →</button>
            </div>
        </aside>
    </div>
</div>

<script>
function updateQuantity(cartId, quantity) {
    if (quantity < 1) return;
    fetch('CartController?action=updateQty&cartId=' + cartId + '&quantity=' + quantity, { method: 'POST' })
        .then(function(response) {
            if (!response.ok) throw new Error('Unable to update quantity');
            window.location.reload();
        })
        .catch(function(err) {
            alert('Could not update quantity. Please try again.');
        });
}
function removeCartItem(cartId) {
    if (!confirm('Remove this item from your bag?')) return;
    fetch('CartController?action=remove&cartId=' + cartId, { method: 'POST' })
        .then(function(response) {
            if (!response.ok) throw new Error('Unable to remove item');
            window.location.reload();
        })
        .catch(function(err) {
            alert('Could not remove item. Please try again.');
        });
}
</script>
</body>
</html>