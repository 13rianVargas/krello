package co.edu.konradlorenz.controller;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

import co.edu.konradlorenz.view.Vista;
import co.edu.konradlorenz.model.*;

public class Controlador {

	/*
	 * protected Administrador objAdministrador = new Administrador(); protected
	 * Colaborador objColaborador = new Colaborador(); protected Tablero objTablero
	 * = new Tablero(); protected Lista objLista = new Lista(); protected Tarea
	 * objTarea = new Tarea(); private ArrayList<Persona> listaPersonasGlobal = new
	 * ArrayList<>();
	 */

	private ArrayList<Lista> listaDeListasGlobal = new ArrayList<>();
	private ArrayList<Tarea> listaDeTareasGlobal = new ArrayList<>();
	private ArrayList<Tablero> listaDeTablerosGlobal = new ArrayList<>();

	public void run(boolean ejecucion) {

		// crear Administrador
		String nombre = Vista.pedirString("su nombre.");
		String correo = Vista.pedirString("su correo.");
		Administrador objAdministrador = new Administrador(nombre, correo, "Administrador");

		while (ejecucion) {

			int opcion = Vista.menuPrincipal();

			switch (opcion) {
			case 1:
				// 1. crear tablero
				crearTablero();
				break;
			case 2:
				// 2. abrir tablero
				Tablero tableroSel = abrirTablero();
				ejecutarTablero(tableroSel);
				break;
			case 3:
				// 3. Salir
				Vista.mostrarMensaje("Saliendo ...");
				ejecucion = false;
				break;
			default:
				Vista.mostrarMensaje("No es una opción valida.");
				break;
			}

		}

	}

	public void ejecutarTablero(Tablero tableroAbierto) {

		boolean ejecucion = true;

		while (ejecucion) {

			Vista.mostrarMensaje("<> <> <> " + tableroAbierto.getNombreTablero() + " <> <> <>");

			int opcion = Vista.menuTablero();

			switch (opcion) {
			case 1:
				// 1. agregar lista
				crearLista(tableroAbierto);
				break;
			case 2:
				// 2. abrir lista
				Lista listaAbierta = abrirLista(tableroAbierto);
				ejecutarLista(listaAbierta);
				break;
			case 3:
				// 3. eliminar lista
				eliminarLista(tableroAbierto);
				break;
			case 4:
				// 4. volver
				ejecucion = false;
				break;
			case 5:
				// 5. Salir

				Vista.mostrarMensaje("Saliendo ...");
				salirPrograma();
				break;
			default:
				Vista.mostrarMensaje("No es una opción valida.");
				break;
			}
		}
	}

	public void ejecutarLista(Lista listaAbierta) {

		boolean ejecucion = true;
		int opcion = 0;

		while (ejecucion) {

			Vista.mostrarMensaje("<> <> <> " + listaAbierta.getNombreLista() + " <> <> <>");

			opcion = Vista.menuLista();

			switch (opcion) {
			case 1:
				// 1. agregar tarea
				crearTarea(listaAbierta);
				// pedir nombre, descripcion, fecha, delegado, casilla?
				// abrir tarea (sin break)
				break;
			case 2:
				// 2. abrir tarea
				Tarea tareaAbierta = abrirTarea(listaAbierta);
				ejecutarTarea(tareaAbierta);
				break;
			case 3:
				// 3. eliminar tarea
				eliminarTarea(listaAbierta);
				// pedir nombre tarea
				// volver
				break;
			case 4:
				// 4. volver
				ejecucion = false;
				break;
			case 5:
				// 5. salir
				Vista.mostrarMensaje("Saliendo ...");
				salirPrograma();
				break;
			default:
				Vista.mostrarMensaje("No es una opción valida.");
				break;
			}
		}
	}

	public void ejecutarTarea(Tarea tareaAbierta) {

		boolean ejecucion = true;
		int opcion = 0;

		while (ejecucion) {

			// Las tareas no tienen nombre, le dejamos la descripcion
			Vista.mostrarMensaje("<> <> <> " + tareaAbierta.getDescripcion() + " <> <> <>");

			opcion = Vista.menuTarea();

			switch (opcion) {
			case 1:
				// 1. modificar descripcion
				modificarDescripcionTarea(tareaAbierta);
				// abrir tarea
				break;
			case 2:
				// 2. modificar fecha
				modificarFechaTarea(tareaAbierta);
				// abrir tarea
				break;
			case 3:
				// 3. modificar casilla
				modificarCasilla(tareaAbierta);
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
				ejecucion = false;
				break;
			case 6:
				// 6. salir
				Vista.mostrarMensaje("Saliendo ...");
				salirPrograma();
				break;
			default:
				Vista.mostrarMensaje("No es una opción valida.");
				break;
			}
		}
	}

	/**
	 * Metodos de crear objetos Tablero, Lista, Tarea y Persona. -crearPersona() se
	 * utiliza unicamente en el método crearTarea.
	 */
	public void crearTablero() {

		String nombreTablero = Vista.pedirString("el nombre del tablero");
		ArrayList<Lista> listaDeListas = new ArrayList<>();
		Tablero tablero = new Tablero(nombreTablero, listaDeListas);
		listaDeTablerosGlobal.add(tablero);

		Vista.mostrarMensaje("Tablero agregado correctamente.");
	}

