package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Pruebas {
	
	public Statement base() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/spoter", "root", "escorpio99").createStatement();
	}
	
	@BeforeEach
    public void init() throws SQLException {
		base().execute("SET FOREIGN_KEY_CHECKS = 0; TRUNCATE TABLE spoter.deporte;TRUNCATE TABLE spoter.evento;TRUNCATE TABLE spoter.usuarios;TRUNCATE TABLE spoter.usuarios_has_deporte;TRUNCATE TABLE spoter.usuarios_has_evento;SET FOREIGN_KEY_CHECKS = 0; ");
    }
	
	@Test
    public void InicialmenteLaBaseDeDatosEstaVacia() throws SQLException {
		ResultSet res = base().executeQuery("SELECT COUNT(*) FROM spoter.deporte,SPOTER.EVENTO,SPOTER.usuarios,SPOTER.usuarios_has_deporte,spoter.usuarios_has_evento;");
		assertEquals(res.getInt(1), 0);
	}
}
