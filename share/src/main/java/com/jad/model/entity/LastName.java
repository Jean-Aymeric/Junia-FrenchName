package com.jad.model.entity;

public class LastName extends Entity {

    static final String TABLE_NAME = "lastname_view";
    private String lastName;
    private int count;

    public LastName(final String lastName,
                    final int count) {
        this(0, lastName, count);
    }

    public LastName(final int id,
                    final String lastName,
                    final int count) {
        super(LastName.TABLE_NAME, id);
        this.lastName = lastName;
        this.count = count;
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }

    @Override
    public String toString() {
        return "LastName{" +
                "lastName='" + this.getLastName() + '\'' +
                ", count=" + this.getCount() +
                "} " + super.toString();
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(final int count) {
        this.count = count;
    }
}
