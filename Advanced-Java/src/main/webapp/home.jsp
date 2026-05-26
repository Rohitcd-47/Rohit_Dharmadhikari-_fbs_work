<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.myntra.model.User, com.myntra.model.CartItem, com.myntra.model.Product, com.myntra.model.Order, com.myntra.model.OrderItem, com.myntra.service.CartService, com.myntra.service.ProductService, com.myntra.service.OrderService, com.myntra.serviceImpl.CartServiceImpl, com.myntra.serviceImpl.ProductServiceImpl, com.myntra.serviceImpl.OrderServiceImpl, java.util.ArrayList, java.util.List, java.util.Map, java.util.HashMap"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Myntra Clone - Shop</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: -apple-system, 'SF Pro Text', 'Helvetica Neue', sans-serif;
	background: #fbfbfd;
	color: #1d1d1f;
}

.shell {
	max-width: 1280px;
	margin: 0 auto;
	padding: 20px 24px 48px;
}

.topbar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	flex-wrap: wrap;
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

.actions {
	display: flex;
	gap: 12px;
}

.actions a {
	padding: 8px 18px;
	border-radius: 980px;
	font-weight: 500;
	font-size: 14px;
	background: transparent;
	color: #1d1d1f;
	border: 0.5px solid #d2d2d6;
	text-decoration: none;
	cursor: pointer;
	transition: all 0.2s ease;
}

.actions a.primary {
	background: #0071e3;
	border-color: #0071e3;
	color: white;
}

.actions a:hover {
	background: #0071e3;
	border-color: #0071e3;
	color: white;
	transform: scale(0.96);
}

.filter-wrapper {
	display: flex;
	justify-content: space-between;
	align-items: center;
	flex-wrap: wrap;
	gap: 16px;
	margin-bottom: 32px;
}

.category-bar {
	display: flex;
	gap: 8px;
	flex-wrap: wrap;
}

.category-bar a {
	padding: 8px 20px;
	border-radius: 980px;
	font-weight: 500;
	font-size: 14px;
	background: transparent;
	color: #6e6e73;
	border: 0.5px solid #d2d2d6;
	text-decoration: none;
	transition: all 0.2s ease;
}

.category-bar a.active, .category-bar a:hover {
	background: #1d1d1f;
	border-color: #1d1d1f;
	color: white;
}

.sort-select {
	padding: 8px 20px;
	border-radius: 980px;
	border: 0.5px solid #d2d2d6;
	background: white;
	font-weight: 500;
	font-size: 14px;
	cursor: pointer;
}

.grid {
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
	gap: 28px;
}

.card {
	background: white;
	border-radius: 20px;
	overflow: hidden;
	transition: all 0.3s cubic-bezier(0.25, 0.46, 0.45, 0.94);
	cursor: pointer;
}

.card:hover {
	transform: translateY(-6px);
	box-shadow: 0 20px 35px -12px rgba(0, 0, 0, 0.15);
}

.card img {
	width: 100%;
	aspect-ratio: 1/1;
	object-fit: cover;
}

.card-content {
	padding: 16px 18px 20px;
	display: flex;
	flex-direction: column;
	gap: 8px;
}

.card-title {
	font-size: 17px;
	font-weight: 590;
	letter-spacing: -0.2px;
}

.card-copy {
	color: #6e6e73;
	font-size: 13px;
	line-height: 1.4;
	display: -webkit-box;
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
	overflow: hidden;
}

.price-row {
	display: flex;
	justify-content: space-between;
	align-items: center;
	gap: 12px;
	margin-top: 8px;
}

.price {
	font-size: 20px;
	font-weight: 600;
	color: #1d1d1f;
}

.card-button {
	background: #0071e3;
	border: none;
	color: white;
	padding: 10px 18px;
	border-radius: 980px;
	font-weight: 500;
	cursor: pointer;
	transition: all 0.2s ease;
}

.card-button:hover {
	background: #0077ed;
	transform: scale(0.96);
}

