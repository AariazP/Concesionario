package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
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



	
}
