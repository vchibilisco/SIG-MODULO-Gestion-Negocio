/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CONTROLADOR_M;
import modelo.dominio.CLIENTE;
import modelo.dominio.LINEA_COMPRA;
import modelo.dominio.PRODUCTO;
import modelo.dominio.PROVEEDOR;
import vista.interfaz.ABM.AMCliente;
import vista.interfaz.ABM.AMProveedor;
import vista.interfaz.ABM.AltaProducto;
import vista.interfaz.ABM.AltaRubro;
import vista.interfaz.ABM.AltaStock;
import vista.interfaz.ABM.BuscaGest;
import vista.interfaz.ABM.EliminarMarca;
import vista.interfaz.ABM.EliminarProducto;
import vista.interfaz.ABM.EliminarRubro;
import vista.interfaz.ABM.ModificarMarca;
import vista.interfaz.ABM.ModificarProducto;
import vista.interfaz.ABM.ModificarRubro;
import vista.interfaz.Busca;
import vista.interfaz.Principal;
import vista.interfaz.SeleccionGestionCliente;
import vista.interfaz.SeleccionGestionMarca;
import vista.interfaz.SeleccionGestionProducto;
import vista.interfaz.SeleccionGestionProveedor;
import vista.interfaz.SeleccionGestionRubro;
import vista.interfaz.logeo.Logeo;
import vista.recursos.Formato;
import vista.recursos.Validacion;

/**
 *
 * @author vicente
 */
public class CONTROLADOR_V {

    private static Principal principal;
    private static AltaStock altaStock;
    private static BuscaGest buscarGestion;
    private static SeleccionGestionProducto selGestProd;
    private static SeleccionGestionRubro selGestRub;
    private static SeleccionGestionMarca selGestMar;
    private static SeleccionGestionCliente selGestCli;
    private static SeleccionGestionProveedor selGestProv;
    private static AltaProducto altaProd;
    private static ModificarProducto modProducto;
    private static EliminarProducto elimProducto;
    private static AltaRubro altaRubro;
    private static ModificarRubro modRubro;
    private static EliminarRubro elimRubro;
    private static ModificarMarca modMarca;
    private static EliminarMarca elimMarca;
    private static AMProveedor altProveedor;
    private static AMCliente altCliente;
    private static CONTROLADOR_M contro_m;
    private static Busca buscarProd;
    private static Logeo logeo;

    public static Principal getPrincipal() {
        return principal;
    }

    public static AltaStock getAltaStock() {
        return altaStock;
    }

    public static AltaProducto getAltaProd() {
        return altaProd;
    }

    public static BuscaGest getBuscaGestionProducto() {
        return buscarGestion;
    }

    public static CONTROLADOR_M getContro_m() {
        return contro_m;
    }

    public static ModificarProducto getModProducto() {
        return modProducto;
    }

    public static EliminarProducto getElimProducto() {
        return elimProducto;
    }
    //logeo

    public static void iniciarApp() {
        CONTROLADOR_V.logeo = new Logeo();
        CONTROLADOR_V.logeo.setVisible(true);
    }

    //===========Inicia ventana principal============    
    public static void iniciaPrincipal(String user, String pass) {
        CONTROLADOR_V.contro_m = new CONTROLADOR_M();
        if (CONTROLADOR_V.contro_m.conectar(user, pass)) {
            CONTROLADOR_V.logeo.dispose();
            CONTROLADOR_V.principal = new Principal();
            CONTROLADOR_V.principal.setTitle(CONTROLADOR_V.principal.getTitle() + " = Sesion abierta por: " + CONTROLADOR_M.getLogeo().getApellido() + " " + CONTROLADOR_M.getLogeo().getNombre());
            CONTROLADOR_V.principal.setVisible(true);
        } else {
            CONTROLADOR_V.logeo.iniciarComponentes();
        }
    }

    //msj de estado en ventana principal
    public static void mensaje(String msj) {
        CONTROLADOR_V.getPrincipal().mensaje(msj);
    }

