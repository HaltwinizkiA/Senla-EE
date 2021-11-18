package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.impl.RoleDaoImpl;
import com.senla.haltvinizki.entity.role.Role;
import com.senla.haltvinizki.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleServiceImpl implements RoleService {
    @Autowired
    private final RoleDaoImpl roleDao;

    public RoleServiceImpl(RoleDaoImpl roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role delete(Role role) {
        return roleDao.delete(role);
    }

    @Override
    public Role create(Role role) {
        return roleDao.create(role);
    }

    @Override
    public Role update(Role role) {
        return roleDao.update(role);
    }

    @Override
    public Role getById(int id) {
        return roleDao.getById(id);
    }
}

