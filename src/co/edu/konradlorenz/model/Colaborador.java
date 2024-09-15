package co.edu.konradlorenz.model;

public class Colaborador extends Persona {

	public Colaborador() {
		// TODO Auto-generated constructor stub
	}

	public Colaborador(String nombre, String correo, String rol) {
		super(nombre, correo, rol);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "El nombre del colaborador es = " + getNombre() + ", el correo es = " + getCorreo() + ", el rol es = "
				+ getRol();
	}
}
