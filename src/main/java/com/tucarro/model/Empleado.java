package com.tucarro.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Empleado extends Persona implements Serializable {

    //Atributos
    enum estadoEmpleado {ACTIVO, BLOQUEADO};
    public estadoEmpleado estado;

    public Empleado(){
        super();
    }

    public Empleado(String email, String contraseña){
        super(email, contraseña);
    }
    public Empleado(String nombre, String apellido, String cedula, String email, String contrasenia){
        super(nombre, apellido, cedula, email, contrasenia);
    }
    public Empleado(String nombre, String apellido, String cedula, String email, String contraseña, estadoEmpleado estado, ArrayList<Empleado> reportes){
        super(nombre, apellido, cedula, email, contraseña);
        this.estado = estado;
    }


    @Override
    public String toString() {
        return null;
    }
}
