
package projetointegrador.poliedro.telas;

import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

public class TelaEditarPerguntas extends javax.swing.JFrame {
    public TelaEditarPerguntas() {
        initComponents();  // Primeiro inicializa os componentes
        setLocationRelativeTo(null);  // Centraliza a janela
        ajustarTamanhoColunas();  // Ajusta o tamanho das colunas
    }

    private void ajustarTamanhoColunas() {
        TableColumnModel colunaModel = tabela.getColumnModel();

        colunaModel.getColumn(0).setPreferredWidth(250); // Pergunta
        colunaModel.getColumn(1).setPreferredWidth(80);  // Série
        colunaModel.getColumn(2).setPreferredWidth(100); // Nível de dificuldade
        colunaModel.getColumn(3).setPreferredWidth(100); // Resposta correta
    }

   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabelaPerguntas = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        editarButton = new javax.swing.JButton();
        excluirButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().setLayout(null);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Pergunta", "Serie", "N dificuldade", "Matéria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaPerguntas.setViewportView(tabela);

        getContentPane().add(tabelaPerguntas);
        tabelaPerguntas.setBounds(20, 210, 670, 402);

        editarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoEditar.png"))); // NOI18N
        editarButton.setText("jButton1");
        editarButton.setBorderPainted(false);
        editarButton.setContentAreaFilled(false);
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editarButton);
        editarButton.setBounds(790, 360, 170, 60);

        excluirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoExcluirVermelho.png"))); // NOI18N
        excluirButton.setText("jButton2");
        excluirButton.setBorderPainted(false);
        excluirButton.setContentAreaFilled(false);
        excluirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirButtonActionPerformed(evt);
            }
        });
        getContentPane().add(excluirButton);
        excluirButton.setBounds(790, 470, 170, 70);

        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoVoltarPequeno.png"))); // NOI18N
        voltarButton.setText("jButton1");
        voltarButton.setBorderPainted(false);
        voltarButton.setContentAreaFilled(false);
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(voltarButton);
        voltarButton.setBounds(30, 630, 100, 47);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/TelaEditarUsuario.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1080, 720));
        jLabel1.setMinimumSize(new java.awt.Dimension(1080, 720));
        jLabel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
        var editar = new SubTelaEditarPerguntas();
        editar.setVisible(true);
        dispose();
    }//GEN-LAST:event_editarButtonActionPerformed

    private void excluirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirButtonActionPerformed
        int resposta = JOptionPane.showConfirmDialog(
            this,
            "Você tem certeza que quer excluir essa pergunta?",
            "Confirmar exclusão",
            JOptionPane.YES_NO_OPTION);
        
        if(resposta == JOptionPane.YES_OPTION){
            System.out.println("Pergunta excluída com sucesso!");
        }else{
            System.out.println("Exclusão cancelada!");
        
        }
     
    }//GEN-LAST:event_excluirButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        var voltar = new TelaCRUDperguntas();
        voltar.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed
 public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TelaEditarPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new TelaEditarPerguntas().setVisible(true));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editarButton;
    private javax.swing.JButton excluirButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable tabela;
    private javax.swing.JScrollPane tabelaPerguntas;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
