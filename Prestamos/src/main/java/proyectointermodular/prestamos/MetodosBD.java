/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
    private static final String TABLA_PRECONCEDIDOS = "prestamospreconcedidos";
    private static final String TABLA_CONCEDIDOS = "prestamosconcedidos";
    private static final String TABLA_PAGOS = "pagos";

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
     * Método estático listarPrestamosPreconcedidos para listar los préstamos preconcedidos.
     *
     * @return Devuelve un List <code>PrestamoPreconcedido</code>
     */
    public static List<PrestamoPreconcedido> listarPrestamosPreconcedidos() {

        List<PrestamoPreconcedido> listaprestamoPreconcedido = new ArrayList();

        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLA_PRECONCEDIDOS);) {

            while (rs.next()) {

                PrestamoPreconcedido prestamopreconcedido = crearPrestamoPreconcedido(rs);

                if (!listaprestamoPreconcedido.add(prestamopreconcedido)) {
                    throw new Exception("Error: no se ha insertado el objeto en la colección.");
                }

            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return listaprestamoPreconcedido;

    }

    /**
     * Método que te devuelve una lista con los prestamos preconcedidos de un cliente por DNI.
     *
     * @param dni Parámetro de tipo String que será el DNI.
     * @return Devuelve un List<code>PrestamoPreconcedido</code>
     */
    public static List<PrestamoPreconcedido> listarPrestamosPreconcedidosPorDNI(String dni) {

        Cliente caux = clientePorDni(dni);
        List<PrestamoPreconcedido> listaprestamoPreconcedido = new ArrayList();

        if (caux != null) {

            String uuid = caux.getUuid();
            String sql = "SELECT * FROM " + TABLA_PRECONCEDIDOS + " WHERE cliente_id = ?";

            try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

                stmt.setString(1, uuid);

                try ( ResultSet rs = stmt.executeQuery();) {
                    while (rs.next()) {

                        PrestamoPreconcedido prestamopreconcedido = crearPrestamoPreconcedido(rs);

                        if (!listaprestamoPreconcedido.add(prestamopreconcedido)) {
                            throw new Exception("Error: no se ha insertado el objeto en la colección.");
                        }
                    }
                }
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return listaprestamoPreconcedido;

    }

    /**
     * Método que te devuelve los clientes de una ciudad específica.
     *
     * @param ciudad Parámetro de tipo String que será la ciudad.
     * @return Devuelve un List<code>Cliente</code>
     */
    public static List<Cliente> listarClientesPorLocalidad(String ciudad) {

        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLA_CLIENTES + " WHERE localidad = ?";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, ciudad);

            try ( ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    Cliente cliente = crearCliente(rs);
                    if (!clientes.add(cliente)) {
                        throw new Exception("Error: no se ha insertado el objeto en la colección.");
                    }
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
     * Método que devuelve una lista de prestamos preconcedidos de los clientes de una ciudad determinada.
     *
     * @param ciudad Parámetro de tipo String que será la ciudad.
     * @return Devuelve un List<code>PrestamoPreconcedido</code>
     */
    public static List<PrestamoPreconcedido> listarPrestamosPreconcedidosPorLocalidad(String ciudad) {

        List<Cliente> clientes = listarClientesPorLocalidad(ciudad);
        List<PrestamoPreconcedido> listaprestamoPreconcedido = new ArrayList();
        String sql = "SELECT * FROM " + TABLA_PRECONCEDIDOS + " WHERE cliente_id = ?";

        if (!clientes.isEmpty()) {

            for (Cliente cliente : clientes) {

                String uuid = cliente.getUuid();
                try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

                    stmt.setString(1, uuid);

                    try ( ResultSet rs = stmt.executeQuery();) {
                        while (rs.next()) {

                            PrestamoPreconcedido prestamopreconcedido = crearPrestamoPreconcedido(rs);

                            if (!listaprestamoPreconcedido.add(prestamopreconcedido)) {
                                throw new Exception("Error: no se ha insertado el objeto en la colección.");
                            }
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println("SQLException: " + ex.getMessage());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        }

        return listaprestamoPreconcedido;

    }

    /**
     * Método estático listarPrestamosConcedidos para listar los préstamos concedidos.
     *
     * @return Devuelve un List <code>PrestamoConcedido</code>
     */
    public static List<PrestamoConcedido> listarPrestamosConcedidos() {

        List<PrestamoConcedido> listaprestamoConcedido = new ArrayList();

        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLA_CONCEDIDOS);) {

            while (rs.next()) {

                PrestamoConcedido prestamoconcedido = crearPrestamoConcedido(rs);

                if (!listaprestamoConcedido.add(prestamoconcedido)) {
                    throw new Exception("Error: no se ha insertado el objeto en la colección.");
                }

            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return listaprestamoConcedido;

    }

    /**
     * Método estático listarPrestamosConcedidosPorId para listar los préstamos concedidos por Id de cliente concedidos.
     *
     * @param id Parámetro de tipo String que será el id.
     * @return Devuelve un List <code>PrestamoConcedido</code>
     */
    public static List<PrestamoConcedido> listarPrestamosConcedidosPorId(String id) {

        List<PrestamoConcedido> listaprestamoConcedido = new ArrayList();
        String sql = "SELECT * FROM " + TABLA_CONCEDIDOS + " INNER JOIN prestamospreconcedidos ON prestamosconcedidos.numero_prestamo_preconcedido=prestamospreconcedidos.numero_prestamo WHERE prestamosconcedidos.cliente_id = ?";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, id);

            try ( ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {

                    PrestamoConcedido prestamoconcedido = crearPrestamoConcedido(rs);

                    if (!listaprestamoConcedido.add(prestamoconcedido)) {
                        throw new Exception("Error: no se ha insertado el objeto en la colección.");
                    }

                }
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return listaprestamoConcedido;

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

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, dni);

            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    cliente = crearCliente(rs);
                }
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
        String sql;
        int casado = saberSiEstaCasado(idCliente);

        if (casado == 0) {
            sql = "SELECT * FROM " + TABLA_PERFILES + " WHERE cliente_id=?";
        } else {
            sql = "SELECT cliente_id, usuario, contraseña, situacion_civil, situacion_laboral, moroso, proceso_judicial, conyuge_id, regimen_matrimonial FROM "
                    + TABLA_PERFILES
                    + " INNER JOIN " + TABLA_CASADOS + " ON cliente_id = id WHERE cliente_id=?";
        }

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, idCliente);

            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    if (casado == 0) {
                        perfil = crearPerfil(rs);
                    } else {
                        perfil = crearPerfilCasado(rs);
                    }

                }
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return perfil;

    }

    /**
     * Método estático saberSiEstaCasado que recibe por parámetro un id de cliente y devuelve un entero indicando si está casado con un cliente del banco.
     *
     * @param idCliente Parámetro de tipo String que será el id del cliente.
     * @return Devuelve un int
     */
    private static int saberSiEstaCasado(String idCliente) {

        int casado = 0;

        String sql = "SELECT COUNT(*) AS total_filas FROM (SELECT * FROM casados WHERE id=?) AS resultados";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, idCliente);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    casado = rs.getInt("total_filas");
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return casado;

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
     * Método estático pagosPorNumPrestamo que recibe por parámetro un número de préstamo y devuelve una lista de los pagos.
     *
     * @param numPrestamo Parámetro de tipo int que será el número de préstamo.
     * @return Devuelve un List<code>Pago</code>
     */
    public static List<Pago> pagosPorNumPrestamo(int numPrestamo) {

        List<Pago> pagos = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLA_PAGOS + " WHERE numero_prestamo=?";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setInt(1, numPrestamo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pago pago = crearPago(rs);
                if (!pagos.add(pago)) {
                    throw new Exception("Error: no se ha insertado el objeto en la colección.");
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return pagos;

    }

    /**
     * Método estático prestamoPreconcedidoPorIdCliente que recibe por parámetro un id del cliente y crea un objeto PrestamoPreconcedido.
     *
     * @param idCliente Parámetro de tipo String que será el id del cliente.
     * @return Devuelve un PrestamoPreconcedido.
     */
    public static PrestamoPreconcedido prestamoPreconcedidoPorIdCliente(String idCliente) {

        PrestamoPreconcedido prestamoPreconcedido = null;
        String sql = "SELECT * FROM " + TABLA_PRECONCEDIDOS + " WHERE cliente_id=?";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, idCliente);

            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    prestamoPreconcedido = crearPrestamoPreconcedido(rs);
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return prestamoPreconcedido;

    }

    /**
     * Metodo para generar un prestamo por su id y el del cliente.
     *
     * @param idCliente Parámetro de tipo String que será el id del cliente.
     * @param num Parámetro de tipo int que será el número de préstamo.
     * @return Devuelve un PrestamoPreconcedido.
     */
    public static PrestamoPreconcedido prestamoPreconcedidoPorIdClienteNum(String idCliente, int num) {

        PrestamoPreconcedido prestamoPreconcedido = null;
        String sql = "SELECT * FROM " + TABLA_PRECONCEDIDOS + " WHERE cliente_id=? AND numero_prestamo=?";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, idCliente);
            stmt.setInt(2, num);

            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    prestamoPreconcedido = crearPrestamoPreconcedido(rs);
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return prestamoPreconcedido;

    }

    /**
     * Método prestamoPreconcedidoPorNum que recibe por parámetro un id de número de préstamo preconcedido y devuelve el objeto.
     *
     * @param num Parámetro de tipo int que será el número de préstamo.
     * @return Devuelve un PrestamoPreconcedido.
     */
    public static PrestamoPreconcedido prestamoPreconcedidoPorNum(int num) {

        PrestamoPreconcedido prestamoPreconcedido = null;
        String sql = "SELECT * FROM " + TABLA_PRECONCEDIDOS + " WHERE numero_prestamo=?";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setInt(1, num);

            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    prestamoPreconcedido = crearPrestamoPreconcedido(rs);
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return prestamoPreconcedido;

    }

    /**
     * Método estático insertarPrestamo que recibe por parámetro un objeto PrestamoPreconcedido y lo inserta en la base de datos.
     *
     * @param prestamopreconcedido Parámetro de tipo PrestamoPreconcedido que será el objeto a insertar.
     */
    public static void insertarPrestamopreconcedido(PrestamoPreconcedido prestamopreconcedido) {

        String sql = "INSERT INTO " + TABLA_PRECONCEDIDOS + " (cliente_id,fecha_oferta,cantidad,periodo_meses,tipo_interes,plazo_aceptacion_dias) VALUES(?,?,?,?,?,?)";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, prestamopreconcedido.getCliente().getUuid());
            stmt.setDate(2, Date.valueOf(prestamopreconcedido.getFecha()));
            stmt.setDouble(3, prestamopreconcedido.getCantidad());
            stmt.setInt(4, prestamopreconcedido.getPeriodoMeses());
            stmt.setDouble(5, prestamopreconcedido.getTipoInteres());
            stmt.setInt(6, prestamopreconcedido.getPlazoAceptacion());

            int salida = stmt.executeUpdate();

            if (salida != 1) {
                throw new Exception(" No se ha insertado un solo registro");
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Método estático insertarPrestamoConcedido que recibe por parámetro un objeto PrestamoConcedido y lo inserta en la base de datos.
     *
     * @param prestamoconcedido Parámetro de tipo PrestamoConcedido que será el objeto a insertar.
     */
    public static void insertarPrestamoConcedido(PrestamoConcedido prestamoconcedido) {

        String sql = "INSERT INTO " + TABLA_CONCEDIDOS + " (cliente_id,fecha_firma,numero_prestamo_preconcedido,cantidad_mensual) VALUES(?,?,?,?)";

        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, prestamoconcedido.getPrestamoPreconcedido().getCliente().getUuid());
            stmt.setDate(2, Date.valueOf(LocalDate.now()));
            stmt.setInt(3, prestamoconcedido.getPrestamoPreconcedido().getId());
            stmt.setDouble(4, prestamoconcedido.getCantidad());

            int salida = stmt.executeUpdate();

            if (salida != 1) {
                throw new Exception(" No se ha insertado un solo registro");
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

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
     * Método estático crearPerfilCasado que crea un objeto de tipo Perfil.
     *
     * @param rs Parámetro de tipo ResultSet.
     * @return Devuelve un objeto Perfil.
     * @throws SQLException Lanza una excepción si hay algún error de SQL.
     */
    private static Perfil crearPerfilCasado(final ResultSet rs) throws SQLException {
        return new Perfil(rs.getString("usuario"), rs.getString("contraseña"), SituacionCivil.valueOf(rs.getString("situacion_civil")), SituacionLaboral.valueOf(rs.getString("situacion_laboral")), rs.getBoolean("moroso"), rs.getBoolean("proceso_judicial"), rs.getString("conyuge_id"), rs.getBoolean("regimen_matrimonial"));
    }

    /**
     * Método estático crearCuentaBancaria que crea un objeto de tipo CuentaBancaria.
     *
     * @param rs Parámetro de tipo ResultSet.
     * @return Devuelve un objeto CuentaBancaria.
     * @throws SQLException Lanza una excepción si hay algún error de SQL.
     */
    private static CuentaBancaria crearCuentaBancaria(final ResultSet rs) throws SQLException {
        return new CuentaBancaria(rs.getString("iban"), TipoCuenta.valueOf(rs.getString("tipo_cuenta")), rs.getDouble("saldo"), rs.getDouble("cantidad_ultima_nomina"), rs.getDouble("cantidad_media_ultimos_12_meses"), rs.getInt("meses_cotizados"), movimientosPorIDCliente(rs.getString("cliente_id")));
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
        //return new PrestamoConcedido(prestamoPreconcedidoPorIdCliente(rs.getString("cliente_id")), pagosPorNumPrestamo(rs.getInt("numero_prestamo")), rs.getInt("numero_prestamo"), clientePorId(rs.getString("cliente_id")), rs.getDate("fecha_firma").toLocalDate(), rs.getDouble("cantidad_mensual"));
        return new PrestamoConcedido(prestamoPreconcedidoPorNum(rs.getInt("numero_prestamo_preconcedido")), pagosPorNumPrestamo(rs.getInt("numero_prestamo")), rs.getInt("numero_prestamo"), clientePorId(rs.getString("cliente_id")), rs.getDate("fecha_firma").toLocalDate(), rs.getDouble("cantidad_mensual"));
    }

    /**
     * Método estático crearPrestamoPreconcedido que crea un objeto de tipo PrestamoPreconcedido.
     *
     * @param rs Parámetro de tipo ResultSet.
     * @return Devuelve un objeto PrestamoPreconcedido.
     * @throws SQLException Lanza una excepción si hay algún error de SQL.
     */
    private static PrestamoPreconcedido crearPrestamoPreconcedido(final ResultSet rs) throws SQLException {
        return new PrestamoPreconcedido(rs.getInt("periodo_meses"), rs.getDouble("tipo_interes"), rs.getInt("plazo_aceptacion_dias"), rs.getInt("numero_prestamo"), clientePorId(rs.getString("cliente_id")), rs.getDate("fecha_oferta").toLocalDate(), rs.getDouble("cantidad"), rs.getBoolean("firmado"));
    }

}
