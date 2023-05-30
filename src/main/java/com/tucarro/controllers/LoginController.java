package com.tucarro.controllers;

import com.tucarro.application.Application;
import com.tucarro.model.Login;
import com.tucarro.utilities.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private ChoiceBox<String> rol;
    @FXML
    private Button btnLogin;
    //-------------------------------------Métodos------------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

            Login login = new Login();
            acceso = login.iniciarSesion(usuario, contrasenia);

            if (acceso) {
                if(rolUsuario.equals("Administrador")){
                    Application.getApplication().loadStage(Paths.ADMINISTRADOR);

                }else if (rolUsuario.equals("Empleado")){
                    Application.getApplication().loadStage(Paths.EMPLEADO);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos, intente nuevamente.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión, ingrese sus datos de acceso.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }

}