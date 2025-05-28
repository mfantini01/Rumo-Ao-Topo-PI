/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetointegrador.poliedro.persistencia;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import static org.junit.jupiter.api.Assertions.*;

public class ConnectionFactoryTest {
    @Test
    public void testConexaoH2() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "")) {
            assertNotNull(conn);
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            fail("Erro na conexão: " + e.getMessage());
        }
    }
}
