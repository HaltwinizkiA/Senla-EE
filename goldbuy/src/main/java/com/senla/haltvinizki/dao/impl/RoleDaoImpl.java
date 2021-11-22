package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.RoleDao;
import com.senla.haltvinizki.configuration.GraphConfiguration;
import com.senla.haltvinizki.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
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
        hints.put(GRAPH_PERSISTENCE, userGraph);
        return entityManager.find(Role.class, id, hints);
    }
}
