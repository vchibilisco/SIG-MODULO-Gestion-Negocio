package vista.interfaz.ABM;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import vista.CONTROLADOR_V;
import vista.recursos.ModeloTabla;

public class BuscaGest extends javax.swing.JDialog {

    private int returnStatus;
    private DefaultTableModel modelo = new ModeloTabla();
    private JTable tablaDatos = new JTable();
    private TableRowSorter filtroDatos;
    private String tipoGestion;

    public BuscaGest(java.awt.Frame parent, boolean modal, String tGestion) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.tipoGestion = tGestion;
        switch (tipoGestion) {
            case "modificarProducto":
                this.btnModElim.setToolTipText("Modificar");
                this.btnModElim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/Update.png")));
                cargarTabla();
                break;
            case "eliminarProducto":
                this.btnModElim.setToolTipText("Eliminar");
                this.btnModElim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/Minus.png")));
                cargarTabla();
                break;
            case "proveedorModificar":
                this.btnModElim.setToolTipText("Modificar");
                this.btnModElim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/Update.png")));
                this.etqBuscar.setText("Buscar Proveedor");
                cargarTabla();
                break;
            case "clienteModificar":
                this.btnModElim.setToolTipText("Modificar");
                this.btnModElim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/Update.png")));
                this.etqBuscar.setText("Buscar Cliente");
                cargarTabla();
                break;
            case "clienteEliminar":
                this.btnModElim.setToolTipText("Eliminar");
                //this.btnModElim.setIcon(new javax.swing.ImageIcon());
                cargarTabla();
                break;
        }
        filtroDatos = new TableRowSorter(tablaDatos.getModel());//Filtrado
        tablaDatos.setRowSorter(filtroDatos);
        tablaDatos.getTableHeader().setReorderingAllowed(false);
        tablaDatos.getTableHeader().setResizingAllowed(false);
    }

    public int getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(int returnStatus) {
        this.returnStatus = returnStatus;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(ModeloTabla modelo) {
        this.modelo = modelo;
    }

    public JTable getTablaDatos() {
        return tablaDatos;
    }

    public void setTablaDatos(JTable tablaDatos) {
        this.tablaDatos = tablaDatos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnModElim = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane(tablaDatos);
        etqBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busqueda");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnModElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModElimActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/Cancel.png"))); // NOI18N
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        etqBuscar.setText("Buscar Producto:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
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
                        .addComponent(etqBuscar)
                        .addGap(20, 20, 20)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 158, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnModElim)
                                .addGap(18, 18, 18)
                                .addComponent(btnCerrar)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqBuscar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnModElim))
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

    //evento de boton cerrar
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    //Evento de boton agregar
    private void btnModElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModElimActionPerformed
        try {
            if (this.tablaDatos.getRowCount() != 0) {
                int indextabla = tablaDatos.getSelectedRow();                
                if (indextabla > -1) {
                    try {
                        int idx = tablaDatos.convertRowIndexToModel(indextabla);                        
                        String id = modelo.getValueAt(idx, 0).toString();
                        switch (this.tipoGestion) {
                            case "modificarProducto":
                                CONTROLADOR_V.iniciaModificarProducto(Integer.parseInt(id));
                                break;
                            case "eliminarProducto":
                                CONTROLADOR_V.iniciaEliminarProducto(Integer.parseInt(id));
                                break;
                            case "proveedorModificar":
                                CONTROLADOR_V.iniciaModificarProveedor(id);
                                break;
                            case "clienteModificar":
                                CONTROLADOR_V.iniciaModificarCliente(id);
                                break;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Seleccione un registro", "ERROR", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "MAL");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No existe ningun Producto almacenado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un registro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModElimActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        filtro(0);
    }//GEN-LAST:event_txtBuscarKeyPressed
    //Grupo de botones que filtra la tabla
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnModElim;
    private javax.swing.JLabel etqBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    //Metodo que carga Tabla
    public void cargarTabla() {
        switch (this.tipoGestion) {
            case "modificarProducto":
                CONTROLADOR_V.completarTablaBuscar(modelo, "Producto");
                break;
            case "eliminarProducto":
                CONTROLADOR_V.completarTablaBuscar(modelo, "Producto");
                break;
            case "proveedorModificar":
                CONTROLADOR_V.completarTablaBuscar(modelo, "Proveedor");
                break;
            case "clienteModificar":
                CONTROLADOR_V.completarTablaBuscar(modelo, "Cliente");
                break;
            case "clienteEliminar":
                CONTROLADOR_V.completarTablaBuscar(modelo, "Cliente");
                break;
        }
        tablaDatos.setModel(modelo);
//        TableColumn columCodigo = tablaDatos.getColumn("Codigo");
//        columCodigo.setMinWidth(60);
//        columCodigo.setMaxWidth(60);
//        TableColumn columDesc = tablaDatos.getColumn("Descripcion/Producto");
//        columDesc.setMinWidth(370);
//        columDesc.setMaxWidth(370);
    }

    //Metodo que filtra
    private void filtro(int colum) {
        filtroDatos.setRowFilter(RowFilter.regexFilter(txtBuscar.getText().toUpperCase(), colum));
    }
}
