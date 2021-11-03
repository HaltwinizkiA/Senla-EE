package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

    @Value(value = "user")
    private String someText;

    @Override
    public String execute() {

        return someText;
    }
}
