/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.servicios.Conexion_DB;
import db.servicios.DBCliente;
import db.servicios.DBCompra;
import db.servicios.DBLinea_Compra;
import db.servicios.DBMarca;
import db.servicios.DBProducto;
import db.servicios.DBProveedor;
import db.servicios.DBRubro;
import db.servicios.DBUbicacion;
import db.servicios.DBUnidad;
import db.servicios.DBUsserPass;
import db.servicios.MySql;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.dominio.CLIENTE;
import modelo.dominio.COMPRA;
import modelo.dominio.EMPLEADO;
import modelo.dominio.MARCA;
import modelo.dominio.PRODUCTO;
import modelo.dominio.PROVEEDOR;
import modelo.dominio.RUBRO;
import vista.recursos.ModeloTabla;

/**
 *
 * @author vicente
 */
public class CONTROLADOR_DB {

    private static Conexion_DB conexion;

    public CONTROLADOR_DB() {
    }

    public boolean conectar(String user, String pass, EMPLEADO logeo) {
        conexion = new MySql();
        if (conexion == null) {
            JOptionPane.showMessageDialog(null, "No se logro conectar con la Base de Datos. \nNo se puede iniciar la Aplicación.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            try {
                conexion.conectar(user, pass);
                if (DBUsserPass.permiso(user, logeo)) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no tiene permiso de acceso.", "ERROR", JOptionPane.WARNING_MESSAGE);
                    getConexion().getConexion().close();
                    return false;
                }
            } catch (SQLException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "No se logro conectar con la Base de Datos. \nNo se puede iniciar la Aplicación.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    public static Conexion_DB getConexion() {
        return conexion;
    }

    //===========Recuperar Rubros==============
    public static void recupNombresRubros(JComboBox lista) {
        DBRubro.recupNombresRubro(lista);
    }

    //========Recupera los nombres de Marca========
    public static void recupNombresMarca(JComboBox lista) {
        DBMarca.recupNombresMarca(lista);
    }

    //========Recupera los nombres de Unidad========
    public static void recupNombresUnidad(JComboBox lista) {
        DBUnidad.recupNombresUnidad(lista);
    }

    //========Recupera codigo de producto nuevo========
    public static Integer recupCodigoProducto(String nombreRurbo) {
        return DBProducto.recupCodigoProducto(nombreRurbo);
    }

    //========Recupera codigo proximo de rubro============
    public static Integer recupCodigoRubroProximo() {
        return DBRubro.recupCodigoRubroProximo();
    }

    //============Recupera todos los producto===============
    public static ArrayList<PRODUCTO> recuperarListaProductoDB() {
        return DBProducto.recuperarListaProductoDB();
    }

    //===========Recupera Proveedores================
    public static ArrayList<PROVEEDOR> recuperarListaProveedorDB() {
        return DBProveedor.recuperarListaProveedor();
    }

    //=========Recupera CLiente
    public static ArrayList<CLIENTE> recuperarListaClienteDB() {
        return DBCliente.recuperarListaCliente();
    }

    //=============Confirma la Factura Compra===================
    public static boolean confirmarFacCompra(COMPRA compra, ArrayList<PRODUCTO> listaProdNuevo) {
        if (DBCompra.cargarFacCompra(compra, listaProdNuevo)) {
            if (DBLinea_Compra.agregarLineas(listaProdNuevo, compra.getLista_compra())) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    //===========Alta de Rubro=========
    public static boolean altaRub(RUBRO rubro) {
        return DBRubro.altaRub(rubro);
    }

    //==========ALta de Marca===========
    public static boolean altaMarca(MARCA marca) {
        return DBMarca.altaMar(marca);
    }

    //==========Modificar Producto=========
    public static boolean modificarProducto(PRODUCTO producto) {
        return DBProducto.modificarProducto(producto);
    }

    //==========Eliminar Producto=========
    public static boolean eliminarProducto(PRODUCTO producto) {
        return DBProducto.eliminarProducto(producto.getCUP(), "producto");
    }

    //==========Modificar Rubro=============
    public static boolean modificarRubro(String nomActual, String nomFut) {
        return DBRubro.modificarRubro(nomActual, nomFut);
    }

    //===========Eliminar rubro=========
    public static boolean eliminarRubro(Integer codRurbo) {
        return DBRubro.eliminarRubro(codRurbo);
    }

    //==========Modificar Marca==========
    public static boolean modificarMarca(String nomActual, String nomFut) {
        return DBMarca.modificarMarca(nomActual, nomFut);
    }

    //==========Eliminar Marca============
    public static boolean eliminarMarca(Integer codMarca) {
        return DBMarca.eliminarMarca(codMarca);
    }

    //=========Recupera codigo de rubro seleccionado ==========
    public static Integer idRubro(String nombre) {
        return DBRubro.idRubro(nombre);
    }

    public static ModeloTabla recuperarDatos(String nombre, ModeloTabla modelo, String origen) {
        if (origen.equals("rubro")) {
            return DBRubro.recuperarDatos(nombre, modelo);
        } else {
            return DBMarca.recuperarDatos(nombre, modelo);
        }
    }

    //=========Mod ubicacion=======
    public static void altaPais(String pais) {
        DBUbicacion.altaPais(pais);
    }

    public static void altaProvincia(String provincia, String pais) {
        DBUbicacion.altaProvincia(provincia, pais);
    }

    public static void altaLocalidad(String localidad, String provincia) {
        DBUbicacion.altaLocalidad(localidad, provincia);
    }

    public static void altaCP(Integer cp, String localidad) {
        DBUbicacion.altaCP(cp, localidad);
    }

    public static void recuperarPais(JComboBox listaPais) {
        DBUbicacion.recuperarPais(listaPais);
    }

    public static ArrayList recuperarProvincia(String pais) {
        return DBUbicacion.recuperarProvincia(pais);
    }

    public static ArrayList recuperarLocalidad(String provincia) {
        return DBUbicacion.recuperarLocalidad(provincia);
    }

    public static ArrayList recuperarCP(String localidad) {
        return DBUbicacion.recuperarCP(localidad);
    }
    //=========================================

    //=========Proveedor=========
    public static void recuperarTipoRS(JComboBox listRS) {
        DBProveedor.recuperarTipoRS(listRS);
    }

    public static boolean altaProveedor(PROVEEDOR proveedor) {
        if (DBProveedor.verficiarCUIT(proveedor)) {
            return DBProveedor.altaProveedor(proveedor);
        } else {
            return false;
        }
    }

    public static boolean modificarProveedor(PROVEEDOR proveedor) {
        return DBProveedor.modificarProveedor(proveedor);
    }
    //===========================

    //=========Cliente===========
    public static boolean altaCliente(CLIENTE cliente) {
        if (DBCliente.verficiarCUIT(cliente)) {
            return DBCliente.altaCliente(cliente);
        } else {
            return false;
        }
    }

    public static boolean modificarCliente(CLIENTE cliente) {
        return DBCliente.modificarCliente(cliente);
    }
    
    public static void eliminarCliente(String cuit){
        DBCliente.eliminarCliente(cuit);
    }
}
