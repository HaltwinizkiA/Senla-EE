package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.UserDao;
import сom.senlainc.injection.annotation.Component;
import сom.senlainc.injection.annotation.Value;

@Component
public class UserDaoImpl implements UserDao {

    @Value(value = "user")
    private String someText;

    @Override
    public String execute() {

        return someText;
    }
}
