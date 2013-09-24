package modelo.dominio;

/**
 * @author vicente
 * @version 1.0
 * @created 20-dic-2012 10:11:04 a.m.
 */
public class PRODUCTO {

    private Integer CUP;
    private String descripcion;
    private Float cap_vol_long;
    private Integer stock;
    private Float precio_Unitario;
    private String nMarca;
    private String nRubro;
    private String nUnidad;
    private PROVEEDOR proveedor;

    public PRODUCTO() {
    }

    public PROVEEDOR getProveedor() {
        return proveedor;
    }

    public void setProveedor(PROVEEDOR proveedor) {
        this.proveedor = proveedor;
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

    public Float getCap_vol_long() {
        return cap_vol_long;
    }

    public void setCap_vol_long(Float cap_vol_long) {
        this.cap_vol_long = cap_vol_long;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Float getPrecio_Unitario() {
        return precio_Unitario;
    }

    public void setPrecio_Unitario(Float precio_Unitario) {
        this.precio_Unitario = precio_Unitario;
    }

    public String getnMarca() {
        return nMarca;
    }

    public void setnMarca(String nMarca) {
        this.nMarca = nMarca;
    }

    public String getnRubro() {
        return nRubro;
    }

    public void setnRubro(String nRubro) {
        this.nRubro = nRubro;
    }

    public String getnUnidad() {
        return nUnidad;
    }

    public void setnUnidad(String nUnidad) {
        this.nUnidad = nUnidad;
    }

    public boolean actualizar(PRODUCTO producto) {
        return true;
    }

    public boolean eliminar(PRODUCTO producto) {
        return true;
    }
}//end PRODUCTO