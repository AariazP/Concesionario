package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@Setter
@ToString
public class Van extends Automovil {
	
	private double capacidadMaletero;
	
	public Van() {
		super();
	}
}
