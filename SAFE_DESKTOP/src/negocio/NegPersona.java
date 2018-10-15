package negocio;

//Importaciones
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
     * @param p persona
     */
    public void addPersona(Persona p){
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_persona.create_persona(?,?,?,?,?)")
                    .setParameter(0, p.getRun())
                    .setParameter(1, p.getNombres())
                    .setParameter(2, p.getAppPaterno())
                    .setParameter(3, p.getAppMaterno())
                    .setParameter(4, p.getIdUser());
            //System.out.print("QUERY: " + q.toString());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR: " + ex.toString());
        }
    }
    
    /**
     * Metodo que devuelve el id de persona registrado en la creacion de cuenta
     * y se anexa a los datos de cliente o trabajador.
     *
     * @return result
     */
    public int obtenerPersonaId() {
        try {
            Transaction tx = sesion.beginTransaction();
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
}
