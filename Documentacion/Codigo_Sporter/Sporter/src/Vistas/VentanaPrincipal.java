package Vistas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.awt.color.*;
import java.awt.Color;

import colores.Colores;
import imagenes.Imagenes;
import javax.swing.border.BevelBorder;
import java.util.ArrayList;
import Modelo.Evento;
import javax.swing.border.MatteBorder;
import Render.Render;

public class VentanaPrincipal extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable tablaEventos;
	private ArrayList<Evento> listaEventos;
	private static Colores colores = new Colores();
	private Imagenes imagenes = new Imagenes();
	private DefaultTableModel modelo = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setTitle("Sporter");
		setIconImage(imagenes.getLogo_sin_nombreEscalado(16, 16));
		setForeground(colores.getNaranja());
		setBackground(colores.getNaranja());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 612);
		contentPane = new JPanel();
		contentPane.setBackground(colores.getVerde());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCrearEvento = new JButton("Crear Evento");
		btnCrearEvento.setBounds(15, 16, 117, 23);
		btnCrearEvento.setBackground(colores.getNaranja());
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCerrarSesion.setBounds(433, 16, 117, 23);
		btnCerrarSesion.setBackground(colores.getNaranja());
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(429, 57, 103, 23);
		btnBuscar.setBackground(colores.getNaranja());
	
		JLabel lblIntroduzcaDeporte = new JLabel("Introduzca Deporte:");
		lblIntroduzcaDeporte.setBounds(15, 61, 98, 14);
		lblIntroduzcaDeporte.setForeground(colores.getAmarillo());
		
		textField = new JTextField();
		textField.setBounds(117, 58, 96, 20);
		textField.setColumns(10);
		
		JLabel lblIntroduzcaUbicacin = new JLabel("Introduzca Ubicaci\u00F3n:");
		lblIntroduzcaUbicacin.setBounds(217, 61, 106, 14);
		lblIntroduzcaUbicacin.setForeground(colores.getAmarillo());
		
		textField_1 = new JTextField();
		textField_1.setBounds(327, 58, 96, 20);
		textField_1.setColumns(10);
		
		JLabel lblRayanChavesDa = new JLabel("Rayan Chaves Da Silva");
		lblRayanChavesDa.setBounds(286, 20, 147, 14);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 86, 516, 457);
		scrollPane.setToolTipText("");
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		

		JTable tablaEventos = new JTable();
		tablaEventos.setBorder(new MatteBorder(0, 0, 1, 1, (Color) Color.WHITE));
		tablaEventos.setShowVerticalLines(false);
		
		JButton btnUnirse = new JButton("Unirse");
		btnUnirse.setName("Unirse");
		
		String[] titulos = {
				"Propietario", "Deporte", "Ubicacion", "Participantes", "fecha", " "
			};
		modelo.setColumnIdentifiers(titulos);
		tablaEventos.setModel(modelo);
		Object[] informacion = {null, null, null, null, null, btnUnirse};
		//es funcional pero falta unirlo a mysql
		/*
		for(int x = 0; x < listaEventos.size(); x++){
			informacion[0] = listaEventos.get(x).getId() + "";
			informacion[1] = listaEventos.get(x).getDeporte() + "";
			informacion[2] = listaEventos.get(x).getUbicacion() + "";
			informacion[3] = listaEventos.get(x).getNumeroParticipantes() + "";
			informacion[4] = listaEventos.get(x).getFecha() + "";
			modelo.addRow(informacion);
		}
		tablaEventos.setModel(modelo);
		*/
		//Tabla test
		for(int x = 0; x < 5; x++){
			informacion[0] = "0";
			informacion[1] = "1";
			informacion[2] = "2";
			informacion[3] = "3";
			informacion[4] = "4";
			modelo.addRow(informacion);
		}
		tablaEventos.setModel(modelo);
		
		tablaEventos.getTableHeader().setReorderingAllowed(false);
		tablaEventos.setDefaultRenderer(Object.class, new Render());
		tablaEventos.setPreferredScrollableViewportSize(tablaEventos.getPreferredSize());
		scrollPane.setViewportView(tablaEventos);
		
		contentPane.setLayout(null);
		contentPane.add(btnCrearEvento);
		contentPane.add(lblRayanChavesDa);
		contentPane.add(btnCerrarSesion);
		contentPane.add(lblIntroduzcaDeporte);
		contentPane.add(textField);
		contentPane.add(lblIntroduzcaUbicacin);
		contentPane.add(textField_1);
		contentPane.add(btnBuscar);
		contentPane.add(scrollPane);
	}
}