package com.senla.haltvinizki.services;

import com.senla.haltvinizki.entity.user.User;

import java.util.List;

public interface UserService {

    User delete(User user);

    User create(User user);

    User update(User user);

    User getById(int id);
}
