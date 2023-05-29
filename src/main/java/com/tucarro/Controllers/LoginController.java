package com.tucarro.Controllers;

import com.tucarro.application.Application;
import com.tucarro.model.Concesionario;
import com.tucarro.model.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
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
    void initialize() {
        rol.getItems().addAll("Administrador", "Empleado");   //Agrega valores al ChoiceBox
    }

    @FXML       //Evento relacionado al ingreso de datos por teclado.
    public void eventKey(KeyEvent textEvent) {
        Object evt = textEvent.getSource(); //Compara en que nodo está posicionado, para hacer validaciones.

        if ((evt.equals(txtUser)) || (evt.equals(txtPassword))) {
            if (textEvent.getCharacter().equals(" ")) {   //Condicional que verifica si el caracter igresado es un espacio en blanco.
                textEvent.consume();    //No permite ingresar espacios en blanco.
            }
        }
    }

    @FXML       //Evento relacionado a la acción del botón.
    public void ingresar(ActionEvent btnEvent) throws IOException {

        String usuario = txtUser.getText();
        String contrasenia = txtPassword.getText();
        String rolUsuario = rol.getValue();


        if (!usuario.isEmpty() && !contrasenia.isEmpty() && !rolUsuario.isEmpty()) {     //Condición que valida si los campos de textos están vacios.
            if (!elegirRol(usuario, contrasenia, rolUsuario)) {
                JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos, intente nuevamente.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Existen campos vacios", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }

    private boolean elegirRol(String usuario, String contrasenia, String rolUsuario) {

        Login login = new Login();
        boolean acceso = Concesionario.getInstance().iniciarSesion(usuario, contrasenia);

        if (acceso) {

            if (rolUsuario.equals("Administrador")) Application.getApplication().loadStage("administrador.fxml");
            else if (rolUsuario.equals("Empleado")) Application.getApplication().loadStage("empleado.fxml");
            return true;

        }

        return false;

    }


}



