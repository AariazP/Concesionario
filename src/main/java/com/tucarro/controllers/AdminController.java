package com.tucarro.controllers;

import com.tucarro.application.Application;
import com.tucarro.model.*;
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
    private ChoiceBox<String> estado;
    @FXML
    private
    Button btnRegistrar, btnActualizar, btnEliminar;
    @FXML private TableView<Cliente> tblClientes;
    //Declarar las columnas de la tabla
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colApellido;
    @FXML private TableColumn<Cliente, String> colCedula;
    @FXML private TableColumn<Cliente, String> colEmail;
    @FXML private TableColumn<Cliente, String> colContrasenia;
    @FXML private TableColumn<Cliente, String> colEstado;
    private ObservableList<Cliente> clientesObservableList = FXCollections.observableArrayList();


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
        estado.setValue("");
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
        String estadoUsuario = estado.getSelectionModel().getSelectedItem();

        Cliente cliente = new Cliente(nombre, apellido, cedula, email, contrasenia, estadoUsuario );



        if (!nombre.isEmpty() && !apellido.isEmpty() && !cedula.isEmpty()
                && !email.isEmpty() && !contrasenia.isEmpty() && !estadoUsuario.isEmpty()) {

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
        String estadoEmpleado = estado.getValue();

        if(Concesionario.getInstance().actualizarDatosCliente(nombre, apellido, cedula, email, contrasenia, estadoEmpleado)){
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
        estado.setValue(cliente.getEstado());
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

    @FXML
    public void initialize() {

        estado.getItems().addAll("Activo", "Bloqueado");   //Agrega valores al ChoiceBox
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
