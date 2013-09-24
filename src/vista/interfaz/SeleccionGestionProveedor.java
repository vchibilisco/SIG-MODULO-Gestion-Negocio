/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaz;

import vista.CONTROLADOR_V;

/**
 *
 * @author vicente-dell
 */
public class SeleccionGestionProveedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form SeleccionGestionProveedor
     */
    public SeleccionGestionProveedor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAltaProv = new javax.swing.JButton();
        btnModProv = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setTitle("Seleccionar la Gestion a Realizar");

        btnAltaProv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAltaProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/add provider 64x64.png"))); // NOI18N
        btnAltaProv.setText("Alta Proveedor");
        btnAltaProv.setToolTipText("Alta Proveedor");
        btnAltaProv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAltaProv.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAltaProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaProvActionPerformed(evt);
            }
        });

        btnModProv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/update provider 64x64.png"))); // NOI18N
        btnModProv.setText("Modificar Proveedor");
        btnModProv.setToolTipText("Modificar Proveedor");
        btnModProv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModProv.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModProvActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAltaProv, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModProv, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAltaProv, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addComponent(btnModProv, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaProvActionPerformed
        CONTROLADOR_V.iniciaAltaProveedor();
    }//GEN-LAST:event_btnAltaProvActionPerformed

    private void btnModProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModProvActionPerformed
        CONTROLADOR_V.iniciaBuscarGestion("proveedorModificar");
    }//GEN-LAST:event_btnModProvActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaProv;
    private javax.swing.JButton btnModProv;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}