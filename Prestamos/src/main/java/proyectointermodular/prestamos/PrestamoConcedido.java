/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.util.List;

/**
 * Clase PrestamoConcedido que contiene todos los datos de un préstamo concedido a un cliente, asociado a un préstamo ya preconcedido.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class PrestamoConcedido {

    //Atributos
    private PrestamoPreconcedido prestamoPreconcedido;
    private List<Pago> pagos;

    /**
     * Constructor por parámetros que recibe el valor de todos los atributos y crea un objeto PrestamoConcedido.
     *
     * @param prestamoPreconcedido Parámetro de tipo PrestamoPreconcedido que será el préstamo preconcedido.
     * @param pagos Parámetro de tipo List<code><Pago></code> que será el listado de pagos.
     */
    public PrestamoConcedido(PrestamoPreconcedido prestamoPreconcedido, List<Pago> pagos) {
        this.prestamoPreconcedido = prestamoPreconcedido;
        this.pagos = pagos;
    }

    public PrestamoPreconcedido getPrestamoPreconcedido() {
        return prestamoPreconcedido;
    }

    public List<Pago> getPagos() {
        return pagos;
    }
    

}
