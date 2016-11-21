/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.listener;

import com.leapfrog.chat.dao.UserDAO;
import com.leapfrog.chat.dao.impl.UserDAOImpl;
import com.leapfrog.chat.entity.Client;
import com.leapfrog.chat.entity.ClientHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author ruman dangol
 */
public class ClientListener extends Thread {

    private UserDAO userDao = new UserDAOImpl();
    private ClientHandler handler;

    private Socket socket;
    private PrintStream ps;
    private BufferedReader reader;
    private Client client;
    private int feature;

    public ClientListener(Socket socket, ClientHandler handler, int feature) throws IOException {
        this.feature = feature;
        this.socket = socket;
        this.handler = handler;
        ps = new PrintStream(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
       
    }

}