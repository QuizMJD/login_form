<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.example.login_form.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!-- Replace "your.package" with the actual package name of the User class -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Information List</title>
</head>
<body>
<h1>Account Information List</h1>
<a class="link" href="account-info-list.jsp">Quản lý tài khoản</a>
<table class="account-info-list">
    <%
        List<User> currentUsers = (List<User>) request.getAttribute("users");
        if (currentUsers != null && !currentUsers.isEmpty()) {
            for (User currentUser : currentUsers) {
    %>
    <tr>
        <td><%= currentUser.getUsername() %></td>
        <td><%= currentUser.getPassword() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2">No users found.</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>