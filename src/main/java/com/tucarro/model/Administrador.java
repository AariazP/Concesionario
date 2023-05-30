package com.tucarro.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
@Getter
@Setter
public class Administrador extends Persona{


    Empleado empleado = new Empleado("yuri","reyes","123","yuri123","1234");

    //Constructores
    public Administrador(){
        super();
    }
    public Administrador(String email, String contraseña){
        super(email, contraseña);
    }
    public Administrador(String nombre, String apellido, String cedula, String email, String contrasenia, ArrayList<Empleado> empleados){
        super(nombre, apellido, cedula, email, contrasenia);
    }



}
