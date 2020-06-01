//Autor: Jose Luis Gonzalez Ramirez

package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import Modelo.Deporte;
import Modelo.Persona;
import Vistas.VentanaAdministrador;



	
	public class CtrlVentanaAdministrador implements ActionListener, ItemListener {
		
		private VentanaAdministrador vista;
		
		public CtrlVentanaAdministrador(VentanaAdministrador v){
			super();
			vista = v;
		}

		// metodo que controla los eventos producidos por los botones de la ventana Administrador
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			
			if(comando.equals("ADMINISTRADOR") ) {
				try {
					vista.VentanaAdministrador();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}else if (comando.contentEquals("CANCELAR")) {
				vista.cerrarVentana();
			}
			
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
		}

		

	}


