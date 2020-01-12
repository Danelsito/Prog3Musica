package objetos;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ventanas extends JFrame{
	
	
	public Ventanas() {
		getContentPane().setLayout(null);
		this.setSize(500,500);
		
		JTextField tf = new JTextField();
		tf.setBounds(88, 16, 271, 26);
		getContentPane().add(tf);
	}
}
