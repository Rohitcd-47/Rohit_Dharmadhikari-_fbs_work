<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
<title>Sign in - Myntra Clone</title>
<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: -apple-system, 'SF Pro Text', 'SF Pro Display', 'Helvetica Neue', sans-serif;
    background: #f5f5f7;
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
}

.auth-container {
    width: 100%;
    max-width: 500px;
    background: #ffffff;
    border-radius: 28px;
    border: 0.5px solid #d2d2d6;
    box-shadow: 0 8px 28px rgba(0, 0, 0, 0.04);
    padding: 44px 40px 48px;
    margin: 20px;
}

.brand-logo {
    text-align: center;
    margin-bottom: 40px;
}

.brand-logo span {
    font-size: 28px;
    font-weight: 600;
    letter-spacing: -0.5px;
    background: linear-gradient(135deg, #1d1d1f 0%, #3a3a3c 100%);
    -webkit-background-clip: text;
    background-clip: text;
    color: transparent;
}

h3 {
    font-size: 34px;
    font-weight: 600;
    letter-spacing: -0.5px;
    color: #1d1d1f;
    text-align: center;
    margin-bottom: 8px;
}

.subhead {
    text-align: center;
    color: #86868b;
    font-size: 17px;
    margin-bottom: 40px;
    font-weight: 400;
}

.form-group {
    margin-bottom: 20px;
}

label {
    display: block;
    font-size: 14px;
    font-weight: 500;
    color: #1d1d1f;
    margin-bottom: 6px;
}

input, select {
    width: 100%;
    padding: 14px 16px;
    border: 1px solid #d2d2d6;
    border-radius: 12px;
    font-size: 17px;
    font-family: inherit;
    background: #ffffff;
    transition: all 0.2s ease;
    color: #1d1d1f;
}

input:focus, select:focus {
    outline: none;
    border-color: #0071e3;
    box-shadow: 0 0 0 4px rgba(0, 113, 227, 0.08);
}

.password-container {
    position: relative;
}

.password-container input {
    padding-right: 80px;
}

.eye-toggle {
    position: absolute;
    right: 16px;
    top: 50%;
    transform: translateY(-50%);
    font-size: 15px;
    font-weight: 500;
    color: #0071e3;
    cursor: pointer;
    background: none;
    border: none;
}

.btn {
    width: 100%;
    background: #0071e3;
    border: none;
    border-radius: 980px;
    padding: 14px 24px;
    font-size: 17px;
    font-weight: 500;
    color: white;
    cursor: pointer;
    margin-top: 20px;
    transition: all 0.2s ease;
}

.btn:hover {
    background: #0077ed;
    transform: scale(0.98);
}

.toggle-link {
    text-align: center;
    margin-top: 28px;
    font-size: 15px;
    color: #0071e3;
    cursor: pointer;
    font-weight: 500;
}

.msg, .success-msg {
    padding: 14px 18px;
    border-radius: 12px;
    margin-bottom: 24px;
    text-align: center;
    font-size: 14px;
}

.msg {
    background: #fef2f2;
    border: 1px solid #fecaca;
    color: #dc2626;
}

.success-msg {
    background: #ecfdf5;
    border: 1px solid #a7f3d0;
    color: #059669;
}

.hints {
    margin-top: 8px;
    font-size: 12px;
    color: #86868b;
}

hr {
    margin: 28px 0 20px;
    border: none;
    border-top: 0.5px solid #d2d2d6;
}

.guest-text {
    text-align: center;
    font-size: 14px;
    color: #86868b;
}

@media (max-width: 480px) {
    .auth-container {
        padding: 32px 24px;
        margin: 16px;
    }
    h3 {
        font-size: 28px;
    }
}
</style>
<script>
    function toggleForms() {
        var loginForm = document.getElementById("login-form");
        var regForm = document.getElementById("register-form");
        var title = document.getElementById("form-title");
        var subhead = document.getElementById("form-subhead");
        if (loginForm.style.display === "none") {
            loginForm.style.display = "block";
            regForm.style.display = "none";
            title.innerText = "Sign in";
            subhead.innerText = "Access your account";
        } else {
            loginForm.style.display = "none";
            regForm.style.display = "block";
            title.innerText = "Create your account";
            subhead.innerText = "Get started with Myntra Clone";
        }
    }
    function togglePasswordVisibility(fieldId, toggleElement) {
        var passwordField = document.getElementById(fieldId);
        if (passwordField.type === "password") {
            passwordField.type = "text";
            toggleElement.innerText = "Hide";
        } else {
            passwordField.type = "password";
            toggleElement.innerText = "Show";
        }
    }
    function onlyNumbersAllowed(event) {
        var charCode = (event.which) ? event.which : event.keyCode;
        if (charCode > 31 && (charCode < 48 || charCode > 57)) {
            event.preventDefault();
            return false;
        }
        return true;
    }
    function validateRegistrationForm() {
        var phone = document.getElementById("reg-phone").value;
        if (phone.length !== 10) {
            alert("Please enter a valid 10-digit mobile number.");
            return false;
        }
        var password = document.getElementById("reg-password").value;
        var lengthValid = password.length >= 8;
        var numbersMatch = password.match(/\d/g);
        var numbersValid = numbersMatch != null && numbersMatch.length >= 2;
        var specialCharMatch = password.match(/[^a-zA-Z0-9]/g);
        var specialValid = specialCharMatch != null && specialCharMatch.length >= 1;
        if (!lengthValid || !numbersValid || !specialValid) {
            alert("Password must be at least 8 characters, contain 2 numbers, and 1 special character.");
            return false;
        }
        return true;
    }
</script>
</head>
<body>
<div class="auth-container">
    <div class="brand-logo">
        <span>Myntra Clone</span>
    </div>
    <h3 id="form-title">Sign in</h3>
    <div class="subhead" id="form-subhead">Access your account</div>

    <%
    String error = (String) request.getAttribute("error");
    if (error != null) {
        String msgClass = "msg";
        if (error.contains("successful")) {
            msgClass = "success-msg";
        }
    %>
    <div class="<%=msgClass%>"><%=error%></div>
    <%
    }
    %>

    <!-- LOGIN FORM -->
    <form id="login-form" action="AuthController" method="POST" autocomplete="off">
        <input type="hidden" name="action" value="login">
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" required placeholder="your@email.com">
        </div>
        <div class="form-group">
            <label>Password</label>
            <div class="password-container">
                <input type="password" name="password" id="login-password" required placeholder="Password">
                <button type="button" class="eye-toggle" onclick="togglePasswordVisibility('login-password', this)">Show</button>
            </div>
        </div>
        <div class="form-group">
            <label>Login as</label>
            <select name="role">
                <option value="Customer">Customer</option>
                <option value="Admin">Administrator</option>
            </select>
        </div>
        <button type="submit" class="btn">Sign in →</button>
        <div class="toggle-link" onclick="toggleForms()">Don't have an account? Create one →</div>
    </form>

    <!-- REGISTER FORM -->
    <form id="register-form" action="AuthController" method="POST" style="display: none;" onsubmit="return validateRegistrationForm();" autocomplete="off">
        <input type="hidden" name="action" value="register">
        <div class="form-group">
            <label>Full name</label>
            <input type="text" name="name" required placeholder="John Appleseed">
        </div>
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" required placeholder="your@email.com">
        </div>
        <div class="form-group">
            <label>Password</label>
            <div class="password-container">
                <input type="password" name="password" id="reg-password" required placeholder="Create a password">
                <button type="button" class="eye-toggle" onclick="togglePasswordVisibility('reg-password', this)">Show</button>
            </div>
            <div class="hints">8+ characters, 2+ numbers, 1+ symbol</div>
        </div>
        <div class="form-group">
            <label>Mobile number</label>
            <input type="text" id="reg-phone" name="phone" maxlength="10" required placeholder="10-digit mobile" onkeypress="return onlyNumbersAllowed(event)" pattern="[0-9]{10}">
        </div>
        <div class="form-group">
            <label>Shipping address</label>
            <input type="text" name="address" required placeholder="Street, city, pincode">
        </div>
        <div class="form-group">
            <label>Register as</label>
            <select name="role" required>
                <option value="Customer">Customer</option>
                <option value="Admin">Administrator</option>
            </select>
        </div>
        <button type="submit" class="btn">Create account →</button>
        <div class="toggle-link" onclick="toggleForms()">Already have an account? Sign in →</div>
    </form>
</div>
</body>
</html>