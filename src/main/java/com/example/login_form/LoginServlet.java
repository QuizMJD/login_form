package com.example.login_form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Thực hiện kiểm tra đăng nhập trong cơ sở dữ liệu
        boolean isValidUser = validateUser(username, password);

        if (isValidUser) {
            // Đăng nhập thành công, chuyển hướng đến trang chính
            response.sendRedirect("home.jsp");
        } else {
            // Đăng nhập thất bại, chuyển hướng đến trang đăng nhập với thông báo lỗi
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private boolean validateUser(String username, String password) {
        // Thực hiện truy vấn đến cơ sở dữ liệu để kiểm tra thông tin đăng nhập
        // Trả về true nếu thông tin đúng, false nếu thông tin sai
        // Ví dụ sử dụng JDBC để truy vấn cơ sở dữ liệu
        // Đây chỉ là ví dụ, bạn cần thay thế bằng mã xử lý thực tế
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Tạo kết nối đến cơ sở dữ liệu
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "123456");

            // Tạo truy vấn kiểm tra thông tin đăng nhập
            String query = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            // Thực thi truy vấn
            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng các kết nối và tài nguyên
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
