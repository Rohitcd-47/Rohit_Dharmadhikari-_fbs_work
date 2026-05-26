<%@ page import="java.sql.*" %>
<%@ page import="com.myntra.util.DBConnection" %>

<%
int id = Integer.parseInt(request.getParameter("id"));

Connection con = DBConnection.getConnection();

PreparedStatement ps =
con.prepareStatement(
"SELECT * FROM products WHERE product_id=?");

ps.setInt(1,id);

ResultSet rs = ps.executeQuery();

rs.next();
%>

<!DOCTYPE html>
<html>
<head>

<title>Edit Product</title>

<style>

body{
    font-family:Arial;
    background:#f5f5f6;
}

.container{
    width:500px;
    margin:40px auto;
    background:white;
    padding:30px;
    border-radius:10px;
}

input,textarea{
    width:100%;
    padding:12px;
    margin-top:10px;
    margin-bottom:20px;
}

button{
    background:#ff3f6c;
    color:white;
    border:none;
    padding:14px;
    width:100%;
    border-radius:8px;
    font-size:16px;
    font-weight:bold;
}

img{
    width:120px;
    margin-bottom:20px;
}

</style>

</head>

<body>

<div class="container">

<h1>Edit Product</h1>

<img src="<%= rs.getString("image_path") %>">

<form action="ProductController" method="post">

<input type="hidden"
name="action"
value="update">

<input type="hidden"
name="productId"
value="<%= rs.getInt("product_id") %>">

<label>Name</label>

<input type="text"
name="name"
value="<%= rs.getString("name") %>">

<label>Description</label>

<textarea name="description"><%= rs.getString("description") %></textarea>

<label>Price</label>

<input type="number"
step="0.01"
name="price"
value="<%= rs.getDouble("price") %>">

<label>Category</label>

<input type="text"
name="category"
value="<%= rs.getString("category") %>">

<label>Stock</label>

<input type="number"
name="stock"
value="<%= rs.getInt("stock_quantity") %>">

<label>Image URL</label>

<input type="text"
name="image"
value="<%= rs.getString("image_path") %>">

<button type="submit">
Update Product
</button>

</form>

</div>

</body>
</html>