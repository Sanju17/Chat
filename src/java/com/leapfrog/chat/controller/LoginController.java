/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.controller;

import com.leapfrog.chat.commonconsts.CommonConsts;
import com.leapfrog.chat.dao.UserDAO;
import com.leapfrog.chat.dao.impl.UserDAOImpl;
import com.leapfrog.chat.entity.User;
import com.leapfrog.chat.system.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Owner
 */
@WebServlet(name = "loginController", urlPatterns = {"/", "/login/*"} )
public class LoginController extends Controller{
    
    UserDAO userDao = new UserDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(CommonConsts.PATH + "login/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        PrintWriter out = resp.getWriter();
        if(type.equals("login")){
            String username = (String) req.getParameter("username");
            String password = (String) req.getParameter("password");
            //retrieve from database
            User user;
            try {
                user = userDao.getUserByUsername(username, password);
                if(user != null && user.getFirstName() != null){
                    HttpSession session = req.getSession(true);
                    session.setAttribute("firstName", user.getFirstName());
                    session.setAttribute("lastName", user.getLastName());
                    session.setAttribute("userName", user.getUsername());
                    resp.sendRedirect(req.getContextPath() + "/profile");
                }else {
                    resp.sendRedirect(req.getContextPath() + "/login?error");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                out.println(ex.getMessage());
            }
        }else if(type.equals("register")){
            String firstName = req.getParameter("firstname");
            String lastName = req.getParameter("lastname");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String confirmPassword = req.getParameter("confirmPassword");
            if(!password.equals(confirmPassword)){
                req.setAttribute("firstname", firstName);
                req.setAttribute("lastname", lastName);
                req.setAttribute("username", username);
                req.setAttribute("error", "Password didn't match");
                req.getRequestDispatcher(CommonConsts.PATH + "login/login.jsp").forward(req, resp);
            }
        }
    }
}
