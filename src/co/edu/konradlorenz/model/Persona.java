package co.edu.konradlorenz.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Persona implements WorkTime {

	private String nombre;
	private String correo;
	private String rol;
	private String contraseña;

	public Persona() {
		super();
	}

	public Persona(String nombre, String correo, String rol, String contraseña) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.rol = rol;
		this.contraseña=contraseña;
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
	
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "El nombre de la persona es = " + nombre + ", el correo = " + correo + ", el rol = " + rol+" y la contraseña = "+contraseña;
	}

	@Override
	public boolean isWorkTime(LocalDateTime dateTime) {
		LocalTime time = dateTime.toLocalTime();
		boolean isWorkTime = !time.isBefore(HORA_INICIO) && !time.isAfter(HORA_FIN);
        return isWorkTime;
	}

	public abstract boolean verificarDisponibilidad(int tareasPendientes);
	
}
