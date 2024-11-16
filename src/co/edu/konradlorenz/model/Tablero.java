package co.edu.konradlorenz.model;

import java.util.ArrayList;

public class Tablero {
    private String nombreTablero;
    private String nombreAdministrador;
    private ArrayList<Persona> listaDeInvitados = new ArrayList<>();
    private ArrayList<Lista> listaDeListas = new ArrayList<>();

    public Tablero() {
    }
    
    public Tablero(String nombreTablero, String nombreAdministrador) {
        this.nombreTablero = nombreTablero;
        this.nombreAdministrador = nombreAdministrador;
    }

	public String getNombreTablero() {
		return nombreTablero;
	}

	public void setNombreTablero(String nombreTablero) {
		this.nombreTablero = nombreTablero;
	}

	public String getNombreAdministrador() {
		return nombreAdministrador;
	}

	public void setNombreAdministrador(String nombreAdministrador) {
		this.nombreAdministrador = nombreAdministrador;
	}

	public ArrayList<Persona> getListaDeInvitados() {
		return listaDeInvitados;
	}

	public void setListaDeInvitados(ArrayList<Persona> listaDeInvitados) {
		this.listaDeInvitados = listaDeInvitados;
	}

	public ArrayList<Lista> getListaDeListas() {
		return listaDeListas;
	}

	public void setListaDeListas(ArrayList<Lista> listaDeListas) {
		this.listaDeListas = listaDeListas;
	}

	@Override
	public String toString() {
		return "Tablero [nombreTablero=" + nombreTablero + ", nombreAdministrador=" + nombreAdministrador
				+ ", listaDeInvitados=" + listaDeInvitados + ", listaDeListas=" + listaDeListas + "]";
	}
    
}