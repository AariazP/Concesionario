package com.tucarro.model;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Setter
@Getter
public class Concesionario {

    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Cliente> listaClientes;
    public static Concesionario concesionario;


    private Concesionario() {
        listaClientes = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
        listaVehiculos = new ArrayList<>();
    }


    /**
     * This method obtain singleton
     *
     * @return
     */
    public static Concesionario getInstance() {

        if (concesionario == null) concesionario = new Concesionario();
        return concesionario;

    }


    public boolean iniciarSesion(String usuario, String contrasenia) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.compararEmail(usuario) && empleado.compararContrasenia(contrasenia)) return true;

        }
        return false;
    }


    /**
     * Método encargado de registrar un nuevo empleado.
     *
     * @param nombre
     * @param apellido
     * @param cedula
     * @param email
     * @param contrasenia
     */
    public boolean registrarEmpleado(String nombre, String apellido, String cedula, String email, String contrasenia) {

        Empleado empleado = new Empleado(nombre, apellido, cedula, email, contrasenia);

        for (Empleado empleadoAux : listaEmpleados) {

            if (!empleadoAux.compararCedula(cedula)) {
                listaEmpleados.add(empleado);
                return true;
            }
        }

        return false;
    }

    /**
     * Este metodo actualiza los datos de un empleado y retorna un true al comparar los datos enviados
     * y false si ningún dato es correcto retorna un false
     *
     * @param nombre
     * @param apellido
     * @param cedula
     * @param email
     * @param contrasenia
     * @return
     */
    public boolean actualizarDatosEmpleado(String nombre, String apellido, String cedula, String email, String contrasenia) {


        for (Empleado empleado : listaEmpleados) {

            if (empleado.compararCedula(cedula)) {
                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setEmail(email);
                empleado.setContrasenia(contrasenia);
                return true;

            }
        }
        return false;

    }

    /**
     * Este metodo agrega un cliente a la lista de clientes,
     * verifica que la cedula no exista en la lista de clientes
     *
     * @param cliente el cliente a agregar
     * @return true si se agrega el cliente, false si no se agrega
     */
    public boolean crearCliente(Cliente cliente) {

        for (Cliente clienteAux : listaClientes) {
            if (clienteAux.compararCedula(cliente.getCedula())) return false;
        }
        listaClientes.add(cliente);
        return true;
    }

    public Cliente getCliente(String cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.compararCedula(cedula)) return cliente;
        }
        return null;
    }

    /**
     * Este metodo actualiza los datos de un cliente y retorna un true al comparar los datos enviados
     * @param nombre el nombre del cliente
     * @param apellido el apellido del cliente
     * @param cedula la cedula del cliente
     * @param email el email del cliente
     * @param contrasenia la contrasenia del cliente
     * @param estadoEmpleado el estado del cliente
     * @return true si se actualiza el cliente, false si no se actualiza
     */
    public boolean actualizarDatosCliente(String nombre, String apellido, String cedula, String email, String contrasenia, String estadoEmpleado) {

        for (Cliente cliente : listaClientes) {
            if (cliente.compararCedula(cedula)) {
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setEmail(email);
                cliente.setContrasenia(contrasenia);
                cliente.setEstado(estadoEmpleado);
                return true;
            }
        }
        return false;

    }

    /**
     * Este metodo elimina un cliente de la lista de clientes
     * @param cedula la cedula del cliente a eliminar
     */
    public void eliminarCliente(String cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.compararCedula(cedula)) {
                listaClientes.remove(cliente);
                break;
            }
        }
    }
}
