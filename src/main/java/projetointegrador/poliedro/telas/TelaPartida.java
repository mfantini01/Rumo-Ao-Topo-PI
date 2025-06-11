package projetointegrador.poliedro.telas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import projetointegrador.poliedro.modelo.Pergunta;
import projetointegrador.poliedro.modelo.PerguntaResposta;
import projetointegrador.poliedro.modelo.Usuario;
import projetointegrador.poliedro.persistencia.PerguntaDAO;

public class TelaPartida extends javax.swing.JFrame {

    private Usuario usuario;
    private int idMateriaSelecionada;
    private Pergunta perguntaAtual;
    private boolean usouMeioMeio = false;
    private boolean usouDicaProfessor = false;
    private boolean usouPular = false;
    private int totalRespondidas = 0;
    private int totalAcertos = 0;
    public TelaPartida() {

    }

    public TelaPartida(Usuario usuario, int idMateriaSelecionada) {
        this.usuario = usuario;
        this.idMateriaSelecionada = idMateriaSelecionada;
        initComponents();
        carregarPerguntaAleatoria();
        setLocationRelativeTo(null);  // Centraliza a janela
        this.setResizable(false);
        this.setMaximizedBounds(this.getBounds());
        setLocationRelativeTo(null); //centraliza a tela quando ela aparece
        meioMeioCinzajLabel.setVisible(false);
        dicaProfessorCinzajLabel.setVisible(false);
        pularQuestaoCinzajLabel.setVisible(false);
        enunciadojScrollPane1.getViewport().setOpaque(false);
        enunciadojScrollPane1.setBorder(null);
        enunciadojScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        alternativa1jScrollPane1.getViewport().setOpaque(false);
        alternativa1jScrollPane1.setBorder(null);
        alternativa1jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        alternativa2jScrollPane2.getViewport().setOpaque(false);
        alternativa2jScrollPane2.setBorder(null);
        alternativa2jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        alternativa3jScrollPane3.getViewport().setOpaque(false);
        alternativa3jScrollPane3.setBorder(null);
        alternativa3jScrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        alternativa4jScrollPane4.getViewport().setOpaque(false);
        alternativa4jScrollPane4.setBorder(null);
        alternativa4jScrollPane4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        alternativa5jScrollPane5.getViewport().setOpaque(false);
        alternativa5jScrollPane5.setBorder(null);
        alternativa5jScrollPane5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        JButton[] botoes = {
            alternativa1jButton1,
            alternativa2jButton1,
            alternativa3jButton1,
            alternativa4jButton1,
            alternativa5jButton1,
            meioMeiojButton1,
            dicaProfessorjButton1,
            pularQuestaojButton1
        };

        for (JButton botao : botoes) {
            botao.setOpaque(false);
            botao.setContentAreaFilled(false);
            botao.setBorderPainted(false);
        }
    }

    private void carregarPerguntaAleatoria() {
        try {
            var perguntaDAO = new PerguntaDAO();
            var serieUsuario = usuario.getSerie();
            Pergunta pergunta = perguntaDAO.buscarPerguntaAleatoriaPorSerieEMateria(serieUsuario, idMateriaSelecionada);

            if (pergunta != null) {
                
                System.out.println("Pergunta: " + pergunta.getEnunciado());
                pergunta.getRespostas().forEach(resp
                        -> System.out.println("- " + resp.getResposta().getTexto())
                );
                
            } else {
                JOptionPane.showMessageDialog(this, "Não há perguntas para essa matéria e série.");
            }
            perguntaAtual = pergunta; 


            enunciado.setText(pergunta.getEnunciado());


            List<PerguntaResposta> respostas = pergunta.getRespostas();

            if (respostas.size() > 0) {
                alternativa1jTextArea1.setText(respostas.get(0).getResposta().getTexto());
            }
            if (respostas.size() > 1) {
                alternativa2jTextArea2.setText(respostas.get(1).getResposta().getTexto());
            }
            if (respostas.size() > 2) {
                alternativa3jTextArea3.setText(respostas.get(2).getResposta().getTexto());
            }
            if (respostas.size() > 3) {
                alternativa4jTextArea4.setText(respostas.get(3).getResposta().getTexto());
            }
            if (respostas.size() > 4) {
                alternativa5jTextArea5.setText(respostas.get(4).getResposta().getTexto());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar pergunta: " + e.getMessage());
        }
        alternativa1jButton1.setEnabled(true);
        alternativa2jButton1.setEnabled(true);
        alternativa3jButton1.setEnabled(true);
        alternativa4jButton1.setEnabled(true);
        alternativa5jButton1.setEnabled(true);

        alternativa1jButton1.setVisible(true);
        alternativa2jButton1.setVisible(true);
        alternativa3jButton1.setVisible(true);
        alternativa4jButton1.setVisible(true);
        alternativa5jButton1.setVisible(true);

        alternativa1jTextArea1.setVisible(true);
        alternativa2jTextArea2.setVisible(true);
        alternativa3jTextArea3.setVisible(true);
        alternativa4jTextArea4.setVisible(true);
        alternativa5jTextArea5.setVisible(true);
    }

    private void verificarResposta(int indice) {
        if (perguntaAtual == null || perguntaAtual.getRespostas() == null || indice >= perguntaAtual.getRespostas().size()) {
            JOptionPane.showMessageDialog(this, "Erro ao verificar a resposta.");
            return;
        }

        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza dessa resposta?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            totalRespondidas++;

            PerguntaResposta respostaSelecionada = perguntaAtual.getRespostas().get(indice);

            if (respostaSelecionada.isCorreta()) {
                totalAcertos++;
                JOptionPane.showMessageDialog(this, "Resposta correta! Próxima pergunta.");
                if (totalAcertos == 10) {
                    encerrarPartida();
                } else {
                    carregarPerguntaAleatoria();
                }
            } else {
                PerguntaResposta correta = perguntaAtual.getRespostas().stream()
                        .filter(PerguntaResposta::isCorreta)
                        .findFirst()
                        .orElse(null);

                if (correta != null) {
                    JOptionPane.showMessageDialog(this, "Resposta errada!\nA correta era:\n" + correta.getResposta().getTexto());
                } else {
                    JOptionPane.showMessageDialog(this, "Resposta errada!");
                }
                encerrarPartida();
            }
        }
    }
    
