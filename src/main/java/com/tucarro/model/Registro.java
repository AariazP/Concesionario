package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Registro {

    private String nombreCliente;
    private String nombreEmpleado;
    private String placaVehiculo;
    private String tipoTramite;

    public Registro(Cliente cliente, Empleado empleado, Vehiculo vehiculo, String tipoTramite) {
        this.tipoTramite = tipoTramite;
        this.nombreCliente = cliente.getNombre();
        this.nombreEmpleado = empleado.getNombre();
        this.placaVehiculo = vehiculo.getPlaca();
    }




}
