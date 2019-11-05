package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import objetos.Datos;
import objetos.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txfUsuario;
	private JPasswordField txfPass;
	private JTextField txfNombre;
	private JTextField txfApellidos;
	private JTextField txfEmail;
	private JTextField txfTlfn;
	private JLabel lblApellidos;
	private JLabel lblEmail;
	private JLabel lblTlfn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("REGISTRO");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblLogin.setBounds(6, 27, 438, 26);
		contentPane.add(lblLogin);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(78, 70, 61, 16);
		contentPane.add(lblUsuario);
		
		txfUsuario = new JTextField();
		txfUsuario.setBounds(181, 65, 130, 26);
		contentPane.add(txfUsuario);
		txfUsuario.setColumns(10);
		
		txfPass = new JPasswordField();
		txfPass.setBounds(181, 103, 130, 26);
		contentPane.add(txfPass);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(78, 108, 76, 16);
		contentPane.add(lblPassword);
		
		JButton btnSingIn = new JButton("Volver");
		btnSingIn.setBounds(16, 375, 117, 29);
		contentPane.add(btnSingIn);
		
		JButton btnRegistro = new JButton("Registrar");
		
		btnRegistro.setBounds(310, 375, 117, 29);
		contentPane.add(btnRegistro);
		
		txfNombre = new JTextField();
		txfNombre.setBounds(181, 141, 130, 26);
		contentPane.add(txfNombre);
		txfNombre.setColumns(10);
		
		txfApellidos = new JTextField();
		txfApellidos.setBounds(181, 179, 130, 26);
		contentPane.add(txfApellidos);
		txfApellidos.setColumns(10);
		
		txfEmail = new JTextField();
		txfEmail.setBounds(181, 217, 130, 26);
		contentPane.add(txfEmail);
		txfEmail.setColumns(10);
		
		txfTlfn = new JTextField();
		txfTlfn.setBounds(181, 255, 130, 26);
		contentPane.add(txfTlfn);
		txfTlfn.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(78, 146, 61, 16);
		contentPane.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(78, 184, 76, 16);
		contentPane.add(lblApellidos);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(78, 222, 61, 16);
		contentPane.add(lblEmail);
		
		lblTlfn = new JLabel("Tlfn :");
		lblTlfn.setBounds(78, 260, 61, 16);
		contentPane.add(lblTlfn);
		
		
		 
		// Instanciar Componente
		JDateChooser dateChooser = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		 
		// Ubicar y agregar al panel
		dateChooser.setBounds(181, 293, 100, 20);
		 
		contentPane.add(dateChooser);
		
		JLabel lblFechaNac = new JLabel("Fecha nac:");
		lblFechaNac.setBounds(78, 297, 76, 16);
		contentPane.add(lblFechaNac);
		
		btnSingIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date fecha = dateChooser.getDate();
				char[] clave = txfPass.getPassword();
				String pass = new String(clave);
				int tlfn = Integer.parseInt(txfTlfn.getText());
				
				String username = txfUsuario.getText();
				String nombre = txfNombre.getText();
				String apellido = txfApellidos.getText();
				String email = txfEmail.getText();
				
				try {
					Datos.conn.introducirUser(username, pass, nombre, apellido, email, tlfn, fecha);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				User u = new User(username, pass, nombre, apellido, email, tlfn, fecha);
				
			}
		});
	}
}
