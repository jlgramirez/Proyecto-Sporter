// Autor : Daniel Cuevas Pérez

package Vistas;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Conexion.Conexion;
import Controlador.CtrlVentanaCrearEvento;
import Modelo.Evento;
import Modelo.Persona;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import java.awt.Choice;


public class VentanaFrmCrearEvento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Propietario;
	private JTextField textField_Fecha;
	private JTextField textField_numPart;
	private JTextField textField_Deporte;
	private JTextField textField_Ubicacion;
	private JButton button_CrearEvento, button_Cancelar;
	protected Statement command;
	private Persona persona;
	private String ubicacion;
	private String fecha;
	private int numParticipantes,deporte;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFrmCrearEvento vista = new VentanaFrmCrearEvento();
					CtrlVentanaCrearEvento ctrl = new CtrlVentanaCrearEvento(vista); // Primero te creas el controlador y le metes la vista
					vista.controladorVentana(ctrl); // Segundo: el metodo de la vista controlador le metes el controlador anteriormente creado
					vista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
//----------------------------------------------------------------- INICIO ESTRUCTURA VENTANA ------------------------------------------------------------------------//
	
	public VentanaFrmCrearEvento() {
		
		setFont(new Font("Dialog", Font.BOLD, 12));
		setForeground(Color.ORANGE);
		setBackground(Color.ORANGE);
		setTitle("Sporter - Crear Evento Deportivo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 191, 119));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPropietario = new JLabel("PROPIETARIO");
		lblPropietario.setBounds(33, 20, 236, 14);
		contentPane.add(lblPropietario);
		
		textField_Propietario = new JTextField();
		textField_Propietario.setBounds(33, 40, 236, 20);
		contentPane.add(textField_Propietario);
		textField_Propietario.setColumns(10);
		
		JLabel lblDeporte = new JLabel("DEPORTE");
		lblDeporte.setBounds(33, 80, 236, 14);
		contentPane.add(lblDeporte);
		
		textField_Deporte = new JTextField();
		textField_Deporte.setColumns(10);
		textField_Deporte.setBounds(33, 100, 236, 20);
		contentPane.add(textField_Deporte);
		
		JLabel lblUbicacion = new JLabel("UBICACI\u00D3N");
		lblUbicacion.setBounds(33, 140, 236, 14);
		contentPane.add(lblUbicacion);
		
		textField_Ubicacion = new JTextField();
		textField_Ubicacion.setColumns(10);
		textField_Ubicacion.setBounds(33, 160, 236, 20);
		contentPane.add(textField_Ubicacion);
		
		JLabel lblFecha = new JLabel("FECHA (aaaa-mm-dd hh:mm:ss)");
		lblFecha.setBounds(33, 200, 236, 14);
		contentPane.add(lblFecha);
		
		textField_Fecha = new JTextField();
		textField_Fecha.setToolTipText("");
		textField_Fecha.setColumns(10);
		textField_Fecha.setBounds(33, 220, 236, 20);
		contentPane.add(textField_Fecha);
		
		JLabel lblNumeroParticipantes = new JLabel("N\u00DAMERO PARTICIPANTES");
		lblNumeroParticipantes.setBounds(33, 260, 236, 14);
		contentPane.add(lblNumeroParticipantes);
		
		textField_numPart = new JTextField();
		textField_numPart.setColumns(10);
		textField_numPart.setBounds(33, 280, 236, 20);
		contentPane.add(textField_numPart);
		
		button_CrearEvento = new JButton("Crear");
		button_CrearEvento.setBounds(33, 348, 90, 22);
		contentPane.add(button_CrearEvento);
		
		button_Cancelar = new JButton("Cancelar");
		button_Cancelar.setBounds(179, 348, 90, 22);
		contentPane.add(button_Cancelar);
		
	}
	
//----------------------------------------------------------------- FIN INICIO ESTRUCTURA VENTANA ------------------------------------------------------------------------//
	
//------------------------------------------------------------------------ CONTROLADORES ---------------------------------------------------------------------------------//
		
		public void controladorVentana(ActionListener ctrl){
			button_CrearEvento.addActionListener(ctrl);
			button_CrearEvento.setActionCommand("CREAR");
			
			button_Cancelar.addActionListener(ctrl);
			button_Cancelar.setActionCommand("CANCELAR");
		}
		
//---------------------------------------------------------------------- FIN CONTROLADORES ---------------------------------------------------------------------------------//		
		
//---------------------------------------------------------------------- METODOS AUXILIADRES -------------------------------------------------------------------------------//
		
		public void crearEvento() throws SQLException {
			
			Conexion conexion = new Conexion();
			command = conexion.getcommand();
			
			int idPersona = Integer.parseInt(textField_Propietario.getText());
			persona = new Persona(command,idPersona);
			deporte = Integer.parseInt(textField_Deporte.getText());
			ubicacion = textField_Ubicacion.getText();
			fecha = textField_Fecha.getText();
			numParticipantes = Integer.parseInt(textField_numPart.getText());
			
			Evento evento = new Evento(command);
			evento.crearEvento(persona, deporte, ubicacion, fecha, numParticipantes);
		
		}
		
}
