
package projetointegrador.poliedro.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import projetointegrador.poliedro.modelo.Usuario;

public class UsuarioDAO {
    public void cadastrar(Usuario u) throws Exception{
        var fabricaDeConexoes = new ConnectionFactory();
        var conexao = fabricaDeConexoes.obterConexao();
        var sql = "INSERT INTO tb_usuario(nome_usuario, email_usuario, senha_usuario, id_serie) VALUES (?, ?, ?, ?)";
        //3. Preparar o comando por meio da conexão 
        PreparedStatement ps = conexao.prepareStatement(sql);
        //4. Substituir oe eventuais placeholders
        ps.setString(1, u.getNome());
        ps.setString(2, u.getEmail());
        ps.setString(3, u.getSenha());
        ps.setInt(4, u.getCodigo());
        ps.execute();
        ps.close();
        conexao.close();
        
    }
    public void atualizar(Usuario u) throws Exception{
        var fabricaDeConexoes = new ConnectionFactory();
        var sql = "UPDATE tb_usuario SET nome_usuario=?, email_usuario=? WHERE id_usuario=?";
        try(
            var conexao = fabricaDeConexoes.obterConexao();
            var ps = conexao.prepareStatement(sql);
                
        ){
            ps.setString(1, u.getNome());
            ps.setString(3, u.getEmail());
            ps.setInt(4, u.getCodigo());
            ps.execute();
        }
    }
    public void listar()throws Exception{
        var sql = "SELECT * FROM tb_usuario";
        var fabricaDeConexoes = new ConnectionFactory();
        try(
            var conexao = fabricaDeConexoes.obterConexao();
            var ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            while(rs.next()){
                var nome = rs.getString("nome");
                var email = rs.getString("email");
                System.out.printf("%s %s\n", nome, email);
            } 
            
        }
    }

    private String getSenha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

