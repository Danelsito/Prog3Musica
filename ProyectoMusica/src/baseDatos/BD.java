package baseDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

import objetos.Cancion;

import objetos.Datos;
import objetos.User;

public class BD {
	
	private Connection conn;	
	
	public void connect(){
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:basedatos.db");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) throws SQLException {
		BD app = new BD();

	}
	
	public void crearUsuarioLocal(String usuario) {

		String sql = "SELECT * FROM user WHERE username = '" + usuario + "'";

		Connection conn = this.conn;
		Statement stmt;
		String password = null;
		String nombre = null;
		String apellidos = null;
		String email = null;
		int telefono = 0;
		String fecha = null;
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// loop through the result set
			while (rs.next()) {
				password = rs.getString("password");
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				email = rs.getString("email");
				telefono = Integer.parseInt(rs.getString("tlfn"));
				//fecha = fecha.toString();
			}
		} catch (SQLException e) {
			
			Datos.log.log(Level.WARNING, "MÃ©todo crearUsuarioLocal ha fallado. " + e);
		}
		// Este serÃ¡ el usuario cliente que ha iniciado sesiÃ³n y utiliza el programa.
		//Datos.usuarioactual = new User(usuario, password, nombre, apellido, email, telefono); 
	}
	
	public void tablaUsuario() {
		try {
			 PreparedStatement stmt = conn.prepareStatement("CREATE TABLE IF NOT EXISTS usuario("
			 		+ "username varchar(50) PRIMARY KEY NOT NULL,"
					+ "password VARCHAR(50) NOT NULL,"
					+ "nombre VARCHAR(50) NOT NULL,"
					+ "apellido VARCHAR(50) NOT NULL,"
					+ "email VARCHAR(50),"
					+ "telefono INT(9)");
			 stmt.execute(); 
			 stmt.close();	
			
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciï¿½n: " 
				    + sqle.getErrorCode() + " " + sqle.getMessage());    
		}
		
		
	}
	
	public void tablaCancion() {
		try {
			 PreparedStatement stmt = conn.prepareStatement("CREATE TABLE cancion("
					+ "id INT(50) PRIMARY KEY NOT NULL,"
			 		+ "titulo VARCHAR(50) NOT NULL,"
					+ "duracion_en_segundos INT(50) NOT NULL,"
					+ "artista VARCHAR(50) NOT NULL,"
					+ "album VARCHAR(50),");
			 stmt.execute(); 
			 stmt.close();	
			
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciï¿½n: " 
				    + sqle.getErrorCode() + " " + sqle.getMessage());    
		}
		
	}
	
	public void tablaPlaylist() {
		try {
			 PreparedStatement stmt = conn.prepareStatement("CREATE TABLE playlist("
					+ "id INT(50) PRIMARY KEY NOT NULL,"
					+ "nombre_playlist VARCHAR(50) NOT NULL,"
			 		+ "FOREIGN KEY(\"usuario\") REFERENCES \"usuario\"(\"username\") ON DELETE CASCADE,");
			 stmt.execute(); 
			 stmt.close();	
			
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciï¿½n: " 
				    + sqle.getErrorCode() + " " + sqle.getMessage());    
		}
		
	}
	
	public void tablaCancionPlaylist() {
		try {
			 PreparedStatement stmt = conn.prepareStatement("CREATE TABLE playlistCancion ("
					+ "FOREIGN KEY(\"idCancion\") REFERENCES \"cancion\"(\"id\") ON DELETE CASCADE,"
					+ "FOREIGN KEY(\"idPlaylist\") REFERENCES \"playlist\"(\"id\") ON DELETE CASCADE,"
					+ "PRIMARY KEY (id_cancion, id_playlist),"
					);
			 stmt.execute(); 
			 stmt.close();	
			
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciï¿½n: " 
				    + sqle.getErrorCode() + " " + sqle.getMessage());    
		}
		
	}
	
	public void insertarCancionEnPlaylist(int idCancion, int idPlaylist) {
		String sql = "INSERT INTO playlistCancion (idCancion, idPlaylist) VALUES (?,?,)";
		Connection conn = this.conn;
		
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idCancion);
		pstmt.setInt(2, idPlaylist);

		pstmt.executeUpdate();
		
	} catch (SQLException sqle) {
		System.out.println("Los datos introducidos no son correctos");
	}
		
	}
	
	public void introducirUser(String username, String password, String nombre, String apellido, String email, int telefono) throws SQLException {
		

			String sql = "INSERT INTO user (username, password, nombre, apellidos, email, tlfn, fecha) VALUES (?,?,?,?,?,?,?)";
			Connection conn = this.conn;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
		try {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, nombre);
			pstmt.setString(4, apellido);
			pstmt.setString(5, email);
			pstmt.setInt(6, telefono);

			pstmt.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Los datos introducidos no son correctos");
		}
		

	}
	

	
	public boolean login(String userIntroducido, String passIntroducido) {
		String sql = "SELECT password FROM user WHERE username LIKE '" + userIntroducido + "'";
		Connection conn = this.conn;
		Statement stmt;
		passIntroducido = passIntroducido.replaceAll(" ", "");
		String password = "";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			// loop through the result set
			while (rs.next()) {
				password = rs.getString("password").replaceAll(" ", "");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (password.contains(passIntroducido)/*||passIntroducido.contains(password)*/) {
			return true;

		}

		else {
			return false;

		}

	}
	
	public void introducirCancion(String titulo, int duracion_en_segundos, String artista, String album, String ubicacion) throws SQLException {
		try {

			String sql = "INSERT INTO cancion (titulo, duracion_en_segundos, album, artista, ubicacion) VALUES (?,?,?,?,?)";
			Connection conn = this.conn;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, titulo);
			pstmt.setInt(2, duracion_en_segundos);
			pstmt.setString(3, artista);
			pstmt.setString(4, album);
			pstmt.setString(5, ubicacion);
			
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Los datos introducidos no son correctos");
		}
		
	}
	
	public ArrayList<Cancion> consultarCancionesA(String tituloIntroducido){
		ArrayList<Cancion> canciones = new ArrayList<>();
		
		String sql = "SELECT * FROM cancion WHERE titulo LIKE " + tituloIntroducido;
		int id = 0;
		String titulo = null;
		int duracion = 0;
		String artista = null;
		String album = null;
		
		Connection conn = this.conn;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("está en el método");

			// loop through the result set
			
			while (rs.next()) {
				id = rs.getInt("id");
				titulo = rs.getString("titulo");
				duracion = rs.getInt("duracion_en_segundos");
				artista = rs.getString("artista");
				album = rs.getString("album");
				
				Cancion c = new Cancion(id, titulo, duracion, artista, album);
				if (c.getTitulo().contains(tituloIntroducido)) {
					canciones.add(c);
				}
			}
		} catch (SQLException sqle) {
			Datos.log.log(Level.SEVERE, "MÃ©todo consultar canciones ha fallado. " + sqle);
			sqle.printStackTrace();
			System.out.println("Sale del método");
		}
		
		return canciones;
	}

}
