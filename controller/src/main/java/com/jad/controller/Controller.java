package com.jad.controller;

import com.jad.model.IModel;

import java.io.IOException;
import java.sql.SQLException;

public class Controller implements IController {
    private IModel model;

    public Controller(final IModel model) {
        this.model = model;
    }

    @Override
    public void start() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Controller started");
        this.model.connect();
        System.out.println("nb firstnames :" + this.model.getAllFirstNames().size());
        System.out.println(this.model.getLastNameById(156));
    }
}
