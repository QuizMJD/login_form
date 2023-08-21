<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Login</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action="login" method="post">--%>
<%--    <label for="username">Username:</label>--%>
<%--    <input type="text" id="username" name="username"><br>--%>

<%--    <label for="password">Password:</label>--%>
<%--    <input type="password" id="password" name="password"><br>--%>

<%--    <input type="submit" value="Login">--%>
<%--    <p><a href="register.jsp">đăng ký</a></p>--%>
<%--</form>--%>

<%--&lt;%&ndash; Hiển thị thông báo lỗi nếu có &ndash;%&gt;--%>
<%--<c:if test="${not empty errorMessage}">--%>
<%--    <p>${errorMessage}</p>--%>
<%--</c:if>--%>
<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <style>
       body {
           font-family: Arial, sans-serif;
           background-color: #f0f0f0;
           display: flex;
           justify-content: center;
           align-items: center;
           height: 100vh;
           margin: 0;
       }

       .container {
           background-color: #fff;
           border-radius: 8px;
           box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
           padding: 20px;
           width: 320px;
       }

       .login-form {
           text-align: center;
       }

       .login-form h2 {
           margin-bottom: 20px;
           color: #333;
       }

       .form-group {
           margin-bottom: 15px;
       }

       .form-group label {
           display: block;
           margin-bottom: 5px;
           color: #666;
       }

       .form-group input {
           width: 100%;
           padding: 10px;
           border: 1px solid #ccc;
           border-radius: 4px;
           font-size: 14px;
       }

       button[type="submit"] {
           background-color: #007bff;
           color: #fff;
           border: none;
           border-radius: 4px;
           padding: 10px 20px;
           font-size: 14px;
           cursor: pointer;
           transition: background-color 0.3s ease;
       }

       button[type="submit"]:hover {
           background-color: #0056b3;
       }
   </style>
    <title>Login</title>
</head>
<body>
<div class="container">
    <%--<form action="login" method="post">--%>
    <form class="login-form" action="login" method="post">>
        <h2>Login</h2>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" placeholder="Enter your username" >
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" >
        </div>
        <button type="submit">Login</button>
        <p><a href="register.jsp">đăng ký</a></p>>
        <%-- Hiển thị thông báo lỗi nếu có --%>
        <c:if test="${not empty errorMessage}">
            <p>${errorMessage}</p>
        </c:if>
    </form>
</div>
</body>
</html>
