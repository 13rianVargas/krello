package co.edu.konradlorenz.model;

import java.util.ArrayList;

public class Tablero {
    private String nombreTablero;
    private ArrayList<Persona> listaDeInvitados = new ArrayList<>();
    private ArrayList<Lista> listaDeListas = new ArrayList<>();

    public Tablero() {
    }
    
    public Tablero(String nombreTablero) {
        this.nombreTablero = nombreTablero;
    }
    
    public Tablero(String nombreTablero, ArrayList<Persona> listaDeInvitados) {
        this.nombreTablero = nombreTablero;
        this.listaDeInvitados = listaDeInvitados;
    }

    public String getNombreTablero() {
        return nombreTablero;
    }

    public void setNombreTablero(String nombreTablero) {
        this.nombreTablero = nombreTablero;
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
		return "Tablero [nombreTablero=" + nombreTablero + ", listaDeInvitados=" + listaDeInvitados + ", listaDeListas="
				+ listaDeListas + "]";
	}
    
}