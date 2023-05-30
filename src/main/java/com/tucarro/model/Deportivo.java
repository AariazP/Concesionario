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

	public Deportivo() {
		super();
	}
 
	
}
