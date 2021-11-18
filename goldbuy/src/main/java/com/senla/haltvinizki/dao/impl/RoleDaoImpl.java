package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.GenericDao;
import com.senla.haltvinizki.dao.RoleDao;
import com.senla.haltvinizki.entity.role.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleDaoImpl extends AbstractDao<Role, Integer> implements RoleDao {
    public RoleDaoImpl() {
        super(Role.class);
    }


}
