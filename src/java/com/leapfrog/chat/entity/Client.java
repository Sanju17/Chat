/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.entity;

import java.net.Socket;

/**
 *
 * @author Owner
 */
public class Client {
    private int userID;
    private String userName;
    private Socket socket;

    public Client() {
    }
    
    public Client(int userID, Socket socket) {
        this.userID = userID;
        this.socket = socket;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
