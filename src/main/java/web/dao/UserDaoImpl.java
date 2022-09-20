package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User("Сергей", "Иванов", 20));
        users.add(new User("Алексей", "Петров", 42));
        users.add(new User("Михаил", "Уваров", 34));
        users.add(new User("Дмитрий", "Васильев", 18));
        users.add(new User("Евгений", "Виноградов", 26));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void createUser(User user) {
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
