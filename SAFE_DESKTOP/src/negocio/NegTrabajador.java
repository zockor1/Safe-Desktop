//Paquete
package negocio;

//Importaciones
import modelo.Trabajador;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Ignacio Antillanca
 * @version 1.2
 */
public class NegTrabajador {

    /**
     * Variables utilizadas.
     */
    Session sesion;

    /**
     * Constructor por defecto de la clase NegTrabajador.
     */
    public NegTrabajador() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Método que llama al stored procedure que ingresa una persona a la base de
     * datos.
     *
     * @param t trabajador a ingresar
     */
    public void addTrabajador(Trabajador t) {
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_trabajador.create_trabajador(?,?,?,?,?)")
                    .setParameter(0, t.getTelefono())
                    .setParameter(1, t.getFechaContrato())
                    .setParameter(2, t.getCargo())
                    .setParameter(3, t.getIdPersona())
                    .setParameter(4, t.getIdEmpresa());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR ADD TRABAJADOR: " + ex.toString());
        }
    }

    /**
     * Método que que llama al stored procedure que modifica un trabajador de la
     * base de datos.
     *
     * @param t Trabajador a actualizar.
     * @throws Exception general.
     */
    public void upTrabajador(Trabajador t) throws Exception {
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_trabajador.update_trabajador(?,?,?,?,?,?)")
                    .setParameter(0, t.getIdTrabajador())
                    .setParameter(1, t.getTelefono())
                    .setParameter(2, t.getFechaContrato())
                    .setParameter(3, t.getCargo())
                    .setParameter(4, t.getIdPersona())
                    .setParameter(5, t.getIdEmpresa());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR UP TRABAJADOR: " + ex.toString());
        }
    }

    /**
     * Método que devuelve el la informacion del trabajador selecionado en la
     * tabla a traves de la id de usuario.
     *
     * @param idUser ID de usuario del trabajador a encontrar.
     * @return Trabajador encontrado o null.
     */
    public Trabajador obtenerTrabajador(int idUser) {
        try {
            Query q = sesion.createSQLQuery("SELECT c.ID_TRABAJADOR\n"
                    + "FROM TRABAJADOR c\n"
                    + "INNER JOIN PERSONA pr\n"
                    + "  ON c.PERSONA_ID_PERSONA = pr.ID_PERSONA\n"
                    + "INNER JOIN USUARIO us\n"
                    + "  ON pr.USUARIO_ID_USUARIO = us.ID_USUARIO AND c.PERSONA_ID_PERSONA = pr.ID_PERSONA\n"
                    + "WHERE us.ID_USUARIO = ?")
                    .setParameter(0, idUser);
            Object result = q.uniqueResult();
            int id = ((Number) result).intValue();
            Trabajador tr = (Trabajador) sesion.get(Trabajador.class, id);
            return tr;
        } catch (Exception ex) {
            System.out.println("ERROR OBTENER TRABAJADOR: " + ex.toString());
        }
        return null;
    }
}
