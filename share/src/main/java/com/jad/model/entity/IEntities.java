package com.jad.model.entity;

import java.util.Iterator;
import java.util.List;

public interface IEntities<E extends IEntity> extends Iterable<E>, Iterator<E> {
    List<E> getEntities();

    E getEntityById(int id);

    void addEntity(E entity);

    boolean removeEntity(E entity);

    int size();
}
