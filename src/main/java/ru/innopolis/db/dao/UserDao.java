package ru.innopolis.db.dao;

import ru.innopolis.db.model.User;

/**
 * UserDao.
 *
 * @author lifeandfree
 */
public interface UserDao {

    void addUser(User user);

    User findUserByLoginOrEmail(String username);

    User findUserByLogin(String name);
}
