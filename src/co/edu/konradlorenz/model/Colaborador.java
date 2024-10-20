package co.edu.konradlorenz.model;

public class Colaborador extends Persona {

	public Colaborador() {
	}

	public Colaborador(String nombre, String correo, String rol) {
		super(nombre, correo, "Colaborador");
	}

	@Override
	public String toString() {
		return "El nombre del colaborador es = " + getNombre() + ", el correo es = " + getCorreo() + "y el rol es = "
				+ getRol();
	}

	@Override
	public boolean verificarDisponibilidad(int tareasPendientes) {
	    boolean disponible = tareasPendientes < 5;  
	    return disponible;
	}
}
