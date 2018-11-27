//Paquete
package negocio;

//Importaciones
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * @author Ignacio Antillanca
 * @version 1.0
 */
public class NegLogin {

    /**
     * Método que verifica las credencialesi ngresadas en la vista de Login y
     * compara con los registros de la base de datos.
     *
     * @param username Nombre de usuario ingresado.
     * @param password Contraseña de usuario ingresada.
     *
     * @return true o false en caso de ser correcto o incorrecto.
     */
    public static boolean Login(String username, String password) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Usuario usuario = (Usuario) sesion.createCriteria(Usuario.class)
                .add(Restrictions.eq("username", username)).uniqueResult();

        try {
            if ("".equals(username) || "".equals(password)) {
                JOptionPane.showMessageDialog(null, "Campos en blanco: Ingrese la informacion solicitada", "", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (usuario != null) {
                // validacion del rol de administrador
                int rol = usuario.getRol();
                if (rol != 1) {
                    JOptionPane.showMessageDialog(null, "No tienes permiso para acceder a este modulo", "", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                //Credenciales correctas
                if (usuario.getClave().equals(password)) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña ingresada es incorrecta", "", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario no existe", "", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (HeadlessException e) {
            System.out.println("ERROR EN LOGIN: " + e.toString());
            return false;
        }

    }
}
