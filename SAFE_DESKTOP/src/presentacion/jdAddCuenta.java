package presentacion;

//Importaciones
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Comuna;
import modelo.Persona;
import modelo.Region;
import modelo.Empresa;
import modelo.Trabajador;
import modelo.Usuario;
import negocio.NegCliente;
import negocio.NegComuna;
import negocio.NegEmpresa;
import negocio.NegPersona;
import negocio.NegTrabajador;
import negocio.NegUsuario;
import negocio.NegRegion;

/**
 * @author Ignacio Antillanca
 * @version 1.2
 */
public class jdAddCuenta extends javax.swing.JDialog {
    //Variables
    List<Comuna> listComuna;
    List<Region> listRegion;
    List<Empresa> listEmpresa;
    
    /**
     * Constructor que inicializa el modal del registro de cuentas.
     * @param parent
     * @param modal
     */
    public jdAddCuenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds((ancho / 2) - (this.getWidth() / 2), (alto / 2) - (this.getHeight() / 2), 800, 600); 
        this.setLocationRelativeTo(this);
        this.panelAdicionalDisable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAddCuenta = new javax.swing.JPanel();
        pnlAddCuentaBanner = new javax.swing.JPanel();
        lblTituloCuenta = new javax.swing.JLabel();
        jpAddUsuario = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblPass2 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        ddlRol = new javax.swing.JComboBox<>();
        txtPass = new javax.swing.JPasswordField();
        txtPass2 = new javax.swing.JPasswordField();
        jpAddPersona = new javax.swing.JPanel();
        lblRun = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblAppPaterno = new javax.swing.JLabel();
        lblAppMaterno = new javax.swing.JLabel();
        txtRun = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtAppPaterno = new javax.swing.JTextField();
        txtAppMaterno = new javax.swing.JTextField();
        btnAgregarCuenta = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jpAdicional = new javax.swing.JPanel();
        lblTelefono = new javax.swing.JLabel();
        lblComuna = new javax.swing.JLabel();
        lblRegion = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblFechaContra = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        ddlRegion = new javax.swing.JComboBox<>();
        ddlComuna = new javax.swing.JComboBox<>();
        txtCargo = new javax.swing.JTextField();
        dpFechaContrato = new org.jdesktop.swingx.JXDatePicker();
        lblIdEmp = new javax.swing.JLabel();
        ddlIdEmpresa = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlAddCuenta.setBackground(new java.awt.Color(255, 255, 255));
        pnlAddCuenta.setPreferredSize(new java.awt.Dimension(800, 600));

        pnlAddCuentaBanner.setBackground(new java.awt.Color(17, 48, 142));

        lblTituloCuenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTituloCuenta.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloCuenta.setText("REGISTRO DE NUEVA CUENTA DE USUARIO");

