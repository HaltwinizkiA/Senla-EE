package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.RoleDao;

import com.senla.haltvinizki.entity.role.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleDaoImpl implements RoleDao {
    List<Role> roleList;

    public RoleDaoImpl() {
        this.roleList = new ArrayList<>();
        roleList.add(new Role(0,"Admin"));
        roleList.add(new Role(0,"User"));
    }

    @Override
    public Role delete(Role role) {
        roleList.remove(role);
        return role;
    }

    @Override
    public Role create(Role role) {
        roleList.add(role);
        return role;
    }

    @Override
    public Role update(Role role) {
        for (Role soughtRole : read()) {
            if (soughtRole.getId() == role.getId()) {
                soughtRole = role;
            }
        }
        return role;
    }

    @Override
    public List<Role> read() {
        return roleList;
    }
}
