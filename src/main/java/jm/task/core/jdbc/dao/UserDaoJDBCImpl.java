package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private UserServiceImpl userServiceImpl = new UserServiceImpl();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        userServiceImpl.createUsersTable();
    }

    public void dropUsersTable() {
        userServiceImpl.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userServiceImpl.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userServiceImpl.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    public void cleanUsersTable() {
        userServiceImpl.cleanUsersTable();
    }
}
