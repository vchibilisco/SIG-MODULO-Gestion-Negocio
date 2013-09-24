/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import com.mysql.jdbc.CallableStatement;
import db.CONTROLADOR_DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.dominio.PROVEEDOR;
import modelo.dominio.UBICACION;

/**
 *
 * @author vicente-dell
 */
public class DBProveedor extends Entidad {

    public static boolean verficiarCUIT(PROVEEDOR proveedor) {
        try {
            ResultSet rs = CONTROLADOR_DB.getConexion().getStatement().executeQuery("SELECT CUIT FROM proveedor WHERE cuit = " + quotate(proveedor.getCuit()));
            if (rs.next()) {
                rs.close();
                JOptionPane.showMessageDialog(null, "El CUIT ingresado ya existe", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            rs.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void recuperarTipoRS(JComboBox listRS) {
        ResultSet rs = consulta("tipo_rs");
        try {
            while (rs.next()) {
                listRS.addItem(rs.getString("tipo_rs"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static boolean altaProveedor(PROVEEDOR proveedor) {
        try {
            CallableStatement altaProveedor = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL ALTA_PROVEEDOR(?,?,?,?,?,?,?,?)");
            altaProveedor.setString("razonSocial", proveedor.getRazonSocial());
            altaProveedor.setString("cuit", proveedor.getCuit());
            altaProveedor.setString("domicilio", proveedor.getDomicilio());
            altaProveedor.setString("telefono", proveedor.getTelefono());
            altaProveedor.setString("contacto", proveedor.getContacto());
            altaProveedor.setString("observacion", proveedor.getObservacion());
            altaProveedor.setString("rs", proveedor.getRs());
            altaProveedor.setInt("cp", proveedor.getUbicacion().getCP());
            if (!altaProveedor.execute()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar al proveedor:\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    public static boolean modificarProveedor(PROVEEDOR proveedor) {
        try {
            CallableStatement modProveedor = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL MODIFICAR_PROVEEDOR(?,?,?,?,?,?,?,?)");
            modProveedor.setString("razonSocial", proveedor.getRazonSocial());
            modProveedor.setString("mCuit", proveedor.getCuit());
            modProveedor.setString("mDomicilio", proveedor.getDomicilio());
            modProveedor.setString("mTelefono", proveedor.getTelefono());
            modProveedor.setString("mContacto", proveedor.getContacto());
            modProveedor.setString("mObservacion", proveedor.getObservacion());
            modProveedor.setString("rs", proveedor.getRs());
            modProveedor.setInt("cp", proveedor.getUbicacion().getCP());
            if (!modProveedor.execute()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se actualizo el proveedor:\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<PROVEEDOR> recuperarListaProveedor() {
        ArrayList<PROVEEDOR> listaProveedor = new ArrayList<>();
        ResultSet rs = consulta("viewproveedor");
        try {
            while (rs.next()) {
                PROVEEDOR proveedor = new PROVEEDOR();
                proveedor.setCuit(rs.getString("CUIT"));
                proveedor.setRazonSocial(rs.getString("razon_social"));
                proveedor.setRs(rs.getString("tipo_rs"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setContacto(rs.getString("contacto"));
                proveedor.setObservacion(rs.getString("observacion"));
                proveedor.setUbicacion(new UBICACION(rs.getInt("cp"), rs.getString("localidad"), rs.getString("provincia"), rs.getString("pais")));
                listaProveedor.add(proveedor);
            }
            return listaProveedor;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return listaProveedor;
        }
    }
}
