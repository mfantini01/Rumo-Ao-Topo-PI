package projetointegrador.poliedro.persistencia;

import projetointegrador.poliedro.modelo.Serie;
import projetointegrador.poliedro.modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "SELECT id_serie FROM tb_usuario WHERE email_usuario = ? AND senha_usuario = ?";

        try (
                var conexao = new ConnectionFactory().obterConexao(); var ps = conexao.prepareStatement(sql)) {

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getSenha());

            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    int serie = rs.getInt("id_serie");

                    // Traduz o número para o nome da série
                    return switch (serie) {
                        case 1 ->
                            "1° ano";
                        case 2 ->
                            "2° ano";
                        case 3 ->
                            "3° ano";
                        default ->
                            null;
                    };
                } else {
                    return null;
                }
            }
        }
    }

    public List<Serie> obterSeries() throws Exception {
        var series = new ArrayList<Serie>();
        var sql = "SELECT id_serie, nome_serie FROM tb_serie";

        try (
                var conexao = new ConnectionFactory().obterConexao(); var ps = conexao.prepareStatement(sql); var rs = ps.executeQuery()) {
            while (rs.next()) {
                var codigo = rs.getInt("id_serie");
                var nome = rs.getString("nome_serie");
                var curso = new Serie(codigo, nome);
                series.add(curso);
            }
        }

        return series;
    }

}