    //==========Inicia internalFrame==================
    public static void iniciaAltaStock() {
        if (estacerrado(CONTROLADOR_V.altaStock)) {
            CONTROLADOR_M.iniciaAltaStock();
            CONTROLADOR_V.altaStock = new AltaStock();
            CONTROLADOR_V.getPrincipal().getPanel().add(CONTROLADOR_V.altaStock);
            CONTROLADOR_V.altaStock.setVisible(true);
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension ventana = CONTROLADOR_V.altaStock.getSize();
            CONTROLADOR_V.altaStock.setLocation((pantalla.width - ventana.width) / 2, ((pantalla.height - ventana.height) / 2) - 80);
        }
    }

    public static void iniciaSeleccionGestionProducto() {
        if (estacerrado(CONTROLADOR_V.selGestProd)) {
            CONTROLADOR_V.selGestProd = new SeleccionGestionProducto();
            CONTROLADOR_V.getPrincipal().getPanel().add(CONTROLADOR_V.selGestProd);
            CONTROLADOR_V.selGestProd.setVisible(true);
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension ventana = CONTROLADOR_V.selGestProd.getSize();
            CONTROLADOR_V.selGestProd.setLocation((pantalla.width - ventana.width) / 2, ((pantalla.height - ventana.height) / 2) - 35);
        }
    }

    public static void iniciaSeleccionGestionRubro() {
        if (estacerrado(CONTROLADOR_V.selGestRub)) {
            CONTROLADOR_V.selGestRub = new SeleccionGestionRubro();
            CONTROLADOR_V.getPrincipal().getPanel().add(CONTROLADOR_V.selGestRub);
            CONTROLADOR_V.selGestRub.setVisible(true);
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension ventana = CONTROLADOR_V.selGestRub.getSize();
            CONTROLADOR_V.selGestRub.setLocation((pantalla.width - ventana.width) / 2, ((pantalla.height - ventana.height) / 2) - 35);
        }
    }

    public static void iniciaSeleccionGestionMarca() {
        if (estacerrado(CONTROLADOR_V.selGestMar)) {
            CONTROLADOR_V.selGestMar = new SeleccionGestionMarca();
            CONTROLADOR_V.getPrincipal().getPanel().add(CONTROLADOR_V.selGestMar);
            CONTROLADOR_V.selGestMar.setVisible(true);
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension ventana = CONTROLADOR_V.selGestMar.getSize();
            CONTROLADOR_V.selGestMar.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
        }
    }

    public static void iniciaSeleccionGestionProveedor() {
        if (estacerrado(CONTROLADOR_V.selGestProv)) {
            CONTROLADOR_V.selGestProv = new SeleccionGestionProveedor();
            CONTROLADOR_V.getPrincipal().getPanel().add(CONTROLADOR_V.selGestProv);
            CONTROLADOR_V.selGestProv.setVisible(true);
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension ventana = CONTROLADOR_V.selGestProv.getSize();
            CONTROLADOR_V.selGestProv.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
        }
    }

    public static void iniciaSeleccionGestionCliente() {
        if (estacerrado(CONTROLADOR_V.selGestCli)) {
            CONTROLADOR_V.selGestCli = new SeleccionGestionCliente();
            CONTROLADOR_V.getPrincipal().getPanel().add(CONTROLADOR_V.selGestCli);
            CONTROLADOR_V.selGestCli.setVisible(true);
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension ventana = CONTROLADOR_V.selGestCli.getSize();
            CONTROLADOR_V.selGestCli.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
        }
    }

    //Control de ventanas internas abiertas
    private static boolean estacerrado(Object obj) {
        JInternalFrame[] activos = CONTROLADOR_V.getPrincipal().getPanel().getAllFrames();
        boolean cerrado = true;
        int i = 0;
        while (i < activos.length && cerrado) {
            if (activos[i] == obj) {
                activos[i].setVisible(true);
                cerrado = false;
            } else {
                activos[i].dispose();
            }
            i++;
        }
        return cerrado;
    }
    //==========Fin internalFrame==================

