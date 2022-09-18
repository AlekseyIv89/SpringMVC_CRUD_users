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
        users.add(new User(1, "Сергей", "Иванов", 20));
        users.add(new User(2, "Алексей", "Петров", 42));
        users.add(new User(3, "Михаил", "Уваров", 34));
        users.add(new User(4, "Дмитрий", "Васильев", 18));
        users.add(new User(5, "Евгений", "Виноградов", 26));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void createUser(User user) {
        user.setId(users.size() + 1);
        users.add(user);
    }
}
