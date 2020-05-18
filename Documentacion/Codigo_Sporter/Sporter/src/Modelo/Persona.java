package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Persona extends Usuario{
	
	private int id;
	private String localidad;
	
	public Persona(Statement command) {
		super(command);
		id = -1;
		localidad = null;
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
		ResultSet data = command.executeQuery("Select idUsuarios from spoter.Usuarios;");
		int id = 1;
		while(data.next()) id++;
		command.execute("INSERT INTO `spoter`.`usuarios` (`idUsuarios`, `nombre`, `email`, `password`, `admin`, `localidad`) VALUES "
				+ "('"+ id +"', '"+ nombre +"', '"+ email +"', '"+ password +"', '"+ 0 +"', '"+ localidad +"');");
		
		this.id = id;this.localidad = localidad;this.nombre = nombre;this.email = email;this.password = password;
	}
}
