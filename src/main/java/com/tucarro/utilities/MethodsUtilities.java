package com.tucarro.utilities;

import com.tucarro.model.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public static void log(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = String.format("[%s] %s", timestamp, message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Paths.RUTA_LOG, true))) {
            writer.write(logMessage);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de log: " + e.getMessage());
        }
    }


    /**
     * Metodo que serializa el concesionario en binario, para que se pueda
     * cargar la informacion de los vehiculos en el programa
     * @param concesionario el concesionario a serializar
     */
    public static void serializarConcesionario(Concesionario concesionario){

        try {
            FileOutputStream fileOut = new FileOutputStream(Paths.RUTA_CONCESIONARIO);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(concesionario);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + Paths.RUTA_CONCESIONARIO);
        } catch (IOException i) {
            i.printStackTrace();
        }


    }


    public static Concesionario deserializarConcesionario() {
        Concesionario concesionario = null;
        try {
            FileInputStream fileIn = new FileInputStream(Paths.RUTA_CONCESIONARIO);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            concesionario = (Concesionario) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Concesionario class not found");
            c.printStackTrace();
        }
        return concesionario;
    }
}
