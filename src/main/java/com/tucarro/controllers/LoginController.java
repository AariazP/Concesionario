package com.tucarro.controllers;

import com.tucarro.application.Application;
import com.tucarro.model.Concesionario;
import com.tucarro.utilities.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private ChoiceBox<String> rol;
    @FXML
    private Button btnLogin;
    //-------------------------------------Métodos------------------------------------------------

    @FXML
    public void initialize() {
        rol.getItems().addAll("Administrador", "Empleado");   //Agrega valores al ChoiceBox
    }

    @FXML       //Evento relacionado al ingreso de datos por teclado.
    public void eventKey(KeyEvent textEvent) {
        Object evt = textEvent.getSource(); //Compara en que nodo está posicionado, para hacer validaciones.

        if((evt.equals(txtUser)) || (evt.equals(txtPassword)) ){
            if(textEvent.getCharacter().equals(" ")){   //Condicional que verifica si el caracter igresado es un espacio en blanco.
                textEvent.consume();    //No permite ingresar espacios en blanco.
            }
        }
    }

    @FXML       //Evento relacionado a la acción del botón.
    public void ingresar(ActionEvent btnEvent) throws IOException {

        if (!txtUser.getText().isEmpty() && !txtPassword.getText().isEmpty() && !rol.getValue().isEmpty()) {     //Condición que valida si los campos de textos están vacios.
            boolean acceso;
            String usuario = txtUser.getText();
            String contrasenia = txtPassword.getText();
            String rolUsuario = rol.getValue();



            if (Concesionario.getInstance().login(usuario, contrasenia, rolUsuario)) {
                if(rolUsuario.equals("Administrador")){
                    Application.getApplication().loadStage(Paths.ADMINISTRADOR);

                }else if (rolUsuario.equals("Empleado")){
                    Application.getApplication().loadStage(Paths.EMPLEADO);
                }

            } else {
                Application.getApplication().mostrarAlerta("Datos de acceso incorrectos, intente nuevamente.");
            }
        } else {
            Application.getApplication().mostrarAlerta("Debe ingresar todos los datos.");
        }
    }

}