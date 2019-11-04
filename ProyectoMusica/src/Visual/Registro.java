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
	private JComboBox cbDia, cbAno, cbMes;
	private JLabel lblDia;
	private JLabel lblMes;
	private JLabel lblAo;

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
		btnSingIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSingIn.setBounds(16, 375, 117, 29);
		contentPane.add(btnSingIn);
		
		JButton btnRegistro = new JButton("Registrar");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fecha = cbDia.getSelectedItem() + "/" + cbMes.getSelectedIndex()+1 + "/" + cbAno.getSelectedItem();
				
				char[] clave = txfPass.getPassword();
				String pass = new String(clave);
				int tlfn = Integer.parseInt(txfTlfn.getText());
				User u = new User(txfUsuario.getText(), pass, txfNombre.getText(), txfApellidos.getText(), txfEmail.getText(), tlfn, fecha);
			}
		});
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
		
		
		cbMes.setBounds(181, 293, 94, 27);
		contentPane.add(cbMes);
		cbMes.addItem("Enero");
		cbMes.addItem("Febrero");
		cbMes.addItem("Marzo");
		cbMes.addItem("Abril");
		cbMes.addItem("Mayo");
		cbMes.addItem("Junio");
		cbMes.addItem("Julio");
		cbMes.addItem("Agosto");
		cbMes.addItem("Septiembre");
		cbMes.addItem("Octubre");
		cbMes.addItem("Noviembre");
		cbMes.addItem("Diciembre");
		
		cbDia = new JComboBox();
		cbDia.setBounds(78, 293, 52, 27);
		contentPane.add(cbDia);
		for (int i = 1; i<=31; i++) {
			cbDia.addItem(i+"");
		}
		
		cbAno = new JComboBox();
		cbAno.setBounds(329, 293, 52, 27);
		contentPane.add(cbAno);
		
		lblDia = new JLabel("Dia:");
		lblDia.setBounds(45, 297, 61, 16);
		contentPane.add(lblDia);
		
		lblMes = new JLabel("Mes:");
		lblMes.setBounds(151, 297, 61, 16);
		contentPane.add(lblMes);
		
		lblAo = new JLabel("Año:");
		lblAo.setBounds(291, 297, 61, 16);
		contentPane.add(lblAo);
		for (int i = 1920; i<=2019; i++) {
			cbAno.addItem(i+"");
		}
	}
}
