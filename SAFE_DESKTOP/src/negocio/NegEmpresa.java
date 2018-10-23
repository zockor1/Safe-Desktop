package negocio;

//Importaciones
import java.util.List;
import modelo.Empresa;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
     * Metodo que llama al stored procedure que ingresa una empresa a la base de
     * datos.
     * @param e Empresa a ingresar
     * @throws Exception general
     */
    public void addEmpresa(Empresa e) throws Exception {
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_empresa.create_empresa(?,?,?,?,?,?)")
                    .setParameter(0, e.getRut())
                    .setParameter(1, e.getNombreFantasia())
                    .setParameter(2, e.getEstado())
                    .setParameter(3, e.getIdCliente())
                    .setParameter(4, e.getIdContrato())
                    .setParameter(5, e.getIdComuna());
            //System.out.print("QUERY: " + q.toString());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR ADD EMPRESA: " + ex.toString());
        }
    }
    
    /**
     * @return Lista de empresas en la base de datos
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
