package com.tucarro.controllers;

import com.tucarro.application.Application;
import com.tucarro.model.*;
import com.tucarro.utilities.MethodsUtilities;
import com.tucarro.utilities.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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

    private String marca;
    private String modelo;
    private int cantCambios;
    private Double velocidadMax;
    private int cilindraje;
    private String placa;
    private EstadoVehiculo estadoVehiculo;
    private TipoCombustible tipoCombustible;
    private TipoABS tieneABS;
    private DisponibilidadVehiculo disponibilidadVehiculo;
    private TipoTransmision tipoTransmision;
    private int numeroPasajeros;
    private int numeroPuertas;
    private TieneCamara tieneCamara;
    private SensorColision tieneSensorColision;
    private SensorTrafico tieneSensorTrafico;
    private TipoPermanencia asistentePermanencia;
    private TipoAcondicionado aireAcondicionado;
    private int numeroBolsasAire;


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
    void guardarSedan(ActionEvent ignoredEvent) {

        if (verificarCampos()) {
            cargarCampos();
            if (!txtCapacidadMaleteroSedan.getText().isEmpty() && !cmbVelocidadCruceroSedan.getValue().isEmpty()) {

                Sedan sedan = new Sedan();
                sedan.setCapacidadMaletero(Double.parseDouble(txtCapacidadMaleteroSedan.getText()));
                //TODO: Hay enums con valores extraños
                sedan.setVelocidadCrucero(MethodsUtilities.getVelocidadCrucero(cmbVelocidadCruceroSedan.getValue()));
                addAtributosVan(sedan);
                Concesionario.getInstance().agregarVehiculo(sedan);
                Application.getApplication().mostrarAlerta("Se ha agregado el vehiculo");
                limpiarCamposAutomovil();
                limpiarCamposSedan();
            } else {
                Application.getApplication().mostrarAlerta("Faltan campos por llenar en Sedan");
            }


        } else {
            Application.getApplication().mostrarAlerta("Faltan campos por llenar en vehiculo");
        }

    }

    private void limpiarCamposSedan() {
        txtCapacidadMaleteroSedan.clear();
        cmbVelocidadCruceroSedan.setValue(null);
    }

    private void limpiarCamposAutomovil() {
        txtMarca.clear();
        txtModelo.clear();
        txtCantCambios.clear();
        txtVelocidadMax.clear();
        txtCilindraje.clear();
        txtPlaca.clear();
        cmbEstadoVehiculo.setValue(null);
        cmbTipoCombustible.setValue(null);
        cmbTieneABS.setValue(null);
        cmbDisponibilidadVehiculo.setValue(null);
        cmbTipoTransmision.setValue(null);
        txtNumeroPasajeros.clear();
        txtNumeroPuertas.clear();
        cmbTieneCamara.setValue(null);
        cmbTieneSensorColision.setValue(null);
        cmbTieneSensorTrafico.setValue(null);
        cmbAsistentePermanencia.setValue(null);
        cmbAireAcondicionado.setValue(null);
        txtNumeroBolsasAire.clear();
        img1.setImage(null);
        img2.setImage(null);
        img3.setImage(null);
        img4.setImage(null);
        img5.setImage(null);
    }

    private String[] obtenerImages() {

        String[] im = new String[5];

        if(img1.getImage() != null) im[0] = MethodsUtilities.getImagePath(img1.getImage());
        if(img2.getImage() != null) im[1] = MethodsUtilities.getImagePath(img2.getImage());
        if(img3.getImage() != null) im[2] = MethodsUtilities.getImagePath(img3.getImage());
        if(img4.getImage() != null) im[3] = MethodsUtilities.getImagePath(img4.getImage());
        if(img5.getImage() != null) im[4] = MethodsUtilities.getImagePath(img5.getImage());
        return im;
    }

    @FXML
    void guardarSuv(ActionEvent event) {
        if(verificarCampos()){

            if(!txtCapacidadMaleteroSuv.getText().isEmpty()
                    && cmbCapacidadCruceroSuv.getValue() != null && cmbTipo4X4Suv.getValue() != null){

                Suv_Camioneta suv = new Suv_Camioneta();
                suv.setCapacidadMaletero(Double.parseDouble(txtCapacidadMaleteroSuv.getText()));
                suv.setVelocidadCrucero(MethodsUtilities.getVelocidadCrucero(cmbCapacidadCruceroSuv.getValue()));
                suv.setEs4x4(MethodsUtilities.getTipo4x4(cmbTipo4X4Suv.getValue()));
                addAtributosVan(suv);

                Concesionario.getInstance().agregarVehiculo(suv);
                limpiarCamposAutomovil();
                limpiarCamposSuv();

            }else {
                Application.getApplication().mostrarAlerta("Faltan campos por llenar en Van");
            }


        }else {
            Application.getApplication().mostrarAlerta("Faltan campos por llenar en vehiculo");
        }

    }

    //TODO
    private void limpiarCamposSuv() {
    }

    @FXML
    void guardarVan(ActionEvent event) {

        if(verificarCampos()){

            if(!txtCapacidadMaleteroVan.getText().isEmpty()){

                Van van = new Van();
                addAtributosVan(van);
                van.setCapacidadMaletero(Double.parseDouble(txtCapacidadMaleteroVan.getText()));

                Concesionario.getInstance().agregarVehiculo(van);
                limpiarCamposAutomovil();
                limpiarCamposVan();

            }else {
                Application.getApplication().mostrarAlerta("Faltan campos por llenar en Van");
            }


        }else {
            Application.getApplication().mostrarAlerta("Faltan campos por llenar en vehiculo");
        }

    }

    //TODO: Hacer
    private void limpiarCamposVan() {
    }

    private void addAtributosVan(Automovil automovil) {

        automovil.setMarca(marca);
        automovil.setModelo(modelo);
        automovil.setCantCambios(cantCambios);
        automovil.setVelocidadMaxima(velocidadMax);
        automovil.setCilindraje(cilindraje);
        automovil.setPlaca(placa);
        automovil.setEstadoVehiculo(estadoVehiculo);
        automovil.setCombustible(tipoCombustible);
        automovil.setTieneAbs(tieneABS);
        automovil.setDisponibilidadVehiculo(disponibilidadVehiculo);
        automovil.setTransmision(tipoTransmision);
        automovil.setNumPasajeros(numeroPasajeros);
        automovil.setNumPuertas(numeroPuertas);
        automovil.setTieneCamara(tieneCamara);
        automovil.setTieneSensorColision(tieneSensorColision);
        automovil.setTieneSensorTrafico(tieneSensorTrafico);
        automovil.setAsistentePermanencia(asistentePermanencia);
        automovil.setAireAcondicionado(aireAcondicionado);
        automovil.setNumBolsasAire(numeroBolsasAire);
        automovil.setFotos(obtenerImages());


    }

    @FXML
    void loadImage(MouseEvent event) {

        if (event.getSource() == img1) img1.setImage(new Image(MethodsUtilities.getRutaImage()));
        if (event.getSource() == img2) img2.setImage(new Image(MethodsUtilities.getRutaImage()));
        if (event.getSource() == img3) img3.setImage(new Image(MethodsUtilities.getRutaImage()));
        if (event.getSource() == img4) img4.setImage(new Image(MethodsUtilities.getRutaImage()));
        if (event.getSource() == img5) img5.setImage(new Image(MethodsUtilities.getRutaImage()));

    }

    @FXML
    void volverLogin(ActionEvent ignoredEvent) {
        Application.getApplication().loadStage(Paths.LOGIN);
    }

    private void cargarCampos() {
        try {
            marca = txtMarca.getText();
            modelo = txtModelo.getText();
            cantCambios = Integer.parseInt(txtCantCambios.getText());
            velocidadMax = Double.parseDouble(txtVelocidadMax.getText());
            cilindraje = Integer.parseInt(txtCilindraje.getText());
            placa = txtPlaca.getText();
            estadoVehiculo = MethodsUtilities.getEstadoVehiculo(cmbEstadoVehiculo.getSelectionModel().getSelectedItem());
            tipoCombustible = MethodsUtilities.getTipoCombustible(cmbTipoCombustible.getSelectionModel().getSelectedItem());
            tieneABS = MethodsUtilities.getTieneABS(cmbTieneABS.getSelectionModel().getSelectedItem());
            disponibilidadVehiculo = MethodsUtilities.getDisponibilidadVehiculo(cmbDisponibilidadVehiculo.getSelectionModel().getSelectedItem());
            tipoTransmision = MethodsUtilities.getTipoTransmision(cmbTipoTransmision.getSelectionModel().getSelectedItem());
            numeroPasajeros = Integer.parseInt(txtNumeroPasajeros.getText());
            numeroPuertas = Integer.parseInt(txtNumeroPuertas.getText());
            tieneCamara = MethodsUtilities.getTieneCamara(cmbTieneCamara.getSelectionModel().getSelectedItem());
            tieneSensorColision = MethodsUtilities.getTieneSensorColision(cmbTieneSensorColision.getSelectionModel().getSelectedItem());
            tieneSensorTrafico = MethodsUtilities.getTieneSensorTrafico(cmbTieneSensorTrafico.getSelectionModel().getSelectedItem());
            asistentePermanencia = MethodsUtilities.getAsistentePermanencia(cmbAsistentePermanencia.getSelectionModel().getSelectedItem());
            aireAcondicionado = MethodsUtilities.getAireAcondicionado(cmbAireAcondicionado.getSelectionModel().getSelectedItem());
            numeroBolsasAire = Integer.parseInt(txtNumeroBolsasAire.getText());
        } catch (Exception e) {
            Application.getApplication().mostrarAlerta("Verifique que los campos esten llenos correctamente");
        }


    }


    /**
     * Metodo que verifica que todos los campos esten llenos, en la
     * sección de Automovil
     *
     * @return true si todos los campos están llenos, false en caso contrario
     */
    private boolean verificarCampos() {

        if (txtMarca.getText().isEmpty()) return false;
        if (txtModelo.getText().isEmpty()) return false;
        if (txtCantCambios.getText().isEmpty()) return false;
        if (txtVelocidadMax.getText().isEmpty()) return false;
        if (txtCilindraje.getText().isEmpty()) return false;
        if (txtPlaca.getText().isEmpty()) return false;
        if (cmbEstadoVehiculo.getSelectionModel().isEmpty()) return false;
        if (cmbTipoCombustible.getSelectionModel().isEmpty()) return false;
        if (cmbTieneABS.getSelectionModel().isEmpty()) return false;
        if (cmbDisponibilidadVehiculo.getSelectionModel().isEmpty()) return false;
        if (cmbTipoTransmision.getSelectionModel().isEmpty()) return false;
        if (txtNumeroPasajeros.getText().isEmpty()) return false;
        if (txtNumeroPuertas.getText().isEmpty()) return false;
        if (cmbTieneCamara.getSelectionModel().isEmpty()) return false;
        if (cmbTieneSensorColision.getSelectionModel().isEmpty()) return false;
        if (cmbTieneSensorTrafico.getSelectionModel().isEmpty()) return false;
        if (txtNumeroBolsasAire.getText().isEmpty()) return false;
        if (cmbAireAcondicionado.getSelectionModel().isEmpty()) return false;
        return !cmbAsistentePermanencia.getSelectionModel().isEmpty();

    }

    @FXML
    void initialize() {
        cmbEstadoVehiculo.getItems().addAll("Nuevo", "Usado");
        cmbTipoCombustible.getItems().addAll("Gasolina", "Diesel", "Hibrido", "Eléctrico");
        cmbTieneABS.getItems().addAll("Si", "No");
        cmbDisponibilidadVehiculo.getItems().addAll("Si", "No");
        cmbTipoTransmision.getItems().addAll("Manual", "Automática");
        cmbTieneCamara.getItems().addAll("Si", "No");
        cmbTieneSensorColision.getItems().addAll("Si", "No");
        cmbTieneSensorTrafico.getItems().addAll("Si", "No");
        cmbAireAcondicionado.getItems().addAll("Si", "No");
        cmbAsistentePermanencia.getItems().addAll("Si", "No");
        cmbVelocidadCruceroSedan.getItems().addAll("Si", "No");
        cmbCapacidadCruceroSuv.getItems().addAll("Si", "No");
        cmbTipoAireCamion.getItems().addAll("Si", "No");
        cmbTipoCamion.getItems().addAll("VOLQUETA", "REMOLQUE", "TANQUE");
        cmbTipo4X4PickUp.getItems().addAll("Si", "No");
        cmbTipo4X4Suv.getItems().addAll("Si", "No");

    }
}
