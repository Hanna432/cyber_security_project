/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import sec.project.domain.Signup;

/**
 *
 * @author Hanna
 */
public class UserDao {
    public void save(String username, String password) throws SQLException{
        try (Connection c = DriverManager.getConnection("jdbc:h2:file:./database", "sa", "")) {
            String sql = "INSERT INTO User VALUES ('" + username + "', '" + password + "')";
            c.createStatement().executeUpdate(sql);

            c.close();
        }
    }
    
    public Signup read(String username) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:h2:file:./database", "sa", "")) {
            String sql = "SELECT * FROM User WHERE username = '" + username + "'";
            ResultSet rs = c.createStatement().executeQuery(sql);

            String u = "";
            String p = "";

            while(rs.next()) {
                u = rs.getString("username");
                p = rs.getString("password");
            }

            c.close();
            
            if (u.equals("")) {
                return null;
            }
            return new Signup(u, p);
        }
    }
}
