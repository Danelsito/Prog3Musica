package sonido;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javazoom.jl.decoder.JavaLayerException;

public interface IReproducir {
	public void reproducirPL(ArrayList<String> Playlist) throws FileNotFoundException, JavaLayerException;
	public void pausar();
	public void anyadir_playlist(String rArchivo);
	public boolean rebobinar();
	public boolean saltar_cancion();
	void reproducirFile(String rArchivo) throws FileNotFoundException, JavaLayerException;
}
