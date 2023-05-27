/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.time.LocalDate;

/**
 * Clase cliente que contiene todos los datos de un cliente, incluyendo su perfil de usuario y su cuenta bancaria.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class Cliente {

    //Atributos
    private String uuid;
    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String localidad;
    private LocalDate fechaNacimiento;
    private Perfil perfil;
    private CuentaBancaria cuentaBancaria;

    /**
     * Constructor por parámetros que recibe todos los valores de los atributos excepto el uuid y crea un objeto Cliente.
     *
     * @param dni Parámetro de tipo String que será el DNI.
     * @param nombre Parámetro de tipo String que será el nombre.
     * @param apellidos Parámetro de tipo String que será los apellidos.
     * @param telefono Parámetro de tipo String que será el teléfono.
     * @param direccion Parámetro de tipo String que será la dirección.
     * @param localidad Parámetro de tipo String que será la localidad.
     * @param fechaNacimiento Parámetro de tipo LocalDate que será la fecha de nacimiento.
     * @param perfil Parámetro de tipo Perfil que será el perfil de usuario.
     * @param cuentaBancaria Parámetro de tipo CuentaBancaria que será la cuenta banacaria.
     */
    public Cliente(String dni, String nombre, String apellidos, String telefono, String direccion, String localidad, LocalDate fechaNacimiento, Perfil perfil, CuentaBancaria cuentaBancaria) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.localidad = localidad;
        this.fechaNacimiento = fechaNacimiento;
        this.perfil = perfil;
        this.cuentaBancaria = cuentaBancaria;
    }

    /**
     * Constructor por parámetros que recibe todos los valores de los atributos y crea un objeto Cliente.
     *
     * @param uuid Parámetro de tipo String que será el UUID.
     * @param dni Parámetro de tipo String que será el DNI.
     * @param nombre Parámetro de tipo String que será el nombre.
     * @param apellidos Parámetro de tipo String que será los apellidos.
     * @param telefono Parámetro de tipo String que será el teléfono.
     * @param direccion Parámetro de tipo String que será la dirección.
     * @param localidad Parámetro de tipo String que será la localidad.
     * @param fechaNacimiento Parámetro de tipo LocalDate que será la fecha de nacimiento.
     * @param perfil Parámetro de tipo Perfil que será el perfil de usuario.
     * @param cuentaBancaria Parámetro de tipo CuentaBancaria que será la cuenta banacaria.
     */
    public Cliente(String uuid, String dni, String nombre, String apellidos, String telefono, String direccion, String localidad, LocalDate fechaNacimiento, Perfil perfil, CuentaBancaria cuentaBancaria) {
        this.uuid = uuid;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.localidad = localidad;
        this.fechaNacimiento = fechaNacimiento;
        this.perfil = perfil;
        this.cuentaBancaria = cuentaBancaria;
    }

    /**
     * Método toString que devuelve una cadena con toda la información del objeto.
     *
     * @return Devuelve un String.
     */
    @Override
    public String toString() {
        return "Cliente{" + "uuid=" + uuid + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", direccion=" + direccion + ", localidad=" + localidad + ", fechaNacimiento=" + fechaNacimiento + ", perfil=" + perfil + ", cuentaBancaria=" + cuentaBancaria + '}';
    }

    /**
     * Método getPerfil que devuelve el valor del atributo perfil.
     *
     * @return Devuelve un Perfil.
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * Método getCuentaBancaria que devuelve el valor del atributo cuentaBancaria.
     *
     * @return Devuelve un CuentaBancaria.
     */
    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     * Método getUuid que devuelve el valor del atributo uuid.
     *
     * @return Devuelve un String.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Método getDni que devuelve el valor del atributo dni.
     *
     * @return Devuelve un String.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Método getNombre que devuelve el valor del atributo nombre.
     *
     * @return Devuelve un String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método getApellidos que devuelve el valor del atributo apellidos.
     *
     * @return Devuelve un String.
     */
    public String getApellidos() {
        return apellidos;
    }

}
