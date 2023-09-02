package com.example.login_form.controller;

import com.example.login_form.db.UserDAO;
import com.example.login_form.model.User;

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

import static com.example.login_form.db.UserDAO.QUERY;


@WebServlet("/")
public class UserServlet extends HttpServlet {

    UserDAO userDAO=new UserDAO();


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                case "/login":
                    login(request, response);
                    break;
                case "/register":
                   register(request, response);
                    break;

                case "/user":
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }




    }

    private void listUser (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<User> users = new ArrayList<>();

        try {
            Connection conn = UserDAO.createConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(username, password);
                users.add(user);
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exceptions
        }

        request.setAttribute("users", users);
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //        // TODO
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        // TODO
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User newUser = new User(username, password);
        userDAO.insert(newUser);

        response.sendRedirect("list"); // Redirect to the user list page
    }


    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String username = request.getParameter("username");
        String newPassword = request.getParameter("newPassword");

        userDAO.updatePassword(username, newPassword);

        response.sendRedirect("list"); // Redirect to the user list page
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String username = request.getParameter("username");

        userDAO.deleteUser(username);

        response.sendRedirect("list"); // Redirect to the user list page
    }
    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
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

        return UserDAO.login(username, password);
    }

    private void register (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
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
