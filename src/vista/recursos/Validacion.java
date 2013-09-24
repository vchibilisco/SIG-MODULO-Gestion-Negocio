/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.recursos;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author vicente
 */
public class Validacion {

    public static MaskFormatter mascara() {
        try {
            return new MaskFormatter("###.##");
        } catch (ParseException ex) {
            Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean validacionFloat(String cadFloat) {
        Pattern pattern = Pattern.compile("[0-9]*.[0-9]{2}");
        Matcher matcher = pattern.matcher(cadFloat);
        if (matcher.matches()) {
            return true;
        } else {
            pattern = Pattern.compile("[1-9]*.[0-9]{1}");
            matcher = pattern.matcher(cadFloat);
            if (matcher.matches()) {
                return true;
            } else {
                pattern = Pattern.compile("[1-9]*");
                matcher = pattern.matcher(cadFloat);
                if (matcher.matches()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public static boolean validarString(String cadena) {
        Pattern pattern = Pattern.compile("[A-Z][A-Z]*");
        Matcher matcher = pattern.matcher(cadena);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarNumero(String numero) {
        Pattern pattern = Pattern.compile("[0-9][0-9]*");
        Matcher matcher = pattern.matcher(numero);
        if (!numero.equals("XXXXXXXXXX")) {
            if (matcher.matches()) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public static String[] separaDormicilio(String cad) {
        String replace;
        String sub;

        String[] domicilio = cad.split(":");
        replace = domicilio[1].replace(" %Nro", "");
        sub = replace.substring(1);
        domicilio[1] = sub;

        replace = domicilio[2].replace(" Piso", "");
        sub = replace.substring(1);
        domicilio[2] = sub;

        replace = domicilio[3].replace(" Dpto", "");
        sub = replace.substring(1);
        domicilio[3] = sub;

        sub = domicilio[4].substring(1);
        domicilio[4] = sub;

        return domicilio;
    }
}
