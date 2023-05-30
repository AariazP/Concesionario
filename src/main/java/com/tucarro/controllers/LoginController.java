package com.tucarro.controllers;

import com.tucarro.application.Application;
import com.tucarro.model.Concesionario;
import com.tucarro.utilities.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    public void initialize() {
    }

    @FXML
    public void eventKey(KeyEvent textEvent) {
        Object evt = textEvent.getSource(); //Compara en que nodo está posicionado, para hacer validaciones.

        if ((evt.equals(txtUser)) || (evt.equals(txtPassword))) {
            if (textEvent.getCharacter().equals(" ")) {   //Condicional que verifica si el caracter igresado es un espacio en blanco.
                textEvent.consume();    //No permite ingresar espacios en blanco.
            }
        }
    }

    @FXML
    public void ingresar(ActionEvent btnEvent) throws IOException {
        //Verifico si los campos están completos
        if (!txtUser.getText().isEmpty() && !txtPassword.getText().isEmpty()) {

            String usuario = txtUser.getText();
            String contrasenia = txtPassword.getText();
            String tipoUsuario = Concesionario.getInstance().login(usuario, contrasenia);

            if (tipoUsuario.equals("Administrador")) {
                Application.getApplication().loadStage(Paths.ADMINISTRADOR);

            } else if (tipoUsuario.equals("Empleado")) {
                Application.getApplication().loadStage(Paths.EMPLEADO);
            } else {
                Application.getApplication().mostrarAlerta("Datos de acceso incorrectos, intente nuevamente.");
            }


        } else {
            Application.getApplication().mostrarAlerta("Debe ingresar todos los datos.");
        }
    }

}