package com.example.lab5.dao;

import com.example.lab5.ConnectionManager;
import com.example.lab5.models.Person;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type People dao.
 */
public class PeopleDAOImpl implements PeopleDAO {
    private static final String SELECT_ALL = "SELECT id, name, email, age FROM \"person\" ORDER BY name ASC";
    private static final String SELECT_PERSON = "SELECT id, name, email, age FROM \"person\" WHERE id=? ORDER BY name ASC";
    private static final String UPDATE_PERSON = "UPDATE \"person\" SET name=?, email=?, age=? WHERE id=?";
    private static final String INSERT_PERSON = "INSERT INTO \"person\" (name, email, age) VALUES (?,?,?)";
    private static final  String DELETE_PERSON = "DELETE FROM \"person\" WHERE id=?";
    /**
     * The Logger.
     */
    protected final Logger logger = LogManager.getLogger(PeopleDAOImpl.class);

    @Override
    public Person selectPersonById(Long idPerson) {
        try {
            PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(SELECT_PERSON);
            ps.setLong(1, idPerson);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println(fillPerson(rs).getId());
            System.out.println(fillPerson(rs).getEmail());
            return fillPerson(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Error SQL select person");
        }
        return null;
    }

    @Override
    public List<Person> selectAllPeople() {
        List<Person> list = new ArrayList<>();
        try {
            PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(fillPerson(rs));
            }
        } catch (SQLException throwables) {
            logger.error("Error SQL select person");
        }
        return list;
    }


    @Override
    //TODO
    public void updatePerson(Person person) {
        try {
            PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(UPDATE_PERSON);
                ps.setString(1, person.getName());
                ps.setString(2, person.getEmail());
                ps.setInt(3, person.getAge());
                ps.setLong(4, person.getId());
            System.out.println(person.getId());
            System.out.println(person.getName());
                ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error SQL update person");
        }
    }

    @Override
    public void addPerson(Person person) {
        try {
            PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(INSERT_PERSON);
                ps.setString(1, person.getName());
                ps.setString(2, person.getEmail());
                ps.setInt(3, person.getAge());
                ps.executeUpdate();
            } catch(SQLException e){
                logger.error("Error SQL add person");
            }
        }

    @Override
    public void deletePerson(Person person) {
        try {
            PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(DELETE_PERSON);
            ps.setLong(1, person.getId());
        } catch (SQLException throwables) {
           logger.error("Error SQL delete person");
        }
    }

    /**
     * Fill person person.
     *
     * @param rs the rs
     * @return the person
     * @throws SQLException the sql exception
     */
    public Person fillPerson(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        Integer age = rs.getInt("age");
        return new Person(id, name, email, age);
    }
}
