/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.entity;

/**
 *
 * @author cSangharsha
 */
public class Chatroom {
    private int id;
    private String hostAddress;
    private String port;

    public Chatroom() {
    }

    public Chatroom(int id, String hostAddress, String port) {
        this.id = id;
        this.hostAddress = hostAddress;
        this.port = port;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    
    
}
