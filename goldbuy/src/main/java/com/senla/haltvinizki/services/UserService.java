package com.senla.haltvinizki.services;

import com.senla.haltvinizki.entity.user.User;

public interface UserService {

    User delete(User user);

    User create(User user);

    User update(User user);

    User getById(int id);

    User getUserWithCredentials(int id);

    User getUserWithProducts(int id);

    User getUserWithRole(int id);
}
