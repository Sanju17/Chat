/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.dao;

import com.leapfrog.chat.entity.Chatroom;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author cSangharsha
 */
public interface ChatroomDao {
    List<Chatroom> getAll() throws ClassNotFoundException, SQLException;
    Chatroom getChatroomById() throws ClassNotFoundException, SQLException;
    int insert(Chatroom chatroom) throws ClassNotFoundException, SQLException;
    int delete(int id) throws ClassNotFoundException, SQLException;
}