    //==========Inicia dialog===============
    public static void iniciaAltaProducto() {
        CONTROLADOR_V.altaProd = new AltaProducto(CONTROLADOR_V.getPrincipal(), true);
        CONTROLADOR_V.altaProd.setVisible(true);
    }

    public static void iniciaBuscarProducto() {
        CONTROLADOR_V.buscarProd = new Busca(principal, true);
        CONTROLADOR_V.buscarProd.setVisible(true);
    }

    public static void iniciaAltaRubro() {
        CONTROLADOR_V.altaRubro = new AltaRubro(altaProd, true);
        CONTROLADOR_V.altaRubro.setVisible(true);
        if (CONTROLADOR_V.altaRubro.isEstado()) {
            CONTROLADOR_V.getAltaProd().getListaRubro().setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccione un Rubro"}));
            CONTROLADOR_M.recupNombresRubros(CONTROLADOR_V.getAltaProd().getListaRubro());
        }
    }

    public static void iniciaBuscarGestion(String tGestion) {
        CONTROLADOR_V.buscarGestion = new BuscaGest(CONTROLADOR_V.getPrincipal(), true, tGestion);
        CONTROLADOR_V.buscarGestion.setVisible(true);
    }

    public static void iniciaModificarRubro() {
        CONTROLADOR_V.modRubro = new ModificarRubro(CONTROLADOR_V.getPrincipal(), true);
        CONTROLADOR_V.modRubro.setVisible(true);
    }

    public static void iniciaEliminarRubro() {
        CONTROLADOR_V.elimRubro = new EliminarRubro(CONTROLADOR_V.getPrincipal(), true);
        CONTROLADOR_V.elimRubro.setVisible(true);
    }

    public static void cerrarBuscarGestionProducto(String tGestion) {
        switch (tGestion) {
            case "modificarProducto":
                CONTROLADOR_V.getModProducto().dispose();
                break;
            case "eliminarProducto":
                CONTROLADOR_V.getElimProducto().dispose();
                break;
        }
        CONTROLADOR_V.getBuscaGestionProducto().dispose();
        CONTROLADOR_V.iniciaBuscarGestion(tGestion);
    }

    public static void iniciaModificarProducto(Integer cup) {
        for (PRODUCTO producto : CONTROLADOR_M.getListaProductoDB()) {
            System.out.println(producto.getCUP() + " " + cup);
            if (producto.getCUP().equals(cup)) {
                CONTROLADOR_V.modProducto = new ModificarProducto(CONTROLADOR_V.getPrincipal(), true, producto);
                CONTROLADOR_V.modProducto.setVisible(true);
            }
        }
    }

    public static void iniciaEliminarProducto(Integer cup) {
        for (PRODUCTO producto : CONTROLADOR_M.getListaProductoDB()) {
            if (producto.getCUP().equals(cup)) {
                CONTROLADOR_V.elimProducto = new EliminarProducto(CONTROLADOR_V.getPrincipal(), true, producto);
                CONTROLADOR_V.elimProducto.setVisible(true);
            }
        }
    }

