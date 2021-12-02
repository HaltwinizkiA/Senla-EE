package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.configuration.GraphConfiguration;
import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.entity.User;
import com.senla.haltvinizki.entity.User_;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<User,Long> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getUserWithCredentials(Long id) {
        EntityGraph userGraph = entityManager.getEntityGraph(GraphConfiguration.USER_CREDENTIALS);
        Map hints = new HashMap();
        hints.put(GRAPH_PERSISTENCE, userGraph);
        return entityManager.find(User.class, id, hints);
    }

    @Override
    public User getUserWithProducts(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);
        userRoot.fetch(User_.products, JoinType.LEFT);
        return entityManager.createQuery(query.select(userRoot).where(criteriaBuilder.equal(userRoot.get(User_.id), id))).getSingleResult();
    }

    @Override
    public User getUserWithRole(Long id) {
        return entityManager.createQuery("select user from User user left join fetch user.roles where user.id= :id", User.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public User getUserWithLogin(String login) {
        return entityManager.createQuery("select user from User user inner join user.credentials cr where cr.login= :login", User.class)
                .setParameter("login", login)
                .getSingleResult();
    }

    @Override
    public List<User> getAllAdmin() {
        return entityManager.createQuery("select user from User user inner join fetch user.roles r where r.name='Admin'", User.class)
                .getResultList();
    }

    @Override
    public User getByNameWithRoles(String username) {
        return entityManager.createQuery("select user from User user left join fetch user.roles where user.name= :username", User.class)
                .setParameter("username", username).getSingleResult();
    }


}
