/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.dao;

import com.leapfrog.chat.entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Owner
 */
public interface UserDAO {
    List<User> getAll() throws ClassNotFoundException, SQLException;
    User getUserById(int id) throws ClassNotFoundException, SQLException;
    User getUserByUsername(String username, String password) throws ClassNotFoundException, SQLException;
    boolean isUserAvailabile(String username) throws ClassNotFoundException, SQLException;
    int insert(User u) throws ClassNotFoundException, SQLException;
}
