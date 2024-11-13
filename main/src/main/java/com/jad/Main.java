package com.jad;

import com.jad.controller.Controller;
import com.jad.controller.IController;
import com.jad.model.Model;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        IController controller = new Controller(new Model());
        controller.start();

    }
}