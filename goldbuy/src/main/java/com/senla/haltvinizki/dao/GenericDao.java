package com.senla.haltvinizki.dao;

public interface GenericDao<Entity, Id> {
    Entity create(Entity entity);

    Entity getById(Id id);

    Entity update(Entity entity);

    Entity delete(Id id);


}
