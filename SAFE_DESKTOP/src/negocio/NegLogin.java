package negocio;

import javax.swing.JOptionPane;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Ignacio Antillanca
 * @version 1.0
 * 16-09-2018
 */
public class NegLogin {
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
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }
}
