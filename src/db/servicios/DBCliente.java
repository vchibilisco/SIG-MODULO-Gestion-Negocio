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
import javax.swing.JOptionPane;
import modelo.dominio.CLIENTE;
import modelo.dominio.UBICACION;

/**
 *
 * @author vicente-dell
 */
public class DBCliente extends Entidad {

    private static ArrayList<CLIENTE> listaCliente;

    public static boolean verficiarCUIT(CLIENTE cliente) {
        try {
            ResultSet rs = CONTROLADOR_DB.getConexion().getStatement().executeQuery("SELECT CUIT FROM cliente WHERE cuit = " + quotate(cliente.getCuit()));
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

    public static boolean altaCliente(CLIENTE cliente) {
        try {
            CallableStatement altaCliente = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL ALTA_CLIENTE(?,?,?,?,?,?)");
            altaCliente.setString("razonSocial", cliente.getRazonSocial());
            altaCliente.setString("cuit", cliente.getCuit());
            altaCliente.setString("domicilio", cliente.getDomicilio());
            altaCliente.setString("telefono", cliente.getTelefono());
            altaCliente.setString("rs", cliente.getRs());
            altaCliente.setInt("cp", cliente.getUbicacion().getCP());
            if (!altaCliente.execute()) {                
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar al cliente:\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    public static boolean modificarCliente(CLIENTE cliente) {
        try {
            CallableStatement modCliente = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL MODIFICAR_CLIENTE(?,?,?,?,?,?)");
            modCliente.setString("razonSocial", cliente.getRazonSocial());
            modCliente.setString("mCuit", cliente.getCuit());
            modCliente.setString("mDomicilio", cliente.getDomicilio());
            modCliente.setString("mTelefono", cliente.getTelefono());
            modCliente.setString("rs", cliente.getRs());
            modCliente.setInt("cp", cliente.getUbicacion().getCP());
            if (!modCliente.execute()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se modifico el cliente:\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<CLIENTE> recuperarListaCliente() {
        try {
            listaCliente = new ArrayList<>();
            ResultSet rs = consulta("viewcliente");
            while (rs.next()) {
                CLIENTE cliente = new CLIENTE();
                cliente.setCuit(rs.getString("CUIT"));
                cliente.setRazonSocial(rs.getString("razon_social"));
                cliente.setRs(rs.getString("tipo_rs"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setUbicacion(new UBICACION());
                cliente.getUbicacion().setCP(rs.getInt("cp"));
                cliente.getUbicacion().setLocalidad(rs.getString("localidad"));
                cliente.getUbicacion().setProvincia(rs.getString("provincia"));
                cliente.getUbicacion().setPais(rs.getString("pais"));
                listaCliente.add(cliente);
            }
            return listaCliente;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return listaCliente;
        }
    }
}
