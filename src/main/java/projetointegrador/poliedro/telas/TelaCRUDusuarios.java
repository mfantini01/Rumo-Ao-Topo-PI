/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetointegrador.poliedro.telas;

/**
 *
 * @author mathe
 */
public class TelaCRUDusuarios extends javax.swing.JFrame {

    /**
     * Creates new form TelaCRUDusuarios
     */
    public TelaCRUDusuarios() {
        super("Rumo ao topo - Poliedro"); //Configura o título da tela 
        initComponents();
        this.setResizable(false); 
        this.setMaximizedBounds(this.getBounds()); 
        setLocationRelativeTo(null); //centraliza a tela quando ela aparece
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adicionarUsuariosButton = new javax.swing.JButton();
        editarUsuariosButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().setLayout(null);

        adicionarUsuariosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoAdicionarUsuarios.png"))); // NOI18N
        adicionarUsuariosButton.setBorderPainted(false);
        adicionarUsuariosButton.setContentAreaFilled(false);
        adicionarUsuariosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarUsuariosButtonActionPerformed(evt);
            }
        });
        getContentPane().add(adicionarUsuariosButton);
        adicionarUsuariosButton.setBounds(250, 400, 280, 70);

        editarUsuariosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoEditarUsuarios.png"))); // NOI18N
        editarUsuariosButton.setText("jButton4");
        editarUsuariosButton.setBorderPainted(false);
        editarUsuariosButton.setContentAreaFilled(false);
        editarUsuariosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarUsuariosButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editarUsuariosButton);
        editarUsuariosButton.setBounds(560, 400, 280, 70);

        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoVoltarPequeno.png"))); // NOI18N
        voltarButton.setBorderPainted(false);
        voltarButton.setContentAreaFilled(false);
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(voltarButton);
        voltarButton.setBounds(10, 630, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/FundoDemaisTelasArrumado.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarUsuariosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarUsuariosButtonActionPerformed
       var uc = new CadastroUsuariosTela();
       uc.setVisible(true);
       dispose();
    }//GEN-LAST:event_adicionarUsuariosButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        var so = new TelaSelecionarOpcaoProfessor();
        so.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void editarUsuariosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarUsuariosButtonActionPerformed
        var editar = new TelaEditarUsuario();
        editar.setVisible(true);
        dispose();
    }//GEN-LAST:event_editarUsuariosButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCRUDusuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDusuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDusuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDusuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCRUDusuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarUsuariosButton;
    private javax.swing.JButton editarUsuariosButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
