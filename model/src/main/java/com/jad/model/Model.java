package com.jad.model;

import com.jad.model.dao.DAOFirstName;
import com.jad.model.dao.DAOLastName;
import com.jad.model.dao.DBConnection;
import com.jad.model.entity.FirstName;
import com.jad.model.entity.FirstNames;
import com.jad.model.entity.LastName;
import com.jad.model.entity.LastNames;

import java.io.IOException;
import java.sql.SQLException;

public class Model implements IModel {
    private DAOFirstName dAOFirstName;
    private DAOLastName dAOLastName;

    @Override
    public void connect() throws SQLException, IOException, ClassNotFoundException {
        DBConnection.INSTANCE.connect();
        this.dAOFirstName = new DAOFirstName();
        this.dAOLastName = new DAOLastName();
    }

    @Override
    public FirstName getFirstNameById(final int id) throws SQLException {
        return this.dAOFirstName.findById(id);
    }

    @Override
    public FirstNames getAllFirstNames() throws SQLException {
        final FirstNames firstNames = new FirstNames();
        this.dAOFirstName.getAll(firstNames);
        return firstNames;
    }

    @Override
    public LastName getLastNameById(final int id) throws SQLException {
        return this.dAOLastName.findById(id);
    }

    @Override
    public LastNames getAllLastNames() throws SQLException {
        final LastNames lastNames = new LastNames();
        this.dAOLastName.getAll(lastNames);
        return lastNames;
    }

    @Override
    public LastNames getAllLastNamesWithStart(final int start) throws SQLException {
        final LastNames lastNames = new LastNames();
        this.dAOLastName.getAllWithStart(lastNames, start);
        return lastNames;
    }
}
