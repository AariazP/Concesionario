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
	for(int i=0;i<listEmpleados.size();i++) {
		
		Empleado temp=listEmpleados.get(i);
		if(temp.getCorreo().equals(usuario) && temp.getPin().equals(pin) ) {
			return bandera;
		}else {
			 bandera=false;
		}
		
	}
	return bandera;
}

	public boolean buscarEmpleado(Empleado empleado) {
		boolean bandera=true;
		for(int i=0;i<listEmpleados.size();i++) {

			String temp=listEmpleados.get(i).getId();
			if(temp.equals(empleado.getId())) {
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
		
		if(empleado.getPin()==pin) {
			
			empleado.setCorreo(correo);
			empleado.setId(id);
			empleado.setNombre(nombre);
			empleado.setPin(pin);
			
		}else {
			System.out.println("Empleado no encontrado	");
		}
	}

	public void eliminarEmpleado(Empleado empleado) {
		
		boolean temp=buscarEmpleado(empleado);
		
		if(temp == true) {
			listEmpleados.remove(empleado);
		}else {
			System.out.println("Empleado no encontrado");
		}
		
	}

}
