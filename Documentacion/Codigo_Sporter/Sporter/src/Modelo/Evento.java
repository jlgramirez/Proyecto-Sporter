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
		fecha = data.getDate(4);
		
		organiza = data.getInt(5);
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) throws SQLException {
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
	
	//En el diagrama ponia devolver un evento, pero he dejado esta clase como la representacion de ese evento
	public void crearEvento(String ubicacion, int numeroParcipantes,Date fecha,int creador,int deporte) throws SQLException {
		command.execute("INSERT INTO `spoter`.`evento` (`ubicacion`, `numParticipantesAct`, `fecha`, `Creador`, `Deporte`)"
				+ " VALUES ('"+ubicacion+"', '"+numeroParcipantes+"', '"+fecha+"', '"+creador+"', '"+deporte+"');");
		this.ubicacion = ubicacion;this.numeroParticipantes = numeroParcipantes;this.fecha = fecha;

		ResultSet data = command.executeQuery("Select id_Evento,creador from spoter.evento order by idEvento desc;");
		data.next();
		id = data.getInt(1);
		creador = data.getInt(2);
	}
	
	public void modificar_evento(int usuario,String ubicacion,Date fecha,int deporte) throws SQLException {
		if(organiza==usuario) {
			if(ubicacion != null) setUbicacion(ubicacion);
			if(fecha != null) setFecha(fecha);
			if(deporte != -1) setDeporte(deporte);
		}
	}
	
	public void borrarevento(int usuario) throws SQLException {
		if(organiza == usuario) {
			command.execute("DELETE FROM `spoter`.`evento` WHERE (`idUsuarios` = '\" + id + \"')");
		}
	}
	
	public void unirse(int usuario) throws SQLException {
		command.execute("INSERT INTO `spoter`.`usuarios_has_evento` (`usuarios_idUsuarios`, `evento_id_Evento`) VALUES ('"+usuario+"', '"+id+"');");
	}
	
	public void dejarEvento(int usuario) throws SQLException {
		command.execute("DELETE FROM `spoter`.`usuarios_has_evento` WHERE (`usuarios_idUsuarios` = '"+usuario+"') and (`evento_id_Evento` = '"+id+"');");
	}
}