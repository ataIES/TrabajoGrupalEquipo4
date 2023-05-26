/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    private static final String TABLA_CUENTAS = "cuentas";
    private static final String TABLA_PERFILES = "perfiles";
    private static final String TABLA_CASADOS = "casados";
    private static final String TABLA_MOVIMIENTOS = "movimientos";

    /**
     * Método privado getConnection que nos devuelve la conexión.
     *
     * return Devuelve un Connection.
     */
    private static Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    /**
     * Método estático listarClientes que devuelve una lista de todos los clientes.
     *
     * @return Devuelve un List <code>Cliente</code>
     */
    public static List<Cliente> listarClientes() {

        List<Cliente> clientes = new ArrayList<>();

        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLA_CLIENTES);) {

            while (rs.next()) {
                Cliente cliente = crearCliente(rs);
                if (!clientes.add(cliente)) {
                    throw new Exception("Error: no se ha insertado el objeto en la colección.");
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return clientes;

    }

    /**
     * Método estático clientePorId que recibe por parámetro el id del cliente y crea un objeto Cliente.
     *
     * @param idCLiente Parámetro de tipo String que será el id del cliente.
     * @return Devuelve un Cliente.
     */
    public static Cliente clientePorId(String idCLiente) {

        Cliente cliente = null;
        String sql = "SELECT * FROM " + TABLA_CLIENTES + " WHERE cliente_id=?";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, idCLiente);

            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    cliente = crearCliente(rs);
                }
            } catch (Exception e) {
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return cliente;

    }

    /**
     * Método estático clientePorDni que recibe por parámetro el dni del cliente y crea un objeto Cliente.
     *
     * @param dni Parámetro de tipo String que será el dni del cliente.
     * @return Devuelve un Cliente.
     */
    public static Cliente clientePorDni(String dni) {

        Cliente cliente = null;
        String sql = "SELECT * FROM " + TABLA_CLIENTES + " WHERE DNI=?";
//        String sql = "SELECT * FROM " + TABLA_CLIENTES
//                + " INNER JOIN " + TABLA_CUENTAS + " ON " + TABLA_CLIENTES + ".cliente_id = " + TABLA_CUENTAS + ".cliente_id"
//                + " INNER JOIN " + TABLA_PERFILES + " ON " + TABLA_CLIENTES + ".cliente_id = " + TABLA_PERFILES + ".cliente_id"
//                + " INNER JOIN " + TABLA_CASADOS + " ON " + TABLA_CLIENTES + ".cliente_id = " + TABLA_CASADOS + ".cliente_id"
//                + " WHERE DNI=?";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, dni);

            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    cliente = crearCliente(rs);
                }
            } catch (Exception e) {
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return cliente;

    }

    /**
     * Método estático perfilPorIdCliente que recibe por parámetro el id del cliente y crea un objeto Perfil.
     *
     * @param idCliente Parámetro de tipo String que será el id del cliente.
     * @return Devuelve un Perfil.
     */
    public static Perfil perfilPorIdCliente(String idCliente) {

        Perfil perfil = null;

        String sql = "SELECT * FROM " + TABLA_PERFILES + " WHERE cliente_id=?";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, idCliente);

            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    perfil = crearPerfil(rs);
                }
            } catch (Exception e) {
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return perfil;

    }

    /**
     * Método estático cuentaPorIdCliente que recibe por parámetro el id del cliente y crea un objeto CuentaBancaria.
     *
     * @param idCliente Parámetro de tipo String que será el id del cliente.
     * @return Devuelve un CuentaBancaria.
     */
    public static CuentaBancaria cuentaPorIdCliente(String idCliente) {

        CuentaBancaria cuenta = null;

        String sql = "SELECT * FROM " + TABLA_CUENTAS + " WHERE cliente_id=?";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, idCliente);

            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    cuenta = crearCuentaBancaria(rs);
                }
            } catch (Exception e) {
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return cuenta;

    }

    /**
     * Método estático movimientosPorIDCliente que recibe por parámetro el id del cliente y crea una lista de movimientos.
     * 
     * @param idCliente Parámetro de tipo String que será el id del cliente.
     * @return Devuelve un List <code>Movimiento</code>
     */
    public static List<Movimiento> movimientosPorIDCliente(String idCliente) {

        List<Movimiento> movimientos = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLA_MOVIMIENTOS + " WHERE cliente_id=?";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Movimiento movimiento = crearMovimiento(rs);
                if (!movimientos.add(movimiento)) {
                    throw new Exception("Error: no se ha insertado el objeto en la colección.");
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return movimientos;

    }

    /**
     * Método estático crearCliente que crea un objeto de tipo Cliente.
     *
     * @param rs Parámetro de tipo ResultSet.
     * @return Devuelve un objeto Cliente.
     * @throws SQLException Lanza una excepción si hay algún error de SQL.
     */
    private static Cliente crearCliente(final ResultSet rs) throws SQLException {
        return new Cliente(rs.getString("cliente_id"), rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("telefono"), rs.getString("direccion"), rs.getString("localidad"), rs.getDate("fecha_nacimiento").toLocalDate(), perfilPorIdCliente(rs.getString("cliente_id")), cuentaPorIdCliente(rs.getString("cliente_id")));
    }
    
    /**
     * Método estático crearPerfil que crea un objeto de tipo Perfil.
     *
     * @param rs Parámetro de tipo ResultSet.
     * @return Devuelve un objeto Perfil.
     * @throws SQLException Lanza una excepción si hay algún error de SQL.
     */
    private static Perfil crearPerfil(final ResultSet rs) throws SQLException {
        return new Perfil(rs.getString("usuario"), rs.getString("contraseña"), SituacionCivil.valueOf(rs.getString("situacion_civil")), SituacionLaboral.valueOf(rs.getString("situacion_laboral")), rs.getBoolean("moroso"), rs.getBoolean("proceso_judicial"), null, false);
    }

    /**
     * Método estático crearCuentaBancaria que crea un objeto de tipo CuentaBancaria.
     *
     * @param rs Parámetro de tipo ResultSet.
     * @return Devuelve un objeto CuentaBancaria.
     * @throws SQLException Lanza una excepción si hay algún error de SQL.
     */
    private static CuentaBancaria crearCuentaBancaria(final ResultSet rs) throws SQLException {
        return new CuentaBancaria(rs.getString("iban"), TipoCuenta.valueOf(rs.getString("tipo_cuenta")), rs.getDouble("saldo"), rs.getDouble("cantidad_ultima_nomina"), rs.getDouble("cantidad_media_ultimos_12_meses"), rs.getInt("meses_cotizados") , movimientosPorIDCliente(rs.getString("cliente_id")));
    }

    /**
     * Método estático crearMovimiento que crea un objeto de tipo Movimiento.
     *
     * @param rs Parámetro de tipo ResultSet.
     * @return Devuelve un objeto Movimiento.
     * @throws SQLException Lanza una excepción si hay algún error de SQL.
     */
    private static Movimiento crearMovimiento(final ResultSet rs) throws SQLException {
        return new Movimiento(rs.getInt("numero_operacion"), rs.getDouble("cantidad"), TipoMovimiento.valueOf(rs.getString("tipo_movimiento")), rs.getString("emisor"), rs.getString("destinatario"), rs.getString("concepto"), rs.getDate("fecha").toLocalDate());
    }

    /**
     * Método estático crearPago que crea un objeto de tipo Pago.
     *
     * @param rs Parámetro de tipo ResultSet.
     * @return Devuelve un objeto Pago.
     * @throws SQLException Lanza una excepción si hay algún error de SQL.
     */
    private static Pago crearPago(final ResultSet rs) throws SQLException {
        return new Pago(rs.getInt("numero_pago"), rs.getDate("fecha_pago").toLocalDate(), rs.getDouble("cantidad_pagada"));
    }

    /**
     * Método estático crearPrestamoConcedido que crea un objeto de tipo PrestamoConcedido.
     *
     * @param rs Parámetro de tipo ResultSet.
     * @return Devuelve un objeto PrestamoConcedido.
     * @throws SQLException Lanza una excepción si hay algún error de SQL.
     */
    private static PrestamoConcedido crearPrestamoConcedido(final ResultSet rs) throws SQLException {
        return new PrestamoConcedido(null, null);
    }

    /**
     * Método estático crearPrestamoPreconcedido que crea un objeto de tipo PrestamoPreconcedido.
     *
     * @param rs Parámetro de tipo ResultSet.
     * @return Devuelve un objeto PrestamoPreconcedido.
     * @throws SQLException Lanza una excepción si hay algún error de SQL.
     */
    private static PrestamoPreconcedido crearPrestamoPreconcedido(final ResultSet rs) throws SQLException {
        return new PrestamoPreconcedido(rs.getInt("periodo_meses"), rs.getDouble("tipo_interes"), rs.getInt("plazo_aceptacion_dias"), rs.getInt("numero_prestamo"), null, rs.getDate("fecha_oferta").toLocalDate(), rs.getDouble("cantidad"));
    }

}
