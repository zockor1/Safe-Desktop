//Paquete
package negocio;

//Importaciones
import java.util.List;
import modelo.Cliente;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Ignacio Antillanca
 * @version 1.0
 */
public class NegCliente {

    /**
     * Variables utilizadas.
     */
    Session sesion;

    /**
     * Constructor por defecto de la clase NegCliente.
     */
    public NegCliente() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Método que llama al stored procedure que ingresa un cliente a la base de
     * datos.
     *
     * @param c Cliente a ingresar
     */
    public void addCliente(Cliente c) {
        try {
            NegPersona per = new NegPersona();
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_cliente.create_cliente(?,?,?)")
                    .setParameter(0, c.getTelefono())
                    .setParameter(1, per.obtenerPersonaId())
                    .setParameter(2, c.getComuna().getIdComuna());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR REGISTRO CLIENTE: " + ex.toString());
        }
    }

    /**
     * Método que que llama al stored procedure que modifica un cliente de la
     * base de datos.
     *
     * @param c Cliente a actualizar
     * @throws Exception general
     */
    public void upCliente(Cliente c) throws Exception {
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_cliente.update_cliente(?,?,?,?)")
                    .setParameter(0, c.getIdCliente())
                    .setParameter(1, c.getTelefono())
                    .setParameter(2, c.getPersona().getIdPersona())
                    .setParameter(3, c.getComuna().getIdComuna());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR UP CLIENTE: " + ex.toString());
        }
    }

    /**
     * Método que obtiene todos los clientes registrado en la base de datos.
     *
     * @return Lista de clientes en la base de datos
     * @throws Exception
     */
    public List<Cliente> getAllCliente() throws Exception {
        try {
            Query q = sesion.createQuery("from Cliente");
            return q.list();
        } catch (Exception ex) {
            System.out.println("ERROR OBTENER CLIENTES:" + ex.toString());
        }
        return null;
    }

    /**
     * Método que devuelve el la informacion del cliente selecionado en la tabla
     * a traves de la id de usuario.
     *
     * @param idUser ID del usuario a encontrar
     * @return Objeto Cliente.
     */
    public Cliente obtenerCliente(int idUser) {
        try {
            Query q = sesion.createSQLQuery("SELECT c.ID_CLIENTE\n"
                    + "FROM CLIENTE c\n"
                    + "INNER JOIN PERSONA pr\n"
                    + "  ON c.PERSONA_ID_PERSONA = pr.ID_PERSONA\n"
                    + "INNER JOIN USUARIO us\n"
                    + "  ON pr.USUARIO_ID_USUARIO = us.ID_USUARIO AND c.PERSONA_ID_PERSONA = pr.ID_PERSONA\n"
                    + "WHERE us.ID_USUARIO = ?")
                    .setParameter(0, idUser);
            Object result = q.uniqueResult();
            int id = ((Number) result).intValue();
            Cliente cli = (Cliente) sesion.get(Cliente.class, id);
            return cli;
        } catch (Exception ex) {
            System.out.println("ERROR OBTENER CLIENTE POR ID: " + ex.toString());
        }
        return null;
    }
}
