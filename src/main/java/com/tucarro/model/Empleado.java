package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
public class Empleado extends Persona implements Serializable {



    //Atributos
    enum estadoEmpleado {ACTIVO, BLOQUEADO};
    public estadoEmpleado estado;

    public Empleado(){
        super();
        estado = estadoEmpleado.ACTIVO;
    }

    public Empleado(String email, String contraseña){
        super(email, contraseña);
    }
    public Empleado(String nombre, String apellido, String cedula, String email, String contrasenia){

        super(nombre, apellido, cedula, email, contrasenia);
        estado = estadoEmpleado.ACTIVO;
    }
    public Empleado(String nombre, String apellido, String cedula, String email, String contraseña, estadoEmpleado estado, ArrayList<Empleado> reportes){
        super(nombre, apellido, cedula, email, contraseña);
        estado = estadoEmpleado.ACTIVO;
        this.estado = estado;
    }

    public void setEstadoInactivo() {
        estado = estadoEmpleado.BLOQUEADO;
    }


    public String getEstado() {
        return estado.toString();
    }


    @Override
    public String toString() {
        return null;
    }
}
