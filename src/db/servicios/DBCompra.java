/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import db.CONTROLADOR_DB;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dominio.COMPRA;
import modelo.dominio.LINEA_COMPRA;
import modelo.dominio.PRODUCTO;

/**
 *
 * @author vicente
 */
public class DBCompra extends Entidad {

    private static String query;

    public static boolean cargarFacCompra(COMPRA compra, ArrayList<PRODUCTO> listaProdNuevo) {
        ArrayList<LINEA_COMPRA> lista_Compra = compra.getLista_compra();
        try {
            CallableStatement nueva_compra_rutina = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL NUEVA_COMPRA(?,?,?)");
            nueva_compra_rutina.setInt("numFac", compra.getNumero_Factura());
            nueva_compra_rutina.setDate("fech", compra.getFecha());
            nueva_compra_rutina.setFloat("precioTotal", compra.getPrecio_Total());
            if (!nueva_compra_rutina.execute()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }
}
