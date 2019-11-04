package baseDatos;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import objetos.Datos;
import objetos.User;

public class BD {
	
	
	private Connection connect() {
		// SQLite connection string
		String url = "jdbc:sqlite:src/proyecto";
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

		String sql = "SELECT * FROM Users WHERE user = '" + usuario + "'";

		Connection conn = this.connect();
		Statement stmt;
		String password = null;
		String nombre = null;
		String apellido = null;
		String email = null;
		int telefono = 0;
		try {
			stmt = (Statement) conn.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);

			// loop through the result set
			while (rs.next()) {
				password = rs.getString("password");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				email = rs.getString("email");
				telefono = Integer.parseInt(rs.getString("telefono"));
			}
		} catch (SQLException e) {
			
			Datos.log.log(Level.WARNING, "Método crearUsuarioLocal ha fallado. " + e);
		}
		// Este será el usuario cliente que ha iniciado sesión y utiliza el programa.
		//Datos.usuarioactual = new User(usuario, password, nombre, apellido, email, telefono); 
	}

}
