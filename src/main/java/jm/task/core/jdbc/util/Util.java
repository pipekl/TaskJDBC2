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

    public void createTable (String nameTable) {
        String sql = "CREATE TABLE IF NOT EXISTS " + nameTable + " (id bigint primary key auto_increment, name varchar(100), lastName varchar(100), age tinyint);";
        connect(sql);
    }

    public void deleteTable (String nameTable) {
        String sql = "DROP TABLE IF EXISTS " + nameTable;
        connect(sql);
    }

    public void joinUser (User user, String nameTable) {
        String sql = "INSERT " + nameTable + " (name, lastName, age) VALUES ('"
                + user.getName() + "', '" + user.getLastName() + "', " + user.getAge() + " );";
        connect(sql);
        System.out.println("User с именем – " + user.getName() + " добавлен в базу данных " + nameTable);
    }

    public void deleteUser (Long id, String nameTable) {
        String sql = "DELETE FROM " + nameTable + " WHERE id = " + id;
        connect(sql);
    }

    public void clearTable (String nameTable) {
        String sql = "TRUNCATE TABLE " + nameTable;
        connect(sql);
    }
}
