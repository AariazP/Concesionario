package com.tucarro.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Vehiculo{

    private EstadoVehiculo estadoVehiculo;
    private String marca;
    private String modelo;
    private int cantCambios;
    private int velocidadMaxima;
    private int cilindraje;
    private TipoCombustible combustible;
    private TipoTransmision transmision;
    private String[] fotos;
    private TipoABS tieneAbs;

    private String placa;

    private DisponibilidadVehiculo disponibilidadVehiculo;

    public Vehiculo() {

    }

    //Constructor
    public Vehiculo(TipoCombustible combustible,TipoTransmision transmision, String marca, String modelo, EstadoVehiculo estadoVehiculo, int cantCambios, int velocidadMaxima, int cilindraje,
                     String[] fotos, TipoABS tieneAbs,String placa,
                DisponibilidadVehiculo disponibilidadVehiculo ){
        this.marca = marca;
        this.modelo = modelo;
        this.estadoVehiculo = estadoVehiculo;
        this.cantCambios = cantCambios;
        this.velocidadMaxima = velocidadMaxima;
        this.cilindraje = cilindraje;
        this.combustible = combustible;
        this.transmision = transmision;
        this.fotos = fotos;
        this.tieneAbs = tieneAbs;
        this.placa=placa;
        this.disponibilidadVehiculo=disponibilidadVehiculo;
    }


}
