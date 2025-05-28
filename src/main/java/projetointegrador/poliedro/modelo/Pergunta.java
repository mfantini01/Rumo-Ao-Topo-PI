
package projetointegrador.poliedro.modelo;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Pergunta {
        private String enunciado;
        private int idMateria;
        private int idSerie;
        private int nivelDificuldade;
        private String dica;
        private List<PerguntaResposta> respostas;    
        
        public Pergunta(String texto){
            this.enunciado = texto;
            respostas = new ArrayList<>();
        }

    @Override
    public String toString() {
        return "Pergunta{" + "texto=" + enunciado + ", respostas=" + respostas + '}';
    }
        
        

    void exibirPergunta() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
}

    
    

