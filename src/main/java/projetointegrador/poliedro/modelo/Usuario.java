package projetointegrador.poliedro.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import projetointegrador.poliedro.persistencia.ConnectionFactory;



@Getter
@Setter
@AllArgsConstructor
public class Usuario {
    private String email, senha, tipo;
    
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario autenticar(Usuario u) throws Exception {
    var sql = "SELECT tipo_usuario FROM tb_usuario WHERE email_usuario=? AND senha_usuario=?";
    
    try (
        var conexao = new ConnectionFactory().obterConexao();
        var ps = conexao.prepareStatement(sql)
    ) {
        ps.setString(1, u.getEmail());
        ps.setString(2, u.getSenha());

        try (var rs = ps.executeQuery()) {
            if (rs.next()) {
                String tipo = rs.getString("tipo_usuario");
                return new Usuario(u.getEmail(), u.getSenha(), tipo); // lembre de ter esse construtor
            } else {
                return null;
            }
        }
    }
}

}
    
