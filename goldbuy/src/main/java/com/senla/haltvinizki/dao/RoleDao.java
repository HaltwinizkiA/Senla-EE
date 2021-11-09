package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.role.Role;
import com.senla.haltvinizki.entity.user.User;

import java.util.List;

public interface RoleDao {
    Role delete(Role role);

    Role create(Role role);

    Role update(Role role);

    List<Role> read();
}
