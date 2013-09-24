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
import modelo.dominio.LINEA_COMPRA;
import modelo.dominio.PRODUCTO;

/**
 *
 * @author vicente
 */
public class DBLinea_Compra extends Entidad {

    private static String query;

    private static boolean agregarLineas(ArrayList<LINEA_COMPRA> lista_Compra, Integer idCompra) {
        try {
            for (LINEA_COMPRA linea : lista_Compra) {
                CallableStatement linea_comp_rutina = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL LINEA_COMPRA(?,?,?,?,?,?)");
                linea_comp_rutina.setInt("idComp", idCompra);
                linea_comp_rutina.setInt("cupProd", linea.getCUP());
                linea_comp_rutina.setString("descr", linea.getDescripcion());
                linea_comp_rutina.setInt("stockActual", linea.getStock_Actual());
                linea_comp_rutina.setInt("stockIngreso", linea.getStock_Ingreso());
                linea_comp_rutina.setFloat("costProd", linea.getCosto_Prod());
                if (!linea_comp_rutina.execute()) {
                    DBProducto.actualizarStock(linea.getCUP(), linea.getStock_Ingreso());
                } else {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar la Linea de Compra en Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    public static boolean agregarLineas(ArrayList<PRODUCTO> listaProdNuevo, ArrayList<LINEA_COMPRA> lista_Compra) {
        try {
            ResultSet rs = consulta("compra");
            while (rs.next()) {
                rs.last();
                Integer id = Integer.parseInt(rs.getString("idCOMPRA"));
                if (!listaProdNuevo.isEmpty()) {
                    if (DBProducto.agregarProductosNuevos(listaProdNuevo)) {
                        if (DBLinea_Compra.agregarLineas(lista_Compra, id)) {
                            return true;
                        }
                    }
                } else {
                    if (DBLinea_Compra.agregarLineas(lista_Compra, id)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
