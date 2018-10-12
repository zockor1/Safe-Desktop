/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import javax.swing.JOptionPane;
import modelo.Contrato;
import negocio.NegContrato;

/**
 *
 * @author Zockor
 */
public class jdAddEmpresa extends javax.swing.JDialog {

    /**
     * Creates new form jdAddEmpresa
     */
    public jdAddEmpresa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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

        pnlAddEmpresa = new javax.swing.JPanel();
        pnlAddEmpresaBanner = new javax.swing.JPanel();
        lblTituloEmpresa = new javax.swing.JLabel();
        jpAddContrato = new javax.swing.JPanel();
        dpFechaTermino = new org.jdesktop.swingx.JXDatePicker();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaTermino = new javax.swing.JLabel();
        dpFechaInicio = new org.jdesktop.swingx.JXDatePicker();
        jpAddEmpresa = new javax.swing.JPanel();
        btnAgregarEmpresa = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        pnlAddEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        pnlAddEmpresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnlAddEmpresaBanner.setBackground(new java.awt.Color(17, 48, 142));

        lblTituloEmpresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTituloEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloEmpresa.setText("INGRESO DE NUEVA EMPRESA");

        javax.swing.GroupLayout pnlAddEmpresaBannerLayout = new javax.swing.GroupLayout(pnlAddEmpresaBanner);
        pnlAddEmpresaBanner.setLayout(pnlAddEmpresaBannerLayout);
        pnlAddEmpresaBannerLayout.setHorizontalGroup(
            pnlAddEmpresaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddEmpresaBannerLayout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .addComponent(lblTituloEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270))
        );
        pnlAddEmpresaBannerLayout.setVerticalGroup(
            pnlAddEmpresaBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddEmpresaBannerLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTituloEmpresa)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jpAddContrato.setBackground(new java.awt.Color(255, 255, 255));
        jpAddContrato.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Contrato"));

        lblId.setText("ID");

        lblFechaInicio.setText("Fecha de Inicio");

        lblFechaTermino.setText("Fecha de Inicio");

        javax.swing.GroupLayout jpAddContratoLayout = new javax.swing.GroupLayout(jpAddContrato);
        jpAddContrato.setLayout(jpAddContratoLayout);
        jpAddContratoLayout.setHorizontalGroup(
            jpAddContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddContratoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(lblFechaInicio)
                .addGap(18, 18, 18)
                .addComponent(dpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(lblFechaTermino)
                .addGap(18, 18, 18)
                .addComponent(dpFechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpAddContratoLayout.setVerticalGroup(
            jpAddContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddContratoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpAddContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpFechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaInicio)
                    .addComponent(lblFechaTermino)
                    .addComponent(dpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jpAddEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        jpAddEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Empresa"));

        javax.swing.GroupLayout jpAddEmpresaLayout = new javax.swing.GroupLayout(jpAddEmpresa);
        jpAddEmpresa.setLayout(jpAddEmpresaLayout);
        jpAddEmpresaLayout.setHorizontalGroup(
            jpAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpAddEmpresaLayout.setVerticalGroup(
            jpAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );

        btnAgregarEmpresa.setText("AGREGAR");
        btnAgregarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpresaActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");

        javax.swing.GroupLayout pnlAddEmpresaLayout = new javax.swing.GroupLayout(pnlAddEmpresa);
        pnlAddEmpresa.setLayout(pnlAddEmpresaLayout);
        pnlAddEmpresaLayout.setHorizontalGroup(
            pnlAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpAddEmpresa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpAddContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlAddEmpresaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlAddEmpresaBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(185, 185, 185))
            .addGroup(pnlAddEmpresaLayout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(btnAgregarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAddEmpresaLayout.setVerticalGroup(
            pnlAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAddEmpresaBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jpAddContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpAddEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlAddEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarEmpresa)
                    .addComponent(btnCancelar))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAddEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAddEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpresaActionPerformed
        Contrato c = new Contrato();
        c.setIdContrato(Integer.parseInt(this.txtId.getText()));
        c.setFechaInicio(this.dpFechaInicio.getDate());
        c.setFechaTermino(this.dpFechaTermino.getDate());
        NegContrato contrato = new NegContrato();
        try {
            contrato.addContrato(c);
            JOptionPane.showMessageDialog(rootPane, "Contrato ingresado correctamente");
        } catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Ha ocurrdo un error inesperado");
        }
        
    }//GEN-LAST:event_btnAgregarEmpresaActionPerformed

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
            java.util.logging.Logger.getLogger(jdAddEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdAddEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdAddEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdAddEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdAddEmpresa dialog = new jdAddEmpresa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregarEmpresa;
    private javax.swing.JButton btnCancelar;
    private org.jdesktop.swingx.JXDatePicker dpFechaInicio;
    private org.jdesktop.swingx.JXDatePicker dpFechaTermino;
    private javax.swing.JPanel jpAddContrato;
    private javax.swing.JPanel jpAddEmpresa;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblFechaTermino;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblTituloEmpresa;
    private javax.swing.JPanel pnlAddEmpresa;
    private javax.swing.JPanel pnlAddEmpresaBanner;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
