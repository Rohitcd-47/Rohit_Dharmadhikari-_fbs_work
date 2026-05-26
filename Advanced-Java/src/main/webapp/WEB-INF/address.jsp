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
<title>Delivery Address</title>

<style>

body{
    font-family:'Assistant',sans-serif;
    background:#f5f5f6;
}

.container{
    width:100%;
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.card{
    background:white;
    width:450px;
    padding:40px;
    border-radius:20px;
}

h1{
    text-align:center;
    margin-bottom:30px;
}

.form-group{
    margin-bottom:20px;
}

label{
    display:block;
    margin-bottom:8px;
    font-weight:bold;
}

input{
    width:100%;
    padding:14px;
    border:1px solid #ddd;
    border-radius:10px;
}

.btn{
    width:100%;
    padding:16px;
    border:none;
    background:#ff3f6c;
    color:white;
    border-radius:12px;
    cursor:pointer;
    font-size:16px;
    font-weight:bold;
}

</style>

</head>
<body>

<div class="container">

    <div class="card">

        <h1>Delivery Address</h1>

        <form action="OrderConfirmation.jsp" method="POST">

            <div class="form-group">
                <label>Area</label>
                <input type="text"
                       name="area"
                       required>
            </div>

            <div class="form-group">
                <label>City</label>
                <input type="text"
                       name="city"
                       required>
            </div>

            <div class="form-group">
                <label>Pincode</label>
                <input type="text"
                       maxlength="6"
                       pattern="[0-9]{6}"
                       name="pincode"
                       required>
            </div>

            <button class="btn">
                Continue
            </button>

        </form>

    </div>

</div>

</body>
</html>