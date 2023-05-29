package com.tucarro.model;

import java.util.Arrays;

public abstract class Automovil extends Vehiculo {
	
	private int numPasajeros;
	private int numPuertas;
	private TieneCamara tieneCamara;
	private SensorTrafico tieneSensorTrafico;
	private SensorColision tieneSensorColision;
	private int numBolsasAire;
	private TipoPermanencia asistentePermanencia;
	private TipoAcondicionado aireAcondicionado;
	
	public Automovil( TipoCombustible combustible, TipoTransmision transmision, String marca, String modelo,
			EstadoVehiculo estadoVehiculo, int velocidadMaxima, int cantCambios, int cilindraje, String[] fotos,
			TipoABS tieneAbs, String placa, DisponibilidadVehiculo disponibilidadVehiculo,int numPasajeros,int numPuertas,TieneCamara tieneCamara,
			SensorTrafico tieneSensorTrafico,int numBolsasAire,TipoPermanencia asistentePermanencia,TipoAcondicionado aireAcondicionado) {
		
		super(combustible, transmision, marca, modelo, estadoVehiculo, velocidadMaxima, cantCambios, cilindraje, fotos,
				tieneAbs, placa, disponibilidadVehiculo);
		
		this.numPasajeros = numPasajeros;
		this.numPuertas = numPuertas;
		this.tieneCamara = tieneCamara;
		this.tieneSensorTrafico = tieneSensorTrafico;
		this.tieneSensorColision = tieneSensorColision;
		this.numBolsasAire = numBolsasAire;
		this.asistentePermanencia = asistentePermanencia;
		this.aireAcondicionado = aireAcondicionado;
	}
    
	
	@Override
	public void ToString() {
		System.out.println( "Automovil [numPasajeros=" + numPasajeros + ", numPuertas=" + numPuertas + ", tieneCamara=" + tieneCamara
				+ ", tieneSensorTrafico=" + tieneSensorTrafico + ", tieneSensorColision=" + tieneSensorColision
				+ ", numBolsasAire=" + numBolsasAire + ", asistentePermanencia=" + asistentePermanencia
				+ ", aireAcondicionado=" + aireAcondicionado + ", getNumPasajeros()=" + getNumPasajeros()
				+ ", getNumPuertas()=" + getNumPuertas() + ", getTieneCamara()=" + getTieneCamara()
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


	public int getNumPasajeros() {
		return numPasajeros;
	}

	public void setNumPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public TieneCamara getTieneCamara() {
		return tieneCamara;
	}

	public void setTieneCamara(TieneCamara tieneCamara) {
		this.tieneCamara = tieneCamara;
	}

	public SensorTrafico getTieneSensorTrafico() {
		return tieneSensorTrafico;
	}

	public void setTieneSensorTrafico(SensorTrafico tieneSensorTrafico) {
		this.tieneSensorTrafico = tieneSensorTrafico;
	}

	public SensorColision getTieneSensorColision() {
		return tieneSensorColision;
	}

	public void setTieneSensorColision(SensorColision tieneSensorColision) {
		this.tieneSensorColision = tieneSensorColision;
	}

	public int getNumBolsasAire() {
		return numBolsasAire;
	}

	public void setNumBolsasAire(int numBolsasAire) {
		this.numBolsasAire = numBolsasAire;
	}

	public TipoPermanencia getAsistentePermanencia() {
		return asistentePermanencia;
	}

	public void setAsistentePermanencia(TipoPermanencia asistentePermanencia) {
		this.asistentePermanencia = asistentePermanencia;
	}

	public TipoAcondicionado getAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(TipoAcondicionado aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}







}
