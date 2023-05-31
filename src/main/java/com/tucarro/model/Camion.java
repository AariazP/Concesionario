package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Arrays;


@Setter
@Getter
@ToString
public class Camion extends Automovil implements Serializable {
	
	private double capacidadCarga;
	private TipoAire frenosAire;
	private TipoCamion tipoC;
	private int numEjes;

	public Camion() {
		super();
	}

	
	
}
