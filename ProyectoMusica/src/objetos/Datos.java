package objetos;

import java.util.logging.Logger;

import baseDatos.BD;


/**
 * Clase para almacenar algunos datos que tienen que ser accesibles
 * desde cualquier lado.
 *
 */

public class Datos {
	public static Logger log = Logger.getLogger("Proyecto");
	public static BD conn = new BD();
	//Estructuras de datos
	/*public static ArrayList<JFrame> ventanaProducto = new ArrayList<>();
	public static ArrayList<JFrame> ventanaPerfil = new ArrayList<>();
	public static HashMap<String, Double> mapDistancias = new HashMap<>();
	public static HashMap<String, String> propiedades = new HashMap();*/
	
}
