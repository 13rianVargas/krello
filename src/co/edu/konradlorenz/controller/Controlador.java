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
		
		while (true) {
			
			//crear Administrador
			

			int opcion = Vista.menuPrincipal();
			
			switch(opcion) {
				case 1:
					//1. crear tablero
					
					//pedir nombre tablero
					//abrir tablero (siguiente opc por eso sin break)
				case 2:
					//2. abrir tablero
					
					opcion = Vista.menuTablero();
					switch(opcion) {
						case 1:
							//1. agregar lista
							
							//pedir nombre lista
							//abrir lista(siguiente por eso quito el break)
						case 2:
							//2. abrir lista
							
							opcion = Vista.menuLista();
							switch(opcion) {
								case 1:
									//1. agregar tarea
									
									//pedir nombre, descripcion, fecha, delegado, casilla?
									//abrir tarea (sin break)
								case 2:
									//2. abrir tarea
									
									opcion = Vista.menuTarea();
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
											System.exit(0);
											break;
										default:
											Vista.mostrarMensaje("No es una opción valida.");
											break;
									}
									
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
									System.exit(0);
									break;	
								default:
									Vista.mostrarMensaje("No es una opción valida.");
									break;
							}			
							break;
						case 3:
							//3. eliminar lista
							
							//pedir nombre lista
							//volver (siguiente, sin break)
						case 4:
							//4. volver
							break;
						case 5:
							//5. Salir
							Vista.mostrarMensaje("Saliendo ...");
							System.exit(0);
							break;
						default:
							Vista.mostrarMensaje("No es una opción valida.");
							break;					
					}
					
					break;
				case 3:
					//3. Salir
					Vista.mostrarMensaje("Saliendo ...");
					System.exit(0);
					break;
				default:
					Vista.mostrarMensaje("No es una opción valida.");
					break;			
			}
			
		}
		
	}
	
	public Tablero crearTablero() {
		String nombre = Vista.pedirString("Ingrese el nombre del tablero: ");
		Lista lista = new Lista();
		Tablero tablero = new Tablero(nombre, lista);
		listaDeTableros.add(tablero);
		return tablero;
	}
	
	
	public Lista crearLista() {
		String nombre = Vista.pedirString("Ingrese el nombre de la lista: ");
		Tarea tarea = new Tarea();
		Lista lista = new Lista(nombre, tarea);
		listaDeListas.add(lista);
		return lista;
	}
	
	public Tarea crearTarea() {
		String nombre = Vista.pedirString("Ingrese el nombre de la tarea: ");
		String descripcion = Vista.perdirString("Ingrese la descripción de la tarea: ");
		String fecha = Vista.pedirString("Ingrese la fecha de vencimiento de la tarea: ");
		boolean casilla = false;
		Colaborador colaborador = new colaborador();
		Tarea tarea = new Tarea(nombre, descripcion, fecha, casilla, colaborador);
		listaDeTareas.add(tarea);
		return tarea;
	}

	public void crearAdministrador() {
		 String nombre = Vista.pedirString("Ingrese el nombre del administrador: ");
		 String correo = Vista.pedirString("Ingrese el correo del administrador: ");
		    
		 objAdministrador = new Administrador(nombre, correo);
	}
	
	public void crearColaborador() {
		String nombre = Vista.pedirString("Ingrese el nombre del colaborador: ");
		String correo = Vista.pedirString("Ingrese el correo del colaborador: ");

		objColaborador = new Colaborador(nombre, correo);
	}

	public void eliminarTablero(String nombreTablero) {
		boolean encontrado;

		for (Tablero tablero : listaDeTableros) {
			if (tablero.getNombre().equals(nombreTablero)) {
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

	public void eliminarLista(String nombreLista) {
		boolean encontrado;

		for (Lista lista : listaDeListas) {
			if (lista.getNombre().equals(nombreLista)) {
				listaDeListas.remove(lista);
				Vista.mostrarMensaje("lista eliminada");
				encontrado = true;
				break;
			}
		}
		if (encontrado == false) {
			Vista.mostrarMensaje("lista no encontrada");
		}
	}

	public void eliminarTarea(String nombreTarea) {	
		boolean encontrado;

		for (Tarea tarea : listaDeTareas) {
	        if (tarea.getNombre().equals(nombreTarea)) {
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
