package com.yjh.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("yjh".equals(username) && "111".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            session.setMaxInactiveInterval(10);
            req.getRequestDispatcher("index").forward(req, resp);
        } else {
            resp.sendRedirect("fail.jsp");
        }
    }
}