    public static void iniciaModificarProveedor(String cuit) {
        for (PROVEEDOR proveedor : CONTROLADOR_M.getListaProveedorDB()) {
            if (proveedor.getCuit().equals(cuit)) {
                CONTROLADOR_V.altProveedor = new AMProveedor(CONTROLADOR_V.principal, true, "Modificar");
                altProveedor.setTitle("Modificar Proveedor");
                altProveedor.getTxtRazonSocial().setText(proveedor.getRazonSocial());
                altProveedor.getListaRazonSocial().setSelectedItem(proveedor.getRs());
                StringTokenizer tokensCuit = new StringTokenizer(proveedor.getCuit(), "-");
                String[] vec1 = new String[3];
                int i = 0;
                while (tokensCuit.hasMoreTokens()) {
                    vec1[i] = tokensCuit.nextToken();
                    i++;
                }
                altProveedor.getTxtPreCuit().setText(vec1[0]);
                altProveedor.getTxtPreCuit().setEditable(false);
                altProveedor.getTxtNumCuit().setText(vec1[1]);
                altProveedor.getTxtNumCuit().setEditable(false);
                altProveedor.getTxtPosCuit().setText(vec1[2]);
                altProveedor.getTxtPosCuit().setEditable(false);
                StringTokenizer tokensTel = new StringTokenizer(proveedor.getTelefono(), "-");
                String[] vec2 = new String[2];
                i = 0;
                while (tokensTel.hasMoreTokens()) {
                    vec2[i] = tokensTel.nextToken();
                    i++;
                }
                altProveedor.getTxtCodArea().setText(vec2[0]);
                altProveedor.getTxtNumTel().setText(vec2[1]);
                altProveedor.getTxtContacto().setText(proveedor.getContacto());
                altProveedor.getTxtObservacion().setText(proveedor.getObservacion());
                altProveedor.getListaPais().setSelectedItem(proveedor.getUbicacion().getPais());
                altProveedor.getListaProvincia().setSelectedItem(proveedor.getUbicacion().getProvincia());
                altProveedor.getListaLocal().setSelectedItem(proveedor.getUbicacion().getLocalidad());
                altProveedor.getListaCP().setSelectedItem(String.valueOf(proveedor.getUbicacion().getCP()));
                String[] vec3 = Validacion.separaDormicilio(proveedor.getDomicilio());
                altProveedor.getTxtCalle().setText(vec3[1]);
                altProveedor.getTxtNumCalle().setText(vec3[2]);
                altProveedor.getTxtPiso().setText(vec3[3]);
                altProveedor.getTxtDep().setText(vec3[4]);
                CONTROLADOR_V.altProveedor.setVisible(true);
            }
        }
    }

    public static void iniciaModificarCliente(String cuit) {
        for (CLIENTE cliente : CONTROLADOR_M.getListaClienteDB()) {
            if (cliente.getCuit().equals(cuit)) {
                CONTROLADOR_V.altCliente = new AMCliente(logeo, true, "Modificar");
                altCliente.setTitle("Modificar Cliente");
                altCliente.getTxtRazonSocial().setText(cliente.getRazonSocial());
                altCliente.getListaRazonSocial().setSelectedItem(cliente.getRs());
                StringTokenizer tokensCuit = new StringTokenizer(cliente.getCuit(), "-");
                String[] vec1 = new String[3];
                int i = 0;
                while (tokensCuit.hasMoreTokens()) {
                    vec1[i] = tokensCuit.nextToken();
                    i++;
                }
                altCliente.getTxtPreCuit().setText(vec1[0]);
                altCliente.getTxtPreCuit().setEditable(false);
                altCliente.getTxtNumCuit().setText(vec1[1]);
                altCliente.getTxtNumCuit().setEditable(false);
                altCliente.getTxtPosCuit().setText(vec1[2]);
                altCliente.getTxtPosCuit().setEditable(false);
                StringTokenizer tokensTel = new StringTokenizer(cliente.getTelefono(), "-");
                String[] vec2 = new String[2];
                i = 0;
                while (tokensTel.hasMoreTokens()) {
                    vec2[i] = tokensTel.nextToken();
                    i++;
                }
                altCliente.getTxtCodArea().setText(vec2[0]);
                altCliente.getTxtNumTel().setText(vec2[1]);
                altCliente.getListaPais().setSelectedItem(cliente.getUbicacion().getPais());
                altCliente.getListaProvincia().setSelectedItem(cliente.getUbicacion().getProvincia());
                altCliente.getListaLocal().setSelectedItem(cliente.getUbicacion().getLocalidad());
                altCliente.getListaCP().setSelectedItem(String.valueOf(cliente.getUbicacion().getCP()));
//                String[] vec3 = Validacion.separaDormicilio(cliente.getDomicilio());
//                altCliente.getTxtCalle().setText(vec3[1]);
//                altCliente.getTxtNumCalle().setText(vec3[2]);
//                altCliente.getTxtPiso().setText(vec3[3]);
//                altCliente.getTxtDep().setText(vec3[4]);
                CONTROLADOR_V.altCliente.setVisible(true);
            }
        }
    }

