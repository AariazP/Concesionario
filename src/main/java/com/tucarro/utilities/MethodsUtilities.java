package com.tucarro.utilities;

import com.tucarro.model.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MethodsUtilities {

    /**
     * Este método se encarga de obtener la ruta de la imagen
     * seleccionada por el usuario usando el FileChooser
     *
     * @return String ruta
     */
    public static String getRutaImage() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar imagen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        File file = fileChooser.showOpenDialog(new Stage());
        return "file:///" + file.getAbsolutePath();

    }

    public static EstadoVehiculo getEstadoVehiculo(String selectedItem) {

        if (selectedItem.equals("Nuevo")) return EstadoVehiculo.NUEVO;
        return EstadoVehiculo.USADO;

    }

    public static TipoCombustible getTipoCombustible(String selectedItem) {

        if (selectedItem.equals("Gasolina")) return TipoCombustible.GASOLINA;
        if (selectedItem.equals("Diesel")) return TipoCombustible.DIESEL;
        return TipoCombustible.HIBRIDO;

    }

    public static TipoABS getTieneABS(String selectedItem) {

        if (selectedItem.equals("Si")) return TipoABS.SI;
        return TipoABS.NO;
    }

    public static DisponibilidadVehiculo getDisponibilidadVehiculo(String selectedItem) {

        if (selectedItem.equals("Si")) return DisponibilidadVehiculo.SI;
        return DisponibilidadVehiculo.NO;
    }

    public static TipoTransmision getTipoTransmision(String selectedItem) {

        if (selectedItem.equals("Manual")) return TipoTransmision.MANUAL;
        return TipoTransmision.AUTOMATICA;
    }

    public static TieneCamara getTieneCamara(String selectedItem) {

        if (selectedItem.equals("Si")) return TieneCamara.SI;
        return TieneCamara.NO;
    }

    public static SensorColision getTieneSensorColision(String selectedItem) {

        if (selectedItem.equals("Si")) return SensorColision.SI;
        return SensorColision.NO;
    }

    public static SensorTrafico getTieneSensorTrafico(String selectedItem) {

        if (selectedItem.equals("Si")) return SensorTrafico.SI;
        return SensorTrafico.NO;
    }

    public static TipoPermanencia getAsistentePermanencia(String selectedItem) {

        if (selectedItem.equals("Si")) return TipoPermanencia.SI;
        return TipoPermanencia.NO;
    }

    public static TipoAcondicionado getAireAcondicionado(String selectedItem) {

        if (selectedItem.equals("Si")) return TipoAcondicionado.SI;
        return TipoAcondicionado.NO;
    }

    public static TipoVelocidad getVelocidadCrucero(String value) {

        if (value.equals("Si")) return TipoVelocidad.SI;
        return TipoVelocidad.NO;
    }

    public static String getImagePath(Image image) {
        return image.getUrl();
    }

    public static Tipo4x4 getTipo4x4(String value) {

        if (value.equals("Si")) return Tipo4x4.SI;
        return Tipo4x4.NO;
    }

    public static TipoCamion getTipoCamion(String value) {

        if (value.equals("Tanque")) return TipoCamion.TANQUE;
        if (value.equals("Volqueta")) return TipoCamion.VOLQUETA;
        return TipoCamion.REMOLQUE;
    }

    public static Tipo4x4 getTipo4x4PickUp(String value) {

        if (value.equals("Si")) return Tipo4x4.SI;
        return Tipo4x4.NO;
    }
}
