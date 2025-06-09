package projetointegrador.poliedro.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ranking {

    private int idRanking;
    private int idUsuario;
    private String mesAno;
    private int pontuacaoTotal;
    private int posicao;
    
    private Usuario usuario; 

    // Campos adicionais (apenas para exibição, não afetam banco de dados diretamente)
    private String nomeUsuario;
    private String nomeSerie;
}
