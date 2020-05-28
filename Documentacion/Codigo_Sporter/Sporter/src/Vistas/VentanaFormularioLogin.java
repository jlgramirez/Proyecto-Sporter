package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JList;

import colores.Colores;
import imagenes.Imagenes;
import Modelo.Evento;
import java.awt.Color;
import javax.swing.JButton;


public class VentanaFormularioLogin extends JFrame {
	private Colores colores = new Colores();
	private Imagenes imagenes = new Imagenes();
	private JPanel contentPane;
	private JTextField textUsr;
	private JTextField textEmail;
	private JPasswordField passwordField;
	private JList<Evento> listDeportes;
	private JList<Evento> listLocalizacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFormularioLogin frame = new VentanaFormularioLogin();
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
	private VentanaFormularioLogin() {
		setTitle("Sporter");
		setIconImage(imagenes.getLogo_sin_nombreEscalado(16, 16));
		setForeground(colores.getNaranja());
		setBackground(colores.getNaranja());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 449);
		contentPane = new JPanel();
		contentPane.setBackground(colores.getVerde());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Panel para la etiqueta y campo usuario 
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
		
		// Panel para la etiqueta y campo email
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
		
		// Panel para la etiqueta y campo contrasenia 
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
		
		// Panel para la etiqueta y la selección de deportes
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(74, 213, 373, 51);
		panel_2.setBackground(colores.getVerde());
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Deportes favoritos:");
		lblNewLabel_2.setForeground(colores.getAmarillo());
		panel_2.add(lblNewLabel_2);
		
		listDeportes = new JList<Evento>();
		panel_2.add(listDeportes);
		
		// Panel para la etiqueta y la selección de localización
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(74, 276, 373, 51);
		panel_2_1.setBackground(colores.getVerde());
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Localización:");
		lblNewLabel_2_1.setForeground(colores.getAmarillo());
		panel_2_1.add(lblNewLabel_2_1);
		
		JList<Evento> listLocalizacion = new JList<Evento>();
		panel_2_1.add(listLocalizacion);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(64, 191, 119));
		panel_2_1_1.setBounds(74, 347, 373, 51);
		contentPane.add(panel_2_1_1);
		
		JButton btnNewButton = new JButton("Crear Perfil");
		panel_2_1_1.add(btnNewButton);
		
		JList<Evento> listLocalizacion_1 = new JList<Evento>();
		panel_2_1_1.add(listLocalizacion_1);
	}
}
