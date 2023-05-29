package com.tucarro.model;

public class Reporte {
	
	private Cliente cliente;
	private String fecha;
	private Empleado empleado;
	private TipoTramite tramite;
	private Vehiculo vehiculo;
	
	public Reporte(String nombre, String id, String correo, String pin, TipoEstado estado,
			Cliente cliente, String fecha, Empleado empleado, TipoTramite tramite,Vehiculo vehiculo) {
		//super(nombre, id, correo, pin, estado);
		this.cliente = cliente;
		this.fecha = fecha;
		this.empleado = empleado;
		this.tramite = tramite;
		this.vehiculo = vehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public TipoTramite getTramite() {
		return tramite;
	}

	public void setTramite(TipoTramite tramite) {
		this.tramite = tramite;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	
}
