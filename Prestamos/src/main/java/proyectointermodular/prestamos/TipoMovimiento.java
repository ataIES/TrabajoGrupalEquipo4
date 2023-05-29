/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package proyectointermodular.prestamos;

/**
 * Enumerado que contiene los tipos de movimientos que se pueden realizar.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public enum TipoMovimiento {
    /**
     * El tipo de movimiento es pago con tarjeta.
     */
    PAGO_TARJETA,
    /**
     * El tipo de movimiento es recibo.
     */
    RECIBO,
    /**
     * El tipo de movimiento es retirada en cajero.
     */
    RETIRADA_CAJERO,
    /**
     * El tipo de movimiento es nómina.
     */
    NOMINA,
    /**
     * EL tipo de movimiento es Bizum.
     */
    BIZUM,
    /**
     * El tipo de movimiento es depósito.
     */
    DEPOSITO;
}
