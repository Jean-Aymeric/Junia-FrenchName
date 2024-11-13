package com.jad.model.dao;

import com.jad.model.entity.LastName;
import com.jad.model.entity.LastNames;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOLastName extends DAOEntity<LastName, LastNames> {
    private final static String CALL_GET_LAST_NAME_BY_ID = "{CALL getLastNameById(?)}";
    private final static String CALL_GET_ALL_LAST_NAMES = "{CALL getAllLastNames()}";
    private final static String CALL_DELETE_LAST_NAME_BY_ID = "{CALL deleteLastNameById(?)}";
    private final static String CALL_SAVE_LAST_NAME = "{CALL saveLastName(?, ?, ?, ?)}";
    private final static String CALL_UPDATE_LAST_NAME = "{CALL getAllLastNamesWithStart(?)}";

    public DAOLastName() {
        super(DAOLastName.CALL_GET_LAST_NAME_BY_ID,
              DAOLastName.CALL_GET_ALL_LAST_NAMES,
              DAOLastName.CALL_DELETE_LAST_NAME_BY_ID,
              DAOLastName.CALL_SAVE_LAST_NAME);
    }

    @Override
    public boolean save(final LastName entity) throws SQLException {
        return false;
    }

    @Override
    protected LastName resultSetToEntity(final ResultSet resultSet) throws SQLException {
        final int id = resultSet.getInt("id");
        final String firstName = resultSet.getString("lastname");
        final int count = resultSet.getInt("count");
        return new LastName(id, firstName, count);
    }

    public LastNames getAllWithStart(LastNames lastNames, int start) throws SQLException {
        final CallableStatement call = this.connection.prepareCall(DAOLastName.CALL_UPDATE_LAST_NAME);
        call.setInt(1, start);
        call.execute();
        final ResultSet resultSet = call.getResultSet();
        while (resultSet.next()) {
            lastNames.addEntity(this.resultSetToEntity(resultSet));
        }
        return lastNames;
    }
}
