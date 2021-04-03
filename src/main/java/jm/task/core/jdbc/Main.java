package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBCImpl = new UserDaoJDBCImpl();
        List<User> users = List.of(
                new User("Vissarion", "Nedopobedimii", (byte) 96),
                new User("Evlampii", "Shac", (byte) 83),
                new User("Klavdiya", "Przhevalskaya", (byte) 91),
                new User("Vladimir", "Tutin", (byte) 101));

        userDaoJDBCImpl.createUsersTable();

        for (User user : users) {
            userDaoJDBCImpl.saveUser(user.getName(), user.getLastName(), user.getAge());
        }

        System.out.println(userDaoJDBCImpl.getAllUsers());
        userDaoJDBCImpl.cleanUsersTable();
        userDaoJDBCImpl.dropUsersTable();
    }
}
