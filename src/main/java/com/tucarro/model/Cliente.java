package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
public class Cliente extends Persona implements Serializable {

	private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

	public Cliente(String nombre, String apellido, String cedula, String email, String contrasenia) {

		super(nombre, apellido, cedula, email, contrasenia);
		vehiculos = new ArrayList<>();
	}


    public void agregarVehiculo(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
    }
}
