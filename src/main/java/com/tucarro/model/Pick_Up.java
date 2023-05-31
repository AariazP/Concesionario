package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
public class Pick_Up extends Automovil implements Serializable {
	
	private Tipo4x4 es4x4;
	private double capacidadCajaCarga;
	
	public Pick_Up() {
		super();
	}



	
}
