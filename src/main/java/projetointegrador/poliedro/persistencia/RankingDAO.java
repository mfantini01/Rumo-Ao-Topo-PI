
package projetointegrador.poliedro.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import projetointegrador.poliedro.modelo.Ranking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

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
}
