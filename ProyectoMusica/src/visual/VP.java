package visual;

import javax.swing.JFrame;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import baseDatos.BD;

public class VP extends JFrame{
	private JTextField textField;
	public VP() {
		getContentPane().setLayout(null);
		BD bd = new BD();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(88, 119, 271, 26);
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(88, 16, 271, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		ArrayList<String> listaCanciones = bd.consultarCancionesA(textField.getText());
		for(int i = 0; i< listaCanciones.size(); i++){
			comboBox.addItem(listaCanciones.get(i));
		}
	}
}