	public void crearLista(Tablero tableroElegido) {
		String nombreLista = Vista.pedirString("el nombre de la lista");
		ArrayList<Tarea> listaDeTareas = new ArrayList<>();
		Lista lista = new Lista(nombreLista, listaDeTareas);
		tableroElegido.getListaDeListas().add(lista);
		listaDeListasGlobal.add(lista);
		Vista.mostrarMensaje("Lista agregada correctamente.");

	}

	public void crearTarea(Lista listaElegida) {
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
		listaElegida.getListaDeTareas().add(objTarea);
		listaDeTareasGlobal.add(objTarea);
		Vista.mostrarMensaje("Tarea agregada correctamente.");
	}

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

	/**
	 * Metodos de eliminar objetos Tablero, Lista, Tarea y Persona.
	 */
	public void eliminarTablero() {

		boolean encontrado = false;
		String nombreBusqueda = Vista.pedirString("el nombre del tablero que desea eliminar");
		for (Tablero tablero : listaDeTablerosGlobal) {
			if (tablero.getNombreTablero().equalsIgnoreCase(nombreBusqueda)) {
				listaDeTablerosGlobal.remove(tablero);
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
		String nombreBusqueda = Vista.pedirString("el nombre de la lista que desea eliminar");
		for (Lista lista : tableroElegido.getListaDeListas()) {
			if (lista.getNombreLista().equalsIgnoreCase(nombreBusqueda)) {
				tableroElegido.getListaDeListas().remove(lista);
				listaDeListasGlobal.remove(lista);
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
		int indiceBusqueda = Integer.parseInt(Vista.pedirString("el indice de la tarea que desea eliminar"));
		boolean encontrado = false;

		for (int i = 0; i < listaElegida.getListaDeTareas().size(); i++) {
			if (indiceBusqueda == (i + 1)) {
				listaElegida.getListaDeTareas().remove(i);
				listaDeTareasGlobal.remove(i);
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

	public void eliminarPersona(Tarea tareaElegida) {
		String nombreBusqueda = Vista.pedirString("el nombre del delegado que desea eliminar");
		boolean encontrado = false;
		for (Persona persona : tareaElegida.getListaDelegados()) {
			if (persona.getNombre().equalsIgnoreCase(nombreBusqueda)) {
				tareaElegida.getListaDelegados().remove(persona);
				Vista.mostrarMensaje("Persona eliminada correctamente.");
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			Vista.mostrarMensaje("La persona no fue encontrada, por favor intente de nuevo.");
			eliminarPersona(tareaElegida);
		}
	}

	/**
	 * Metodos para mostrar listas, tableros, tareas y personas. -los métodos de
	 * mostrar unicamente se usan en los métodos de abrir y moverTarea.
	 */
	public void mostrarTablero() {
		if (listaDeTablerosGlobal.isEmpty()) {
			Vista.mostrarMensaje("No hay tableros creados para mostrar.");
		} else {
			for (Tablero tablero : listaDeTablerosGlobal) {
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

	/**
	 * Metodos para abrir/seleccionar objetos Tablero, Lista, Tarea y Persona. -Creo
	 * que a los metodos de abrir clases se les puede quitar el if del is.empty,
	 * menos al de tablero.
	 */
	public Tablero abrirTablero() {
		boolean encontrado = false;
		if (listaDeTablerosGlobal.isEmpty()) {
			Vista.mostrarMensaje("No hay tableros creados para abrir.");
			return null;
		} else {
			mostrarTablero();
			String nombreBusqueda = Vista.pedirString("el nombre del tablero que desea abrir.");
			for (Tablero tablero : listaDeTablerosGlobal) {
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
			String nombreBusqueda = Vista.pedirString("el nombre de la lista que desea abrir.");
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
			int indice = Integer
					.parseInt(Vista.pedirString("el indice de la descripción de la tarea que desea abrir."));
			for (int i = 0; i < listaDeTareas.size(); i++) {
				if ((i + 1) == indice) {
					encontrado = true;
					Vista.mostrarMensaje("La tarea fue encontrada.");
					return listaDeTareas.get(i);
				}
			}
		}
		if (!encontrado) {
			Vista.mostrarMensaje("La tarea no fue encontrada, por favor intente de nuevo.");
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

	/**
	 * Metodos para modificar objetos Tablero, Lista, Tarea y Persona.
	 * 
	 */
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

	public void modificarNombreLista(Lista listaEditar) {
		String nuevoNombre = Vista.pedirString("el nuevo nombre de la lista");
		listaEditar.setNombreLista(nuevoNombre);
	}

	public void modificarNombreTablero(Tablero tableroEditar) {
		String nuevoNombre = Vista.pedirString("el nuevo nombre del tablero");
		tableroEditar.setNombreTablero(nuevoNombre);
	}

	/* Verificar funcionalidad de este tablero poque est heavy, toca crear metodos para recorrer tableros y listas creo
	public void moverTarea(Lista listaElegida, Tarea tareaElegida) {
		mostrarLista(listaDeListasGlobal);
		String nombreBusqueda = Vista.pedirString("el nombre de la lista destino en la que desea mover la tarea");
		for (Lista lista : listaDeListasGlobal) {
			if (nombreBusqueda.equalsIgnoreCase(lista.getNombreLista())) {
				for (Tablero tablero : listaDeTablerosGlobal) {
					if (tablero.getListaDeListas().contains(lista)) {
						
					}
				}
				listaElegida.getListaDeTareas().remove(tareaElegida);
				Vista.mostrarMensaje("La tarea fue movida exitosamente");
			}
		}

	}*/
	public void salirPrograma() {
		boolean ejecucion = false;
		run(ejecucion);
	}
}
