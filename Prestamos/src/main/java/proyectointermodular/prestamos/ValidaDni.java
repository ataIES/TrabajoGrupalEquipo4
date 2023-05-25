/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

/**
 * Clase ValidaDni exclusiva para validar DNIs.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class ValidaDni {

    /**
     * Método validar que devuelve un boolean true si el DNI es válido o false si no lo es.
     *
     * @param dni Parámetro de tipo String que será el DNI.
     * @return Devuelve un boolean.
     */
    public static boolean validarDni(String dni) {

        String letraMayuscula = "";

        if (dni.length() != 9 || !Character.isLetter(dni.charAt(8))) {
            System.out.println("El DNI no tiene una longitud de 9 caracteres o el último no es una letra.");
            return false;
        }

        //letraMayuscula = (dni.substring(8)).toUpperCase();
        letraMayuscula = String.valueOf(dni.charAt(8)).toUpperCase();

        return soloNumeros(dni) && letraDNI(dni).equals(letraMayuscula);
    }

    /**
     * Método privado soloNumeros que comprueba que cada dígito esté comprendido entre 1 y 9 y que la longitud de todos los números sea 8. Devuelve un boolean true si es válido o false si no lo es.
     *
     * @return Devuelve un boolean.
     */
    private static boolean soloNumeros(String dni) {

        int i, j = 0;
        String numero = "";
        String miDNI = "";
        String[] unoNueve = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (i = 0; i < dni.length() - 1; i++) {
            //numero = this.dni.substring(i, i + 1);
            numero = String.valueOf(dni.charAt(i));

            for (j = 0; j < unoNueve.length; j++) {
                if (numero.equals(unoNueve[j])) {
                    miDNI += unoNueve[j];
                }
            }
        }

        return miDNI.length() == 8;

    }

    /**
     * Método privado letrasDNI que calcula letra del DNI correcta según los dígitos y la devuelve.
     *
     * @return Devuelve un String.
     */
    private static String letraDNI(String dni) {

        int miDNI = Integer.parseInt(dni.substring(0, 8));
        int resto = 0;
        String miLetra = "";
        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        resto = miDNI % 23;

        miLetra = asignacionLetra[resto];

        return miLetra;

    }

}
