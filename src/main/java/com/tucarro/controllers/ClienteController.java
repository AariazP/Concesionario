package com.tucarro.controllers;

import com.tucarro.application.Application;
import com.tucarro.model.Concesionario;
import com.tucarro.model.Vehiculo;
import com.tucarro.utilities.MethodsUtilities;
import com.tucarro.utilities.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Setter
@Getter
public class ClienteController {


    @FXML
    private HBox hBoxCarroItem;

    private Vehiculo vehiculo;
    @FXML
    private Label lblEstado;

    @FXML
    private Label lblMarca;

    @FXML
    private Label lblModelo;

    @FXML
    private Label lblPlaca;

    @FXML
    private Label lblTipoCombustible;

    @FXML
    private Label lblTipoVehic;

    @FXML
    private ImageView imgVehiculo;

    @FXML
    void volverLogin(ActionEvent ignoredEvent) {
        Application.getApplication().loadStage(Paths.LOGIN);
    }


    @FXML
    void initialize() {

        for (Vehiculo vehiculo : Concesionario.getInstance().getListaVehiculos()) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Paths.CarroItem));
            try {
                AnchorPane pane = fxmlLoader.load();
                HBox.setMargin(pane, new Insets(5));
                CarroItemController carroItemController = fxmlLoader.getController();
                carroItemController.setVehiculo(vehiculo);
                carroItemController.setClienteController(this);
                hBoxCarroItem.getChildren().add(pane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }


    public void verDetalles() {

        lblMarca.setText(vehiculo.getMarca());
        lblModelo.setText(vehiculo.getModelo());
        lblPlaca.setText(vehiculo.getPlaca());
        lblEstado.setText(vehiculo.getEstadoVehiculo().toString());
        lblTipoCombustible.setText(vehiculo.getCombustible().toString());
        lblTipoVehic.setText(MethodsUtilities.getTipoVehiculo(vehiculo));
        imgVehiculo.setImage(new Image(vehiculo.getFotos()[0]));

    }


    @FXML
    void alquilar(ActionEvent ignoredEvent) {
        Concesionario.getInstance().alquilarVehiculo(Concesionario.getInstance().getClienteActual(), vehiculo);
        Application.getApplication().mostrarAlerta("El vehiculo" + vehiculo.getPlaca()+" ha sido alquilado");
        Application.getApplication().loadStage(Paths.CLIENTE);
    }

    @FXML
    void comprar(ActionEvent ignoredEvent) {
        Concesionario.getInstance().venderVehiculo(Concesionario.getInstance().getClienteActual(), vehiculo);
        Application.getApplication().mostrarAlerta("El vehiculo" + vehiculo.getPlaca()+" ha sido comprado");
        Application.getApplication().loadStage(Paths.CLIENTE);
    }
}
