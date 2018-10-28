//Paquete
package negocio;

//Importaciones
import java.util.List;
import modelo.Region;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Ignacio Antillanca
 * @version 1.0
 */
public class NegRegion {

    /**
     * Variables utilizadas.
     */
    Session sesion;

    /**
     * Constructor por defecto de la clase NegRegion.
     */
    public NegRegion() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Método que obtiene todas las regiones registradas en la base de datos.
     *
     * @return Lista de regiones en la base de datos
     * @throws Exception general.
     */
    public List<Region> getAllRegion() throws Exception {
        try {
            Query q = sesion.createQuery("from Region");
            return q.list();
        } catch (Exception ex) {
            System.out.println("ERROR OBTENER REGIONES:" + ex.toString());
        }
        return null;
    }

}
