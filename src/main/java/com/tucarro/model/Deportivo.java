package com.tucarro.model;

import java.util.Arrays;

public class Deportivo extends Automovil {
	
	private int numCaballosFuerza;
	private double tiempo0_100;
	public Deportivo(TipoCombustible combustible, TipoTransmision transmision, String marca, String modelo,
			EstadoVehiculo estadoVehiculo, int velocidadMaxima, int cantCambios, int cilindraje, String[] fotos,
			TipoABS tieneAbs, String placa, DisponibilidadVehiculo disponibilidad, int numPasajeros, int numPuertas,
			TieneCamara tieneCamara, SensorTrafico tieneSensorTrafico, int numBolsasAire,
			TipoPermanencia asistentePermanencia, TipoAcondicionado aireAcondicionado) {
		super(combustible, transmision, marca, modelo, estadoVehiculo, velocidadMaxima, cantCambios, cilindraje, fotos,
				tieneAbs, placa, disponibilidad, numPasajeros, numPuertas, tieneCamara, tieneSensorTrafico, numBolsasAire,
				asistentePermanencia, aireAcondicionado);
		
	
		this.numCaballosFuerza = numCaballosFuerza;
		this.tiempo0_100 = tiempo0_100;
	}
	
	@Override
	public void ToString() {
		System.out.println( "Deportivo [numCaballosFuerza=" + numCaballosFuerza + ", tiempo0_100=" + tiempo0_100
				+ ", getNumCaballosFuerza()=" + getNumCaballosFuerza() + ", getTiempo0_100()=" + getTiempo0_100()
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



	public int getNumCaballosFuerza() {
		return numCaballosFuerza;
	}
	public void setNumCaballosFuerza(int numCaballosFuerza) {
		this.numCaballosFuerza = numCaballosFuerza;
	}
	public double getTiempo0_100() {
		return tiempo0_100;
	}
	public void setTiempo0_100(double tiempo0_100) {
		this.tiempo0_100 = tiempo0_100;
	}
 
	
}
