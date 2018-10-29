//Paquete
package modelo;

//Importaciones
import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

    /**
     * Atributos de la clase Usuario.
     */
    private int idUsuario;
    private String username;
    private String clave;
    private String email;
    private int rol;
    private Set personas = new HashSet(0);

    /**
     * Constructor por defecto de la clase Usuario.
     */
    public Usuario() {
    }

    /**
     * Constructor con parametros de la clase Usuario.
     *
     * @param username USERNAME de Usuario.
     * @param clave CLAVE de usuario.
     * @param email EMAIL de usuario.
     * @param rol ROL de Usuario.
     */
    public Usuario(String username, String clave, String email, int rol) {
        this.username = username;
        this.clave = clave;
        this.email = email;
        this.rol = rol;
    }

    /**
     *
     * @return
     */
    public int getIdUsuario() {
        return this.idUsuario;
    }

    /**
     *
     * @param idUsuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return this.username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getClave() {
        return this.clave;
    }

    /**
     *
     * @param clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public int getRol() {
        return this.rol;
    }

    /**
     *
     * @param rol
     */
    public void setRol(int rol) {
        this.rol = rol;
    }

    /**
     *
     * @return
     */
    public Set getPersonas() {
        return this.personas;
    }

    /**
     *
     * @param personas
     */
    public void setPersonas(Set personas) {
        this.personas = personas;
    }

    /**
     * Función toString de la clase Usuario.
     *
     * @return los atributos del objeto en formato de texto.
     */
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", username=" + username + ", clave=" + clave + ", email=" + email + ", rol=" + rol + ", personas=" + personas + '}';
    }

}


