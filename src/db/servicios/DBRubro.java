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
import modelo.dominio.RUBRO;
import vista.recursos.ModeloTabla;

/**
 *
 * @author vicente
 */
public class DBRubro extends Entidad {

    private static String query;
    //Consultas
    //Recupera todos los nombres de la tabla RUBRO

    public static void recupNombresRubro(JComboBox lista) {
        ResultSet rs = consultaDes("rubro", "nombre");
        try {
            while (rs.next()) {
                if (rs.getString("eliminar").equals(String.valueOf(1))) {
                    lista.addItem(rs.getString("nombre"));
                }
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    //=====Recupera codigo de rubro======
    public static Integer idRubro(String nombre) {
        ResultSet rs = consulta("rubro");
        Integer id = null;
        try {
            while (rs.next()) {
                if (nombre.equals(rs.getString("nombre"))) {
                    id = Integer.parseInt(rs.getString("idRUBRO"));
                }
            }
            rs.close();
        } catch (SQLException | NumberFormatException e) {
            return null;
        }
        return id;
    }

    //=============Asigna codigo al rubro nuevo=========
    public static Integer recupCodigoRubroProximo() {
        ResultSet rs = consulta("rubro");
        Integer id;
        try {
            if (rs.next() != false) {
                rs.last();
                id = Integer.parseInt(rs.getString("idRUBRO"));
                id = id + 1000;
                rs.close();
                return id;
            } else {
                id = 1000;
                rs.close();
                return id;
            }
        } catch (SQLException | NumberFormatException e) {
            return null;
        }
    }

    //=========Alta de rubro =============
    public static boolean altaRub(RUBRO rubro) {
        try {
            boolean bandera = false;
            seleccionarTablaBD("rubro");
            CallableStatement alta_rubro_rutina = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL ALTA_RUBRO(?,?,?,?)");
            alta_rubro_rutina.setInt("cod", rubro.getId_Rubro());
            alta_rubro_rutina.setString("nomb", rubro.getNombre());
            alta_rubro_rutina.setInt("elim", 1);
            alta_rubro_rutina.setBoolean("bandera", Boolean.parseBoolean(String.valueOf(Types.BOOLEAN)));
            alta_rubro_rutina.execute();
            bandera = alta_rubro_rutina.getBoolean("bandera");
            if (bandera) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //===========Modificar Rubro===========
    public static boolean modificarRubro(String nomActual, String nomFut) {
        try {
            boolean bandera = false;
            CallableStatement mod_rub_rutina = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL MODIFICAR_RUBRO(?,?,?)");
            mod_rub_rutina.setString("nombA", nomActual);
            mod_rub_rutina.setString("nombF", nomFut);
            mod_rub_rutina.setBoolean("bandera", Boolean.valueOf(String.valueOf(Types.BOOLEAN)));
            mod_rub_rutina.execute();
            bandera = mod_rub_rutina.getBoolean("bandera");
            if (bandera) {
                System.out.println("Actualizado");
                return true;
            } else {
                System.out.println("NO actualizado");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    //===========Eliminar rubro=========
    public static boolean eliminarRubro(Integer codRurbo) {
        try {
            CallableStatement eliminar_rubro_rutina = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL ELIMINAR_RUBRO(?)");
            eliminar_rubro_rutina.setInt("cod", codRurbo);
            eliminar_rubro_rutina.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PRODUCTO");
            return false;
        }
    }

    //===========Recupera todos los productos a eliminar===============
    public static ModeloTabla recuperarDatos(String nombre, ModeloTabla modelo) {
        ResultSet rs = consulta("vieweliminar");
        try {
            Object[] filas = new Object[2];
            while (rs.next()) {
                if (nombre.equals(rs.getString("rubro"))) {
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
}
