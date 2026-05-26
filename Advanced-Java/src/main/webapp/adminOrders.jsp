<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myntra.model.Order, com.myntra.model.OrderItem, com.myntra.model.Product, java.util.*" %>

<%
    List<Order> allOrders = (List<Order>) request.getAttribute("allOrders");
    Map<Integer, List<OrderItem>> orderItemsMap = (Map<Integer, List<OrderItem>>) request.getAttribute("orderItemsMap");
    Map<Integer, String> userNamesMap = (Map<Integer, String>) request.getAttribute("userNamesMap");
    Map<Integer, String> userEmailsMap = (Map<Integer, String>) request.getAttribute("userEmailsMap");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Myntra Clone - All Orders</title>
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

.container {
    max-width: 1400px;
    margin: 32px auto;
    padding: 0 24px;
}

.header {
    background: #1d1d1f;
    color: white;
    padding: 20px 32px;
    border-radius: 24px;
    margin-bottom: 32px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    gap: 16px;
}

.header h1 {
    font-size: 24px;
    font-weight: 590;
    letter-spacing: -0.3px;
}

.back-btn {
    background: #0071e3;
    color: white;
    padding: 10px 24px;
    border-radius: 980px;
    text-decoration: none;
    font-size: 14px;
    font-weight: 500;
    transition: all 0.2s ease;
}

.back-btn:hover {
    background: #0077ed;
    transform: scale(0.96);
}

.summary-cards {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(180px, 1fr));
    gap: 20px;
    margin-bottom: 32px;
}

.summary-card {
    background: white;
    padding: 20px;
    border-radius: 20px;
    text-align: center;
    box-shadow: 0 2px 12px rgba(0, 0, 0, 0.04);
}

.summary-card .number {
    font-size: 32px;
    font-weight: 600;
    color: #0071e3;
}

.summary-card .label {
    color: #6e6e73;
    font-size: 13px;
    margin-top: 6px;
}

.order-card {
    background: white;
    border-radius: 20px;
    margin-bottom: 24px;
    overflow: hidden;
    box-shadow: 0 2px 12px rgba(0, 0, 0, 0.04);
}

.order-header {
    background: #f5f5f7;
    padding: 18px 24px;
    border-bottom: 0.5px solid #e5e5ea;
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    gap: 12px;
}

.order-id {
    font-weight: 590;
    font-size: 16px;
    color: #0071e3;
}

.status {
    padding: 4px 12px;
    border-radius: 980px;
    font-size: 11px;
    font-weight: 500;
    margin-left: 10px;
}

.status-pending {
    background: #fef3c7;
    color: #d97706;
}

.status-delivered {
    background: #ecfdf5;
    color: #059669;
}

.status-cancelled {
    background: #fef2f2;
    color: #dc2626;
}

.user-info {
    color: #6e6e73;
    font-size: 14px;
}

.user-info strong {
    color: #1d1d1f;
}

.order-items {
    padding: 20px 24px;
}

.items-table {
    width: 100%;
    border-collapse: collapse;
}

.items-table th {
    text-align: left;
    padding: 12px 8px;
    background: #f5f5f7;
    font-size: 12px;
    font-weight: 500;
    color: #6e6e73;
    border-radius: 12px;
}

.items-table td {
    padding: 12px 8px;
    border-bottom: 0.5px solid #e5e5ea;
    font-size: 14px;
}

.product-image {
    width: 48px;
    height: 48px;
    border-radius: 12px;
    object-fit: cover;
}

.order-footer {
    background: #f5f5f7;
    padding: 16px 24px;
    border-top: 0.5px solid #e5e5ea;
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    gap: 12px;
}

.shipping-address {
    font-size: 13px;
    color: #6e6e73;
}

.total-amount {
    font-size: 18px;
    font-weight: 590;
    color: #0071e3;
}

.no-orders {
    text-align: center;
    padding: 80px 24px;
    background: white;
    border-radius: 24px;
}

.no-orders h2 {
    font-size: 24px;
    font-weight: 590;
    margin-bottom: 8px;
}

.no-orders p {
    color: #6e6e73;
}

