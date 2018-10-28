//Paquete
package negocio;

//Importaciones
import java.util.List;
import modelo.Comuna;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ignacio Antillanca
 * @version 1.0
 */
public class NegComuna {

    /**
     * Variables utilizadas.
     */
    Session sesion;

    /**
     * Constructor por defecto de la clase NegComuna.
     */
    public NegComuna() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Método que devuelve todas las comunas registras en la base de datos.
     *
     * @return Lista de regiones en la base de datos
     * @throws Exception general.
     */
    public List<Comuna> getAllComuna() throws Exception {
        try {
            Query q = sesion.createQuery("from Comuna");
            return q.list();
        } catch (Exception ex) {
            System.out.println("ERROR OBTENER COMUNAS:" + ex.toString());
        }
        return null;
    }
}
