package com.tucarro.model;

import java.util.Arrays;

public class Bus extends Automovil{
	
	private int numEjes;
	private int numSalidasEmergencia;
	private double capacidadMaletero;

	public Bus() {
		super();
	}
	
	public Bus(TipoCombustible combustible, TipoTransmision transmision, String marca, String modelo,
			EstadoVehiculo estadoVehiculo, int velocidadMaxima, int cantCambios, int cilindraje, String[] fotos,
			TipoABS tieneAbs, String placa, DisponibilidadVehiculo disponibilidad, int numPasajeros, int numPuertas,
			TieneCamara tieneCamara, SensorTrafico tieneSensorTrafico, int numBolsasAire,
			TipoPermanencia asistentePermanencia, TipoAcondicionado aireAcondicionado, int numEjes,
			int numSalidasEmergencia, double capacidadMaletero) {
		super(combustible, transmision, marca, modelo, estadoVehiculo, velocidadMaxima, cantCambios, cilindraje, fotos,
				tieneAbs, placa, disponibilidad, numPasajeros, numPuertas, tieneCamara, tieneSensorTrafico,
				numBolsasAire, asistentePermanencia, aireAcondicionado);
		this.numEjes = numEjes;
		this.numSalidasEmergencia = numSalidasEmergencia;
		this.capacidadMaletero = capacidadMaletero;
	}
	
	@Override
	public void ToString() {
		System.out.println( "Bus [numEjes=" + numEjes + ", numSalidasEmergencia=" + numSalidasEmergencia + ", capacidadMaletero="
				+ capacidadMaletero + ", getNumEjes()=" + getNumEjes() + ", getNumSalidasEmergencia()="
				+ getNumSalidasEmergencia() + ", getCapacidadMaletero()=" + getCapacidadMaletero()
				+ ", getNumPasajeros()=" + getNumPasajeros() + ", getNumPuertas()=" + getNumPuertas()
				+ ", getTieneCamara()=" + getTieneCamara() + ", getTieneSensorTrafico()=" + getTieneSensorTrafico()
				+ ", getTieneSensorColision()=" + getTieneSensorColision() + ", getNumBolsasAire()="
				+ getNumBolsasAire() + ", getAsistentePermanencia()=" + getAsistentePermanencia()
				+ ", getAireAcondicionado()=" + getAireAcondicionado() + ", getCombustible()=" + getCombustible()
				+ ", getTransmision()=" + getTransmision() + ", getMarca()=" + getMarca() + ", getModelo()="
				+ getModelo() + ", getEstadoVehiculo()=" + getEstadoVehiculo() + ", getVelocidadMaxima()="
				+ getVelocidadMaxima() + ", getCantCambios()=" + getCambios() + ", getCilindraje()="
				+ getCilindraje() + ", getFotos()=" + Arrays.toString(getFotos()) + ", getTieneAbs()=" +getAbs()
				+ ", getPlaca()=" + getPlaca() + ", getDisponibilidad()=" + getDisponibilidadVehiculo() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]");
	}

	public int getNumEjes() {
		return numEjes;
	}

	public void setNumEjes(int numEjes) {
		this.numEjes = numEjes;
	}

	public int getNumSalidasEmergencia() {
		return numSalidasEmergencia;
	}

	public void setNumSalidasEmergencia(int numSalidasEmergencia) {
		this.numSalidasEmergencia = numSalidasEmergencia;
	}

	public double getCapacidadMaletero() {
		return capacidadMaletero;
	}

	public void setCapacidadMaletero(double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}


	@Override
	public String toString() {
		return null;
	}
}
