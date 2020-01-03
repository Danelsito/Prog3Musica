package objetos;

public class Cancion {
	
	private int id;
	private String titulo;
	private int duracion_en_segundos;
	private String artista;
	private String album;
	
	public Cancion(int id, String titulo, int duracion_en_segundos, String artista, String album) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.duracion_en_segundos = duracion_en_segundos;
		this.artista = artista;
		this.album = album;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion_en_segundos() {
		return duracion_en_segundos;
	}

	public void setDuracion_en_segundos(int duracion_en_segundos) {
		this.duracion_en_segundos = duracion_en_segundos;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getId() {
		return id;
	}
	
	
	

}
