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
	
	public Pick_Up() {
		super();
	}



	
}
