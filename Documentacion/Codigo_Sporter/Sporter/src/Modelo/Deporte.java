package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//He creado clase creardeporte, se puede eliminar, junto al primer constructor;

public class Deporte {
	private int id;
	private String nombre;
	private int numParticipante;
	private Statement command;
	
	public Deporte(Statement command) {
		this.command = command;
	}
	
	public Deporte(Statement command,int id ) throws SQLException {
		ResultSet data = command.executeQuery("Select* from spoter.deporte where spoter.deporte.idDeporte = "+id+";"); 
		data.next();
		nombre = data.getString(2);
		numParticipante = data.getInt(3);
		this.command = command;
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
	
	public void crearDeporte(String deporte, int numpart) throws SQLException {
		command.execute("INSERT INTO `spoter`.`deporte` (`nombre`, `numParticipantes`) VALUES ('"+deporte+"', '"+numpart+"');");
	}
	
}
