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

    private void loadNodes(Field[] atributosVehiculo) {
        for (int i = 0; i < atributosVehiculo.length; i++) {
            Label label = new Label();
            TextField textField = new TextField();
            textField.setPromptText(atributosVehiculo[i].getName());
            vBoxTextFields.getChildren().add(textField);
            label.setText(atributosVehiculo[i].getName());
            vboxLabels.getChildren().add(label);
            label.setStyle("-fx-background-color: #252525;\n" +
                    "    -fx-border-radius: 50px;\n" +
                    "    -fx-background-radius: 50px;\n" +
                    "    -fx-border-color: WHITE;" +
                    "-fx-text-fill: White; \n" +
                    "-fx-alignment: center ");
        }
    }

    @FXML
    void initialize() {

    }
}
