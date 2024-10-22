package co.edu.konradlorenz.controller;

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
	private Administrador objAdministrador;
	private Lista objLista = new Lista();

	private Tablero tableroAbierto;
	private Lista listaAbierta;
	private Tarea tareaAbierta;

	// > > > > > > > > > > > > > > > > > > > > > > > - < < < < < < < < < < < < < < <
	// < < < < < < //
	// > > > > > > > > > > > > > > > > > > > > M É T O D O S < < < < < < < < < < < <
	// < < < < < < //
	// > > > > > > > > > > > > > > > > > > > > > > > - < < < < < < < < < < < < < < <
	// < < < < < < //

	public void run() {

		// crear Administrador
		String nombre = Vista.pedirString("su nombre");
		String correo = Vista.pedirString("su correo");
		objAdministrador = new Administrador(nombre, correo, "Administrador");

		ejecutarMenuPrincipal();
	}

	public void ejecutarMenuPrincipal() {
		while (true) {
			int opcion = Vista.menuPrincipal();
			switchMenuPrincipal(opcion);
		}
	}
	// ejecutarMenuPrincipal

	public void ejecutarTablero() {
		while (true) {
			Vista.mostrarMensaje("<> <> <> TABLERO: " + tableroAbierto.getNombreTablero() + " <> <> <>");
			int opcion = Vista.menuTablero();
			switchTablero(opcion);
		}
	}
	// ejecutarTablero

	public void ejecutarLista() {
		while (true) {
			Vista.mostrarMensaje("<> <> <> LISTA: " + listaAbierta.getNombreLista() + " <> <> <>");
			int opcion = Vista.menuLista();
			switchLista(opcion);
		}
	}
	// ejecutarLista

	public void ejecutarTarea() {
		while (true) {
			// Las tareas no tienen nombre, le dejamos la descripcion
			Vista.mostrarMensaje("<> <> <> " + tareaAbierta.getDescripcion() + " <> <> <>");
			int opcion = Vista.menuTarea();
			switchTarea(opcion);
		}
	}
	// ejecutarLista

	// > > > > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < <
	// < < < < < //
	// > > > > > > > > > > > > > > > > > > S W I T C H E S < < < < < < < < < < < < <
	// < < < < < //
	// > > > > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < <
	// < < < < < //

	public void switchMenuPrincipal(int opcion) {
		switch (opcion) {
		case 1:
			// 1. crear tablero
			crearTablero();
			break;
		case 2:
			// 2. abrir tablero
			while (true) {
				tableroAbierto = abrirTablero();
				if (tableroAbierto != null) {
					ejecutarTablero();
				} else
					break;
			}
			break;
		case 0:
			// 0. Salir
			Vista.mostrarMensaje("Saliendo ...");
			System.exit(0);
			break;
		default:
			Vista.mostrarMensaje("No es una opción valida.");
			break;
		}
	}
	// switchMenuPrincipal

	public void switchTablero(int opcion) {
		if (tableroAbierto != null) {
			switch (opcion) {
			case 1:
				// 1. agregar lista
				crearLista(tableroAbierto);
				ejecutarTablero();
				break;
			case 2:
				// 2. abrir lista
				while (true) {
					listaAbierta = abrirLista();
					if (listaAbierta != null) {
						ejecutarLista();
					} else
						break;
				}
			case 3:
				// 3. eliminar lista
				eliminarLista(tableroAbierto);
				if (tableroAbierto != null) {
					ejecutarTablero();
				}
				break;
			case 4:
				// 4. volver
				Vista.mostrarMensaje("Volviendo ...");
				ejecutarMenuPrincipal();
				break;
			case 0:
				// 0. Salir
				Vista.mostrarMensaje("Saliendo ...");
				System.exit(0);
				break;
			default:
				Vista.mostrarMensaje("No es una opción valida.");
				break;
			}
			// switch
		}
		// if
	}
	// switchTablero

	public void switchLista(int opcion) {
		if (listaAbierta != null) {
			switch (opcion) {
			case 1:
				// 1. agregar tarea
				crearTarea(listaAbierta);
				ejecutarLista();
				// pedir nombre, descripcion, fecha, delegado, casilla?
				break;
			case 2:
				// 2. abrir tarea

				while (true) {
					tareaAbierta = abrirTarea();
					if (tareaAbierta != null) {
						ejecutarTarea();
					} else
						break;
				}
				break;
			case 3:
				// 3. eliminar tarea
				eliminarTarea(listaAbierta);
				if (listaAbierta != null) {
					ejecutarLista();
				}
				break;
			case 4:
				// 4. volver
				Vista.mostrarMensaje("Volviendo ...");
				ejecutarTablero();
				break;
			case 0:
				// 0. salir
				Vista.mostrarMensaje("Saliendo ...");
				System.exit(0);
				break;
			default:
				Vista.mostrarMensaje("No es una opción valida.");
				break;
			}
			// switch
		}
		// if
	}
	// switchLista

	public void switchTarea(int opcion) {
		if (tareaAbierta != null) {
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
			// case 4: de momento no lo utilizaremos
			// 4. mover tarea

			// modificar casilla
			// abrir tarea
			// break;
			case 5:
				// 5. volver
				Vista.mostrarMensaje("Volviendo ...");
				ejecutarLista();
				break;
			case 0:
				// 0. salir
				Vista.mostrarMensaje("Saliendo ...");
				System.exit(0);
				break;
			default:
				Vista.mostrarMensaje("No es una opción valida.");
				break;
			}
			// switch
		}
		// if
	}
	// switchTarea

	// > > > > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < <
	// < < < < < //
	// > > > > > > > > > > > > > > > > > > > > C R E A R < < < < < < < < < < < < < <
	// < < < < < //
	// > > > > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < <
	// < < < < < //

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
	// crearTablero

	public void crearLista(Tablero tableroElegido) {
		String nombreLista = Vista.pedirString("el nombre de la lista");
		ArrayList<Tarea> listaDeTareas = new ArrayList<>();
		Lista lista = new Lista(nombreLista, listaDeTareas);
		tableroElegido.getListaDeListas().add(lista);
		listaDeListasGlobal.add(lista);
		Vista.mostrarMensaje("Lista agregada correctamente.");

	}
	// crearLista

	public void crearTarea(Lista listaElegida) {
		Tarea objTarea = new Tarea();
		String descripcion = Vista.pedirString("la descripción de la tarea");
		objTarea.setDescripcion(descripcion);
		int anio = Integer.parseInt(Vista.pedirString("el año de la fecha de vencimiento"));
		int mes = Integer.parseInt(Vista.pedirString("el número de mes de la fecha de vencimiento"));
		int dia = Integer.parseInt(Vista.pedirString("el dia de la fecha de vencimiento"));
		int hora = Integer.parseInt(Vista.pedirString("la hora de la fecha de vencimiento"));
		int min = Integer.parseInt(Vista.pedirString("los minutos de la fecha de vencimiento"));
		objTarea.setFechaVencimiento(LocalDateTime.of(anio, mes, dia, hora, min));
		objTarea.setCasilla(false);
		ArrayList<Persona> listaDelegados = new ArrayList<>();
		int indice = Integer.parseInt(Vista.pedirString("cuantos delegados tiene la tarea"));
		for (int i = 1; i <= indice; i++) {
			listaDelegados.add(crearPersona());
		}
		listaElegida.getListaDeTareas().add(objTarea);
		listaDeTareasGlobal.add(objTarea);
		Vista.mostrarMensaje("Tarea agregada correctamente.");
	}
	// crearTarea

	public Persona crearPersona() {
		String nombre = Vista.pedirString("el nombre del delegado");
		String correo = Vista.pedirString("el correo del delegado");
		String rol = Vista.pedirString("el rol del delegado (Colaborador/Administrador)");

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
	// crearPersona

	// > > > > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < <
	// < < < < < //
	// > > > > > > > > > > > > > > > > > > E L I M I N A R < < < < < < < < < < < < <
	// < < < < < //
	// > > > > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < <
	// < < < < < //

	/**
	 * Metodos de eliminar objetos Tablero, Lista, Tarea y Persona. -eliminarTablero
	 * no se usa aún.
	 */
	/*
	 * public void eliminarTablero() {
	 * 
	 * boolean encontrado = false;
	 * 
	 * mostrarTablero(); String nombreBusqueda =
	 * Vista.pedirString("el nombre del tablero que desea eliminar"); for (Tablero
	 * tablero : listaDeTablerosGlobal) { if
	 * (tablero.getNombreTablero().equalsIgnoreCase(nombreBusqueda)) {
	 * listaDeTablerosGlobal.remove(tablero);
	 * Vista.mostrarMensaje("Tablero eliminado correctamente."); encontrado = true;
	 * break; } } if (encontrado == false) { Vista.
	 * mostrarMensaje("EL tablero no fue encontrado, por favor intente de nuevo.");
	 * eliminarTablero(); }
	 * 
	 * }
	 */

	public void eliminarLista(Tablero tableroElegido) {
		mostrarLista(tableroElegido.getListaDeListas());
		if (!tableroElegido.getListaDeListas().isEmpty()) {
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
	}
	// eliminarLista

	public void eliminarTarea(Lista listaElegida) {
		mostrarTarea(listaElegida.getListaDeTareas());
		if (!listaElegida.getListaDeTareas().isEmpty()) {
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
	}
	// eliminarTarea

	public void eliminarPersona(Tarea tareaElegida) {
		if (!tareaElegida.getListaDelegados().isEmpty()) {
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
	}
	// eliminarPersona

	// > > > > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < <
	// < < < < < //
	// > > > > > > > > > > > > > > > > > > > M O S T R A R < < < < < < < < < < < < <
	// < < < < < //
	// > > > > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < <
	// < < < < < //

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
	// mostrarTablero

	public void mostrarLista(ArrayList<Lista> listaDeListas) {

		if (listaDeListas.isEmpty()) {
			Vista.mostrarMensaje("No hay listas creadas para mostrar.");
		} else {
			for (Lista lista : listaDeListas) {
				Vista.mostrarMensaje(" -" + lista.toString());
			}
		}
	}
	// mostrarLista

	public void mostrarTarea(ArrayList<Tarea> listaDeTareas) {

		if (listaDeTareas.isEmpty()) {
			Vista.mostrarMensaje("No hay tareas creadas para mostrar.");
		} else {
			for (int i = 0; i < listaDeTareas.size(); i++)
				Vista.mostrarMensaje("[" + (i + 1) + "] " + listaDeTareas.get(i).getDescripcion());
		}
	}
	// mostrarTarea

	public void mostrarPersonas(ArrayList<Persona> listaDePersonas) {
		if (listaDePersonas.isEmpty()) {
			Vista.mostrarMensaje("No hay Colabores asignados a la tarea.");
		} else {
			for (Persona persona : listaDePersonas) {
				Vista.mostrarMensaje(persona.toString());
			}
		}
	}
	// mostrarPersonas

	// > > > > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < <
	// < < < < < //
	// > > > > > > > > > > > > > > > > > > > > A B R I R < < < < < < < < < < < < < <
	// < < < < < //
	// > > > > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < <
	// < < < < < //

	/**
	 * Metodos para abrir/seleccionar objetos Tablero, Lista, Tarea y Persona. -Creo
	 * que a los metodos de abrir clases se les puede quitar el if del is.empty,
	 * menos al de tablero.
	 */
	public Tablero abrirTablero() {
		boolean encontrado = false;

		Tablero tableroAbierto = null;

		if (listaDeTablerosGlobal.isEmpty()) {
			Vista.mostrarMensaje("No hay tableros creados para abrir.");
			return null;
		} else {
			while (!encontrado) {
				mostrarTablero();
				String nombreBusqueda = Vista.pedirString("El nombre del tablero que desea abrir.");

				for (Tablero tablero : listaDeTablerosGlobal) {
					if (tablero.getNombreTablero().equalsIgnoreCase(nombreBusqueda)) {
						encontrado = true;
						tableroAbierto = tablero;
						break;
					}
				}

				if (!encontrado) {
					Vista.mostrarMensaje("El tablero ingresado no existe, intente de nuevo.");
				}

			}

			return tableroAbierto;
		}
	}
	// abrirTablero

	public Lista abrirLista() {
		boolean encontrado = false;

		if (tableroAbierto.getListaDeListas().isEmpty()) {
			Vista.mostrarMensaje("No hay listas creadas para abrir.");
			objLista = null;
			return null;
		} else {
			mostrarLista(tableroAbierto.getListaDeListas());
			String nombreBusqueda = Vista.pedirString("el nombre de la lista que desea abrir.");
			for (Lista lista : tableroAbierto.getListaDeListas()) {
				if (lista.getNombreLista().equalsIgnoreCase(nombreBusqueda)) {
					encontrado = true;
					Vista.mostrarMensaje("La lista fue encontrada.");
					objLista = lista;
					return lista;
				}
			}
			if (!encontrado) {
				Vista.mostrarMensaje("La lista no fue encontrada, por favor intente de nuevo.");
			}
			return null;
		}
	}
	// abrirLista

	public Tarea abrirTarea() {
		ArrayList<Tarea> listaDeTareas = listaAbierta.getListaDeTareas();
		boolean encontrado = false;
		if (listaDeTareas.isEmpty()) {
			Vista.mostrarMensaje("No hay tareas creadas para abrir.");
			return null;
		} else {
			mostrarTarea(listaDeTareas);
			int indice = Integer.parseInt(Vista.pedirString("el indice de la descripción de la tarea que desea abrir"));
			for (int i = 0; i < listaDeTareas.size(); i++) {
				if ((i + 1) == indice) {
					encontrado = true;
					Vista.mostrarMensaje("La tarea fue encontrada.");
					return listaDeTareas.get(i);
				}
			}
		}
		if (!encontrado) {
			Vista.mostrarMensaje("La tarea no fue encontrada, por favor intente de nuevo");
		}
		return null;
	}
	// abrirTarea

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
	// abrirPersona

	// > > > > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < <
	// < < < < < //
	// > > > > > > > > > > > > > > > > > > M O D I F I C A R < < < < < < < < < < < <
	// < < < < < //
	// > > > > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < <
	// < < < < < //

	public void modificarDescripcionTarea(Tarea tareaEditar) {
		String nuevaDescripcion = Vista.pedirString("la nueva descripción de la tarea");
		tareaEditar.setDescripcion(nuevaDescripcion);
		Vista.mostrarMensaje("Descripción modificada correctamente.");
	}
	// modificarDescripcionTarea

	public void modificarFechaTarea(Tarea tareaEditar) {
		Vista.mostrarMensaje("la nueva fecha de vencimiento de la tarea.");
		int anio = Integer.parseInt(Vista.pedirString("el año de la fecha de vencimiento"));
		int mes = Integer.parseInt(Vista.pedirString("el mes de la fecha de vencimiento"));
		int dia = Integer.parseInt(Vista.pedirString("el dia de la fecha de vencimiento"));
		int hora = Integer.parseInt(Vista.pedirString("la hora de la fecha de vencimiento"));
		int min = Integer.parseInt(Vista.pedirString("los minutos de la fecha de vencimiento"));
		tareaEditar.setFechaVencimiento(LocalDateTime.of(anio, mes, dia, hora, min));
	}
	// modificarFechaTarea

	public void modificarCasilla(Tarea tareaEditar) {
		LocalDateTime tiempoAhora = LocalDateTime.now();
		if (objAdministrador.isWorkTime(tiempoAhora)) {
			Vista.mostrarMensaje("¿La tarea fue finalizada?");
			while (true) {
				String confirmacion = Vista.pedirString("s/n");
				if (confirmacion.equalsIgnoreCase("s")) {
					tareaEditar.setCasilla(true);
					Vista.mostrarMensaje("La tarea fue marcada como finalizada");
				} else if (confirmacion.equalsIgnoreCase("n")) {
					tareaEditar.setCasilla(false);
					Vista.mostrarMensaje("La tarea fue marcada como pendiente");
				}else{
					Vista.mostrarMensaje("Opción incorrecta, itentalo de nuevo");
				}
			}
		} else {
			Vista.mostrarMensaje("No se puede realizar la acción, estás fuera del horario laboral.");
		}
	}
	// modificarCasilla

	public void modificarNombrePersona(Persona personaEditar) {
		String nuevoNombre = Vista.pedirString("el nuevo nombre del delegado");
		personaEditar.setNombre(nuevoNombre);
	}
	// modificarNombrePersona

	public void modificarCorreoPersona(Persona personaEditar) {
		String nuevoCorreo = Vista.pedirString("el nuevo correo del delegado");
		personaEditar.setCorreo(nuevoCorreo);
	}
	// modificarCorreoPersona

	public void modificarRolPersona(Persona personaEditar) {
		String nuevoRol = Vista.pedirString("el nuevo rol del delegado");
		personaEditar.setRol(nuevoRol);
	}
	// modificarRolPersona

	public void modificarNombreLista(Lista listaEditar) {
		String nuevoNombre = Vista.pedirString("el nuevo nombre de la lista");
		listaEditar.setNombreLista(nuevoNombre);
	}
	// modificarNombreLista

	public void modificarNombreTablero(Tablero tableroEditar) {
		String nuevoNombre = Vista.pedirString("el nuevo nombre del tablero");
		tableroEditar.setNombreTablero(nuevoNombre);
	}
	// modificarNombreTablero

	/*
	 * Verificar funcionalidad de este tablero poque esta heavy, toca crear metodos
	 * para recorrer tableros y listas creo public void
	 * moverTarea(ListalistaElegida, Tarea tareaElegida) {
	 * mostrarLista(listaDeListasGlobal); String nombreBusqueda = Vista.
	 * pedirString("el nombre de la lista destino en la que desea mover la tarea");
	 * for (Lista lista : listaDeListasGlobal) { if
	 * (nombreBusqueda.equalsIgnoreCase(lista.getNombreLista())) { for (Tablero
	 * tablero : listaDeTablerosGlobal) { if
	 * (tablero.getListaDeListas().contains(lista)) {
	 * 
	 * } } listaElegida.getListaDeTareas().remove(tareaElegida);
	 * Vista.mostrarMensaje("La tarea fue movida exitosamente"); } }
	 * 
	 * }
	 */

}
//class
