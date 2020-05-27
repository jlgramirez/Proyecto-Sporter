package Testing;

import java.sql.*;

public class Conexion {
	
	private Statement command;
	
	public Conexion() throws SQLException {
		command = DriverManager.getConnection("jdbc:mysql://localhost:3306/spoter", "root", "escorpio99").createStatement();
	}
	public Statement getcommand() {
		return command;
	}
}
