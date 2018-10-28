//Paquete
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

    /**
     * Variables utilizadas.
     */
    Session sesion;

    /**
     * Constructor por defecto de la clase NegPersona.
     */
    public NegPersona() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Método que llama al stored procedure que ingresa una Persona a la base de
     * datos.
     *
     * @param p Persona a ingresar
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
            System.out.print("ERROR ADD PERSONA: " + ex.toString());
        }
    }

    /**
     * Método que que llama al stored procedure que modifica una Persona de la
     * base de datos.
     *
     * @param p Persona a modificar
     * @throws Exception general
     */
    public void upPersona(Persona p) throws Exception {
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_persona.update_persona(?,?,?,?,?,?)")
                    .setParameter(0, p.getIdPersona())
                    .setParameter(1, p.getRun())
                    .setParameter(2, p.getNombres())
                    .setParameter(3, p.getAppPaterno())
                    .setParameter(4, p.getAppMaterno())
                    .setParameter(5, p.getIdUser());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR UP PERSONA: " + ex.toString());
        }
    }

    /**
     * Método que retorna una lista de las personas registradas en la base de
     * datos.
     *
     * @return list Lista de personas.
     * @throws Exception general.
     */
    public List<Persona> getAllPersona() throws Exception {
        List<Persona> list = sesion.createCriteria(Persona.class).list();
        return list;
    }

    /**
     * Método que devuelve el id de persona registrado en la creacion de cuenta
     * y se anexa a los datos de cliente o trabajador.
     *
     * @return result ID de persona
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
            System.out.print("ERROR OBTENER ID PERSONA: " + ex.toString());
        }
        return 0;
    }

    /**
     * Método que valida en la base de datos, si existe o no un RUN de persona
     * registrado para evitar conflictos.
     *
     * @param run Run ingresado en la creacion de cuentas.
     * @return False si existe el username, True si esta disponible.
     */
    public boolean validateRun(String run) {
        Query q = sesion.createSQLQuery("SELECT RUN FROM PERSONA WHERE RUN = ?")
                .setParameter(0, run);
        String result = String.valueOf(q);
        if (result.equals("")) {
            return true;
        } else {
            return result.equals(run);
        }
    }

    /**
     * Método que devuelve la informacion de la persona selecionada en la tabla
     * a traves de la id de usuario.
     *
     * @param idUser ID de persona a encontrar
     * @return Persona encontrada o null
     */
    public Persona obtenerPersona(int idUser) {
        try {
            Query q = sesion.createSQLQuery("SELECT pr.ID_PERSONA\n"
                    + "FROM PERSONA pr\n"
                    + "INNER JOIN USUARIO usu\n"
                    + "ON pr.USUARIO_ID_USUARIO = usu.ID_USUARIO\n"
                    + "WHERE usu.ID_USUARIO = ?")
                    .setParameter(0, idUser);
            Object result = q.uniqueResult();
            int id = ((Number) result).intValue();
            Persona p = (Persona) sesion.get(Persona.class, id);
            return p;
        } catch (Exception ex) {
            System.out.println("ERROR controller: " + ex.toString());
        }
        return null;
    }
}
