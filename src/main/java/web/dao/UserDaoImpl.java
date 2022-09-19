package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private static long USERS_COUNT = 0;
    private final List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++USERS_COUNT, "Сергей", "Иванов", 20));
        users.add(new User(++USERS_COUNT, "Алексей", "Петров", 42));
        users.add(new User(++USERS_COUNT, "Михаил", "Уваров", 34));
        users.add(new User(++USERS_COUNT, "Дмитрий", "Васильев", 18));
        users.add(new User(++USERS_COUNT, "Евгений", "Виноградов", 26));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void createUser(User user) {
        user.setId(++USERS_COUNT);
        users.add(user);
    }

    @Override
    public User getUser(long id) {
        return users.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void editUser(long id, User user) {
        User editedUser = getUser(id);
        editedUser.setName(user.getName());
        editedUser.setSurname(user.getSurname());
        editedUser.setAge(user.getAge());
    }

    @Override
    public void deleteUser(long id) {
        users.removeIf(user -> user.getId() == id);
    }
}
