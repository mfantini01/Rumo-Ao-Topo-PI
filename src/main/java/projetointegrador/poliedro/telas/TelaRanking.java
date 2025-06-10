
package projetointegrador.poliedro.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projetointegrador.poliedro.modelo.Ranking;
import projetointegrador.poliedro.persistencia.RankingDAO;


public class TelaRanking extends javax.swing.JFrame {

    
    public TelaRanking() {
        super("Rumo ao topo - Poliedro"); //Configura o título da tela 
        initComponents();
        this.setResizable(false);
        this.setMaximizedBounds(this.getBounds());
        setLocationRelativeTo(null);
        carregarRanking();
        
        // Adiciona opções à comboSerie
        comboSerie.addItem("Todos");
        comboSerie.addItem("1º ano");
        comboSerie.addItem("2º ano");
        comboSerie.addItem("3º ano");

        // Adiciona opções à comboAno
        comboAno.addItem("Selecione");
        comboAno.addItem("2023");
        comboAno.addItem("2024");
        comboAno.addItem("2025");

        // Adiciona opções à comboMes e desativa inicialmente
        comboMes.addItem("01");
        comboMes.addItem("02");
        comboMes.addItem("03");
        comboMes.addItem("04");
        comboMes.addItem("05");
        comboMes.addItem("06");
        comboMes.addItem("07");
        comboMes.addItem("08");
        comboMes.addItem("09");
        comboMes.addItem("10");
        comboMes.addItem("11");
        comboMes.addItem("12");
        comboMes.setEnabled(false); // importante!
        
        comboAno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String anoSelecionado = comboAno.getSelectedItem().toString();
                if (!anoSelecionado.equals("Selecione")) {
                    comboMes.setEnabled(true);
                } else {
                    comboMes.setEnabled(false);
                }
            }
        });
        
        ActionListener filtroListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filtrarRanking();
            }
        };

        comboSerie.addActionListener(filtroListener);
        comboAno.addActionListener(filtroListener);
        comboMes.addActionListener(filtroListener);


    }
    
    
    
    private void filtrarRanking() {
        try {
            RankingDAO dao = new RankingDAO();
            List<Ranking> lista = dao.listarComUsuarios(); // Aqui você pode depois passar parâmetros se quiser otimizar

            String serieSelecionada = (String) comboSerie.getSelectedItem();
            String anoSelecionado = (String) comboAno.getSelectedItem();
            String mesSelecionado = (String) comboMes.getSelectedItem();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Posição");
            modelo.addColumn("Nome");
            modelo.addColumn("Série");
            modelo.addColumn("Pontuação");
            modelo.addColumn("Período");

            for (Ranking r : lista) {
                String nome = r.getUsuario().getNome();
                int serie = r.getUsuario().getCodigo();
                String mesAno = r.getMesAno(); // formato: MM/YYYY

                boolean atendeFiltroSerie = serieSelecionada.equals("Todos")
                        || (serieSelecionada.equals("1º ano") && serie == 1)
                        || (serieSelecionada.equals("2º ano") && serie == 2)
                        || (serieSelecionada.equals("3º ano") && serie == 3);

                boolean atendeFiltroData = true;
                if (anoSelecionado != null && !anoSelecionado.equals("Ano")) {
                    if (mesAno.endsWith(anoSelecionado)) {
                        if (mesSelecionado != null && !mesSelecionado.equals("Mês")) {
                            atendeFiltroData = mesAno.startsWith(mesSelecionado);
                        }
                    } else {
                        atendeFiltroData = false;
                    }
                }

                if (atendeFiltroSerie && atendeFiltroData) {
                    modelo.addRow(new Object[]{
                        r.getPosicao(),
                        nome,
                        serie,
                        r.getPontuacaoTotal(),
                        r.getMesAno()
                    });
                }
            }

            jTable1.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao filtrar ranking: " + e.getMessage());
        }
    }


    private void carregarRanking() {
        try {
            RankingDAO dao = new RankingDAO();
            List<Ranking> lista = dao.listarComUsuarios();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Posição");
            modelo.addColumn("Nome");
            modelo.addColumn("Série");
            modelo.addColumn("Pontuação");
            modelo.addColumn("Período");

            for (Ranking r : lista) {
                String nome = r.getUsuario().getNome();
                int serie = r.getUsuario().getCodigo(); 

                modelo.addRow(new Object[]{
                    r.getPosicao(),
                    nome,
                    serie,
                    r.getPontuacaoTotal(),
                    r.getMesAno()
                });
            }

            jTable1.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar ranking: " + e.getMessage());
        }
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        voltarButton = new javax.swing.JButton();
        comboSerie = new javax.swing.JComboBox<>();
        comboAno = new javax.swing.JComboBox<>();
        comboMes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Posição", "Nome", "Série", "Pontuação", "Período"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(150, 200, 780, 402);

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
        voltarButton.setBounds(40, 637, 90, 40);

        comboSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSerieActionPerformed(evt);
            }
        });
        getContentPane().add(comboSerie);
        comboSerie.setBounds(350, 160, 72, 22);

        comboAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnoActionPerformed(evt);
            }
        });
        getContentPane().add(comboAno);
        comboAno.setBounds(510, 160, 72, 22);

        comboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMesActionPerformed(evt);
            }
        });
        getContentPane().add(comboMes);
        comboMes.setBounds(660, 160, 72, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/TelaRanking.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1080, 720));
        jLabel1.setMinimumSize(new java.awt.Dimension(1080, 720));
        jLabel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        var voltar = new TelaSelecionarOpcaoProfessor();
        voltar.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void comboSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSerieActionPerformed
       
    }//GEN-LAST:event_comboSerieActionPerformed

    private void comboAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnoActionPerformed
        
    }//GEN-LAST:event_comboAnoActionPerformed

    private void comboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMesActionPerformed
        
    }//GEN-LAST:event_comboMesActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRanking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboAno;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JComboBox<String> comboSerie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
