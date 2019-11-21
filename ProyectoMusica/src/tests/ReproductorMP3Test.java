package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sonido.ReproductorMP3;

public class ReproductorMP3Test extends ReproductorMP3 {

	@Test
	public void test() {
		ReproductorMP3 mp3 = new ReproductorMP3();
		mp3.anyadir_playlist("Files/Viento.MP3");
		assertEquals(1, mp3.getPlaylist().size());
		
	}

}
