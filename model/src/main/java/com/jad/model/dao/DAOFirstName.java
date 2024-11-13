package com.jad.model.dao;

import com.jad.model.entity.FirstName;
import com.jad.model.entity.FirstNames;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOFirstName extends DAOEntity<FirstName, FirstNames> {
    private final static String CALL_GET_FIRST_NAME_BY_ID = "{CALL getFirstNameById(?)}";
    private final static String CALL_GET_ALL_FIRST_NAMES = "{CALL getAllFirstNames()}";
    private final static String CALL_DELETE_FIRST_NAME_BY_ID = "{CALL deleteFirstNameById(?)}";
    private final static String CALL_SAVE_FIRST_NAME = "{CALL saveFirstName(?, ?, ?, ?)}";

    public DAOFirstName() {
        super(DAOFirstName.CALL_GET_FIRST_NAME_BY_ID,
              DAOFirstName.CALL_GET_ALL_FIRST_NAMES,
              DAOFirstName.CALL_DELETE_FIRST_NAME_BY_ID,
              DAOFirstName.CALL_SAVE_FIRST_NAME);
    }

    @Override
    public boolean save(final FirstName entity) throws SQLException {
        return false;
    }

    @Override
    protected FirstName resultSetToEntity(final ResultSet resultSet) throws SQLException {
        final int id = resultSet.getInt("id");
        final String firstName = resultSet.getString("firstname");
        final int count = resultSet.getInt("count");
        final char sexe = resultSet.getString("sexe").charAt(0);
        return new FirstName(id, firstName, count, sexe);
    }
}
