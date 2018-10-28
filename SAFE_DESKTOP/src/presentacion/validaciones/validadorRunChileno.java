//Paquete
package presentacion.validaciones;

//Importaciones
/**
 * @author Ignacio Antillanca
 * @version 1.0
 */
public class validadorRunChileno {

    /**
     * Variables utilizadas.
     */
    String rut;

    /**
     * Constructor con parametros de la clase validadorRunChileno.
     *
     * @param run Texto ingresado a validar.
     */
    public validadorRunChileno(String run) {
        this.rut = run;
    }

    /**
     * Método que verifica el formato y veracidad de un RUN ingresado, con el
     * formato de Chile.
     *
     * @return true en caso de que el run sea correcto, false en caso contrario.
     */
    public boolean validateRun() {
        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
}
