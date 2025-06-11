
package projetointegrador.poliedro.modelo;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pergunta {

    private int id;
    private String enunciado;
    private int idMateria;
    private int idSerie;
    private int nivelDificuldade;
    private String dica;
    private List<PerguntaResposta> respostas = new ArrayList<>();

    private String nomeMateria;
    private String nomeSerie;

    public Pergunta(String texto) {
        this.enunciado = texto;
        this.respostas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Pergunta{" + "enunciado=" + enunciado + ", respostas=" + respostas + '}';
    }
    public Pergunta(int id, String enunciado, String dica) {
        this.id = id;
        this.enunciado = enunciado;
        this.dica = dica;
    }
   
    public void exibirPergunta() {
        System.out.println("Enunciado: " + enunciado);
        System.out.println("Dica: " + dica);
        System.out.println("Matéria: " + nomeMateria);
        System.out.println("Série: " + nomeSerie);
        System.out.println("Nível de Dificuldade: " + nivelDificuldade);
        System.out.println("Respostas:");
        for (int i = 0; i < respostas.size(); i++) {
            System.out.println((i + 1) + ") " + respostas.get(i).getResposta().getTexto());
        }
    }

    
    public boolean verificarResposta(int indice) {
        if (indice < 0 || indice >= respostas.size()) {
            return false;
        }
        return respostas.get(indice).isCorreta();
    }
}

    
    

