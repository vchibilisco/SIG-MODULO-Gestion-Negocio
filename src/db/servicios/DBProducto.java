/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import db.CONTROLADOR_DB;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.dominio.PRODUCTO;

/**
 *
 * @author vicente
 */
public class DBProducto extends Entidad {

    private static ArrayList<PRODUCTO> lista_producto;
    private static String query;

    public static boolean agregarProductosNuevos(ArrayList<PRODUCTO> listaPorductoNuev) {
        try {
            for (PRODUCTO producto : listaPorductoNuev) {
                CallableStatement alta_prod_rutina = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL ALTA_PRODUCTO(?,?,?,?,?,?,?,?,?,?)");
                alta_prod_rutina.setInt("cup", producto.getCUP());
                alta_prod_rutina.setString("descrip", producto.getDescripcion());
                alta_prod_rutina.setFloat("pesVolLong", producto.getCap_vol_long());
                alta_prod_rutina.setInt("estock", 0);
                alta_prod_rutina.setFloat("preUni", producto.getPrecio_Unitario());
                alta_prod_rutina.setInt("elim", 1);
                alta_prod_rutina.setString("marc", producto.getnMarca());
                alta_prod_rutina.setString("rub", producto.getnRubro());
                alta_prod_rutina.setString("uni", producto.getnUnidad());
                alta_prod_rutina.setString("pCuit", producto.getProveedor().getCuit());
                if (!alta_prod_rutina.execute()) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar producto:\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<PRODUCTO> recuperarListaProductoDB() {
        DBProducto.lista_producto = new ArrayList<>();
        ResultSet rs = consulta("viewproducto");
        try {
            while (rs.next()) {
                PRODUCTO producto = new PRODUCTO();
                producto.setCUP(Integer.parseInt(rs.getString("CUP")));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCap_vol_long(Float.parseFloat(rs.getString("pes_vol_long")));
                producto.setStock(Integer.parseInt(rs.getString("stock")));
                producto.setPrecio_Unitario(Float.parseFloat(rs.getString("precio_unitario")));
                producto.setnMarca(rs.getString("marca"));
                producto.setnRubro(rs.getString("rubro"));
                producto.setnUnidad(rs.getString("unidad"));
                DBProducto.lista_producto.add(producto);
            }
            rs.close();
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No se logro recuperar los Productos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return DBProducto.lista_producto;
    }

    //=======Recupera codigo correspondiente=======
    public static Integer recupCodigoProducto(String nombreRubro) {
        Integer CUP = null;
        Integer idRubro = null;
        try {
            idRubro = DBRubro.idRubro(nombreRubro);
            if (idRubro != null) {
                ResultSet rs = CONTROLADOR_DB.getConexion().getStatement().executeQuery("Select CUP from producto where RUBRO_idRUBRO = " + idRubro);
                if (rs.next() != false) {
                    rs.last();
                    CUP = Integer.parseInt(rs.getString("CUP"));
                    CUP = CUP + 10;
                    rs.close();
                    return CUP;
                } else {
                    CUP = idRubro + 10;
                    rs.close();
                    return CUP;
                }
            }
        } catch (SQLException | NumberFormatException e) {
            return null;
        }
        return null;
    }

    //=======Actualiza stock==================
    public static void actualizarStock(Integer cup, Integer stock) {
        try {
            System.out.println(cup);
            CallableStatement actualizar_stock_rutina = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL ACTUALIZAR_STOCK_PRODUCTO(?,?,?)");
            actualizar_stock_rutina.setInt("cups", cup);
            actualizar_stock_rutina.setInt("estock", stock);
            actualizar_stock_rutina.setString("opcion", "compra");
            actualizar_stock_rutina.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar stock en Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    //===============Modifica Producto=================
    public static boolean modificarProducto(PRODUCTO producto) {
        try {
            CallableStatement modi_pro_rutina = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL MODIFICAR_PRODUCTO(?,?,?,?)");
            modi_pro_rutina.setInt("mCup", producto.getCUP());
            modi_pro_rutina.setFloat("pesVolLong", producto.getCap_vol_long());
            modi_pro_rutina.setFloat("preUnitario", producto.getPrecio_Unitario());
            if (producto.getnUnidad().equals("No posee")) {
                modi_pro_rutina.setString("opcion", producto.getnUnidad());
                modi_pro_rutina.execute();
                return true;
            } else {
                modi_pro_rutina.setString("opcion", "SI");
                modi_pro_rutina.execute();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos del Producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    //============Eliminar Producto============
    public static boolean eliminarProducto(Integer codigoRubro, String opcion) {
        ResultSet rs = consulta("producto");
        try {
            CallableStatement eliminar_producto_rutina = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL ELIMINAR_PRODUCTO(?,?)");
            eliminar_producto_rutina.setInt("cod", codigoRubro);
            eliminar_producto_rutina.setString("opcion", opcion);
            eliminar_producto_rutina.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo eliminar los datos del Producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }
}
