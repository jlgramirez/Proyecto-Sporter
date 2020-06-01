// Autor; Jose Luis Gonzalez Ramirez

package Vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Conexion.Conexion;
import Modelo.Administrador;
import Modelo.Deporte;
import Modelo.Evento;
import Modelo.Persona;
import Modelo.Ubicacion;
import Modelo.Usuario;
import Render.Render;
import Render.Mimodelo;
import Render.Mimodelo2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import colores.Colores;
import imagenes.Imagenes;
import Modelo.Administrador.*;



public class VentanaAdministrador extends JFrame  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Colores colores = new Colores();
	private Imagenes imagenes = new Imagenes();
	private JPanel contentPane;
	protected static Statement command;
	private ArrayList<Evento> listaEventos;
	
	private Choice choice_Deporte,choice_Ubicacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conexion conexion = new Conexion();
					command = conexion.getcommand();
					VentanaAdministrador frame = new VentanaAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	public void VentanaAdministrador() throws SQLException {
		
		Conexion conexion = new Conexion();
		command = conexion.getcommand();
		
		String[] titulos = new String[] {
				"Propietario", "Deporte", "Ubicacion", "Participantes", "fecha", " "
			};
		
		//Object[][] datos = obtenerMatrizDatos(titulos);
		
		// si se pulsa filtrar cargar tabla nueva con
		int idDeporte;
		Deporte deporte = new Deporte(command);
		idDeporte = deporte.obtenerIdDeporte(choice_Deporte.getSelectedItem());
		String ubicacion = choice_Ubicacion.getSelectedItem();
		// falta cargar tablas
		
		
		
	}
	
	*/
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public VentanaAdministrador() throws SQLException{
		
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Sporter");
		setIconImage(imagenes.getLogo_sin_nombreEscalado(16, 16));
		setForeground(colores.getNaranja());
		setBackground(colores.getNaranja());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 334);
		contentPane = new JPanel();
		contentPane.setBackground(colores.getVerde());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(6, 62, 61, 16);
		lblDeporte.setForeground(colores.getAmarillo());
		contentPane.add(lblDeporte);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setBounds(165, 62, 68, 16);
		lblUbicacion.setForeground(colores.getAmarillo());
		contentPane.add(lblUbicacion);
		
		JButton btFiltro = new JButton("Filtrar");
		btFiltro.setBounds(358, 57, 117, 29);
		btFiltro.setForeground(colores.getNaranja());
		contentPane.add(btFiltro);
		btFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
			}
		});	
		
		choice_Deporte = new Choice();
		choice_Deporte.setBounds(65, 58, 100, 27);
		contentPane.add(choice_Deporte);
		
		
		choice_Ubicacion = new Choice();
		choice_Ubicacion.setBounds(232, 58, 120, 27);
		contentPane.add(choice_Ubicacion);
		
		cargarChoiceDeporte(choice_Deporte);
		cargarChoiceUbicacion(choice_Ubicacion);
		
		
		JButton btCerrarSesion = new JButton("Cerrar sesion");
		btCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});		
		btCerrarSesion.setBounds(659, 6, 117, 29);
		contentPane.add(btCerrarSesion);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setBounds(554, 11, 108, 16);
		contentPane.add(lblAdministrador);
		
		JToggleButton btnPerfil = new JToggleButton("Perfil");
		btnPerfil.setForeground(colores.getNaranja());
		btnPerfil.setBounds(481, 6, 61, 39);
		contentPane.add(btnPerfil);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
			}
		});	
		// tabla derecha Eliminar Eventos 
		
		@SuppressWarnings("serial")
		Mimodelo t = new Mimodelo();
		
		JButton btnEliminar = new javax.swing.JButton("Eliminar");
		btnEliminar.setName("e");
		
		JTable tabla = new javax.swing.JTable();
		tabla.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar}
	            },
	            new String [] {
	                "Propietario", "Deporte", "Ubicacion", "Participantes", "Fecha", " "
	            }
	        ));			
		    
			tabla.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                tablaMouseClicked(evt);
	            }

				private void tablaMouseClicked(MouseEvent evt) {
					// TODO Auto-generated method stub
					
				}
	        });
		
	    JScrollPane scrollPaneEventos = new JScrollPane();
	    scrollPaneEventos.setBounds(6, 114, 539, 192);
	    scrollPaneEventos.setViewportView(tabla);
	    contentPane.add(scrollPaneEventos);			
		scrollPaneEventos.setColumnHeaderView(btnEliminar);			
		
		//String[] titulos = new String[] {
		//		"Propietario", "Deporte", "Ubicacion", "Participantes", "fecha", " "
		//	};
		
		//listaEventos = obtenerMatrizDatos(,btnEliminar);
		
		t.ver_tabla(tabla);
		
		
		
		// tabla derecha Eliminar Usuarios
		
		Mimodelo2 t1 = new Mimodelo2();
		JButton btn2Eliminar = new javax.swing.JButton("Eliminar");
		btn2Eliminar.setName("ee");
		
		
		
		JTable tabla1 = new javax.swing.JTable();
		
		tabla1.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, btn2Eliminar},
	                {null, btn2Eliminar},
	                {null, btn2Eliminar},
	                {null, btn2Eliminar},
	                {null, btn2Eliminar},
	                {null, btn2Eliminar},
	                {null, btn2Eliminar},
	                {null, btn2Eliminar},
	                {null, btn2Eliminar},
	                {null, btn2Eliminar},
	                {null, btn2Eliminar}
	            },
	            new String [] {
	                "Nombre Usuario",  " "
	            }
	        ));
		JScrollPane scrollPaneNonmbreUsuario = new JScrollPane();
		scrollPaneNonmbreUsuario .setBounds(566, 114, 221, 192);
		scrollPaneNonmbreUsuario .setViewportView(tabla1);
		contentPane.add(scrollPaneNonmbreUsuario );
		scrollPaneNonmbreUsuario.setColumnHeaderView(btn2Eliminar);
		
		//String[] titulos2 = new String[] {
		//		"Nombre Usuarios",  " "
		//	};
		
		//Object informacion2[][]= obtenerMatrizDatos(titulos2,btn2Eliminar);   
		
		t1.ver_tabla(tabla1);
		
		tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                tablaMouseClicked(evt);
	            }

	            private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
			        
			        int column = tabla1.getColumnModel().getColumnIndexAtX(evt.getX());
			        int row = evt.getY()/tabla1.getRowHeight();
			        
			        if(row < tabla1.getRowCount() && row >= 0 && column < tabla1.getColumnCount() && column >= 0){
			            Object value = tabla1.getValueAt(row, column);
			            if(value instanceof JButton){
			                ((JButton)value).doClick();
			                JButton boton = (JButton) value;

			             
			                if(boton.getName().equals("ee")){
			                    JOptionPane.showConfirmDialog(null, "Desea eliminar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
			                    System.out.println("Click en el boton eliminar");
			                    Object id;
								//EVENTOS ELIMINAR
			                    
			                
			                }
			            }
			        
			        }
			        
			    }//GEN-LAST:event_tablaMouseClicked
	        });
	       
	     
	
	}
	
    
	
	private Object[][] obtenerMatrizDatos(ArrayList<String> st, JButton btnEliminar){
		
		Object informacion[][] = new String[listaEventos.size()][st.size()];
		for(int x = 0; x < informacion.length; x++){
			informacion[x][0] = listaEventos.get(x).getId() + "";
			informacion[x][1] = listaEventos.get(x).getDeporte() + "";
			informacion[x][2] = listaEventos.get(x).getUbicacion() + "";
			informacion[x][3] = listaEventos.get(x).getNumeroParticipantes() + "";
			informacion[x][4] = listaEventos.get(x).getFecha() + "";
			informacion[x][5] = btnEliminar;
		}
		return informacion;
	}
	
	
	private Object[][] obtenerMatrizUsuarios(ArrayList<String> st, JButton btn2Eliminar){
		Object informacion[][] = new String[listaEventos.size()][st.size()];
		for(int x = 0; x < informacion.length; x++){
			informacion[x][0] = listaEventos.get(x).getId() + "";
			informacion[x][1] = btn2Eliminar;
		}
		return informacion;
	}
   
	
	//Metodo para rellenar los items del choice de deporte
			private void cargarChoiceDeporte(Choice c) throws SQLException {
				Conexion conexion = new Conexion();
				command = conexion.getcommand();
				
				Deporte deporte = new Deporte(command);
				List<String> listDeporte = deporte.obtenerListaDeporte();
				for(String item : listDeporte) {
					c.add(item);
				}
			}
			
			//Metodo para rellenar los items del choice de ubicacion
			private void cargarChoiceUbicacion(Choice c) {
				Ubicacion ub = new Ubicacion();
				List<String> listUbicacion = ub.getListUbicacion();
				for(String item : listUbicacion) {
					c.add(item);
				} 
	
			}
	
			public void cerrarVentana() {
				this.dispose();
			}	
			
}

