package projetointegrador.poliedro.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import projetointegrador.poliedro.modelo.Ranking;
import projetointegrador.poliedro.modelo.Usuario;

public class RankingDAO {

    public void inserir(Ranking r) throws Exception {
        var fabrica = new ConnectionFactory();
        var conexao = fabrica.obterConexao();
        var sql = "INSERT INTO tb_ranking (id_usuario, mes_ano, pontuacao_total, posicao) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, r.getIdUsuario());
        ps.setString(2, r.getMesAno());
        ps.setInt(3, r.getPontuacaoTotal());
        ps.setInt(4, r.getPosicao());
        ps.execute();
        ps.close();
        conexao.close();
    }

    public List<Ranking> listar() throws Exception {
        var fabrica = new ConnectionFactory();
        var conexao = fabrica.obterConexao();
        var sql = "SELECT * FROM tb_ranking";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Ranking> lista = new ArrayList<>();
        while (rs.next()) {
            Ranking r = new Ranking();
            r.setIdRanking(rs.getInt("id_ranking"));
            r.setIdUsuario(rs.getInt("id_usuario"));
            r.setMesAno(rs.getString("mes_ano"));
            r.setPontuacaoTotal(rs.getInt("pontuacao_total"));
            r.setPosicao(rs.getInt("posicao"));
            lista.add(r);
        }
        rs.close();
        ps.close();
        conexao.close();
        return lista;
    }

    public List<Ranking> listarComUsuariosESerie() throws Exception {
        var fabrica = new ConnectionFactory();
        var conexao = fabrica.obterConexao();
        var sql = """
            SELECT r.*, u.nome_usuario, s.nome_serie
            FROM tb_ranking r
            JOIN tb_usuario u ON r.id_usuario = u.id_usuario
            JOIN tb_serie s ON u.id_serie = s.id_serie
            ORDER BY r.pontuacao_total DESC
        """;
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Ranking> lista = new ArrayList<>();
        while (rs.next()) {
            Ranking r = new Ranking();
            r.setIdRanking(rs.getInt("id_ranking"));
            r.setIdUsuario(rs.getInt("id_usuario"));
            r.setMesAno(rs.getString("mes_ano"));
            r.setPontuacaoTotal(rs.getInt("pontuacao_total"));
            r.setPosicao(rs.getInt("posicao"));
            // Campos adicionais (se existirem na classe Ranking)
            r.setNomeUsuario(rs.getString("nome_usuario"));
            r.setNomeSerie(rs.getString("nome_serie"));
            lista.add(r);
        }
        rs.close();
        ps.close();
        conexao.close();
        return lista;
    }

    public List<Ranking> listarPorPeriodo(String mesAno) throws Exception {
        var fabrica = new ConnectionFactory();
        var conexao = fabrica.obterConexao();
        var sql = """
            SELECT r.*, u.nome_usuario, s.nome_serie
            FROM tb_ranking r
            JOIN tb_usuario u ON r.id_usuario = u.id_usuario
            JOIN tb_serie s ON u.id_serie = s.id_serie
            WHERE r.mes_ano = ?
            ORDER BY r.pontuacao_total DESC
        """;
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, mesAno);
        ResultSet rs = ps.executeQuery();
        List<Ranking> lista = new ArrayList<>();
        while (rs.next()) {
            Ranking r = new Ranking();
            r.setIdRanking(rs.getInt("id_ranking"));
            r.setIdUsuario(rs.getInt("id_usuario"));
            r.setMesAno(rs.getString("mes_ano"));
            r.setPontuacaoTotal(rs.getInt("pontuacao_total"));
            r.setPosicao(rs.getInt("posicao"));
            r.setNomeUsuario(rs.getString("nome_usuario"));
            r.setNomeSerie(rs.getString("nome_serie"));
            lista.add(r);
        }
        rs.close();
        ps.close();
        conexao.close();
        return lista;
    }
    public List<Ranking> listarComUsuarios() throws Exception {
        var fabrica = new ConnectionFactory();
        var conexao = fabrica.obterConexao();

        String sql = """
        SELECT r.posicao, r.pontuacao_total, r.mes_ano, 
               u.nome_usuario, u.id_serie 
        FROM tb_ranking r
        JOIN tb_usuario u ON r.id_usuario = u.id_usuario
        ORDER BY r.posicao ASC
    """;

        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Ranking> lista = new ArrayList<>();
        while (rs.next()) {
            Ranking r = new Ranking();
            r.setPosicao(rs.getInt("posicao"));
            r.setPontuacaoTotal(rs.getInt("pontuacao_total"));
            r.setMesAno(rs.getString("mes_ano"));

            // Informações do usuário vinculadas
            Usuario u = new Usuario();
            u.setNome(rs.getString("nome_usuario"));
            u.setCodigo(rs.getInt("id_serie")); 

            r.setUsuario(u); 
            lista.add(r);
        }

        rs.close();
        ps.close();
        conexao.close();

        return lista;
    }

}
