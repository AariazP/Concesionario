package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Calendar;

@Getter
@Setter
public class Registro implements Serializable {

    private String nombreCliente;
    private String nombreEmpleado;
    private String placaVehiculo;
    private String tipoTramite;
    private String fecha;

    public Registro(Cliente cliente, Empleado empleado, Vehiculo vehiculo, String tipoTramite) {
        this.tipoTramite = tipoTramite;
        this.nombreCliente = cliente.getNombre();
        this.nombreEmpleado = empleado.getNombre();
        this.placaVehiculo = vehiculo.getPlaca();
        this.fecha = Calendar.getInstance().getTime().toString();
    }




}
