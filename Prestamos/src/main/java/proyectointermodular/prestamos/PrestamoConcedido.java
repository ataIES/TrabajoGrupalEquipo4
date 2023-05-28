/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase PrestamoConcedido que contiene todos los datos de un préstamo concedido a un cliente, asociado a un préstamo ya preconcedido.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class PrestamoConcedido extends Prestamo {

    //Atributos
    private PrestamoPreconcedido prestamoPreconcedido;
    private List<Pago> pagos;

    /**
     * Constructor por parámetros que recibe el valor de todos los atributos excepto el id y crea un objeto PrestamoConcedido.
     *
     * @param prestamoPreconcedido Parámetro de tipo PrestamoPreconcedido que será el préstamo preconcedido.
     * @param pagos Parámetro de tipo List<code>Pago</code> que será el listado de pagos.
     * @param cliente Parámetro de tipo Cliente que será el cliente.
     * @param fecha Parámetro de tipo LocalDate que será la fecha de la firma.
     * @param cantidad Parámetro de tipo double que será la cantidad mensual.
     */
    public PrestamoConcedido(PrestamoPreconcedido prestamoPreconcedido, List<Pago> pagos, Cliente cliente, LocalDate fecha, double cantidad) {
        super(cliente, fecha, cantidad);
        this.prestamoPreconcedido = prestamoPreconcedido;
        this.pagos = pagos;
    }

    /**
     * Constructor por parámetros que recibe el valor de todos los atributos y crea un objeto PrestamoConcedido.
     *
     * @param prestamoPreconcedido Parámetro de tipo PrestamoPreconcedido que será el préstamo preconcedido.
     * @param pagos Parámetro de tipo List<code>Pago</code> que será el listado de pagos.
     * @param id Parámetro de tipo int que será el id.
     * @param cliente Parámetro de tipo Cliente que será el cliente.
     * @param fecha Parámetro de tipo LocalDate que será la fecha de la firma.
     * @param cantidad Parámetro de tipo double que será la cantidad mensual.
     */
    public PrestamoConcedido(PrestamoPreconcedido prestamoPreconcedido, List<Pago> pagos, int id, Cliente cliente, LocalDate fecha, double cantidad) {
        super(id, cliente, fecha, cantidad);
        this.prestamoPreconcedido = prestamoPreconcedido;
        this.pagos = pagos;
    }

    /**
     * Método getPrestamoPreconcedido que devuelve el valor del atributo prestamoPreconcedido.
     *
     * @return Devuelve un PrestamoPreconcedido.
     */
    public PrestamoPreconcedido getPrestamoPreconcedido() {
        return prestamoPreconcedido;
    }

    /**
     * Método getPagos que devuelve el valor del atributo pagos.
     *
     * @return Devuelve un List<code>Pago</code>
     */
    public List<Pago> getPagos() {
        return pagos;
    }

}
