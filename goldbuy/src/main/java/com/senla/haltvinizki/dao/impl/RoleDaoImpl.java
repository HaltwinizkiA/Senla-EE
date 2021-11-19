package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.RoleDao;
import com.senla.haltvinizki.entity.role.Role;
import org.springframework.stereotype.Component;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Component
public class RoleDaoImpl extends AbstractDao<Role, Integer> implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public RoleDaoImpl() {
        super(Role.class);
    }


    @Override
    public Role getRoleWithUsers(int id) {
        EntityGraph userGraph = entityManager.getEntityGraph("role-users");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", userGraph);
        return entityManager.find(Role.class, id, hints);
    }
}
