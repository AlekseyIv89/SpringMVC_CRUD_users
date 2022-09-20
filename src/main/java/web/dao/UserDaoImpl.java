package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext(unitName = "entityManagerFactory")
    public EntityManager entityManager;

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
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(long id) {
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getResultList().stream().findAny().orElse(null);
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
