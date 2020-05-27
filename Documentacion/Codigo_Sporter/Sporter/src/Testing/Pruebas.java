package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.*;

import Modelo.Administrador;
import Modelo.Evento;
import Modelo.Persona;

public class Pruebas {
	static Statement command;
	
	@BeforeAll
	public static void init() throws SQLException {
		Conexion conexion = new Conexion();
		command = conexion.getcommand();
		
		command.execute("SET FOREIGN_KEY_CHECKS = 0;");
		command.execute("TRUNCATE TABLE spoter.evento;");
		command.execute("TRUNCATE TABLE spoter.usuarios;");
		command.execute("TRUNCATE TABLE spoter.deporte;");
		command.execute("TRUNCATE TABLE spoter.usuarios_has_deporte;");
		command.execute("TRUNCATE TABLE spoter.usuarios_has_evento;");
		command.execute("SET FOREIGN_KEY_CHECKS = 1;");
		
		command.execute("INSERT INTO `spoter`.`deporte` (`nombre`, `numParticipantes`) VALUES ('Baloncesto', '10');");
		command.execute("INSERT INTO `spoter`.`deporte` (`nombre`, `numParticipantes`) VALUES ('Futbol', '10');");
		command.execute("INSERT INTO `spoter`.`deporte` (`nombre`, `numParticipantes`) VALUES ('volley', '10');");
	}
	
	// 	CrearPerfil:Se añade un usuario a la base de datos,
	//				Se añade todo correctamente,
	@Test
	public void CrearPerfilyModificar() throws SQLException {
		
		int numUsuarios;
		ResultSet res = command.executeQuery("select count(*) from spoter.usuarios;");
		res.next();
		numUsuarios = res.getInt(1);
		
		Persona persona = new Persona(command);
		
		persona.crearPerfil("a", "a", "a", "a");
		
		res = command.executeQuery("select count(*) from spoter.usuarios;");
		res.next();
		
		assertEquals(res.getInt(1),numUsuarios+1);
		
		numUsuarios++;
		
		res = command.executeQuery("select * from spoter.usuarios where spoter.usuarios.idUsuarios = "+persona.getId()+";");
		res.next();
		
		assertEquals(res.getString(2),persona.getNombre());
		assertEquals(res.getString(3),persona.getEmail());
		assertEquals(res.getString(4), persona.getPassword());
		assertEquals(res.getBoolean(5), persona.getAdmin());
		assertEquals(res.getString(6), persona.getLocalidad());
		
		Persona persona2 = new Persona(command);
		persona2.crearPerfil("b", "b", "b", "b");
		
		res = command.executeQuery("select count(*) from spoter.usuarios;");
		res.next();
		
		assertEquals(res.getInt(1),numUsuarios+1);
		numUsuarios++;
		
	//ModificarPerfil:	Se modifican los datos dados.
		persona2 = new Persona(command,persona2.getId());
		persona2.modificarPerfil("c", "d");
		
		res = command.executeQuery("select nombre,localidad from spoter.usuarios where spoter.usuarios.idUsuarios = "+persona2.getId()+";");
		res.next();
		
		assertEquals(res.getString(1), "c");
		assertEquals(res.getString(2), "d");
		
	//Se Añade deporte correctamente
		persona2.meterDeporte(1);
		
		res = command.executeQuery("select deporte_idDeporte from spoter.usuarios_has_deporte where spoter.usuarios_has_deporte.usuarios_idUsuarios = "+persona2.getId()+";");
		res.next();
		
		assertEquals(res.getInt(1), 1);
		
	}
	
