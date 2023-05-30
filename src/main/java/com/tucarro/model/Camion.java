package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;


@Setter
@Getter
@ToString
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
	

	
	
}
