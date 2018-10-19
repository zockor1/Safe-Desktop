package presentacion.validaciones;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * @author Ignacio Antillanca 
 * Documento plano que permite establecer los limites
 * a cada campo de texto en los formularios.
 */
public class jTextFieldCharLimits extends PlainDocument {

    private final int limit;

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
