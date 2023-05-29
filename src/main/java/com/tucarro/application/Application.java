package com.tucarro.application;

import com.tucarro.utilities.Paths;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    private Stage stage;
    private static Application application;


    public static void main(String[] args) {
        launch();
    }



    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        application = this;
        loadStage(Paths.LOGIN);
    }


    public void loadStage(String ruta){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ruta));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            stage.setTitle("Iniciar sesión");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static Application getApplication(){
        return application;
    }



}