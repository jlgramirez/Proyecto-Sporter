package Vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import colores.Colores;
import imagenes.Imagenes;

public class VentanaLogin extends JFrame {
	private static Colores colores = new Colores();
	private Imagenes imagenes = new Imagenes();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaLogin() {
		
		setTitle("Sporter");
		setIconImage(imagenes.getLogo_sin_nombreEscalado(16, 16));
		setForeground(colores.getNaranja());
		setBackground(colores.getNaranja());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 388);
		contentPane = new JPanel();
		contentPane.setBackground(colores.getVerde());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(110, 188, 61, 16);
		lblNewLabel.setForeground(colores.getAmarillo());
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setBounds(110, 226, 93, 16);
		lblNewLabel_1.setForeground(colores.getAmarillo());
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(215, 183, 187, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(215, 221, 189, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrarme");
		btnNewButton.setBounds(92, 276, 175, 29);
		btnNewButton.setBackground(colores.getNaranja());
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Iniciar Sesión");
		btnNewButton_1.setBounds(312, 276, 175, 29);
		btnNewButton_1.setBackground(colores.getNaranja());
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(205, 6, 197, 155);
		
		int width = lblNewLabel_2.getWidth();
		int height = lblNewLabel_2.getHeight();
		lblNewLabel_2.setIcon(new ImageIcon(imagenes.getLogo_sin_fondoEscalado(width, height)));
		
		contentPane.add(lblNewLabel_2);
		
	}
}
