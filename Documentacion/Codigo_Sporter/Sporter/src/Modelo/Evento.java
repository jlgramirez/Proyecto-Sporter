package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Evento {
	private int id;
	private String ubicacion;
	private Integer numeroParticipantes;
	private String fecha;
	private int deporte;
	private int organiza;
	
	private Statement command;

	
	public Evento(Statement command) {
		id = -1;ubicacion = null;numeroParticipantes = -1;fecha=null;deporte = -1;
		this.command = command;
	}
	
	public Evento(Statement command,int id) throws SQLException {
		this.command = command;
		this.id = id;
		ResultSet data = command.executeQuery("SELECT * FROM spoter.evento even where even.id_Evento = "+id+";"); 
		data.next();
		deporte = data.getInt(6);
		ubicacion = data.getString(2);
		numeroParticipantes = data.getInt(3);
		fecha = data.getString(4);
		
		organiza = data.getInt(5);
	}
	
	
	//Setters y getters
	public int getId() {
		return id;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(String ubicacion) throws SQLException {
		command.execute("UPDATE `spoter`.`evento` SET `ubicacion` = '"+ ubicacion +"' WHERE (`id_Evento` = '" + id +"');");
		this.ubicacion = ubicacion;
		
	}
	
	public Integer getNumeroParticipantes() {
		return numeroParticipantes;
	}
	
	public void setNumeroParticipantes(Integer numeroParticipantes) throws SQLException {
		command.execute("UPDATE `spoter`.`evento` SET `numParticipantesAct` = '"+ numeroParticipantes +"' WHERE (`id_Evento` = '" + id +"');");
		this.numeroParticipantes = numeroParticipantes;
	}
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) throws SQLException {
		command.execute("UPDATE `spoter`.`evento` SET `fecha` = '"+ fecha +"' WHERE (`id_Evento` = '" + id +"');");
		this.fecha = fecha;
	}
	public int getDeporte() {
		return deporte;
	}
	public void setDeporte(int deporte) throws SQLException {
		command.execute("UPDATE `spoter`.`evento` SET `deporte` = '"+ deporte +"' WHERE (`id_Evento` = '" + id +"');");
		this.deporte = deporte;
	}
	//Final setters getters
	
	
	//En el diagrama ponia devolver un evento, pero he dejado esta clase como la representacion de ese evento
	public void crearEvento(Persona persona, int deporte,String ubicacion,String fecha,int numeroParcipantes) throws SQLException {
		command.execute("INSERT INTO `spoter`.`evento` (`ubicacion`, `numParticipantesAct`, `fecha`, `Creador`, `Deporte`)"
				+ " VALUES ('"+ubicacion+"', '"+numeroParcipantes+"', '"+fecha+"', '"+persona.getId()+"', '"+deporte+"');");
		this.ubicacion = ubicacion;this.numeroParticipantes = numeroParcipantes;this.deporte = deporte;

		ResultSet data = command.executeQuery("Select id_Evento,creador,fecha from spoter.evento order by id_Evento desc;");
		data.next();
		id = data.getInt(1);
		organiza = data.getInt(2);
		this.fecha = data.getString(3);
	}
	
	public void modificar_evento(int usuario,String ubicacion,String fecha,int deporte) throws SQLException {
		if(organiza==usuario) {
			if(ubicacion != null) setUbicacion(ubicacion);
			if(fecha != null) setFecha(fecha);
			if(deporte != -1) setDeporte(deporte);
		}
	}
	
	public void borrarevento(Persona persona) throws SQLException {
		if(organiza == persona.getId()) {
			command.execute("delete from spoter.evento where id_Evento = "+this.id+";");
		}
	}
	
	public void unirse(Persona persona) throws SQLException {
		command.execute("INSERT INTO `spoter`.`usuarios_has_evento` (`usuarios_idUsuarios`, `evento_id_Evento`) VALUES ('"+persona.getId()+"', '"+id+"');");
	}
	
	public void dejarEvento(Persona persona) throws SQLException {
		command.execute("DELETE FROM `spoter`.`usuarios_has_evento` WHERE (`usuarios_idUsuarios` = '"+persona.getId()+"') and (`evento_id_Evento` = '"+id+"');");
	}
}