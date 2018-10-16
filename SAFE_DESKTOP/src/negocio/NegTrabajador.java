package negocio;

//Importaciones
import modelo.Trabajador;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Ignacio Antillanca
 */
public class NegTrabajador {

    //Variables
    Session sesion;
    
    //Constructor
    public NegTrabajador(){
      sesion = HibernateUtil.getSessionFactory().openSession();
    }
    
     /**
     * Metodo que llama al stored procedure que ingresa una persona a la base de
     * datos.
     * @param t trabajador
     */
    public void addTrabajador(Trabajador t){
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
            System.out.print("ERROR: " + ex.toString());
        }
    }     
}
