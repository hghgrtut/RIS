package com.example.lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Connection Manager.
 */
public class ConnectionManager {

    /**
     * The Jdbc driver.
     */
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    /**
     * The Jdbc db url.
     */
    static final String JDBC_DB_URL = "jdbc:postgresql://localhost:5432/authentication";
    /**
     * The Jdbc user.
     */
    static final String JDBC_USER = "postgres";
    /**
     * The Jdbc pass.
     */
    static final String JDBC_PASS = "rtnm26yc16";

    private static Connection connection = null;


    /**
     * Gets connection.
     *
     * @return the connection
     */
    static public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(JDBC_DRIVER);
                connection =  DriverManager.getConnection(JDBC_DB_URL,
                        JDBC_USER, JDBC_PASS);
                System.out.println(connection.isValid(1000));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
        }

}

