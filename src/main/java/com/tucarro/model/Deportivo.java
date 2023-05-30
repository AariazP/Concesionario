package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
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

 
	
}
