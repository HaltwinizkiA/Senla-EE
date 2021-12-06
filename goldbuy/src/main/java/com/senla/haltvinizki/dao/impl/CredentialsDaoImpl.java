package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.configuration.GraphConfiguration;
import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import com.senla.haltvinizki.entity.Credentials;
import com.senla.haltvinizki.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CredentialsDaoImpl extends AbstractDao<Credentials, Long> implements CredentialsDao {

    public CredentialsDaoImpl() {
        super(Credentials.class);
    }

    @Override
    public Credentials getCredentialsWithUser(Long id) {
        EntityGraph userGraph = entityManager.getEntityGraph(GraphConfiguration.CREDENTIALS_USER);
        Map hints = new HashMap();
        hints.put(GRAPH_PERSISTENCE, userGraph);
        return entityManager.find(Credentials.class, id, hints);
    }

    @Override
    public Credentials getByUserId(long id) {
        return entityManager.createQuery
                        ("select credentials from Credentials credentials left join fetch credentials.user user where user.id= :id", Credentials.class)
                .setParameter("id", id).getSingleResult();
    }
}
