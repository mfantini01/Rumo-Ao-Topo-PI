package projetointegrador.poliedro.modelo;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import projetointegrador.poliedro.persistencia.ConnectionFactory;

@Getter
@Setter
@AllArgsConstructor
public class Usuario {
    private String email, tipo, nome, senha;
    private int codigo;
    
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
   
    private int id;
   
    public Usuario() {
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
        
    }
    public Usuario(String email, String senha, String tipo) {
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
}
    
    public Usuario(int codigo, String email, String nome) {
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
    }
    public Usuario(String nome, String email, String senha, int codigoSerie) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.codigo = codigoSerie; 
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
    
