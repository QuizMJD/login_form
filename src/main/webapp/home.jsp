<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 40px;
            width: 400px;
            text-align: center;
        }

        h1 {
            margin-top: 0;
        }

        .link {
            text-decoration: none;
            color: #007bff;
            margin-top: 10px;
            display: block;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Trang đăng nhập</h1>
    <!-- Biểu mẫu đăng nhập ở đây -->
    <a class="link" href="users.jsp">Quản lý tài khoản</a>

    <a class="link" href="login.jsp">Quay lại trang chủ</a>
</div>
</body>
</html>

