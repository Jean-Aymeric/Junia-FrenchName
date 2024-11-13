package com.jad.model.entity;

public class FirstName extends Entity {

    static final String TABLE_NAME = "firstname_view";
    private String firstName;
    private int count;
    private char sexe;

    public FirstName(final String firstName,
                     final int count,
                     final char sexe) {
        this(0, firstName, count, sexe);
    }

    public FirstName(final int id,
                     final String firstName,
                     final int count,
                     final char sexe) {
        super(FirstName.TABLE_NAME, id);
        this.firstName = firstName;
        this.count = count;
        this.sexe = sexe;
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }

    @Override
    public String toString() {
        return "FirstName{" +
                "firstName='" + this.getFirstName() + '\'' +
                ", count=" + this.getCount() +
                ", sexe=" + this.getSexe() +
                "} " + super.toString();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public char getSexe() {
        return this.sexe;
    }

    public void setSexe(final char sexe) {
        this.sexe = sexe;
    }
}
