package projetointegrador.poliedro.persistencia;

import projetointegrador.poliedro.modelo.Usuario;
import java.sql.*;

public class DAO {
    public boolean existe(Usuario u) throws Exception {
        String sql = "SELECT * FROM tb_usuario WHERE email_usuario = ? AND senha_usuario = ?";

        try (
            Connection conexao = new ConnectionFactory().obterConexao();
            PreparedStatement ps = conexao.prepareStatement(sql)
        ) {
            ps.setString(1, u.getEmail()); // login aqui é o email
            ps.setString(2, u.getSenha());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // se achou, retorna true
            }
        }
    }

    public String obterTipo(Usuario u) throws Exception {
        String sql = "SELECT tipo_usuario FROM tb_usuario WHERE email_usuario = ? AND senha_usuario = ?";

        try (
            Connection conexao = new ConnectionFactory().obterConexao();
            PreparedStatement ps = conexao.prepareStatement(sql)
        ) {
            ps.setString(1, u.getEmail());
            ps.setString(2, u.getSenha());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("tipo_usuario");
                } else {
                    return null;
                }
            }
        }
    }
    
    public String obterSerie(Usuario user) throws Exception {
        String sql = "SELECT serie_usuario FROM tb_usuario WHERE email_usuario = ? AND senha_usuario = ?";

        try (
                var conexao = new ConnectionFactory().obterConexao(); var ps = conexao.prepareStatement(sql)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getSenha());

            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("serie_usuario");
                } else {
                    return null;
                }
            }
        }
    }

}

