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
            Query q = sesion.createSQLQuery("call pkg_crud_cliente.create_cliente(?,?,?,?)")
                    .setParameter(0, c.getTelefono())
                    .setParameter(1, c.getComuna())
                    .setParameter(2, c.getRegion())
                    .setParameter(3, c.getIdPersona());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR: " + ex.toString());
        }
    }       
}
