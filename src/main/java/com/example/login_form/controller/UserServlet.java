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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getContextPath();

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
               
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }




//        List<User> users = new ArrayList<>();
//
//        try {
//            Connection conn = UserDAO.createConnection();
//            Statement statement = conn.createStatement();
//            String query = "SELECT username, password FROM users";
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//                String username = resultSet.getString("username");
//                String password = resultSet.getString("password");
//                User user = new User(username, password);
//                users.add(user);
//            }
//
//            conn.close();
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//            // Handle exceptions
//        }
//
//        request.setAttribute("users", users);
//        request.getRequestDispatcher("home.jsp").forward(request, response);
//    }


//    private void  users_list (HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//
//        request.setAttribute("users", users);
//        request.getRequestDispatcher("users.jsp").forward(request, response);
//
//
//        // TODO
    }

    private void listUser (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<User> users = new ArrayList<>();

        try {
            Connection conn = UserDAO.createConnection();
            Statement statement = conn.createStatement();
//            String query = "SELECT username, password FROM users";
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
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        // TODO
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        // TODO
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        // TODO
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        // TODO
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
            request.getRequestDispatcher("home.jsp").forward(request, response);

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
            throws SQLException, IOException {
        // TODO
    }

}