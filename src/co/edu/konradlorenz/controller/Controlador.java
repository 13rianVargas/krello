package co.edu.konradlorenz.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import co.edu.konradlorenz.view.Vista;
import co.edu.konradlorenz.model.*;

public class Controlador {

	/*
	 * Para que estan ahi? (Creo que su uso es el poder almacenar entre metodos que
	 * listas objetos se van eligiendo) (pero revisar al momento de hacer los
	 * switch) protected Administrador objAdministrador = new Administrador();
	 * protected Colaborador objColaborador = new Colaborador(); protected Tablero
	 * objTablero = new Tablero(); protected Lista objLista = new Lista(); protected
	 * Tarea objTarea = new Tarea(); private ArrayList<Lista> listaDeListas = new
	 * ArrayList<>(); private ArrayList<Tarea> listaDeTareas = new ArrayList<>();
	 */

	private ArrayList<Tablero> listaDeTableros = new ArrayList<>();

	public void run() {

		while (true) {

			// crear Administrador

			int opcion = Vista.menuPrincipal();

			switch (opcion) {
			case 1:
				// 1. crear tablero

				// pedir nombre tablero
				// abrir tablero (siguiente opc por eso sin break)
			case 2:
				// 2. abrir tablero

				opcion = Vista.menuTablero();
				switch (opcion) {
				case 1:
					// 1. agregar lista

					// pedir nombre lista
					// abrir lista(siguiente por eso quito el break)
				case 2:
					// 2. abrir lista

					opcion = Vista.menuLista();
					switch (opcion) {
					case 1:
						// 1. agregar tarea

						// pedir nombre, descripcion, fecha, delegado, casilla?
						// abrir tarea (sin break)
					case 2:
						// 2. abrir tarea

						opcion = Vista.menuTarea();
						switch (opcion) {
						case 1:
							// 1. modificar descripcion

							// abrir tarea
							break;
						case 2:
							// 2. modificar fecha

							// abrir tarea
							break;
						case 3:
							// 3. modificar casilla

							// modificar descripcion
							// modificar fecha
							// abrir tarea
							break;
						case 4:
							// 4. mover tarea

							// modificar casilla
							// abrir tarea
							break;
						case 5:
							// 5. volver
							break;
						case 6:
							// 6. salir
							Vista.mostrarMensaje("Saliendo ...");
							System.exit(0);
							break;
						default:
							Vista.mostrarMensaje("No es una opción valida.");
							break;
						}

						break;
					case 3:
						// 3. eliminar tarea

						// pedir nombre tarea
						// volver
					case 4:
						// 4. volver
						break;
					case 5:
						// 5. salir
						Vista.mostrarMensaje("Saliendo ...");
						System.exit(0);
						break;
					default:
						Vista.mostrarMensaje("No es una opción valida.");
						break;
					}
					break;
				case 3:
					// 3. eliminar lista

					// pedir nombre lista
					// volver (siguiente, sin break)
				case 4:
					// 4. volver
					break;
				case 5:
					// 5. Salir
					Vista.mostrarMensaje("Saliendo ...");
					System.exit(0);
					break;
				default:
					Vista.mostrarMensaje("No es una opción valida.");
					break;
				}

				break;
			case 3:
				// 3. Salir
				Vista.mostrarMensaje("Saliendo ...");
				System.exit(0);
				break;
			default:
				Vista.mostrarMensaje("No es una opción valida.");
				break;
			}

		}

	}

	public void crearTablero() {
		String nombreTablero = Vista.pedirString("el nombre del tablero");
		ArrayList<Lista> listaDeListas = new ArrayList<>();
		Tablero tablero = new Tablero(nombreTablero, listaDeListas);
		listaDeTableros.add(tablero);
	}

	public void crearLista(Tablero tableroElegido) {
		ArrayList<Lista> listaDeListas = tableroElegido.getListaDeListas();
		String nombreLista = Vista.pedirString("el nombre de la lista");
		ArrayList<Tarea> listaDeTareas = new ArrayList<>();
		Lista lista = new Lista(nombreLista, listaDeTareas);
		listaDeListas.add(lista);
	}

