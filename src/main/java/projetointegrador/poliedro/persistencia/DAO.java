
package projetointegrador.poliedro.persistencia;

import projetointegrador.poliedro.modelo.Usuario;
import projetointegrador.poliedro.persistencia.ConnectionFactory;

public class DAO {
    public boolean existe(Usuario u)throws Exception{
        var sql = "SELECT email_usuario, senha_usuario FROM tb_usuario WHERE email_usuario=? AND senha_usuario=?"; // Comando SQL
        try (
             var conexao = new ConnectionFactory().obterConexao();
             var ps = conexao.prepareStatement(sql);
        ){
            ps.setString(1, u.getEmail());
            ps.setString(2, u.getSenha());
            try(
                var rs = ps.executeQuery();
            ){
                return rs.next();
            }
        }
    }
}

