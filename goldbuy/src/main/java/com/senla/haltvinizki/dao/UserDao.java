package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.User;

import java.util.List;

public interface UserDao  extends GenericDao<User,Long> {
    User getUserWithCredentials(int id);

    User getUserWithProducts(int id);

    User getUserWithRole(int id);

    User getUserWithLogin(String login);

    List<User> getAllAdmin();



}
