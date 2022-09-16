package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(1, "Сергей", "Иванов", 20, "Москва"));
        users.add(new User(2, "Алексей", "Петров", 42, "Воронеж"));
        users.add(new User(3, "Михаил", "Уваров", 34, "Москва"));
        users.add(new User(4, "Дмитрий", "Васильев", 18, "Санкт-Петербург"));
        users.add(new User(5, "Евгений", "Виноградов", 26, "Уфа"));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
