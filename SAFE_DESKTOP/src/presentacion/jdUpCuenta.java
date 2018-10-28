//Paquete
package presentacion;

//Importaciones
import com.sun.glass.events.KeyEvent;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import presentacion.validaciones.jTextFieldCharLimits;
import presentacion.validaciones.validadorCorreo;
import presentacion.validaciones.validadorRunChileno;

/**
 * @author Ignacio Antillanca
 * @version 1.2
 */
public class jdUpCuenta extends javax.swing.JDialog {

    /**
     * Variables utilizadas.
     */
    List<Comuna> listComuna;
    List<Region> listRegion;
    List<Empresa> listEmpresa;

    /**
     * Constructor que inicializa el modal del registro de cuentas.
     *
     * @param parent ventana jfPrincipal.
     * @param modal
     */
    public jdUpCuenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limits();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds((ancho / 2) - (this.getWidth() / 2), (alto / 2) - (this.getHeight() / 2), 800, 600);
        this.setLocationRelativeTo(this);
        this.panelAdicionalDisable();
    }

    /**
     * Método que realiza la llamada al metodo correspondiente, para cagar la
     * informacion a mostrar.
     *
     * @param idUsu ID de usuario seleccionado en la tabla cuentas
     * @param idRol ID de rol seleccionado en la tabla cuentas
     */
    public void cargaDeCampos(int idUsu, int idRol) {
        switch (idRol) {
            case 3:
                cargaDeCliente(idUsu);
                break;
            case 4:
                cargaDeTrabajador(idUsu);
                break;
            default:
                cargaDeUsuario(idUsu);
                break;
        }
    }

    /**
     * Método que recibe la informacion entregada por la base de datos en base
     * al id de un usuario del tipo cliente, seteando los datos en los
     * respectivos campos del formulario.
     *
     * @param idUsu ID de usuario seleccionado en la tabla cuenta.
     */
    public void cargaDeCliente(int idUsu) {
        NegCliente negC = new NegCliente();
        Cliente cliente = negC.obtenerCliente(idUsu);
        //Llenado ID usu
        this.lblIdUsu.setText(String.valueOf(idUsu));
        this.lblIdPer.setText(String.valueOf(cliente.getPersona().getIdPersona()));
        this.lblIdCli.setText(String.valueOf(cliente.getIdCliente()));

        //Llenado campos de usuario
        this.txtUsername.setText(cliente.getPersona().getUsuario().getUsername());
        this.txtPass.setText("");
        this.txtPass2.setText("");
        this.txtCorreo.setText(cliente.getPersona().getUsuario().getEmail());
        this.ddlRol.setSelectedIndex(cliente.getPersona().getUsuario().getRol());
        //Llenado campos de persona
        this.txtRun.setText(cliente.getPersona().getRun());
        this.txtNombres.setText(cliente.getPersona().getNombres());
        this.txtAppPaterno.setText(cliente.getPersona().getAppPaterno());
        this.txtAppMaterno.setText(cliente.getPersona().getAppMaterno());
        //Llenado campos de cliente
        this.txtTelefono.setText(cliente.getTelefono());
        DefaultComboBoxModel cModelR = (DefaultComboBoxModel) this.ddlRegion.getModel();
        DefaultComboBoxModel cModelC = (DefaultComboBoxModel) this.ddlComuna.getModel();
        cModelR.setSelectedItem(cliente.getComuna().getRegion().getNombre());
        cModelC.setSelectedItem(cliente.getComuna().getNombre());
    }

    /**
     * Método que recibe la informacion entregada por la base de datos en base
     * al id de un usuario del tipo trabajador, seteando los datos en los
     * respectivos campos del formulario.
     *
     * @param idUsu ID de usuario seleccionado en la tabla cuenta.
     */
    public void cargaDeTrabajador(int idUsu) {
        NegTrabajador negT = new NegTrabajador();
        Trabajador trabajador = negT.obtenerTrabajador(idUsu);
        //Llenado ID usu
        this.lblIdUsu.setText(String.valueOf(idUsu));
        this.lblIdPer.setText(String.valueOf(trabajador.getPersona().getIdPersona()));
        this.lblIdTra.setText(String.valueOf(trabajador.getIdTrabajador()));
        //Llenado campos de usuario
        this.txtUsername.setText(trabajador.getPersona().getUsuario().getUsername());
        this.txtPass.setText("");
        this.txtPass2.setText("");
        this.txtCorreo.setText(trabajador.getPersona().getUsuario().getEmail());
        this.ddlRol.setSelectedIndex(trabajador.getPersona().getUsuario().getRol());
        //Llenado campos de persona
        this.txtRun.setText(trabajador.getPersona().getRun());
        this.txtNombres.setText(trabajador.getPersona().getNombres());
        this.txtAppPaterno.setText(trabajador.getPersona().getAppPaterno());
        this.txtAppMaterno.setText(trabajador.getPersona().getAppMaterno());
        //Llenado campos de trabajador
        this.txtTelefono.setText(trabajador.getTelefono());
        this.dpFechaContrato.setDate(trabajador.getFechaContrato());
        this.txtCargo.setText(trabajador.getCargo());
        DefaultComboBoxModel cModelE = (DefaultComboBoxModel) this.ddlIdEmpresa.getModel();
        cModelE.setSelectedItem(trabajador.getEmpresa().getNombreFantasia());
    }

    /**
     * Método que recibe la informacion entregada por la base de datos en base
     * al id de un usuario, seteando los datos en los respectivos campos del
     * formulario.
     *
     * @param idUsu ID de usuario seleccionado en la tabla cuenta.
     */
    public void cargaDeUsuario(int idUsu) {
        NegPersona negP = new NegPersona();
        Persona pr = negP.obtenerPersona(idUsu);
        //Llenado ID usu
        this.lblIdUsu.setText(String.valueOf(idUsu));
        this.lblIdPer.setText(String.valueOf(pr.getIdPersona()));
        //Llenado campos de usuario
        this.txtUsername.setText(pr.getUsuario().getUsername());
        this.txtPass.setText("");
        this.txtPass2.setText("");
        this.txtCorreo.setText(pr.getUsuario().getEmail());
        this.ddlRol.setSelectedIndex(pr.getUsuario().getRol());
        //Llenado campos de persona
        this.txtRun.setText(pr.getRun());
        this.txtNombres.setText(pr.getNombres());
        this.txtAppPaterno.setText(pr.getAppPaterno());
        this.txtAppMaterno.setText(pr.getAppMaterno());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUpCuenta = new javax.swing.JPanel();
        pnlUpCuentaBanner = new javax.swing.JPanel();
        lblTituloCuenta = new javax.swing.JLabel();
        lblIdUsu = new javax.swing.JLabel();
        lblIdPer = new javax.swing.JLabel();
        lblIdCli = new javax.swing.JLabel();
        lblIdTra = new javax.swing.JLabel();
        jpUpUsuario = new javax.swing.JPanel();
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
        jpUpPersona = new javax.swing.JPanel();
        lblRun = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblAppPaterno = new javax.swing.JLabel();
        lblAppMaterno = new javax.swing.JLabel();
        txtRun = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtAppPaterno = new javax.swing.JTextField();
        txtAppMaterno = new javax.swing.JTextField();
        btnModificarCuenta = new javax.swing.JButton();
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
        lblIdEmp = new javax.swing.JLabel();
        ddlIdEmpresa = new javax.swing.JComboBox<>();
        dpFechaContrato = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlUpCuenta.setBackground(new java.awt.Color(255, 255, 255));
        pnlUpCuenta.setPreferredSize(new java.awt.Dimension(800, 600));

        pnlUpCuentaBanner.setBackground(new java.awt.Color(17, 48, 142));

        lblTituloCuenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTituloCuenta.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloCuenta.setText("MODIFICACION DE CUENTA DE USUARIO");

        lblIdUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblIdUsu.setText("ID Usu: ");

        lblIdPer.setForeground(new java.awt.Color(255, 255, 255));
        lblIdPer.setText("ID Per:");

        lblIdCli.setForeground(new java.awt.Color(255, 255, 255));
        lblIdCli.setText("ID Cli:");

        lblIdTra.setForeground(new java.awt.Color(255, 255, 255));
        lblIdTra.setText("ID Tra:");

        javax.swing.GroupLayout pnlUpCuentaBannerLayout = new javax.swing.GroupLayout(pnlUpCuentaBanner);
        pnlUpCuentaBanner.setLayout(pnlUpCuentaBannerLayout);
        pnlUpCuentaBannerLayout.setHorizontalGroup(
            pnlUpCuentaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpCuentaBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUpCuentaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdUsu)
                    .addComponent(lblIdPer))
                .addGap(18, 18, 18)
                .addGroup(pnlUpCuentaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUpCuentaBannerLayout.createSequentialGroup()
                        .addComponent(lblIdCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTituloCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225))
                    .addGroup(pnlUpCuentaBannerLayout.createSequentialGroup()
                        .addComponent(lblIdTra)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlUpCuentaBannerLayout.setVerticalGroup(
            pnlUpCuentaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpCuentaBannerLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlUpCuentaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloCuenta)
                    .addComponent(lblIdUsu)
                    .addComponent(lblIdCli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUpCuentaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdPer)
                    .addComponent(lblIdTra))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jpUpUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpUpUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Usuario"));

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

        javax.swing.GroupLayout jpUpUsuarioLayout = new javax.swing.GroupLayout(jpUpUsuario);
        jpUpUsuario.setLayout(jpUpUsuarioLayout);
        jpUpUsuarioLayout.setHorizontalGroup(
            jpUpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUpUsuarioLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jpUpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername)
                    .addComponent(lblPass)
                    .addComponent(lblPass2))
                .addGap(18, 18, 18)
                .addGroup(jpUpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(txtPass)
                    .addComponent(txtPass2))
                .addGap(114, 114, 114)
                .addGroup(jpUpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRol)
                    .addComponent(lblCorreo))
                .addGap(33, 33, 33)
                .addGroup(jpUpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(ddlRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jpUpUsuarioLayout.setVerticalGroup(
            jpUpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUpUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpUpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(lblCorreo)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jpUpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpUpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpUpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPass2)
                        .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpUpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ddlRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRol)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpUpPersona.setBackground(new java.awt.Color(255, 255, 255));
        jpUpPersona.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Persona"));

        lblRun.setText("Run");

        lblNombres.setText("Nombres");

        lblAppPaterno.setText("Apellido Paterno");

        lblAppMaterno.setText("Apellido materno");

        txtRun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRunKeyTyped(evt);
            }
        });

        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        txtAppPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAppPaternoKeyTyped(evt);
            }
        });

        txtAppMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAppMaternoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jpUpPersonaLayout = new javax.swing.GroupLayout(jpUpPersona);
        jpUpPersona.setLayout(jpUpPersonaLayout);
        jpUpPersonaLayout.setHorizontalGroup(
            jpUpPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUpPersonaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpUpPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpUpPersonaLayout.createSequentialGroup()
                        .addComponent(lblRun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpUpPersonaLayout.createSequentialGroup()
                        .addGroup(jpUpPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAppPaterno)
                            .addComponent(lblNombres))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpUpPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAppPaterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpUpPersonaLayout.createSequentialGroup()
                        .addComponent(lblAppMaterno)
                        .addGap(18, 18, 18)
                        .addComponent(txtAppMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jpUpPersonaLayout.setVerticalGroup(
            jpUpPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUpPersonaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpUpPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRun)
                    .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpUpPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jpUpPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAppPaterno)
                    .addComponent(txtAppPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpUpPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAppMaterno)
                    .addComponent(txtAppMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnModificarCuenta.setText("MODIFICAR");
        btnModificarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCuentaActionPerformed(evt);
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

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        ddlRegion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ddlRegionItemStateChanged(evt);
            }
        });

        txtCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCargoKeyTyped(evt);
            }
        });

        lblIdEmp.setText("Empresa");

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
                    .addComponent(txtCargo)
                    .addComponent(ddlIdEmpresa, 0, 106, Short.MAX_VALUE)
                    .addComponent(dpFechaContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpAdicionalLayout.setVerticalGroup(
            jpAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAdicionalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTelefono)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFechaContra))
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

        javax.swing.GroupLayout pnlUpCuentaLayout = new javax.swing.GroupLayout(pnlUpCuenta);
        pnlUpCuenta.setLayout(pnlUpCuentaLayout);
        pnlUpCuentaLayout.setHorizontalGroup(
            pnlUpCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUpCuentaBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlUpCuentaLayout.createSequentialGroup()
                .addGroup(pnlUpCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUpCuentaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlUpCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpUpUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlUpCuentaLayout.createSequentialGroup()
                                .addComponent(jpUpPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jpAdicional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnlUpCuentaLayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(btnModificarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUpCuentaLayout.setVerticalGroup(
            pnlUpCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpCuentaLayout.createSequentialGroup()
                .addComponent(pnlUpCuentaBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpUpUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUpCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpUpPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpAdicional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlUpCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificarCuenta)
                    .addComponent(btnCancelar))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUpCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUpCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que deshabilita el panel con la informacion adicional necesaria
     * para el registro de clientes o trabajadores
     */
    public void panelAdicionalDisable() {
        for (Component cp : this.jpAdicional.getComponents()) {
            cp.setEnabled(false);
        }
    }

    /**
     * Método que habilita el panel con la informacion adicional necesaria para
     * el registro de clientes o trabajadores
     */
    public void panelAdicionalEnable() {
        for (Component cp : this.jpAdicional.getComponents()) {
            cp.setEnabled(true);
        }
    }

    /**
     * Método que obtiene los datos ingresados en el formulario de cuenta de
     * usuario nueva y los envia a su respectivo controller.
     *
     * @param evt evento que indica que se realizo una accion definida
     * (ActionEvent)
     */
    private void btnModificarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCuentaActionPerformed
        if (!validateEmptys()) {
            if (validateDuplicate()) {
                try {
                    Usuario u = new Usuario();
                    u.setIdUsuario(Integer.parseInt(this.lblIdUsu.getText()));
                    u.setUsername(this.txtUsername.getText());
                    if (String.valueOf(this.txtPass.getPassword()).equals(String.valueOf(this.txtPass2.getPassword()))) {
                        u.setClave(String.valueOf(this.txtPass.getPassword()));
                        if (new validadorCorreo(this.txtCorreo.getText()).validateEmail() == true) {
                            u.setEmail(this.txtCorreo.getText());
                            u.setRol(this.ddlRol.getSelectedIndex());
                            if (new validadorRunChileno(this.txtRun.getText()).validateRun() == true) {
                                NegUsuario user = new NegUsuario();
                                user.upUsuario(u);
                                Persona p = new Persona();
                                p.setIdPersona(Integer.parseInt(this.lblIdPer.getText()));
                                p.setRun(this.txtRun.getText()); //Agregar validación de ingreso
                                p.setNombres(this.txtNombres.getText());
                                p.setAppPaterno(this.txtAppPaterno.getText());
                                p.setAppMaterno(this.txtAppMaterno.getText());
                                p.setIdUser(Integer.parseInt(this.lblIdUsu.getText())); //Se ingesa el id autogenerado de usuario a persona

                                NegPersona per = new NegPersona();
                                per.upPersona(p);
                                switch (this.ddlRol.getSelectedIndex()) {
                                    case 3:
                                        Cliente cl = new Cliente();
                                        cl.setIdCliente(Integer.parseInt(this.lblIdCli.getText()));
                                        cl.setTelefono(this.txtTelefono.getText());
                                        cl.setComunaId(this.ddlComuna.getSelectedIndex());
                                        cl.setIdPersona(p.getIdPersona());
                                        NegCliente neg = new NegCliente();
                                        neg.upCliente(cl);
                                        JOptionPane.showMessageDialog(rootPane, "Cuenta de Cliente modificada correctamente");
                                        break;
                                    case 4:
                                        Trabajador tr = new Trabajador();
                                        tr.setIdTrabajador(Integer.parseInt(this.lblIdTra.getText()));
                                        tr.setTelefono(this.txtTelefono.getText());
                                        tr.setCargo(this.txtCargo.getText());
                                        tr.setFechaContrato(this.dpFechaContrato.getDate());
                                        tr.setIdPersona(p.getIdPersona());
                                        tr.setIdEmpresa(this.ddlIdEmpresa.getSelectedIndex());
                                        NegTrabajador negT = new NegTrabajador();
                                        negT.upTrabajador(tr);
                                        JOptionPane.showMessageDialog(rootPane, "Cuenta de Trabajador modificada correctamente");
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(rootPane, "Cuenta de Usuario modificada correctamente");
                                        break;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El RUN ingresado no es valido.", "", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El formato del correo es incorrecto", "", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado", "", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    System.out.println("ERROR EN LA MODIFICACION" + ex.toString());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnModificarCuentaActionPerformed

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
     * Accion del boton "CANCELAR" del modal de registro de cuenta. Termina el
     * proceso, cerrando la ventana emergente
     *
     * @param evt evento que indica que se realizo una accion definida
     * (ActionEvent)
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Método que modifica el formulario de registro de cuenta en el caso que el
     * tipo de cuenta sea cliente o trabajador
     *
     * @param evt evento que indica que se realizo una accion definida
     * (ActionEvent)
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
     * @param evt evento que indica que se realizo una accion definida
     * (WindowEvent)
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        NegRegion negR = new NegRegion();
        NegComuna negC = new NegComuna();
        NegEmpresa negE = new NegEmpresa();

        DefaultComboBoxModel cModelR = (DefaultComboBoxModel) this.ddlRegion.getModel();
        DefaultComboBoxModel cModelC = (DefaultComboBoxModel) this.ddlComuna.getModel();
        DefaultComboBoxModel cModelE = (DefaultComboBoxModel) this.ddlIdEmpresa.getModel();

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
     *
     * @param evt evento que indica que se realizo una accion definida
     * (ItemEvent)
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
                listComuna.stream().filter((c) -> (c.getRegion().getIdRegion() == this.ddlRegion.getSelectedIndex())).forEachOrdered((c) -> {
                    cModelC.addElement(c.getNombre());
                });
            }
        }
    }//GEN-LAST:event_ddlRegionItemStateChanged

    /**
     * Función que evita escribir caracteres diferentes a números, en el campos
     * de ingreso del RUN.
     *
     * @param evt evento que indica que se realizo una accion definida
     * (KeyEvent)
     */
    private void txtRunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRunKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACKSPACE))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRunKeyTyped

    /**
     * Función que evita escribir caracteres numericos o simbolos, en el campo
     * de nombres.
     *
     * @param evt evento que indica que se realizo una accion definida
     * (KeyEvent)
     */
    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || c == KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombresKeyTyped

    /**
     * Función que evita escribir caracteres numericos o simbolos, en el campo
     * de apellido paterno.
     *
     * @param evt evento que indica que se realizo una accion definida
     * (KeyEvent)
     */
    private void txtAppPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAppPaternoKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || c == KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAppPaternoKeyTyped

    /**
     * Función que evita escribir caracteres numericos o simbolos, en el campo
     * de apellido materno.
     *
     * @param evt evento que indica que se realizo una accion definida
     * (KeyEvent)
     */
    private void txtAppMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAppMaternoKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || c == KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAppMaternoKeyTyped
    /**
     * Función que evita escribir caracteres diferentes a números, en el campos
     * de ingreso del RUN.
     *
     * @param evt evento que indica que se realizo una accion definida
     * (KeyEvent)
     */
    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACKSPACE))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    /**
     * Función que evita escribir caracteres numericos o simbolos, en el campo
     * de cargo.
     *
     * @param evt evento que indica que se realizo una accion definida
     * (KeyEvent)
     */
    private void txtCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargoKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || c == KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCargoKeyTyped

    /**
     * Método que verifica que el nombre de usuario o run ingresado, no se
     * encuentren ya registrados.
     *
     * @return true o false, si existe algún dato ya registrado.
     */
    public boolean validateDuplicate() {
        String txtUser = this.txtUsername.getText();
        String txtRunPer = this.txtRun.getText();
        NegUsuario negU = new NegUsuario();
        NegPersona negP = new NegPersona();
        if (negU.validateUsername(txtUser) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe registrado ese nombre de usuario, ingrese otro...", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (negP.validateRun(txtRunPer) != false) {
            JOptionPane.showMessageDialog(null, "Ya existe registrado ese RUN de persona, ingrese otro...", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    /**
     * Método que establece los limites de caracteres por campos de texto en el
     * formulario.
     *
     */
    public void limits() {
        this.txtUsername.setDocument(new jTextFieldCharLimits(20));
        this.txtPass.setDocument(new jTextFieldCharLimits(20));
        this.txtPass2.setDocument(new jTextFieldCharLimits(20));
        this.txtCorreo.setDocument(new jTextFieldCharLimits(40));
        this.txtRun.setDocument(new jTextFieldCharLimits(9));
        this.txtNombres.setDocument(new jTextFieldCharLimits(40));
        this.txtAppPaterno.setDocument(new jTextFieldCharLimits(20));
        this.txtAppMaterno.setDocument(new jTextFieldCharLimits(20));
        this.txtTelefono.setDocument(new jTextFieldCharLimits(9));
        this.txtCargo.setDocument(new jTextFieldCharLimits(20));
        Date fechaActual = new Date();
        this.dpFechaContrato.setMaxSelectableDate(fechaActual);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaT = "01/01/1975";
            Date fechaMaxima = sdf.parse(fechaT);
            this.dpFechaContrato.setMinSelectableDate(fechaMaxima);
        } catch (ParseException ex) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificarCuenta;
    private javax.swing.JComboBox<String> ddlComuna;
    private javax.swing.JComboBox<String> ddlIdEmpresa;
    private javax.swing.JComboBox<String> ddlRegion;
    private javax.swing.JComboBox<String> ddlRol;
    private com.toedter.calendar.JDateChooser dpFechaContrato;
    private javax.swing.JPanel jpAdicional;
    private javax.swing.JPanel jpUpPersona;
    private javax.swing.JPanel jpUpUsuario;
    private javax.swing.JLabel lblAppMaterno;
    private javax.swing.JLabel lblAppPaterno;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblComuna;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFechaContra;
    private javax.swing.JLabel lblIdCli;
    private javax.swing.JLabel lblIdEmp;
    private javax.swing.JLabel lblIdPer;
    private javax.swing.JLabel lblIdTra;
    private javax.swing.JLabel lblIdUsu;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPass2;
    private javax.swing.JLabel lblRegion;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblRun;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTituloCuenta;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlUpCuenta;
    private javax.swing.JPanel pnlUpCuentaBanner;
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