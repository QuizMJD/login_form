<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
            width: 600px;
        }

        .user-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        .user-table th,
        .user-table td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: center;
        }

        .edit-button,
        .delete-button {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            padding: 5px 10px;
            font-size: 12px;
            cursor: pointer;
            margin-right: 5px;
        }

        .edit-button:hover,
        .delete-button:hover {
            background-color: #0056b3;
        }

    </style>
    <title>User List</title>
</head>
<body>
<div class="container">
    <h2>User List</h2>

    <div class="information">
        <input type="text" id="search" name="search" placeholder="Search..." action="search" method="post">
        <button type="button" id="searchButton">Search</button>
    </div>
    <table class="user-table" action="information" method="get">
        <tr>
            <th><p><strong>Username:</strong></p></th>
            <th> <p><strong>Password:</strong></p></th>
            <th> <p><em>Action</em></p></th>
        </tr>
        <tr>
            <td>user1</td>
            <td>password1</td>
            <td>
                <button class="edit-button">Edit</button>
                <button class="delete-button">Delete</button>
            </td>
        </tr>
        <tr>
            <td>user2</td>
            <td>password2</td>
            <td>
                <button class="edit-button">Edit</button>
                <button class="delete-button">Delete</button>
            </td>
        </tr>
        <!-- Add more rows as needed -->
    </table>
</div>
</body>
</html>

