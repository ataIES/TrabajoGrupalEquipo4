/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.time.LocalDate;

/**
 * Clase abstracta Prestamo que contiene los datos base para un préstamo, incluyendo el cliente.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public abstract class Prestamo {

    //Atributos
    private int id;
    private Cliente cliente;
    private LocalDate fecha;
    private double cantidad;

    /**
     * Constructor por parámetros que recibe el valor de todos los atributos excepto el id y crea el objeto.
     *
     * @param cliente Parámetro de tipo Cliente que será el cliente.
     * @param fecha Parámetro de tipo LocalDate que será la fecha. Podrá tomar diferentes formas: en un préstamo preconcedido será la fecha de la oferta y un préstamo concedido será la fecha de firma.
     * @param cantidad Parámetro de tipo double que será la cantidad.
     */
    public Prestamo(Cliente cliente, LocalDate fecha, double cantidad) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    /**
     * Constructor por parámetros que recibe el valor de todos los atributos y crea el objeto.
     *
     * @param id Parámetro de tipo int que será el id.
     * @param cliente Parámetro de tipo Cliente que será el cliente.
     * @param fecha Parámetro de tipo LocalDate que será la fecha. Podrá tomar diferentes formas: en un préstamo preconcedido será la fecha de la oferta y un préstamo concedido será la fecha de firma.
     * @param cantidad Parámetro de tipo double que será la cantidad.
     */
    public Prestamo(int id, Cliente cliente, LocalDate fecha, double cantidad) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getCantidad() {
        return cantidad;
    }
    

}
