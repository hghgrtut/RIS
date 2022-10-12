package com.example.lab5.dao;

import com.example.lab5.ConnectionManager;
import com.example.lab5.models.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Data dao.
 */
public class DataDAO {

    private static final String sqlInquiry = "SELECT DISTINCT name, password, gender FROM \"user\" WHERE name=?";

    /**
     * Find user user account.
     *
     * @param userName the user name
     * @param password the password
     * @return the user account
     */
    public static UserAccount findUser(String userName, String password) {
        UserAccount u = findByName(userName);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

    /**
     * Find by name user account.
     *
     * @param name the name
     * @return the user account
     */
    public static UserAccount findByName(String name) {
        Connection connection = ConnectionManager.getConnection();
        UserAccount user = null;
        try {
                PreparedStatement prepStatement = connection.prepareStatement(sqlInquiry);
            prepStatement.setString(1, name);
            ResultSet resObj = prepStatement.executeQuery();
            while (resObj.next()) {
                user = new UserAccount();
                String userName = resObj.getString("name");
                user.setUserName(userName);
                String password = resObj.getString("password");
                user.setPassword(password);
                String gender = resObj.getString("gender");
                user.setGender(gender);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }

}
