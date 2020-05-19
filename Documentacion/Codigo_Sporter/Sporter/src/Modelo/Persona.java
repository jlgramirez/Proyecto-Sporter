package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Persona extends Usuario{
	
	private int id;
	private String localidad;
	public ArrayList<Integer> participa = new ArrayList<Integer>();
	public ArrayList<Integer> practica = new ArrayList<Integer>();
	
	public Persona(Statement command) {
		super(command);
		id = -1;
		localidad = null;
		participa = null;
	}
	
	public Persona(Statement command, int id) throws SQLException {
		super(command, id);
		this.id = id;
		if(getAdmin()) {
			throw new RuntimeException("Es admin");
		}
		ResultSet data = command.executeQuery("Select localidad from spoter.usuarios user where user.idUsuarios ="+ 1 +";");
		data.next();
		localidad = data.getString(1);
		
		data = command.executeQuery("SELECT evento_id_Evento FROM spoter.usuarios_has_evento where usuarios_idUsuarios = "+id+"; ");
		while(data.next()) participa.add(data.getInt(1));
		
		data = command.executeQuery("SELECT evento_id_Evento FROM spoter.usuarios_has_evento where usuarios_idUsuarios = "+id+"; ");
		while(data.next()) participa.add(data.getInt(1));
	}

	public int getId() {
		return id;
	}

	public String getLocalidad() {
		return localidad;
	}
	
	public void modificarPerfil(String nombre,String localidad) throws SQLException {
		command.execute("UPDATE `spoter`.`usuarios` SET `nombre` = '"+nombre+"', `localidad` = '"+localidad+"' WHERE (`idUsuarios` = "+id+");");
	}
	
	public void crearPerfil(String nombre,String localidad,String email,String password) throws SQLException {
		command.execute("INSERT INTO `spoter`.`usuarios` (`nombre`, `email`, `password`, `admin`, `localidad`) VALUES "
				+ "('"+ nombre +"', '"+ email +"', '"+ password +"', '"+ 0 +"', '"+ localidad +"');");
		
		this.localidad = localidad;this.nombre = nombre;this.email = email;this.password = password;
		ResultSet data = command.executeQuery("Select idUsuarios from spoter.usuarios order by idUsuarios desc;");
		data.next();
		id = data.getInt(1);
	}
}
