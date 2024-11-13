package com.jad.model;

import com.jad.model.dao.DAOFirstName;
import com.jad.model.dao.DAOLastName;
import com.jad.model.entity.FirstName;
import com.jad.model.entity.FirstNames;
import com.jad.model.entity.LastName;
import com.jad.model.entity.LastNames;

import java.sql.SQLException;

public class Model {
    private final DAOFirstName dAOFirstName = new DAOFirstName();
    private final DAOLastName dAOLastName = new DAOLastName();

    public FirstName getFirstNameById(final int id) throws SQLException {
        return this.dAOFirstName.findById(id);
    }

    public FirstNames getAllFirstNames() throws SQLException {
        final FirstNames firstNames = new FirstNames();
        this.dAOFirstName.getAll(firstNames);
        return firstNames;
    }

    public LastName getLastNameById(final int id) throws SQLException {
        return this.dAOLastName.findById(id);
    }

    public LastNames getAllLastNames() throws SQLException {
        final LastNames lastNames = new LastNames();
        this.dAOLastName.getAll(lastNames);
        return lastNames;
    }

    public LastNames getAllLastNamesWithStart(final int start) throws SQLException {
        final LastNames lastNames = new LastNames();
        this.dAOLastName.getAllWithStart(lastNames, start);
        return lastNames;
    }
}
