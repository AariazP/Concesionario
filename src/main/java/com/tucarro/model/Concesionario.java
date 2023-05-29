package com.tucarro.model;


import java.util.ArrayList;


public class Concesionario {

    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Vehiculo> listaVehiculos;
    public static Concesionario concesionario;


    private Concesionario(){

    }


    /**
     * This method obtain singleton
     * @return
     */
    public static Concesionario getInstance(){

        if(concesionario == null) concesionario = new Concesionario();
        return concesionario;

    }


    public boolean iniciarSesion(String usuario, String contrasenia) {
        for(Empleado empleado: listaEmpleados){
            if(empleado.compararEmail(usuario) && empleado.compararContrasenia(contrasenia)) return true;

        }
        return false;
    }


    /**
     * Método encargado de registrar un nuevo empleado.
     * @param nombre
     * @param apellido
     * @param cedula
     * @param email
     * @param contrasenia
     */
    public boolean registrarEmpleado(String nombre, String apellido, String cedula, String email, String contrasenia) {

        Empleado empleado = new Empleado(nombre, apellido, cedula, email, contrasenia);

        for(Empleado empleadoAux:listaEmpleados){

            if(!empleadoAux.compararCedula(cedula)) {
                listaEmpleados.add(empleado);
                return true;
            }
        }

        return false;
    }

    /**
     * Este metodo actualiza los datos de un empleado y retorna un true al comparar los datos enviados
     * y false si ningún dato es correcto retorna un false
     * @param nombre
     * @param apellido
     * @param cedula
     * @param email
     * @param contrasenia
     * @return
     */
    public boolean actualizarDatosEmpleado(String nombre, String apellido, String cedula, String email, String contrasenia) {


        for(Empleado empleado: listaEmpleados){

            if(empleado.compararCedula(cedula)){
                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setEmail(email);
                empleado.setContrasenia(contrasenia);
               return true;

            }
        }
        return false;

    }
}
