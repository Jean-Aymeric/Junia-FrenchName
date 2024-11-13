package com.jad;

import com.jad.model.dao.DAOFirstName;
import com.jad.model.dao.DAOLastName;
import com.jad.model.dao.DBConnection;
import com.jad.model.entity.FirstNames;
import com.jad.model.entity.LastNames;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        DBConnection.INSTANCE.connect();
        System.out.println(DBConnection.INSTANCE.getConnection());
        DAOFirstName daoFirstName = new DAOFirstName();
        FirstNames firstNames = new FirstNames();
        daoFirstName.getAll(firstNames);
        System.out.println("nb firstnames :" + firstNames.size());
        DAOLastName daoLastName = new DAOLastName();
        System.out.println(daoLastName.findById(1));
        LastNames lastNames = new LastNames();
        daoLastName.getAllWithStart(lastNames, 10);
        System.out.println(lastNames);
    }
}