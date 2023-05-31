package com.tucarro.controllers;

import com.tucarro.application.Application;
import com.tucarro.model.*;
import com.tucarro.utilities.Paths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class AdminController {

    @FXML
    private TextField txtBuscar;

    @FXML
    private ChoiceBox<?> estadoEmpleado;
    @FXML
    private TextField txtApellidoEmpleado;
    @FXML
    private TextField txtCedulaEmpleado;
    @FXML
    private PasswordField txtContraseniaEmpleado;
    @FXML
    private TextField txtEmailEmpleado;
    @FXML
    private TextField txtNombreEmpleado;
    @FXML
    private TableColumn<Registro, String> colTramite;
    @FXML
    private TableColumn<Registro, String> colCliente;
    @FXML
    private TableColumn<Registro, String> colEmpleado;
    @FXML
    private TableColumn<Registro, String> colPlacaVehiculo;
    @FXML
    private TableView<Registro> tblReportes;




// table view Empleados
    @FXML private TableView<Empleado> tblEmpleados;
    //Declarar las columnas de la tabla
    @FXML private TableColumn<Empleado, String> colNombreEmpleado;
    @FXML private TableColumn<Empleado, String> colApellidoEmpleado;
    @FXML private TableColumn<Empleado, String> colCedulaEmpleado;
    @FXML private TableColumn<Empleado, String> colEmailEmpleado;
    @FXML private TableColumn<Empleado, String> colContraseniaEmpleado;
    @FXML private TableColumn<Empleado, String> colEstadoEmpleado;

    private ObservableList<Empleado> empleadoObservableList = FXCollections.observableArrayList();


    //--------------CRUD EMPLEADO------------------
    /**
     * Metodo que permite buscar un cliente por su cedula
     * @param event que se genera al hacer escribir en el campo de texto
     */
    @FXML
    public void buscarEmpleado(KeyEvent event){
        String cedula = txtBuscar.getText();

        if(cedula.isEmpty()){
           // refrescarTabla();
        }else {
            Empleado empleado = Concesionario.getInstance().getEmpleadoByCedula(cedula);
         //   if(empleado != null) refrescarTabla(empleado);
           // else vaciarTabla();
        }
    }
    @FXML
    void actualizarEmpleado(ActionEvent event) {

    }

    @FXML
    void crearEmpleado(ActionEvent event) {

        String nombreEmpleado = txtNombreEmpleado.getText();
        String apellidoEmpleado = txtApellidoEmpleado.getText();
        String cedulaEmpleado = txtCedulaEmpleado.getText();
        String emailEmpleado = txtEmailEmpleado.getText();
        String contraseniaEmpleado = txtContraseniaEmpleado.getText();

        Empleado empleado = new Empleado(nombreEmpleado, apellidoEmpleado, cedulaEmpleado, emailEmpleado, contraseniaEmpleado);


        if(Concesionario.getInstance().crearEmpleado(empleado)){
            Application.getApplication().mostrarAlerta("Empleado creado con éxito");
            //refrescarTablaEmpleado();
           // limpiarCamposEmpleado();
        }else {
            Application.getApplication().mostrarAlerta("Ya existe un usuario con estos datos.");
        }


    }

    @FXML
    void eliminarEmpleado(ActionEvent event) {
        Empleado empleado = tblEmpleados.getSelectionModel().getSelectedItem();
        Concesionario.getInstance().eliminarCliente(empleado.getCedula());
       // refrescarTabla();
    }

    @FXML
    void limpiarCamposEmpleado(ActionEvent event) {

       Empleado empleado = tblEmpleados.getSelectionModel().getSelectedItem();
        Concesionario.getInstance().eliminarCliente(empleado.getCedula());
       // refrescarTabla();
    }

    @FXML
    void volverLogin(ActionEvent ignoredEvent) {
        Application.getApplication().loadStage(Paths.LOGIN);
    }



    @FXML
    public void initialize() {

        colCliente.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        colEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombreEmpleado"));
        colPlacaVehiculo.setCellValueFactory(new PropertyValueFactory<>("placaVehiculo"));
        colTramite.setCellValueFactory(new PropertyValueFactory<>("tipoTramite"));
        tblReportes.getItems().addAll(Concesionario.getInstance().getListaRegistros());


    }


    public void actualizarRegistros(ActionEvent event){
        tblReportes.getItems().clear();
        tblReportes.getItems().addAll(Concesionario.getInstance().getListaRegistros());
    }

    @FXML
    void buscar(KeyEvent event) {

    }

}
