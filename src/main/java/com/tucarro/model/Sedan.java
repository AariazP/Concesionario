package com.tucarro.model;

import java.util.Arrays;

public class Sedan extends Automovil{
	
	private double capacidadMaletero;
	private TipoVelocidad velocidadCrucero;
	
	public Sedan(TipoCombustible combustible, TipoTransmision transmision, String marca, String modelo,
			EstadoVehiculo estadoVehiculo, int velocidadMaxima, int cantCambios, int cilindraje, String[] fotos,
			TipoABS tieneAbs, String placa, DisponibilidadVehiculo disponibilidad, int numPasajeros, int numPuertas,
			TieneCamara tieneCamara, SensorTrafico tieneSensorTrafico, int numBolsasAire,
			TipoPermanencia asistentePermanencia, TipoAcondicionado aireAcondicionado, double capacidadMaletero,
			TipoVelocidad velocidadCrucero) {
		super(combustible, transmision, marca, modelo, estadoVehiculo, velocidadMaxima, cantCambios, cilindraje, fotos,
				tieneAbs, placa, disponibilidad, numPasajeros, numPuertas, tieneCamara, tieneSensorTrafico,
				numBolsasAire, asistentePermanencia, aireAcondicionado);
		this.capacidadMaletero = capacidadMaletero;
		this.velocidadCrucero = velocidadCrucero;
	}
	
	@Override
	public void ToString() {
		System.out.println( "Sedan [capacidadMaletero=" + capacidadMaletero + ", velocidadCrucero=" + velocidadCrucero
				+ ", getCapacidadMaletero()=" + getCapacidadMaletero() + ", getVelocidadCrucero()="
				+ getVelocidadCrucero() + ", getNumPasajeros()=" + getNumPasajeros() + ", getNumPuertas()="
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


}
