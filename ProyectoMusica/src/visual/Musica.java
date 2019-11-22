package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;
import sonido.ReproductorMP3;

public class Musica extends JFrame {
	
	public Musica() {
		
	ReproductorMP3 mp = new ReproductorMP3();
	setTitle("Musica");
	this.setSize(600, 400);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	
	
	JButton botonCancion = new JButton("Reproducir Cancion");
	botonCancion.setAlignmentX(10);
	JButton botonPL = new JButton("Reproducir Playlist");
	botonPL.setAlignmentX(590);
	
	JPanel bPanel =  new JPanel();
	bPanel.setBackground(Color.pink);
	bPanel.add(botonCancion);
	bPanel.add(botonPL);
	
	add(bPanel, BorderLayout.SOUTH);
	
	botonCancion.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				mp.reproducirFile("File/Viento.mp3");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JavaLayerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	});
	
	botonPL.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			mp.anyadir_playlist("Files/Viento.mp3");
			mp.anyadir_playlist("Files/Tittle.mp3");
			
			try {
				mp.reproducirPL(mp.getPlaylist());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JavaLayerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
}
}
