
package projetointegrador.poliedro.telas;

import projetointegrador.poliedro.telas.TelaJogoIniciando;
import projetointegrador.poliedro.telas.TelaPartida;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaJogoIniciando extends javax.swing.JFrame {
    
    public TelaJogoIniciando() {
        super("Rumo ao topo - Poliedro"); //Configura o título da tela 
        initComponents();
        this.setResizable(false); 
        this.setMaximizedBounds(this.getBounds()); 
        setLocationRelativeTo(null); 
        
        
    }

    public class ControladorTransicao {

        private TelaJogoIniciando telaJogoIniciando;
        private TelaPartida telaPartida;

        public void iniciarPartida() {
            // Cria e exibe a tela "JOGO INICIANDO..."
            telaJogoIniciando = new TelaJogoIniciando();
            telaJogoIniciando.setLocationRelativeTo(null);  // Centraliza a janela
            telaJogoIniciando.setVisible(true);

            // Define o tempo de espera em milissegundos (ex: 3000 ms = 3 segundos)
            int delay = 3000;

            // Cria um Timer para aguardar e depois abrir a TelaPartida
            Timer timer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a tela "JOGO INICIANDO..."
                    telaJogoIniciando.dispose();

                    // Abre a tela da partida
                    telaPartida = new TelaPartida();
                    telaPartida.setVisible(true);
                }
            });

            // Garante que o Timer execute apenas uma vez
            timer.setRepeats(false);

            // Inicia o Timer
            timer.start();
        }
    }
   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/FundoTelaJogoIniciando.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1080, 720));
        jLabel1.setMinimumSize(new java.awt.Dimension(1080, 720));
        jLabel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1070, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(TelaJogoIniciando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogoIniciando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogoIniciando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogoIniciando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJogoIniciando().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
