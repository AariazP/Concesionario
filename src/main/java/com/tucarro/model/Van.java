package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;


@Getter
@Setter
@ToString
public class Van extends Automovil implements Serializable {
	
	private double capacidadMaletero;
	
	public Van() {
		super();
	}
}
