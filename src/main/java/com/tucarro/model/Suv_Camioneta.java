package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;


@Getter
@Setter
public class Suv_Camioneta extends Automovil{
	
	private double capacidadMaletero;
	private TipoVelocidad velocidadCrucero;
	private Tipo4x4 es4x4;
	
	public Suv_Camioneta(TipoCombustible combustible, TipoTransmision transmision, String marca, String modelo,
			EstadoVehiculo estadoVehiculo, int velocidadMaxima, int cantCambios, int cilindraje, String[] fotos,
			TipoABS tieneAbs, String placa, DisponibilidadVehiculo disponibilidad, int numPasajeros, int numPuertas,
			TieneCamara tieneCamara, SensorTrafico tieneSensorTrafico, int numBolsasAire,
			TipoPermanencia asistentePermanencia, TipoAcondicionado aireAcondicionado, double capacidadMaletero,
			TipoVelocidad velocidadCrucero, Tipo4x4 es4x4) {
		super(combustible, transmision, marca, modelo, estadoVehiculo, velocidadMaxima, cantCambios, cilindraje, fotos,
				tieneAbs, placa, disponibilidad, numPasajeros, numPuertas, tieneCamara, tieneSensorTrafico,
				numBolsasAire, asistentePermanencia, aireAcondicionado);
		this.capacidadMaletero = capacidadMaletero;
		this.velocidadCrucero = velocidadCrucero;
		this.es4x4 = es4x4;
	}


}
