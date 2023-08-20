package com.example.login_form.db;

import java.sql.*;

public class JdbcConnection {
     // Method to create the connection and set up database resources
    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "123456");
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
        String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
        insertStatement.setString(1, username);
        insertStatement.setString(2, password);
        int rowsInserted = insertStatement.executeUpdate();
        return rowsInserted > 0; // Trả về true nếu có ít nhất một bản ghi được chèn
    }

    // Method to update the name of a brand based on its ID
    private static int updateBrandName(Connection conn, int id, String newName) throws SQLException {
        String updateQuery = "UPDATE users SET name = ? WHERE id = ?";
        PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
        updateStatement.setString(1, newName);
        updateStatement.setInt(2, id);
        return updateStatement.executeUpdate();
    }

    // Method to delete a brand based on its ID
    private static int deleteBrandById(Connection conn, int id) throws SQLException {
        String deleteQuery = "DELETE FROM users WHERE id = ?";
        PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
        deleteStatement.setInt(1, id);
        return deleteStatement.executeUpdate();
    }

    // Method to search for a brand by its name
    private static void searchBrandByName(Connection conn, String searchKeyword) throws SQLException {
        String searchQuery = "SELECT * FROM users WHERE name LIKE ?";
        PreparedStatement searchStatement = conn.prepareStatement(searchQuery);
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, null, null);
        }
        return status;

    }
}
//
