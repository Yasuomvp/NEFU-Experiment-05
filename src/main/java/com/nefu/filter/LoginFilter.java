package com.nefu.filter;

import com.nefu.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/welcome"})
public class LoginFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        User bobo =(User) req.getSession().getAttribute("BOBO");
        if(bobo!=null && bobo.equals(new User(null,"BOBO","666666"))){
            chain.doFilter(req,resp);
        }
        req.getRequestDispatcher("/login").forward(req,resp);
    }
}