	public void crearTarea(Lista listaElegida) {
		ArrayList<Tarea> listaDeTareas = listaElegida.getListaDeTareas();
		Tarea objTarea = new Tarea();
		String descripcion = Vista.pedirString("la descripción de la tarea");
		objTarea.setDescripcion(descripcion);
		int anio = Integer.parseInt(Vista.pedirString("el año de la fecha de vencimiento"));
		int dia = Integer.parseInt(Vista.pedirString("el mes de la fecha de vencimiento"));
		int mes = Integer.parseInt(Vista.pedirString("el dia de la fecha de vencimiento"));
		int hora = Integer.parseInt(Vista.pedirString("la hora de la fecha de vencimiento"));
		int min = Integer.parseInt(Vista.pedirString("los minutos de la fecha de vencimiento"));
		objTarea.setFechaVencimiento(LocalDateTime.of(anio, mes, dia, hora, min));
		objTarea.setCasilla(false);
		ArrayList<Persona> listaDelegados = new ArrayList<>();
		int indice = Integer.parseInt(Vista.pedirString("cuantos delegados tiene la tarea"));
		for (int i = 0; i <= indice; i++) {
			listaDelegados.add(crearPersona());
		}
		objTarea.setListaDelegados(listaDelegados);
		listaDeTareas.add(objTarea);
	}

	// Se utiliza unicamente en el método crearTarea.
	public Persona crearPersona() {
		String nombre = Vista.pedirString("el nombre del delegado");
		String correo = Vista.pedirString("el correo del delegado");
		String rol = Vista.pedirString("el rol del delegado");

		if (rol.equalsIgnoreCase("colaborador")) {
			Colaborador objColaborador = new Colaborador(nombre, correo, rol);
			return objColaborador;
		} else if (rol.equalsIgnoreCase("administrador")) {
			Administrador objAdministrador = new Administrador(nombre, correo, rol);
			return objAdministrador;
		} else {
			Vista.mostrarMensaje("No es un rol valido.");
			Vista.mostrarMensaje("Por favor elige entre las opciones disponibles. Colaborador/Administrador");
			crearPersona();
		}
		return null;
	}

	public void eliminarTablero() {
		boolean encontrado = false;
		String nombreBusqueda = Vista.pedirString("Por favor ingrese el nombre del tablero que desea eliminar");
		for (Tablero tablero : listaDeTableros) {
			if (tablero.getNombreTablero().equalsIgnoreCase(nombreBusqueda)) {
				listaDeTableros.remove(tablero);
				Vista.mostrarMensaje("Tablero eliminado correctamente.");
				encontrado = true;
				break;
			}
		}
		if (encontrado == false) {
			Vista.mostrarMensaje("EL tablero no fue encontrado, por favor intente de nuevo.");
			eliminarTablero();
		}
	}

	public void eliminarLista(Tablero tableroElegido) {
		boolean encontrado = false;
		ArrayList<Lista> listaDeListas = tableroElegido.getListaDeListas();
		String nombreBusqueda = Vista.pedirString("Por favor ingrese el nombre de la lista que desea eliminar");
		for (Lista lista : listaDeListas) {
			if (lista.getNombreLista().equals(nombreBusqueda)) {
				listaDeListas.remove(lista);
				Vista.mostrarMensaje("Lista eliminada correctamente.");
				encontrado = true;
				break;
			}
		}
		if (encontrado == false) {
			Vista.mostrarMensaje("La lista no fue encontrada, por favor intente de nuevo.");
			eliminarLista(tableroElegido);
		}
	}

