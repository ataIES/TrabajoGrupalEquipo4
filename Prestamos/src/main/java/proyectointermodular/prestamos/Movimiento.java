/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.time.LocalDate;

/**
 * Clase Movimiento que contiene los datos de un movimiento en cuenta.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class Movimiento {

    //Atributos
    private int numOperacion;
    private double cantidad;
    private TipoMovimiento tipoMovimiento;
    private String emisor;
    private String destinatario;
    private String concepto;
    private LocalDate fecha;

    /**
     * Constructor por parámetros que recibe el valor de todos los atributos excepto el número de operación y crea un objeto Movimiento.
     *
     * @param cantidad Parámetro de tipo double que será la cantidad.
     * @param tipoMovimiento Parámetro de tipo TipoMovimiento que será un Enum de tipos de movimientos.
     * @param emisor Parámetro de tipo String que será el emisor.
     * @param destinatario Parámetro de tipo String que será el destinatario.
     * @param concepto Parámetro de tipo String que será el concepto.
     * @param fecha Parámetro de tipo LocalDate que será la fecha.
     */
    public Movimiento(double cantidad, TipoMovimiento tipoMovimiento, String emisor, String destinatario, String concepto, LocalDate fecha) {
        this.cantidad = cantidad;
        this.tipoMovimiento = tipoMovimiento;
        this.emisor = emisor;
        this.destinatario = destinatario;
        this.concepto = concepto;
        this.fecha = fecha;
    }

    /**
     * Constructor por parámetros que recibe el valor de todos los atributos y crea un objeto Movimiento.
     *
     * @param numOperacion Parámetro de tipo int que será el número de operación.
     * @param cantidad Parámetro de tipo double que será la cantidad.
     * @param tipoMovimiento Parámetro de tipo TipoMovimiento que será un Enum de tipos de movimientos.
     * @param emisor Parámetro de tipo String que será el emisor.
     * @param destinatario Parámetro de tipo String que será el destinatario.
     * @param concepto Parámetro de tipo String que será el concepto.
     * @param fecha Parámetro de tipo LocalDate que será la fecha.
     */
    public Movimiento(int numOperacion, double cantidad, TipoMovimiento tipoMovimiento, String emisor, String destinatario, String concepto, LocalDate fecha) {
        this.numOperacion = numOperacion;
        this.cantidad = cantidad;
        this.tipoMovimiento = tipoMovimiento;
        this.emisor = emisor;
        this.destinatario = destinatario;
        this.concepto = concepto;
        this.fecha = fecha;
    }

}
