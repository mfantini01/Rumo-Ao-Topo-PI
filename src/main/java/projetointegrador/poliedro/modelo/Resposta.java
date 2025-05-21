
package projetointegrador.poliedro.modelo;


import lombok.*;

@Getter
@Setter
@ToString

public class Resposta {
    private int idResposta;
    private String textoResposta;
    private boolean correta;
    private Pergunta pergunta; // Referência à pergunta associada

    // Construtor vazio
    public Resposta() {
    }

    // Construtor completo
    public Resposta(int idResposta, String textoResposta, boolean correta, Pergunta pergunta) {
        this.idResposta = idResposta;
        this.textoResposta = textoResposta;
        this.correta = correta;
        this.pergunta = pergunta;
    }


    // Método para exibir a resposta
    public void exibirResposta() {
        System.out.println("Resposta: " + textoResposta);
        System.out.println("Correta: " + (correta ? "Sim" : "Não"));
        if (pergunta != null) {
            System.out.println("Pergunta relacionada:");
            pergunta.exibirPergunta(); // Usa método da classe Pergunta
        }
    }
}

