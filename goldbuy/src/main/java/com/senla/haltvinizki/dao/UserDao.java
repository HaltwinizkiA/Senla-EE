package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.User;

import java.util.List;

public interface UserDao  extends GenericDao<User,Long> {
    User getUserWithCredentials(Long id);

    User getUserWithProducts(Long id);

    User getUserWithRole(Long id);

    User getUserWithLogin(String login);

    List<User> getAllAdmin();

    User getByLoginWithRoles(String username);

    User getByNameWithRoles(String username);
}
