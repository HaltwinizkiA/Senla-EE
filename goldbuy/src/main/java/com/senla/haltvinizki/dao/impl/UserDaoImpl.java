package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.entity.user.User;
import com.senla.haltvinizki.entity.user.User_;
import org.springframework.stereotype.Component;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getUserWithCredentials(int id) {
        EntityGraph userGraph = entityManager.getEntityGraph("user-credentials");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", userGraph);
        return entityManager.find(User.class, id, hints);
    }

    @Override
    public User getUserWithProducts(int id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);
        userRoot.fetch(User_.products, JoinType.LEFT);
        return entityManager.createQuery(query.select(userRoot).where(criteriaBuilder.equal(userRoot.get(User_.id), id))).getSingleResult();
    }

    @Override
    public User getUserWithRole(int id) {
        return entityManager.createQuery("select user from User user left join fetch user.roles where user.id= :id", User.class)
                .setParameter("id", id).getSingleResult();
    }


}
