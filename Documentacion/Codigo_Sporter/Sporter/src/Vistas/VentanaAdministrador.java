package Vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Modelo.Evento;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import colores.Colores;
import imagenes.Imagenes;

public class VentanaAdministrador extends JFrame  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private Colores colores = new Colores();
	private Imagenes imagenes = new Imagenes();
	private JPanel contentPane;
	
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
		
		
		JLabel lblNewLabel = new JLabel("Deporte");
		lblNewLabel.setBounds(6, 62, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ubicacion");
		lblNewLabel_1.setBounds(165, 62, 68, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("filtro");
		btnNewButton.setBounds(364, 57, 117, 29);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(65, 58, 100, 27);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(232, 58, 120, 27);
		contentPane.add(comboBox_1);
		
		JButton CerrarSesion = new JButton("Cerrar sesion");
		CerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		CerrarSesion.setBounds(629, 6, 117, 29);
		contentPane.add(CerrarSesion);
		
		JButton btnEliminar = new javax.swing.JButton();
		JTable tabla = new javax.swing.JTable();
		tabla.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar},
	                {null, null, null, null, null, btnEliminar}
	            },
	            new String [] {
	                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
	            }
	        ));
	        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                //tablaMouseClicked(evt);
	            }
	        });
	        
	        JScrollPane scrollPane_11 = new JScrollPane();
			scrollPane_11.setBounds(6, 114, 475, 192);
			scrollPane_11.setViewportView(tabla);
			contentPane.add(scrollPane_11);
		
		JPanel panel = new JPanel();
		panel.setBounds(528, 114, 218, 176);
		contentPane.add(panel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(19, 114, 319, 192);
		panel.add(scrollPane_2);
		JList list_2 = new JList();
		contentPane.add(list_2);
		//CerrarSesion.addActionListener(new ActionListener()) {
		//	public void actionPerformer(ActionEvent e) {
		//		System.exit(0);
		//	}
		//}
		
		/*
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new CompoundBorder());
		scrollPane.setBounds(6, 90, 475, 216);
		frmSpoter.getContentPane().add(scrollPane);
		
		JTable fondo = new JTable();
		fondo.setBorder(new CompoundBorder());
		fondo.setBounds(524, 90, 172, 216);
		frmSpoter.getContentPane().add(fondo);*/
		
		JLabel lblNewLabel_2 = new JLabel("Administrador");
		lblNewLabel_2.setBounds(524, 11, 108, 16);
		contentPane.add(lblNewLabel_2);
		
		JToggleButton perfil = new JToggleButton("Perfil");
		perfil.setBounds(353, 6, 161, 29);
		contentPane.add(perfil);

	
	}

}
