/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.time.LocalDate;

/**
 * Clase Pago que contiene todos los datos de un pago realizado sobre un préstamo concedido.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class Pago {

    //Atributos
    private int id;
    private LocalDate fecha;
    private double cantidad;

    /**
     * Constructor por parámetros que recibe el valor de todos los atributos excepto el id y crea un objeto Pago.
     *
     * @param fecha Parámetro de tipo LocalDate que será la fecha.
     * @param cantidad Parámetro de tipo double que será la cantidad.
     */
    public Pago(LocalDate fecha, double cantidad) {
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    /**
     * Constructor por parámetros que recibe el valor de todos los atributos y crea un objeto Pago.
     *
     * @param id Parámetro de tipo int que será el id.
     * @param fecha Parámetro de tipo LocalDate que será la fecha.
     * @param cantidad Parámetro de tipo double que será la cantidad.
     */
    public Pago(int id, LocalDate fecha, double cantidad) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

}
