/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Clase Ficheros que contiene los métodos necearios para manipular ficheros.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class Ficheros {

    //Ejemplo de fichero que se generará en la carpeta Documentos del usuario que ejecute el programa.
    private static File fichero = new File(System.getenv("userprofile") + "\\Documents", "nombreFichero.txt");

    /**
     * Método estático eliminar que recibe por parámetro un objeto de tipo File y lo elimina.
     *
     * @param fichero Parámetro de tipo File que será el fichero a eliminar.
     * @return Devuelve un boolean.
     */
    public static boolean eliminar(File fichero) {

        boolean eliminado = false;

        try {
            eliminado = fichero.delete();
        } catch (SecurityException e) {
            System.out.println(e.toString());
        }

        return eliminado;

    }

    /**
     * Método estático escribirLineaALineaDeListPrestamosPreconcedidos que recibe por parámetro un objeto File y un List de PrestamoPreconcedido. Recorre la colección y lo graba en el fichero.
     *
     * @param fichero Parámetro de tipo File que será el fichero.
     * @param lista Parámetro de tipo List<code>PrestamoPreconcedido</code>
     */
    public static void escribirLineaALineaDeListPrestamosPreconcedidos(File fichero, List<PrestamoPreconcedido> lista) {

        BufferedWriter bW = null;

        try {
            bW = new BufferedWriter(new FileWriter(fichero));

            for (PrestamoPreconcedido elemento : lista) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                bW.write("Nº Préstamo preconcedido: " + elemento.getId() + " | DNI: " + elemento.getCliente().getDni() + " | Fecha oferta: " + elemento.getFecha().format(formatter) + " | Cantidad: " + String.format("%,.2f", elemento.getCantidad()) + " | Periodo en meses: " + elemento.getPeriodoMeses() + " | Tipo interés (%): " + String.format("%,.2f", elemento.getTipoInteres()) + " | Plazo aceptación (días): " + elemento.getPlazoAceptacion());
                //bR.write(System.lineSeparator());
                bW.newLine();
            }

            System.out.println("Fichero " + fichero.getAbsolutePath() + " grabado.");

        } catch (IOException ex) {
            System.err.println(ex.toString());
        } finally {
            if (bW != null) {
                try {
                    bW.close();
                } catch (IOException ex) {
                    System.err.println("Error al cerrar el flujo de escritura.");
                }
            }
        }

    }

    /**
     * Método estático escribirLineaALineaDeListPrestamosConcedidos que recibe por parámetro un objeto File y un List de PrestamoConcedido. Recorre la colección y lo graba en el fichero.
     *
     * @param fichero Parámetro de tipo File que será el fichero.
     * @param lista Parámetro de tipo List<code>PrestamoConcedido</code>
     */
    public static void escribirLineaALineaDeListPrestamosConcedidos(File fichero, List<PrestamoConcedido> lista) {

        BufferedWriter bW = null;

        try {
            bW = new BufferedWriter(new FileWriter(fichero));

            for (PrestamoConcedido elemento : lista) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                bW.write("Nº Préstamo concedido: " + elemento.getId() + " | DNI: " + elemento.getCliente().getDni() + " | Fecha firma: " + elemento.getFecha().format(formatter) + " | Cantidad mensual: " + String.format("%,.2f", elemento.getCantidad()));
                //bR.write(System.lineSeparator());
                bW.newLine();
            }

            System.out.println("Fichero " + fichero.getAbsolutePath() + " grabado.");

        } catch (IOException ex) {
            System.err.println(ex.toString());
        } finally {
            if (bW != null) {
                try {
                    bW.close();
                } catch (IOException ex) {
                    System.err.println("Error al cerrar el flujo de escritura.");
                }
            }
        }

    }

}
