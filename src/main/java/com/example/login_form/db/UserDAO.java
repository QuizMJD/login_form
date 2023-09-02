package com.example.login_form.db;

import com.example.login_form.model.User;

import java.sql.*;

public class UserDAO {
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String INSERT_QUERY = "INSERT INTO users (username, password) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE users SET username = ?, password = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id = ?";
    private static final String SEARCH_QUERY = "SELECT * FROM users WHERE name LIKE ?";
    private static final String SELECT_ALL = "select * from users where id =?";
    public static final String QUERY= "SELECT username, password FROM users";
//
    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String URL ="jdbc:mysql://localhost:3306/user_db";
    private static final String USERNAME ="root";
    private static final String PASS ="123456";





    // Method to create the connection and set up database resources
    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME,PASS);
    }

    // Method to close the connection and other resources
    private static void closeResources(Connection conn, Statement stm, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to insert a new brand into the database
    public static boolean insertUser(Connection conn, String username, String password) throws SQLException {

        PreparedStatement insertStatement = conn.prepareStatement(INSERT_QUERY);
        insertStatement.setString(1, username);
        insertStatement.setString(2, password);
        int rowsInserted = insertStatement.executeUpdate();
        return rowsInserted > 0; // Trả về true nếu có ít nhất một bản ghi được chèn
    }

    // Method to update the name of a brand based on its ID
    public boolean updateUser(Connection conn, int userId, String newUsername, String newPassword) {

        try (PreparedStatement updateStatement = conn.prepareStatement(UPDATE_QUERY)) {
            updateStatement.setString(1, newUsername);
            updateStatement.setString(2, newPassword);
            updateStatement.setInt(3, userId);
            int rowsUpdated = updateStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(Connection conn, int userId) {

        try (PreparedStatement deleteStatement = conn.prepareStatement(DELETE_QUERY)) {
            deleteStatement.setInt(1, userId);
            int rowsDeleted = deleteStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to search for a brand by its name
    private static void searchBrandByName(Connection conn, String searchKeyword) throws SQLException {

        PreparedStatement searchStatement = conn.prepareStatement(SEARCH_QUERY);
        searchStatement.setString(1, "%" + searchKeyword + "%");
        ResultSet rs = searchStatement.executeQuery();

        // Display search results
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println("ID: " + id + ", Name: " + name);
        }
    }
    public static boolean login(String username, String password) throws SQLException {
        Connection conn = null;
        boolean status = false;
        try {
            conn = createConnection();
            String searchQuery = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(searchQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            System.out.println(status);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, null, null);
        }
        return status;

    }

    public void deleteUser(String username) {
    }

    public void insert(User newUser) {
    }

    public void updatePassword(String username, String newPassword) {
    }
}
//
