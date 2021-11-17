package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.entity.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {
    public UserDaoImpl() {
    }
}
