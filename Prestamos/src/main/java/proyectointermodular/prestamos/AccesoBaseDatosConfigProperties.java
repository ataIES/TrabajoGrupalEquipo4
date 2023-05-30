/*
 * sigue el patrón Singleton para la conexión a la base de datos
 */
package proyectointermodular.prestamos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase acceso a base de datos que contiene los atributos y métodos para conectarnos a una base de datos. Se usa un fichero properties.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class AccesoBaseDatosConfigProperties {

    //Fichero de propiedades
    //private File config = new File(System.getenv("userprofile") + "\\Documents\\programacion\\UNIDAD08\\Ficheros", "configDB.properties");
    private File config = new File("configDB.properties");
    private Properties propiedades;

    //atributo conexión
    private Connection conn = null;

    /**
     * Constructor privado que establece la conexión con la base de datos.
     */
    private AccesoBaseDatosConfigProperties() {

        propiedades = getPropiedades();

        if (propiedades != null) {

            try {

                System.out.println("Fichero de propiedades: " + propiedades.toString());
                String url = propiedades.getProperty("url") + propiedades.getProperty("bd");
                propiedades.remove("bd");
                propiedades.remove("url");

                conn = (Connection) DriverManager.getConnection(url, propiedades);

                if (conn == null) {
                    System.out.println("Error en conexion");
                } else {
                    System.out.println("Conexion correcta a: " + url);
                }

            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }

        } else {
            System.out.println("Error al cargar el fichero de configuración.");
        }

    }

    /**
     * Método estático getInstance que devuelve la instancia de conexión a la base de datos.
     *
     * @return Devuelve un objeto AccesoBaseDatosConfigXml.INSTANCE.
     */
    public static AccesoBaseDatosConfigProperties getInstance() {
        return AccesoBaseDatosHolder.INSTANCE;
    }

    /**
     * Clase privada AccesoBaseDatosHolder que tiene como constante estática un objeto AccesoBaseDatosConfigXml.
     */
    private static class AccesoBaseDatosHolder {

        private static final AccesoBaseDatosConfigProperties INSTANCE = new AccesoBaseDatosConfigProperties();
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

    /**
     * Método privado getPropiedades que carga las propiedades de un fichero properties.
     *
     * @return Devuelve un objeto Properties
     */
    private Properties getPropiedades() {

        Properties prop = null;

        try ( FileInputStream fIS = new FileInputStream(config);) {

            prop = new Properties();
            prop.load(fIS);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        return prop;

    }

}
