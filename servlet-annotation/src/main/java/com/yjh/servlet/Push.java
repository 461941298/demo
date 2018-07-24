package com.yjh.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/push")
//@MultipartConfig
public class Push extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        String name = part.getHeader("content-disposition");
        String suffer = name.substring(name.lastIndexOf('.'), name.length() - 1);
        System.out.println(suffer);
        part.write("/home/yjh/111" + suffer);

    }


}
