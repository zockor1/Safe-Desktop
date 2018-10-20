package negocio;

//Importaciones
import java.util.List;
import modelo.Persona;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Ignacio Antillanca
 * @version 1.0
 */
public class NegPersona {
    
    //Variables
    Session sesion;
    
    //Constructor
    public NegPersona(){
      sesion = HibernateUtil.getSessionFactory().openSession();
    }
    
    /**
     * Metodo que llama al stored procedure que ingresa una persona a la base de
     * datos.
     * @param p Persona 
     */
    public void addPersona(Persona p) {
            try {
                Transaction tx = sesion.beginTransaction();
                Query q = sesion.createSQLQuery("call pkg_crud_persona.create_persona(?,?,?,?,?)")
                        .setParameter(0, p.getRun())
                        .setParameter(1, p.getNombres())
                        .setParameter(2, p.getAppPaterno())
                        .setParameter(3, p.getAppMaterno())
                        .setParameter(4, p.getIdUser());
                q.executeUpdate();
                tx.commit();
            } catch (Exception ex) {
                System.out.print("ERROR: " + ex.toString());

            }
    }
    
     /**
     * Método que retorna una lista de las personas registradas en la base de 
     * datos.
     * @return Lista de persona.
     * @throws Exception general.
     */
    public List<Persona> getAllPersona() throws Exception {
        List<Persona> list = sesion.createCriteria(Persona.class).list();
        return list;
    }
    
    /**
     * Metodo que devuelve el id de persona registrado en la creacion de cuenta
     * y se anexa a los datos de cliente o trabajador.
     *
     * @return result
     */
    public int obtenerPersonaId() {
        try {
            Query q = sesion.createSQLQuery("SELECT ID_PERSONA\n"
                    + "  FROM ( SELECT a.*, MAX(ID_PERSONA) OVER (\n"
                    + "  ) AS max_pk\n"
                    + "    FROM PERSONA A)\n"
                    + "    where ID_PERSONA = max_pk");
            Object result = q.uniqueResult();
            return ((Number) result).intValue();
        } catch (NumberFormatException ex) {
            System.out.print("ERROR: " + ex.toString());
        }
        return 0;
    }
    
    /**
     * Método que valida en la base de datos, si existe o no un RUN de persona
     * registrado para evitar conflictos.
     *
     * @param run Run ingresado en la creacion de cuentas.
     * @return 1 si existe el username, 0 si esta disponible.
     */
    public Object validateRun(String run) {
        Query q = sesion.createSQLQuery("SELECT RUN FROM PERSONA WHERE RUN = ?")
                .setParameter(0, run);
        return q.uniqueResult();
    }
}
