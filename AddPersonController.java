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
 * The type Add person controller.
 */
public class AddPersonController extends HttpServlet {
    private static final String URL_INDEX = "person.jsp";

    private long count;
    /**
     * The People.
     */
    PeopleDAO people = new PeopleDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        people.addPerson(new Person(++count, name, email,
                Integer.valueOf(age)));
        resp.sendRedirect(URL_INDEX);
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public long getCount() {
        return count;
    }
}
