//Paquete
package modelo;

//Importaciones
import java.util.HashSet;
import java.util.Set;

/**
 * Comuna generated by hbm2java
 */
public class Comuna implements java.io.Serializable {

    /**
     * Atributos de la Clase Comuna.
     *
     */
    private int idComuna;
    private Region region;
    private String nombre;
    private Set clientes = new HashSet(0);
    private Set empresas = new HashSet(0);

    /**
     * Constructor por defecto de la clase Comuna.
     */
    public Comuna() {
    }

    /**
     * Constructor con parámetros de la clase Comuna.
     *
     * @param idComuna ID_COMUNA de Comuna.
     * @param region Region de Comuna.
     * @param nombre NOMBRE de Comuna.
     */
    public Comuna(int idComuna, Region region, String nombre) {
        this.idComuna = idComuna;
        this.region = region;
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public int getIdComuna() {
        return this.idComuna;
    }

    /**
     *
     * @param idComuna
     */
    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    /**
     *
     * @return
     */
    public Region getRegion() {
        return this.region;
    }

    /**
     *
     * @param region
     */
    public void setRegion(Region region) {
        this.region = region;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public Set getClientes() {
        return this.clientes;
    }

    /**
     *
     * @param clientes
     */
    public void setClientes(Set clientes) {
        this.clientes = clientes;
    }

    /**
     *
     * @return
     */
    public Set getEmpresas() {
        return this.empresas;
    }

    /**
     *
     * @param empresas
     */
    public void setEmpresas(Set empresas) {
        this.empresas = empresas;
    }

    /**
     * Función toString de la clase Comuna.
     *
     * @return los atributos del objeto en formato de texto.
     */
    @Override
    public String toString() {
        return "" + nombre ;
    }

}


