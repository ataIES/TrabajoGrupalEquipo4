/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase métodos BD que contiene los métodos necesarios para operar con la base de datos.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class MetodosBD {

    //Constantes (Nombres de tablas usadas para las sentencias)
    private static final String TABLA_CLIENTES = "clientes";

    /**
     * Método privado getConnection que nos devuelve la conexión.
     *
     * return Devuelve un Connection.
     */
    private static Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    
    //Pruebas
    
    //Generado para pruebas de conexión
    public static List<Cliente> listarClientes() {

        List<Cliente> actividades = new ArrayList<>();

        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLA_CLIENTES);) {

            while (rs.next()) {
                Cliente cliente = crearCliente(rs);
                if (!actividades.add(cliente)) {
                    throw new Exception("Error: no se ha insertado el objeto en la colección.");
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return actividades;

    }
    
    //Generado para pruebas de conexión
    private static Cliente crearCliente(final ResultSet rs) throws SQLException {
        return new Cliente(rs.getString("cliente_id"), rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("telefono"), rs.getString("direccion"), rs.getString("localidad"), rs.getDate("fecha_nacimiento").toLocalDate(), null, null);
    }

}
