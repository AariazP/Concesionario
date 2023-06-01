package com.tucarro.controllers;

import com.tucarro.model.Vehiculo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarroItemController {

    @FXML
    private Label lblEstado;

    @FXML
    private Label lblMarca;

    @FXML
    private Label lblModelo;

    @FXML
    private Label lblPlaca;

    @FXML
    private ImageView imgVehiculo;

    private Vehiculo vehiculo;

    private ClienteController clienteController;

    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
        lblEstado.setText(vehiculo.getEstadoVehiculo().toString());
        lblMarca.setText(vehiculo.getMarca());
        lblModelo.setText(vehiculo.getModelo());
        lblPlaca.setText(vehiculo.getPlaca());
        imgVehiculo.setImage(new Image(vehiculo.getFotos()[0]));
    }

    @FXML
    public void verDetalles(){
        clienteController.setVehiculo(vehiculo);
        clienteController.verDetalles();
    }

}
