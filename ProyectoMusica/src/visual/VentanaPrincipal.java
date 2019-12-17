package visual;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
		
		JList listaCanciones = new JList(Cancion);
		listaCanciones.setBounds(0, 0, 390, 288);
		panelCanciones.add(listaCanciones);
		
		Panel panelPlaylists = new Panel();
		tabbedPane.addTab("Playlists", null, panelPlaylists, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Ã�lbumes", null, panel, null);
		
		JPanel panelBusqueda = new JPanel();
		contentPane.add(panelBusqueda, BorderLayout.NORTH);
		panelBusqueda.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		panelBusqueda.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tituloIntroducido = textField.getText();
				BD bd = new BD();
				ArrayList<Cancion> canciones = bd.consultarCanciones(tituloIntroducido);
				JList<Cancion> jlistaCanciones = new JList<>();
				jlistaCanciones.setBounds(0, 0, 390, 288);
				panelCanciones.add(listaCanciones);
				jlistaCanciones.setModel((ListModel<Cancion>) canciones);
			}
		});
			
		panelBusqueda.add(btnNewButton, BorderLayout.EAST);
	}
}
