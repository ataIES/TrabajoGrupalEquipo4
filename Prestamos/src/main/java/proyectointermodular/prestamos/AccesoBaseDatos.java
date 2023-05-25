/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase acceso a base de datos que contiene los atributos y métodos para conectarnos a una base de datos.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class AccesoBaseDatos {

    //Atributos y constantes
    private Connection conn = null;
    private static final String BD = "prestamos";
    private static final String USUARIO = "root";
    private static final String CLAVE = "mysql";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BD;

    /**
     * Constructor privado que establece la conexión con la base de datos.
     */
    private AccesoBaseDatos() {

        try {

            Properties properties = new Properties();
            properties.setProperty("user", USUARIO);
            properties.setProperty("password", CLAVE);
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");

            conn = (Connection) DriverManager.getConnection(URL, properties);

            if (conn == null) {
                System.out.println("Error en conexion");
            } else {
                System.out.println("Conexion correcta a: " + URL);
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    /**
     * Método estático getInstance que devuelve la instancia de conexión a la base de datos.
     *
     * @return Devuelve un objeto AccesoBaseDatos.INSTANCE.
     */
    public static AccesoBaseDatos getInstance() {
        return AccesoBaseDatosHolder.INSTANCE;
    }

    /**
     * Clase privada AccesoBaseDatosHolder que tiene como constante estática un objeto AccesoBaseDatos.
     */
    private static class AccesoBaseDatosHolder {

        private static final AccesoBaseDatos INSTANCE = new AccesoBaseDatos();
    }

    /**
     * Método getConn que devuelve la conexión a la base de datos.
     *
     * @return Devuelve un objeto Connection.
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * Método cerrar que cierra la conexión con la base de datos.
     *
     * @return Devuelve un boolean.
     */
    public boolean cerrar() {
        boolean siCerrada = false;
        try {
            conn.close();
            if (conn.isClosed()) {
                siCerrada = true;
            }
        } catch (SQLException sqe) {
            System.out.println("Se produjo un error en el cierre");
        }
        return siCerrada;
    }

}
