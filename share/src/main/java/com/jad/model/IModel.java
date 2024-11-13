package com.jad.model;

import com.jad.model.entity.FirstName;
import com.jad.model.entity.FirstNames;
import com.jad.model.entity.LastName;
import com.jad.model.entity.LastNames;

import java.io.IOException;
import java.sql.SQLException;

public interface IModel {
    void connect() throws SQLException, IOException, ClassNotFoundException;

    FirstName getFirstNameById(int id) throws SQLException;

    FirstNames getAllFirstNames() throws SQLException;

    LastName getLastNameById(int id) throws SQLException;

    LastNames getAllLastNames() throws SQLException;

    LastNames getAllLastNamesWithStart(int start) throws SQLException;
}
