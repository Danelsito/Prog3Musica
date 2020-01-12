package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baseDatos.BD;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.awt.event.ActionEvent;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static BD bd = new BD();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblLogin.setBounds(6, 27, 438, 26);
		contentPane.add(lblLogin);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(77, 101, 61, 16);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(180, 96, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 134, 130, 26);
		contentPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(77, 139, 76, 16);
		contentPane.add(lblPassword);
		
		JButton btnSingIn = new JButton("Sign In");
		btnSingIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				String usuarioIntroducido = textField.getText();
				//Cifra el texto introducido por el usuario en SHA1 y MD5 y lo compara con la BD.
				String passIntroducido = new String(passwordField.getPassword());
				System.out.println(passIntroducido);
	
				if (bd.login(usuarioIntroducido, passIntroducido)) {
					//Datos.propiedades.put("key", usuarioIntroducido+";"+passIntroducido);
					dispose();
					loguear(usuarioIntroducido);
					VentanaPrincipal v = new VentanaPrincipal();
					v.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Por favor, inténtelo de nuevo", "Error", JOptionPane.WARNING_MESSAGE);
					Datos.log.log(Level.INFO, "Intento de sesión fallido con el usuario " + usuarioIntroducido);
				}
			}
	
		});
		btnSingIn.setBounds(237, 216, 117, 29);
		contentPane.add(btnSingIn);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro r = new Registro();
				r.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setBounds(108, 216, 117, 29);
		contentPane.add(btnRegistro);
	}
	
	public static void loguear(String usuario) {
		bd.crearUsuarioLocal(usuario); // Creamos el objeto de usuario local del cliente, para acceder a los datos de manera rápida.
		//Datos.log.log(Level.INFO, "Inicio de sesión correcto con el usuario " + usuario);
		
		//VentanaPrincipal v;
		JOptionPane.showMessageDialog(null, "Bienvenido de nuevo, "+usuario, "", JOptionPane.INFORMATION_MESSAGE);
		
		/*try {
			v = new VentanaPrincipal();
			v.setVisible(true);
		} catch (SQLException e) {
			//Datos.log.log(Level.SEVERE, "Ventana Principal no se ha podido cargar correctamente. " + e);
		}
	}*/
	
}}


