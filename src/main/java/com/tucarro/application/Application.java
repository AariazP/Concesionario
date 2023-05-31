package com.tucarro.application;

import com.tucarro.model.Concesionario;
import com.tucarro.utilities.MethodsUtilities;
import com.tucarro.utilities.Paths;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    private Stage stage;
    private static Application application;


    public static void main(String[] args) {
        launch();
    }


    /**
     * Método que inicia la aplicación
     * @param stage ventana principal
     * @throws IOException excepción de entrada y salida
     */
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
       //cuando la ventana se cierra se guarda el concesionario
        stage.setOnCloseRequest(e -> {
            MethodsUtilities.serializarConcesionario(Concesionario.getInstance());
        });
        application = this;
        loadStage(Paths.LOGIN);
    }

    /**
     * Método que carga una nueva ventana a partir de una ruta
     * @param ruta ruta del archivo fxml
     */
    public void loadStage(String ruta){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ruta));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
            stage.setTitle("Iniciar sesión");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Singleton, se usa para obtener la instancia de la aplicación
     * y que sea unica en toda la aplicación
     * @return instancia de la aplicación
     */
    public static Application getApplication(){
        return application;
    }

    public void mostrarAlerta(String mensaje){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();


    }



}