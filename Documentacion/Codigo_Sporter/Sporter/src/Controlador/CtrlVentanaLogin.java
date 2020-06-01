// Autor: Francisco Javier SAntiburcio Vicente

package Controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Vistas.VentanaLogin;

public class CtrlVentanaLogin implements ActionListener{
	
	private VentanaLogin ventana;
	
	public CtrlVentanaLogin(VentanaLogin ventana) {
		super();
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals("INICIAR SESION")) {
			try {
				System.out.println("INICIAR SESION");
				ventana.iniciarSesion();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (comando.contentEquals("CREAR USUARIO")){
			ventana.crearUsuario();
		}
		
	}
}
