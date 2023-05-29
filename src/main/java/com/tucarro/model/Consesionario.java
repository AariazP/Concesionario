package com.tucarro.model;

import java.util.ArrayList;
import java.util.List;

public enum Consesionario {
	INSTANCIA;
	
	private List<Reporte> reportes;
	private List<Empleado> listEmpleados;
	private List<Vehiculo> listVehiculos;
	
	
	Consesionario() {
		// TODO Auto-generated constructor stub
		listEmpleados = new ArrayList<>();
		listVehiculos = new ArrayList<>();
		reportes = new ArrayList<>();
	}
	
public boolean buscarEmpleado(String usuario, String pin) {
	boolean bandera=true;
	for (Empleado temp : listEmpleados) {

		if (temp.getEmail().equals(usuario) && temp.getContrasenia().equals(pin)) {
			return bandera;
		} else {
			bandera = false;
		}

	}
	return bandera;
}

	public boolean buscarEmpleado(Empleado empleado) {
		boolean bandera=true;
		for(int i=0;i<listEmpleados.size();i++) {

			String temp=listEmpleados.get(i).getCedula();
			if(temp.equals(empleado.getCedula())) {
				return bandera;
			}else {
				bandera=false;
			}

		}
		return bandera;
	}
public void registrarEmpleado(Empleado empleado) {
	
	boolean temp=buscarEmpleado(empleado);
	
	if(temp == false) {
			
			System.out.println("Empleado est� registrado");
			
		}else {	
		
		ArrayList<Empleado> listEmpleados = new ArrayList<Empleado>();
		
		listEmpleados.add(empleado);
		System.out.println("Empleado Registrado Exitosamente");
	
	   }
	
}
	
	public void actualizarEmpleado(Empleado empleado, String nombre,String id, String correo, String pin) {
		
		if(empleado.getContrasenia().equals(pin)) {
			
			empleado.setEmail(correo);
			//empleado.set(id);
			empleado.setNombre(nombre);
			empleado.setContrasenia(pin);
			
		}else {
			System.out.println("Empleado no encontrado	");
		}
	}

	public void eliminarEmpleado(Empleado empleado) {
		
		boolean temp=buscarEmpleado(empleado);
		
		if(temp) {
			listEmpleados.remove(empleado);
		}else {
			System.out.println("Empleado no encontrado");
		}
		
	}

}
