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
		
		int opcion = 0;
		boolean ejecucion = true;
		
		//crear Administrador
		//pedri nombre y correo
		
		
		while (true) {
		    opcion = Vista.menuPrincipal();
			
			switch(opcion) {
				case 1:
					crearTablero();
					break;
				case 2:
					abrirTablero();
					break;
				case 3:
					Vista.mostrarMensaje("Saliendo ...");
					ejecucion = false;
					break;
				default:
					Vista.mostrarMensaje("No es una opción valida.");
					break;			
			}
		}
		
	}
	
	public void ejecutarTablero(Tablero tableroSel) {
		
		String nombre = "";
		boolean ejecutar = true; 
		
		while(true) {
			int opcion = Vista.menuTablero();
			
			switch(opcion) {
				case 1:
					crearLista(tableroSel);
					break;
				case 2:
					abrirLista(tableroSel);
					break;
				case 3:
					nombre = Vista.pedirString("el nombre de la lista que desea eliminar: ");
					eliminarLista(tableroSel, nombre);
					mostrarListas(tableroSel);
					break;
				case 4:
					run();
					break;
				case 5:
					Vista.mostrarMensaje("Saliendo ...");
					ejecutar = false;
					break;
				default:
					Vista.mostrarMensaje("No es una opción valida.");
					break;					
			}
		}
		
	}
	
	public void ejecutarLista(Lista lista) {
		int opcion = Vista.menuLista();
		switch(opcion) {
		case 1:
			//1. agregar tarea
			
			//pedir nombre, descripcion, fecha, delegado, casilla?
			//abrir tarea (sin break)
		case 2:
			//2. abrir tarea
			
			opcion = Vista.menuTarea();
			break;
		case 3:
			//3. eliminar tarea
			
			//pedir nombre tarea
			//volver
		case 4:
			//4. volver	
			break;
		case 5: 
			//5. salir
			Vista.mostrarMensaje("Saliendo ...");
			System.exit(0); //Quitar el System...
			break;	
		default:
			Vista.mostrarMensaje("No es una opción valida.");
			break;		
		}
	}
	
	public void ejecutarTarea() {
		int opcion = Vista.menuTarea();
		switch(opcion) {
			case 1:
				//1. modificar descripcion
				
				//abrir tarea
				break;
			case 2:
				//2. modificar fecha
				
				//abrir tarea
				break;
			case 3: 
				//3. modificar casilla
				
				//modificar descripcion
				//modificar fecha
				//abrir tarea
				break;
			case 4: 
				//4. mover tarea
				
				//modificar casilla
				//abrir tarea
				break;
			case 5: 
				//5. volver
				break;
			case 6: 
				//6. salir
				Vista.mostrarMensaje("Saliendo ...");
				System.exit(0); //toca quitar esto de System
				break;
			default:
				Vista.mostrarMensaje("No es una opción valida.");
				break;
		}
	}
	
	public void crearTablero() {
		
		String nombre = Vista.pedirString("Ingrese el nombre del tablero: ");
		ArrayList<Lista> lista = new ArrayList<>();
		Tablero tablero = new Tablero(nombre, lista);
		listaDeTableros.add(tablero);
		
	}
	
	public void crearLista(Tablero tablero) {
		
		String nombre = Vista.pedirString("Ingrese el nombre de la lista: ");
		ArrayList<Tarea> tarea = new ArrayList<>();
		Lista lista = new Lista(nombre, tarea);
		//tablero.agregarLista(lista); agregar el metodo en el model de tablero
		//public void agregarLista(Lista nuevaLista) {
		//	this.getListaDeListas().add(nuevaLista);
		//}
		Vista.mostrarMensaje("Lista '"+nombre+"' agregada al tablero '"+tablero.getNombreTablero()+"'.");
		listaDeListas.add(lista);
		
	}
	
	public Tarea crearTarea() {
		String descripcion = Vista.pedirString("Ingrese la descripción de la tarea: ");
		String fecha = Vista.pedirString("Ingrese la fecha de vencimiento de la tarea: ");
		boolean casilla = false;
		ArrayList<Persona> delegado = new ArrayList<>();
		Tarea tarea = new Tarea( descripcion, fecha, casilla, delegado);
		listaDeTareas.add(tarea);
		return tarea;
	}

	public Persona crearDelegado() {
		String nombre = Vista.pedirString("Ingrese el nombre del delegado: ");
		String correo = Vista.pedirString("Ingrese el correo del delegado: ");
		String rol = Vista.pedirString("Ingrese el rol del delegado: ").toLowerCase();
		
		if (rol.equals("colaborador")) {
			return objColaborador = new Colaborador(nombre, correo, rol);
		}else  if (rol.equals("administrador")) {
			return objAdministrador = new Administrador(nombre, correo, rol);
		} else {
			Vista.mostrarMensaje("No es un rol valido.");
			crearDelegado();
		}
		return null;
	}
	
	public void abrirTablero(){
		
		if(listaDeTableros.isEmpty()){
			Vista.mostrarMensaje("No hay tableros. Por favor, cree uno primero.");
		} else {
			mostrarTableros();
		
			String nombre = Vista.pedirString("Ingrese el nombre del tablero que desea abrir: ");
			Tablero tableroAbrir = null;
		
			for(Tablero tablero : listaDeTableros) {
				if(tablero.getNombreTablero().equalsIgnoreCase(nombre)) {
					tableroAbrir = tablero;
				break;
				}
			}
		
			if(tableroAbrir != null) {
				Vista.mostrarMensaje("Tablero "+nombre+" abierto.");
				ejecutarTablero(tableroAbrir);
			} else {
				Vista.mostrarMensaje("No se encontró el tablero "+nombre);
			}
		}
		
	}
	
	public void abrirLista(Tablero tablero) {
		
		mostrarListas(tablero);
		
		if(!tablero.getListaDeListas().isEmpty()) {
			String nombre = Vista.pedirString("Ingrese el nombre de la lista que desea abrir: ");
			Lista listaAbrir = null;
			
			for(Lista lista : tablero.getListaDeListas()) {
				if(lista.getNombreLista().equalsIgnoreCase(nombre)) {
					listaAbrir = lista;
					break;
				}
			}
		
			if(listaAbrir != null) {
				Vista.mostrarMensaje("Lista"+nombre+" abierta.");
				ejecutarLista(listaAbrir);
			} else {
				Vista.mostrarMensaje("No se encontró la lista "+nombre+".");
			}
		}
		
	}
	
	public void mostrarTableros() {
		
		Vista.mostrarMensaje("Tableros: ");
		for (int i=0; i<listaDeTableros.size(); i++) {
			Tablero tablero = listaDeTableros.get(i);
			Vista.mostrarMensaje((i+1)+". "+tablero.getNombreTablero());
		}
		
	}
	
	public void mostrarListas(Tablero tablero) {
		
		ArrayList<Lista> listas = tablero.getListaDeListas();
		
		if(listas.isEmpty()) {
			Vista.mostrarMensaje("No hay listas. Por favor, cree una primero.");
		}else {
			Vista.mostrarMensaje("Listas en el tablero '"+tablero.getNombreTablero()+"':");
			for (int i=0; i<listas.size(); i++) {
				Lista lista = listas.get(i);
				Vista.mostrarMensaje((i+1)+". "+lista.getNombreLista());
			}
		}
		
	}

	public void eliminarTablero(String nombreTablero) {
		boolean encontrado = false;

		for (Tablero tablero : listaDeTableros) {
			if (tablero.getNombreTablero().equals(nombreTablero)) {
				listaDeTableros.remove(tablero);
				Vista.mostrarMensaje("tablero eliminado");
				encontrado = true;
				break;
			}
		}
		if (encontrado==false) {
			Vista.mostrarMensaje("tablero no encontrado");
		}
	}

	public void eliminarLista(Tablero tablero, String nombreLista) {
		
		boolean encontrado = false;
		ArrayList<Lista> listasDelTablero = tablero.getListaDeListas();

		for (Lista lista : listasDelTablero) {
			if (lista.getNombreLista().equalsIgnoreCase(nombreLista)) {
				listasDelTablero.remove(lista);
				Vista.mostrarMensaje("Lista '"+nombreLista+"' eliminada del tablero '"+tablero.getNombreTablero()+"'.");
				encontrado = true;
				break;
			}
		}
		if (encontrado == false) {
			Vista.mostrarMensaje("No se encontró la lista '"+nombreLista+"' en el tablero.");
		}
		
	}

	public void eliminarTarea(String nombreTarea) {	
		boolean encontrado = false;

		for (Tarea tarea : listaDeTareas) {
	        if (tarea.getDescripcion().equals(nombreTarea)) {
	            listaDeTareas.remove(tarea);
	            Vista.mostrarMensaje("tarea eliminada");
	            encontrado = true;
	            break;
	        }
	    }
		if (encontrado == false) {
			Vista.mostrarMensaje("tarea no encontrada");
		}
	}
}
