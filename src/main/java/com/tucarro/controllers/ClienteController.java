package com.tucarro.controllers;

import com.tucarro.application.Application;
import com.tucarro.model.Concesionario;
import com.tucarro.model.Vehiculo;
import com.tucarro.utilities.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ClienteController {



    @FXML
    private HBox hBoxCarroItem;

    @FXML
    void volverLogin(ActionEvent event) {
        Application.getApplication().loadStage(Paths.LOGIN);
    }



    @FXML
    void initialize(){

        for(int i = 0; i < 100; i++){

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Paths.CarroItem));
            try {
                AnchorPane pane = fxmlLoader.load();
                pane.setStyle("-fx-margin: 10px");
                hBoxCarroItem.getChildren().add(pane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }



        }


    }


}