.card-button.disabled {
	background: #a1a1a6;
	cursor: default;
}

/* Modal Styles */
.modal-overlay {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.5);
	backdrop-filter: blur(12px);
	z-index: 1000;
	justify-content: center;
	align-items: center;
}

.modal-content {
	background: white;
	width: 95%;
	max-width: 1000px;
	max-height: 85vh;
	border-radius: 24px;
	overflow-y: auto;
	padding: 0;
}

.modal-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 20px 28px;
	background: #1d1d1f;
	color: white;
	position: sticky;
	top: 0;
}

.close-modal {
	font-size: 28px;
	cursor: pointer;
	background: none;
	border: none;
	color: white;
}

.orders-container {
	padding: 24px 28px;
}

.order-card {
	background: white;
	border-radius: 20px;
	margin-bottom: 24px;
	border: 0.5px solid #e5e5ea;
	overflow: hidden;
}

.order-header {
	background: #f5f5f7;
	padding: 16px 22px;
	border-bottom: 0.5px solid #e5e5ea;
	display: flex;
	justify-content: space-between;
	flex-wrap: wrap;
	gap: 12px;
}

.order-id {
	font-weight: 590;
	font-size: 16px;
	color: #0071e3;
}

.order-status {
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

.status-cancelled {
	background: #fee2e2;
	color: #dc2626;
}

.order-items {
	padding: 18px 22px;
}

.product-item {
	display: flex;
	align-items: center;
	gap: 16px;
	padding: 12px;
	background: #f5f5f7;
	border-radius: 16px;
	flex-wrap: wrap;
}

.product-image {
	width: 60px;
	height: 60px;
	border-radius: 12px;
	object-fit: cover;
}

.product-details {
	flex: 1;
}

.product-name {
	font-weight: 590;
	font-size: 15px;
	margin-bottom: 4px;
}

.item-cancel-btn {
	background: #dc2626;
	border: none;
	color: white;
	padding: 6px 16px;
	border-radius: 980px;
	font-weight: 500;
	font-size: 12px;
	cursor: pointer;
}

.order-footer {
	padding: 14px 22px;
	background: #f5f5f7;
	border-top: 0.5px solid #e5e5ea;
	display: flex;
	justify-content: space-between;
	flex-wrap: wrap;
}

.total-amount span {
	color: #0071e3;
	font-weight: 600;
}
</style>
</head>
<body>

	<%
    User currentUser = (User) session.getAttribute("currentUser");
    CartService cartService = new CartServiceImpl();
    ProductService productService = new ProductServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    List<CartItem> currentCart = new ArrayList<>();
    List<Product> products = productService.getAllProducts();
    List<Order> userOrders = new ArrayList<>();
    Map<Integer, List<OrderItem>> orderItemsMap = new HashMap<>();
    int cartQuantity = 0;

    String categoryFilter = request.getParameter("category");
    String sortFilter = request.getParameter("sort");

    if (categoryFilter == null || categoryFilter.trim().isEmpty()) categoryFilter = "All";
    if ("lowToHigh".equals(sortFilter)) products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
    else if ("highToLow".equals(sortFilter)) products.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));

    if (currentUser != null) {
        currentCart = cartService.getUserCart(currentUser.getUserId());
        for (CartItem item : currentCart) cartQuantity += item.getQuantity();
        userOrders = orderService.getOrdersByUserId(currentUser.getUserId());
        for (Order order : userOrders) {
            orderItemsMap.put(order.getOrderId(), orderService.getOrderItemsWithProducts(order.getOrderId()));
        }
    }
