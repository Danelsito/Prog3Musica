package visual;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import baseDatos.BD;

public class VP extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	
	public VP() {
		getContentPane().setLayout(null);
	
		
		textField = new JTextField();
		textField.setBounds(88, 16, 271, 26);
		getContentPane().add(textField);
		textField.setColumns(10);

	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VP ventana = new VP();
					ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("inutil");
				}
			}
		});
	}
}
