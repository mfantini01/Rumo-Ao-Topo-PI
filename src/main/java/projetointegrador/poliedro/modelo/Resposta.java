
package projetointegrador.poliedro.modelo;


import lombok.*;

@Getter
@Setter


public class Resposta {
    private int codigo;
    private String texto;
    
     

    
    public Resposta(String texto) {
        this.texto = texto;
    }
    @Override
    public String toString(){
        return "Resposta{" + "texto=" + texto +'}';
    }
    
    
}

