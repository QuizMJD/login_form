//package com.example.login_form;
//
//import com.example.login_form.db.JdbcConnection;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//
//import static com.example.login_form.db.JdbcConnection.createConnection;
//
//@WebServlet("/register")
//public class Register extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String confirm_password = request.getParameter("confirm_password");
//
//        if (!password.equals(confirm_password)) {
//            request.setAttribute("errorMessage", "Passwords do not match");
//            request.getRequestDispatcher("register.jsp").forward(request, response);
//            return;
//        }
//
//        boolean isRegistrationSuccessful = false;
//        try {
//            isRegistrationSuccessful = registerUser(username, password);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        if (isRegistrationSuccessful) {
//            response.sendRedirect("login.jsp");
//        } else {
//            request.setAttribute("errorMessage", "Registration failed");
//            request.getRequestDispatcher("register.jsp").forward(request, response);
//        }
//    }
//
//    private boolean registerUser(String username, String password) throws SQLException {
//        JdbcConnection jdbcConnection = new JdbcConnection();
////        return jdbcConnection.insertUser(JdbcConnection.createConnection(), username, password);
//        return jdbcConnection.insertUser(username, password);
//   }
//}
//
//
package com.example.login_form.controller;

import com.example.login_form.db.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password").trim();
        String confirm_password = request.getParameter("confirm_password").trim();

        // Kiểm tra xem có trường nào bị bỏ trống hay không
        if (username.isEmpty() || password.isEmpty() || confirm_password.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        if (!password.equals(confirm_password)) {
            request.setAttribute("errorMessage", "Passwords do not match");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        boolean isRegistrationSuccessful = registerUser(username, password);

        if (isRegistrationSuccessful) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMessage", "Registration failed");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    private boolean registerUser(String username, String password) {
        try {
            UserDAO jdbcConnection = new UserDAO();
            Connection conn = jdbcConnection.createConnection(); // Tạo kết nối
            return jdbcConnection.insertUser(conn, username, password); // Truyền kết nối vào insertUser
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
