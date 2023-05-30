package com.tucarro.controllers;

import com.tucarro.application.Application;
import com.tucarro.model.*;
import com.tucarro.utilities.MethodsUtilities;
import com.tucarro.utilities.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.lang.reflect.Field;

public class EmpleadoController {



    @FXML
    private ComboBox<String> cmbAireAcondicionado;

    @FXML
    private ComboBox<String> cmbAsistentePermanencia;

    @FXML
    private ComboBox<String> cmbCapacidadCruceroSuv;

    @FXML
    private TextField cmbCapacidadEjeCarga;

    @FXML
    private ComboBox<String> cmbDisponibilidadVehiculo;

    @FXML
    private ComboBox<String> cmbEstadoVehiculo;

    @FXML
    private ComboBox<String> cmbTieneABS;

    @FXML
    private ComboBox<String> cmbTieneCamara;

    @FXML
    private ComboBox<String> cmbTieneSensorColision;

    @FXML
    private ComboBox<String> cmbTieneSensorTrafico;

    @FXML
    private ComboBox<String> cmbTipo4X4PickUp;

    @FXML
    private ComboBox<String> cmbTipo4X4Suv;

    @FXML
    private ComboBox<String> cmbTipoAireCamion;

    @FXML
    private ComboBox<String> cmbTipoCamion;

    @FXML
    private ComboBox<String> cmbTipoCombustible;

    @FXML
    private ComboBox<String> cmbTipoTransmision;

    @FXML
    private ComboBox<String> cmbVelocidadCruceroSedan;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img5;

    @FXML
    private TextField txtCantCambios;

    @FXML
    private TextField txtCapacidadCargaCamion;

    @FXML
    private TextField txtCapacidadMaleteroSedan;

    @FXML
    private TextField txtCapacidadMaleteroSuv;

    @FXML
    private TextField txtCapacidadMaleteroVan;

    @FXML
    private TextField txtCilindraje;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtNumeroBolsasAire;

    @FXML
    private TextField txtNumeroCaballosDeportivo;

    @FXML
    private TextField txtNumeroEjesBus;

    @FXML
    private TextField txtNumeroEjesCamion;

    @FXML
    private TextField txtNumeroPasajeros;

    @FXML
    private TextField txtNumeroPuertas;

    @FXML
    private TextField txtNumeroSalidasEmergenciaBus;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtTiempo0a100Deportivo;

    @FXML
    private TextField txtVelocidadMax;

    @FXML
    void guardarBus(ActionEvent event) {

    }

    @FXML
    void guardarCamion(ActionEvent event) {

    }

    @FXML
    void guardarDeportivo(ActionEvent event) {

    }

    @FXML
    void guardarPickUp(ActionEvent event) {

    }

    @FXML
    void guardarSedan(ActionEvent event) {

    }

    @FXML
    void guardarSuv(ActionEvent event) {

    }

    @FXML
    void guardarVan(ActionEvent event) {

    }

    @FXML
    void loadImage(MouseEvent event) {

        if(event.getSource() == img1) {
            System.out.println(MethodsUtilities.getRutaImage());
            img1.setImage(new Image(MethodsUtilities.getRutaImage()));
        }
        if(event.getSource() == img2) img2.setImage(new Image(MethodsUtilities.getRutaImage()));
        if(event.getSource() == img3) img3.setImage(new Image(MethodsUtilities.getRutaImage()));
        if (event.getSource() == img4) img4.setImage(new Image(MethodsUtilities.getRutaImage()));
        if (event.getSource() == img5) img5.setImage(new Image(MethodsUtilities.getRutaImage()));

    }

    @FXML
    void volverLogin(ActionEvent event) {
        Application.getApplication().loadStage(Paths.LOGIN);
    }


    @FXML
    void initialize() {

    }
}
