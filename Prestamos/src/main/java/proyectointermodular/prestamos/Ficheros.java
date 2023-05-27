/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
                bW.write(elemento.toString());
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
     * Método estático escribirLineaALinea que recibe por parámetro un objeto File y uno tipo String y escribe línea a línea la información del String.
     *
     * @param fichero Parámetro de tipo File que será el fichero donde escribir.
     * @param cadenaLinea Parámetro de tipo String que será el texto a escribir en un línea.
     */
    public static void escribirLineaALinea(File fichero, String cadenaLinea) {

        BufferedWriter bW = null;

        try {
            bW = new BufferedWriter(new FileWriter(fichero, true));
            bW.write(cadenaLinea);
            //bW.write(System.lineSeparator());
            bW.newLine();
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
     * 
     * @param fichero
     * @param lista 
     */
     public static void escribirLineaALineaDeListPrestamosConcedidos(File fichero, List<PrestamoConcedido> lista) {

        BufferedWriter bW = null;

        try {
            bW = new BufferedWriter(new FileWriter(fichero));

            for (PrestamoConcedido elemento : lista) {
                bW.write(elemento.toString());
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
