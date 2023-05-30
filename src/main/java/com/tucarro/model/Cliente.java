package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Persona{

	private String estado;

	public Cliente(String nombre, String apellido, String cedula, String email, String contrasenia, String estado) {
		super(nombre, apellido, cedula, email, contrasenia);
		this.estado = estado;
	}

	
	

}
