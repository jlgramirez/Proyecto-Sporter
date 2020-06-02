package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import vistas.VentanaFormularioLogin;

public class CtrlVentanaFrmLogin implements ActionListener{
	
	private VentanaFormularioLogin ventana;
	
	public CtrlVentanaFrmLogin(VentanaFormularioLogin ventana) {
		super();
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.contentEquals("CREAR")) {
			System.out.print("HOLA");
			try {
				ventana.crearPerfil();
			}catch (SQLException e1){
				e1.printStackTrace();
			}
		}else if(comando.contentEquals("CANCELAR")){
			ventana.cerrarVentana();
		}
		
	}
	

}
