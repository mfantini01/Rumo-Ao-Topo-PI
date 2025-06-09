
package projetointegrador.poliedro.telas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projetointegrador.poliedro.modelo.Ranking;
import projetointegrador.poliedro.persistencia.RankingDAO;


public class TelaRanking extends javax.swing.JFrame {

    
    public TelaRanking() {
        initComponents();
        setLocationRelativeTo(null);
        carregarRanking();
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/TelaRanking.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1080, 720));
        jLabel1.setMinimumSize(new java.awt.Dimension(1080, 720));
        jLabel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRanking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
