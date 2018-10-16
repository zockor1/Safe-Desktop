/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import modelo.Comuna;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ignacio Antillanca
 */
public class NegComuna {
    //Variables
    Session sesion;
    
    public NegComuna(){
        sesion = HibernateUtil.getSessionFactory().openSession();
    }
    
    /**
     * @return Lista de regiones en la base de datos
     * @throws Exception 
     */
    public List<Comuna> getAllComuna() throws Exception {       
        try {
         Query q = sesion.createQuery("from Comuna");
         return q.list();   
        } catch (Exception ex){
          System.out.println("ERROR:" + ex.toString());  
        }
        return null;
    }
}
