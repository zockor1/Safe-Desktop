package negocio;

import modelo.Contrato;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Zockor
 */
public class NegContrato {
    
    Session sesion;
    
    public NegContrato(){
        sesion = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void addContrato(Contrato c) throws Exception {
        Transaction tx = sesion.beginTransaction();
        sesion.save(c);
        tx.commit();
    }
}
