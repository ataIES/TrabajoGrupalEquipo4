/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.util.List;

/**
 * Clase CuentaBancaria que contiene todos los datos de una cuenta bancaria, incluyendo un listado de movimientos realizados.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class CuentaBancaria {

    //Atributos
    private String IBAN;
    private TipoCuenta tipoCuenta;
    private double saldoActual;
    private double nominaUltMes;
    private double mediaNominaAnual;
    private int mesesCotizados;
    private List<Movimiento> movimientos;

    /**
     * Constructor por parámetros que recibe todos los valores de los atributos y crea un objeto CuentaBancaria.
     *
     * @param IBAN Parámetro de tipo String que será el IBAN.
     * @param tipoCuenta Parámetro de tipo String que será en Enum de tipos de cuentas.
     * @param saldoActual Parámetro de tipo double que será el saldo actual.
     * @param nominaUltMes Parámetro de tipo double que será la cantidad de la nómina del último mes.
     * @param mediaNominaAnual Parámetro de tupo double que será la media de las últimas 12 nóminas.
     * @param mesesCotizados Parámetro de tipo int que serán los meses que ha cotizado.
     * @param movimientos Parámetrod de tipo List<code>Movimiento</code> que será una lista con los movimientos.
     */
    public CuentaBancaria(String IBAN, TipoCuenta tipoCuenta, double saldoActual, double nominaUltMes, double mediaNominaAnual, int mesesCotizados, List<Movimiento> movimientos) {
        this.IBAN = IBAN;
        this.tipoCuenta = tipoCuenta;
        this.saldoActual = saldoActual;
        this.nominaUltMes = nominaUltMes;
        this.mediaNominaAnual = mediaNominaAnual;
        this.mesesCotizados = mesesCotizados;
        this.movimientos = movimientos;
    }

    /**
     * Método toString que devuelve toda la información del objeto.
     *
     * @return Devuelve un String.
     */
    @Override
    public String toString() {
        return "\nCuentaBancaria{" + "IBAN=" + IBAN + ", tipoCuenta=" + tipoCuenta + ", saldoActual=" + saldoActual + ", nominaUltMes=" + nominaUltMes + ", mediaNominaAnual=" + mediaNominaAnual + ", mesesCotizados=" + mesesCotizados + ", movimientos=" + movimientos + '}';
    }

    /**
     * Método getNominaUltMes que devuelve el valor del atributo nominaUltMes.
     *
     * @return Devuelve un double.
     */
    public double getNominaUltMes() {
        return nominaUltMes;
    }

    /**
     * Método getMediaNominaAnual que devuelve el valor del atributo mediaNominaAnual.
     *
     * @return Devuelve un double.
     */
    public double getMediaNominaAnual() {
        return mediaNominaAnual;
    }

    /**
     * Método getMesesCotizados que devuelve el valor del atributo mesesCotizados.
     *
     * @return Devuelve un int.
     */
    public int getMesesCotizados() {
        return mesesCotizados;
    }

    /**
     * Método getIBAN que devuelve el valor del atributo IBAN.
     *
     * @return Devuelve un String.
     */
    public String getIBAN() {
        return IBAN;
    }

    /**
     * Método getTipoCuenta que devuelve el valor del atributo tipoCuenta.
     *
     * @return Devuelve un TipoCuenta.
     */
    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

}
