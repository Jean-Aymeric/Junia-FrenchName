package com.jad;

import com.jad.model.dao.DBConnection;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        DBConnection.INSTANCE.connect();
        System.out.println(DBConnection.INSTANCE.getConnection());
    }
}