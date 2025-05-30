
package projetointegrador.poliedro.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projetointegrador.poliedro.modelo.Pergunta;
import projetointegrador.poliedro.modelo.PerguntaResposta;


public class PerguntaDAO {

        public void cadastrar(Pergunta p) throws Exception {
            var fabricaDeConexoes = new ConnectionFactory();
            var conexao = fabricaDeConexoes.obterConexao();

            // Inserir pergunta
           
            System.out.println("ID da matéria:" + p.getIdMateria());
            var sql = "INSERT INTO tb_pergunta(enunciado, id_materia, id_serie, dificuldade, dica_pergunta) VALUES (?, ?, ?, ?, ?)";
            System.out.println("SQL usada:" +  sql);
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
            }

            psPergunta.close();

            // Inserir respostas
            var sqlResp = "INSERT INTO tb_resposta(texto_resposta, id_pergunta) VALUES (?,?)";
            var sqlRespPerg = "INSERT INTO tb_pergunta_resposta(id_resposta, id_pergunta, correta) VALUES (?, ?, ?)";
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
        var lista = new ArrayList<String[]>();

        var sql = """
        SELECT 
            p.enunciado,
            s.nome_serie,
            p.dificuldade,
            m.nome_materia
        FROM 
            tb_pergunta p
        JOIN 
            tb_serie s ON p.id_serie = s.id_serie
        JOIN 
            tb_materia m ON p.id_materia = m.id_materia
    """;

        var fabricaDeConexoes = new ConnectionFactory();
        var conexao = fabricaDeConexoes.obterConexao();

        var ps = conexao.prepareStatement(sql);
        var rs = ps.executeQuery();

        while (rs.next()) {
            String[] linha = new String[4];
            linha[0] = rs.getString("enunciado");
            linha[1] = rs.getString("nome_serie");

            // Conversão de dificuldade (1, 2, 3) para texto
            int nivel = rs.getInt("dificuldade");
            String dificuldadeTexto;
            switch (nivel) {
                case 1 ->
                    dificuldadeTexto = "Fácil";
                case 2 ->
                    dificuldadeTexto = "Médio";
                case 3 ->
                    dificuldadeTexto = "Difícil";
                default ->
                    dificuldadeTexto = "Desconhecido";
            }

            linha[2] = dificuldadeTexto;
            linha[3] = rs.getString("nome_materia");

            lista.add(linha);
        }

        rs.close();
        ps.close();
        conexao.close();

        return lista;
    }
        
        




    }


