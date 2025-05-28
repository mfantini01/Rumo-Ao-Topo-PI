package projetointegrador.poliedro.persistencia;

import projetointegrador.poliedro.modelo.Serie;
import projetointegrador.poliedro.modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import projetointegrador.poliedro.modelo.Materia;
import projetointegrador.poliedro.modelo.NivelDificuldade;

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
    public List<Materia> obterMaterias() throws Exception {
        var materias = new ArrayList<Materia>();
        var sql = "SELECT id_materia, nome_materia FROM tb_materia";

        try (
                var conexao = new ConnectionFactory().obterConexao(); var ps = conexao.prepareStatement(sql); var rs = ps.executeQuery()) {
            while (rs.next()) {
                var codigo = rs.getInt("id_materia");
                var nome = rs.getString("nome_materia");
                var curso = new Materia(codigo, nome);
                materias.add(curso);
            }
        }

        return materias;
    }
    
    public List<NivelDificuldade> obterNivel() throws Exception {
        var dificuldade = new ArrayList<NivelDificuldade>();
        var sql = "SELECT id_nivel, dificuldade FROM tb_nivel_dificuldade";

        try (
                var conexao = new ConnectionFactory().obterConexao(); var ps = conexao.prepareStatement(sql); var rs = ps.executeQuery()) {
            while (rs.next()) {
                var codigo = rs.getInt("id_materia");
                var nivel = rs.getString("nome_materia");
                var nd = new NivelDificuldade(codigo, nivel);
                dificuldade.add(nd);
            }
        }

        return dificuldade;
    }
}

