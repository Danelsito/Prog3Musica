package objetos;

public class UserActual extends User {
	public String password;

	public UserActual(String username, String password, String location, String nombre, String apellido, int dni,
			String email, int telefono, String image) {

		super(username, location, nombre, apellido, dni, email, telefono, image);
		this.password = password;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void getTodo() {
		System.out.println(getUsername() + "; " + getPassword() + "; " + getLocation() + "; " + getNombre() + "; "
				+ getApellido() + "; " + getTelefono() + "; " + getEmail() + "; ");
	}

}