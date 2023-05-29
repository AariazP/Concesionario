package com.tucarro.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Persona {


    private String nombre;
    private String apellido;
    private String cedula;
    private String email;
    private String contrasenia;

    public Persona() {
    }
    public Persona(String email, String contrasenia){
        this.email = email;
        this.contrasenia = contrasenia;
    }
    public Persona(String nombre, String apellido, String cedula, String email, String contraseña){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
        this.contrasenia = contrasenia;
    }


}
