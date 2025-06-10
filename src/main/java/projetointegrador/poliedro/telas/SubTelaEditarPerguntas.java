
package projetointegrador.poliedro.telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import projetointegrador.poliedro.modelo.Materia;
import projetointegrador.poliedro.persistencia.PerguntaDAO;
import projetointegrador.poliedro.persistencia.ConnectionFactory;

/**
 *
 * @author Lucas C Ribeiro
 */
public class SubTelaEditarPerguntas extends javax.swing.JFrame {

    private int idPergunta;

    public SubTelaEditarPerguntas(int idPergunta) {
        initComponents();
        this.idPergunta = idPergunta;
        carregarPergunta(idPergunta);
        setLocationRelativeTo(null);
    }
    
    public SubTelaEditarPerguntas() {
        JOptionPane.showMessageDialog(this, "Esta tela deve ser aberta com um ID de pergunta.");
        dispose(); // Fecha a tela imediatamente
    }
    
 
    private void carregarPergunta(int idPergunta) {
        try {
            Connection con = new ConnectionFactory().obterConexao();

            // Consulta os dados principais da pergunta
            String sqlPergunta = "SELECT enunciado, dica_pergunta, id_serie, dificuldade, id_materia FROM tb_pergunta WHERE id_pergunta = ?";
            PreparedStatement stmtPergunta = con.prepareStatement(sqlPergunta);
            stmtPergunta.setInt(1, idPergunta);
            ResultSet rsPergunta = stmtPergunta.executeQuery();

            if (rsPergunta.next()) {
                txtPergunta.setText(rsPergunta.getString("enunciado"));
                txtDica.setText(rsPergunta.getString("dica_pergunta"));

                // Seleciona os combos por ID (ou converta para nome se necessário)
                cmbSerie.setSelectedIndex(rsPergunta.getInt("id_serie") - 1);
                cmbDificuldade.setSelectedIndex(rsPergunta.getInt("dificuldade") - 1);
                cmbMateria.setSelectedIndex(rsPergunta.getInt("id_materia") - 1);
            }

            rsPergunta.close();
            stmtPergunta.close();

            // Consulta as alternativas
            String sqlAlternativas = """
            SELECT r.texto_resposta, pr.correta 
            FROM tb_resposta r
            JOIN tb_pergunta_resposta pr ON r.id_resposta = pr.id_resposta
            WHERE pr.id_pergunta = ?
            """;
            PreparedStatement stmtAlt = con.prepareStatement(sqlAlternativas);
            stmtAlt.setInt(1, idPergunta);
            ResultSet rsAlt = stmtAlt.executeQuery();

            int contador = 1;
            while (rsAlt.next() && contador <= 5) {
                String texto = rsAlt.getString("texto_resposta");
                boolean correta = rsAlt.getBoolean("correta");

                switch (contador) {
                    case 1 ->
                        txtAlternativa1.setText(texto);
                    case 2 ->
                        txtAlternativa2.setText(texto);
                    case 3 ->
                        txtAlternativa3.setText(texto);
                    case 4 ->
                        txtAlternativa4.setText(texto);
                    case 5 ->
                        txtAlternativa5.setText(texto);
                }

                if (correta) {
                    cmbAlternativaCorreta.setSelectedIndex(contador - 1); // Índice começa em 0
                }

                contador++;
            }

            rsAlt.close();
            stmtAlt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar pergunta.");
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ePergunta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPergunta = new javax.swing.JTextArea();
        eAlternativaA = new javax.swing.JLabel();
        txtAlternativa1 = new javax.swing.JTextField();
        eAlternativaB = new javax.swing.JLabel();
        txtAlternativa2 = new javax.swing.JTextField();
        eAlternativaC = new javax.swing.JLabel();
        txtAlternativa3 = new javax.swing.JTextField();
        eAlternativaD = new javax.swing.JLabel();
        txtAlternativa4 = new javax.swing.JTextField();
        txtAlternativa5 = new javax.swing.JTextField();
        eAlternativaE = new javax.swing.JLabel();
        eDica = new javax.swing.JLabel();
        txtDica = new javax.swing.JTextField();
        eAlternativaCerta = new javax.swing.JLabel();
        cmbAlternativaCorreta = new javax.swing.JComboBox<>();
        eDificuldade = new javax.swing.JLabel();
        cmbDificuldade = new javax.swing.JComboBox<>();
        eMateria = new javax.swing.JLabel();
        cmbMateria = new javax.swing.JComboBox<>();
        confirmarEdicaoButton = new javax.swing.JButton();
        eSerie = new javax.swing.JLabel();
        cmbSerie = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ePergunta.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ePergunta.setText("Edite a pergunta:");

        txtPergunta.setColumns(20);
        txtPergunta.setRows(5);
        jScrollPane1.setViewportView(txtPergunta);

        eAlternativaA.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        eAlternativaA.setText("Edite a alternativa 1:");

        eAlternativaB.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        eAlternativaB.setText("Edite a alternativa 2:");

        eAlternativaC.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        eAlternativaC.setText("Edite a alternativa 3:");

        eAlternativaD.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        eAlternativaD.setText("Edite a alternativa 4:");

        eAlternativaE.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        eAlternativaE.setText("Edite a alternativa 5:");

        eDica.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        eDica.setText("Edite a dica:");

        eAlternativaCerta.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        eAlternativaCerta.setText("Edite alternativa certa:");

        cmbAlternativaCorreta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        eDificuldade.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        eDificuldade.setText("Edite a dificuldade:");

        cmbDificuldade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facíl", "Médio", "Difícil" }));

        eMateria.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        eMateria.setText("Edite a matéria:");

        cmbMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matemática", "Português", "Geografia", "História", "Física", "Química", "Geometria", "Biologia" }));
        cmbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMateriaActionPerformed(evt);
            }
        });

        confirmarEdicaoButton.setText("Confirmar edição");
        confirmarEdicaoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarEdicaoButtonActionPerformed(evt);
            }
        });

        eSerie.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        eSerie.setText("Edite a seríe:");

        cmbSerie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 ano", "2 ano", "3 ano" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(eAlternativaA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eAlternativaB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eAlternativaC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eAlternativaD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eAlternativaE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eDica)
                                    .addComponent(eDificuldade))
                                .addComponent(eSerie)
                                .addComponent(eAlternativaCerta))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAlternativa1)
                                .addComponent(txtAlternativa2)
                                .addComponent(txtAlternativa3)
                                .addComponent(txtAlternativa4)
                                .addComponent(txtAlternativa5)
                                .addComponent(txtDica)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbMateria, 0, 100, Short.MAX_VALUE)
                                        .addComponent(cmbAlternativaCorreta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbDificuldade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbSerie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(ePergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(eMateria))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmarEdicaoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(ePergunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eAlternativaA)
                    .addComponent(txtAlternativa1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eAlternativaB)
                    .addComponent(txtAlternativa2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlternativa3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eAlternativaC))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlternativa4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eAlternativaD))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlternativa5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eAlternativaE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eDica)
                    .addComponent(txtDica, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eSerie)
                    .addComponent(cmbSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eAlternativaCerta)
                    .addComponent(cmbAlternativaCorreta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eDificuldade)
                    .addComponent(cmbDificuldade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eMateria)
                    .addComponent(cmbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(confirmarEdicaoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarEdicaoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarEdicaoButtonActionPerformed
        try {
            Connection con = new ConnectionFactory().obterConexao();

            // 1. Atualiza a pergunta principal
            String sqlPergunta = """
            UPDATE tb_pergunta SET 
                enunciado = ?, 
                dica_pergunta = ?, 
                id_serie = ?, 
                dificuldade = ?, 
                id_materia = ?
            WHERE id_pergunta = ?
        """;
            PreparedStatement stmtPergunta = con.prepareStatement(sqlPergunta);
            stmtPergunta.setString(1, txtPergunta.getText());
            stmtPergunta.setString(2, txtDica.getText());
            stmtPergunta.setInt(3, cmbSerie.getSelectedIndex() + 1); // ou use o ID correto
            stmtPergunta.setInt(4, cmbDificuldade.getSelectedIndex() + 1);
            stmtPergunta.setInt(5, cmbMateria.getSelectedIndex() + 1);
            stmtPergunta.setInt(6, idPergunta);
            stmtPergunta.executeUpdate();
            stmtPergunta.close();

            // 2. Atualiza as alternativas e qual é a correta
            // Primeiro buscamos os IDs das respostas dessa pergunta
            String sqlBuscarRespostas = """
            SELECT r.id_resposta 
            FROM tb_resposta r
            JOIN tb_pergunta_resposta pr ON r.id_resposta = pr.id_resposta
            WHERE pr.id_pergunta = ?
            ORDER BY r.id_resposta ASC
        """;
            PreparedStatement stmtBusca = con.prepareStatement(sqlBuscarRespostas);
            stmtBusca.setInt(1, idPergunta);
            ResultSet rs = stmtBusca.executeQuery();

            List<Integer> idsRespostas = new ArrayList<>();
            while (rs.next()) {
                idsRespostas.add(rs.getInt("id_resposta"));
            }
            rs.close();
            stmtBusca.close();

            // Atualiza os textos e qual é correta
            JTextField[] alternativas = {
                txtAlternativa1, txtAlternativa2, txtAlternativa3,
                txtAlternativa4, txtAlternativa5
            };

            int indiceCorreta = cmbAlternativaCorreta.getSelectedIndex(); // 0 a 4

            for (int i = 0; i < idsRespostas.size(); i++) {
                int idResposta = idsRespostas.get(i);

                // Atualiza texto da resposta
                String sqlUpdateResposta = "UPDATE tb_resposta SET texto_resposta = ? WHERE id_resposta = ?";
                PreparedStatement stmtAlt = con.prepareStatement(sqlUpdateResposta);
                stmtAlt.setString(1, alternativas[i].getText());
                stmtAlt.setInt(2, idResposta);
                stmtAlt.executeUpdate();
                stmtAlt.close();

                // Atualiza se é correta ou não
                String sqlUpdateCorreta = "UPDATE tb_pergunta_resposta SET correta = ? WHERE id_resposta = ? AND id_pergunta = ?";
                PreparedStatement stmtCorreta = con.prepareStatement(sqlUpdateCorreta);
                stmtCorreta.setBoolean(1, i == indiceCorreta);
                stmtCorreta.setInt(2, idResposta);
                stmtCorreta.setInt(3, idPergunta);
                stmtCorreta.executeUpdate();
                stmtCorreta.close();
            }

            con.close();
            JOptionPane.showMessageDialog(this, "Pergunta atualizada com sucesso!");
            this.dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar pergunta.");
        }
    }//GEN-LAST:event_confirmarEdicaoButtonActionPerformed

    private void cmbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMateriaActionPerformed

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
            java.util.logging.Logger.getLogger(SubTelaEditarPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubTelaEditarPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubTelaEditarPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubTelaEditarPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubTelaEditarPerguntas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbAlternativaCorreta;
    private javax.swing.JComboBox<String> cmbDificuldade;
    private javax.swing.JComboBox<String> cmbMateria;
    private javax.swing.JComboBox<String> cmbSerie;
    private javax.swing.JButton confirmarEdicaoButton;
    private javax.swing.JLabel eAlternativaA;
    private javax.swing.JLabel eAlternativaB;
    private javax.swing.JLabel eAlternativaC;
    private javax.swing.JLabel eAlternativaCerta;
    private javax.swing.JLabel eAlternativaD;
    private javax.swing.JLabel eAlternativaE;
    private javax.swing.JLabel eDica;
    private javax.swing.JLabel eDificuldade;
    private javax.swing.JLabel eMateria;
    private javax.swing.JLabel ePergunta;
    private javax.swing.JLabel eSerie;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAlternativa1;
    private javax.swing.JTextField txtAlternativa2;
    private javax.swing.JTextField txtAlternativa3;
    private javax.swing.JTextField txtAlternativa4;
    private javax.swing.JTextField txtAlternativa5;
    private javax.swing.JTextField txtDica;
    private javax.swing.JTextArea txtPergunta;
    // End of variables declaration//GEN-END:variables
}