    public static void iniciaEliminarCliente(String cuit){
        CONTROLADOR_M.eliminarCliente(cuit);
        buscarGestion.setEnabled(false);
        iniciaBuscarGestion("clienteEliminar");
    }
    
    public static void iniciaModificarMarca() {
        CONTROLADOR_V.modMarca = new ModificarMarca(CONTROLADOR_V.getPrincipal(), true);
        CONTROLADOR_V.modMarca.setVisible(true);
    }

    public static void iniciaEliminarMarca() {
        CONTROLADOR_V.elimMarca = new EliminarMarca(CONTROLADOR_V.getPrincipal(), true);
        CONTROLADOR_V.elimMarca.setVisible(true);
    }

    public static void iniciaAltaProveedor() {
        CONTROLADOR_V.altProveedor = new AMProveedor(CONTROLADOR_V.getPrincipal(), true, "Alta");
        CONTROLADOR_V.altProveedor.setVisible(true);
    }

    public static void iniciaAltaCliente() {
        CONTROLADOR_V.altCliente = new AMCliente(CONTROLADOR_V.getPrincipal(), true, "Alta");
        CONTROLADOR_V.altCliente.setVisible(true);
    }
    //==========Fin dialog==================

    //==========METODOS DE ALTA DE STOCK=======================
    //========Metodos de Alta de Producto=======================    
    public static void ingresaDatosNuevoProducto(Integer prov, String rubro, Integer cup, String marca, String descripcion, Float cap_vol, String unidad, Float precioUnitario, Integer stockIngreso, Float costoProd) {
        CONTROLADOR_M.ingresaDatosNuevoProducto(prov, rubro, cup, marca, descripcion, cap_vol, unidad, precioUnitario, stockIngreso, costoProd);
        LINEA_COMPRA lineaCompra = CONTROLADOR_M.getCompra().getM_LINEA_FACTURA();
        Object[] fila = new Object[5];
        fila[0] = lineaCompra.getCUP();
        fila[1] = lineaCompra.getDescripcion();
        fila[2] = lineaCompra.getStock_Actual();
        fila[3] = lineaCompra.getStock_Ingreso();
        fila[4] = Formato.cambioCarater().format(lineaCompra.getCosto_Prod());
        CONTROLADOR_V.getAltaStock().getModelo().addRow(fila);
        CONTROLADOR_V.getAltaStock().setearModelo();
        CONTROLADOR_V.getAltaStock().getTxtTotal().setText(String.valueOf(Formato.cambioCarater().format(CONTROLADOR_M.getCompra().getPrecio_Total())));
    }

    //========Recupera los nombres de Rubros========
    public static void recupNombresRubros(JComboBox lista) {
        CONTROLADOR_M.recupNombresRubros(lista);
    }

    //========Recupera los nombres de Marca========
    public static void recupNombresMarca(JComboBox lista) {
        CONTROLADOR_M.recupNombresMarca(lista);
    }

    //========Recupera los nombres de Unidad========
    public static void recupNombresUnidad(JComboBox lista) {
        CONTROLADOR_M.recupNombresUnidad(lista);
    }

    //======Recupera los nombres de Proveedor
    public static void recupNombresProveedor(JComboBox lista) {
        CONTROLADOR_M.recupNombresProveedor(lista);
    }

    //===========Recupera codigo correspondiente=========
    public static Integer recupCodigoProducto(String nombreRubro) {
        if (!CONTROLADOR_V.getContro_m().getListaProductoNuevo().isEmpty()) {
            ArrayList<PRODUCTO> listaProdExist = new ArrayList<>();
            for (PRODUCTO producto : CONTROLADOR_V.getContro_m().getListaProductoNuevo()) {
                if (producto.getnRubro().equals(nombreRubro)) {
                    listaProdExist.add(producto);
                }
            }
            if (!listaProdExist.isEmpty()) {
                return listaProdExist.get(listaProdExist.size() - 1).getCUP() + 10;
            } else {
                return CONTROLADOR_M.recupCodigoProducto(nombreRubro);
            }
        } else {
            return CONTROLADOR_M.recupCodigoProducto(nombreRubro);
        }
    }
    //====================Fin de Alta de Producto==============

