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
    private ChoiceBox<String> estadoEmpleado;
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
    private TableColumn<Registro, String> colFecha;

    @FXML
    private TableView<Registro> tblReportes;

    @FXML
    private Button btnActualizar, btnEliminar, btnRegistrar;


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
     * Metodo que permite buscar un empleado por su cedula
     * @param event que se genera al hacer escribir en el campo de texto
     */
    @FXML
    public void buscarEmpleado(KeyEvent event){
        String cedula = txtBuscar.getText();

        if(cedula.isEmpty()){
            refrescarTabla();
        }else {
            Empleado empleado = Concesionario.getInstance().getEmpleadoByCedula(cedula);
            if(empleado != null) refrescarTablaEmpleado(empleado);
            else vaciarTablaEmpleado();
        }
    }

    private void refrescarTabla() {

        tblEmpleados.getItems().clear();
        empleadoObservableList.clear();
        empleadoObservableList.addAll(Concesionario.getInstance().getListaEmpleados());
        tblEmpleados.getItems().addAll(empleadoObservableList);
        tblEmpleados.refresh();

    }

    private void vaciarTablaEmpleado() {
        empleadoObservableList.clear();
        tblEmpleados.getItems().clear();
        tblEmpleados.refresh();
    }

    //TODO
    @FXML
    void actualizarEmpleado(ActionEvent event) {
        String nombre = txtNombreEmpleado.getText();
        String apellido = txtApellidoEmpleado.getText();
        String cedula = txtCedulaEmpleado.getText();
        System.out.println("cedula = " + cedula);
        String email = txtEmailEmpleado.getText();
        String contrasenia = txtContraseniaEmpleado.getText();

        if (Concesionario.getInstance().actualizarDatosCliente(nombre, apellido, cedula, email, contrasenia)) {
            tblEmpleados.refresh();
            Application.getApplication().mostrarAlerta("Empleado actualizado con éxito");
        } else {
            Application.getApplication().mostrarAlerta("No se pudo actualizar el empleado, verifique la cedula sea la correcta");
        }


    }

    @FXML
    void crearEmpleado(ActionEvent event) {

        String nombreEmpleado = txtNombreEmpleado.getText();
        String apellidoEmpleado = txtApellidoEmpleado.getText();
        String cedulaEmpleado = txtCedulaEmpleado.getText();
        String emailEmpleado = txtEmailEmpleado.getText();
        String contraseniaEmpleado = txtContraseniaEmpleado.getText();
        String estado  = estadoEmpleado.getValue();

        Empleado empleado = new Empleado(nombreEmpleado, apellidoEmpleado, cedulaEmpleado, emailEmpleado, contraseniaEmpleado);

        if(estado.equalsIgnoreCase("inactivo")) {
            empleado.setEstadoInactivo();
        }

        if(Concesionario.getInstance().crearEmpleado(empleado)){
            Application.getApplication().mostrarAlerta("Empleado creado con éxito");
            refrescarTabla();
            limpiarCamposEmpleado();
        }else {
            Application.getApplication().mostrarAlerta("Ya existe un usuario con estos datos.");
        }


    }

    @FXML
    void eliminarEmpleado(ActionEvent event) {
        Empleado empleado = tblEmpleados.getSelectionModel().getSelectedItem();
        Concesionario.getInstance().eliminarCliente(empleado.getCedula());
        refrescarTablaEmpleado(empleado);
    }

    @FXML
    void limpiarCamposEmpleado() {
        Empleado empleado = tblEmpleados.getSelectionModel().getSelectedItem();
        Concesionario.getInstance().eliminarCliente(empleado.getCedula());
        refrescarTablaEmpleado(empleado);
    }

    @FXML
    void volverLogin(ActionEvent ignoredEvent) {
        Application.getApplication().loadStage(Paths.LOGIN);
    }



    @FXML
    public void initialize() {

        colNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colApellidoEmpleado.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCedulaEmpleado.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colEmailEmpleado.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContraseniaEmpleado.setCellValueFactory(new PropertyValueFactory<>("contrasenia"));
        colEstadoEmpleado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        estadoEmpleado.getItems().addAll("Activo", "Inactivo");
        refrescarTabla();

        tblEmpleados.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Empleado itemSeleccionado = tblEmpleados.getSelectionModel().getSelectedItem();
                if (itemSeleccionado != null) cargarCampos(itemSeleccionado);
            }
        });
    }

    private void cargarCampos(Empleado itemSeleccionado) {
        txtNombreEmpleado.setText(itemSeleccionado.getNombre());
        txtApellidoEmpleado.setText(itemSeleccionado.getApellido());
        txtCedulaEmpleado.setText(itemSeleccionado.getCedula());
        txtEmailEmpleado.setText(itemSeleccionado.getEmail());
        txtContraseniaEmpleado.setText(itemSeleccionado.getContrasenia());
        estadoEmpleado.setValue(itemSeleccionado.getEstado());
        btnActualizar.setDisable(false);
        btnRegistrar.setDisable(true);
        btnEliminar.setDisable(false);
    }


    public void actualizarRegistros(ActionEvent event){
        tblReportes.getItems().clear();
        tblReportes.getItems().addAll(Concesionario.getInstance().getListaRegistros());
    }

    @FXML
    void buscar(KeyEvent event) {
        String cedula = txtBuscar.getText();

        if(cedula.isEmpty()){
            refrescarTabla();
        }else {
            Empleado empleado = Concesionario.getInstance().getEmpleadoByCedula(cedula);
            if(empleado != null) refrescarTablaEmpleado(empleado);
            else vaciarTablaEmpleado();
        }
    }

    private void refrescarTablaEmpleado(Empleado empleado){
        tblEmpleados.getItems().clear();
        empleadoObservableList.clear();
        empleadoObservableList.add(empleado);
        tblEmpleados.getItems().addAll(empleado);
        tblEmpleados.refresh();

    }


    @FXML
    public void limpiarCamposEmpleado(ActionEvent event) {
        //Limpia los campos para realizar un nuevo registro
        txtBuscar.setText("");
        txtNombreEmpleado.setText("");
        txtApellidoEmpleado.setText("");
        txtCedulaEmpleado.setText("");
        txtEmailEmpleado.setText("");
        txtContraseniaEmpleado.setText("");
        estadoEmpleado.setValue("");
        btnActualizar.setDisable(true);//permite que solo el boton de registrar se active
        btnEliminar.setDisable(true);
        btnRegistrar.setDisable(false);
    }
}