/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author vicente
 */
public class DBUnidad extends Entidad {

    public static void recupNombresUnidad(JComboBox lista) {
        ResultSet rs = consulta("unidad");
        try {
            while (rs.next()) {
                lista.addItem(rs.getString("nombre"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static Integer idUnidad(String nombre) {
        Integer id = 0;
        try {
            ResultSet rs = consulta("unidad");
            while (rs.next()) {
                if (nombre.equals(rs.getString("nombre"))) {
                    id = Integer.parseInt(rs.getString("idUNIDAD"));
                }
            }
            rs.close();
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            return id;
        }
        return id;
    }
}
