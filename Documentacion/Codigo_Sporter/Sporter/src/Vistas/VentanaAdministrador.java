package Vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Conexion.Conexion;
import Modelo.Evento;
import Modelo.Persona;
import Render.Render;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import colores.Colores;
import imagenes.Imagenes;

public class VentanaAdministrador extends JFrame  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table1;
	private JButton btnEliminar;
	private Colores colores = new Colores();
	private Imagenes imagenes = new Imagenes();
	private JPanel contentPane;
	protected Statement command;
	private JList<Evento> listDeportes;
	private JList<Evento> listLocalizacion;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdministrador frame = new VentanaAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private VentanaAdministrador(){
		setTitle("Sporter");
		setIconImage(imagenes.getLogo_sin_nombreEscalado(16, 16));
		setForeground(colores.getNaranja());
		setBackground(colores.getNaranja());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 334);
		contentPane = new JPanel();
		contentPane.setBackground(colores.getVerde());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(6, 62, 61, 16);
		contentPane.add(lblDeporte);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setBounds(165, 62, 68, 16);
		contentPane.add(lblUbicacion);
		
		JButton btFiltro = new JButton("filtro");
		btFiltro.setBounds(364, 57, 117, 29);
		contentPane.add(btFiltro);
		
		JComboBox comboBoxDeporte = new JComboBox();
		comboBoxDeporte.setBounds(65, 58, 100, 27);
		contentPane.add(comboBoxDeporte);
		
		JComboBox comboBoxUbicacion = new JComboBox();
		comboBoxUbicacion.setBounds(232, 58, 120, 27);
		contentPane.add(comboBoxUbicacion);
		
		JButton btCerrarSesion = new JButton("Cerrar sesion");
		btCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btCerrarSesion.setBounds(629, 6, 117, 29);
		contentPane.add(btCerrarSesion);
		//CerrarSesion.addActionListener(new ActionListener()) {
		//	public void actionPerformer(ActionEvent e) {
		//		System.exit(0);
		//	}
		//}
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setBounds(524, 11, 108, 16);
		contentPane.add(lblAdministrador);
		
		JToggleButton btnPerfil = new JToggleButton("Perfil");
		btnPerfil.setBounds(353, 6, 161, 29);
		contentPane.add(btnPerfil);
		
		// tabla derecha Eliminar Eventos 
		
		JButton btnEliminar = new javax.swing.JButton("Eliminar");
		btnEliminar.setName("e");
		
	 
		JTable tabla = new javax.swing.JTable();
		tabla.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, null, btnEliminar}
	            },
	            new String [] {
	                "Propietario", "Deporte", "Ubicacion", "Participantes", "Fecha", " "
	            }
	        ));			
			tabla.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	        //        //tablaMouseClicked(evt);
	            }
	        });
	        
	    JScrollPane scrollPaneEventos = new JScrollPane();
	    scrollPaneEventos.setBounds(6, 114, 475, 192);
	    scrollPaneEventos.setViewportView(tabla);
	    contentPane.add(scrollPaneEventos);			
		scrollPaneEventos.setColumnHeaderView(btnEliminar);			
		
		tabla.setDefaultRenderer(Object.class, new Render());			
		
		tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());
		
		// tabla derecha Eliminar Usuarios
		JButton btn2Eliminar = new javax.swing.JButton("Eliminar");
		btn2Eliminar.setName("e2");
		
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
	        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt1) {
	                //tablaMouseClicked(evt);
	            }
	        });
		
		
	        JScrollPane scrollPaneNonmbreUsuario = new JScrollPane();
			scrollPaneNonmbreUsuario .setBounds(525, 114, 221, 192);
			scrollPaneNonmbreUsuario .setViewportView(tabla1);
			contentPane.add(scrollPaneNonmbreUsuario );
			scrollPaneNonmbreUsuario.setColumnHeaderView(btn2Eliminar);
			
			tabla1.setDefaultRenderer(Object.class, new Render());
			
			tabla1.setPreferredScrollableViewportSize(tabla.getPreferredSize());
		
			
		

	        
	
	}
	
	 
	
}
