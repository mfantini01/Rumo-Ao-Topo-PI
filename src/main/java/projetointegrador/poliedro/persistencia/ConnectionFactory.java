
package projetointegrador.poliedro.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactory {
    
    private static final Dotenv dotenv = Dotenv.load();
    private String host = "mysql-f3dbf01-matheus-4ae4.l.aivencloud.com";
    private String port = "22564";
    private String db = "rumo_ao_topo";
    private String user = dotenv.get("USER");
    private String password = dotenv.get("PASSWORD");  

    
    public Connection obterConexao() throws Exception{
        var s = String.format(
            "jdbc:mysql://%s:%s/%s?sslMode=REQUIRED",
            host, port, db
        );
        //cláusula catch or declare
        Connection c = DriverManager.getConnection(s, user, password);
        return c;
    }
    
    public static void main(String[] args) throws Exception {
        var fabricaDeConexoes = new ConnectionFactory();
        Connection conexao = fabricaDeConexoes.obterConexao();
        if(conexao != null){
            System.out.println("Conectou!");
        }
        else{
            System.out.println("Não conectou");
        }
    }
    
}

