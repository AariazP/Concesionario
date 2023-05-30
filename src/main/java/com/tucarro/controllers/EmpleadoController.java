package com.tucarro.controllers;

import com.tucarro.application.Application;
import com.tucarro.model.*;
import com.tucarro.utilities.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.lang.reflect.Field;

public class EmpleadoController {


    @FXML
    private VBox vBoxTextFields;

    @FXML
    private VBox vboxLabels;


    @FXML
    void updateFields(ActionEvent event) {



    }



    @FXML
    void volverLogin(ActionEvent event) {
        Application.getApplication().loadStage(Paths.LOGIN);
    }


    @FXML
    void initialize() {

    }
}
