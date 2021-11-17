package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.GenerikDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDao<Entity, Id> implements GenerikDao<Entity, Id> {

    @PersistenceContext
    protected EntityManager entityManager;
    protected Class<Entity> entityClass;

    @Override
    public Entity create(Entity entity) {
         entityManager.persist(entity);
         return entity;
    }

    @Override
    public Entity getById(int id) {
        return entityManager.find(entityClass,id);
    }

    @Override
    public Entity update(Entity entity) {
        return entityManager.merge(entity);
    }

    @Override
    public Entity delete(Entity entity) {
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            entityManager.remove(entityManager.merge(entity));
        }
        return entity;
    }
}
