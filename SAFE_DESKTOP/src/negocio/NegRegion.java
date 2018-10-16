package negocio;

//Importaciones
import java.util.List;
import modelo.Region;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Ignacio Antillanca
 */
public class NegRegion {
    
    //Variables
    Session sesion;
    
    public NegRegion(){
        sesion = HibernateUtil.getSessionFactory().openSession();
    }
    
    /**
     * @return Lista de regiones en la base de datos
     * @throws Exception 
     */
    public List<Region> getAllRegion() throws Exception {       
        try {
         Query q = sesion.createQuery("from Region");
         return q.list();   
        } catch (Exception ex){
          System.out.println("ERROR:" + ex.toString());  
        }
        return null;
    }
    
}
