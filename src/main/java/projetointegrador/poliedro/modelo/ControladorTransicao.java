
package projetointegrador.poliedro.modelo;

import projetointegrador.poliedro.telas.TelaJogoIniciando;
import projetointegrador.poliedro.telas.TelaPartida;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTransicao {
    private TelaJogoIniciando telaJogoIniciando;
    private TelaPartida telaPartida;

    public void iniciarPartida() {
        // Cria e exibe a tela "JOGO INICIANDO..."
        telaJogoIniciando = new TelaJogoIniciando();
        telaJogoIniciando.setLocationRelativeTo(null);  // Centraliza a janela
        telaJogoIniciando.setVisible(true);

        // Define o tempo de espera em milissegundos (5 segundos)
        int delay = 5000;

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
