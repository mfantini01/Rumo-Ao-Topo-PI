
package projetointegrador.poliedro.telas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import projetointegrador.poliedro.modelo.Pergunta;
import projetointegrador.poliedro.persistencia.ConnectionFactory;
import projetointegrador.poliedro.persistencia.PerguntaDAO;

public class TelaEditarPerguntas extends javax.swing.JFrame {
    public TelaEditarPerguntas() {
        initComponents();  // Primeiro inicializa os componentes
        setLocationRelativeTo(null);  // Centraliza a janela
        ajustarTamanhoColunas();  // Ajusta o tamanho das colunas
        carregarPerguntasNaTabela();
        preencherCombos();
        tabelaPergunta.getColumnModel().getColumn(4).setMinWidth(0);
        tabelaPergunta.getColumnModel().getColumn(4).setMaxWidth(0);
        tabelaPergunta.getColumnModel().getColumn(4).setWidth(0);

        // Para campo de texto (pesquisa do enunciado)
        txtPesquisarEnunciado.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                atualizarTabelaComFiltros();
            }

            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                atualizarTabelaComFiltros();
            }

            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                atualizarTabelaComFiltros();
            }
        });

        comboMateria.addActionListener(e -> atualizarTabelaComFiltros());
        comboSerie.addActionListener(e -> atualizarTabelaComFiltros());
        comboDificuldade.addActionListener(e -> atualizarTabelaComFiltros());

        // ✅ Carrega as perguntas com tratamento de erro
        try {
            PerguntaDAO dao = new PerguntaDAO();
            listaPerguntasCache = dao.listarPerguntasSimples(); // Carrega tudo uma vez só
            atualizarTabelaComFiltros(); // Exibe na tabela
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar perguntas: " + e.getMessage());
            listaPerguntasCache = new ArrayList<>(); // Evita NullPointerException
        }
    }

    
    
    
    private List<String[]> listaPerguntasCache = new ArrayList<>();
    
    
    
    private void preencherCombos() {
        try {
            var conexao = new ConnectionFactory().obterConexao();

            // MATÉRIA
            var psMat = conexao.prepareStatement("SELECT nome_materia FROM tb_materia");
            var rsMat = psMat.executeQuery();
            comboMateria.addItem("Todas");
            while (rsMat.next()) {
                comboMateria.addItem(rsMat.getString("nome_materia"));
            }

            // SÉRIE
            var psSerie = conexao.prepareStatement("SELECT nome_serie FROM tb_serie");
            var rsSerie = psSerie.executeQuery();
            comboSerie.addItem("Todas");
            while (rsSerie.next()) {
                comboSerie.addItem(rsSerie.getString("nome_serie"));
            }

            // DIFICULDADE: apenas com nomes amigáveis
            comboDificuldade.removeAllItems(); // limpa antes de adicionar
            comboDificuldade.addItem("Todas");
            comboDificuldade.addItem("Fácil");
            comboDificuldade.addItem("Médio");
            comboDificuldade.addItem("Difícil");

            rsMat.close();
            rsSerie.close();
            psMat.close();
            psSerie.close();
            conexao.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao preencher os filtros: " + e.getMessage());
        }
    }

    
    private void atualizarTabelaComFiltros() {
        try {
            String enunciadoFiltro = txtPesquisarEnunciado.getText().toLowerCase().trim();
            String materiaFiltro = comboMateria.getSelectedItem().toString();
            String serieFiltro = comboSerie.getSelectedItem().toString();
            String dificuldadeFiltro = comboDificuldade.getSelectedItem().toString();

            DefaultTableModel modelo = (DefaultTableModel) tabelaPergunta.getModel();
            modelo.setRowCount(0); // limpa a tabela

            for (String[] linha : listaPerguntasCache) {
                String enunciado = linha[0].toLowerCase();
                String serie = linha[1];
                String dificuldade = linha[2]; // Ex: "1", "2", "3"
                String materia = linha[3];
                
                System.out.println("Dificuldade da linha: " + dificuldade);

                boolean condEnunciado = enunciado.contains(enunciadoFiltro);
                boolean condMateria = materiaFiltro.equals("Todas") || materia.equalsIgnoreCase(materiaFiltro);
                boolean condSerie = serieFiltro.equals("Todas") || serie.equalsIgnoreCase(serieFiltro);
                boolean condDificuldade = dificuldadeFiltro.equals("Todas") || dificuldade.equalsIgnoreCase(dificuldadeFiltro);
                

                if (condEnunciado && condMateria && condSerie && condDificuldade) {
                    modelo.addRow(linha);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao aplicar filtros: " + e.getMessage());
        }
    }






    private void ajustarTamanhoColunas() {
        TableColumnModel colunaModel = tabelaPergunta.getColumnModel();

        colunaModel.getColumn(0).setPreferredWidth(250); // Pergunta
        colunaModel.getColumn(1).setPreferredWidth(80);  // Série
        colunaModel.getColumn(2).setPreferredWidth(100); // Nível de dificuldade
        colunaModel.getColumn(3).setPreferredWidth(100); // Resposta correta
    }
    
    private void carregarPerguntasNaTabela() {
        try {
            PerguntaDAO dao = new PerguntaDAO();
            List<String[]> perguntas = dao.listarPerguntasSimples();

            // Cria um novo modelo para a tabela
            String[] colunas = {"Enunciado", "Série", "Dificuldade", "Matéria"};
            DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

            // Adiciona cada pergunta à tabela
            for (String[] linha : perguntas) {
                modelo.addRow(linha);
            }

            tabelaPergunta.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar perguntas: " + e.getMessage());
            e.printStackTrace();
        }
    }




   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabelaPerguntas = new javax.swing.JScrollPane();
        tabelaPergunta = new javax.swing.JTable();
        editarButton = new javax.swing.JButton();
        excluirButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();
        txtPesquisarEnunciado = new javax.swing.JTextField();
        comboDificuldade = new javax.swing.JComboBox<>();
        comboMateria = new javax.swing.JComboBox<>();
        comboSerie = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().setLayout(null);

        tabelaPergunta.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaPergunta.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabelaPerguntaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tabelaPerguntas.setViewportView(tabelaPergunta);

        getContentPane().add(tabelaPerguntas);
        tabelaPerguntas.setBounds(30, 220, 740, 410);

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
        editarButton.setBounds(820, 310, 170, 70);

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
        excluirButton.setBounds(820, 460, 170, 70);

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
        getContentPane().add(txtPesquisarEnunciado);
        txtPesquisarEnunciado.setBounds(60, 170, 370, 40);

        getContentPane().add(comboDificuldade);
        comboDificuldade.setBounds(560, 180, 90, 30);

        getContentPane().add(comboMateria);
        comboMateria.setBounds(670, 180, 90, 30);

        getContentPane().add(comboSerie);
        comboSerie.setBounds(450, 180, 90, 30);

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
        int linhaSelecionada = tabelaPergunta.getSelectedRow();
        if (linhaSelecionada != -1) {
            int colunaID = tabelaPergunta.getColumnCount() - 1;
            int idPergunta = Integer.parseInt(tabelaPergunta.getValueAt(linhaSelecionada, colunaID).toString());
            int resposta = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja realmente excluir o usuário?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    var conexao = new ConnectionFactory().obterConexao();
                    var psResposta = conexao.prepareStatement("DELETE FROM tb_pergunta_resposta WHERE id_pergunta = ?");
                    psResposta.setInt(1, idPergunta);
                    psResposta.execute();
                    psResposta.close();

                    var conexao2 = new ConnectionFactory().obterConexao();
                    var ps = conexao.prepareStatement("DELETE FROM tb_pergunta WHERE id_pergunta=?");
                    ps.setInt(1, idPergunta);
                    ps.execute();
                    ps.close();
                    conexao.close();

                    carregarPerguntasNaTabela(); // <-- esse método precisa recarregar os dados da tabela
                    JOptionPane.showMessageDialog(null, "Pergunta excluído com sucesso!");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao excluir pergunta");
                }
            }

        }
     
    }//GEN-LAST:event_excluirButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        var voltar = new TelaCRUDperguntas();
        voltar.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void tabelaPerguntaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabelaPerguntaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaPerguntaAncestorAdded
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
    private javax.swing.JComboBox<String> comboDificuldade;
    private javax.swing.JComboBox<String> comboMateria;
    private javax.swing.JComboBox<String> comboSerie;
    private javax.swing.JButton editarButton;
    private javax.swing.JButton excluirButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable tabelaPergunta;
    private javax.swing.JScrollPane tabelaPerguntas;
    private javax.swing.JTextField txtPesquisarEnunciado;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
