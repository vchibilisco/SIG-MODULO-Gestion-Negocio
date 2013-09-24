/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaz.ABM;

import java.awt.Frame;
import java.awt.HeadlessException;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import vista.CONTROLADOR_V;
import vista.recursos.Validacion;

/**
 *
 * @author vicente
 */
public class AltaProducto extends JDialog {

    private boolean bandera;

    /**
     * Creates new form AltaProducto
     */
    public AltaProducto(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        CONTROLADOR_V.recupNombresRubros(this.listaRubro);
        CONTROLADOR_V.recupNombresMarca(this.listaMarca);
        CONTROLADOR_V.recupNombresUnidad(this.listaUnidad);
        CONTROLADOR_V.recupNombresProveedor(this.listaProveedor);
        txtCUP.setText("");
    }

    public JComboBox getListaRubro() {
        return listaRubro;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etqCUP = new javax.swing.JLabel();
        etqMarca = new javax.swing.JLabel();
        listaMarca = new javax.swing.JComboBox();
        btnAgMarca = new javax.swing.JButton();
        etqDesc = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        etqRubro = new javax.swing.JLabel();
        listaRubro = new javax.swing.JComboBox();
        btnAgRubro = new javax.swing.JButton();
        etqCapVol = new javax.swing.JLabel();
        txtCapVol = new javax.swing.JTextField();
        etqUnidad = new javax.swing.JLabel();
        listaUnidad = new javax.swing.JComboBox();
        etqPreUnit = new javax.swing.JLabel();
        txtPreUnit = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        txtCUP = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        listaProveedor = new javax.swing.JComboBox();

        setTitle("Alta de Producto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        etqCUP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etqCUP.setText("CUP previsto:");

        etqMarca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etqMarca.setText("Seleccione la Marca:");

        listaMarca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listaMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Seleccione una Marca"}));

        btnAgMarca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgMarca.setText("Agregar Marca");
        btnAgMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgMarcaActionPerformed(evt);
            }
        });

        etqDesc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etqDesc.setText("Ingrese la descripción:");

        txtDesc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        etqRubro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etqRubro.setText("Seleccione el Rubro:");

        listaRubro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listaRubro.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Seleccione un Rubro"}));
        listaRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaRubroActionPerformed(evt);
            }
        });

        btnAgRubro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgRubro.setText("Agregar Rubro");
        btnAgRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgRubroActionPerformed(evt);
            }
        });

        etqCapVol.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etqCapVol.setText("Ingrese capacidad/volumen:");

        txtCapVol.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        etqUnidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etqUnidad.setText("Unidad:");

        listaUnidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listaUnidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Seleccione una Unidad"}));
        listaUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaUnidadActionPerformed(evt);
            }
        });

        etqPreUnit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etqPreUnit.setText("Ingrese el Precio Unitario:");

        txtPreUnit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnCerrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/Cancel.png"))); // NOI18N
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/Save.png"))); // NOI18N
        btnAgregar.setToolTipText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtCUP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCUP.setText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione el Proveedor:");

        listaProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etqMarca)
                        .addGap(18, 18, 18)
                        .addComponent(listaMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgMarca)
                        .addGap(96, 96, 96))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqRubro)
                            .addComponent(etqCUP))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCUP)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(listaRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAgRubro)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCerrar)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqCapVol)
                            .addComponent(etqDesc)
                            .addComponent(etqPreUnit)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPreUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(listaProveedor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCapVol, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(etqUnidad)
                                        .addGap(18, 18, 18)
                                        .addComponent(listaUnidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqRubro)
                    .addComponent(listaRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgRubro))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqCUP)
                    .addComponent(txtCUP))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqMarca)
                    .addComponent(listaMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgMarca))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqDesc)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqCapVol)
                    .addComponent(txtCapVol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqUnidad)
                    .addComponent(listaUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPreUnit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqPreUnit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(listaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnCerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaRubroActionPerformed
        Integer id = CONTROLADOR_V.recupCodigoProducto((String) listaRubro.getSelectedItem());
        if (id != null) {
            txtCUP.setText(String.valueOf(id));
        } else {
            txtCUP.setText("");
        }
    }//GEN-LAST:event_listaRubroActionPerformed

    private void btnAgRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgRubroActionPerformed
        CONTROLADOR_V.iniciaAltaRubro();
    }//GEN-LAST:event_btnAgRubroActionPerformed

    private void btnAgMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgMarcaActionPerformed
        try {
            String marca = (String) JOptionPane.showInputDialog(null, "Ingrese una nueva Marca: ", "Alta de Marca", JOptionPane.INFORMATION_MESSAGE);
            if (!marca.equals("")) {
                marca = marca.toUpperCase();
//                if (Validacion.validarString(marca)) {
                    bandera = CONTROLADOR_V.getContro_m().altaMarca(marca);
                    if (bandera == true) {
                        listaMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccione una Marca"}));
                        CONTROLADOR_V.recupNombresMarca(listaMarca);
                        JOptionPane.showMessageDialog(null, "Se guardo la nueva Marca", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                        CONTROLADOR_V.mensaje("Marca guardad");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo guardar la nueva Marca", "Error", JOptionPane.ERROR_MESSAGE);
                        CONTROLADOR_V.mensaje("No se guardo la nueva Marca");
                    }
//                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ingreso ninguna Marca.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnAgMarcaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (!listaRubro.getSelectedItem().equals("Seleccione un Rubro")) {
            if (!listaMarca.getSelectedItem().equals("Seleccione una Marca")) {
                if (!this.txtDesc.getText().equals("")) {
                    if (!listaUnidad.getSelectedItem().equals("Seleccione una Unidad")) {
                        if (Validacion.validacionFloat(txtCapVol.getText()) || txtCapVol.getText().equals("")) {
                            if (!txtPreUnit.getText().equals("")) {
                                this.txtPreUnit.setText(this.txtPreUnit.getText().replace(",", "."));
                                if (Validacion.validacionFloat(txtPreUnit.getText())) {
                                    if (!txtCapVol.getText().equals("")) {
                                        this.txtCapVol.setText(this.txtCapVol.getText().replace(",", "."));
                                        if (Validacion.validacionFloat(this.txtCapVol.getText())) {
                                            this.agregar(Float.parseFloat(this.txtCapVol.getText()));
                                            this.limpiar();
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Por favor verifique el valos ingresado. La forma correcta es ej: 34.55", "Error", JOptionPane.ERROR_MESSAGE);
                                            this.txtCapVol.requestFocus();
                                            this.txtCapVol.selectAll();
                                        }
                                    } else {
                                        agregar(Float.parseFloat("0.00"));
                                        this.limpiar();
                                    }
                                } else {
                                    this.txtPreUnit.requestFocus();
                                    this.txtPreUnit.selectAll();
                                    JOptionPane.showMessageDialog(null, "Por favor verifique los datos ingresados.\nEjs: 234.23, 23416",
                                            "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                this.txtPreUnit.requestFocus();
                                this.txtPreUnit.selectAll();
                                JOptionPane.showMessageDialog(null, "Por favor complete los campos faltantes.",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            this.txtCapVol.requestFocus();
                            this.txtCapVol.selectAll();
                            JOptionPane.showMessageDialog(null, "Por favor verifique el dato ingresado.\nEjs: 234.23, 23416",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor seleccione una Unidad.\nSi el Producto no lleva unidad, seleccione 'No posee'", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    this.txtDesc.requestFocus();
                    this.txtDesc.selectAll();
                    JOptionPane.showMessageDialog(null, "Por favor este campo no debe estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor seleccione una Marca o agregue una Marca nueva.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un Rubro o agregue un Rubro nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        formWindowClosing(null);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void listaUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaUnidadActionPerformed
        String opcion = (String) this.listaUnidad.getSelectedItem();
        if (opcion.equals("No posee")) {
            this.txtCapVol.setEditable(false);
        } else {
            this.txtCapVol.setEditable(true);
        }
    }//GEN-LAST:event_listaUnidadActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int op = JOptionPane.showConfirmDialog(this, "¿Desea cerrar la ventana de Alta?.\n"
                + "Perdera los datos cargados", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void agregar(Float capVol) {
        try {
            Integer stockIng = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la cantidad de Stock entrante.", "Informacion", JOptionPane.INFORMATION_MESSAGE));
            Float costoTotal = Float.parseFloat(JOptionPane.showInputDialog(this, "Ingrese el costo total por el Producto adquirido", "Informacion", JOptionPane.INFORMATION_MESSAGE));
            CONTROLADOR_V.ingresaDatosNuevoProducto(this.listaProveedor.getSelectedIndex(), (String) this.listaRubro.getSelectedItem(), Integer.parseInt(this.txtCUP.getText()), (String) this.listaMarca.getSelectedItem(), this.txtDesc.getText().toUpperCase(), capVol, (String) this.listaUnidad.getSelectedItem(), Float.parseFloat(this.txtPreUnit.getText()), stockIng, costoTotal);
            limpiar();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al ingresar los valos de Strock entrante o de costo total, vuelva a ingresarlo por favor.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar() {
        this.listaRubro.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccione un Rubro"}));
        this.listaMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccione una Marca"}));
        this.listaUnidad.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccione una Unidad"}));
        CONTROLADOR_V.recupNombresRubros(this.listaRubro);
        CONTROLADOR_V.recupNombresMarca(this.listaMarca);
        CONTROLADOR_V.recupNombresUnidad(this.listaUnidad);
        txtCUP.setText("");
        txtDesc.setText("");
        txtCapVol.setText("");
        txtPreUnit.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgMarca;
    private javax.swing.JButton btnAgRubro;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel etqCUP;
    private javax.swing.JLabel etqCapVol;
    private javax.swing.JLabel etqDesc;
    private javax.swing.JLabel etqMarca;
    private javax.swing.JLabel etqPreUnit;
    private javax.swing.JLabel etqRubro;
    private javax.swing.JLabel etqUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox listaMarca;
    private javax.swing.JComboBox listaProveedor;
    private javax.swing.JComboBox listaRubro;
    private javax.swing.JComboBox listaUnidad;
    private javax.swing.JLabel txtCUP;
    private javax.swing.JTextField txtCapVol;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtPreUnit;
    // End of variables declaration//GEN-END:variables
}
