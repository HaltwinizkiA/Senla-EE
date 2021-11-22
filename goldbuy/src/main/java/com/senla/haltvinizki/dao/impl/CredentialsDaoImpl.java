package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.dao.configuration.GraphConfiguration;
import com.senla.haltvinizki.entity.credentials.Credentials;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CredentialsDaoImpl extends AbstractDao<Credentials, Integer> implements CredentialsDao {

    public CredentialsDaoImpl() {
        super(Credentials.class);
    }

    @Override
    public Credentials getCredentialsWithUser(int id) {
        EntityGraph userGraph = entityManager.getEntityGraph(GraphConfiguration.CREDENTIALS_USER);
        Map hints = new HashMap();
        hints.put(graphPersistence, userGraph);
        return entityManager.find(Credentials.class, id, hints);
    }
}
