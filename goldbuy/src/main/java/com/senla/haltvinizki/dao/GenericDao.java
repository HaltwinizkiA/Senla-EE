package com.senla.haltvinizki.dao;

public interface GenericDao<Entity, Id> {
    Entity create(Entity entity);

    Entity getById(int id);

    Entity update(Entity entity);

    Entity delete(int id);


}
