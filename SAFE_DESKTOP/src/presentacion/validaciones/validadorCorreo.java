package presentacion.validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ignacio Antillanca
 */
public class validadorCorreo {

    String correo;

    public validadorCorreo(String email) {
        this.correo = email;
    }

    /**
     * Método que valida el correcto formato de un email.
     *
     * @return True si es correcto, False si no.
     */
    public boolean validateEmail() {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        String email;
        email = correo;
        Matcher mather = pattern.matcher(email);
        return mather.find() == true;
    }
    
}