%>

	<div class="shell">
		<div class="topbar">
			<div class="brand">MYNTRA CLONE</div>
			<div class="actions">
				<a href="viewcart.jsp">Bag (<%= cartQuantity %>)</a> 
				<a href="#" class="primary" onclick="openOrdersModal(event)">My Orders</a> 
				<a href="javascript:void(0)" onclick="confirmLogout(event)">Logout</a>
			</div>
		</div>

		<div class="filter-wrapper">
			<div class="category-bar">
				<a href="home.jsp" class="<%= "All".equals(categoryFilter) ? "active" : "" %>">All</a>
				<a href="home.jsp?category=Fashion" class="<%= "Fashion".equals(categoryFilter) ? "active" : "" %>">Fashion</a>
				<a href="home.jsp?category=Tech" class="<%= "Tech".equals(categoryFilter) ? "active" : "" %>">Tech</a>
				<a href="home.jsp?category=Sports" class="<%= "Sports".equals(categoryFilter) ? "active" : "" %>">Sports</a>
			</div>
			<select class="sort-select" onchange="window.location.href=this.value">
				<option value="home.jsp?category=<%= categoryFilter %>">Sort By</option>
				<option value="home.jsp?category=<%= categoryFilter %>&sort=lowToHigh">Price: Low to High</option>
				<option value="home.jsp?category=<%= categoryFilter %>&sort=highToLow">Price: High to Low</option>
			</select>
		</div>

		<div class="grid">
			<% if (products.isEmpty()) { %>
			<div class="empty-state" style="grid-column: 1/-1; text-align: center; padding: 60px;">
				<h2>No products available</h2>
			</div>
			<% } else {
            for (Product product : products) {
                if (!"All".equals(categoryFilter) && !categoryFilter.equals(product.getCategory())) continue;
                boolean alreadyAdded = false;
                for (CartItem item : currentCart) {
                    if (item.getProduct().getProductId() == product.getProductId()) { alreadyAdded = true; break; }
                }
                String buttonClass = alreadyAdded ? "card-button disabled" : "card-button";
                String buttonLabel = alreadyAdded ? "View Cart" : "Add to Bag";
                String onclickAttr = alreadyAdded ? "window.location.href='viewcart.jsp'" : "addToCartAsync('" + product.getProductId() + "')";
        %>
			<div class="card">
				<img src="<%= product.getImagePath() != null && !product.getImagePath().isEmpty() ? product.getImagePath() : "https://placehold.co/500x500?text=Product" %>"
					alt="<%= product.getName() %>">
				<div class="card-content">
					<div class="card-title"><%= product.getName() %></div>
					<div class="card-copy"><%= product.getDescription() != null ? product.getDescription() : "Premium quality product." %></div>
					<div class="price-row">
						<span class="price">₹<%= String.format("%.2f", product.getPrice()) %></span>
						<button class="<%= buttonClass %>" onclick="<%= onclickAttr %>"><%= buttonLabel %></button>
					</div>
				</div>
			</div>
			<% }
        } %>
		</div>
	</div>

	<!-- Orders Modal -->
	<div id="ordersModal" class="modal-overlay">
		<div class="modal-content">
			<div class="modal-header">
				<h2>My Order History</h2>
				<button class="close-modal" onclick="closeOrdersModal()">&times;</button>
			</div>
			<div class="orders-container">
				<% if (userOrders == null || userOrders.isEmpty()) { %>
				<div class="no-orders">
					<h3>No orders yet!</h3>
					<p>Start shopping to see your order history.</p>
				</div>
				<% } else { 
                for (Order order : userOrders) { 
                    String status = order.getStatus() != null ? order.getStatus() : "Pending";
                    String statusClass = "status-pending";
                    if ("Cancelled".equalsIgnoreCase(status)) statusClass = "status-cancelled";
                    List<OrderItem> orderItems = orderItemsMap.get(order.getOrderId());
            %>
				<div class="order-card">
					<div class="order-header">
						<div>
							<span class="order-id">Order #<%= order.getOrderId() %></span>
							<span class="order-status <%= statusClass %>"><%= status %></span>
						</div>
						<div>📅 <%= order.getOrderDate() != null ? order.getOrderDate() : "N/A" %></div>
					</div>
					<div class="order-items">
						<% if (orderItems != null && !orderItems.isEmpty()) {
                                for (OrderItem item : orderItems) { 
                                    Product product = item.getProduct();
                                    boolean isItemCancelled = item.isCancelled();
                                    String productName = product != null ? product.getName() : "Unknown Product";
                                    String escapedProductName = productName.replace("'", "\\'").replace("\"", "\\\"");
                            %>
							<div class="product-item">
								<img class="product-image" src="<%= product != null && product.getImagePath() != null ? product.getImagePath() : "https://placehold.co/100x100?text=Product" %>" alt="Product">
								<div class="product-details">
									<div class="product-name"><%= productName %> <% if (isItemCancelled) { %><span style="color:#dc2626; font-size:11px;">(Cancelled)</span><% } %></div>
									<div>Qty: <%= item.getQuantity() %> | ₹<%= String.format("%.2f", item.getPriceAtPurchase()) %></div>
								</div>
								<% if (!isItemCancelled && !"Cancelled".equalsIgnoreCase(status)) { %>
								<button class="item-cancel-btn" onclick="confirmCancelItem(<%= order.getOrderId() %>, <%= item.getOrderItemId() %>, '<%= escapedProductName %>', this)">Cancel</button>
								<% } else if (isItemCancelled) { %>
								<button class="item-cancel-btn" style="background:#a1a1a6;" disabled>Cancelled</button>
								<% } %>
							</div>
							<% } 
                            } else { %>
							<div>No items found for this order.</div>
							<% } %>
					</div>
					<div class="order-footer">
						<div>📍 <%= order.getShippingAddress() != null ? order.getShippingAddress() : "N/A" %></div>
						<div class="total-amount">Total: <span>₹<%= String.format("%.2f", order.getTotalAmount()) %></span></div>
					</div>
				</div>
				<% } 
            } %>
			</div>
		</div>
	</div>

	<script>
	function openOrdersModal(event) {
	    event.preventDefault();
	    document.getElementById('ordersModal').style.display = 'flex';
	    document.body.style.overflow = 'hidden';
	}	
    
    function closeOrdersModal() {
        document.getElementById('ordersModal').style.display = 'none';
        document.body.style.overflow = '';
    }
    
    window.onclick = function(event) {
        let modal = document.getElementById('ordersModal');
        if (event.target === modal) closeOrdersModal();
    }

    function confirmCancelItem(orderId, orderItemId, productName, buttonElement) {
        let confirmCancel = confirm("⚠️ Are you sure you want to cancel " + productName + " from your order?");
        if (confirmCancel) {
        	let refundConfirm = confirm("✅ Your 100% refund for " + productName + " will be credited within 24 hours.\n\nClick OK to proceed.");
            if (refundConfirm) {
                buttonElement.disabled = true;
                buttonElement.textContent = "Processing...";
                
                fetch('OrderController?action=cancelOrderItem&orderId=' + orderId + '&orderItemId=' + orderItemId, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
                })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                    	alert("🎉 " + productName + " has been cancelled successfully.");
                        location.reload();
                    } else {
                        alert(data.message || "Something went wrong. Please try again.");
                        buttonElement.disabled = false;
                        buttonElement.textContent = "Cancel";
                    }
                })
                .catch(error => {
                    alert("Unable to cancel item. Please try again.");
                    buttonElement.disabled = false;
                    buttonElement.textContent = "Cancel";
                });
            }
        }
    }

    function confirmLogout(event) {
        event.preventDefault();
        if (confirm("Are you sure you want to logout?")) {
            window.location.href = "AuthController?action=logout";
        }
    }

    function addToCartAsync(id) {
        <% if (currentUser == null) { %>
            window.location.href = 'login.jsp';
            return;
        <% } %>
        fetch('CartController?action=add&productId=' + id, { method: 'POST' })
        .then(function(response) {
            if (!response.ok) throw new Error('Unable to add item.');
            window.location.reload();
        })
        .catch(function(error) {
            alert('Could not add item to bag.');
        });
    }
	</script>
</body>
</html>