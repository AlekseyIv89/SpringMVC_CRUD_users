package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void createUser(User user);
    User getUser(long id);
    void editUser(long id, User user);
    void deleteUser(long id);
}
