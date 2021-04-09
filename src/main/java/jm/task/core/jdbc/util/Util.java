package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.NonRegisteringDriver;
import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection connect() {
        Connection connection = null;

        try {
            Driver driver = new NonRegisteringDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
