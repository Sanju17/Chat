/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.dao.impl;

import com.leapfrog.chat.dao.UserDAO;
import com.leapfrog.chat.db.DBConnection;
import com.leapfrog.chat.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Owner
 */
public class UserDAOImpl implements UserDAO{

    DBConnection dbConnection = new DBConnection();
    
    @Override
    public List<User> getAll() throws ClassNotFoundException, SQLException{
        List<User> userList = new ArrayList<>();
        dbConnection.open();
        String sql = "SELECT * FROM user";
        dbConnection.initStatement(sql);
        ResultSet rs = dbConnection.executeQuery();
        while(!rs.next()){
           User user = new User();
           user.setId(rs.getInt("user_id"));
           user.setFirstName(rs.getString("firstname"));
           user.setLastName(rs.getString("last_name"));
           user.setUsername(rs.getString("username"));
           user.setPassword(rs.getString("password"));
           user.setIsActive(rs.getBoolean("status"));
           user.setIsAdmin(rs.getBoolean("is_Admin"));
           
           userList.add(user);
        }
        dbConnection.close();
        return userList;
    }

    @Override
    public User getUserById(int id) throws ClassNotFoundException, SQLException{
        dbConnection.open();
        String sql = "SELECT * FROM user WHERE user_id = ?";
        
        PreparedStatement stmt = dbConnection.initStatement(sql);
        stmt.setString(1, String.valueOf(id));
        
        ResultSet rs = dbConnection.executeQuery();
        
        User user = new User();
        while(!rs.next()){
           user.setId(rs.getInt("user_id"));
           user.setFirstName(rs.getString("firstname"));
           user.setLastName(rs.getString("last_name"));
           user.setUsername(rs.getString("username"));
           user.setPassword(rs.getString("password"));
           user.setIsActive(rs.getBoolean("status"));
           user.setIsAdmin(rs.getBoolean("is_Admin"));
        }
        dbConnection.close();
        return user;
    }

    @Override
    public int insert(User u) throws ClassNotFoundException, SQLException{
        
        dbConnection.open();
        String sql = "INSERT INTO user(firstname, last_name, username, password, status, is_admin) "
                     + "values (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = dbConnection.initStatement(sql);
        stmt.setString(1, u.getFirstName());
        stmt.setString(2, u.getLastName());
        stmt.setString(3, u.getUsername());
        stmt.setString(4, u.getPassword());
        stmt.setBoolean(5, u.isIsActive());
        stmt.setBoolean(6, u.isIsAdmin());
        
        int result = dbConnection.executeUpdate();
    
        dbConnection.close();
        return result;
    }

    @Override
    public User getUserByUsername(String username, String password) throws ClassNotFoundException, SQLException {
        dbConnection.open();
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        
        PreparedStatement stmt = dbConnection.initStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        
        ResultSet rs = dbConnection.executeQuery();
        
        User user = new User();
        while(rs.next()){
           user.setId(rs.getInt("user_id"));
           user.setFirstName(rs.getString("firstname"));
           user.setLastName(rs.getString("last_name"));
           user.setUsername(rs.getString("username"));
           user.setPassword(rs.getString("password"));
           user.setIsActive(rs.getBoolean("status"));
           user.setIsAdmin(rs.getBoolean("is_Admin"));
        }
        dbConnection.close();
        return user;
    }
    
}
