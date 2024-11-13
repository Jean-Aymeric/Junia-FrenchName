package com.jad.model.entity;

import java.util.Objects;

public abstract class Entity implements IEntity {
    private int id;
    private String tableName;

    public Entity(String tableName) {
        this(tableName, 0);
    }

    public Entity(String tableName, int id) {
        this.id = id;
        this.tableName = tableName;
    }

    public abstract void save();

    public abstract void delete();

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.tableName);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        final Entity entity = (Entity) other;
        return this.id == entity.id && Objects.equals(this.tableName, entity.tableName);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + this.getId() +
                ", tableName='" + this.tableName + '\'' +
                '}';
    }

    @Override
    public int getId() {
        return this.id;
    }
}
