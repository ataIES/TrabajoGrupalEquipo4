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
    
    private String IBAN;
    private TipoCuenta tipoCuenta;
    private double saldoActual;
    private double nominaUltMes;
    private double mediaNominaAnual;
    private List<Movimiento> movimientos;
    
}
