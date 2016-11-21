/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.dao.impl;

import com.leapfrog.chat.dao.ChatroomDao;
import com.leapfrog.chat.db.DBConnection;
import com.leapfrog.chat.entity.Chatroom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cSangharsha
 */
public class ChatroomDaoImpl implements ChatroomDao{
    
    DBConnection dbConnection = new DBConnection();
    
    @Override
    public List<Chatroom> getAll() throws ClassNotFoundException, SQLException {
        List<Chatroom> chatrooms = new ArrayList<>();
        dbConnection.open();
        String sql = "SELECT * FROM chatroom";
        dbConnection.initStatement(sql);
        ResultSet rs = dbConnection.executeQuery();
        while(rs.next()){
            Chatroom chatroom = new Chatroom();
            chatroom.setId(rs.getInt("chatroom_id"));
            chatroom.setHostAddress(rs.getString("host_address"));
            chatroom.setPort(rs.getString("port"));
            chatrooms.add(chatroom);
        }
        dbConnection.close();
        return chatrooms;
    }

    @Override
    public Chatroom getChatroomById() throws ClassNotFoundException, SQLException {
        dbConnection.open();
        String sql = "SELECT * FROM chatroom";
        dbConnection.initStatement(sql);
        ResultSet rs = dbConnection.executeQuery();
        
        Chatroom chatroom = new Chatroom();
        while(rs.next()){
            chatroom.setId(rs.getInt("chatroom_id"));
            chatroom.setHostAddress(rs.getString("host_address"));
            chatroom.setPort(rs.getString("port"));
        }
        dbConnection.close();
        return chatroom;
    }

    @Override
    public int insert(Chatroom chatroom) throws ClassNotFoundException, SQLException {
        dbConnection.open();
        String sql = "INSERT INTO chatroom(host_address, port)"
                + " VALUES(? ,?)";
        PreparedStatement stmt = dbConnection.initStatement(sql);
        stmt.setString(1, chatroom.getHostAddress());
        stmt.setString(2, chatroom.getPort());
        int result = dbConnection.executeUpdate();
        
        dbConnection.close();
        return result;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        dbConnection.open();
        String sql = "DELETE FROM chatroom WHERE chatroom_id = ?";
        PreparedStatement stmt = dbConnection.initStatement(sql);
        stmt.setString(1, String.valueOf(id));
        int result = dbConnection.executeUpdate();
        
        dbConnection.close();
        return result;
    }
    
    
}
