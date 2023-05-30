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

    private Double velocidadMaxima;

    private int cilindraje;

    private TipoCombustible combustible;

    private TipoTransmision transmision;

    private String[] fotos;

    private TipoABS tieneAbs;

    private String placa;

    private DisponibilidadVehiculo disponibilidadVehiculo;

    public Vehiculo() {

    }




}
