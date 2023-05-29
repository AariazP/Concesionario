package com.tucarro.interfaz;

import com.tucarro.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.lang.reflect.Field;

public class EmpleadoController {

    @FXML
    private ComboBox<String> cmbTipoVehiculo;

    @FXML
    private VBox vBoxTextFields;

    @FXML
    private VBox vboxLabels;


    @FXML
    void updateFields(ActionEvent event) {

        String tipoVehiculo = cmbTipoVehiculo.getValue();

        switch (tipoVehiculo) {
            case "moto" -> {
                Field[] atributosMoto = Moto.class.getSuperclass().getDeclaredFields();
                loadNodes(atributosMoto);
            }
            case "Sedan" -> {
                Field[] atributosSedan = Sedan.class.getSuperclass().getDeclaredFields();
                loadNodes(atributosSedan);
            }
            case "Deportivo" -> {
                Field[] atributosVehiculo = Deportivo.class.getSuperclass().getDeclaredFields();
                loadNodes(atributosVehiculo);
            }
            case "Van" -> {
                Field[] atributosVan = Van.class.getSuperclass().getDeclaredFields();
                loadNodes(atributosVan);
            }
            case "Camion" -> {
                Field[] atributosCamion = Camion.class.getSuperclass().getDeclaredFields();
                loadNodes(atributosCamion);
            }
        }




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

        cmbTipoVehiculo.getItems().add("Sedan");
        cmbTipoVehiculo.getItems().add("Deportivo");
        cmbTipoVehiculo.getItems().add("Bus");
        cmbTipoVehiculo.getItems().add("Moto");

    }
}