    private void encerrarPartida() {
        try {
            PerguntaDAO dao = new PerguntaDAO();
            String nomeMateria = dao.buscarNomeMateriaPorId(idMateriaSelecionada);

            PontuacaoFinalTela finalTela = new PontuacaoFinalTela(nomeMateria, totalRespondidas, totalAcertos);
            finalTela.setVisible(true);
            this.dispose(); // Fecha a tela atual

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao buscar nome da matéria.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enunciadojScrollPane1 = new javax.swing.JScrollPane();
        enunciado = new javax.swing.JTextArea();
        alternativa1jScrollPane1 = new javax.swing.JScrollPane();
        alternativa1jTextArea1 = new javax.swing.JTextArea();
        alternativa2jScrollPane2 = new javax.swing.JScrollPane();
        alternativa2jTextArea2 = new javax.swing.JTextArea();
        alternativa3jScrollPane3 = new javax.swing.JScrollPane();
        alternativa3jTextArea3 = new javax.swing.JTextArea();
        alternativa4jScrollPane4 = new javax.swing.JScrollPane();
        alternativa4jTextArea4 = new javax.swing.JTextArea();
        alternativa5jScrollPane5 = new javax.swing.JScrollPane();
        alternativa5jTextArea5 = new javax.swing.JTextArea();
        dicaProfessorCinzajLabel = new javax.swing.JLabel();
        pularQuestaoCinzajLabel = new javax.swing.JLabel();
        meioMeioCinzajLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        meioMeiojButton1 = new javax.swing.JButton();
        dicaProfessorjButton1 = new javax.swing.JButton();
        pularQuestaojButton1 = new javax.swing.JButton();
        alternativa1jButton1 = new javax.swing.JButton();
        alternativa2jButton1 = new javax.swing.JButton();
        alternativa3jButton1 = new javax.swing.JButton();
        alternativa4jButton1 = new javax.swing.JButton();
        alternativa5jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        getContentPane().setLayout(null);

        enunciadojScrollPane1.setOpaque(false);

        enunciado.setEditable(false);
        enunciado.setBackground(new Color(0, 0, 0, 0));
        enunciado.setColumns(20);
        enunciado.setFont(new java.awt.Font("Segoe UI Semibold", 1, 28)); // NOI18N
        enunciado.setForeground(Color.WHITE);
        enunciado.setLineWrap(true);
        enunciado.setRows(5);
        enunciado.setToolTipText("");
        enunciado.setWrapStyleWord(true);
        enunciado.setBorder(null);
        enunciado.setOpaque(false);
        enunciadojScrollPane1.setViewportView(enunciado);

        getContentPane().add(enunciadojScrollPane1);
        enunciadojScrollPane1.setBounds(130, 40, 640, 80);

        alternativa1jScrollPane1.setOpaque(false);

        alternativa1jTextArea1.setEditable(false);
        alternativa1jTextArea1.setBackground(new Color(0, 0, 0, 0));
        alternativa1jTextArea1.setColumns(20);
        alternativa1jTextArea1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 25)); // NOI18N
        alternativa1jTextArea1.setForeground(Color.WHITE);
        alternativa1jTextArea1.setLineWrap(true);
        alternativa1jTextArea1.setRows(5);
        alternativa1jTextArea1.setWrapStyleWord(true);
        alternativa1jTextArea1.setBorder(null);
        alternativa1jTextArea1.setOpaque(false);
        alternativa1jScrollPane1.setViewportView(alternativa1jTextArea1);

