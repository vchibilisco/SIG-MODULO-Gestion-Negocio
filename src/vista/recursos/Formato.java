/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.recursos;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

/**
 *
 * @author vicente
 */
public class Formato {

    //completa con 0 a la izquierda
    public static Formatter numFact(Integer num) {
        Formatter fmt = new Formatter();
        fmt.format("%010d", num);
        return fmt;
    }

    //limita los decimales a 2 despues d la coma
    public static DecimalFormat precio() {
        DecimalFormatSymbols simb = new DecimalFormatSymbols();
        simb.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#######.##", simb);
        return df;
    }

    public static DecimalFormat validarFloat() {
        DecimalFormatSymbols simb = new DecimalFormatSymbols();
        simb.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#######.##", simb);
        return df;
    }
    //hace un cambio de caracter solamente para mostrar el precio de forma entendible para el usuario

    public static DecimalFormat cambioCarater() {
        //DecimalFormatSymbols simb = new DecimalFormatSymbols();
        //simb.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###,###.##");
        return df;
    }

    public static String getFechaActual(Date fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(fecha);
    }
}
