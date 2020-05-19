package Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Connection connection;
	private static Statement command;
	private static ResultSet data;
	private String contraseña;
	
	private final static String database = "jdbc:mysql://localhost:3306/spoter";
	
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce tu contraseña:");
		connection = DriverManager.getConnection(database,"root",sc.next());
		command  = connection.createStatement();
		System.out.println("Introduce prueba:");
		int prueba = 0;
		prueba = sc.nextInt();
		
		if(prueba == 1) {
			Deporte dep = new Deporte(command);
			dep.crearDeporte("a", 10);
		}
		
	}

}
