package com.tucarro.controllers;

import com.tucarro.application.Application;
import com.tucarro.model.*;
import com.tucarro.utilities.MethodsUtilities;
import com.tucarro.utilities.Paths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
    @FXML
    private TableView<Cliente> tblClientes;
    @FXML
    private TableView<Vehiculo> tblVehiculosOp;
    @FXML
    private TableView<Cliente> tblClientesOp;
    @FXML
    private TableColumn<Cliente, String> colNombre;
    @FXML
    private TableColumn<Cliente, String> colApellido;
    @FXML
    private TableColumn<Cliente, String> colCedula;
    @FXML
    private TableColumn<Cliente, String> colEmail;
    @FXML
    private TableColumn<Cliente, String> colContrasenia;
    @FXML
    private TableColumn<Cliente, String> colEstado;
    private ObservableList<Cliente> clientesObservableList = FXCollections.observableArrayList();
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
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtBuscar;
    @FXML
    private PasswordField txtContrasenia;
    @FXML
    private Button btnActualizar, btnEliminar, btnRegistrar;
    @FXML
    private TableColumn<Automovil, String> colCilindraje;
    @FXML
    private TableColumn<Automovil, String> colMarca;
    @FXML
    private TableColumn<Automovil, String> colModelo;
    @FXML
    private TableColumn<Automovil, String> colNumeroPasajeros;
    @FXML
    private TableColumn<Automovil, String> colNumeroPuertas;
    @FXML
    private TableColumn<Automovil, String> colPlaca;
    @FXML
    private TableColumn<Automovil, String> colVelocidadMaxima;
    @FXML
    private TableColumn<Automovil, String> colCantCambios;

    @FXML
    private TableColumn<Automovil, String> colPlacaOp;
    @FXML
    private TableColumn<Automovil, String> colMarcaOp;
    @FXML
    private TableColumn<Automovil, String> colModeloOp;
    @FXML
    private TableColumn<Cliente, String> colNombreOp;
    @FXML
    private TableColumn<Cliente, String> colApellidosOp;
    @FXML
    private TableColumn<Cliente, String> colCedulaOp;
    @FXML
    private TableColumn<Cliente, String> colEmailOp;



    private Vehiculo vehiculoSeleccionado;



    @FXML
    private TableView<Vehiculo> tableAutomoviles;


    @FXML
    void guardarBus(ActionEvent ignoredEvent) {

        if (verificarCampos()) {
            cargarCampos();
            if (!txtNumeroEjesBus.getText().isEmpty()
                    && !txtNumeroSalidasEmergenciaBus.getText().isEmpty()) {

                Bus bus = new Bus();
                bus.setNumEjes(Integer.parseInt(txtNumeroEjesBus.getText()));
                bus.setNumSalidasEmergencia(Integer.parseInt(txtNumeroSalidasEmergenciaBus.getText()));
                addAtributosAutomovil(bus);

                Concesionario.getInstance().agregarVehiculo(bus);
                Application.getApplication().mostrarAlerta("Se ha agregado el vehiculo");
                limpiarCamposAutomovil();
                limpiarCamposCamion();
            } else {
                Application.getApplication().mostrarAlerta("Faltan campos por llenar en Sedan");
            }


        } else {
            Application.getApplication().mostrarAlerta("Faltan campos por llenar en vehiculo");
        }


    }

    @FXML
    void guardarCamion(ActionEvent ignoredEvent) {
        if (verificarCampos()) {
            cargarCampos();
            if (!txtCapacidadCargaCamion.getText().isEmpty()
                    && !cmbTipoAireCamion.getValue().isEmpty()
                    && !txtNumeroEjesCamion.getText().isEmpty()
                    && !cmbTipoCamion.getValue().isEmpty()) {

                Camion camion = new Camion();
                camion.setCapacidadCarga(Double.parseDouble(txtCapacidadCargaCamion.getText()));
                camion.setAireAcondicionado(MethodsUtilities.getAireAcondicionado(cmbTipoAireCamion.getValue()));
                camion.setNumEjes(Integer.parseInt(txtNumeroEjesCamion.getText()));
                camion.setTipoC(MethodsUtilities.getTipoCamion(cmbTipoCamion.getValue()));


                Concesionario.getInstance().agregarVehiculo(camion);
                Application.getApplication().mostrarAlerta("Se ha agregado el vehiculo");
                limpiarCamposAutomovil();
                limpiarCamposCamion();
            } else {
                Application.getApplication().mostrarAlerta("Faltan campos por llenar en Sedan");
            }


        } else {
            Application.getApplication().mostrarAlerta("Faltan campos por llenar en vehiculo");
        }
    }

    private void limpiarCamposCamion() {
        txtCapacidadCargaCamion.clear();
        cmbTipoAireCamion.getSelectionModel().clearSelection();
        txtNumeroEjesCamion.clear();
        cmbTipoCamion.getSelectionModel().clearSelection();
    }

    @FXML
    void guardarDeportivo(ActionEvent ignoredEvent) {
        if (verificarCampos()) {
            cargarCampos();
            if (!txtNumeroCaballosDeportivo.getText().isEmpty()
                    && !txtTiempo0a100Deportivo.getText().isEmpty()) {

                Deportivo deportivo = new Deportivo();
                deportivo.setNumCaballosFuerza(Integer.parseInt(txtNumeroCaballosDeportivo.getText()));
                deportivo.setTiempo0_100(Double.parseDouble(txtTiempo0a100Deportivo.getText()));

                addAtributosAutomovil(deportivo);
                Concesionario.getInstance().agregarVehiculo(deportivo);
                Application.getApplication().mostrarAlerta("Se ha agregado el vehiculo");
                limpiarCamposAutomovil();
                limpiarCamposDeportivo();
            } else {
                Application.getApplication().mostrarAlerta("Faltan campos por llenar en Sedan");
            }
        }
    }

    //TODO
    private void limpiarCamposDeportivo() {

    }

    @FXML
    void guardarPickUp(ActionEvent ignoredEvent) {
        if (verificarCampos()) {
            cargarCampos();
            if (cmbTipo4X4PickUp.getValue() != null && !cmbCapacidadEjeCarga.getText().isEmpty()) {

                Pick_Up pick = new Pick_Up();
                pick.setEs4x4(MethodsUtilities.getTipo4x4PickUp(cmbTipo4X4PickUp.getValue()));
                pick.setCapacidadCajaCarga(Double.parseDouble(cmbCapacidadEjeCarga.getText()));
                addAtributosAutomovil(pick);
                Concesionario.getInstance().agregarVehiculo(pick);
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

    @FXML
    void guardarSedan(ActionEvent ignoredEvent) {

        if (verificarCampos()) {
            cargarCampos();
            if (!txtCapacidadMaleteroSedan.getText().isEmpty() && !cmbVelocidadCruceroSedan.getValue().isEmpty()) {

                Sedan sedan = new Sedan();
                sedan.setCapacidadMaletero(Double.parseDouble(txtCapacidadMaleteroSedan.getText()));
                sedan.setVelocidadCrucero(MethodsUtilities.getVelocidadCrucero(cmbVelocidadCruceroSedan.getValue()));
                addAtributosAutomovil(sedan);
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
        img1.setImage(new Image("file:src/main/resources/images/withOutImage.png"));
        img2.setImage(new Image("file:src/main/resources/images/withOutImage.png"));
        img3.setImage(new Image("file:src/main/resources/images/withOutImage.png"));
        img4.setImage(new Image("file:src/main/resources/images/withOutImage.png"));
        img5.setImage(new Image("file:src/main/resources/images/withOutImage.png"));
    }

    private String[] obtenerImages() {

        String[] im = new String[5];

        if (img1.getImage() != null) im[0] = MethodsUtilities.getImagePath(img1.getImage());
        if (img2.getImage() != null) im[1] = MethodsUtilities.getImagePath(img2.getImage());
        if (img3.getImage() != null) im[2] = MethodsUtilities.getImagePath(img3.getImage());
        if (img4.getImage() != null) im[3] = MethodsUtilities.getImagePath(img4.getImage());
        if (img5.getImage() != null) im[4] = MethodsUtilities.getImagePath(img5.getImage());
        return im;
    }

    @FXML
    void guardarSuv(ActionEvent ignoredEvent) {
        if (verificarCampos()) {

            if (!txtCapacidadMaleteroSuv.getText().isEmpty()
                    && cmbCapacidadCruceroSuv.getValue() != null && cmbTipo4X4Suv.getValue() != null) {

                Suv_Camioneta suv = new Suv_Camioneta();
                suv.setCapacidadMaletero(Double.parseDouble(txtCapacidadMaleteroSuv.getText()));
                suv.setVelocidadCrucero(MethodsUtilities.getVelocidadCrucero(cmbCapacidadCruceroSuv.getValue()));
                suv.setEs4x4(MethodsUtilities.getTipo4x4(cmbTipo4X4Suv.getValue()));
                addAtributosAutomovil(suv);

                Concesionario.getInstance().agregarVehiculo(suv);
                limpiarCamposAutomovil();
                limpiarCamposSuv();

            } else {
                Application.getApplication().mostrarAlerta("Faltan campos por llenar en Van");
            }


        } else {
            Application.getApplication().mostrarAlerta("Faltan campos por llenar en vehiculo");
        }

    }

    //TODO
    private void limpiarCamposSuv() {
        txtCapacidadMaleteroSuv.clear();
        cmbCapacidadCruceroSuv.setValue(null);
    }

    @FXML
    void guardarVan(ActionEvent ignoredEvent) {

        if (verificarCampos()) {

            if (!txtCapacidadMaleteroVan.getText().isEmpty()) {

                Van van = new Van();
                addAtributosAutomovil(van);
                van.setCapacidadMaletero(Double.parseDouble(txtCapacidadMaleteroVan.getText()));

                Concesionario.getInstance().agregarVehiculo(van);
                limpiarCamposAutomovil();
                limpiarCamposVan();

            } else {
                Application.getApplication().mostrarAlerta("Faltan campos por llenar en Van");
            }


        } else {
            Application.getApplication().mostrarAlerta("Faltan campos por llenar en vehiculo");
        }

    }

    private void limpiarCamposVan() {
        txtCapacidadMaleteroVan.clear();
    }

    private void addAtributosAutomovil(Automovil automovil) {

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
     * Metodo que limpia la tabla
     */
    private void vaciarTabla() {
        clientesObservableList.clear();
        tblClientes.getItems().clear();
        tblClientes.refresh();
    }

    /**
     * Metodo que refresca la tabla con un solo cliente
     *
     * @param cliente el que se va a mostrar
     */
    private void refrescarTabla(Cliente cliente) {

        tblClientes.getItems().clear();
        clientesObservableList.clear();
        clientesObservableList.add(cliente);
        tblClientes.getItems().addAll(clientesObservableList);
        tblClientes.refresh();

    }


    /**
     * Metodo que permite buscar un cliente por su cedula
     *
     * @param event que se genera al hacer escribir en el campo de texto
     */
    @FXML
    public void buscar(KeyEvent event) {
        String cedula = txtBuscar.getText();

        if (cedula.isEmpty()) {
            refrescarTabla();
        } else {
            Cliente cliente = Concesionario.getInstance().getClienteByCedula(cedula);
            if (cliente != null) refrescarTabla(cliente);
            else vaciarTabla();
        }
    }


    /**
     * Metodo que crea un cliente en el modelo
     *
     * @param ignoredEvent que generado al hacer click
     */
    @FXML
    public void crearCliente(ActionEvent ignoredEvent) {

        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();
        String email = txtEmail.getText();
        String contrasenia = txtContrasenia.getText();

        Cliente cliente = new Cliente(nombre, apellido, cedula, email, contrasenia);


        if (!nombre.isEmpty() && !apellido.isEmpty() && !cedula.isEmpty()
                && !email.isEmpty() && !contrasenia.isEmpty()) {

            if (Concesionario.getInstance().crearCliente(cliente)) {

                Application.getApplication().mostrarAlerta("Cliente creado con éxito");
                refrescarTabla();
                limpiarCampos();

            } else {

                Application.getApplication().mostrarAlerta("Ya existe un usuario con estos datos.");

            }
        } else {
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
    public void actualizarCliente(ActionEvent ignoredEvent) {

        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();
        System.out.println("cedula = " + cedula);
        String email = txtEmail.getText();
        String contrasenia = txtContrasenia.getText();

        if (Concesionario.getInstance().actualizarDatosCliente(nombre, apellido, cedula, email, contrasenia)) {
            tblClientes.refresh();
            Application.getApplication().mostrarAlerta("Cliente actualizado con éxito");
        } else {
            Application.getApplication().mostrarAlerta("No se pudo actualizar el cliente, verifique la cedula sea la correcta");
        }

    }

    /**
     * Metodo que carga los campos de texto con los datos del cliente seleccionado
     *
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
     *
     * @param ignoredEvent que se genera al hacer click
     */
    @FXML
    public void eliminarCliente(ActionEvent ignoredEvent) {

        Cliente cliente = tblClientes.getSelectionModel().getSelectedItem();
        Concesionario.getInstance().eliminarCliente(cliente.getCedula());
        refrescarTabla();
    }


    /**
     * Metodo que limpia los campos de texto de la vista
     */
    @FXML
    public void limpiarCampos() {
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
        cmbTipoCamion.getItems().addAll("Volqueta", "Remolque", "Tanque");
        cmbTipo4X4PickUp.getItems().addAll("Si", "No");
        cmbTipo4X4Suv.getItems().addAll("Si", "No");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContrasenia.setCellValueFactory(new PropertyValueFactory<>("contrasenia"));


        colCilindraje.setCellValueFactory(new PropertyValueFactory<>("cilindraje"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colNumeroPasajeros.setCellValueFactory(new PropertyValueFactory<>("combustible"));
        colNumeroPuertas.setCellValueFactory(new PropertyValueFactory<>("numeroPuertas"));
        colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colVelocidadMaxima.setCellValueFactory(new PropertyValueFactory<>("velocidadMaxima"));
        colCantCambios.setCellValueFactory(new PropertyValueFactory<>("cantCambios"));
        colNumeroPuertas.setCellValueFactory(new PropertyValueFactory<>("transmision"));

        colPlacaOp.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colMarcaOp.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModeloOp.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colNombreOp.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidosOp.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCedulaOp.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colEmailOp.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblClientes.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Cliente itemSeleccionado = tblClientes.getSelectionModel().getSelectedItem();
                if (itemSeleccionado != null) cargarCampos(itemSeleccionado);
            }
        });

        tableAutomoviles.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
               vehiculoSeleccionado = tableAutomoviles.getSelectionModel().getSelectedItem();
            }
        });
        refrescarTabla();

        Concesionario.getInstance().getListaVehiculos().forEach(e->tableAutomoviles.getItems().add(e));

        refrescarTablaOP();
    }

    public void refrescarTablaOP() {
        tblVehiculosOp.getItems().clear();
        tblClientesOp.getItems().clear();
        Concesionario.getInstance().getListaVehiculos().forEach(e->tblVehiculosOp.getItems().add(e));
        Concesionario.getInstance().getListaClientes().forEach(e->tblClientesOp.getItems().add(e));
    }

    public void refrescarTablaVehiculos(){
        tableAutomoviles.getItems().clear();
        Concesionario.getInstance().getListaVehiculos().forEach(e->tableAutomoviles.getItems().add(e));
    }

    public void eliminarVehiculo(ActionEvent ignoredEvent){
        if(vehiculoSeleccionado == null) return;
        Concesionario.getInstance().eliminarVehiculo(vehiculoSeleccionado.getPlaca());
        refrescarTablaVehiculos();
        Application.getApplication().mostrarAlerta("Vehiculo eliminado. se ha eliminado el vehiculo "+ vehiculoSeleccionado.getPlaca());
    }

    public void venderVehiculo(ActionEvent ignoredEvent){
        Cliente cliente = tblClientesOp.getSelectionModel().getSelectedItem();
        Vehiculo vehiculo = tblVehiculosOp.getSelectionModel().getSelectedItem();
        if(cliente != null && vehiculo != null){
            Concesionario.getInstance().venderVehiculo(cliente,vehiculo);
            MethodsUtilities.log("Se ha vendido el vehiculo "+vehiculo.getPlaca()+" al cliente "+cliente.getNombre()+" "+cliente.getApellido());
            System.err.println("Se ha vendido el vehiculo "+vehiculo.getPlaca()+" al cliente "+cliente.getNombre()+" "+cliente.getApellido());
            refrescarTablaVehiculos();
            refrescarTablaOP();
        }
    }

    public void alquilarVehiculo(ActionEvent ignoredEvent){
        Cliente cliente = tblClientesOp.getSelectionModel().getSelectedItem();
        Vehiculo vehiculo = tblVehiculosOp.getSelectionModel().getSelectedItem();
        if(cliente != null && vehiculo != null){
            Concesionario.getInstance().alquilarVehiculo(cliente,vehiculo);
            MethodsUtilities.log("Se ha alquilado el vehiculo "+vehiculo.getPlaca()+" al cliente "+cliente.getNombre()+" "+cliente.getApellido());
            System.err.println("Se ha alquilado el vehiculo "+vehiculo.getPlaca()+" al cliente "+cliente.getNombre()+" "+cliente.getApellido());
            refrescarTablaVehiculos();
            refrescarTablaOP();
        }
    }

}
