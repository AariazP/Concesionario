package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Persona{



	public Cliente(String nombre, String apellido, String cedula, String email, String contrasenia) {
		super(nombre, apellido, cedula, email, contrasenia);
	}

	
	

}
