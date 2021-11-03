package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.services.UserService;

import сom.senlainc.injection.annotation.Autowired;
import сom.senlainc.injection.annotation.Component;


@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {

    }

    @Override
    public void execute() {
        System.out.println( userDao.execute());
    }
}
