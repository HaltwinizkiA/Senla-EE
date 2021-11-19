package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.entity.credentials.Credentials;
import org.springframework.stereotype.Component;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Component
public class CredentialsDaoImpl extends AbstractDao<Credentials, Integer> implements CredentialsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public CredentialsDaoImpl() {
        super(Credentials.class);
    }

    @Override
    public Credentials getCredentialsWithUser(int id) {
        EntityGraph userGraph = entityManager.getEntityGraph("credentials-user");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", userGraph);
        return entityManager.find(Credentials.class, id, hints);
    }
}
