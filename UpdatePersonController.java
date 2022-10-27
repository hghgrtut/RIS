package com.example.lab5.people;

import com.example.lab5.dao.PeopleDAO;
import com.example.lab5.dao.PeopleDAOImpl;
import com.example.lab5.models.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Update person controller.
 */
public class UpdatePersonController extends HttpServlet {
    private static final String URL_INDEX = "person.jsp";
    private static final String URL_UPDATE = "/update.jsp";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String AGE = "age";
    private PeopleDAO people = new PeopleDAOImpl();
    private AddPersonController addPersonController = new AddPersonController();

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse
            resp) throws ServletException, IOException {
        String name = req.getParameter(NAME);
        String email = req.getParameter(EMAIL);
        String age = req.getParameter(AGE);
        people.updatePerson(new Person(addPersonController.getCount(), name, email, Integer.valueOf(age)));
        System.out.println(addPersonController.getCount());
        resp.sendRedirect(URL_INDEX);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(URL_UPDATE).forward(req,resp);
    }
}