package com.tucarro.utilities;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MethodsUtilities {

    /**
     * Este método se encarga de obtener la ruta de la imagen
     * seleccionada por el usuario usando el FileChooser
     * @return String ruta
     */
    public static String getRutaImage(){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar imagen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        File file = fileChooser.showOpenDialog(new Stage());
        return "file:///" + file.getAbsolutePath();

    }
}
