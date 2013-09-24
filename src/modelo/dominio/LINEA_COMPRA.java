package modelo.dominio;

/**
 * @author vicente
 * @version 1.0
 * @created 20-dic-2012 10:11:03 a.m.
 */
public class LINEA_COMPRA {

    private Integer CUP;
    private String descripcion;
    private Integer stock_Actual;
    private Integer stock_Ingreso;
    private Float costo_Prod;

    public LINEA_COMPRA() {
    }

    /**
     *
     * @param PRODUCTO
     * @param int
     * @param float
     */
    public LINEA_COMPRA(PRODUCTO producto, Integer stockIng, Float costoProd) {
        this.CUP = producto.getCUP();
        if (producto.getnUnidad().equals("No posee")) {
            this.descripcion = producto.getnMarca() + " " + producto.getDescripcion();
        } else {
            this.descripcion = producto.getnMarca() + " " + producto.getDescripcion() + " " + producto.getCap_vol_long() + " " + producto.getnUnidad();
        }
        if (producto.getStock() == 0) {
            this.stock_Actual = 0;
        } else {
            this.stock_Actual = producto.getStock();
        }
        this.stock_Ingreso = stockIng;
        this.costo_Prod = costoProd;
    }

    public Integer getCUP() {
        return CUP;
    }

    public void setCUP(Integer CUP) {
        this.CUP = CUP;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock_Actual() {
        return stock_Actual;
    }

    public void setStock_Actual(Integer stock_Actual) {
        this.stock_Actual = stock_Actual;
    }

    public Integer getStock_Ingreso() {
        return stock_Ingreso;
    }

    public void setStock_Ingreso(Integer stock_Ingreso) {
        this.stock_Ingreso = stock_Ingreso;
    }

    public Float getCosto_Prod() {
        return costo_Prod;
    }

    public void setCosto_Prod(Float costo_Prod) {
        this.costo_Prod = costo_Prod;
    }
}//end LINEA_COMPRA