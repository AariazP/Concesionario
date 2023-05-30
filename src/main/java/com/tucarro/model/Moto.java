package com.tucarro.model;

import java.util.Arrays;

public class Moto extends Vehiculo{

    public Moto() {
        super();
    }

    public Moto(TipoCombustible combustible, TipoTransmision transmision, String marca, String modelo, EstadoVehiculo estadoVehiculo, int cantCambios, int velocidadMaxima, int cilindraje, String[] fotos, TipoABS tieneAbs, String placa, DisponibilidadVehiculo disponibilidadVehiculo) {
        super(combustible, transmision, marca, modelo, estadoVehiculo, cantCambios, velocidadMaxima, cilindraje, fotos, tieneAbs, placa, disponibilidadVehiculo);
    }



    public void ToString() {
        String mensaje = "*** CARACTERISTICAS DE LA MOTO ***\n\n" +
                "Marca: "+getMarca()+".\n" +
                "Modelo: "+getModelo()+".\n" +
                "Estado: "+getEstadoVehiculo()+".\n" +
                "Cambios: "+getCantCambios()+".\n" +
                "Velocidad máxima: "+getVelocidadMaxima()+".\n" +
                "Cilindraje: "+getCilindraje()+".\n" +
                "Combustible: "+getCombustible()+".\n" +
                "Transmisión: "+getTransmision()+".\n" +
                "Abs: "+getTieneAbs()+".\n" +
                "Fotos: "+ Arrays.toString(getFotos()) +".";

    }
}