        getContentPane().add(alternativa1jScrollPane1);
        alternativa1jScrollPane1.setBounds(210, 200, 310, 50);

        alternativa2jScrollPane2.setOpaque(false);

        alternativa2jTextArea2.setEditable(false);
        alternativa2jTextArea2.setBackground(new Color(0, 0, 0, 0));
        alternativa2jTextArea2.setColumns(20);
        alternativa2jTextArea2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 25)); // NOI18N
        alternativa2jTextArea2.setForeground(Color.WHITE);
        alternativa2jTextArea2.setLineWrap(true);
        alternativa2jTextArea2.setRows(5);
        alternativa2jTextArea2.setWrapStyleWord(true);
        alternativa2jTextArea2.setBorder(null);
        alternativa2jTextArea2.setOpaque(false);
        alternativa2jScrollPane2.setViewportView(alternativa2jTextArea2);

        getContentPane().add(alternativa2jScrollPane2);
        alternativa2jScrollPane2.setBounds(214, 296, 310, 50);

        alternativa3jScrollPane3.setOpaque(false);

        alternativa3jTextArea3.setEditable(false);
        alternativa3jTextArea3.setBackground(new Color(0, 0, 0, 0));
        alternativa3jTextArea3.setColumns(20);
        alternativa3jTextArea3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 25)); // NOI18N
        alternativa3jTextArea3.setForeground(Color.WHITE);
        alternativa3jTextArea3.setLineWrap(true);
        alternativa3jTextArea3.setRows(5);
        alternativa3jTextArea3.setWrapStyleWord(true);
        alternativa3jTextArea3.setBorder(null);
        alternativa3jTextArea3.setOpaque(false);
        alternativa3jScrollPane3.setViewportView(alternativa3jTextArea3);

        getContentPane().add(alternativa3jScrollPane3);
        alternativa3jScrollPane3.setBounds(210, 390, 310, 50);

        alternativa4jScrollPane4.setOpaque(false);

        alternativa4jTextArea4.setEditable(false);
        alternativa4jTextArea4.setBackground(new Color(0, 0, 0, 0));
        alternativa4jTextArea4.setColumns(20);
        alternativa4jTextArea4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 25)); // NOI18N
        alternativa4jTextArea4.setForeground(Color.WHITE);
        alternativa4jTextArea4.setLineWrap(true);
        alternativa4jTextArea4.setRows(5);
        alternativa4jTextArea4.setWrapStyleWord(true);
        alternativa4jTextArea4.setBorder(null);
        alternativa4jTextArea4.setOpaque(false);
        alternativa4jScrollPane4.setViewportView(alternativa4jTextArea4);

        getContentPane().add(alternativa4jScrollPane4);
        alternativa4jScrollPane4.setBounds(210, 480, 310, 60);

        alternativa5jScrollPane5.setOpaque(false);

        alternativa5jTextArea5.setEditable(false);
        alternativa5jTextArea5.setBackground(new Color(0, 0, 0, 0));
        alternativa5jTextArea5.setColumns(20);
        alternativa5jTextArea5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 25)); // NOI18N
        alternativa5jTextArea5.setForeground(Color.WHITE);
        alternativa5jTextArea5.setLineWrap(true);
        alternativa5jTextArea5.setRows(5);
        alternativa5jTextArea5.setWrapStyleWord(true);
        alternativa5jTextArea5.setBorder(null);
        alternativa5jTextArea5.setOpaque(false);
        alternativa5jScrollPane5.setViewportView(alternativa5jTextArea5);

        getContentPane().add(alternativa5jScrollPane5);
        alternativa5jScrollPane5.setBounds(214, 576, 310, 60);

        dicaProfessorCinzajLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoDicaProfessorCinza.png"))); // NOI18N
        dicaProfessorCinzajLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dicaProfessorCinzajLabelMouseClicked(evt);
            }
        });
        getContentPane().add(dicaProfessorCinzajLabel);
        dicaProfessorCinzajLabel.setBounds(760, 330, 150, 120);

        pularQuestaoCinzajLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoPularCinza.png"))); // NOI18N
        pularQuestaoCinzajLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pularQuestaoCinzajLabelMouseClicked(evt);
            }
        });
        getContentPane().add(pularQuestaoCinzajLabel);
        pularQuestaoCinzajLabel.setBounds(900, 330, 140, 120);

        meioMeioCinzajLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoCinquentaCinquentaCinza.png"))); // NOI18N
        meioMeioCinzajLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                meioMeioCinzajLabelMouseClicked(evt);
            }
        });
        getContentPane().add(meioMeioCinzajLabel);
        meioMeioCinzajLabel.setBounds(610, 330, 140, 120);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/TelaPerguntas.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1080, 720));
        jLabel1.setMinimumSize(new java.awt.Dimension(1080, 720));
        jLabel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 720);

        meioMeiojButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoAdicionarPerguntas (1).png"))); // NOI18N
        meioMeiojButton1.setText("jButton1");
        meioMeiojButton1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/poliedro/teste/imagem/folder/BotaoAdicionarPerguntas (1).png"))); // NOI18N
        meioMeiojButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meioMeiojButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(meioMeiojButton1);
        meioMeiojButton1.setBounds(635, 333, 110, 110);

        dicaProfessorjButton1.setText("jButton1");
        dicaProfessorjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dicaProfessorjButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(dicaProfessorjButton1);
        dicaProfessorjButton1.setBounds(780, 340, 100, 100);

        pularQuestaojButton1.setText("jButton1");
        pularQuestaojButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pularQuestaojButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(pularQuestaojButton1);
        pularQuestaojButton1.setBounds(920, 340, 110, 100);

        alternativa1jButton1.setBackground(new Color(0, 0, 0, 0));
        alternativa1jButton1.setBorder(null);
        alternativa1jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa1jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa1jButton1);
        alternativa1jButton1.setBounds(110, 193, 100, 60);

        alternativa2jButton1.setBackground(new Color(0, 0, 0, 0));
        alternativa2jButton1.setBorder(null);
        alternativa2jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa2jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa2jButton1);
        alternativa2jButton1.setBounds(110, 293, 100, 60);

        alternativa3jButton1.setBackground(new Color(0, 0, 0, 0));
        alternativa3jButton1.setBorder(null);
        alternativa3jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa3jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa3jButton1);
        alternativa3jButton1.setBounds(110, 383, 100, 70);

        alternativa4jButton1.setBackground(new Color(0, 0, 0, 0));
        alternativa4jButton1.setBorder(null);
        alternativa4jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa4jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa4jButton1);
        alternativa4jButton1.setBounds(110, 483, 100, 60);

        alternativa5jButton1.setBackground(new Color(0, 0, 0, 0));
        alternativa5jButton1.setBorder(null);
        alternativa5jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa5jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa5jButton1);
        alternativa5jButton1.setBounds(110, 573, 100, 80);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alternativa1jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa1jButton1ActionPerformed
        verificarResposta(0);
    }//GEN-LAST:event_alternativa1jButton1ActionPerformed

    private void alternativa2jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa2jButton1ActionPerformed
        verificarResposta(1);
    }//GEN-LAST:event_alternativa2jButton1ActionPerformed

    private void alternativa3jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa3jButton1ActionPerformed
        verificarResposta(2);
    }//GEN-LAST:event_alternativa3jButton1ActionPerformed

    private void alternativa4jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa4jButton1ActionPerformed
        verificarResposta(3);
    }//GEN-LAST:event_alternativa4jButton1ActionPerformed

    private void alternativa5jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa5jButton1ActionPerformed
        verificarResposta(4);
    }//GEN-LAST:event_alternativa5jButton1ActionPerformed

    private void meioMeiojButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meioMeiojButton1ActionPerformed
        if (usouMeioMeio) {
            JOptionPane.showMessageDialog(this, "Você já usou a dica 50/50.");
            return;
        }

        usouMeioMeio = true;

        List<JButton> botoes = Arrays.asList(
                alternativa1jButton1,
                alternativa2jButton1,
                alternativa3jButton1,
                alternativa4jButton1,
                alternativa5jButton1
        );

        List<JTextArea> textos = Arrays.asList(
                alternativa1jTextArea1,
                alternativa2jTextArea2,
                alternativa3jTextArea3,
                alternativa4jTextArea4,
                alternativa5jTextArea5
        );

        String respostaCorreta = perguntaAtual.getRespostas()
                .stream()
                .filter(PerguntaResposta::isCorreta)
                .findFirst()
                .map(pr -> pr.getResposta().getTexto())
                .orElse("");

        JButton botaoCorreto = null;
        JTextArea textoCorreto = null;
        List<Integer> indicesErrados = new ArrayList<>();

        for (int i = 0; i < perguntaAtual.getRespostas().size(); i++) {
            String texto = perguntaAtual.getRespostas().get(i).getResposta().getTexto();
            if (texto.equals(respostaCorreta)) {
                botaoCorreto = botoes.get(i);
                textoCorreto = textos.get(i);
            } else {
                indicesErrados.add(i);
            }
        }

        Collections.shuffle(indicesErrados);
        int indiceErradoVisivel = indicesErrados.get(0);

        
        for (int i = 1; i < indicesErrados.size(); i++) {
            int idx = indicesErrados.get(i);
            botoes.get(idx).setVisible(false);
            textos.get(idx).setVisible(false);
        }
        
        botaoCorreto.setVisible(true);
        textoCorreto.setVisible(true);

        botoes.get(indiceErradoVisivel).setVisible(true);
        textos.get(indiceErradoVisivel).setVisible(true);
        
        meioMeioCinzajLabel.setVisible(true);   
        meioMeiojButton1.setEnabled(false);
    }//GEN-LAST:event_meioMeiojButton1ActionPerformed

    private void dicaProfessorjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dicaProfessorjButton1ActionPerformed
        if (usouDicaProfessor) {
            JOptionPane.showMessageDialog(this, "Você já usou a dica do professor.");
            return;
        }
        usouDicaProfessor = true;

        String dica = perguntaAtual.getDica();
        if (dica != null && !dica.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Dica do professor: " + dica);
        } else {
            JOptionPane.showMessageDialog(this, "Não há dica cadastrada para esta pergunta.");
        }
        dicaProfessorCinzajLabel.setVisible(true);
        dicaProfessorjButton1.setEnabled(false);
    }//GEN-LAST:event_dicaProfessorjButton1ActionPerformed

    private void pularQuestaojButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pularQuestaojButton1ActionPerformed
        if (usouPular) {
            JOptionPane.showMessageDialog(this, "Você já usou a dica de pular pergunta.");
            return;
        }
        usouPular = true;
       
        carregarPerguntaAleatoria();
        
        pularQuestaoCinzajLabel.setVisible(true);
        pularQuestaojButton1.setEnabled(false);
    }//GEN-LAST:event_pularQuestaojButton1ActionPerformed

    private void meioMeioCinzajLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meioMeioCinzajLabelMouseClicked
        JOptionPane.showMessageDialog(this, "Você já usou a dica 50/50.");
    }//GEN-LAST:event_meioMeioCinzajLabelMouseClicked

    private void pularQuestaoCinzajLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pularQuestaoCinzajLabelMouseClicked
        JOptionPane.showMessageDialog(this, "Você já usou a dica de pular pergunta.");
    }//GEN-LAST:event_pularQuestaoCinzajLabelMouseClicked

    private void dicaProfessorCinzajLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dicaProfessorCinzajLabelMouseClicked
        JOptionPane.showMessageDialog(this, "Você já usou a dica do professor.");
    }//GEN-LAST:event_dicaProfessorCinzajLabelMouseClicked
  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alternativa1jButton1;
    private javax.swing.JScrollPane alternativa1jScrollPane1;
    private javax.swing.JTextArea alternativa1jTextArea1;
    private javax.swing.JButton alternativa2jButton1;
    private javax.swing.JScrollPane alternativa2jScrollPane2;
    private javax.swing.JTextArea alternativa2jTextArea2;
    private javax.swing.JButton alternativa3jButton1;
    private javax.swing.JScrollPane alternativa3jScrollPane3;
    private javax.swing.JTextArea alternativa3jTextArea3;
    private javax.swing.JButton alternativa4jButton1;
    private javax.swing.JScrollPane alternativa4jScrollPane4;
    private javax.swing.JTextArea alternativa4jTextArea4;
    private javax.swing.JButton alternativa5jButton1;
    private javax.swing.JScrollPane alternativa5jScrollPane5;
    private javax.swing.JTextArea alternativa5jTextArea5;
    private javax.swing.JLabel dicaProfessorCinzajLabel;
    private javax.swing.JButton dicaProfessorjButton1;
    private javax.swing.JTextArea enunciado;
    private javax.swing.JScrollPane enunciadojScrollPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel meioMeioCinzajLabel;
    private javax.swing.JButton meioMeiojButton1;
    private javax.swing.JLabel pularQuestaoCinzajLabel;
    private javax.swing.JButton pularQuestaojButton1;
    // End of variables declaration//GEN-END:variables
}

