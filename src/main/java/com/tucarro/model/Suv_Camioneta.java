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
	
 	public Suv_Camioneta() {
		super();
	}

}
