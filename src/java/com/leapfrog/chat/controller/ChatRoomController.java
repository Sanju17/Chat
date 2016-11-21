/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.controller;

import com.leapfrog.chat.commonconsts.CommonConsts;
import com.leapfrog.chat.dao.ChatroomDao;
import com.leapfrog.chat.dao.impl.ChatroomDaoImpl;
import com.leapfrog.chat.entity.Chatroom;
import com.leapfrog.chat.system.Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cSangharsha
 */
@WebServlet(name = "chatRoomController", urlPatterns = "/chatroom/*")
public class ChatRoomController extends Controller{

    ChatroomDao chatroomDao = new ChatroomDaoImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = "chatroom/create.jsp";
        
        HttpSession session = req.getSession(false);
        req.setAttribute("firstname", session.getAttribute("firstname"));
        req.setAttribute("lastname", session.getAttribute("lastname"));
        
        if(req.getRequestURI().contains("/join")){
            page = "chatroom/join.jsp";
        }
        req.getRequestDispatcher(CommonConsts.PATH + page).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if(type.equalsIgnoreCase("create")){
            String portNumber = req.getParameter("port_num");
            try{
                PrintWriter out = resp.getWriter();
                ServerSocket serverSocket = new ServerSocket(Integer.parseInt(portNumber));

                Chatroom chatroom = new Chatroom();
                chatroom.setHostAddress(req.getRemoteAddr());
                chatroom.setPort(portNumber);
                chatroomDao.insert(chatroom);
                while(true){
                    Socket client = serverSocket.accept();
                    out.println(client.getInetAddress().getHostAddress() + " has joined this chat room.");
                }
            }catch(IOException | ClassNotFoundException | SQLException ex){
                PrintWriter out = resp.getWriter();
                out.println(ex.getMessage());
            }
        }else {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec("telnet " + req.getAttribute("ipaddress") + " "+ req.getAttribute("port_num"));
        }
    }
}