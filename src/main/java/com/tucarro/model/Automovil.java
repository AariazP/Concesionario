package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Setter
@Getter
@ToString
public abstract class Automovil extends Vehiculo {
	
	private int numPasajeros;
	private int numPuertas;
	private TieneCamara tieneCamara;
	private SensorTrafico tieneSensorTrafico;
	private SensorColision tieneSensorColision;
	private int numBolsasAire;
	private TipoPermanencia asistentePermanencia;
	private TipoAcondicionado aireAcondicionado;

	public Automovil() {

	}


	
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
    
	








}
