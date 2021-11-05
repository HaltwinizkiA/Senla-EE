package com.senla.haltvinizki.services;

import com.senla.haltvinizki.entity.role.Role;

import java.util.List;

public interface RoleService {
    Role delete(Role role);

    Role create(Role role);

    Role update(Role role);

    List<Role> read();
}
