<%--<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>--%>
<%--<%@ page import="com.example.login_form.model.User" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>
<%--<%@ page import="com.example.login_form.controller.UserServlet" %>--%>
<%--<!-- Replace "your.package" with the actual package name of the User class -->--%>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>Account Information List</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Account Information List</h1>--%>
<%--<table class="users">--%>
<%--    <%--%>
<%--        List<User> currentUsers = (List<User>) request.getAttribute("users");--%>
<%--        if (currentUsers != null && !currentUsers.isEmpty()) {--%>
<%--            for (User currentUser : currentUsers) {--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td><%= currentUser.getUsername() %></td>--%>
<%--        <td><%= currentUser.getPassword() %></td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        }--%>
<%--    } else {--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td colspan="2">No users found.</td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Information List</title>
</head>
<body>
<h1>Account Information List</h1>
<table class="users">
    <c:if test="${not empty users}">
        <tr>
            <th>Username</th>
            <th>Password</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${empty users}">
        <tr>
            <td colspan="2">No users found.</td>
        </tr>
    </c:if>
</table>
</body>
</html>