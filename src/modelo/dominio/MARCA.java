package modelo.dominio;

/**
 * @author vicente
 * @version 1.0
 * @created 20-dic-2012 10:11:04 a.m.
 */
public class MARCA {

    private Integer id_Marca;
    private String nombre;

    public MARCA() {
    }

    public MARCA(Integer id, String nombre) {
        this.id_Marca = id;
        this.nombre = nombre;
    }

    public void finalize() throws Throwable {
    }

    public Integer getId_Marca() {
        return id_Marca;
    }

    public void setId_Marca(Integer id_Marca) {
        this.id_Marca = id_Marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}//end MARCA