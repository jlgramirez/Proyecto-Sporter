// Autor : Daniel Cuevas Pérez
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Modelo.Deporte;
import Modelo.Persona;
import Vistas.VentanaFrmCrearEvento;

public class CtrlVentanaCrearEvento implements ActionListener {
	
	private VentanaFrmCrearEvento vista;
	
	public CtrlVentanaCrearEvento(VentanaFrmCrearEvento v){
		super();
		vista = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals("CREAR") ) {
			try {
				vista.crearEvento();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
