/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetointegrador.poliedro.telas;

import javax.swing.JOptionPane;
import projetointegrador.poliedro.modelo.Usuario;
/**
 *
 * @author Lucas C Ribeiro
 */
public class TelaSelecionarMateria extends javax.swing.JFrame {
    
   
    private int idMateriaSelecionada = -1;
    private Usuario usuario;
    
    
    public TelaSelecionarMateria(Usuario usuario) {
        super("Rumo ao topo - Poliedro"); // Título da tela
        this.usuario = usuario;           // 👈 ESSA LINHA É ESSENCIAL
        initComponents();
        this.setResizable(false);
        this.setMaximizedBounds(this.getBounds());
        setLocationRelativeTo(null);
    }

    private TelaSelecionarMateria() {
        
    }

    private void abrirTelaPartida(int materiaId) {
        idMateriaSelecionada = materiaId;
        TelaPartida telaPartida = new TelaPartida(usuario, idMateriaSelecionada);
        telaPartida.setVisible(true);
        dispose();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        matematicaButton = new javax.swing.JButton();
        portuguesButton = new javax.swing.JButton();
        geometriaButton = new javax.swing.JButton();
        quimicaButton = new javax.swing.JButton();
        fisicaButton = new javax.swing.JButton();
        biologiaButton = new javax.swing.JButton();
        historiaButton = new javax.swing.JButton();
        geografiaButton = new javax.swing.JButton();
        todasButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().setLayout(null);

        matematicaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoMatematica.png"))); // NOI18N
        matematicaButton.setText("matamatica");
        matematicaButton.setBorderPainted(false);
        matematicaButton.setContentAreaFilled(false);
        matematicaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matematicaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(matematicaButton);
        matematicaButton.setBounds(80, 420, 260, 70);

        portuguesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoPortugues.png"))); // NOI18N
        portuguesButton.setText("portgues");
        portuguesButton.setBorderPainted(false);
        portuguesButton.setContentAreaFilled(false);
        portuguesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portuguesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(portuguesButton);
        portuguesButton.setBounds(390, 420, 260, 70);

        geometriaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoGeometria.png"))); // NOI18N
        geometriaButton.setText("geometria");
        geometriaButton.setBorderPainted(false);
        geometriaButton.setContentAreaFilled(false);
        geometriaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geometriaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(geometriaButton);
        geometriaButton.setBounds(710, 420, 260, 70);

        quimicaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoQuimica.png"))); // NOI18N
        quimicaButton.setText("quimica");
        quimicaButton.setBorderPainted(false);
        quimicaButton.setContentAreaFilled(false);
        quimicaButton.setMaximumSize(new java.awt.Dimension(347, 97));
        quimicaButton.setMinimumSize(new java.awt.Dimension(347, 97));
        quimicaButton.setPreferredSize(new java.awt.Dimension(347, 97));
        quimicaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quimicaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(quimicaButton);
        quimicaButton.setBounds(80, 510, 260, 70);

        fisicaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoFisica.png"))); // NOI18N
        fisicaButton.setText("fisica");
        fisicaButton.setBorderPainted(false);
        fisicaButton.setContentAreaFilled(false);
        fisicaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fisicaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(fisicaButton);
        fisicaButton.setBounds(390, 510, 260, 70);

        biologiaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoBiologia.png"))); // NOI18N
        biologiaButton.setText("jButton1");
        biologiaButton.setBorderPainted(false);
        biologiaButton.setContentAreaFilled(false);
        biologiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biologiaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(biologiaButton);
        biologiaButton.setBounds(710, 510, 260, 70);

        historiaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoHistoria.png"))); // NOI18N
        historiaButton.setText("historia");
        historiaButton.setBorderPainted(false);
        historiaButton.setContentAreaFilled(false);
        historiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historiaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(historiaButton);
        historiaButton.setBounds(80, 600, 260, 70);

        geografiaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoGeografia.png"))); // NOI18N
        geografiaButton.setText("geografia");
        geografiaButton.setBorderPainted(false);
        geografiaButton.setContentAreaFilled(false);
        geografiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geografiaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(geografiaButton);
        geografiaButton.setBounds(390, 600, 260, 70);

        todasButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoTodas.png"))); // NOI18N
        todasButton.setText("jButton1");
        todasButton.setBorderPainted(false);
        todasButton.setContentAreaFilled(false);
        todasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todasButtonActionPerformed(evt);
            }
        });
        getContentPane().add(todasButton);
        todasButton.setBounds(710, 600, 260, 70);

        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoSairPequeno.png"))); // NOI18N
        voltarButton.setText("jButton1");
        voltarButton.setBorderPainted(false);
        voltarButton.setContentAreaFilled(false);
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(voltarButton);
        voltarButton.setBounds(950, 20, 100, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/SelecioneMateriaTelaFundoArrumado.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1080, 720));
        jLabel1.setMinimumSize(new java.awt.Dimension(1080, 720));
        jLabel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void geometriaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geometriaButtonActionPerformed
        abrirTelaPartida(7);
       
    }//GEN-LAST:event_geometriaButtonActionPerformed

    private void matematicaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matematicaButtonActionPerformed
        abrirTelaPartida(1);
    }//GEN-LAST:event_matematicaButtonActionPerformed

    private void portuguesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portuguesButtonActionPerformed
        abrirTelaPartida(2);
    }//GEN-LAST:event_portuguesButtonActionPerformed

    private void quimicaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quimicaButtonActionPerformed
        abrirTelaPartida(6);
    }//GEN-LAST:event_quimicaButtonActionPerformed

    private void fisicaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fisicaButtonActionPerformed
        abrirTelaPartida(5);
    }//GEN-LAST:event_fisicaButtonActionPerformed

    private void biologiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biologiaButtonActionPerformed
        abrirTelaPartida(8);
    }//GEN-LAST:event_biologiaButtonActionPerformed

    private void historiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historiaButtonActionPerformed
        abrirTelaPartida(4);
    }//GEN-LAST:event_historiaButtonActionPerformed

    private void geografiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geografiaButtonActionPerformed
        abrirTelaPartida(3);
    }//GEN-LAST:event_geografiaButtonActionPerformed

    private void todasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todasButtonActionPerformed

        TelaPartida telaPartida = new TelaPartida(usuario, idMateriaSelecionada);
        telaPartida.setVisible(true);
        dispose();
    }//GEN-LAST:event_todasButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
       dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Este main não deveria ser usado diretamente, pois a tela precisa de um Usuario
        // Se for necessário para testes, crie um usuário mock
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Exemplo para teste - remova ou modifique para produção
                Usuario usuarioTeste = new Usuario("teste@email.com", "senha");
                usuarioTeste.setSerie(1); // Adicione um método setSerie na classe Usuario
                new TelaSelecionarMateria(usuarioTeste).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton biologiaButton;
    private javax.swing.JButton fisicaButton;
    private javax.swing.JButton geografiaButton;
    private javax.swing.JButton geometriaButton;
    private javax.swing.JButton historiaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton matematicaButton;
    private javax.swing.JButton portuguesButton;
    private javax.swing.JButton quimicaButton;
    private javax.swing.JButton todasButton;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
