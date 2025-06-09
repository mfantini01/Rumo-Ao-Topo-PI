package projetointegrador.poliedro.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import projetointegrador.poliedro.modelo.Usuario;

public class UsuarioDAO {

    public void cadastrar(Usuario u) throws Exception {
        var fabricaDeConexoes = new ConnectionFactory();
        var conexao = fabricaDeConexoes.obterConexao();
        var sql = "INSERT INTO tb_usuario(nome_usuario, email_usuario, senha_usuario, id_serie) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, u.getNome());
        ps.setString(2, u.getEmail());
        ps.setString(3, u.getSenha());
        ps.setInt(4, u.getCodigo());
        ps.execute();
        ps.close();
        conexao.close();
    }

    public void atualizar(Usuario u) throws Exception {
        var fabricaDeConexoes = new ConnectionFactory();
        var sql = "UPDATE tb_usuario SET nome_usuario=?, email_usuario=?, senha_usuario=?, id_serie=? WHERE id_usuario=?";
        try (
                var conexao = fabricaDeConexoes.obterConexao(); var ps = conexao.prepareStatement(sql);) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            ps.setInt(4, u.getCodigo()); // id_serie
            ps.setInt(5, u.getId());     // id_usuario
            ps.executeUpdate();
        }
    }

    public List<Usuario> listar() throws Exception {
        var sql = "SELECT * FROM tb_usuario";
        var fabrica = new ConnectionFactory();
        var conexao = fabrica.obterConexao();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Usuario> lista = new ArrayList<>();
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id_usuario"));
            u.setNome(rs.getString("nome_usuario"));
            u.setEmail(rs.getString("email_usuario"));
            u.setSenha(rs.getString("senha_usuario"));
            u.setCodigo(rs.getInt("id_serie"));
            lista.add(u);
        }
        rs.close();
        ps.close();
        conexao.close();
        return lista;
    }

    public Usuario buscarPorId(int idUsuario) throws Exception {
        var fabrica = new ConnectionFactory();
        var conexao = fabrica.obterConexao();
        var sql = "SELECT * FROM tb_usuario WHERE id_usuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();
        Usuario u = null;
        if (rs.next()) {
            u = new Usuario();
            u.setId(rs.getInt("id_usuario"));
            u.setNome(rs.getString("nome_usuario"));
            u.setEmail(rs.getString("email_usuario"));
            u.setSenha(rs.getString("senha_usuario"));
            u.setCodigo(rs.getInt("id_serie"));
        }
        rs.close();
        ps.close();
        conexao.close();
        return u;
    }
}

