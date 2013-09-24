/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dominio;

/**
 *
 * @author vicente-dell
 */
public class PROVEEDOR {

    private String cuit;
    private String razonSocial;
    private String rs;
    private String telefono;
    private String contacto;
    private String domicilio;
    private UBICACION ubicacion;
    private String observacion;

    public PROVEEDOR(String cuit, String razonSocial, String rs, String telefono, String contacto, String observacion, String domicilio, String pais, String provincia, String localidad, Integer cp) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.rs = rs;
        this.telefono = telefono;
        this.contacto = contacto;
        this.domicilio = domicilio;
        this.observacion = observacion;
        this.ubicacion = new UBICACION(cp, localidad, provincia, pais);
    }

    public PROVEEDOR() {        
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public UBICACION getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UBICACION ubicacion) {
        this.ubicacion = ubicacion;
    }
}