    //=======Inicia Metodo Buscar Producto==========
    public static void completarTablaBuscar(DefaultTableModel modelo, String tGestion) {
        switch (tGestion) {
            case "Producto":
                modelo.addColumn("Codigo");
                modelo.addColumn("Descripcion/Producto");
                if (!CONTROLADOR_M.getListaProductoDB().isEmpty()) {
                    for (PRODUCTO producto : CONTROLADOR_M.getListaProductoDB()) {
                        Object[] datosFilas = new Object[4];
                        datosFilas[0] = producto.getCUP();
                        if (!producto.getnUnidad().equals("No posee")) {
                            datosFilas[1] = producto.getnMarca() + " " + producto.getDescripcion() + " " + producto.getCap_vol_long() + " " + producto.getnUnidad();
                        } else {
                            datosFilas[1] = producto.getnMarca() + " " + producto.getDescripcion();
                        }
                        datosFilas[2] = producto.getStock();
                        datosFilas[3] = producto.getPrecio_Unitario();
                        modelo.addRow(datosFilas);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro ningun Producto", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case "Proveedor":
                modelo.addColumn("CUIT");
                modelo.addColumn("Razon Social");
                modelo.addColumn("Observacion");
                if (!CONTROLADOR_M.getListaProveedorDB().isEmpty()) {
                    for (PROVEEDOR proveedor : CONTROLADOR_M.getListaProveedorDB()) {
                        Object[] fila = new Object[3];
                        fila[0] = proveedor.getCuit();
                        fila[1] = proveedor.getRazonSocial() + " " + proveedor.getRs();
                        fila[2] = proveedor.getObservacion();
                        modelo.addRow(fila);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro ningun Proveedor", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case "Cliente":
                modelo.addColumn("CUIT");
                modelo.addColumn("Razon Social");
                if (!CONTROLADOR_M.getListaClienteDB().isEmpty()) {
                    for (CLIENTE cliente : CONTROLADOR_M.getListaClienteDB()) {
                        Object[] fila = new Object[2];
                        fila[0] = cliente.getCuit();
                        fila[1] = cliente.getRazonSocial() + " " + cliente.getRs();
                        modelo.addRow(fila);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro ningun Cliente", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
        }
    }

    public static void agregarProducto(Integer cup, Integer stockIng, Float costoTotal) {
        if (!CONTROLADOR_V.getContro_m().cargarProducto(cup, stockIng, costoTotal)) {
            LINEA_COMPRA lineaCompra = CONTROLADOR_M.getCompra().getM_LINEA_FACTURA();
            Object[] fila = new Object[5];
            fila[0] = lineaCompra.getCUP();
            fila[1] = lineaCompra.getDescripcion();
            fila[2] = lineaCompra.getStock_Actual();
            fila[3] = lineaCompra.getStock_Ingreso();
            fila[4] = Formato.cambioCarater().format(lineaCompra.getCosto_Prod());
            CONTROLADOR_V.getAltaStock().getModelo().addRow(fila);
            CONTROLADOR_V.getAltaStock().setearModelo();
            CONTROLADOR_V.getAltaStock().getTxtTotal().setText(String.valueOf(Formato.cambioCarater().format(CONTROLADOR_M.getCompra().getPrecio_Total())));
        }
    }

    public static void eliminar(Integer cup, Integer posProd) {
        CONTROLADOR_M.eliminar(cup);
        CONTROLADOR_V.getAltaStock().getModelo().removeRow(posProd);
        CONTROLADOR_V.getAltaStock().setearModelo();
        CONTROLADOR_V.getAltaStock().getTxtTotal().setText(String.valueOf(Formato.cambioCarater().format(CONTROLADOR_M.getCompra().getPrecio_Total())));
    }

    public static boolean ingresaDatosFac(Integer numero_Factura, Date fecha) {
        return CONTROLADOR_M.ingresaDatosFac(numero_Factura, fecha);
    }
    //==========FIN METODOS DE ALTA DE STOCK=======================

    //===========Inicia metodos gestion de producto============
    public static void completarTablaGestionProducto(DefaultTableModel modelo) {
        if (!CONTROLADOR_M.getListaProductoDB().isEmpty()) {
            for (PRODUCTO producto : CONTROLADOR_M.getListaProductoDB()) {
                Object[] datosFilas = new Object[2];
                datosFilas[0] = producto.getCUP();
                if (!producto.getnUnidad().equals("No posee")) {
                    datosFilas[1] = producto.getnMarca() + " " + producto.getDescripcion() + " " + producto.getCap_vol_long() + " " + producto.getnUnidad();
                } else {
                    datosFilas[1] = producto.getnMarca() + " " + producto.getDescripcion();
                }
                modelo.addRow(datosFilas);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro ningun Producto", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //=============Fin metodos gestion de producto=============

    //==========AM proveedor=========
    public static void recuperarTipoRS(JComboBox listRS) {
        CONTROLADOR_V.getContro_m().recuperarTipoRS(listRS);
    }

    public static boolean altaProveedor(String cuit, String razonSocial, String rs, String telefono, String contacto, String observacion, String domicilio, String pais, String provincia, String localidad, Integer cp) {
        return CONTROLADOR_V.getContro_m().altaProveedor(cuit, razonSocial, rs, telefono, contacto, observacion, domicilio, pais, provincia, localidad, cp);
    }

    public static boolean modificarProveedor(String cuit, String razonSocial, String rs, String telefono, String contacto, String observacion, String domicilio, String pais, String provincia, String localidad, Integer cp) {
        return CONTROLADOR_V.getContro_m().modificarProveedor(cuit, razonSocial, rs, telefono, contacto, observacion, domicilio, pais, provincia, localidad, cp);
    }
    //==============Fin metodos AM Proveedor===============

    //=============Alta Cliente===============
    public static boolean altaCliente(String cuit, String razonSocial, String rs, String telefono, String domicilio, String pais, String provincia, String localidad, Integer cp) {
        return CONTROLADOR_V.getContro_m().altaCliente(cuit, razonSocial, rs, telefono, domicilio, pais, provincia, localidad, cp);
    }

    public static boolean modificarCliente(String cuit, String razonSocial, String rs, String telefono, String domicilio, String pais, String provincia, String localidad, Integer cp) {
        return CONTROLADOR_V.getContro_m().modificarCliente(cuit, razonSocial, rs, telefono, domicilio, pais, provincia, localidad, cp);
    }
    
    //=============Fin alta cliente
    //============Mod ubicacion================

    public static void altaPais(String pais) {
        CONTROLADOR_M.altaPais(pais);
    }

    public static void recuperarPais(JComboBox listaPais) {
        CONTROLADOR_M.recuperarPais(listaPais);
    }

    public static void altaProvincia(String provincia, String pais) {
        CONTROLADOR_M.altaProvincia(provincia, pais);
    }

    public static void altaLocalidad(String localidad, String provincia) {
        CONTROLADOR_M.altaLocalidad(localidad, provincia);
    }

    public static void altaCP(Integer cp, String localidad) {
        CONTROLADOR_M.altaCP(cp, localidad);
    }

    public static ArrayList recuperarProvincia(String pais) {
        return CONTROLADOR_V.getContro_m().recuperarProvincia(pais);
    }

    public static ArrayList recuperarLocalidad(String provincia) {
        return CONTROLADOR_V.getContro_m().recuperarLocalidad(provincia);
    }

    public static ArrayList recuperarCP(String localidad) {
        return CONTROLADOR_V.getContro_m().recuperarCP(localidad);
    }
    //==========Fin alta prov========

    public static void cerrarDB() {
        CONTROLADOR_V.getContro_m().cerrarDB();
    }
}
