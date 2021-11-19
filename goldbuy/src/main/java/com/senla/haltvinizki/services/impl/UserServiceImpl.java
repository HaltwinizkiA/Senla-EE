package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.entity.user.User;
import com.senla.haltvinizki.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserDao userDao;

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

    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public User getUserWithCredentials(int id) {
        return userDao.getUserWithCredentials(id);
    }

    @Override
    public User getUserWithProducts(int id) {
        return userDao.getUserWithProducts(id);
    }

    @Override
    public User getUserWithRole(int id) {
        return userDao.getUserWithRole(id);
    }
}
