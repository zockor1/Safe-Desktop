package negocio;

//Importaciones
import modelo.Cliente;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ignacio Antillanca
 */
public class NegCliente {

    //Variables
    Session sesion;
    
    //Constructor
    public NegCliente(){
      sesion = HibernateUtil.getSessionFactory().openSession();
    }
    
     /**
     * Metodo que llama al stored procedure que ingresa un cliente a la base de
     * datos.
     * @param c cliente
     */
    public void addCliente(Cliente c){
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_cliente.create_cliente(?,?,?)")
                    .setParameter(0, c.getTelefono())
                    .setParameter(1, c.getIdPersona())
                    .setParameter(2, c.getComunaId());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR: " + ex.toString());
        }
    }

    /**
     *  Método que devuelve el la informacion del cliente selecionado en la tabla
     * a traves de la is de usuario.
     * @param idUser
     * @return
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
            System.out.println("ERROR: " + ex.toString());
        }
        return null;
    }
}
