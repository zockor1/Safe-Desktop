//Paquete
package presentacion.validaciones;

//Importaciones
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Documento plano que permite establecer los limites a cada campo de texto en
 * los formularios.
 *
 * @author Ignacio Antillanca
 * @version 1.0
 */
public class jTextFieldCharLimits extends PlainDocument {

    /**
     * Variables utilizadas.
     */
    private final int limit;

    /**
     * Constructor con parametros de la clase jTextFieldCharLimits.
     *
     * @param limitation Número entero maximo a establecer.
     */
    public jTextFieldCharLimits(int limitation) {
        this.limit = limitation;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet set) throws BadLocationException {
        if (str == null) {
        } else if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, set);
        }
    }
}
