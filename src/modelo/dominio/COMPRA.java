package modelo.dominio;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author vicente
 * @version 1.0
 * @created 20-dic-2012 10:11:03 a.m.
 */
public class COMPRA {

    private Integer numero_Factura;
    private Date fecha;
    private Float precio_Total;
    private ArrayList<LINEA_COMPRA> lista_compra;
    private LINEA_COMPRA m_LINEA_FACTURA;
    private boolean estaCargado = false;

    public COMPRA() {
        this.lista_compra = new ArrayList<>();
    }

    public Integer getNumero_Factura() {
        return numero_Factura;
    }

    public void setNumero_Factura(Integer numero_Factura) {
        this.numero_Factura = numero_Factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getPrecio_Total() {
        return precio_Total;
    }

    public void setPrecio_Total(Float precio_Total) {
        this.precio_Total = precio_Total;
    }

    public LINEA_COMPRA getM_LINEA_FACTURA() {
        return m_LINEA_FACTURA;
    }

    public void setM_LINEA_FACTURA(LINEA_COMPRA m_LINEA_FACTURA) {
        this.m_LINEA_FACTURA = m_LINEA_FACTURA;
    }

    public ArrayList<LINEA_COMPRA> getLista_compra() {
        return lista_compra;
    }

    /**
     *
     * @param PRODUCTO
     * @param int
     * @param float
     */
    public void ingresaDatos(PRODUCTO Producto, Integer stock_ingreso, Float costo_prod) {
        this.m_LINEA_FACTURA = new LINEA_COMPRA(Producto, stock_ingreso, costo_prod);
        this.getLista_compra().add(m_LINEA_FACTURA);
        this.actualizarTotal();
    }

    /**
     *
     * @param long
     * @param date
     */
    public void ingresaDatosFac(long numero_factura, Date fecha) {
    }

    //=======Cargar una linea de producto existente=========
    public LINEA_COMPRA cargar(PRODUCTO producto, Integer stockIng, Float costoTotal) {
        this.m_LINEA_FACTURA = new LINEA_COMPRA(producto, stockIng, costoTotal);
        this.lista_compra.add(m_LINEA_FACTURA);
        this.actualizarTotal();
        return this.m_LINEA_FACTURA;
    }

    public void actEliminar() {
        actualizarTotal();
    }

    public void actualizarTotal() {
        Float precio = Float.parseFloat("0.00");
        for (LINEA_COMPRA linea : this.getLista_compra()) {
            precio = precio + linea.getCosto_Prod();
            this.setPrecio_Total(precio);
        }
    }
}//end COMPRA