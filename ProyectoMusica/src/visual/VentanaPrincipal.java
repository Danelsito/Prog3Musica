package visual;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import baseDatos.BD;
import objetos.Cancion;
import objetos.Datos;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Panel;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class VentanaPrincipal extends JFrame{
	BD bd= new BD(); 
	
	private JPanel contentPane;
	public static BD conn = new BD();
	private JTextField textField;
	private JTable table;
	
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 450);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Usuario");
		menuBar.add(mntmNewMenuItem);
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login v = new Login();
				v.setVisible(true);
				dispose();
				
			}
		});
		menuBar.add(btnNewButton_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelCanciones = new JPanel();
		tabbedPane.addTab("Canciones", null, panelCanciones, null);
		panelCanciones.setLayout(null);
		
	/*	Panel panelPlaylists = new Panel();
		tabbedPane.addTab("Playlists", null, panelPlaylists, null);
	*/	
	/*	JPanel panel = new JPanel();
		tabbedPane.addTab("Ã�lbumes", null, panel, null);
	*/	
		JPanel panelBusqueda = new JPanel();
		contentPane.add(panelBusqueda, BorderLayout.NORTH);
		panelBusqueda.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		panelBusqueda.add(textField);
		textField.setColumns(10);
		
		JList<Cancion> jlistaCanciones = new JList<>();
		jlistaCanciones.setBounds(0, 0, 390, 288);
		panelCanciones.add(jlistaCanciones);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(405, 16, 142, 37);
		contentPane.add(comboBox, BorderLayout.WEST);
		bd.consultarCancionesA(textField.getText()).size();
		for(int i = 0; i< bd.consultarCancionesA(textField.getText()).size(); i++){
			comboBox.addItem(bd.consultarCancionesA(textField.getText()).get(i));
		}
		
		JButton btnBuscar = new JButton("Buscar");
		panelBusqueda.add(btnBuscar, BorderLayout.EAST);
		/*btnBuscar.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				BD bd = new BD();
				try {
					bd.connect();
					bd.consultarCanciones(textField.getText());
					HashMap<Integer, String> mapaCanciones = bd.consultarCanciones(textField.getText());
					jlistaCanciones.a(mapaCanciones);
				} catch (Exception e2) {

				}
				
			}
		});*/
	}
}
