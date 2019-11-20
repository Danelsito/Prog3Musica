package sonido;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ReproductorMP3 implements IReproducir{
	 private List<String> Playlist = new ArrayList<>();
	@Override
	public void reproducirFile(String rArchivo) throws FileNotFoundException, JavaLayerException {
		 Player apl = new Player(new FileInputStream(rArchivo));
		 
		 apl.play();
	}

	@Override
	public void pausar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reproducirPL(ArrayList<String> Playlist) throws FileNotFoundException, JavaLayerException {
		boolean rebobinar = false;
		boolean saltar = false;
		for(int i = 0; i < Playlist.size(); i++) {
			if(rebobinar) {
				i--;
			}
			if(saltar) {
				i++;
			}
			
			Player apl = new Player(new FileInputStream(Playlist.get(i)));
			 
			 apl.play();
		}
		
	}

	@Override
	public void anyadir_playlist(String rArchivo) {
		Playlist.add(rArchivo);		
	}

	@Override
	public boolean rebobinar() {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean saltar_cancion() {
		return true;
		
	}


}
