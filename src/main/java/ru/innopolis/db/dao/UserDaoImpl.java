package ru.innopolis.db.dao;

import org.springframework.stereotype.Repository;
import ru.innopolis.db.model.User;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * UserDaoImpl.
 *
 * @author lifeandfree
 */
@Repository
public class UserDaoImpl implements UserDao {

    private Map<UUID, User> users = new ConcurrentHashMap<>();

    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User findUserByLoginOrEmail(String username) {
        return users.values().stream()
                .filter(user -> user.getEmail().equals(username) || user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findUserByLogin(String name) {
        return findUserByLoginOrEmail(name);
    }
}
