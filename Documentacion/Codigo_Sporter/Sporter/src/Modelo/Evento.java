package Modelo;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Evento {
	private int id;
	private String ubicacion;
	private Integer numeroParticipantes;
	private Date fecha;
	private String deporte;
	private Statement command;
	
	public Evento(Statement command,int id) throws SQLException {
		this.command = command;
		this.id = id;
		ResultSet data = command.executeQuery("SELECT * FROM spoter.evento even where even.id_Evento = "+id+";"); 
		data.next();
		deporte = data.getString(6);
		ubicacion = data.getString(2);
		numeroParticipantes = data.getInt(3);
		fecha = data.getDate(4);
	}
	
	public String getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(String ubicacion) throws SQLException {
		ResultSet data = command.executeQuery("UPDATE `spoter`.`evento` SET `ubicacion` = '"+ ubicacion +"' WHERE (`id_Evento` = '" + id +"');");
		this.ubicacion = ubicacion;
		
	}
	
	public Integer getNumeroParticipantes() {
		return numeroParticipantes;
	}
	
	public void setNumeroParticipantes(Integer numeroParticipantes) throws SQLException {
		command.execute("UPDATE `spoter`.`evento` SET `numParticipantesAct` = '"+ numeroParticipantes +"' WHERE (`id_Evento` = '" + id +"');");
		this.numeroParticipantes = numeroParticipantes;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) throws SQLException {
		command.execute("UPDATE `spoter`.`evento` SET `fecha` = '"+ fecha +"' WHERE (`id_Evento` = '" + id +"');");
		this.fecha = fecha;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
}
