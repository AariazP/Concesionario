package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@Setter
@ToString
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
	

}
