/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetointegrador.poliedro.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

 @Getter
 @Setter
 @AllArgsConstructor
public class PerguntaResposta {
    private Pergunta pergunta;
    private Resposta resposta;
    private boolean correta;

    @Override
    public String toString() {
        return "PerguntaResposta{" + "pergunta=" + pergunta.getEnunciado() + ", resposta=" + resposta.getTexto() + ", correta=" + correta + '}';
    }
    
    
}
