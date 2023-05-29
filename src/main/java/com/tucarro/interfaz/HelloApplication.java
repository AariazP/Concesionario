package com.tucarro.interfaz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/empleado.fxml")));
        Scene scene = new Scene(fxmlLoader);
        stage.setTitle("Iniciar sesión");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}