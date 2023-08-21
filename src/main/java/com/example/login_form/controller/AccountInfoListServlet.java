package com.example.login_form.controller;

import com.example.login_form.db.JdbcConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/account-info-list")
public class AccountInfoListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> usernames = new ArrayList<>();
        List<String> passwords = new ArrayList<>();

        try {
            Connection conn = JdbcConnection.createConnection();
            Statement statement = conn.createStatement();
            String query = "SELECT username, password FROM users";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                usernames.add(username);
                passwords.add(password); // Note: Displaying passwords directly is not recommended
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exceptions
        }

        request.setAttribute("usernames", usernames);
        request.setAttribute("passwords", passwords);

        request.getRequestDispatcher("/account-info-list.jsp").forward(request, response);
    }
}
