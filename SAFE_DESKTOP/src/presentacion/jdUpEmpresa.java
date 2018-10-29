//Paquete
package presentacion;

//Importaciones
import com.sun.glass.events.KeyEvent;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ItemEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Comuna;
import modelo.Contrato;
import modelo.Empresa;
import modelo.Region;
import negocio.NegCliente;
import negocio.NegComuna;
import negocio.NegContrato;
import negocio.NegEmpresa;
import negocio.NegRegion;
import presentacion.validaciones.jTextFieldCharLimits;
import presentacion.validaciones.validadorRunChileno;

/**
 * @author Ignacio Antillanca
 * @version 1.0
 */
public class jdUpEmpresa extends javax.swing.JDialog {

    /**
     * Variables utilizadas.
     */
    List<Comuna> listComuna;
    List<Region> listRegion;
    List<Cliente> listCliente;

    /**
     * Constructor que inicializa la ventana de ingreso de empresa.
     *
     * @param parent ventana jfPrincipal
     * @param modal
     */
    public jdUpEmpresa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limits();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds((ancho / 2) - (this.getWidth() / 2), (alto / 2) - (this.getHeight() / 2), 800, 600);
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUpEmpresa = new javax.swing.JPanel();
        pnlAddEmpresaBanner = new javax.swing.JPanel();
        lblTituloEmpresa = new javax.swing.JLabel();
        lblIdClient = new javax.swing.JLabel();
        jpAddContrato = new javax.swing.JPanel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaTermino = new javax.swing.JLabel();
        dpFechaInicio = new com.toedter.calendar.JDateChooser();
        dpFechaTermino = new com.toedter.calendar.JDateChooser();
        jpAddEmpresa = new javax.swing.JPanel();
        lblRut = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        lblNombFantasia = new javax.swing.JLabel();
        txtNombreFantasia = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        ddlCliente = new javax.swing.JComboBox<>();
        lblRegion = new javax.swing.JLabel();
        ddlRegion = new javax.swing.JComboBox<>();
        lblComuna = new javax.swing.JLabel();
        ddlComuna = new javax.swing.JComboBox<>();
        btnUpEmpresa = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlUpEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        pnlUpEmpresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnlAddEmpresaBanner.setBackground(new java.awt.Color(17, 48, 142));

        lblTituloEmpresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTituloEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloEmpresa.setText("MODIFICACION DE EMPRESA");

        lblIdClient.setForeground(new java.awt.Color(255, 255, 255));
        lblIdClient.setText("ID CLIENTE");

