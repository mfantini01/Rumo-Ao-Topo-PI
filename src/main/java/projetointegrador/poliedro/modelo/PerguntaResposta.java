/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetointegrador.poliedro.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor // ✅ Adicionado para permitir uso do construtor vazio
public class PerguntaResposta {

    private Pergunta pergunta;
    private Resposta resposta;
    private boolean correta;

    @Override
    public String toString() {
        return "PerguntaResposta{"
                + "pergunta=" + (pergunta != null ? pergunta.getEnunciado() : "null")
                + ", resposta=" + (resposta != null ? resposta.getTexto() : "null")
                + ", correta=" + correta
                + '}';
    }
}
