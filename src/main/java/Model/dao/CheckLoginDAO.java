package Model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.bean.Admin;
public class CheckLoginDAO{
    public boolean isExistUser(String username, String password) throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DATA", "root", "");
            Statement sm = conn.createStatement();
            String sql = "SELECT * FROM myData";
            ResultSet rs = sm.executeQuery(sql);
            while(rs.next()) {
                if(username.equals(rs.getString(1))&&password.equals(rs.getString(2))) {
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Admin getAdmin(String username, String password) throws ClassNotFoundException, SQLException {
        Admin admin = null;
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Use try-with-resources to ensure resources are properly closed
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DATA", "root", "");
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM myData WHERE username = ? AND password = ?")) {

            // Set parameters for the query
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute the query and process the result set
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    admin = new Admin();
                    admin.setUsername(resultSet.getString("username"));
                    admin.setPassword(resultSet.getString("password"));
                }
            }
        }
        catch (SQLException e) {
            throw new SQLException("Lỗi kết nối cơ sở dữ liệu", e);
        }
        return admin;
    }

}