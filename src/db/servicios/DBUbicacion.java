/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;


import db.CONTROLADOR_DB;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author vicenteW7 noteb
 */
public class DBUbicacion extends Entidad {

    public static void recuperarPais(JComboBox listaPais) {
        ResultSet rs = consulta("pais");
        try {
            while (rs.next()) {
                listaPais.addItem(rs.getString("pais"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static ArrayList recuperarProvincia(String pais) {
        ArrayList<String> listaProvincias = new ArrayList<>();
        try {
            ResultSet rs = CONTROLADOR_DB.getConexion().getStatement().executeQuery("select provincia from sig.provincia,sig.pais where pais = '" + pais + "' and PAIS_idPAIS = idPAIS");
            while (rs.next()) {
                String provincia;
                provincia = rs.getString("provincia");
                listaProvincias.add(provincia);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se recupero las Provincias correspondientes al Pais", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return listaProvincias;
    }

    public static ArrayList recuperarLocalidad(String provincia) {
        ArrayList<String> listaLocalidad = new ArrayList<>();
        try {
            ResultSet rs = CONTROLADOR_DB.getConexion().getStatement().executeQuery("select localidad from sig.provincia,sig.localidad where  provincia = '" + provincia + "' and PROVINCIA_idPROVINCIA = idPROVINCIA");
            while (rs.next()) {
                String localidad;
                localidad = rs.getString("localidad");
                listaLocalidad.add(localidad);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se recupero las Provincias correspondientes al Pais", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return listaLocalidad;
    }

    public static ArrayList recuperarCP(String localidad) {
        ArrayList<String> listaCP = new ArrayList<>();
        try {
            ResultSet rs = CONTROLADOR_DB.getConexion().getStatement().executeQuery("select cp from sig.codigo_postal,sig.localidad where  localidad = '" + localidad + "' and LOCALIDAD_idLOCALIDAD = idLOCALIDAD");
            while (rs.next()) {
                String cp;
                localidad = rs.getString("cp");
                listaCP.add(localidad);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se recupero las Provincias correspondientes al Pais", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return listaCP;
    }

    public static void altaPais(String pais) {
        try {
            CallableStatement alta = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL ALTA_PAIS(?)");
            alta.setString("mPais", pais);
            alta.execute();
            System.out.println("Se realizo el Alta satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se logro realizar el Alta", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void altaProvincia(String provincia, String pais) {
        try {
            CallableStatement alta = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL ALTA_PROVINCIA(?,?)");
            alta.setString("mProvincia", provincia);
            alta.setString("mPais", pais);
            alta.execute();
            System.out.println("Se realizo el Alta satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se logro realizar el Alta", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void altaLocalidad(String localidad, String provincia) {
        try {
            CallableStatement alta = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL ALTA_LOCALIDAD(?,?)");
            alta.setString("mLocalidad", localidad);
            alta.setString("mProvincia", provincia);
            alta.execute();
            System.out.println("Se realizo el Alta satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se logro realizar el Alta", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void altaCP(Integer cp, String localidad) {
        try {
            CallableStatement alta = (CallableStatement) CONTROLADOR_DB.getConexion().getConexion().prepareCall("CALL ALTA_CP(?,?)");
            alta.setInt("mCP", cp);
            alta.setString("mLocalidad", localidad);
            alta.execute();
            System.out.println("Se realizo el Alta satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se logro realizar el Alta", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
