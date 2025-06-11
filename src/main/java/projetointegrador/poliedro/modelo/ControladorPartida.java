/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetointegrador.poliedro.modelo;
import projetointegrador.poliedro.modelo.Pergunta;
import projetointegrador.poliedro.modelo.PerguntaResposta;
import projetointegrador.poliedro.modelo.Usuario;
import projetointegrador.poliedro.modelo.Ranking;
import projetointegrador.poliedro.persistencia.RankingDAO;
import projetointegrador.poliedro.modelo.PontuacaoUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ControladorPartida {

    private final List<Pergunta> perguntas;
    private final Usuario usuario;
    private int pontos;
    private int checkpoint;

    public ControladorPartida(List<Pergunta> perguntas, Usuario usuario) {
        this.perguntas = perguntas;
        this.usuario = usuario;
        this.pontos = 0;
        this.checkpoint = 0;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < perguntas.size(); i++) {
            Pergunta pergunta = perguntas.get(i);
            System.out.println("\\nPergunta " + (i + 1) + ": " + pergunta.getEnunciado());

            List<PerguntaResposta> alternativas = pergunta.getRespostas();
            for (int j = 0; j < alternativas.size(); j++) {
                System.out.println((j + 1) + ") " + alternativas.get(j).getResposta().getTexto());
            }

            int resposta = scanner.nextInt() - 1;
            PerguntaResposta selecionada = alternativas.get(resposta);

            if (selecionada.isCorreta()) {
                int pontosGanhos = PontuacaoUtil.getPontuacaoPorOrdem(i + 1);
                pontos += pontosGanhos;
                System.out.println("✅ Correta! + " + pontosGanhos + " pontos. Total: " + pontos);

                if (i == 2 || i == 6) {
                    checkpoint = pontos;
                    System.out.println("💾 Checkpoint salvo com " + checkpoint + " pontos.");
                }

            } else {
                System.out.println("❌ Incorreta! Você perdeu, mas seu último checkpoint foi de " + checkpoint + " pontos.");
                pontos = checkpoint;
                break;
            }
        }

        salvarPontuacao();
    }

    private void salvarPontuacao() {
        try {
            Ranking ranking = new Ranking();
            ranking.setIdUsuario(usuario.getId());
            ranking.setPontuacaoTotal(pontos);
            ranking.setMesAno(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/yyyy")));
            ranking.setPosicao(0); // será ajustada depois

            new RankingDAO().inserir(ranking);

            System.out.println("\\n🏁 Partida finalizada com " + pontos + " pontos! Pontuação salva no ranking.");
        } catch (Exception e) {
            System.err.println("Erro ao salvar pontuação: " + e.getMessage());
        }
    }
}