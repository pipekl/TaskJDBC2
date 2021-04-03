package jm.task.core.jdbc.util;
import com.mysql.cj.jdbc.NonRegisteringDriver;
import jm.task.core.jdbc.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public void connect (String operation) {
        try {
            Driver driver = new NonRegisteringDriver();
            DriverManager.registerDriver(driver);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            statement.executeUpdate(operation);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> connectShow () {
        String sql = "SELECT * FROM pensionniiFond";
        List <User> users = new ArrayList<>();
        try {
            Driver driver = new NonRegisteringDriver();
            DriverManager.registerDriver(driver);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}
