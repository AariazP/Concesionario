package com.tucarro.model;

import java.util.Arrays;

public class Suv_Camioneta extends Automovil{
	
	private double capacidadMaletero;
	private TipoVelocidad velocidadCrucero;
	private Tipo4x4 es4x4;
	
	public Suv_Camioneta(TipoCombustible combustible, TipoTransmision transmision, String marca, String modelo,
			EstadoVehiculo estadoVehiculo, int velocidadMaxima, int cantCambios, int cilindraje, String[] fotos,
			TipoABS tieneAbs, String placa, DisponibilidadVehiculo disponibilidad, int numPasajeros, int numPuertas,
			TieneCamara tieneCamara, SensorTrafico tieneSensorTrafico, int numBolsasAire,
			TipoPermanencia asistentePermanencia, TipoAcondicionado aireAcondicionado, double capacidadMaletero,
			TipoVelocidad velocidadCrucero, Tipo4x4 es4x4) {
		super(combustible, transmision, marca, modelo, estadoVehiculo, velocidadMaxima, cantCambios, cilindraje, fotos,
				tieneAbs, placa, disponibilidad, numPasajeros, numPuertas, tieneCamara, tieneSensorTrafico,
				numBolsasAire, asistentePermanencia, aireAcondicionado);
		this.capacidadMaletero = capacidadMaletero;
		this.velocidadCrucero = velocidadCrucero;
		this.es4x4 = es4x4;
	}

	@Override
	public void ToString() {
		System.out.println( "Suv_Camioneta [capacidadMaletero=" + capacidadMaletero + ", velocidadCrucero=" + velocidadCrucero
				+ ", es4x4=" + es4x4 + ", getNumPasajeros()=" + getNumPasajeros() + ", getNumPuertas()="
				+ getNumPuertas() + ", getTieneCamara()=" + getTieneCamara() + ", getTieneSensorTrafico()="
				+ getTieneSensorTrafico() + ", getTieneSensorColision()=" + getTieneSensorColision()
				+ ", getNumBolsasAire()=" + getNumBolsasAire() + ", getAsistentePermanencia()="
				+ getAsistentePermanencia() + ", getAireAcondicionado()=" + getAireAcondicionado()
				+ ", getCombustible()=" + getCombustible() + ", getTransmision()=" + getTransmision() + ", getMarca()="
				+ getMarca() + ", getModelo()=" + getModelo() + ", getEstadoVehiculo()=" + getEstadoVehiculo()
				+ ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCantCambios()=" + getCambios()
				+ ", getCilindraje()=" + getCilindraje() + ", getFotos()=" + Arrays.toString(getFotos())
				+ ", getTieneAbs()=" + getAbs() + ", getPlaca()=" + getPlaca() + ", getDisponibilidad()="
				+ getDisponibilidadVehiculo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]");
	}

	public double getCapacidadMaletero() {
		return capacidadMaletero;
	}

	public void setCapacidadMaletero(double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

	public TipoVelocidad getVelocidadCrucero() {
		return velocidadCrucero;
	}

	public void setVelocidadCrucero(TipoVelocidad velocidadCrucero) {
		this.velocidadCrucero = velocidadCrucero;
	}

	public Tipo4x4 getEs4x4() {
		return es4x4;
	}

	public void setEs4x4(Tipo4x4 es4x4) {
		this.es4x4 = es4x4;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