	@Test
	public void FuncionesAdmin() throws SQLException {
		int id = 0;
		command.execute("INSERT INTO `spoter`.`usuarios` (`nombre`, `email`, `password`, `admin`, `localidad`) VALUES ('e', 'e', 'e', '1', 'e');");
		ResultSet res = command.executeQuery("SELECT idUsuarios FROM spoter.usuarios;");
		while(res.next()) id = res.getInt(1);
		Administrador admin = new Administrador(command, id);
		command.execute("INSERT INTO `spoter`.`usuarios` (`nombre`, `email`, `password`, `admin`, `localidad`) VALUES ('f', 'f', 'f', '0', 'f');");
		Persona persona = new Persona(command,id+1);
		
		res = command.executeQuery("select count(*) from spoter.usuarios;");
		res.next();
		int num = res.getInt(1);
		
		admin.eliminarUsuario(persona);
		
		res = command.executeQuery("select count(*) from spoter.usuarios;");
		res.next();
		
		assertEquals(res.getInt(1), num-1);
		
		command.execute("INSERT INTO `spoter`.`evento` (`ubicacion`, `numParticipantesAct`, `fecha`, `Creador`, `Deporte`) VALUES ('a', '10', '11/11/11', '1', '1');");
		
		res = command.executeQuery("SELECT id_Evento FROM spoter.evento;");
		while(res.next()) id = res.getInt(1);
		
		res = command.executeQuery("select count(*) from spoter.evento;");
		res.next();
		num = res.getInt(1);
		
		Evento evento = new Evento(command,id);
		
		admin.eliminarEvento(evento);
		
		res = command.executeQuery("select count(*) from spoter.evento;");
		res.next();
		
		assertEquals(res.getInt(1), num-1);
	}
	
	@Test
	public void EventoGuardaBienEventos() throws SQLException {
		command.execute("INSERT INTO `spoter`.`usuarios` (`nombre`, `email`, `password`, `admin`, `localidad`) VALUES ('h', 'h', 'h', '0', 'h');");
		int id = 0;
		ResultSet res = command.executeQuery("SELECT idUsuarios FROM spoter.usuarios;");
		
		while(res.next()) id = res.getInt(1);
		Persona persona  = new Persona(command, id);
		
		command.execute("INSERT INTO `spoter`.`evento` (`ubicacion`, `numParticipantesAct`, `fecha`, `Creador`, `Deporte`) VALUES ('b', '10', '11/11/11', '"+id+"', '1');");
		
		
		res = command.executeQuery("SELECT id_Evento FROM spoter.evento order by id_Evento desc;");
		res.next();
		
		id = res.getInt(1);
		Evento evento = new Evento(command, id);
		
		res = command.executeQuery("Select * from spoter.evento where id_Evento = "+id+"");
		res.next();
		
		assertEquals(res.getInt(1), evento.getId());
		assertEquals(res.getString(2), evento.getUbicacion());
		assertEquals(res.getInt(3), evento.getNumeroParticipantes());
		assertEquals(res.getString(4), evento.getFecha());
		assertEquals(res.getInt(6), evento.getDeporte());
		
		evento= new Evento(command);
		evento.crearEvento(persona, 1, "k", "11/11/11", 10);
		
		res = command.executeQuery("Select * from spoter.evento where id_Evento = "+ evento.getId() +"");
		res.next();
		
		assertEquals(res.getInt(1), evento.getId());
		assertEquals(res.getString(2), evento.getUbicacion());
		assertEquals(res.getInt(3), evento.getNumeroParticipantes());
		assertEquals(res.getString(4), evento.getFecha());
		assertEquals(res.getInt(6), evento.getDeporte());
		
	}
	
	@Test
	public void BorrarEvento() throws SQLException {
		command.execute("INSERT INTO `spoter`.`usuarios` (`nombre`, `email`, `password`, `admin`, `localidad`) VALUES ('i', 'i', 'i', '0', 'i');");
		
		int id;
		int Creador;
		ResultSet res = command.executeQuery("SELECT idUsuarios FROM spoter.usuarios order by idUsuarios desc;");
		res.next();
		Creador = res.getInt(1);
		
		command.execute("INSERT INTO `spoter`.`evento` (`ubicacion`, `numParticipantesAct`, `fecha`, `Creador`, `Deporte`) VALUES ('m', '10', '11/11/11', '"+Creador+"', '1');");
		
		res = command.executeQuery("SELECT id_Evento FROM spoter.evento order by id_Evento desc;");
		res.next();
		id = res.getInt(1);
		
		int numero;
		res = command.executeQuery("SELECT Count(*) FROM spoter.evento;");
		res.next();
		numero = res.getInt(1);
		
		Evento evento = new Evento(command, id);
		Persona persona = new Persona(command,Creador);
		
		//Borrar evento
		evento.borrarevento(persona);
		
		res = command.executeQuery("SELECT Count(*) FROM spoter.evento;");
		res.next();
		
		assertEquals(res.getInt(1), numero-1);
	}
	@Test
	public void UnirseEvento() {
		
	}
}
