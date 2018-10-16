package negocio;

//Importaciones
import java.util.List;
import modelo.Empresa;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Ignacio Antillanca
 */

public class NegEmpresa {
//Variables
    Session sesion;
    
    public NegEmpresa(){
        sesion = HibernateUtil.getSessionFactory().openSession();
    }
    
    /**
     * @return Lista de regiones en la base de datos
     * @throws Exception 
     */
    public List<Empresa> getAllEmpresa() throws Exception {       
        try {
         Query q = sesion.createQuery("from Empresa");
         return q.list();   
        } catch (Exception ex){
          System.out.println("ERROR:" + ex.toString());  
        }
        return null;
    }
    
}
