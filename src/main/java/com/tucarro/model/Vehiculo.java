package com.tucarro.model;

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
    public abstract void ToString();

    //Métodos Getters and Setters

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public EstadoVehiculo getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(EstadoVehiculo estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public int getCambios() {
        return cantCambios;
    }

    public void setCambios(int cambios) {
        this.cantCambios = cantCambios;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public TipoCombustible getCombustible() {
        return combustible;
    }

    public void setCombustible(TipoCombustible combustible) {
        this.combustible = combustible;
    }

    public TipoTransmision getTransmision() {
        return transmision;
    }

    public void setTransmision(TipoTransmision transmision) {
        this.transmision = transmision;
    }

    public String[] getFotos() {
        return fotos;
    }

    public void setFotos(String[] fotos) {
        this.fotos = fotos;
    }

    public TipoABS getAbs() {
        return tieneAbs;
    }

    public void setAbs(TipoABS abs) {
        this.tieneAbs =tieneAbs;
    }

    public String getPlaca(){return placa;}
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public DisponibilidadVehiculo getDisponibilidadVehiculo() {
        return disponibilidadVehiculo;
    }

    public void setDisponibilidadVehiculo(DisponibilidadVehiculo disponibilidadVehiculo) {
        this.disponibilidadVehiculo = disponibilidadVehiculo;
    }
}