        javax.swing.GroupLayout pnlAddEmpresaBannerLayout = new javax.swing.GroupLayout(pnlAddEmpresaBanner);
        pnlAddEmpresaBanner.setLayout(pnlAddEmpresaBannerLayout);
        pnlAddEmpresaBannerLayout.setHorizontalGroup(
            pnlAddEmpresaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddEmpresaBannerLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblIdClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(lblTituloEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270))
        );
        pnlAddEmpresaBannerLayout.setVerticalGroup(
            pnlAddEmpresaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddEmpresaBannerLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlAddEmpresaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloEmpresa)
                    .addComponent(lblIdClient))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jpAddContrato.setBackground(new java.awt.Color(255, 255, 255));
        jpAddContrato.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Contrato"));

        lblFechaInicio.setText("Fecha de Inicio");

        lblFechaTermino.setText("Fecha de Termino");

        javax.swing.GroupLayout jpAddContratoLayout = new javax.swing.GroupLayout(jpAddContrato);
        jpAddContrato.setLayout(jpAddContratoLayout);
        jpAddContratoLayout.setHorizontalGroup(
            jpAddContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddContratoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblFechaInicio)
                .addGap(84, 84, 84)
                .addComponent(dpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(lblFechaTermino)
                .addGap(18, 18, 18)
                .addComponent(dpFechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpAddContratoLayout.setVerticalGroup(
            jpAddContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddContratoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpAddContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dpFechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaTermino)
                    .addComponent(lblFechaInicio))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jpAddEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        jpAddEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Empresa"));

        lblRut.setText("Rut");

        txtRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRutKeyTyped(evt);
            }
        });

        lblNombFantasia.setText("Nombre fantasía");

        txtNombreFantasia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreFantasiaKeyTyped(evt);
            }
        });

        lblCliente.setText("Cliente");

        lblRegion.setText("Region");

        ddlRegion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ddlRegionItemStateChanged(evt);
            }
        });

        lblComuna.setText("Comuna");

        javax.swing.GroupLayout jpAddEmpresaLayout = new javax.swing.GroupLayout(jpAddEmpresa);
        jpAddEmpresa.setLayout(jpAddEmpresaLayout);
        jpAddEmpresaLayout.setHorizontalGroup(
            jpAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddEmpresaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jpAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRut)
                    .addComponent(lblNombFantasia)
                    .addComponent(lblCliente))
                .addGap(76, 76, 76)
                .addGroup(jpAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNombreFantasia)
                    .addComponent(txtRut)
                    .addComponent(ddlCliente, 0, 123, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegion)
                    .addComponent(lblComuna))
                .addGap(44, 44, 44)
                .addGroup(jpAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ddlRegion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ddlComuna, 0, 119, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpAddEmpresaLayout.setVerticalGroup(
            jpAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddEmpresaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jpAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRut)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegion)
                    .addComponent(ddlRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAddEmpresaLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jpAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblComuna)
                            .addComponent(ddlComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpAddEmpresaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jpAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombFantasia))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(ddlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        btnUpEmpresa.setText("MODIFICAR");
        btnUpEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpEmpresaActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUpEmpresaLayout = new javax.swing.GroupLayout(pnlUpEmpresa);
        pnlUpEmpresa.setLayout(pnlUpEmpresaLayout);
        pnlUpEmpresaLayout.setHorizontalGroup(
            pnlUpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUpEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpAddEmpresa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpAddContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlUpEmpresaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlAddEmpresaBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(185, 185, 185))
            .addGroup(pnlUpEmpresaLayout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(btnUpEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUpEmpresaLayout.setVerticalGroup(
            pnlUpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAddEmpresaBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jpAddContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpAddEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlUpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpEmpresa)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUpEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUpEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACKSPACE))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRutKeyTyped

    private void txtNombreFantasiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreFantasiaKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || c == KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreFantasiaKeyTyped

    private void ddlRegionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ddlRegionItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (this.ddlRegion.getSelectedIndex() > 0) {
                NegComuna negC = new NegComuna();
                DefaultComboBoxModel cModelC = (DefaultComboBoxModel) this.ddlComuna.getModel();
                cModelC.removeAllElements();
                cModelC.addElement("Comuna...");
                try {
                    listComuna = negC.getAllComuna();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "Error con la actualizacion de comunas.");
                }
                for (Comuna c : listComuna) {
                    if (c.getRegion().getIdRegion() == this.ddlRegion.getSelectedIndex()) {
                        cModelC.addElement(c.getNombre());
                    }
                }
            }
        }
    }//GEN-LAST:event_ddlRegionItemStateChanged

    /**
     * Método que realiza la llamada al metodo correspondiente, para cagar la
     * informacion y modificarla.
     *
     * @param id1 ID de Empresa
     * @param id2 ID de Contrato
     */
    public void cargaDeCampos(int id1, int id2) {
        NegEmpresa negE = new NegEmpresa();
        Empresa emp = negE.obtenerEmpresa(id2);
        //Lleando ID empresa, contrato

        //Llenado informacion contrato
        this.dpFechaInicio.setDate(emp.getContrato().getFechaInicio());
        this.dpFechaTermino.setDate(emp.getContrato().getFechaTermino());
        //Llenado informacion empresa
        this.txtRut.setText(emp.getRut());
        this.txtNombreFantasia.setText(emp.getNombreFantasia());
        this.lblIdClient.setText(String.valueOf(emp.getCliente().getIdCliente()));
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.ddlCliente.getModel();
        model.setSelectedItem(emp.getCliente().getPersona().getNombres());
        DefaultComboBoxModel cModelR = (DefaultComboBoxModel) this.ddlRegion.getModel();
        DefaultComboBoxModel cModelC = (DefaultComboBoxModel) this.ddlComuna.getModel();
        cModelR.setSelectedItem(emp.getComuna().getRegion().getNombre());
        cModelC.setSelectedItem(emp.getComuna().getNombre());
    }

    /**
     *
     * @param evt
     */
    private void btnUpEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpEmpresaActionPerformed

        try {
            if (!validateEmptys()) {
                Contrato c = new Contrato();
                c.setFechaInicio(this.dpFechaInicio.getDate());
                c.setFechaTermino(this.dpFechaTermino.getDate());
                NegContrato contrato = new NegContrato();
                contrato.addContrato(c);

                Empresa e = new Empresa();
                if (new validadorRunChileno(this.txtRut.getText()).validateRun() == true) {
                    e.setRut(this.txtRut.getText());
                    e.setNombreFantasia(this.txtNombreFantasia.getText());
                    e.setEstado('1');
                    e.setIdCliente(this.ddlCliente.getSelectedIndex());//cambiar por ID de cliente.
                    e.setIdContrato(contrato.obtenerContratoId());
                    e.setIdComuna(this.ddlComuna.getSelectedIndex());
                    NegEmpresa negE = new NegEmpresa();
                    negE.addEmpresa(e);

                    JOptionPane.showMessageDialog(rootPane, "Empresa ingresada correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "El RUT ingresado es invalido", "", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error inesperado" + ex.toString());
        }
    }//GEN-LAST:event_btnUpEmpresaActionPerformed

    /**
     * Método que valida que los campos del formulario de registro de empresa no
     * se encuentren vacios.
     *
     * @return campo true/false.
     */
    private boolean validateEmptys() {
        boolean campo = this.dpFechaInicio.getDate() == null;
        campo |= this.dpFechaTermino.getDate() == null;
        campo |= this.txtRut.getText().isEmpty();
        campo |= this.txtNombreFantasia.getText().isEmpty();
        campo |= this.ddlCliente.getSelectedIndex() == 0;
        campo |= this.ddlRegion.getSelectedIndex() == 0;
        campo |= this.ddlComuna.getSelectedIndex() == 0;
        return campo;
    }

    /**
     * Método que establece los limites de caracteres por campo de texto en el
     * formulario de registro de empresa.
     *
     */
    public void limits() {
        Date fechaInicio = new Date();
        this.dpFechaInicio.setMinSelectableDate(fechaInicio);
        Date fechaTermino = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaTermino);
        calendar.add(Calendar.DAY_OF_YEAR, 365);
        this.dpFechaTermino.setMinSelectableDate(calendar.getTime());
        this.txtRut.setDocument(new jTextFieldCharLimits(9));
        this.txtNombreFantasia.setDocument(new jTextFieldCharLimits(30));

        JTextFieldDateEditor editor = (JTextFieldDateEditor) this.dpFechaInicio.getDateEditor();
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) this.dpFechaTermino.getDateEditor();
        editor.setEditable(false);
        editor2.setEditable(false);
    }

    /**
     *
     * @param evt
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     *
     * @param evt
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        NegRegion negR = new NegRegion();
        NegComuna negC = new NegComuna();
        NegCliente negCli = new NegCliente();

        DefaultComboBoxModel cModelR = (DefaultComboBoxModel) this.ddlRegion.getModel();
        DefaultComboBoxModel cModelC = (DefaultComboBoxModel) this.ddlComuna.getModel();
        DefaultComboBoxModel cModelCli = (DefaultComboBoxModel) this.ddlCliente.getModel();

        cModelR.addElement("Región...");
        cModelC.addElement("Comuna...");
        cModelCli.addElement("Cliente...");
        try {
            listRegion = negR.getAllRegion();
            listComuna = negC.getAllComuna();
            listCliente = negCli.getAllCliente();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error inesperado (combobox)");
        }

        for (Region r : listRegion) {
            cModelR.addElement(r.getNombre());
        }

        for (Comuna c : listComuna) {
            if (c.getRegion().getIdRegion() == 1) {
                cModelC.addElement(c.getNombre());
            }
        }

        for (Cliente e : listCliente) {
            cModelCli.addElement(e.getPersona().getNombres());
        }
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnUpEmpresa;
    private javax.swing.JComboBox<String> ddlCliente;
    private javax.swing.JComboBox<String> ddlComuna;
    private javax.swing.JComboBox<String> ddlRegion;
    private com.toedter.calendar.JDateChooser dpFechaInicio;
    private com.toedter.calendar.JDateChooser dpFechaTermino;
    private javax.swing.JPanel jpAddContrato;
    private javax.swing.JPanel jpAddEmpresa;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblComuna;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblFechaTermino;
    private javax.swing.JLabel lblIdClient;
    private javax.swing.JLabel lblNombFantasia;
    private javax.swing.JLabel lblRegion;
    private javax.swing.JLabel lblRut;
    private javax.swing.JLabel lblTituloEmpresa;
    private javax.swing.JPanel pnlAddEmpresaBanner;
    private javax.swing.JPanel pnlUpEmpresa;
    private javax.swing.JTextField txtNombreFantasia;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}