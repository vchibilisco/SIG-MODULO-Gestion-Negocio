package modelo.dominio;

/**
 * @author vicente
 * @version 1.0
 * @created 20-dic-2012 10:11:05 a.m.
 */
public class RUBRO {

    private Integer id_Rubro;
    private String nombre;

    public RUBRO() {
    }

    public void finalize() throws Throwable {
    }

    /**
     *
     * @param long
     * @param char
     */
    public RUBRO(Integer id_Rubro, String nombre) {
        this.id_Rubro = id_Rubro;
        this.nombre = nombre;
    }

    public int getId_Rubro() {
        return id_Rubro;
    }

    public void setId_Rubro(Integer id_Rubro) {
        this.id_Rubro = id_Rubro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     *
     * @param char
     */
}//end RUBRO