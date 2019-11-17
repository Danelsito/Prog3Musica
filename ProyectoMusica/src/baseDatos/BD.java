package baseDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;
import java.util.Date;
import java.util.logging.Level;

import objetos.Datos;
import objetos.User;

public class BD {
	
	
	public static Connection connect() {
		// SQLite connection string
		String url = "jdbc:sqlite:src/basedatos.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			Datos.log.log(Level.INFO, "No se ha podido conectar a la base de datos. " + e);
		}
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		BD app = new BD();

	}
	
	public void crearUsuarioLocal(String usuario) {

		String sql = "SELECT * FROM user WHERE username = '" + usuario + "'";

		Connection conn = this.connect();
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
			
			Datos.log.log(Level.WARNING, "Método crearUsuarioLocal ha fallado. " + e);
		}
		// Este será el usuario cliente que ha iniciado sesión y utiliza el programa.
		//Datos.usuarioactual = new User(usuario, password, nombre, apellido, email, telefono); 
	}
	
	public void tablaUsuario() {
		try {
			 PreparedStatement stmt = connect().prepareStatement("CREATE TABLE usuario(username varchar(50) PRIMARY KEY NOT NULL,"
					+ "password VARCHAR(50) NOT NULL,"
					+ "nombre VARCHAR(50) NOT NULL,"
					+ "apellido VARCHAR(50) NOT NULL,"
					+ "email VARCHAR(50),"
					+ "telefono INT(9)");
			 stmt.execute(); 
			 stmt.close();	
			
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n: " 
				    + sqle.getErrorCode() + " " + sqle.getMessage());    
		}
		
		
	}
	
	public void tablaCancion() {
		try {
			 PreparedStatement stmt = connect().prepareStatement("CREATE TABLE cancion(titulo varchar(50) PRIMARY KEY NOT NULL,"
					+ "duracion_en_segundos INT(50) NOT NULL,"
					+ "artista VARCHAR(50) NOT NULL,"
					+ "album VARCHAR(50),");
			 stmt.execute(); 
			 stmt.close();	
			
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuci�n: " 
				    + sqle.getErrorCode() + " " + sqle.getMessage());    
		}
		
	}
	
	public void introducirUser(String username, String password, String nombre, String apellido, String email, int telefono, Date fecha) throws SQLException {

		String sql = "INSERT INTO user (username, password, nombre, apellidos, email, tlfn, fecha) VALUES (?,?,?,?,?,?,?)";
		Connection conn = this.connect();
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, username);
		pstmt.setString(2, password);
		pstmt.setString(3, nombre);
		pstmt.setString(4, apellido);
		pstmt.setString(5, email);
		pstmt.setInt(6, telefono);
		
		String strFecha = fecha.toString();
		pstmt.setString(7, strFecha);
		pstmt.executeUpdate();

	}
	
	public boolean login(String userIntroducido, String passIntroducido) {
		String sql = "SELECT password FROM user WHERE username LIKE '" + userIntroducido + "'";
		Connection conn = this.connect();
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

}
