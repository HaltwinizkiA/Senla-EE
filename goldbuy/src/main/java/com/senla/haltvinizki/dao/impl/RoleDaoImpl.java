package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.RoleDao;
import com.senla.haltvinizki.dao.configuration.GraphConfiguration;
import com.senla.haltvinizki.entity.role.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RoleDaoImpl extends AbstractDao<Role, Integer> implements RoleDao {

    public RoleDaoImpl() {
        super(Role.class);
    }


    @Override
    public Role getRoleWithUsers(int id) {
        EntityGraph userGraph = entityManager.getEntityGraph(GraphConfiguration.ROLE_USERS);
        Map hints = new HashMap();
        hints.put(graphPersistence, userGraph);
        return entityManager.find(Role.class, id, hints);
    }
}
