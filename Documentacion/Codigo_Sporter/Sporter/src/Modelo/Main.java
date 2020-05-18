package Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

public class Main {
	//hola
	private static Connection connection;
	private static Statement command;
	private static ResultSet data;
	
	private final static String database = "jdbc:mysql://localhost:3306/spoter";
	
	public static void main(String[] args) throws SQLException {
		connection = DriverManager.getConnection(database,"root","7544");
		command  = connection.createStatement();
		
		Persona persona = new Persona(command);
		persona.crearPerfil("dani", "M�laga", "daniel@gmail.com", "7544");
	}

}
