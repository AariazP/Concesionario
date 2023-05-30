package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@Setter
@ToString

public class Sedan extends Automovil{
	
	private double capacidadMaletero;
	private TipoVelocidad velocidadCrucero;
	
	public Sedan(TipoCombustible combustible, TipoTransmision transmision, String marca, String modelo,
			EstadoVehiculo estadoVehiculo, int velocidadMaxima, int cantCambios, int cilindraje, String[] fotos,
			TipoABS tieneAbs, String placa, DisponibilidadVehiculo disponibilidad, int numPasajeros, int numPuertas,
			TieneCamara tieneCamara, SensorTrafico tieneSensorTrafico, int numBolsasAire,
			TipoPermanencia asistentePermanencia, TipoAcondicionado aireAcondicionado, double capacidadMaletero,
			TipoVelocidad velocidadCrucero) {
		super(combustible, transmision, marca, modelo, estadoVehiculo, velocidadMaxima, cantCambios, cilindraje, fotos,
				tieneAbs, placa, disponibilidad, numPasajeros, numPuertas, tieneCamara, tieneSensorTrafico,
				numBolsasAire, asistentePermanencia, aireAcondicionado);
		this.capacidadMaletero = capacidadMaletero;
		this.velocidadCrucero = velocidadCrucero;
	}
	


}
