//Paquete
package presentacion;

//Importaciones
import modelo.Cliente;
import modelo.Persona;
import modelo.Trabajador;
import negocio.NegCliente;
import negocio.NegPersona;
import negocio.NegTrabajador;

/**
 * @author Ignacio Antillanca
 * @version 1.0
 */
public class jdVerCuenta extends javax.swing.JDialog {

    /**
     * Creates new form jdVerCuenta
     *
     * @param parent
     * @param modal
     */
    public jdVerCuenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds((ancho / 2) - (this.getWidth() / 2), (alto / 2) - (this.getHeight() / 2), 850, 600);
        this.setLocationRelativeTo(this);
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
     * respectivos campos de la ventana.
     *
     * @param idUsu ID de usuario seleccionado en la tabla cuenta.
     */
    public void cargaDeCliente(int idUsu) {
        NegCliente negC = new NegCliente();
        Cliente cliente = negC.obtenerCliente(idUsu);
        //Llenado ID usu
        this.lblIdUsuarioText.setText(String.valueOf(cliente.getPersona().getUsuario().getIdUsuario()));
        //Llenado campos de usuario
        this.lblNombreUsuText.setText(cliente.getPersona().getUsuario().getUsername());
        this.lblCorreoText.setText(cliente.getPersona().getUsuario().getEmail());
        this.lblRolText.setText("Cliente");
        //Llenado campos de persona
        this.lblIdPersonaText.setText(String.valueOf(cliente.getPersona().getIdPersona()));
        this.lblRunText.setText(cliente.getPersona().getRun());
        this.lblNombresText.setText(cliente.getPersona().getNombres());
        this.lblAppPatText.setText(cliente.getPersona().getAppPaterno());
        this.lblAppMatText.setText(cliente.getPersona().getAppMaterno());
        //Llenado campos de cliente
        this.lblIdX.setText("ID Cliente");
        this.lblIdText.setText(String.valueOf(cliente.getIdCliente()));
        this.lblCampo1.setText("Teléfono");
        this.lblCampo1Text.setText(cliente.getTelefono());
        this.lblCampo3.setText("Region");
        this.lblCampo3Text.setText(cliente.getComuna().getRegion().getNombre());
        this.lblCampo4.setText("Comuna");
        this.lblCampo4Text.setText(cliente.getComuna().getNombre());
        this.lblCampo2.setVisible(false);
        this.lblCampo2Text.setVisible(false);
        this.lblCampo5.setVisible(false);
        this.lblCampo5Text.setVisible(false);        
    }

    /**
     * Método que recibe la informacion entregada por la base de datos en base
     * al id de un usuario del tipo trabajador, seteando los datos en los
     * respectivos campos de la ventana.
     *
     * @param idUsu ID de usuario seleccionado en la tabla cuenta.
     */
    public void cargaDeTrabajador(int idUsu) {
        NegTrabajador negT = new NegTrabajador();
        Trabajador trabajador = negT.obtenerTrabajador(idUsu);
        //Llenado ID usu
        this.lblIdUsuarioText.setText(String.valueOf(trabajador.getPersona().getUsuario().getIdUsuario()));
        //Llenado campos de usuario
        this.lblNombreUsuText.setText(trabajador.getPersona().getUsuario().getUsername());
        this.lblCorreoText.setText(trabajador.getPersona().getUsuario().getEmail());
        this.lblRolText.setText("Trabajador");
        //Llenado campos de persona
        this.lblIdPersonaText.setText(String.valueOf(trabajador.getPersona().getIdPersona()));
        this.lblRunText.setText(trabajador.getPersona().getRun());
        this.lblNombresText.setText(trabajador.getPersona().getNombres());
        this.lblAppPatText.setText(trabajador.getPersona().getAppPaterno());
        this.lblAppMatText.setText(trabajador.getPersona().getAppMaterno());
        //Llenado campos de trabajador
        this.lblIdX.setText("ID Trabajador");
        this.lblIdText.setText(String.valueOf(trabajador.getIdTrabajador()));
        this.lblCampo1.setText("Teléfono");
        this.lblCampo1Text.setText(trabajador.getTelefono());
        this.lblCampo2.setText("Fecha Contrato");
        this.lblCampo2Text.setText(String.valueOf(trabajador.getFechaContrato()));
        this.lblCampo3.setText("Cargo");
        this.lblCampo3Text.setText(trabajador.getCargo());
        this.lblCampo4.setText("Empresa");
        this.lblCampo4Text.setText(trabajador.getEmpresa().getNombreFantasia());
        this.lblCampo5.setVisible(false);
        this.lblCampo5Text.setVisible(false);
    }

