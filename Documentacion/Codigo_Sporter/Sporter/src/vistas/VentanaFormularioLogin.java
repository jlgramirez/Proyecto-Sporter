//Autor: Francisco Javier Santiburcio Vicente

package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.sql.*;

import javax.swing.JPasswordField;
import javax.swing.JList;

import colores.Colores;
import conexion.Conexion;
import controlador.CtrlVentanaFrmLogin;
import imagenes.Imagenes;
import modelo.Deporte;
import modelo.Evento;
import modelo.Persona;
import modelo.Ubicacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Choice;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.List;




public class VentanaFormularioLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Colores colores = new Colores();
	private Imagenes imagenes = new Imagenes();
	private JPanel contentPane;
	private JTextField textUsr, textEmail;
	private JPasswordField passwordField;
	private List listDeportes;
	private Choice choice_ubi;
	private JButton button_cancelar, button_crear;
	private Statement comando = new Conexion().getcommand();

	/**
	 * Launch the application.
	 */
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFormularioLogin frame = new VentanaFormularioLogin();
					CtrlVentanaFrmLogin ctrl = new CtrlVentanaFrmLogin(frame);
					frame.controlVentana(ctrl);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public VentanaFormularioLogin() throws SQLException {
		
		setTitle("Sporter");
		setIconImage(imagenes.getLogo_sin_nombreEscalado(16, 16));
		setForeground(colores.getNaranja());
		setBackground(colores.getNaranja());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 503);
		contentPane = new JPanel();
		contentPane.setBackground(colores.getVerde());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Panel para la etiqueta y campo USUARIO 
		JPanel panel = new JPanel();
		panel.setBounds(74, 24, 373, 51);
		panel.setBackground(colores.getVerde());
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Nombre de usuario:");
		lblNewLabel.setForeground(colores.getAmarillo());
		panel.add(lblNewLabel);
		
		textUsr = new JTextField();
		panel.add(textUsr);
		textUsr.setColumns(10);
		
		Dimension size = textUsr.getSize();
		
		// Panel para la etiqueta y campo EMAIL
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(74, 87, 373, 51);
		panel_1.setBackground(colores.getVerde());
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setForeground(colores.getAmarillo());
		panel_1.add(lblNewLabel_1);
		
		textEmail = new JTextField();
		panel_1.add(textEmail);
		textEmail.setColumns(10);
		
		// Panel para la etiqueta y campo CONTRASENIA 
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(74, 150, 373, 51);
		panel_1_1.setBackground(colores.getVerde());
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña:");
		lblNewLabel_1_1.setForeground(colores.getAmarillo());
		panel_1_1.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		panel_1_1.add(passwordField);
		passwordField.setColumns(10);
		
		// Panel para la etiqueta y la selección de DEPORTES
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(74, 213, 373, 51);
		panel_2.setBackground(colores.getVerde());
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Deportes favoritos:");
		lblNewLabel_2.setForeground(colores.getAmarillo());
		panel_2.add(lblNewLabel_2);
		
		choice_ubi = new Choice();
		panel_2.add(choice_ubi);
		
		// Panel para la etiqueta y la selección de LOCALIZACION
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(74, 276, 373, 99);
		panel_2_1.setBackground(colores.getVerde());
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Localización:");
		lblNewLabel_2_1.setForeground(colores.getAmarillo());
		panel_2_1.add(lblNewLabel_2_1);
		
		listDeportes = new java.awt.List();
		listDeportes.setMultipleMode(true);
		panel_2_1.add(listDeportes);
		
		
		// Panel para los botones
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(64, 191, 119));
		panel_2_1_1.setBounds(74, 387, 373, 51);
		contentPane.add(panel_2_1_1);
		
		button_cancelar = new JButton("Cancelar");
		button_cancelar.setBackground(colores.getNaranja());
		panel_2_1_1.add(button_cancelar);
		
		button_crear = new JButton("Crear Perfil");
		button_crear.setBackground(colores.getNaranja());
		panel_2_1_1.add(button_crear);
		
		cargarChoiceLocalizacion(choice_ubi);
		cargarListaDeportes(listDeportes);
	}
	
	// Controladores
	
	public void controlVentana(ActionListener ctrl) {
		button_crear.addActionListener(ctrl);
		button_crear.setActionCommand("CREAR");
		
		button_cancelar.addActionListener(ctrl);
		button_cancelar.setActionCommand("CANCELAR");
	}
	
	
	// Cargamos las listas
	private void cargarChoiceLocalizacion(Choice choice_ubi2) {
		Ubicacion ub = new Ubicacion();
		java.util.List<String> listUbicacion = ub.getListUbicacion();
		
		for(String item : listUbicacion) {
			choice_ubi2.add(item);
		}
		
	}
	
	private void cargarListaDeportes(List listDeportes) throws SQLException {
		Deporte depo = new Deporte(comando);
		java.util.List<String> listDepo =  depo.obtenerListaDeporte();
				
		for(String item : listDepo) {
			listDeportes.add(item);
		}
		
	}
	
	// Metodo encargado de crear el perfil de usuario en la base de datos
	
	public void crearPerfil() throws SQLException {
		String usr = textUsr.getText();
		String email = textEmail.getText();
		String password = passwordField.getSelectedText();
		String localidad = choice_ubi.getSelectedItem();
		String [] lDeportes = listDeportes.getSelectedItems();
		
		for(String str : lDeportes) {
			System.out.println(str);
		}
		
		Persona persona = new Persona(comando);  
		persona.crearPerfil(usr, localidad, email, password, lDeportes);
		
		this.cerrarVentana();
	}
	
	public void cerrarVentana() {
		this.dispose();
	}
}
