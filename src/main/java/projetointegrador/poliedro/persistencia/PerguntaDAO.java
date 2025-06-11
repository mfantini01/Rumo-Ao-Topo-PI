
package projetointegrador.poliedro.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import projetointegrador.poliedro.modelo.Pergunta;
import projetointegrador.poliedro.modelo.PerguntaResposta;
import projetointegrador.poliedro.modelo.Resposta;

public class PerguntaDAO {

    public void cadastrar(Pergunta p) throws Exception {
        var fabricaDeConexoes = new ConnectionFactory();
        var conexao = fabricaDeConexoes.obterConexao();

        var sql = "INSERT INTO tb_pergunta(enunciado, id_materia, id_serie, dificuldade, dica_pergunta) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement psPergunta = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        psPergunta.setString(1, p.getEnunciado());
        psPergunta.setInt(2, p.getIdMateria());
        psPergunta.setInt(3, p.getIdSerie());
        psPergunta.setInt(4, p.getNivelDificuldade());
        psPergunta.setString(5, p.getDica());
        psPergunta.executeUpdate();

        ResultSet rs = psPergunta.getGeneratedKeys();
        int idPergunta = 0;
        if (rs.next()) {
            idPergunta = rs.getInt(1);
            p.setId(idPergunta); // ✅ Define o ID da pergunta após inserção
        }
        psPergunta.close();

        String sqlResp = "INSERT INTO tb_resposta(texto_resposta, id_pergunta) VALUES (?,?)";
        String sqlRespPerg = "INSERT INTO tb_pergunta_resposta(id_resposta, id_pergunta, correta) VALUES (?, ?, ?)";
        for (PerguntaResposta r : p.getRespostas()) {
            PreparedStatement psResp = conexao.prepareStatement(sqlResp, Statement.RETURN_GENERATED_KEYS);
            psResp.setString(1, r.getResposta().getTexto());
            psResp.setInt(2, idPergunta);
            psResp.executeUpdate();

            ResultSet rsResp = psResp.getGeneratedKeys();
            int idResposta = 0;
            if (rsResp.next()) {
                idResposta = rsResp.getInt(1);
            }
            psResp.close();

            PreparedStatement psRespPerg = conexao.prepareStatement(sqlRespPerg);
            psRespPerg.setInt(1, idResposta);
            psRespPerg.setInt(2, idPergunta);
            psRespPerg.setBoolean(3, r.isCorreta());
            psRespPerg.execute();
            psRespPerg.close();
        }

        conexao.close();
    }

    public List<String[]> listarPerguntasSimples() throws Exception {
        List<String[]> lista = new ArrayList<>();
        var conexao = new ConnectionFactory().obterConexao();
        var ps = conexao.prepareStatement(
                "SELECT p.id_pergunta, p.enunciado, s.nome_serie, d.dificuldade, m.nome_materia "
                + "FROM tb_pergunta p "
                + "JOIN tb_serie s ON p.id_serie = s.id_serie "
                + "JOIN tb_nivel_dificuldade d ON p.dificuldade = d.id_nivel "
                + "JOIN tb_materia m ON p.id_materia = m.id_materia");
        var rs = ps.executeQuery();

        while (rs.next()) {
            String[] linha = new String[5];
            linha[0] = rs.getString("enunciado");
            linha[1] = rs.getString("nome_serie");
            linha[2] = rs.getString("dificuldade");
            linha[3] = rs.getString("nome_materia");
            linha[4] = String.valueOf(rs.getInt("id_pergunta"));

            lista.add(linha);
        }

        rs.close();
        ps.close();
        conexao.close();

        return lista;
    }

    public Pergunta buscarPerguntaAleatoriaPorSerieEMateria(int idSerie, int idMateria) throws Exception {
        Pergunta pergunta = null;
        var conexao = new ConnectionFactory().obterConexao();

        String sqlPergunta = """
        SELECT * FROM tb_pergunta 
        WHERE id_serie = ? AND id_materia = ? 
        ORDER BY RAND() 
        LIMIT 1
    """;
        PreparedStatement ps = conexao.prepareStatement(sqlPergunta);
        ps.setInt(1, idSerie);
        ps.setInt(2, idMateria);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int idPergunta = rs.getInt("id_pergunta");
            pergunta = new Pergunta();
            pergunta.setId(idPergunta);
            pergunta.setEnunciado(rs.getString("enunciado"));
            pergunta.setIdMateria(rs.getInt("id_materia"));
            pergunta.setIdSerie(rs.getInt("id_serie"));
            pergunta.setNivelDificuldade(rs.getInt("dificuldade"));
            pergunta.setDica(rs.getString("dica_pergunta"));

            String sqlRespostas = """
            SELECT r.texto_resposta, pr.correta 
            FROM tb_resposta r 
            JOIN tb_pergunta_resposta pr ON r.id_resposta = pr.id_resposta 
            WHERE pr.id_pergunta = ?
        """;
            PreparedStatement psRespostas = conexao.prepareStatement(sqlRespostas);
            psRespostas.setInt(1, idPergunta);
            ResultSet rsResp = psRespostas.executeQuery();

            List<PerguntaResposta> respostas = new ArrayList<>();
            while (rsResp.next()) {
                String texto = rsResp.getString("texto_resposta");
                boolean correta = rsResp.getBoolean("correta");

                Resposta resposta = new Resposta(texto);
                resposta.setTexto(texto);

                PerguntaResposta pr = new PerguntaResposta();
                pr.setResposta(resposta);
                pr.setCorreta(correta);

                respostas.add(pr);
            }

            Collections.shuffle(respostas);
            pergunta.setRespostas(respostas);

            rsResp.close();
            psRespostas.close();
        }

        rs.close();
        ps.close();
        conexao.close();

        return pergunta;
    }


   
}


