package co.edu.konradlorenz.model;

public class Persona implements Login {

	private String nombre;
	private String correo;
	private String rol;
	private String password;

	public Persona() {
		super();
	}

	public Persona(String nombre, String correo, String rol) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "El nombre de la persona es = " + nombre + ", el correo = " + correo + "y el rol = " + rol;
	}

	@Override
	public boolean signUp(String correo, String password) {
		if (correo.equalsIgnoreCase(getCorreo())) {
			setPassword(password);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean signIn(String correo, String password) {
		if (correo.equalsIgnoreCase(getCorreo()) && password.equalsIgnoreCase(getPassword())) {
			return true;
		}else{
			return false;
		}
	}


}
