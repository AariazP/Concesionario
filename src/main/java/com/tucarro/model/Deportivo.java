package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
public class Deportivo extends Automovil implements Serializable {
	
	private int numCaballosFuerza;
	private double tiempo0_100;

	public Deportivo() {
		super();
	}
 
	
}
