package com.tucarro.model;


import com.tucarro.utilities.MethodsUtilities;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;


@Setter
@Getter
public class Concesionario implements Serializable {

    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Administrador> listaAdministradores;
    private ArrayList<Registro> listaRegistros;
    public static Concesionario concesionario;
    private Empleado empleadoActual;
    private Cliente clienteActual;


    private Concesionario() {
        listaClientes = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
        listaVehiculos = new ArrayList<>();
        listaAdministradores = new ArrayList<>();
        listaRegistros = new ArrayList<>();
        
    }

    /**
     * Este metodo permite obtener solo una instancia de concesionario
     * @return la unica instancia del concesionario
     */
    public static Concesionario getInstance() {

        if (concesionario == null) concesionario = MethodsUtilities.deserializarConcesionario();
        if (concesionario == null) concesionario = new Concesionario();
        return concesionario;

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
     * @param nombre      nombre del empleado a actualizar
     * @param apellido    apellido del empleado a actualizar
     * @param cedula      cedula del empleado a actualizar
     * @param email       email del empleado a actualizar
     * @param contrasenia contrasenia del empleado a actualizar
     * @return true si se pudo actualizar, false si no se encontró el cliente
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

    /**
     * Este método permite obtener un cliente por la cedula
     *
     * @param cedula atributo por el que se va a obtener el cliente
     * @return el cliente con esa cedula
     */
    public Cliente getClienteByCedula(String cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.compararCedula(cedula)) return cliente;
        }
        return null;
    }

    /**
     * Este metodo actualiza los datos de un cliente y retorna un true al comparar los datos enviados
     *
     * @param nombre         el nombre del cliente
     * @param apellido       el apellido del cliente
     * @param cedula         la cedula del cliente
     * @param email          el email del cliente
     * @param contrasenia    la contrasenia del cliente
     * @return true si se actualiza el cliente, false si no se actualiza
     */
    public boolean actualizarDatosCliente(String nombre, String apellido, String cedula, String email, String contrasenia) {

        for (Cliente cliente : listaClientes) {
            if (cliente.compararCedula(cedula)) {
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setEmail(email);
                cliente.setContrasenia(contrasenia);
                return true;
            }
        }
        return false;

    }

    /**
     * Este metodo elimina un cliente de la lista de clientes
     *
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

    /**
     * Este metodo permite iniciar sesion en el sistema
     *
     * @param usuario     el usuario que inicia sesion
     * @param contrasenia la contrasenia del usuario
     * @return true si el usuario inicia sesion, false si no inicia sesion
     */
    public String login(String usuario, String contrasenia) {

        for (Cliente cliente : listaClientes) {
            if (cliente.compararEmail(usuario) && cliente.compararContrasenia(contrasenia)){
                clienteActual = cliente;
                return "Cliente";
            }

        }


        for (Empleado empleado : listaEmpleados) {
            if (empleado.compararEmail(usuario) && empleado.compararContrasenia(contrasenia)){
                empleadoActual = empleado;
                return "Empleado";
            }
        }


        for (Administrador administrador : listaAdministradores) {
            if (administrador.compararEmail(usuario) && administrador.compararContrasenia(contrasenia))
                return "Administrador";
        }

        return "";
    }
//--------------------------------------------CRUD EMPLEADO-------------------------------------------
    /**
     * Este metodo permite crear un empleado validando la cedula
     * @param empleado el empleado a crear
     * @return true si se crea el empleado, false si no se crea
     */
    public boolean crearEmpleado(Empleado empleado) {

        for (Empleado empleadoAux : listaEmpleados) {
            if (empleadoAux.getCedula() != null && empleadoAux.compararCedula(empleado.getCedula())) return false;
        }

        listaEmpleados.add(empleado);
        return true;

    }

    /**
     * Este método permite obtener un empleado por la cedula
     *
     * @param cedula atributo por el que se va a obtener el empleado
     * @return el empleado con esa cedula
     */
    public Empleado getEmpleadoByCedula(String cedula) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.compararCedula(cedula)) return empleado;
        }
        return null;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);

    }

    public void eliminarVehiculo(String placa) {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.compararPlaca(placa)) {
                listaVehiculos.remove(vehiculo);
                break;
            }
        }
    }

    public void venderVehiculo(Cliente cliente, Vehiculo vehiculo) {
        Registro registro = new Registro(cliente, empleadoActual,vehiculo, "Venta");
        listaRegistros.add(registro);
        cliente.agregarVehiculo(vehiculo);
        eliminarVehiculo(vehiculo.getPlaca());
    }

    public void alquilarVehiculo(Cliente cliente, Vehiculo vehiculo) {
        Registro registro = new Registro(cliente, empleadoActual,vehiculo, "Alquiler");
        listaRegistros.add(registro);
        cliente.agregarVehiculo(vehiculo);
        eliminarVehiculo(vehiculo.getPlaca());
    }
}
