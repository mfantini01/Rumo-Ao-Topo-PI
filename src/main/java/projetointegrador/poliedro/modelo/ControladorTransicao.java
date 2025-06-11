
package projetointegrador.poliedro.modelo;

import projetointegrador.poliedro.telas.TelaJogoIniciando;
import projetointegrador.poliedro.telas.TelaPartida;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTransicao {
    private TelaJogoIniciando telaJogoIniciando;
    private TelaPartida telaPartida;
    private String materiaSelecionada;
    
    public ControladorTransicao(String materiaSelecionada) {
        this.materiaSelecionada = materiaSelecionada;
    }

    public void iniciarPartida() {
        
        telaJogoIniciando = new TelaJogoIniciando();
        telaJogoIniciando.setLocationRelativeTo(null);  
        telaJogoIniciando.setVisible(true);

        
        int delay = 5000;

        
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaJogoIniciando.dispose();

                
                telaPartida = new TelaPartida(materiaSelecionada);
                telaPartida.setVisible(true);
            }
        });

        timer.setRepeats(false);
        timer.start();
    }
}
