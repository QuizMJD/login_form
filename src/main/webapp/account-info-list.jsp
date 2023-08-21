<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 21/08/2023
  Time: 12:19 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Information List</title>
</head>
<body>
<h1>Account Information List</h1>
<table class="account-info-list" action="account-info-list" method="get">
    <tr>
        <th>Username</th>
        <th>Password</th>
    </tr>
    <% List<String> usernames = (List<String>) request.getAttribute("usernames"); %>
    <c:forEach items="${usernames}" var="username" varStatus="loop">
        <tr>
            <td>${username}</td>
            <td>${passwords[loop.index]}</td> <!-- Displaying passwords directly is not recommended -->
        </tr>
    </c:forEach>
</table>
</body>
</html>

