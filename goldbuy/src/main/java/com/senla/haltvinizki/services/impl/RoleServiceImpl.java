package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.impl.RoleDaoImpl;
import com.senla.haltvinizki.entity.role.Role;
import com.senla.haltvinizki.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    @Autowired
    private final RoleDaoImpl roleDao;

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

    @Override
    public Role getRoleWithUsers(int id) {
        return roleDao.getRoleWithUsers(id);
    }
}

