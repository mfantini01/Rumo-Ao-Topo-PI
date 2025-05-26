package projetointegrador.poliedro.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Serie {
        private int codigo;
        private String nome ;
    
    @Override
    
    public String toString(){
        return nome;
    }
}

