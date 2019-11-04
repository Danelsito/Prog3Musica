package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import objetos.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
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
		
		textField = new JTextField();
		textField.setBounds(181, 65, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 103, 130, 26);
		contentPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(78, 108, 76, 16);
		contentPane.add(lblPassword);
		
		JButton btnSingIn = new JButton("Volver");
		btnSingIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSingIn.setBounds(16, 375, 117, 29);
		contentPane.add(btnSingIn);
		
		JButton btnRegistro = new JButton("Registrar");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = new User(title, title, title, title, title, defaultCloseOperation);
			}
		});
		btnRegistro.setBounds(310, 375, 117, 29);
		contentPane.add(btnRegistro);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 141, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(181, 179, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(181, 217, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(181, 255, 130, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
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
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, null);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
		contentPane.add(datePanel);
	}
}
