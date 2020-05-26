package Modelo;
import java.sql.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
	private static Connection connection;
	private static Statement command;
	private static ResultSet data;
	private String contrasenia;
	
	private final static String database = "jdbc:mysql://localhost:3306/spoter";
	
	public static void main(String[] args) throws SQLException, ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce tu contrase�a:");
		connection = DriverManager.getConnection(database,"root",sc.next());
		command  = connection.createStatement();
		System.out.println("Introduce prueba:");
		int prueba = 0;
		prueba = sc.nextInt();
		//Deporte
		if(prueba == 1) {
			System.out.println("Ponga nombre del deporte:");
			String deporte = sc.next();
			System.out.println("Ponga numpart del deporte:");
			int numpart = sc.nextInt();
			Deporte dep = new Deporte(command);
			dep.crearDeporte(deporte, numpart);
		//Persona
		}else if(prueba == 2) {
			System.out.println("Ponga nombre de usuario:");
			String nombre = sc.next();
			System.out.println("Ponga email de usuario:");
			String email = sc.next();
			System.out.println("Ponga localidad de usuario:");
			String localidad = sc.next();
			System.out.println("Ponga password de usuario:");
			String password = sc.next();
			
			
			Persona per = new Persona(command);
			per.crearPerfil(nombre, localidad, email, password);
		//Evento -- nose poner la fecha
		}else if(prueba == 3) {
			System.out.println("Ponga ubicacion de usuario:");
			String ubicacion = sc.next();
			System.out.println("Ponga numeroParticipantes de usuario:");
			int numeroParcipantes = sc.nextInt();
			System.out.println("Ponga fecha de usuario:");
			String fecha = sc.next();
			SimpleDateFormat sim= new SimpleDateFormat("dd/MM/yyyy");
			Date date = (Date) sim.parse(fecha);
			System.out.println("Ponga deporte de usuario:");
			int deporte = sc.nextInt();
			System.out.println("Ponga creador de usuario:");
			int creador = sc.nextInt();
			
			Evento even = new Evento(command);
			even.crearEvento(ubicacion, numeroParcipantes, date, creador, deporte);
		}
		
	}

}