    /**
     * Método que recibe la informacion entregada por la base de datos en base
     * al id de un usuario, seteando los datos en los respectivos campos de la
     * ventana.
     *
     * @param idUsu ID de usuario seleccionado en la tabla cuenta.
     */
    public void cargaDeUsuario(int idUsu) {
        NegPersona negP = new NegPersona();
        Persona pr = negP.obtenerPersona(idUsu);
        //Llenado ID usu
        this.lblIdUsuarioText.setText(String.valueOf(pr.getUsuario().getIdUsuario()));
        //Llenado campos de usuario
        this.lblNombreUsuText.setText(pr.getUsuario().getUsername());
        this.lblCorreoText.setText(pr.getUsuario().getEmail());
        int rol = pr.getUsuario().getRol();
        String nombreRol = "";
        switch (rol) {
            case 1:
                nombreRol = "Administrador";
                break;
            case 2:
                nombreRol = "Supervisor";
                break;
            case 5:
                nombreRol = "Ingeniero";
                break;
            case 6:
                nombreRol = "Técnico";
                break;
            case 7:
                nombreRol = "Médico";
                break;
            default:
                break;
        }
        this.lblRolText.setText(nombreRol);
        //Llenado campos de persona
        this.lblIdPersonaText.setText(String.valueOf(pr.getIdPersona()));
        this.lblRunText.setText(pr.getRun());
        this.lblNombresText.setText(pr.getNombres());
        this.lblAppPatText.setText(pr.getAppPaterno());
        this.lblAppMatText.setText(pr.getAppMaterno());
        //Se oculta panel adicional
        this.jpVerAdicional.setVisible(false);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVerCuenta = new javax.swing.JPanel();
        pnlVerCuentaBanner = new javax.swing.JPanel();
        lblTituloCuenta = new javax.swing.JLabel();
        jpVerUsuario = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        lblIdUsuario = new javax.swing.JLabel();
        lblIdUsuarioText = new javax.swing.JLabel();
        lblNombreUsuText = new javax.swing.JLabel();
        lblCorreoText = new javax.swing.JLabel();
        lblRolText = new javax.swing.JLabel();
        jpVerPersona = new javax.swing.JPanel();
        lblRun = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblAppPaterno = new javax.swing.JLabel();
        lblAppMaterno = new javax.swing.JLabel();
        lblRunText = new javax.swing.JLabel();
        lblNombresText = new javax.swing.JLabel();
        lblAppPatText = new javax.swing.JLabel();
        lblAppMatText = new javax.swing.JLabel();
        lblIdPersona = new javax.swing.JLabel();
        lblIdPersonaText = new javax.swing.JLabel();
        jpVerAdicional = new javax.swing.JPanel();
        lblIdX = new javax.swing.JLabel();
        lblCampo2 = new javax.swing.JLabel();
        lblCampo1 = new javax.swing.JLabel();
        lblCampo4 = new javax.swing.JLabel();
        lblCampo3 = new javax.swing.JLabel();
        lblCampo5 = new javax.swing.JLabel();
        lblIdText = new javax.swing.JLabel();
        lblCampo1Text = new javax.swing.JLabel();
        lblCampo2Text = new javax.swing.JLabel();
        lblCampo3Text = new javax.swing.JLabel();
        lblCampo4Text = new javax.swing.JLabel();
        lblCampo5Text = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlVerCuenta.setBackground(new java.awt.Color(255, 255, 255));
        pnlVerCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 4, true));
        pnlVerCuenta.setPreferredSize(new java.awt.Dimension(850, 600));

        pnlVerCuentaBanner.setBackground(new java.awt.Color(17, 48, 142));

        lblTituloCuenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTituloCuenta.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloCuenta.setText("Información de Usuario");

        javax.swing.GroupLayout pnlVerCuentaBannerLayout = new javax.swing.GroupLayout(pnlVerCuentaBanner);
        pnlVerCuentaBanner.setLayout(pnlVerCuentaBannerLayout);
        pnlVerCuentaBannerLayout.setHorizontalGroup(
            pnlVerCuentaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVerCuentaBannerLayout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(lblTituloCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlVerCuentaBannerLayout.setVerticalGroup(
            pnlVerCuentaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVerCuentaBannerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTituloCuenta)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jpVerUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpVerUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Usuario"));

        lblUsername.setText("Nombre de Usuario");

        lblCorreo.setText("Correo electronico");

        lblRol.setText("Rol");

        lblIdUsuario.setText("ID Usuario");

        javax.swing.GroupLayout jpVerUsuarioLayout = new javax.swing.GroupLayout(jpVerUsuario);
        jpVerUsuario.setLayout(jpVerUsuarioLayout);
        jpVerUsuarioLayout.setHorizontalGroup(
            jpVerUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVerUsuarioLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jpVerUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVerUsuarioLayout.createSequentialGroup()
                        .addComponent(lblIdUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIdUsuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpVerUsuarioLayout.createSequentialGroup()
                        .addComponent(lblUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(lblNombreUsuText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(159, 159, 159)
                .addGroup(jpVerUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCorreo)
                    .addComponent(lblRol))
                .addGap(62, 62, 62)
                .addGroup(jpVerUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCorreoText, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(lblRolText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        jpVerUsuarioLayout.setVerticalGroup(
            jpVerUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVerUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVerUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdUsuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdUsuario)
                    .addComponent(lblCorreo)
                    .addComponent(lblCorreoText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jpVerUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpVerUsuarioLayout.createSequentialGroup()
                        .addGroup(jpVerUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombreUsuText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsername))
                        .addGap(27, 27, 27))
                    .addGroup(jpVerUsuarioLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jpVerUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRolText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRol))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );

        jpVerPersona.setBackground(new java.awt.Color(255, 255, 255));
        jpVerPersona.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Persona"));

        lblRun.setText("Run");

        lblNombres.setText("Nombres");

        lblAppPaterno.setText("Apellido Paterno");

        lblAppMaterno.setText("Apellido materno");

        lblIdPersona.setText("ID Persona");

        javax.swing.GroupLayout jpVerPersonaLayout = new javax.swing.GroupLayout(jpVerPersona);
        jpVerPersona.setLayout(jpVerPersonaLayout);
        jpVerPersonaLayout.setHorizontalGroup(
            jpVerPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVerPersonaLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jpVerPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdPersona)
                    .addComponent(lblRun)
                    .addComponent(lblNombres))
                .addGap(92, 92, 92)
                .addGroup(jpVerPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombresText, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpVerPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblIdPersonaText, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(lblRunText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpVerPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAppPaterno)
                    .addComponent(lblAppMaterno))
                .addGap(70, 70, 70)
                .addGroup(jpVerPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAppPatText, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(lblAppMatText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );
        jpVerPersonaLayout.setVerticalGroup(
            jpVerPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVerPersonaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVerPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAppPatText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAppPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIdPersona, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdPersonaText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpVerPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRun)
                    .addComponent(lblRunText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAppMaterno)
                    .addComponent(lblAppMatText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpVerPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombres)
                    .addComponent(lblNombresText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jpVerAdicional.setBackground(new java.awt.Color(255, 255, 255));
        jpVerAdicional.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion Adicional"));

        lblIdX.setText("ID");

        lblCampo2.setText("campo2");

        lblCampo1.setText("campo1");

        lblCampo4.setText("campo4");

        lblCampo3.setText("campo3");

        lblCampo5.setText("campo5");

        javax.swing.GroupLayout jpVerAdicionalLayout = new javax.swing.GroupLayout(jpVerAdicional);
        jpVerAdicional.setLayout(jpVerAdicionalLayout);
        jpVerAdicionalLayout.setHorizontalGroup(
            jpVerAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVerAdicionalLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jpVerAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCampo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCampo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIdX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102)
                .addGroup(jpVerAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCampo1Text, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(lblIdText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCampo2Text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpVerAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCampo3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCampo5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCampo4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(111, 111, 111)
                .addGroup(jpVerAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCampo3Text, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(lblCampo4Text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCampo5Text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        jpVerAdicionalLayout.setVerticalGroup(
            jpVerAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVerAdicionalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVerAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpVerAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpVerAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdX)
                            .addComponent(lblIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblCampo3, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(lblCampo3Text, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpVerAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVerAdicionalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpVerAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCampo1Text, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCampo1)
                            .addComponent(lblCampo4Text, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCampo4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpVerAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCampo5Text, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCampo5))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jpVerAdicionalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpVerAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCampo2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCampo2Text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );

        btnVolver.setBackground(new java.awt.Color(17, 48, 142));
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVerCuentaLayout = new javax.swing.GroupLayout(pnlVerCuenta);
        pnlVerCuenta.setLayout(pnlVerCuentaLayout);
        pnlVerCuentaLayout.setHorizontalGroup(
            pnlVerCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlVerCuentaBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlVerCuentaLayout.createSequentialGroup()
                .addGroup(pnlVerCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpVerUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpVerPersona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpVerAdicional, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlVerCuentaLayout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlVerCuentaLayout.setVerticalGroup(
            pnlVerCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVerCuentaLayout.createSequentialGroup()
                .addComponent(pnlVerCuentaBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpVerUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpVerPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpVerAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlVerCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlVerCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que realiza la opción de cerrar el modal de ver cuentas
     * @param evt evento que indica que se realizo una accion definida
     * (ActionEvent)
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jpVerAdicional;
    private javax.swing.JPanel jpVerPersona;
    private javax.swing.JPanel jpVerUsuario;
    private javax.swing.JLabel lblAppMatText;
    private javax.swing.JLabel lblAppMaterno;
    private javax.swing.JLabel lblAppPatText;
    private javax.swing.JLabel lblAppPaterno;
    private javax.swing.JLabel lblCampo1;
    private javax.swing.JLabel lblCampo1Text;
    private javax.swing.JLabel lblCampo2;
    private javax.swing.JLabel lblCampo2Text;
    private javax.swing.JLabel lblCampo3;
    private javax.swing.JLabel lblCampo3Text;
    private javax.swing.JLabel lblCampo4;
    private javax.swing.JLabel lblCampo4Text;
    private javax.swing.JLabel lblCampo5;
    private javax.swing.JLabel lblCampo5Text;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCorreoText;
    private javax.swing.JLabel lblIdPersona;
    private javax.swing.JLabel lblIdPersonaText;
    private javax.swing.JLabel lblIdText;
    private javax.swing.JLabel lblIdUsuario;
    private javax.swing.JLabel lblIdUsuarioText;
    private javax.swing.JLabel lblIdX;
    private javax.swing.JLabel lblNombreUsuText;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblNombresText;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblRolText;
    private javax.swing.JLabel lblRun;
    private javax.swing.JLabel lblRunText;
    private javax.swing.JLabel lblTituloCuenta;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlVerCuenta;
    private javax.swing.JPanel pnlVerCuentaBanner;
    // End of variables declaration//GEN-END:variables
}
