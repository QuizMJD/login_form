package com.example.login_form.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.login_form.db.JdbcConnection;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Thực hiện kiểm tra đăng nhập trong cơ sở dữ liệu
        boolean isValidUser = false;
        try {
            isValidUser = validateUser(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (isValidUser) {
            // Đăng nhập thành công, chuyển hướng đến trang chính
            response.sendRedirect("home.jsp");
        } else {
            // Đăng nhập thất bại, chuyển hướng đến trang đăng nhập với thông báo lỗi
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }





    }

    private boolean validateUser (String username, String password) throws SQLException {
        // Thực hiện truy vấn đến cơ sở dữ liệu để kiểm tra thông tin đăng nhập
        // Trả về true nếu thông tin đúng, false nếu thông tin sai
        // Ví dụ sử dụng JDBC để truy vấn cơ sở dữ liệu
        // Đây chỉ là ví dụ, bạn cần thay thế bằng mã xử lý thực tế

        JdbcConnection jdbcConnection = new JdbcConnection();
        return jdbcConnection.login(username, password);
    }



}

