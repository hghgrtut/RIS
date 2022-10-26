package com.example.lab5.servlet;

import com.example.lab5.models.UserAccount;
import com.example.lab5.dao.DataDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * The type Login servlet.
 */
public class LoginServlet extends HttpServlet {

    /**
     * Do post.
     *
     * @param request the HttpServletRequest
     * @param response the HttpServletResponse
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        UserAccount userAccount = DataDAO.findUser(userName, password);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (userAccount == null) {
            String errorMessage = "Invalid userName or Password";
            out.println("<html><body>");
            out.println("<h1>" + errorMessage + "</h1>");
            out.println("</body></html>");
            return;
        }

        response.sendRedirect("person.jsp");
    }

    /**
     * Do post.
     *
     * @param request the HttpServletRequest
     * @param response the HttpServletResponse
     */

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}