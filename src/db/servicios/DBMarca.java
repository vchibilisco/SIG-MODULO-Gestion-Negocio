/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import db.CONTROLADOR_DB;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.dominio.MARCA;
import vista.recursos.ModeloTabla;

/**
 *
 * @author vicente
 */
public class DBMarca extends Entidad {

    private static String query;

    public static void recupNombresMarca(JComboBox lista) {
        ResultSet rs = consultaDes("marca", "nombre");
        try {
            while (rs.next()) {
                if (rs.getInt("eliminar") == 1) {
                    lista.addItem(rs.getString("nombre"));
                }
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    //=========Recuperar Id marca==========
    public static Integer idMarca(String marca) {
        Integer id = null;
        try {
            ResultSet rs = consulta("marca");
            while (rs.next()) {
                if (marca.equals(rs.getString("nombre"))) {
                    id = Integer.parseInt(rs.getString("idMARCA"));
                }
            }
            rs.close();
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            return id;
        }
        return id;
    }

    public static boolean altaMar(MARCA marca) {
        try {
            CallableStatement alta_marc_rutina = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL ALTA_MARCA(?)");
            alta_marc_rutina.setString("nomb", marca.getNombre());
            if (!alta_marc_rutina.execute()) {
                System.out.println("GUARDADO");
                return true;
            } else {
                System.out.println("NO GUARDADO");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean modificarMarca(String nomActual, String nomFut) {
        try {            
            CallableStatement mod_rub_rutina = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL MODIFICAR_MARCA(?,?)");
            mod_rub_rutina.setString("nombA", nomActual);
            mod_rub_rutina.setString("nombF", nomFut);                                   
            if (!mod_rub_rutina.execute()) {
                System.out.println("Actualizado");
                return true;
            } else {
                System.out.println("NO actualizado");
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    //==========Recupera todos los productos a eliminar
    public static ModeloTabla recuperarDatos(String nombre, ModeloTabla modelo) {
        ResultSet rs = consulta("vieweliminar");
        try {
            Object[] filas = new Object[2];
            while (rs.next()) {
                if (nombre.equals(rs.getString("marca"))) {
                    filas[0] = rs.getString("CUP");//rs.getString("CUP");
                    String desc = rs.getString("marca") + " " + rs.getString("descripcion");
                    filas[1] = desc;
                    modelo.addRow(filas);
                }
            }
            rs.close();
            return modelo;
        } catch (SQLException e) {
            return modelo;
        }
    }
    
    //============Eliminar marca==========
    public static boolean eliminarMarca(Integer codMarca){
        try {
            CallableStatement eliminar_rubro_rutina = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL ELIMINAR_MARCA(?)");
            eliminar_rubro_rutina.setInt("cod", codMarca);
            eliminar_rubro_rutina.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PRODUCTO");
            return false;
        }
    }
}
