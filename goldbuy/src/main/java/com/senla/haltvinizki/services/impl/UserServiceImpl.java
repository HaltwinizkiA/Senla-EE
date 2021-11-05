package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.dao.impl.UserDaoImpl;
import com.senla.haltvinizki.entity.user.User;
import com.senla.haltvinizki.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao=userDao;

    }

    @Override
    public User delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> read() {
        return userDao.read();
    }
}
