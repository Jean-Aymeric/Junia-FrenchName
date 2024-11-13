package com.jad.model.entity;

import java.util.*;
import java.util.function.Consumer;

public abstract class Entities<E extends IEntity> implements IEntities<E> {
    private final ArrayList<E> entities = new ArrayList<>();

    @Override
    public List<E> getEntities() {
        return Collections.unmodifiableList(this.entities);
    }

    @Override
    public E getEntityById(final int id) {
        for (final E entity : this.entities) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public void addEntity(final E entity) {
        if (this.getEntityById(entity.getId()) != null) return;
        if (this.entities.contains(entity)) return;
        this.entities.add(entity);
    }

    @Override
    public boolean removeEntity(final E entity) {
        return this.entities.remove(entity);
    }

    @Override
    public int size() {
        return this.entities.size();
    }

    @Override
    public Iterator<E> iterator() {
        return this.entities.iterator();
    }

    @Override
    public void forEach(final Consumer<? super E> action) {
        this.entities.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return this.entities.spliterator();
    }

    @Override
    public boolean hasNext() {
        return this.entities.iterator().hasNext();
    }

    @Override
    public E next() {
        return this.entities.iterator().next();
    }

    @Override
    public void forEachRemaining(final Consumer<? super E> action) {
        this.entities.iterator().forEachRemaining(action);
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        for (final E entity : this.entities) {
            result.append(entity.toString()).append("\n");
        }
        return result.toString();
    }
}
