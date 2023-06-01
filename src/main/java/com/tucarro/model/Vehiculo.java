package com.tucarro.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@Getter
@Setter
@ToString
public abstract class Vehiculo implements Serializable {

    private EstadoVehiculo estadoVehiculo;

    private String marca;

    private String modelo;

    private int cantCambios;

    private Double velocidadMaxima;

    private int cilindraje;

    private TipoCombustible combustible;

    private TipoTransmision transmision;

    private String[] fotos;

    private TipoABS tieneAbs;

    private String placa;

    private DisponibilidadVehiculo disponibilidadVehiculo;

    public Vehiculo() {
    estadoVehiculo = EstadoVehiculo.NUEVO;
    }


    public boolean compararPlaca(String placa) {
        return this.placa.equals(placa);
    }

    public void isNuevo() {
        estadoVehiculo= EstadoVehiculo.NUEVO;
    }

    public void isUsado() {
        estadoVehiculo= EstadoVehiculo.USADO;
    }
    public String getCombustible(){
        if(TipoCombustible.DIESEL==combustible){
            return "Diesel";
        }if(TipoCombustible.HIBRIDO==combustible){
            return "Hibrido";
        }if(TipoCombustible.GASOLINA==combustible){
            return "Gasolina";
        }
        return "Electrico";
    }
}
