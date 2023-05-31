package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Arrays;

@Getter
@Setter
@ToString

public class Sedan extends Automovil implements Serializable {
	
	private double capacidadMaletero;
	private TipoVelocidad velocidadCrucero;
	
	public Sedan() {
		super();
	}
	


}
