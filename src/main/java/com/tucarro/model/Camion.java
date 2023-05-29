package com.tucarro.model;

import java.util.Arrays;

public class Camion extends Automovil {
	
	private double capacidadCarga;
	private TipoAire frenosAire;
	private TipoCamion tipoC;
	private int numEjes;
	public Camion(TipoCombustible combustible, TipoTransmision transmision, String marca, String modelo,
			EstadoVehiculo estadoVehiculo, int velocidadMaxima, int cantCambios, int cilindraje, String[] fotos,
			TipoABS tieneAbs, String placa, DisponibilidadVehiculo disponibilidad, int numPasajeros, int numPuertas,
			TieneCamara tieneCamara, SensorTrafico tieneSensorTrafico, int numBolsasAire,
			TipoPermanencia asistentePermanencia, TipoAcondicionado aireAcondicionado) {
		super(combustible, transmision, marca, modelo, estadoVehiculo, velocidadMaxima, cantCambios, cilindraje, fotos,
				tieneAbs, placa, disponibilidad, numPasajeros, numPuertas, tieneCamara, tieneSensorTrafico, numBolsasAire,
				asistentePermanencia, aireAcondicionado);
		
		this.capacidadCarga = capacidadCarga;
		this.frenosAire = frenosAire;
		this.tipoC = tipoC;
		this.numEjes = numEjes;
	}
	
	@Override
	public void ToString() {
		System.out.println( "Camion [capacidadCarga=" + capacidadCarga + ", frenosAire=" + frenosAire + ", tipoC=" + tipoC
				+ ", numEjes=" + numEjes + ", getCapacidadCarga()=" + getCapacidadCarga() + ", getFrenosAire()="
				+ getFrenosAire() + ", getTipoC()=" + getTipoC() + ", getNumEjes()=" + getNumEjes()
				+ ", getNumPasajeros()=" + getNumPasajeros() + ", getNumPuertas()=" + getNumPuertas()
				+ ", getTieneCamara()=" + getTieneCamara() + ", getTieneSensorTrafico()=" + getTieneSensorTrafico()
				+ ", getTieneSensorColision()=" + getTieneSensorColision() + ", getNumBolsasAire()="
				+ getNumBolsasAire() + ", getAsistentePermanencia()=" + getAsistentePermanencia()
				+ ", getAireAcondicionado()=" + getAireAcondicionado() + ", getCombustible()=" + getCombustible()
				+ ", getTransmision()=" + getTransmision() + ", getMarca()=" + getMarca() + ", getModelo()="
				+ getModelo() + ", getEstadoVehiculo()=" + getEstadoVehiculo() + ", getVelocidadMaxima()="
				+ getVelocidadMaxima() + ", getCantCambios()=" +getCambios() + ", getCilindraje()="
				+ getCilindraje() + ", getFotos()=" + Arrays.toString(getFotos()) + ", getTieneAbs()=" + getAbs()
				+ ", getPlaca()=" + getPlaca() + ", getDisponibilidad()=" +getDisponibilidadVehiculo() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]");
	}

	public double getCapacidadCarga() {
		return capacidadCarga;
	}
	public void setCapacidadCarga(double capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}
	public TipoAire getFrenosAire() {
		return frenosAire;
	}
	public void setFrenosAire(TipoAire frenosAire) {
		this.frenosAire = frenosAire;
	}
	public TipoCamion getTipoC() {
		return tipoC;
	}
	public void setTipoC(TipoCamion tipoC) {
		this.tipoC = tipoC;
	}
	public int getNumEjes() {
		return numEjes;
	}
	public void setNumEjes(int numEjes) {
		this.numEjes = numEjes;
	}
	
	
	
}
