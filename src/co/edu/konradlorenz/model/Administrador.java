package co.edu.konradlorenz.model;

public class Administrador extends Persona {

	public Administrador() {
	}

	public Administrador(String nombre, String correo, String rol, String contraseña) {
		super(nombre, correo, "Administrador", contraseña);
	}

	@Override
	public String toString() {
		return "El nombre del administrador es = " + getNombre() + ", el correo es = " + getCorreo() + " y el rol es = "
				+ getRol();
	}

	@Override
	public boolean verificarDisponibilidad(int tareasPendientes) {
		return true;
	}
}