@media (max-width: 780px) {
    .container {
        padding: 0 16px;
    }
    .order-header {
        flex-direction: column;
        align-items: flex-start;
    }
    .items-table {
        font-size: 12px;
    }
    .items-table th, .items-table td {
        padding: 10px 6px;
    }
}
</style>
</head>
<body>

<div class="container">
    <div class="header">
        <h1>📦 All Customer Orders</h1>
        <a href="adminDashboard.jsp" class="back-btn">← Back to Dashboard</a>
    </div>

    <% 
    if(allOrders != null && !allOrders.isEmpty()) { 
        double totalRevenue = 0;
        int totalOrders = allOrders.size();
        int pendingOrders = 0;
        int deliveredOrders = 0;
        int cancelledOrders = 0;
        
        for(Order order : allOrders) {
            totalRevenue += order.getTotalAmount();
            String status = order.getStatus();
            if("Pending".equalsIgnoreCase(status)) pendingOrders++;
            else if("Delivered".equalsIgnoreCase(status)) deliveredOrders++;
            else if("Cancelled".equalsIgnoreCase(status)) cancelledOrders++;
        }
    %>
    
    <div class="summary-cards">
        <div class="summary-card">
            <div class="number"><%= totalOrders %></div>
            <div class="label">Total Orders</div>
        </div>
        <div class="summary-card">
            <div class="number">₹<%= String.format("%.0f", totalRevenue) %></div>
            <div class="label">Total Revenue</div>
        </div>
        <div class="summary-card">
            <div class="number"><%= pendingOrders %></div>
            <div class="label">Pending</div>
        </div>
        <div class="summary-card">
            <div class="number"><%= deliveredOrders %></div>
            <div class="label">Delivered</div>
        </div>
        <div class="summary-card">
            <div class="number"><%= cancelledOrders %></div>
            <div class="label">Cancelled</div>
        </div>
    </div>

    <% for(Order order : allOrders) { 
        List<OrderItem> items = orderItemsMap.get(order.getOrderId());
        String userName = userNamesMap.get(order.getUserId());
        String userEmail = userEmailsMap.get(order.getUserId());
        String statusClass = "status-pending";
        if("Delivered".equalsIgnoreCase(order.getStatus())) statusClass = "status-delivered";
        else if("Cancelled".equalsIgnoreCase(order.getStatus())) statusClass = "status-cancelled";
    %>
    
    <div class="order-card">
        <div class="order-header">
            <div>
                <span class="order-id">Order #<%= order.getOrderId() %></span>
                <span class="status <%= statusClass %>"><%= order.getStatus() != null ? order.getStatus() : "Pending" %></span>
            </div>
            <div class="user-info">
                👤 <strong><%= userName != null ? userName : "Unknown" %></strong> • <%= userEmail != null ? userEmail : "No email" %>
            </div>
            <div class="user-info">
                📅 <%= order.getOrderDate() != null ? order.getOrderDate() : "N/A" %>
            </div>
        </div>
        
        <div class="order-items">
            <table class="items-table">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Name</th>
                        <th>Qty</th>
                        <th>Price</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <% if(items != null) {
                        for(OrderItem item : items) { 
                            Product product = item.getProduct();
                    %>
                    <tr>
                        <td><img class="product-image" src="<%= product != null && product.getImagePath() != null ? product.getImagePath() : "https://placehold.co/50x50" %>" alt="Product"></td>
                        <td><%= product != null ? product.getName() : "Unknown" %></td>
                        <td><%= item.getQuantity() %></td>
                        <td>₹<%= String.format("%.2f", item.getPriceAtPurchase()) %></td>
                        <td><strong>₹<%= String.format("%.2f", item.getPriceAtPurchase() * item.getQuantity()) %></strong></td>
                    </tr>
                    <% } 
                    } %>
                </tbody>
            </table>
        </div>
        
        <div class="order-footer">
            <div class="shipping-address">📍 <%= order.getShippingAddress() != null ? order.getShippingAddress() : "N/A" %></div>
            <div class="total-amount">Total: ₹<%= String.format("%.2f", order.getTotalAmount()) %></div>
        </div>
    </div>
    <% } 
    } else { %>
    <div class="no-orders">
        <h2>No orders yet</h2>
        <p>Customers haven't placed any orders.</p>
    </div>
    <% } %>
</div>

</body>
</html>