/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaz;

import vista.CONTROLADOR_V;

/**
 *
 * @author vicente-ub1204
 */
public class SeleccionGestionProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form SeleccionGestionProducto
     */
    public SeleccionGestionProducto() {
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
        btnModProd = new javax.swing.JButton();
        btnElimProd = new javax.swing.JButton();

        setTitle("Seleccionar la Gestion a Realizar");

        btnModProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/update product 63x63.png"))); // NOI18N
        btnModProd.setText("Modificar Producto");
        btnModProd.setToolTipText("Modificar Producto");
        btnModProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModProdActionPerformed(evt);
            }
        });

        btnElimProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnElimProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/delete product 63x63.png"))); // NOI18N
        btnElimProd.setText("Eliminar Producto");
        btnElimProd.setToolTipText("Eliminar Producto");
        btnElimProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnElimProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnElimProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnModProd, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnElimProd, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnElimProd, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModProd, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModProdActionPerformed
        CONTROLADOR_V.iniciaBuscarGestion("modificarProducto");
    }//GEN-LAST:event_btnModProdActionPerformed

    private void btnElimProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimProdActionPerformed
        CONTROLADOR_V.iniciaBuscarGestion("eliminarProducto");
    }//GEN-LAST:event_btnElimProdActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElimProd;
    private javax.swing.JButton btnModProd;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}