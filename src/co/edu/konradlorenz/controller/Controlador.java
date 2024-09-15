package co.edu.konradlorenz.controller;

import java.util.ArrayList;

import co.edu.konradlorenz.view.Vista;
import co.edu.konradlorenz.model.*;

public class Controlador {

	protected Administrador objAdministrador = new Administrador();	
	protected Colaborador objColaborador = new Colaborador();
	protected Tablero objTablero = new Tablero();
	protected Lista objLista = new Lista();
	protected Tarea objTarea = new Tarea();
	
	private ArrayList<Tablero> listaDeTableros = new ArrayList<>();
	private ArrayList<Lista> listaDeListas = new ArrayList<>();
	private ArrayList<Tarea> listaDeTareas = new ArrayList<>();

	
	public void run() {
		
		
	}
	
	public Tablero crearTablero() {
		
		return Tablero;
	}
	
	
	public Lista crearLista() {
		
		return Lista;
	}
	
	public Tarea crearTarea() {
		
		return Tarea;
	}

	public void crearAdministrador() {
		
		
	}
	
	public void crearColaborador() {
		
		
	}
	
	public void eliminarTablero(String nombreTablero) {
		
		
	}
	
	public void eliminarLista(String nombreLista) {
		
		
	}
	

	public void eliminarTarea(String nombreTarea) {
		
		
	}
	
	

}
