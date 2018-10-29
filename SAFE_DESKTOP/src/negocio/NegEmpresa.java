//Paquete
package negocio;

//Importaciones
import java.util.List;
import modelo.Empresa;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Ignacio Antillanca
 * @version 1.0
 */
public class NegEmpresa {

    /**
     * Variables a utilizar.
     */
    Session sesion;

    /**
     * Constructor por defecto de la clase NegEmpresa.
     */
    public NegEmpresa() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Método que llama al stored procedure que ingresa una empresa a la base de
     * datos.
     *
     * @param e Empresa a ingresar.
     * @throws Exception general.
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
     * Método que devuelve la informacion de la persona selecionada en la tabla
     * a traves de la id de usuario.
     *
     * @param idCon ID de Contrato a encontrar
     * @return Empresa encontrada o null
     */
    public Empresa obtenerEmpresa(int idCon) {
        try {
            Query q = sesion.createSQLQuery("SELECT emp.ID_EMPRESA\n"
                    + "FROM EMPRESA emp\n"
                    + "INNER JOIN CONTRATO con\n"
                    + "ON emp.CONTRATO_ID_CONTRATO = con.ID_CONTRATO\n"
                    + "WHERE con.ID_CONTRATO = ?")
                    .setParameter(0, idCon);
            Object result = q.uniqueResult();
            int id = ((Number) result).intValue();
            Empresa e = (Empresa) sesion.get(Empresa.class, id);
            return e;
        } catch (Exception ex) {
            System.out.println("ERROR OBTENER EMPRESA: " + ex.toString());
        }
        return null;
    }
    
    /**
     * Método que devuelve las empresas registradas en la base de datos.
     *
     * @return Lista de empresas en la base de datos.
     * @throws Exception general.
     */
    public List<Empresa> getAllEmpresa() throws Exception {
        try {
            Query q = sesion.createQuery("from Empresa");
            return q.list();
        } catch (Exception ex) {
            System.out.println("ERROR OBTENER LISTADO EMPRESAS:" + ex.toString());
        }
        return null;
    }

}
