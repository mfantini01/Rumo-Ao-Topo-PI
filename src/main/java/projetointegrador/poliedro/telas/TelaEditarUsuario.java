/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetointegrador.poliedro.telas;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import projetointegrador.poliedro.modelo.Usuario;
import projetointegrador.poliedro.persistencia.ConnectionFactory;
import projetointegrador.poliedro.persistencia.UsuarioDAO;

/**
 *
 * @author gabriel salve
 */
public class TelaEditarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form TelaEditarUsuario
     */
    public TelaEditarUsuario() {
        initComponents();
        comboSerie.removeAllItems();
        comboSerie.addItem("1");
        comboSerie.addItem("2");
        comboSerie.addItem("3");
        carregarUsuariosNaTabela();
        setLocationRelativeTo(null);
        
        txtBuscar.setText("Pesquise o nome desejado");
        txtBuscar.setForeground(Color.GRAY);

        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtBuscar.getText().equals("Pesquise o nome desejado")) {
                    txtBuscar.setText("");
                    txtBuscar.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtBuscar.getText().isEmpty()) {
                    txtBuscar.setForeground(Color.GRAY);
                    txtBuscar.setText("Pesquise o nome desejado");
                }
            }

        });
        
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String texto = txtBuscar.getText();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tabelaUsuarios.getModel());
                tabelaUsuarios.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 1)); // Filtra pelo nome (coluna 1)
            }
        });
        
        tabelaUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && tabelaUsuarios.getSelectedRow() != -1) {
                    int linha = tabelaUsuarios.getSelectedRow();
                    txtNome.setText(tabelaUsuarios.getValueAt(linha, 1).toString());
                    txtEmail.setText(tabelaUsuarios.getValueAt(linha, 2).toString());
                    txtSenha.setText(tabelaUsuarios.getValueAt(linha, 3).toString());
                    comboSerie.setSelectedItem(tabelaUsuarios.getValueAt(linha, 4).toString());
                }
            }
        });


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        tabela = new javax.swing.JScrollPane();
        tabelaUsuarios = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        comboSerie = new javax.swing.JComboBox<>();
        txtNome = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        telaFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        getContentPane().setLayout(null);

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(60, 170, 520, 40);

        tabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.setViewportView(tabelaUsuarios);

        getContentPane().add(tabela);
        tabela.setBounds(40, 220, 690, 420);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoCadastrar_1.png"))); // NOI18N
        btnSalvar.setText("jButton1");
        btnSalvar.setBorderPainted(false);
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(740, 510, 160, 60);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoExcluirVermelho.png"))); // NOI18N
        btnExcluir.setBorderPainted(false);
        btnExcluir.setContentAreaFilled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(900, 510, 150, 60);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(750, 320, 300, 40);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(750, 390, 300, 40);

        comboSerie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        getContentPane().add(comboSerie);
        comboSerie.setBounds(830, 450, 130, 30);
        getContentPane().add(txtNome);
        txtNome.setBounds(750, 250, 300, 40);

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoVoltarPequeno.png"))); // NOI18N
        btnVoltar.setBorderPainted(false);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar);
        btnVoltar.setBounds(10, 650, 100, 30);

        telaFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/TelaEditarUsuario.png"))); // NOI18N
        getContentPane().add(telaFundo);
        telaFundo.setBounds(0, 0, 1080, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tabelaUsuarios.getSelectedRow();
        if (linha >= 0) {
            int id = (int) tabelaUsuarios.getValueAt(linha, 0);
            int resposta = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja realmente excluir o usuário?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    var conexao = new ConnectionFactory().obterConexao();
                    var ps = conexao.prepareStatement("DELETE FROM tb_usuario WHERE id_usuario=?");
                    ps.setInt(1, id);
                    ps.execute();
                    ps.close();
                    conexao.close();

                    carregarUsuariosNaTabela(); // <-- esse método precisa recarregar os dados da tabela
                    JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir usuário: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um usuário para excluir.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        txtBuscar.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String texto = txtBuscar.getText();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tabelaUsuarios.getModel());
                tabelaUsuarios.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 1)); // 1 = coluna do nome
            }
        });

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        var voltar = new TelaCRUDusuarios();
        voltar.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String email = txtEmail.getText();
        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "Por favor, informe um e-mail válido.");
            return; // Sai do método sem continuar
        }
        
        try {
            int linhaSelecionada = tabelaUsuarios.getSelectedRow();
            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um usuário para salvar as alterações.");
                return;
            }

            int idSelecionado = (int) tabelaUsuarios.getValueAt(linhaSelecionada, 0);

            Usuario usuario = new Usuario();
            usuario.setId(idSelecionado);
            usuario.setNome(txtNome.getText());
            usuario.setEmail(txtEmail.getText());
            usuario.setSenha(new String(txtSenha.getPassword()));
            usuario.setCodigo(Integer.parseInt(comboSerie.getSelectedItem().toString()));

            UsuarioDAO dao = new UsuarioDAO();
            dao.atualizar(usuario);

            JOptionPane.showMessageDialog(this, "Usuário atualizado com sucesso!");
            carregarUsuariosNaTabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar usuário: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    private void carregarUsuariosNaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaUsuarios.getModel();
        modelo.setRowCount(0); // <-- limpa a tabela antes de recarregar
        modelo.setColumnIdentifiers(new String[]{
            "ID", "Nome", "Email", "Senha", "Série"
        });

        try {
            var conexao = new ConnectionFactory().obterConexao();
            String sql = "SELECT id_usuario, nome_usuario, email_usuario, senha_usuario, id_serie FROM tb_usuario";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nome = rs.getString("nome_usuario");
                String email = rs.getString("email_usuario");
                String senha = rs.getString("senha_usuario");
                int serie = rs.getInt("id_serie");

                modelo.addRow(new Object[]{id, nome, email, senha, serie});
            }

            rs.close();
            ps.close();
            conexao.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar usuários: " + e.getMessage());
        }
    }


        
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
            java.util.logging.Logger.getLogger(TelaEditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEditarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> comboSerie;
    private javax.swing.JScrollPane tabela;
    private javax.swing.JTable tabelaUsuarios;
    private javax.swing.JLabel telaFundo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
