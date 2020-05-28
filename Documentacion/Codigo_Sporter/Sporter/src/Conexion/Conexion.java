package Conexion;

import java.sql.*;

public class Conexion {
	
	private Statement command;
	
	public Conexion() throws SQLException {
		command = DriverManager.getConnection("jdbc:mysql://localhost:3306/spoter", "root", "7544").createStatement();
	}
	public Statement getcommand() {
		return command;
	}
}
