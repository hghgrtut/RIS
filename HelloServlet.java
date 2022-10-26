package com.example.lab5.servlet;

import java.io.*;
import javax.servlet.http.*;


/**
 * The type Hello servlet.
 */
public class HelloServlet extends HttpServlet {

    private String message;

    @Override
    public void init() {
        message = "Hello Servlet!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
}