	public void eliminarTarea(Lista listaElegida) {
		ArrayList<Tarea> listaDeTareas = listaElegida.getListaDeTareas();
		int indiceBusqueda = Integer
				.parseInt(Vista.pedirString("Por favor ingrese el indice de la tarea que desea eliminar"));
		boolean encontrado = false;

		for (int i = 0; i < listaDeTareas.size(); i++) {
			if (indiceBusqueda == (i + 1)) {
				listaDeTareas.remove(i);
				Vista.mostrarMensaje("Tarea eliminada correctamente.");
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			Vista.mostrarMensaje("La tarea no fue encontrada, por favor intente de nuevo.");
			eliminarTarea(listaElegida);
		}
	}

	// los métodos de mostrar unicamente se usan en los métodos de abrir.
	public void mostrarTablero() {
		if (listaDeTableros.isEmpty()) {
			Vista.mostrarMensaje("No hay tableros creados para mostrar.");
		} else {
			for (Tablero tablero : listaDeTableros) {
				Vista.mostrarMensaje(" -" + tablero.toString());
			}
		}
	}

	public void mostrarLista(ArrayList<Lista> listaDeListas) {

		if (listaDeListas.isEmpty()) {
			Vista.mostrarMensaje("No hay listas creadas para mostrar.");
		} else {
			for (Lista lista : listaDeListas) {
				Vista.mostrarMensaje(" -" + lista.toString());
			}
		}
	}

	public void mostrarTarea(ArrayList<Tarea> listaDeTareas) {

		if (listaDeTareas.isEmpty()) {
			Vista.mostrarMensaje("No hay tareas creadas para mostrar.");
		} else {
			for (int i = 0; i < listaDeTareas.size(); i++)
				Vista.mostrarMensaje("[" + (i + 1) + "] " + listaDeTareas.get(i).getDescripcion());
		}
	}

	public void mostrarPersonas(ArrayList<Persona> listaDePersonas) {
		if (listaDePersonas.isEmpty()) {
			Vista.mostrarMensaje("No hay Colabores asignados a la tarea.");
		} else {
			for (Persona persona : listaDePersonas) {
				Vista.mostrarMensaje(persona.toString());
			}
		}
	}

	// Creo que a los metodos de abrir clases se les puede quitar el if del
	// is.empty, menos al de tablero.
	public Tablero abrirTablero() {
		boolean encontrado = false;
		if (listaDeTableros.isEmpty()) {
			Vista.mostrarMensaje("No hay tableros creados para abrir.");
			return null;
		} else {
			mostrarTablero();
			String nombreBusqueda = Vista.pedirString("Por favor ingrese el nombre del tablero que desea abrir.");
			for (Tablero tablero : listaDeTableros) {
				if (tablero.getNombreTablero().equalsIgnoreCase(nombreBusqueda)) {
					encontrado = true;
					return tablero;
				}
			}
			if (!encontrado) {
				Vista.mostrarMensaje("El tablero no fue encontrado, por favor intente de nuevo.");
				abrirTablero();
			}
			return null;
		}
	}

	public Lista abrirLista(Tablero tableroElegido) {
		ArrayList<Lista> listaDeListas = tableroElegido.getListaDeListas();
		boolean encontrado = false;
		if (listaDeListas.isEmpty()) {
			Vista.mostrarMensaje("No hay listas creadas para abrir.");
			return null;
		} else {
			mostrarLista(listaDeListas);
			String nombreBusqueda = Vista.pedirString("Por favor ingrese el nombre de la lista que desea abrir.");
			for (Lista lista : listaDeListas) {
				if (lista.getNombreLista().equalsIgnoreCase(nombreBusqueda)) {
					encontrado = true;
					Vista.mostrarMensaje("La lista fue encontrada.");
					return lista;
				}
			}
			if (!encontrado) {
				Vista.mostrarMensaje("La lista no fue encontrada, por favor intente de nuevo.");
				abrirLista(tableroElegido);
			}
			return null;
		}
	}

	public Tarea abrirTarea(Lista listaElegida) {
		ArrayList<Tarea> listaDeTareas = listaElegida.getListaDeTareas();
		boolean encontrado = false;
		if (listaDeTareas.isEmpty()) {
			Vista.mostrarMensaje("No hay tareas creadas para abrir.");
			return null;
		} else {
			mostrarTarea(listaDeTareas);
			int indice = Integer.parseInt(
					Vista.pedirString("Por favor elija el idice de la descripción de la tarea que desea abrir."));
			for (int i = 0; i < listaDeTareas.size(); i++) {
				if ((i + 1) == indice) {
					encontrado = true;
					Vista.mostrarMensaje("La tarea fue encontrada.");
					return listaDeTareas.get(i);
				}
			}
		}
		if (!encontrado) {
			Vista.mostrarMensaje("La terea no fue encontrada, por favor intente de nuevo.");
			abrirTarea(listaElegida);
		}
		return null;
	}

	public Persona abrirPersona(Tarea tareaElegida) {
		ArrayList<Persona> listaDePersonas = tareaElegida.getListaDelegados();
		boolean encontrado = false;
		if (listaDePersonas.isEmpty()) {
			Vista.mostrarMensaje("No hay delegados asignados a la tarea.");
		} else {
			mostrarPersonas(listaDePersonas);
			String nombreBusqueda = Vista.pedirString("el nombre del delegado que deseas abrir");
			for (Persona persona : listaDePersonas) {
				if (persona.getNombre().equalsIgnoreCase(nombreBusqueda)) {
					encontrado = true;
					Vista.mostrarMensaje("El delegado fue encontrado.");
					return persona;
				}
			}
			if (!encontrado) {
				Vista.mostrarMensaje("La persona no fue encontrada, por favor intente de nuevo.");
				abrirPersona(tareaElegida);
			}
		}
		return null;
	}

	public void modificarDescripcionTarea(Tarea tareaEditar) {
		String nuevaDescripcion = Vista.pedirString("la nueva descripción de la tarea");
		tareaEditar.setDescripcion(nuevaDescripcion);
	}

	public void modificarFechaTarea(Tarea tareaEditar) {
		Vista.mostrarMensaje("la nueva fecha de vencimiento de la tarea.");
		int anio = Integer.parseInt(Vista.pedirString("el año de la fecha de vencimiento"));
		int dia = Integer.parseInt(Vista.pedirString("el mes de la fecha de vencimiento"));
		int mes = Integer.parseInt(Vista.pedirString("el dia de la fecha de vencimiento"));
		int hora = Integer.parseInt(Vista.pedirString("la hora de la fecha de vencimiento"));
		int min = Integer.parseInt(Vista.pedirString("los minutos de la fecha de vencimiento"));
		tareaEditar.setFechaVencimiento(LocalDateTime.of(anio, mes, dia, hora, min));
	}

	public void modificarCasilla(Tarea tareaEditar) {
		Vista.mostrarMensaje("¿La tarea fue finalizada?");
		String confirmacion = Vista.pedirString("si/no");
		if (confirmacion.equalsIgnoreCase("si")) {
			tareaEditar.setCasilla(true);
			Vista.mostrarMensaje("La tarea fue marcada como finalizada");
		} else {
			tareaEditar.setCasilla(false);
			Vista.mostrarMensaje("La tarea fue marcada como pendiente");
		}
	}

	public void modificarNombrePersona(Persona personaEditar) {
		String nuevoNombre = Vista.pedirString("el nuevo nombre del delegado");
		personaEditar.setNombre(nuevoNombre);
	}

	public void modificarCorreoPersona(Persona personaEditar) {
		String nuevoCorreo = Vista.pedirString("el nuevo correo del delegado");
		personaEditar.setCorreo(nuevoCorreo);
	}

	public void modificarRolPersona(Persona personaEditar) {
		String nuevoRol = Vista.pedirString("el nuevo rol del delegado");
		personaEditar.setRol(nuevoRol);
	}

	//Hacer métodos para editar los tableros, listas y tareas ya hechas?.
}
