package com.tucarro.model;

public class Cliente extends Persona{

	public Cliente(String nombre, String id, String correo, String pin) {
		super(nombre, id, correo, pin);
	}

	@Override
	public void ToString() {
		System.out.println( "Cliente [getNombre()=" + getNombre() + ", getId()=" + getId() + ", getCorreo()=" + getCorreo()
				+ ", getContrase�a()=" + getPin() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]");
	}
	
	

}
