/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Owner
 */
public class DBConnection {
    
    Connection conn;
    private PreparedStatement stmt;
    
    public void open() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/lfa_chat", "root",null);
    }
    
    public PreparedStatement initStatement(String sql) throws SQLException{
        stmt = conn.prepareStatement(sql);
        return stmt;
    }
    
    public ResultSet executeQuery() throws SQLException{
        return stmt.executeQuery();
    }
    
    public int executeUpdate() throws SQLException{
        return stmt.executeUpdate();
    }
    
    public void close() throws SQLException{
        if(conn != null && !conn.isClosed()){
            conn.close();
        }
    }
    
}
