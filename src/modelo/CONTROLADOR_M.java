/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import db.CONTROLADOR_DB;
import db.servicios.DBMarca;
import db.servicios.DBRubro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.dominio.CLIENTE;
import modelo.dominio.COMPRA;
import modelo.dominio.EMPLEADO;
import modelo.dominio.LINEA_COMPRA;
import modelo.dominio.MARCA;
import modelo.dominio.PRODUCTO;
import modelo.dominio.PROVEEDOR;
import modelo.dominio.RUBRO;
import vista.recursos.ModeloTabla;

/**
 *
 * @author vicente
 */
public class CONTROLADOR_M {

    private static COMPRA compra;
    private static PRODUCTO producto;
    private static RUBRO rubro;
    private static MARCA marca;
    private static ArrayList<PRODUCTO> listaProductoNuevo;
    private static CONTROLADOR_DB contro_db;
    private static EMPLEADO logeo;
    private static PROVEEDOR proveedor;
    private static CLIENTE cliente;
    private static ArrayList<PROVEEDOR> listaProveedor;

    public CONTROLADOR_M() {
        CONTROLADOR_M.contro_db = new CONTROLADOR_DB();
        CONTROLADOR_M.listaProductoNuevo = new ArrayList<>();
    }

    public boolean conectar(String user, String pass) {
        CONTROLADOR_M.logeo = new EMPLEADO();
        return this.getContro_db().conectar(user, pass, logeo);
    }

    public static EMPLEADO getLogeo() {
        return logeo;
    }

    public static ArrayList<PRODUCTO> getListaProductoDB() {
        return CONTROLADOR_DB.recuperarListaProductoDB();
    }

    public static ArrayList<PRODUCTO> getListaProductoNuevo() {
        return listaProductoNuevo;
    }

    public static ArrayList<PROVEEDOR> getListaProveedorDB() {
        return CONTROLADOR_DB.recuperarListaProveedorDB();
    }

    public static ArrayList<CLIENTE> getListaClienteDB() {
        return CONTROLADOR_DB.recuperarListaClienteDB();
    }

    public static COMPRA getCompra() {
        return compra;
    }

    public static CONTROLADOR_DB getContro_db() {
        return contro_db;
    }

    //===========Recupera los nombres de Rubros====
    public static void recupNombresRubros(JComboBox lista) {
        CONTROLADOR_DB.recupNombresRubros(lista);
    }

    //========Recupera los nombres de Marca========
    public static void recupNombresMarca(JComboBox lista) {
        CONTROLADOR_DB.recupNombresMarca(lista);
    }

    //========Recupera los nombres de Unidad========
    public static void recupNombresUnidad(JComboBox lista) {
        CONTROLADOR_DB.recupNombresUnidad(lista);
    }

    //========Recupera los nombres de Proveedor========
    public static void recupNombresProveedor(JComboBox lista) {
        listaProveedor = getListaProveedorDB();
        for (PROVEEDOR proveedorDB : listaProveedor) {
            lista.addItem(proveedorDB.getRazonSocial() + " " + proveedorDB.getRs());
        }
    }

    //=======Recupera codigo correspondiente=========
    public static Integer recupCodigoProducto(String nombreRurbo) {
        return CONTROLADOR_DB.recupCodigoProducto(nombreRurbo);
    }

    //========Recupera codigo correspondiente============
    public static Integer recupCodigoRubroProximo() {
        return CONTROLADOR_DB.recupCodigoRubroProximo();
    }

    //=====Inicia los objetos para el altastock======
    public static void iniciaAltaStock() {
        CONTROLADOR_M.compra = new COMPRA();
    }

    //==========METODOS DE ALTA DE STOCK=======================
    //===========Ingresa un nuevo producto===================
    public static void ingresaDatosNuevoProducto(Integer prov, String rubro, Integer cup, String marca, String descripcion, Float cap_vol, String unidad, Float precioUnitario, Integer stockIngreso, Float costoProd) {
        CONTROLADOR_M.producto = new PRODUCTO();
        CONTROLADOR_M.producto.setnRubro(rubro);
        CONTROLADOR_M.producto.setCUP(cup);
        CONTROLADOR_M.producto.setnMarca(marca);
        CONTROLADOR_M.producto.setDescripcion(descripcion);
        CONTROLADOR_M.producto.setCap_vol_long(cap_vol);
        CONTROLADOR_M.producto.setStock(0);
        CONTROLADOR_M.producto.setnUnidad(unidad);
        CONTROLADOR_M.producto.setPrecio_Unitario(precioUnitario);
        PROVEEDOR prove = listaProveedor.get(prov);
        CONTROLADOR_M.producto.setProveedor(prove);
        CONTROLADOR_M.getCompra().ingresaDatos(producto, stockIngreso, costoProd);
        CONTROLADOR_M.getListaProductoNuevo().add(producto);
    }

