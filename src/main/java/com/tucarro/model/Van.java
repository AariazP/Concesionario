package com.tucarro.model;

import java.util.Arrays;

public class Van extends Automovil {
	
	private double capacidadMaletero;
	
	public Van(TipoCombustible combustible, TipoTransmision transmision, String marca, String modelo,
			EstadoVehiculo estadoVehiculo, int velocidadMaxima, int cantCambios, int cilindraje, String[] fotos,
			TipoABS tieneAbs, String placa, DisponibilidadVehiculo disponibilidad, int numPasajeros, int numPuertas,
			TieneCamara tieneCamara, SensorTrafico tieneSensorTrafico, int numBolsasAire,
			TipoPermanencia asistentePermanencia, TipoAcondicionado aireAcondicionado,double capacidadMaletero) {
		super(combustible, transmision, marca, modelo, estadoVehiculo, velocidadMaxima, cantCambios, cilindraje, fotos,
				tieneAbs, placa, disponibilidad, numPasajeros, numPuertas, tieneCamara, tieneSensorTrafico, numBolsasAire,
				asistentePermanencia, aireAcondicionado);
		 this.capacidadMaletero=capacidadMaletero;
	
	}

	@Override
	public void ToString() {
		System.out.println( "Van [capacidadMaletero=" + capacidadMaletero + ", getCapacidadMaletero()=" + getCapacidadMaletero()
				+ ", getNumPasajeros()=" + getNumPasajeros() + ", getNumPuertas()=" + getNumPuertas()
				+ ", getTieneCamara()=" + getTieneCamara() + ", getTieneSensorTrafico()=" + getTieneSensorTrafico()
				+ ", getTieneSensorColision()=" + getTieneSensorColision() + ", getNumBolsasAire()="
				+ getNumBolsasAire() + ", getAsistentePermanencia()=" + getAsistentePermanencia()
				+ ", getAireAcondicionado()=" + getAireAcondicionado() + ", getCombustible()=" + getCombustible()
				+ ", getTransmision()=" + getTransmision() + ", getMarca()=" + getMarca() + ", getModelo()="
				+ getModelo() + ", getEstadoVehiculo()=" + getEstadoVehiculo() + ", getVelocidadMaxima()="
				+ getVelocidadMaxima() + ", getCantCambios()=" + getCambios() + ", getCilindraje()="
				+ getCilindraje() + ", getFotos()=" + Arrays.toString(getFotos()) + ", getTieneAbs()=" + getAbs()
				+ ", getPlaca()=" + getPlaca() + ", getDisponibilidad()=" + getDisponibilidadVehiculo() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]");
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
