package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Deporte {
	private int id;
	private String nombre;
	private int numParticipante;
	
	public Deporte(Statement command,int id ) throws SQLException {
		ResultSet data = command.executeQuery("Select* from spoter.deporte where spoter.deporte.idDeporte = "+id+";"); 
		data.next();
		nombre = data.getString(2);
		numParticipante = data.getInt(3);
	}
	

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumParticipante() {
		return numParticipante;
	}
}
