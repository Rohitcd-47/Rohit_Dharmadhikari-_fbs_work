<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.myntra.model.User"%>
<%@ page import="com.myntra.model.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.myntra.service.ProductService"%>
<%@ page import="com.myntra.serviceImpl.ProductServiceImpl"%>

<%
    User user = (User) session.getAttribute("currentUser");

    if (user == null || !"Admin".equals(user.getRole())) {
        response.sendRedirect("login.jsp?error=Unauthorized Access!");
        return;
    }

    ProductService productService = new ProductServiceImpl();
    List<Product> productList = productService.getAllProducts();

    String searchId = request.getParameter("searchId");
    if(searchId != null && !searchId.trim().isEmpty()){
        List<Product> filteredList = new ArrayList<>();
        for(Product p : productList){
            if(String.valueOf(p.getProductId()).equals(searchId)){
                filteredList.add(p);
            }
        }
        productList = filteredList;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Myntra Clone - Admin Console</title>
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

.header {
    background: #1d1d1f;
    color: white;
    padding: 20px 32px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    gap: 16px;
    position: sticky;
    top: 0;
    z-index: 100;
}

.header h1 {
    font-size: 22px;
    font-weight: 590;
    letter-spacing: -0.3px;
    color: white;
}

.header-right {
    display: flex;
    gap: 16px;
    align-items: center;
    flex-wrap: wrap;
}

.welcome-text {
    font-size: 14px;
    color: #8e8e93;
}

.logout-btn, .orders-btn {
    padding: 8px 20px;
    border-radius: 980px;
    text-decoration: none;
    font-size: 14px;
    font-weight: 500;
    transition: all 0.2s ease;
    cursor: pointer;
    display: inline-block;
}

.logout-btn {
    background: #dc2626;
    color: white;
    border: none;
}

.logout-btn:hover {
    background: #b91c1c;
    transform: scale(0.96);
}

.orders-btn {
    background: #0071e3;
    color: white;
    border: none;
}

.orders-btn:hover {
    background: #0077ed;
    transform: scale(0.96);
}

.container {
    max-width: 1400px;
    margin: 32px auto;
    padding: 0 24px;
    display: grid;
    grid-template-columns: 380px 1fr;
    gap: 32px;
}

.card {
    background: white;
    border-radius: 24px;
    overflow: hidden;
    box-shadow: 0 2px 12px rgba(0, 0, 0, 0.04);
}

.card-header {
    padding: 20px 24px;
    border-bottom: 0.5px solid #e5e5ea;
}

.card-header h2 {
    font-size: 20px;
    font-weight: 590;
    letter-spacing: -0.2px;
}

.card-body {
    padding: 24px;
}

.form-group {
    margin-bottom: 20px;
}

label {
    display: block;
    margin-bottom: 6px;
    font-size: 13px;
    font-weight: 500;
    color: #6e6e73;
}

input, select, textarea {
    width: 100%;
    padding: 12px 14px;
    border: 0.5px solid #d2d2d6;
    border-radius: 14px;
    font-size: 15px;
    font-family: inherit;
    transition: all 0.2s ease;
}

input:focus, select:focus, textarea:focus {
    outline: none;
    border-color: #0071e3;
    box-shadow: 0 0 0 4px rgba(0, 113, 227, 0.1);
}

.btn-primary {
    width: 100%;
    background: #0071e3;
    color: white;
    border: none;
    padding: 12px 24px;
    border-radius: 980px;
    font-size: 15px;
    font-weight: 500;
    cursor: pointer;
    transition: all 0.2s ease;
}

.btn-primary:hover {
    background: #0077ed;
    transform: scale(0.98);
}

.status-msg {
    background: #ecfdf5;
    color: #059669;
    padding: 12px 16px;
    border-radius: 14px;
    margin-bottom: 20px;
    font-size: 14px;
}

.err-msg {
    background: #fef2f2;
    color: #dc2626;
    padding: 12px 16px;
    border-radius: 14px;
    margin-bottom: 20px;
    font-size: 14px;
}

.product-section {
    display: flex;
    flex-direction: column;
    gap: 24px;
}

.top-manage {
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    gap: 16px;
    margin-bottom: 8px;
}

.top-manage h2 {
    font-size: 20px;
    font-weight: 590;
}

.search-box {
    display: flex;
    gap: 12px;
}

.search-box input {
    width: 200px;
    padding: 10px 14px;
}

.search-btn {
    background: #1d1d1f;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 980px;
    cursor: pointer;
    font-weight: 500;
    transition: all 0.2s ease;
}

.search-btn:hover {
    background: #3a3a3c;
}

.product-card {
    background: white;
    border-radius: 24px;
    padding: 24px;
    box-shadow: 0 2px 12px rgba(0, 0, 0, 0.04);
    transition: all 0.2s ease;
}

.product-card:hover {
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.08);
}

.product-card img {
    width: 100px;
    height: 100px;
    object-fit: cover;
    border-radius: 16px;
    margin-bottom: 16px;
}

.product-title {
    font-size: 18px;
    font-weight: 590;
    margin-bottom: 8px;
}

.product-desc {
    color: #6e6e73;
    font-size: 13px;
    margin-bottom: 12px;
    line-height: 1.4;
}

.price {
    font-size: 20px;
    font-weight: 590;
    color: #0071e3;
    margin-bottom: 4px;
}

.stock, .category {
    font-size: 13px;
    color: #6e6e73;
    margin-bottom: 4px;
}

.action-buttons {
    margin: 16px 0 20px;
}

