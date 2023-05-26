/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase PrestamoPreconcedido que contiene todos los datos de un préstamo preconcedido a un cliente.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class PrestamoPreconcedido extends Prestamo implements Serializable {

    //Atributos
    private int periodoMeses;
    private double tipoInteres;
    private int plazoAceptacion;

    /**
     * Constructor por parámetros que recibe el valor de todos los atributos excepto el id y crea el objeto PrestamoPreconcedido.
     *
     * @param periodoMeses Parámetro de tipo int que será el periodo de meses.
     * @param tipoInteres Parámetro de tipo double que será el tipo de interés.
     * @param plazoAceptacion Parámetro de tipo int que será el plazo de aceptación.
     * @param cliente Parámetro de tipo Cliente que será el cliente.
     * @param fecha Parámetro de tipo LocalDate que será la fecha. Podrá tomar diferentes formas: en un préstamo preconcedido será la fecha de la oferta y un préstamo concedido será la fecha de firma.
     * @param cantidad Parámetro de tipo double que será la cantidad.
     */
    public PrestamoPreconcedido(int periodoMeses, double tipoInteres, int plazoAceptacion, Cliente cliente, LocalDate fecha, double cantidad) {
        super(cliente, fecha, cantidad);
        this.periodoMeses = periodoMeses;
        this.tipoInteres = tipoInteres;
        this.plazoAceptacion = plazoAceptacion;
    }

    /**
     * Constructor por parámetros que recibe el valor de todos los atributos y crea el objeto préstamo preconcedido.
     *
     * @param periodoMeses Parámetro de tipo int que será el periodo de meses.
     * @param tipoInteres Parámetro de tipo double que será el tipo de interés.
     * @param plazoAceptacion Parámetro de tipo int que será el plazo de aceptación.
     * @param id Parámetro de tipo int que será el id.
     * @param cliente Parámetro de tipo Cliente que será el cliente.
     * @param fecha Parámetro de tipo LocalDate que será la fecha. Podrá tomar diferentes formas: en un préstamo preconcedido será la fecha de la oferta y un préstamo concedido será la fecha de firma.
     * @param cantidad Parámetro de tipo double que será la cantidad.
     */
    public PrestamoPreconcedido(int periodoMeses, double tipoInteres, int plazoAceptacion, int id, Cliente cliente, LocalDate fecha, double cantidad) {
        super(id, cliente, fecha, cantidad);
        this.periodoMeses = periodoMeses;
        this.tipoInteres = tipoInteres;
        this.plazoAceptacion = plazoAceptacion;
    }

    public int getPeriodoMeses() {
        return periodoMeses;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public int getPlazoAceptacion() {
        return plazoAceptacion;
    }
    

}
