package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Arrays;

@Getter
@Setter
@ToString
public class Bus extends Automovil implements Serializable {
	
	private int numEjes;
	private int numSalidasEmergencia;
	private double capacidadMaletero;

	public Bus() {
		super();
	}
	

}
