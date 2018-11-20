//Paquete
package negocio;

//Importaciones
import java.util.List;
import modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Ignacio Antillanca 13-10-2018
 * @version 1.0
 */
public class NegUsuario {

    /**
     * Variables utilizadas.
     */
    Session sesion;

    /**
     * Constructor por defecto de la clase NegUsuario.
     */
    public NegUsuario() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Método que llama al stored procedure que ingresa un usuario a la base de
     * datos.
     *
     * @param u Usuario a ingresar
     */
    public void addUsuario(Usuario u) {
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_usuario.create_usuario(?,?,?,?)")
                    .setParameter(0, u.getUsername())
                    .setParameter(1, u.getClave())
                    .setParameter(2, u.getEmail())
                    .setParameter(3, u.getRol());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR ADD USUARIO: " + ex.toString());
        }
    }

    /**
     * Método que que llama al stored procedure que modifica un usuario de la
     * base de datos.
     *
     * @param u Usuario a actualizar.
     * @throws Exception general.
     */
    public void upUsuario(Usuario u) throws Exception {
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_usuario.update_usuario(?,?,?,?,?)")
                    .setParameter(0, u.getIdUsuario())
                    .setParameter(1, u.getUsername())
                    .setParameter(2, u.getClave())
                    .setParameter(3, u.getEmail())
                    .setParameter(4, u.getRol());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR UP USUARIO: " + ex.toString());
        }
    }

    /**
     * Método que que llama al stored procedure que elimina un usuario de la
     * base de datos.
     *
     * @param id ID de usuario a eliminar
     * @return True si se ha eliminado, False en caso contrario.
     * @throws Exception general
     */
    public boolean delUsuario(int id) throws Exception {
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_usuario.delete_usuario(?)")
                    .setParameter(0, id);
            q.executeUpdate();
            tx.commit();
            return true;
        } catch (Exception ex) {
            System.out.print("ERROR DELETE USUARIO: " + ex.toString());
            return false;
        }
    }

    /**
     * Método que llama al stored procedure que devuelve una lista de los
     * usuarios registrados en la base de datos.
     *
     * @return List de contratos, caso contrario, null.
     * @throws Exception general.
     */
    public List<Usuario> getAllUsuario() throws Exception {
        try {
            Query q;
            List<Usuario> result = sesion.createSQLQuery("call pkg_crud_usuario.select_usuarios")
                    .addEntity(Usuario.class)
                    .list();
            return result;
        } catch (Exception ex) {
            System.out.print("ERROR OBTENER USUARIOS: " + ex.toString());
        }
        return null;
    }

    /**
     * Método que devuelve el id del usuario registrado en la creacion de cuenta
     * y se anexa a los datos de persona.
     *
     * @return result = último ID registrado en USUARIO.
     */
    public int obtenerUserId() {
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("SELECT ID_USUARIO\n"
                    + "FROM ( SELECT A.*, MAX(A.ID_USUARIO) OVER () AS max_pk\n"
                    + "FROM USUARIO A)\n"
                    + "WHERE ID_USUARIO = max_pk");
            Object result = q.uniqueResult();
            tx.commit();
            return ((Number) result).intValue();
        } catch (NumberFormatException ex) {
            System.out.print("ERROR OBTENER USER ID: " + ex.toString());
        }
        return 0;
    }

    /**
     * Método que valida en la base de datos, si existe o no un nombre de
     * usuario para evitar conflictos.
     *
     * @param username nombre de usuario a validar en la BD
     * @return Object si existe el username, null si esta disponible.
     */
    public Object validateUsername(String username) {
        Query q = sesion.createSQLQuery("SELECT USERNAME FROM USUARIO WHERE USERNAME = ?")
                .setParameter(0, username);
        return q.uniqueResult();
    }
}
