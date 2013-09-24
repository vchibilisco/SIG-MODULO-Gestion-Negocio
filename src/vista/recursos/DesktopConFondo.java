/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.recursos;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author vicenteW7 noteb
 */
public class DesktopConFondo extends JDesktopPane {

    private Image imagen = new ImageIcon(getClass().getResource("../imagen/cygni.jpg")).getImage();

    @Override
    public void paintChildren(Graphics g) {
        if (this.imagen != null) {
            g.drawImage(this.imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
        } else {
            setOpaque(true);
        }
        super.paintChildren(g);
    }
}