    //===============Verifica que no este cargado el producto===============
    public boolean cargarProducto(Integer cup, Integer stockIng, Float costoTotal) {
        boolean estaCargado = false;
        for (LINEA_COMPRA linea : CONTROLADOR_M.getCompra().getLista_compra()) {
            if (linea.getCUP().equals(cup)) {
                estaCargado = true;
            }
        }
        if (estaCargado == false) {
            if (CONTROLADOR_M.getCompra().getLista_compra().isEmpty()) {
                for (PRODUCTO mProducto : CONTROLADOR_M.getListaProductoDB()) {
                    if (mProducto.getCUP().equals(cup)) {
                        CONTROLADOR_M.getCompra().setM_LINEA_FACTURA(CONTROLADOR_M.getCompra().cargar(mProducto, stockIng, costoTotal));
                    }
                }
            } else {
                for (PRODUCTO mProducto : CONTROLADOR_M.getListaProductoDB()) {
                    if (mProducto.getCUP().equals(cup)) {
                        CONTROLADOR_M.getCompra().setM_LINEA_FACTURA((CONTROLADOR_M.getCompra().cargar(mProducto, stockIng, costoTotal)));
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El Producto ya fue cargado.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        return estaCargado;
    }

    public static void eliminar(Integer cup) {
        Iterator iteLinea = CONTROLADOR_M.getCompra().getLista_compra().iterator();
        while (iteLinea.hasNext()) {
            LINEA_COMPRA linea = (LINEA_COMPRA) iteLinea.next();
            if (cup.equals(linea.getCUP())) {
                if (eliminarProducto(cup)) {
                    iteLinea.remove();
                } else {
                    iteLinea.remove();
                }
            }
        }
        CONTROLADOR_M.getCompra().actEliminar();
    }

    private static boolean eliminarProducto(Integer cup) {
        Iterator iteProd = CONTROLADOR_M.getListaProductoNuevo().iterator();
        while (iteProd.hasNext()) {
            PRODUCTO mProducto = (PRODUCTO) iteProd.next();
            if (cup.equals(mProducto.getCUP())) {
                iteProd.remove();
                return true;
            }
        }
        return false;
    }

    public static boolean ingresaDatosFac(Integer numero_Factura, Date fecha) {
        java.sql.Date fechaSql = new java.sql.Date(fecha.getTime());
        CONTROLADOR_M.getCompra().setFecha(fechaSql);
        CONTROLADOR_M.getCompra().setNumero_Factura(numero_Factura);
        if (CONTROLADOR_DB.confirmarFacCompra(CONTROLADOR_M.getCompra(), CONTROLADOR_M.getListaProductoNuevo())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean altaRubro(int id_Rubro, String nombre) {
        CONTROLADOR_M.rubro = new RUBRO(id_Rubro, nombre);
        return CONTROLADOR_DB.altaRub(rubro);
    }

    public static boolean altaMarca(String nombre) {
        marca = new MARCA();
        marca.setNombre(nombre);
        return CONTROLADOR_DB.altaMarca(marca);
    }
    //==========FIN METODOS DE ALTA DE STOCK=======================

    //===========INICIA METODOS DE ABM==============================
    //==========Modifica producto===============
    public static boolean modificarProducto(PRODUCTO producto) {
        return CONTROLADOR_DB.modificarProducto(producto);
    }

    public static boolean eliminarProducto(PRODUCTO producto) {
        return CONTROLADOR_DB.eliminarProducto(producto);
    }

    public static boolean modificarRubro(String nomActual, String nomFut) {
        return CONTROLADOR_DB.modificarRubro(nomActual, nomFut);
    }

    public static boolean eliminarRubro(Integer codRurbo) {
        return CONTROLADOR_DB.eliminarRubro(codRurbo);
    }

    public static boolean modificarMarca(String nomActual, String nomFut) {
        return CONTROLADOR_DB.modificarMarca(nomActual, nomFut);
    }

    public static boolean eliminarMarca(Integer codMarca) {
        return CONTROLADOR_DB.eliminarMarca(codMarca);
    }
    //===========FInaliza metodos de ABM===========

    //=========Recupera codigo seleccionado ==========
    public static Integer idRubro(String nombre) {
        return DBRubro.idRubro(nombre);
    }

    public static Integer idMarca(String nombre) {
        return DBMarca.idMarca(nombre);
    }

    //============Recupera productos a eliminar junto al rubro/marca===========
    public static ModeloTabla recuperarDatos(String nombre, ModeloTabla modelo, String origen) {
        return CONTROLADOR_DB.recuperarDatos(nombre, modelo, origen);
    }

    //=========Proveedor======
    public static void recuperarTipoRS(JComboBox listRS) {
        CONTROLADOR_DB.recuperarTipoRS(listRS);
    }

    public static boolean altaProveedor(String cuit, String razonSocial, String rs, String telefono, String contacto, String observacion, String domicilio, String pais, String provincia, String localidad, Integer cp) {
        CONTROLADOR_M.proveedor = new PROVEEDOR(cuit, razonSocial, rs, telefono, contacto, observacion, domicilio, pais, provincia, localidad, cp);
        if (CONTROLADOR_DB.altaProveedor(CONTROLADOR_M.proveedor)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean modificarProveedor(String cuit, String razonSocial, String rs, String telefono, String contacto, String observacion, String domicilio, String pais, String provincia, String localidad, Integer cp) {
        for (PROVEEDOR proveedordb : CONTROLADOR_DB.recuperarListaProveedorDB()) {
            if (proveedordb.getCuit().equals(cuit)) {
                proveedordb.setRazonSocial(razonSocial);
                proveedordb.setRs(rs);
                proveedordb.setTelefono(telefono);
                proveedordb.setContacto(contacto);
                proveedordb.setObservacion(observacion);
                proveedordb.setDomicilio(domicilio);
                proveedordb.getUbicacion().setCP(cp);
                proveedordb.getUbicacion().setLocalidad(localidad);
                proveedordb.getUbicacion().setProvincia(provincia);
                proveedordb.getUbicacion().setPais(pais);
                if (CONTROLADOR_DB.modificarProveedor(proveedordb)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    //==========Cliente==========
    public static boolean altaCliente(String cuit, String razonSocial, String rs, String telefono, String domicilio, String pais, String provincia, String localidad, Integer cp) {
        CONTROLADOR_M.cliente = new CLIENTE(cuit, razonSocial, rs, telefono, domicilio, pais, provincia, localidad, cp);
        if (CONTROLADOR_DB.altaCliente(cliente)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean modificarCliente(String cuit, String razonSocial, String rs, String telefono, String domicilio, String pais, String provincia, String localidad, Integer cp) {
        for (CLIENTE clientedb : CONTROLADOR_DB.recuperarListaClienteDB()) {
            if (clientedb.getCuit().equals(cuit)) {
                clientedb.setRazonSocial(razonSocial);
                clientedb.setRs(rs);
                clientedb.setTelefono(telefono);
                clientedb.setDomicilio(domicilio);
                clientedb.getUbicacion().setCP(cp);
                clientedb.getUbicacion().setLocalidad(localidad);
                clientedb.getUbicacion().setProvincia(provincia);
                clientedb.getUbicacion().setPais(pais);
                if (CONTROLADOR_DB.modificarCliente(clientedb)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    //========Mod ubicacion==============

    public static void altaPais(String pais) {
        CONTROLADOR_DB.altaPais(pais);
    }

    public static void recuperarPais(JComboBox listaPais) {
        CONTROLADOR_DB.recuperarPais(listaPais);
    }

    public static void altaProvincia(String provincia, String pais) {
        CONTROLADOR_DB.altaProvincia(provincia, pais);
    }

    public static void altaLocalidad(String localidad, String provincia) {
        CONTROLADOR_DB.altaLocalidad(localidad, provincia);
    }

    public static void altaCP(Integer cp, String localidad) {
        CONTROLADOR_DB.altaCP(cp, localidad);
    }

    public static ArrayList recuperarProvincia(String pais) {
        return CONTROLADOR_DB.recuperarProvincia(pais);
    }

    public static ArrayList recuperarLocalidad(String provincia) {
        return CONTROLADOR_DB.recuperarLocalidad(provincia);
    }

    public static ArrayList recuperarCP(String localidad) {
        return CONTROLADOR_DB.recuperarCP(localidad);
    }
    //=============================================

    //==========Cierra la DB=============
    public void cerrarDB() {
        try {
            CONTROLADOR_DB.getConexion().getConexion().close();
            System.out.println("Se cerro la conexion");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se cerro de forma normal la aplicación", "ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CONTROLADOR_M.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
