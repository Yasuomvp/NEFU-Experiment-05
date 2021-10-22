package com.nefu.controller;

import com.nefu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login",loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equals("BOBO") && password.equals("666666")){
            req.getSession().setAttribute("BOBO",new User(null,username,password));
            req.getRequestDispatcher("/WEB-INF/jsp/welcome.html").forward(req,resp);
        }else {
            req.getRequestDispatcher("/WEB-INF/jsp/login.html").forward(req,resp);
        }
    }
}
