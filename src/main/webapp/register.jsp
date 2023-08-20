<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 20/08/2023
  Time: 11:10 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>register</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action="register" method="post">--%>
<%--    <label for="username">Username:</label>--%>
<%--    <input type="text" id="username" name="username"><br>--%>

<%--    <label for="password">Password:</label>--%>
<%--    <input type="password" id="password" name="password"><br>--%>
<%--    <label for="password">confirm password:</label>--%>
<%--    <input type="password" id="confirm_password" name="confirm_password"><br>--%>


<%--    <input type="submit" value="register">--%>
<%--</form>--%>


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

        .registration-form {
            text-align: center;
        }

        .registration-form h2 {
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
    <title>Registration</title>
</head>
<body>
<div class="container">
    <%--<form action="register" method="post">--%>
    <form class="registration-form" action="register" method="post">>
        <h2>Registration</h2>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" placeholder="Enter your username" >
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter your password">
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password</label>
            <input type="password" id="confirm_password" name="confirm_password" placeholder="Confirm your password" >
        </div>
        <button type="submit">Register</button>
<c:if test="${not empty errorMessage}">
        <p>${errorMessage}</p>
    </c:if>

    </form>
</div>
</body>
</html>
