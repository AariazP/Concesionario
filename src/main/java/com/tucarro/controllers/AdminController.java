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
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtContrasenia;

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

    private  Button btnRegistrar, btnActualizar, btnEliminar;
    @FXML private TableView<Cliente> tblClientes;
    //Declarar las columnas de la tabla
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colApellido;
    @FXML private TableColumn<Cliente, String> colCedula;
    @FXML private TableColumn<Cliente, String> colEmail;
    @FXML private TableColumn<Cliente, String> colContrasenia;
    @FXML private TableColumn<Cliente, String> colEstado;
    private ObservableList<Cliente> clientesObservableList = FXCollections.observableArrayList();
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
    /**
     * Metodo que permite buscar un cliente por su cedula
     * @param event que se genera al hacer escribir en el campo de texto
     */
    @FXML
    public void buscar(KeyEvent event){
       String cedula = txtBuscar.getText();

        if(cedula.isEmpty()){
            refrescarTabla();
        }else {
            Cliente cliente = Concesionario.getInstance().getClienteByCedula(cedula);
            if(cliente != null) refrescarTabla(cliente);
            else vaciarTabla();
        }
    }

    /**
     * Metodo que limpia la tabla
     */
    private void vaciarTabla() {
        clientesObservableList.clear();
        tblClientes.getItems().clear();
        tblClientes.refresh();
    }

    /**
     * Metodo que refresca la tabla con un solo cliente
     * @param cliente el que se va a mostrar
     */
    private void refrescarTabla(Cliente cliente){

        tblClientes.getItems().clear();
        clientesObservableList.clear();
        clientesObservableList.add(cliente);
        tblClientes.getItems().addAll(clientesObservableList);
        tblClientes.refresh();

    }

    /**
     * Metodo que limpia los campos de texto de la vista
     */
    @FXML
    public void limpiarCampos(){
        //Limpia los campos para realizar un nuevo registro
        txtBuscar.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtEmail.setText("");
        txtContrasenia.setText("");
        btnActualizar.setDisable(true);//permite que solo el boton de registrar se active
        btnEliminar.setDisable(true);
        btnRegistrar.setDisable(false);
    }

    /**
     * Metodo que crea un cliente en el modelo
     * @param event que generado al hacer click
     */
    @FXML
    public void crearCliente(ActionEvent event){

        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();
        String email = txtEmail.getText();
        String contrasenia = txtContrasenia.getText();

        Cliente cliente = new Cliente(nombre, apellido, cedula, email, contrasenia);



        if (!nombre.isEmpty() && !apellido.isEmpty() && !cedula.isEmpty()
                && !email.isEmpty() && !contrasenia.isEmpty()) {

            if(Concesionario.getInstance().crearCliente(cliente)){

                Application.getApplication().mostrarAlerta("Cliente creado con éxito");
                refrescarTabla();
                limpiarCampos();

            } else {

                Application.getApplication().mostrarAlerta("Ya existe un usuario con estos datos.");

            }
        }else {
            Application.getApplication().mostrarAlerta("Por favor rellene todos los campos");
        }
    }

    /**
     * Este método refresca la tabla de usuarios, mostrando los que están registrados
     */
    private void refrescarTabla() {

        tblClientes.getItems().clear();
        clientesObservableList.clear();
        clientesObservableList.addAll(Concesionario.getInstance().getListaClientes());
        tblClientes.getItems().addAll(clientesObservableList);
        tblClientes.refresh();

    }

    /**
     * Este metodo permite actualizar los datos de un cliente
     */
    @FXML
    public void actualizarCliente(ActionEvent event){

        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();
        System.out.println("cedula = " + cedula);
        String email = txtEmail.getText();
        String contrasenia = txtContrasenia.getText();

        if(Concesionario.getInstance().actualizarDatosCliente(nombre, apellido, cedula, email, contrasenia)){
            tblClientes.refresh();
            Application.getApplication().mostrarAlerta("Cliente actualizado con éxito");
        }else {
            Application.getApplication().mostrarAlerta("No se pudo actualizar el cliente, verifique la cedula sea la correcta");
        }

    }

    /**
     * Metodo que carga los campos de texto con los datos del cliente seleccionado
     * @param cliente que se va a mostrar
     */
    private void cargarCampos(Cliente cliente) {

        txtNombre.setText(cliente.getNombre());
        txtApellido.setText(cliente.getApellido());
        txtCedula.setText(cliente.getCedula());
        txtEmail.setText(cliente.getEmail());
        txtContrasenia.setText(cliente.getContrasenia());
        btnActualizar.setDisable(false);
        btnEliminar.setDisable(false);
        btnRegistrar.setDisable(true);


    }

    /**
     * Metodo que permite eliminar un cliente
     * @param event que se genera al hacer click
     */
    @FXML
    public void eliminarCliente(ActionEvent event){

        Cliente cliente = tblClientes.getSelectionModel().getSelectedItem();
        Concesionario.getInstance().eliminarCliente(cliente.getCedula());
        refrescarTabla();
    }

    //--------------CRUD EMPLEADO------------------
    /**
     * Metodo que permite buscar un cliente por su cedula
     * @param event que se genera al hacer escribir en el campo de texto
     */
    @FXML
    public void buscarEmpleado(KeyEvent event){
        String cedula = txtBuscar.getText();

        if(cedula.isEmpty()){
            refrescarTabla();
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
        refrescarTabla();
    }

    @FXML
    void limpiarCamposEmpleado(ActionEvent event) {

       Empleado empleado = tblEmpleados.getSelectionModel().getSelectedItem();
        Concesionario.getInstance().eliminarCliente(empleado.getCedula());
        refrescarTabla();
    }

    @FXML
    void volverLogin(ActionEvent event) {
        Application.getApplication().loadStage(Paths.LOGIN);
    }



    @FXML
    public void initialize() {

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContrasenia.setCellValueFactory(new PropertyValueFactory<>("contrasenia"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tblClientes.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Cliente itemSeleccionado = tblClientes.getSelectionModel().getSelectedItem();
                if(itemSeleccionado != null) cargarCampos(itemSeleccionado);
            }
        });
        refrescarTabla();

    }

}
