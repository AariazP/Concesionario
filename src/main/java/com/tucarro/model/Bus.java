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
	

}
