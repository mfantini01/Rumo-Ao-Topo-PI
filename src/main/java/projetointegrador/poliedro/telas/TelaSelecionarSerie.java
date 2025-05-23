/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetointegrador.poliedro.telas;
import javax.swing.JOptionPane;
/**
 *
 * @author 25.00360-9
 */
public class TelaSelecionarSerie extends javax.swing.JFrame {

    /**
     * Creates new form TelaSelecionarSerie
     */
    public TelaSelecionarSerie() {
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

        primeiraSerieButton = new javax.swing.JButton();
        segundaSerieButton = new javax.swing.JButton();
        terceiraSerieButton = new javax.swing.JButton();
        sairButton = new javax.swing.JButton();
        fundoTelaSelecionarSerieLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().setLayout(null);

        primeiraSerieButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoPrimeiraSerie.png"))); // NOI18N
        primeiraSerieButton.setBorderPainted(false);
        primeiraSerieButton.setContentAreaFilled(false);
        primeiraSerieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primeiraSerieButtonActionPerformed(evt);
            }
        });
        getContentPane().add(primeiraSerieButton);
        primeiraSerieButton.setBounds(110, 440, 260, 70);

        segundaSerieButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoSegundaSerie.png"))); // NOI18N
        segundaSerieButton.setBorderPainted(false);
        segundaSerieButton.setContentAreaFilled(false);
        segundaSerieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                segundaSerieButtonActionPerformed(evt);
            }
        });
        getContentPane().add(segundaSerieButton);
        segundaSerieButton.setBounds(400, 440, 260, 70);

        terceiraSerieButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoTerceiraSerie.png"))); // NOI18N
        terceiraSerieButton.setBorderPainted(false);
        terceiraSerieButton.setContentAreaFilled(false);
        terceiraSerieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terceiraSerieButtonActionPerformed(evt);
            }
        });
        getContentPane().add(terceiraSerieButton);
        terceiraSerieButton.setBounds(690, 440, 260, 70);

        sairButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoSairPequeno.png"))); // NOI18N
        sairButton.setText("jButton1");
        sairButton.setBorderPainted(false);
        sairButton.setContentAreaFilled(false);
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sairButton);
        sairButton.setBounds(30, 630, 100, 30);

        fundoTelaSelecionarSerieLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/TelaSelecionarSerieFundo.png"))); // NOI18N
        getContentPane().add(fundoTelaSelecionarSerieLabel);
        fundoTelaSelecionarSerieLabel.setBounds(0, 0, 1080, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void primeiraSerieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primeiraSerieButtonActionPerformed
         var sm = new TelaSelecionarMateria();
        sm.setVisible(true);
        dispose();
    }//GEN-LAST:event_primeiraSerieButtonActionPerformed

    private void segundaSerieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_segundaSerieButtonActionPerformed
        var sm = new TelaSelecionarMateria();
        sm.setVisible(true);
        dispose();
    }//GEN-LAST:event_segundaSerieButtonActionPerformed

    private void terceiraSerieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terceiraSerieButtonActionPerformed
         var sm = new TelaSelecionarMateria();
        sm.setVisible(true);
        dispose();
    }//GEN-LAST:event_terceiraSerieButtonActionPerformed

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed
       dispose();
    }//GEN-LAST:event_sairButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaSelecionarSerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSelecionarSerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSelecionarSerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSelecionarSerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSelecionarSerie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fundoTelaSelecionarSerieLabel;
    private javax.swing.JButton primeiraSerieButton;
    private javax.swing.JButton sairButton;
    private javax.swing.JButton segundaSerieButton;
    private javax.swing.JButton terceiraSerieButton;
    // End of variables declaration//GEN-END:variables
}