        javax.swing.GroupLayout pnlAddCuentaBannerLayout = new javax.swing.GroupLayout(pnlAddCuentaBanner);
        pnlAddCuentaBanner.setLayout(pnlAddCuentaBannerLayout);
        pnlAddCuentaBannerLayout.setHorizontalGroup(
            pnlAddCuentaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddCuentaBannerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225))
        );
        pnlAddCuentaBannerLayout.setVerticalGroup(
            pnlAddCuentaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddCuentaBannerLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTituloCuenta)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jpAddUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpAddUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Usuario"));

        lblUsername.setText("Nombre de Usuario");

        lblPass.setText("Contraseña");

        lblPass2.setText("Repita contraseña");

        lblCorreo.setText("Correo electronico");

        lblRol.setText("Rol");

        ddlRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un rol", "Administrador", "Supervisor", "Cliente", "Trabajador", "Ingeniero", "Tecnico", "Medico" }));
        ddlRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlRolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAddUsuarioLayout = new javax.swing.GroupLayout(jpAddUsuario);
        jpAddUsuario.setLayout(jpAddUsuarioLayout);
        jpAddUsuarioLayout.setHorizontalGroup(
            jpAddUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddUsuarioLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jpAddUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername)
                    .addComponent(lblPass)
                    .addComponent(lblPass2))
                .addGap(18, 18, 18)
                .addGroup(jpAddUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(txtPass)
                    .addComponent(txtPass2))
                .addGap(114, 114, 114)
                .addGroup(jpAddUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRol)
                    .addComponent(lblCorreo))
                .addGap(33, 33, 33)
                .addGroup(jpAddUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(ddlRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jpAddUsuarioLayout.setVerticalGroup(
            jpAddUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpAddUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(lblCorreo)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jpAddUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpAddUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAddUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPass2)
                        .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAddUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ddlRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRol)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpAddPersona.setBackground(new java.awt.Color(255, 255, 255));
        jpAddPersona.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Persona"));

        lblRun.setText("Run");

        lblNombres.setText("Nombres");

        lblAppPaterno.setText("Apellido Paterno");

        lblAppMaterno.setText("Apellido materno");

        javax.swing.GroupLayout jpAddPersonaLayout = new javax.swing.GroupLayout(jpAddPersona);
        jpAddPersona.setLayout(jpAddPersonaLayout);
        jpAddPersonaLayout.setHorizontalGroup(
            jpAddPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddPersonaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAddPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpAddPersonaLayout.createSequentialGroup()
                        .addComponent(lblRun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAddPersonaLayout.createSequentialGroup()
                        .addGroup(jpAddPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAppPaterno)
                            .addComponent(lblNombres))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpAddPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAppPaterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpAddPersonaLayout.createSequentialGroup()
                        .addComponent(lblAppMaterno)
                        .addGap(18, 18, 18)
                        .addComponent(txtAppMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jpAddPersonaLayout.setVerticalGroup(
            jpAddPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddPersonaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAddPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRun)
                    .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpAddPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jpAddPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAppPaterno)
                    .addComponent(txtAppPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpAddPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAppMaterno)
                    .addComponent(txtAppMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregarCuenta.setText("AGREGAR");
        btnAgregarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCuentaActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jpAdicional.setBackground(new java.awt.Color(255, 255, 255));
        jpAdicional.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion Adicional"));

        lblTelefono.setText("Teléfono");

        lblComuna.setText("Comuna");

        lblRegion.setText("Region");

        lblCargo.setText("Cargo");

        lblFechaContra.setText("Fecha Contrato");

        ddlRegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ddlRegion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ddlRegionItemStateChanged(evt);
            }
        });

        ddlComuna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblIdEmp.setText("Empresa");

        ddlIdEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jpAdicionalLayout = new javax.swing.GroupLayout(jpAdicional);
        jpAdicional.setLayout(jpAdicionalLayout);
        jpAdicionalLayout.setHorizontalGroup(
            jpAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAdicionalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpAdicionalLayout.createSequentialGroup()
                        .addComponent(lblTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefono))
                    .addGroup(jpAdicionalLayout.createSequentialGroup()
                        .addComponent(lblComuna)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ddlComuna, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpAdicionalLayout.createSequentialGroup()
                        .addComponent(lblRegion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ddlRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jpAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaContra)
                    .addComponent(lblCargo)
                    .addComponent(lblIdEmp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dpFechaContrato, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(txtCargo)
                    .addComponent(ddlIdEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpAdicionalLayout.setVerticalGroup(
            jpAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAdicionalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaContra)
                    .addComponent(dpFechaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegion)
                    .addComponent(ddlRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCargo)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComuna)
                    .addComponent(ddlComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdEmp)
                    .addComponent(ddlIdEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAddCuentaLayout = new javax.swing.GroupLayout(pnlAddCuenta);
        pnlAddCuenta.setLayout(pnlAddCuentaLayout);
        pnlAddCuentaLayout.setHorizontalGroup(
            pnlAddCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAddCuentaBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlAddCuentaLayout.createSequentialGroup()
                .addGroup(pnlAddCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddCuentaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlAddCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpAddUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlAddCuentaLayout.createSequentialGroup()
                                .addComponent(jpAddPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jpAdicional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnlAddCuentaLayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(btnAgregarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAddCuentaLayout.setVerticalGroup(
            pnlAddCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddCuentaLayout.createSequentialGroup()
                .addComponent(pnlAddCuentaBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpAddUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAddCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpAddPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpAdicional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlAddCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarCuenta)
                    .addComponent(btnCancelar))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAddCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAddCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que deshabilita el panel con la informacion adicional necesaria
     * para el registro de clientes o trabajadores
     */
    public void panelAdicionalDisable(){
        for (Component cp : this.jpAdicional.getComponents()) {
            cp.setEnabled(false);
        }
    }
    
    /**
     * Método que habilita el panel con la informacion adicional necesaria
     * para el registro de clientes o trabajadores
     */
    public void panelAdicionalEnable(){
        for (Component cp : this.jpAdicional.getComponents()) {
            cp.setEnabled(true);
        }
    }
    
    /**
     * Método que obtiene los datos ingresados en el formulario de cuenta de
     * usuario nueva y los envia a su respectivo controller.
     *
     * @param evt
     */
    private void btnAgregarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCuentaActionPerformed
        if (!validateEmptys()) {

            try {
                Usuario u = new Usuario();
                u.setUsername(this.txtUsername.getText());
                u.setClave(String.valueOf(this.txtPass.getPassword()));
                u.setEmail(this.txtCorreo.getText());
                u.setRol(this.ddlRol.getSelectedIndex());

                NegUsuario user = new NegUsuario();
                if (user.addUsuario(u)) {
                    Persona p = new Persona();
                    p.setRun(this.txtRun.getText());
                    p.setNombres(this.txtNombres.getText());
                    p.setAppPaterno(this.txtAppPaterno.getText());
                    p.setAppMaterno(this.txtAppMaterno.getText());
                    p.setIdUser(user.obtenerUser()); //Se ingesa el id autogenerado de usuario a persona

                    NegPersona per = new NegPersona();
                    per.addPersona(p); // Se ingresa una persona del tipo (admin, ingeniero, tecnico, supervisor o medico) 

                    switch (this.ddlRol.getSelectedIndex()) {
                        case 3:
                            Cliente cl = new Cliente();
                            cl.setTelefono(this.txtTelefono.getText());
                            cl.setComunaId(this.ddlComuna.getSelectedIndex());
                            cl.setIdPersona(per.obtenerPersonaId());
                            NegCliente neg = new NegCliente();
                            neg.addCliente(cl);
                            JOptionPane.showMessageDialog(rootPane, "Cuenta de Cliente registrada correctamente");
                            break;
                        case 4:
                            Trabajador tr = new Trabajador();
                            tr.setTelefono(this.txtTelefono.getText());
                            tr.setCargo(this.txtCargo.getText());
                            tr.setFechaContrato(this.dpFechaContrato.getDate());
                            tr.setIdPersona(per.obtenerPersonaId());
                            tr.setIdEmpresa(this.ddlIdEmpresa.getSelectedIndex());
                            NegTrabajador negT = new NegTrabajador();
                            negT.addTrabajador(tr);
                            JOptionPane.showMessageDialog(rootPane, "Cuenta de Trabajador registrada correctamente");
                            break;
                        default:
                            JOptionPane.showMessageDialog(rootPane, "Cuenta de usuario registrada correctamente");
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre de usuario ya se encuentra registrado", "", JOptionPane.ERROR_MESSAGE);
                }
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(rootPane, "Ha ocurrdo un error inesperado: " + e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAgregarCuentaActionPerformed

    /**
     * Método que valida que los campos del formulario de usuario no esten
     * vacios.
     *
     * @return campo true/false
     */
    private boolean validateEmptys() {
        boolean campo = this.txtUsername.getText().isEmpty();
        campo |= this.txtPass.getText().isEmpty();
        campo |= this.txtPass2.getText().isEmpty();
        campo |= this.txtCorreo.getText().isEmpty();
        campo |= this.ddlRol.getSelectedIndex() == 0;
        campo |= this.txtRun.getText().isEmpty();
        campo |= this.txtNombres.getText().isEmpty();
        campo |= this.txtAppPaterno.getText().isEmpty();
        campo |= this.txtAppMaterno.getText().isEmpty();
        if (this.ddlRol.getSelectedIndex() == 3) {
            campo |= this.txtTelefono.getText().isEmpty();
            campo |= this.ddlRegion.getSelectedIndex() == 0;
            campo |= this.ddlComuna.getSelectedIndex() == 0;
        } else if (this.ddlRol.getSelectedIndex() == 4) {
            campo |= this.txtTelefono.getText().isEmpty();
            campo |= this.dpFechaContrato.getDate() == null;
            campo |= this.txtCargo.getText().isEmpty();
            campo |= this.ddlIdEmpresa.getSelectedIndex() == 0;
        }
        return campo;
    }
    
    /**
     * Accion del boton "CANCELAR" del modal de registro de cuenta.
     * Termina el proceso, cerrando la ventana emergente
     * @param evt 
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Método que modifica el formulario de registro de cuenta en el caso
     * que el tipo de cuenta sea cliente o trabajador
     * @param evt 
     */
    private void ddlRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddlRolActionPerformed
        switch (this.ddlRol.getSelectedIndex()) {
            case 3:
                panelAdicionalEnable();
                this.dpFechaContrato.setEnabled(false);
                this.txtCargo.setEnabled(false);
                this.ddlIdEmpresa.setEnabled(false);
                break;
            case 4:
                panelAdicionalEnable();
                this.ddlComuna.setEnabled(false);
                this.ddlRegion.setEnabled(false);
                break;
            default:
                panelAdicionalDisable();
                break;
        }
    }//GEN-LAST:event_ddlRolActionPerformed

    /**
     * Método que realiza la carga de los jcombobox al momento de mostrar la
     * ventana.
     *
     * @param evt
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        NegRegion negR = new NegRegion();
        NegComuna negC = new NegComuna();
        NegEmpresa negE = new NegEmpresa();

        DefaultComboBoxModel cModelR = (DefaultComboBoxModel) this.ddlRegion.getModel();
        DefaultComboBoxModel cModelC = (DefaultComboBoxModel) this.ddlComuna.getModel();
        DefaultComboBoxModel cModelE = (DefaultComboBoxModel) this.ddlIdEmpresa.getModel();

        cModelR.removeAllElements();
        cModelC.removeAllElements();
        cModelE.removeAllElements();

        cModelR.addElement("Región...");
        cModelC.addElement("Comuna...");
        cModelE.addElement("Empresa...");
        try {
            listRegion = negR.getAllRegion();
            listComuna = negC.getAllComuna();
            listEmpresa = negE.getAllEmpresa();
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

        for (Empresa e : listEmpresa) {
            cModelE.addElement(e.getNombreFantasia());
        }
    }//GEN-LAST:event_formWindowOpened

    /**
     * Metodo que filtra las comunas en base a la region seleccionada.
     * @param evt 
     */
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
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdAddCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdAddCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdAddCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdAddCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdAddCuenta dialog = new jdAddCuenta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCuenta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> ddlComuna;
    private javax.swing.JComboBox<String> ddlIdEmpresa;
    private javax.swing.JComboBox<String> ddlRegion;
    private javax.swing.JComboBox<String> ddlRol;
    private org.jdesktop.swingx.JXDatePicker dpFechaContrato;
    private javax.swing.JPanel jpAddPersona;
    private javax.swing.JPanel jpAddUsuario;
    private javax.swing.JPanel jpAdicional;
    private javax.swing.JLabel lblAppMaterno;
    private javax.swing.JLabel lblAppPaterno;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblComuna;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFechaContra;
    private javax.swing.JLabel lblIdEmp;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPass2;
    private javax.swing.JLabel lblRegion;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblRun;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTituloCuenta;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlAddCuenta;
    private javax.swing.JPanel pnlAddCuentaBanner;
    private javax.swing.JTextField txtAppMaterno;
    private javax.swing.JTextField txtAppPaterno;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPass2;
    private javax.swing.JTextField txtRun;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
