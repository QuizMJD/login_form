package com.example.login_form.controller;

import com.example.login_form.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = new ArrayList<>();
        userList.add(new User("user1", "password1"));
        userList.add(new User("user2", "password2"));
// Thêm các đối tượng User khác vào danh sách

        request.setAttribute("userList", userList);
        request.getRequestDispatcher("account-info-list.jsp").forward(request, response);
    }
}
