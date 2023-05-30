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










}
