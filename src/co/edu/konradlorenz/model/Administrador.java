package co.edu.konradlorenz.model;

public class Administrador extends Persona {

	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public Administrador(String nombre, String correo, String rol) {
		super(nombre, correo, rol);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "El nombre del administrador es = " + getNombre() + ", el correo es = " + getCorreo() + ", el rol es = "
				+ getRol();
	}

}
