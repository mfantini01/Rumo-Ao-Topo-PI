
package projetointegrador.poliedro.modelo;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class Pergunta {
    private int id;
    private String enunciado;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private String alternativaE;
    private String respostaCorreta;
    private String materia;
    private String serie;
    private String dificuldade;

   
    public Pergunta(int id, String enunciado, String alternativaA, String alternativaB, String alternativaC,
                    String alternativaD, String alternativaE, String respostaCorreta, String materia,
                    String serie, String dificuldade) {
        this.id = id;
        this.enunciado = enunciado;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
        this.alternativaE = alternativaE;
        this.respostaCorreta = respostaCorreta;
        this.materia = materia;
        this.serie = serie;
        this.dificuldade = dificuldade;
    }
    
    public void exibirPergunta() {
        System.out.println("Pergunta: " + enunciado);
        System.out.println("A) " + alternativaA);
        System.out.println("B) " + alternativaB);
        System.out.println("C) " + alternativaC);
        System.out.println("D) " + alternativaD);
        System.out.println("E) " + alternativaE);
    }
}

    
    

