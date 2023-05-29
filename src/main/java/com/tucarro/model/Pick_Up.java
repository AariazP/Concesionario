package com.tucarro.model;

import java.util.Arrays;

public class Pick_Up extends Automovil{
	
	private Tipo4x4 es4x4;
	private double capacidadCajaCarga;
	
	public Pick_Up(TipoCombustible combustible, TipoTransmision transmision, String marca, String modelo,
			EstadoVehiculo estadoVehiculo, int velocidadMaxima, int cantCambios, int cilindraje, String[] fotos,
			TipoABS tieneAbs, String placa, DisponibilidadVehiculo disponibilidad, int numPasajeros, int numPuertas,
			TieneCamara tieneCamara, SensorTrafico tieneSensorTrafico, int numBolsasAire,
			TipoPermanencia asistentePermanencia, TipoAcondicionado aireAcondicionado, Tipo4x4 es4x4,
			double capacidadCajaCarga) {
		super(combustible, transmision, marca, modelo, estadoVehiculo, velocidadMaxima, cantCambios, cilindraje, fotos,
				tieneAbs, placa, disponibilidad, numPasajeros, numPuertas, tieneCamara, tieneSensorTrafico,
				numBolsasAire, asistentePermanencia, aireAcondicionado);
		
		this.es4x4 = es4x4;
		this.capacidadCajaCarga = capacidadCajaCarga;
	}

	@Override
	public void ToString() {
		System.out.println( "Pick_Up [es4x4=" + es4x4 + ", capacidadCajaCarga=" + capacidadCajaCarga + ", getNumPasajeros()="
				+ getNumPasajeros() + ", getNumPuertas()=" + getNumPuertas() + ", getTieneCamara()=" + getTieneCamara()
				+ ", getTieneSensorTrafico()=" + getTieneSensorTrafico() + ", getTieneSensorColision()="
				+ getTieneSensorColision() + ", getNumBolsasAire()=" + getNumBolsasAire()
				+ ", getAsistentePermanencia()=" + getAsistentePermanencia() + ", getAireAcondicionado()="
				+ getAireAcondicionado() + ", getCombustible()=" + getCombustible() + ", getTransmision()="
				+ getTransmision() + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo()
				+ ", getEstadoVehiculo()=" + getEstadoVehiculo() + ", getVelocidadMaxima()=" + getVelocidadMaxima()
				+ ", getCantCambios()=" + getCambios() + ", getCilindraje()=" + getCilindraje() + ", getFotos()="
				+ Arrays.toString(getFotos()) + ", getTieneAbs()=" + getAbs() + ", getPlaca()=" + getPlaca()
				+ ", getDisponibilidad()=" + getDisponibilidadVehiculo() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]");
	}

	public Tipo4x4 getEs4x4() {
		return es4x4;
	}

	public void setEs4x4(Tipo4x4 es4x4) {
		this.es4x4 = es4x4;
	}

	public double getCapacidadCajaCarga() {
		return capacidadCajaCarga;
	}

	public void setCapacidadCajaCarga(double capacidadCajaCarga) {
		this.capacidadCajaCarga = capacidadCajaCarga;
	}

	
}
