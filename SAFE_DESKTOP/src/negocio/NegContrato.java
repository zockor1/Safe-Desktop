package negocio;

// Importaciones
import java.util.List;
import modelo.Contrato;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Ignacio Antillanca
 * @version 1.0
 */
public class NegContrato {

    //Variables.
    Session sesion;

    //Constructor por defecto.
    public NegContrato() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Metodo que llama al stored procedure que ingresa un contrato a la base de
     * datos.
     * @param c contrato
     * @throws Exception general
     */
    public void addContrato(Contrato c) throws Exception {
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_contrato.create_contrato(?,?)")
                    .setParameter(0, c.getFechaInicio())
                    .setParameter(1, c.getFechaTermino());
            //System.out.print("QUERY: " + q.toString());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR INGRESO CONTRATO: " + ex.toString());
        }
    }

    /**
     * Metodo que que llama al stored procedure que modifica un contrato de la
     * base de datos.
     * @param c contrato
     * @throws Exception general
     */
    public void upContrato(Contrato c) throws Exception {
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_contrato.update_contrato(?,?,?)")
                    .setParameter(0, c.getIdContrato())
                    .setParameter(1, c.getFechaInicio())
                    .setParameter(2, c.getFechaTermino());
            //System.out.print("QUERY: " + q.toString());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR: " + ex.toString());
        }
    }

    /**
     * Metodo que que llama al stored procedure que elimina un contrato de la
     * base de datos.
     * @param c contrato
     * @throws Exception general
     */
    public void delContrato(Contrato c) throws Exception {
        try {
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createSQLQuery("call pkg_crud_contrato.delete_contrato(?)")
                    .setParameter(0, c.getIdContrato());
            //System.out.print("QUERY: " + q.toString());
            q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.print("ERROR: " + ex.toString());
        }
    }

    /**
     * Metodo que llama al stored procedure que devuelve una lista de los
     * contratos registrados en la base de datos.
     * @return List de contratos, caso contrario, null
     * @throws Exception general
     */
    public List<Contrato> getAllContrato() throws Exception {
        try {
            Query q;
            List<Contrato> result = sesion.createSQLQuery("call pkg_crud_contrato.select_contratos")
                    .addEntity(Contrato.class)
                    .list();
            return result;
        } catch(Exception ex) {
           System.out.print("ERROR: " + ex.toString()); 
        }
        return null;
    }
    
    /**
     * Metodo que devuelve el id de contrato registrado en la creacion de
     * empresa y se anexa a los datos de la empresa a registrar.
     *
     * @return result ID de contrato
     */
    public int obtenerContratoId() {
        try {
            Query q = sesion.createSQLQuery("SELECT ID_CONTRATO\n"
                    + "FROM ( SELECT a.*, MAX(ID_CONTRATO) OVER (\n"
                    + ") AS max_pk\n"
                    + "FROM CONTRATO A)\n"
                    + "WHERE ID_CONTRATO = max_pk");
            Object result = q.uniqueResult();
            return ((Number) result).intValue();
        } catch (NumberFormatException ex) {
            System.out.print("ERROR ID CONTRATO: " + ex.toString());
        }
        return 0;
    }
   
}
