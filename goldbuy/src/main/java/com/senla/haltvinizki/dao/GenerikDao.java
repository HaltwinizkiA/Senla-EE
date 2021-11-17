package com.senla.haltvinizki.dao;

public interface GenerikDao<Entity, Id> {
    Entity create(Entity entity);

    Entity getById(int id);

    Entity update(Entity entity);

    Entity delete(Entity entity);


}
