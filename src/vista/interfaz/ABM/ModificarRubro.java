/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaz.ABM;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import vista.CONTROLADOR_V;

/**
 *
 * @author vicente
 */
public class ModificarRubro extends javax.swing.JDialog {

    private boolean bandera;

    /**
     * Creates new form ModificarRubro
     */
    public ModificarRubro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        CONTROLADOR_V.recupNombresRubros(this.listaRubro);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        listaRubro = new javax.swing.JComboBox();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setTitle("Modicar Rubro");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        listaRubro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listaRubro.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Seleccione un Rubro"}));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Ingrese nuevo Nombre:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Seleccione Rubro:");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/Save.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/Cancel.png"))); // NOI18N
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(btnGuardar)
                        .addGap(28, 28, 28)
                        .addComponent(btnCerrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listaRubro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(listaRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar)
                    .addComponent(btnGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        formWindowClosing(null);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        actualizar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            actualizar();
        }
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int op = JOptionPane.showConfirmDialog(this, "¿Desea cerrar la ventana de Modificar?.\n"
                + "Perdera los datos cargados", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void actualizar() {
        String nombre = this.txtNombre.getText().toUpperCase();
        if (!listaRubro.getSelectedItem().equals("Seleccione un Rubro")) {
            if (!txtNombre.getText().equals((String) listaRubro.getSelectedItem()) || !txtNombre.getText().equals("")) {
                if (txtNombre.getText().length() <= 120) {
                    txtNombre.setText(nombre);
                    Pattern pattern = Pattern.compile("[A-Z]*");
                    Matcher matcher = pattern.matcher(nombre);
                    if (matcher.matches()) {
                        bandera = CONTROLADOR_V.getContro_m().modificarRubro((String) this.listaRubro.getSelectedItem(), this.txtNombre.getText());
                        if (bandera == true) {
                            JOptionPane.showMessageDialog(this, "Rubro: " + listaRubro.getSelectedItem() + " actualizado a " + txtNombre.getText(), "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                            CONTROLADOR_V.mensaje("Rubro: " + listaRubro.getSelectedItem() + " actualizado a " + txtNombre.getText());
                            limpiar();
                        } else {
                            JOptionPane.showMessageDialog(this, "Rubro: " + txtNombre.getText() + " no se actualizo."
                                    + "             \nVerifique que no exista el Rubro que desea ingresar.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                            CONTROLADOR_V.mensaje("Rubro: " + txtNombre.getText() + " no se actualizo");
                            this.txtNombre.selectAll();
                            this.txtNombre.requestFocus();
                        }
                    } else {
                        txtNombre.requestFocus();
                        txtNombre.selectAll();
                        JOptionPane.showMessageDialog(null, "Este campo solo admite letras. \nPor favor verifique.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    txtNombre.requestFocus();
                    txtNombre.selectAll();
                    JOptionPane.showMessageDialog(null, "Este campo no debe superar los 120 caracteres. \nPor favor verifique.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                txtNombre.requestFocus();
                txtNombre.selectAll();
                JOptionPane.showMessageDialog(null, "Por favor complete los campos faltantes o verifique no estar ingresando"
                        + "                     \nel mismo nombre del Rubro que desea cambiar. "
                        + "                     \nPor favor verifique.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un Rubro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar() {
        listaRubro.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccione un Rubro"}));
        CONTROLADOR_V.recupNombresRubros(listaRubro);
        txtNombre.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox listaRubro;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
