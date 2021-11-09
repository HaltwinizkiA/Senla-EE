package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.user.User;

import java.util.List;

public interface UserDao {

    User delete(User user);

    User create(User user);

    User update(User user);

    List<User> read();

}
