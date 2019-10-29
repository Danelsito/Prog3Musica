package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
		
		JButton btnSingIn = new JButton("Sing In");
		btnSingIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				char[] clave = passwordField.getPassword();
				String pass = new String(clave);
				
				if(textField.getText().equals("Grupo")&& pass.equals("1234")) {
					dispose();
					JOptionPane.showMessageDialog(null, "Bienvenido!","INGRESASTE", JOptionPane.INFORMATION_MESSAGE);
					aquiventanaprincipal p = new aquiventanaprincipal();
					p.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos.","ERROR", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnSingIn.setBounds(180, 216, 117, 29);
		contentPane.add(btnSingIn);
	}
}