.delete-btn {
    background: #dc2626;
    color: white;
    border: none;
    padding: 8px 20px;
    border-radius: 980px;
    cursor: pointer;
    font-weight: 500;
    transition: all 0.2s ease;
}

.delete-btn:hover {
    background: #b91c1c;
    transform: scale(0.96);
}

.edit-form {
    border-top: 0.5px solid #e5e5ea;
    padding-top: 20px;
    margin-top: 8px;
}

.edit-form h3 {
    font-size: 16px;
    font-weight: 590;
    margin-bottom: 16px;
}

.edit-btn {
    background: #1d1d1f;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 980px;
    cursor: pointer;
    font-weight: 500;
    width: 100%;
    transition: all 0.2s ease;
}

.edit-btn:hover {
    background: #3a3a3c;
}

@media (max-width: 900px) {
    .container {
        grid-template-columns: 1fr;
    }
    .header {
        padding: 16px 20px;
    }
    .container {
        padding: 0 20px;
    }
}
</style>
</head>
<body>

<div class="header">
    <h1>MYNTRA CLONE • Admin Console</h1>
    <div class="header-right">
        <span class="welcome-text">Welcome, <%= user.getName() %></span>
        <a href="AdminProductController?action=viewAllOrders" class="orders-btn">📋 All Orders</a>
        <a href="javascript:void(0)" onclick="confirmLogout()" class="logout-btn">Logout</a>
    </div>
</div>

<div class="container">
    <!-- ADD PRODUCT CARD -->
    <div class="card">
        <div class="card-header">
            <h2>Add New Product</h2>
        </div>
        <div class="card-body">
            <% if(request.getParameter("msg") != null){ %>
                <div class="status-msg">✓ <%= request.getParameter("msg") %></div>
            <% } %>
            <% if(request.getParameter("error") != null){ %>
                <div class="err-msg">⚠ <%= request.getParameter("error") %></div>
            <% } %>

            <form action="AdminProductController" method="POST" onsubmit="return confirmAdd()">
                <input type="hidden" name="action" value="add">
                <div class="form-group">
                    <label>Product Name</label>
                    <input type="text" name="name" required placeholder="e.g., AirPods Pro">
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <textarea name="description" rows="3" required placeholder="Product description..."></textarea>
                </div>
                <div class="form-group">
                    <label>Price (₹)</label>
                    <input type="number" step="0.01" name="price" required placeholder="24999">
                </div>
                <div class="form-group">
                    <label>Category</label>
                    <select name="category">
                        <option value="Fashion">Fashion</option>
                        <option value="Tech">Tech</option>
                        <option value="Sports">Sports</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Stock Quantity</label>
                    <input type="number" name="stock" required placeholder="100">
                </div>
                <div class="form-group">
                    <label>Image URL</label>
                    <input type="text" name="imagePath" required placeholder="https://...">
                </div>
                <button type="submit" class="btn-primary">Add Product →</button>
            </form>
        </div>
    </div>

    <!-- PRODUCT MANAGEMENT SECTION -->
    <div class="product-section">
        <div class="top-manage">
            <h2>Manage Products</h2>
            <form method="GET" action="adminDashboard.jsp" class="search-box">
                <input type="text" name="searchId" placeholder="Search by Product ID">
                <button type="submit" class="search-btn">Search</button>
            </form>
        </div>

        <% for(Product p : productList){ %>
        <div class="product-card">
            <img src="<%= p.getImagePath() %>" alt="<%= p.getName() %>">
            <div class="product-title"><%= p.getName() %></div>
            <div class="product-desc"><%= p.getDescription() %></div>
            <div class="price">₹<%= p.getPrice() %></div>
            <div class="stock">Stock: <%= p.getStockQuantity() %></div>
            <div class="category">Category: <%= p.getCategory() %></div>

            <!-- DELETE BUTTON -->
            <div class="action-buttons">
                <form action="AdminProductController" method="POST" onsubmit="return confirmDelete()">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="productId" value="<%= p.getProductId() %>">
                    <button type="submit" class="delete-btn">Delete Product</button>
                </form>
            </div>

            <!-- EDIT FORM -->
            <div class="edit-form">
                <h3>Edit Product</h3>
                <form action="AdminProductController" method="POST" onsubmit="return confirmUpdate()">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="productId" value="<%= p.getProductId() %>">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" name="name" value="<%= p.getName() %>" required>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea name="description" rows="2" required><%= p.getDescription() %></textarea>
                    </div>
                    <div class="form-group">
                        <label>Price (₹)</label>
                        <input type="number" step="0.01" name="price" value="<%= p.getPrice() %>" required>
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <input type="text" name="category" value="<%= p.getCategory() %>" required>
                    </div>
                    <div class="form-group">
                        <label>Stock</label>
                        <input type="number" name="stock" value="<%= p.getStockQuantity() %>" required>
                    </div>
                    <div class="form-group">
                        <label>Image URL</label>
                        <input type="text" name="imagePath" value="<%= p.getImagePath() %>" required>
                    </div>
                    <button type="submit" class="edit-btn">Update Product</button>
                </form>
            </div>
        </div>
        <% } %>
    </div>
</div>

<script>
function confirmAdd(){
    return confirm("Add this product to inventory?");
}
function confirmDelete(){
    return confirm("Delete this product permanently?");
}
function confirmUpdate(){
    return confirm("Update this product with new details?");
}
function confirmLogout() {
    if (confirm("Are you sure you want to logout?")) {
        window.location.href = "login.jsp";
    }
}
</script>
</body>
</html>