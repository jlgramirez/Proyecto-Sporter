package Modelo;
import java.sql.SQLException;
import java.sql.Statement;

public class Administrador extends Usuario{
	
	public Administrador(Statement command, int id) throws SQLException {
		super(command, id);
		if(!getAdmin()) {
			throw new RuntimeException("No eres admin");
		}
	}
	
	public void eliminarUsuario(Persona persona) {
		try {
			command.execute("DELETE FROM `spoter`.`usuarios` WHERE (`idUsuarios` = '" + persona.getId() + "')");
		} catch (SQLException e) {
			throw new RuntimeException("No existe ese id de usuario");
		}
	}
	public void eliminarEvento (Evento evento) throws SQLException{
		command.execute("DELETE FROM `spoter`.`evento` WHERE (`id_Evento` = '"+evento.getId()+"');");
	}
}
