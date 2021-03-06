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
public class SeleccionGestionMarca extends javax.swing.JInternalFrame {

    /**
     * Creates new form SeleccionGestionMarca
     */
    public SeleccionGestionMarca() {
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

        jPanel1 = new javax.swing.JPanel();
        btnModMarca = new javax.swing.JButton();
        btnEliMarca = new javax.swing.JButton();

        setTitle("Seleccionar la Gestion a Realizar");
        setPreferredSize(new java.awt.Dimension(439, 233));

        btnModMarca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/update product 63x63.png"))); // NOI18N
        btnModMarca.setText("Modificar Marca");
        btnModMarca.setToolTipText("Modificar Marca");
        btnModMarca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModMarca.setPreferredSize(new java.awt.Dimension(121, 23));
        btnModMarca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModMarcaActionPerformed(evt);
            }
        });

        btnEliMarca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/delete product 63x63.png"))); // NOI18N
        btnEliMarca.setText("Eliminar Marca");
        btnEliMarca.setToolTipText("Eliminar Marca");
        btnEliMarca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliMarca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliMarcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnModMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnModMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModMarcaActionPerformed
        CONTROLADOR_V.iniciaModificarMarca();        
    }//GEN-LAST:event_btnModMarcaActionPerformed

    private void btnEliMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliMarcaActionPerformed
        CONTROLADOR_V.iniciaEliminarMarca();
    }//GEN-LAST:event_btnEliMarcaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliMarca;
    private javax.swing.JButton btnModMarca;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
