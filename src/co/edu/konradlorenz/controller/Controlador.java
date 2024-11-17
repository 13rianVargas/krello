package co.edu.konradlorenz.controller;

import java.awt.Color;
import java.awt.Container;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import co.edu.konradlorenz.view.*;
import co.edu.konradlorenz.view.gui.*;
import co.edu.konradlorenz.model.*;

public class Controlador {
	
	//MOSTRAR DETALLES
	public boolean detalles = true;//true -> mostrar / false -> ocultar

	private ArrayList<Tablero> listaDeTablerosGlobal = new ArrayList<>();
	private ArrayList<Lista> listaDeListasGlobal = new ArrayList<>();
	private ArrayList<Tarea> listaDeTareasGlobal = new ArrayList<>();
	private ArrayList<Persona> listaDePersonasGlobal = new ArrayList<>();
	private Administrador objAdministrador;

	private Administrador administradorAbierto;
	private Tablero tableroAbierto;
	private Lista listaAbierta;
	private Tarea tareaAbierta;
	private Colaborador colaboradorAbierto;
	
	//COLORS
	public Color negro = new Color(0, 0, 0);
	public Color blanco = new Color(255, 255, 255);
	public Color rojo = new Color(255, 0, 0);
	public Color verde = new Color(117, 251, 76);
	public Color millos = new Color(0, 0, 255);
	public Color azulito = new Color(31, 165, 163);
	public Color rosa = new Color(243, 178, 177);
	public Color rosa2 = new Color(235, 116, 116);
	public Color cyan = new Color(117, 251, 253);
	public Color cyan2 = new Color(81, 174, 173);
	public Color gris = new Color(154, 154, 154);
	public Color gris2 = new Color(217, 217, 217);
	public Color morado = new Color(98, 20, 109);
	public Color morado2 = new Color(173, 16, 195);
	public Color morado3 = new Color(161, 114, 167);
	public Color aguacate = new Color(102, 181, 127);
	public Color petroleo = new Color(0, 151, 149);
	public Color petroleo2 = new Color(83, 181, 179);
	public Color limon = new Color(206, 220, 23);
	public Color limon2 = new Color(180, 200, 0);
	public Color limon3 = new Color(162, 168, 0);

	public void run() {
		
		//Abre: Cambio de diseño de botones generales
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
		//Cierra: Cambio de diseño de botones generales
		
		crearEjemplosPersona();
		
		//Inicia el GUI:
		new Login(this);//El this envía esta instancia del controlador a esa ventana.
		
	}
	// run

	// > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < < < //
	// > > > > > > > > > > > > > > > > > C R E A R < < < < < < < < < < < < < < < //
	// > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < < < //

	/**
	 * Metodos de crear objetos Tablero, Lista, Tarea y Persona. -crearPersona() se
	 * utiliza unicamente en el método crearTarea.
	 */
	public Tablero crearTablero(String nombreTablero, String nombreAdministrador) {
		Tablero tablero = new Tablero(nombreTablero, nombreAdministrador);
		listaDeTablerosGlobal.add(tablero);//TODO: Cambiar por tableros de persona.
		return tablero;
	}
	// crearTablero

	public Lista crearLista(String nombreLista) {
		Lista lista = new Lista(nombreLista);//Crea la lista
		tableroAbierto.getListaDeListas().add(lista);//Añade la lista al tablero abierto
		return lista;
	}
	// crearLista

	public void crearTarea() {
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
		objTarea.setListaDelegados(listaDelegados);
		mostrarPersonas(listaDePersonasGlobal);
		boolean disponible = false;
		boolean vacia = false;
		if (listaDePersonasGlobal.isEmpty()) {
			int indice = Integer.parseInt(Vista.pedirString("cuantos delegados tiene la tarea"));
			for (int i = 1; i <= indice; i++) {
				listaDelegados.add(seleccionarDelegado());
			}
		}else {
			String correoBusqueda = Vista.pedirString("el correo del delegado a asignar la tarea");
			for (Persona persona : listaDePersonasGlobal) {
				if (persona.getCorreo().equals(correoBusqueda)) {
					colaboradorAbierto= (Colaborador)persona;
					break;
				}
			}
			if(listaDeTareasGlobal.isEmpty()){
				vacia = true;
			}else{
				disponible = asignarTarea(colaboradorAbierto);
			}	
		}
		if(vacia || disponible){
			objTarea.getListaDelegados().add(colaboradorAbierto);
		}
		
		listaDeTareasGlobal.add(objTarea);
		Vista.mostrarMensaje("Tarea agregada correctamente.");
	}
	// crearTarea

	public Persona seleccionarDelegado() {
		boolean elegido=false;
		String nombreBusqueda=Vista.pedirString("el nombre del delegado de la tarea");
		String correoBusqueda= Vista.pedirString("el correo del delegado de la tarea");
		for (Persona persona : listaDePersonasGlobal) {
			if (persona.getNombre().equalsIgnoreCase(nombreBusqueda)
				 && persona.getCorreo().equalsIgnoreCase(correoBusqueda)) {
				elegido=true;
				return persona;
			}
			break;
		}
		if (!elegido) {
			Vista.mostrarMensaje("No se ha encontrado ninguna persona con ese nombre y correo");
			seleccionarDelegado();
		}
		return null;
	}
	//seleccionarDelegado
	
	public Persona crearPersona(String nombre, String correo, String rol, String contraseña) {

		if (rol.equalsIgnoreCase("colaborador")) {
			Colaborador objColaborador = new Colaborador(nombre, correo, rol, contraseña);
			return objColaborador;
		} else if (rol.equalsIgnoreCase("administrador")) {
			Administrador objAdministrador = new Administrador(nombre, correo, rol, contraseña);
			return objAdministrador;
		} else {
			Vista.mostrarMensaje("No es un rol valido.");
			Vista.mostrarMensaje("Por favor elige entre las opciones disponibles. Colaborador/Administrador");
			crearPersona(nombre, correo, rol, contraseña);
		}
		return null;
	}
	// crearPersona

	// > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < < < //
	// > > > > > > > > > > > > > > > E L I M I N A R < < < < < < < < < < < < < < //
	// > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < < < //

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

	public void eliminarLista() {
		mostrarLista();
		if (!tableroAbierto.getListaDeListas().isEmpty()) {
			boolean encontrado = false;
			String nombreBusqueda = Vista.pedirString("el nombre de la lista que desea eliminar");
			for (Lista lista : tableroAbierto.getListaDeListas()) {
				if (lista.getNombreLista().equalsIgnoreCase(nombreBusqueda)) {
					tableroAbierto.getListaDeListas().remove(lista);
					listaDeListasGlobal.remove(lista);
					Vista.mostrarMensaje("Lista eliminada correctamente.");
					encontrado = true;
					break;
				}
			}
			if (encontrado == false) {
				Vista.mostrarMensaje("La lista no fue encontrada, por favor intente de nuevo.");
				eliminarLista();
			}

		}
	}
	// eliminarLista

	public void eliminarTarea() {
		mostrarTarea();
		if (!listaAbierta.getListaDeTareas().isEmpty()) {
			int indiceBusqueda = Integer.parseInt(Vista.pedirString("el indice de la tarea que desea eliminar"));
			boolean encontrado = false;

			for (int i = 0; i < listaAbierta.getListaDeTareas().size(); i++) {
				if (indiceBusqueda == (i + 1)) {
					listaDeTareasGlobal.remove(i);
					Vista.mostrarMensaje("Tarea eliminada correctamente.");
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {
				Vista.mostrarMensaje("La tarea no fue encontrada, por favor intente de nuevo.");
				eliminarTarea();
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

	// > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < < < //
	// > > > > > > > > > > > > > > > > M O S T R A R < < < < < < < < < < < < < < //
	// > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < < < //

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

	public void mostrarLista() {

		if (listaDeListasGlobal.isEmpty()) {
			Vista.mostrarMensaje("No hay listas creadas para mostrar.");
		} else {
			for (Lista lista : listaDeListasGlobal) {
				Vista.mostrarMensaje(" -" + lista.toString());
			}
		}
	}
	// mostrarLista

	public void mostrarTarea() {

		if (listaDeTareasGlobal.isEmpty()) {
			Vista.mostrarMensaje("No hay tareas creadas para mostrar.");
		} else {
			for (int i = 0; i < listaDeTareasGlobal.size(); i++)
				Vista.mostrarMensaje("[" + (i + 1) + "] " + listaDeTareasGlobal.get(i).getDescripcion());
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

	// > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < < < //
	// > > > > > > > > > > > > > > > > > A B R I R < < < < < < < < < < < < < < < //
	// > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < < < //

	/**
	 * Metodos para abrir/seleccionar objetos Tablero, Lista, Tarea y Persona. -Creo
	 * que a los metodos de abrir clases se les puede quitar el if del is.empty,
	 * menos al de tablero.
	 */
	public String getNombreAdministradorAbierto() {
		return administradorAbierto.getNombre();
	}
	//abrirAdministrador
	
	public String getNombreTableroAbierto() {
		String nombreTablero = tableroAbierto.getNombreTablero();
		return nombreTablero;
	}
	// getNombreTableroAbierto
	
	public String getNombreAdministradorDeTableroAbierto() {
		String nombreAdministrador = tableroAbierto.getNombreAdministrador();
		return nombreAdministrador;
	}
	// getNombreTableroAbierto

	public String getNombreListaAbierta() {
			String nombreLista = listaAbierta.getNombreLista();
		return nombreLista;
	}
	// abrirLista

	public Tarea abrirTarea() {
		boolean encontrado = false;
		if (listaAbierta.getListaDeTareas().isEmpty()) {
			Vista.mostrarMensaje("No hay tareas creadas para abrir.");
			return null;
		} else {
			while (!encontrado) {
				mostrarTarea();
				int indice = Integer.parseInt(Vista.pedirString("el indice de la descripción de la tarea que desea abrir"));
				for (int i = 0; i < listaDeTareasGlobal.size(); i++) {
					if ((i + 1) == indice) {
						encontrado = true;
						Vista.mostrarMensaje("La tarea fue encontrada.");
						return listaAbierta.getListaDeTareas().get(i);
					}
				}
				if (!encontrado) {
					Vista.mostrarMensaje("La tarea no fue encontrada, por favor intente de nuevo");
				}
			}
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

	// > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < < < //
	// > > > > > > > > > > > > > > M O D I F I C A R < < < < < < < < < < < < < < //
	// > > > > > > > > > > > > > > > > > > > < < < < < < < < < < < < < < < < < < //

	public void modificarDescripcionTarea() {
		String nuevaDescripcion = Vista.pedirString("la nueva descripción de la tarea");
		tareaAbierta.setDescripcion(nuevaDescripcion);
		Vista.mostrarMensaje("Descripción modificada correctamente.");
	}
	// modificarDescripcionTarea

	public void modificarFechaTarea() {
		Vista.mostrarMensaje("la nueva fecha de vencimiento de la tarea.");
		int anio = Integer.parseInt(Vista.pedirString("el año de la fecha de vencimiento"));
		int mes = Integer.parseInt(Vista.pedirString("el mes de la fecha de vencimiento"));
		int dia = Integer.parseInt(Vista.pedirString("el dia de la fecha de vencimiento"));
		int hora = Integer.parseInt(Vista.pedirString("la hora de la fecha de vencimiento"));
		int min = Integer.parseInt(Vista.pedirString("los minutos de la fecha de vencimiento"));
		tareaAbierta.setFechaVencimiento(LocalDateTime.of(anio, mes, dia, hora, min));
	}
	// modificarFechaTarea

	public void modificarCasilla() {
		LocalDateTime tiempoAhora = LocalDateTime.now();
		if (objAdministrador.isWorkTime(tiempoAhora)) {
			Vista.mostrarMensaje("¿La tarea fue finalizada?");
			while (true) {
				String confirmacion = Vista.pedirString("s/n");
				if (confirmacion.equalsIgnoreCase("s")) {
					tareaAbierta.setCasilla(true);
					Vista.mostrarMensaje("La tarea fue marcada como finalizada");
				} else if (confirmacion.equalsIgnoreCase("n")) {
					tareaAbierta.setCasilla(false);
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

	public void modificarNombreLista() {
		String nuevoNombre = Vista.pedirString("el nuevo nombre de la lista");
		listaAbierta.setNombreLista(nuevoNombre);
	}
	// modificarNombreLista

	public void modificarNombreTablero() {
		String nuevoNombre = Vista.pedirString("el nuevo nombre del tablero");
		tableroAbierto.setNombreTablero(nuevoNombre);
	}
	// modificarNombreTablero

	public void crearEjemplosPersona() {
		
		listaDePersonasGlobal.add(new Administrador("Alejandra Durán", "alejaqt@gmail.com", "Administrador", "123"));
		listaDePersonasGlobal.add(new Administrador("Sharon Cruz", "sharina@gmail.com", "Administrador", "123"));
		listaDePersonasGlobal.add(new Administrador("Brian Vargas", "briscuit@gmail.com", "Administrador", "123"));
		listaDePersonasGlobal.add(new Administrador("Alexander Chacon", "alexito@gmail.com", "Administrador", "falcao<3"));
		listaDePersonasGlobal.add(new Administrador("admin", "admin", "admin", "admin"));
		
		listaDePersonasGlobal.add(new Colaborador("Juan Perez", "juan.perez@example.com", "Colaborador", "123"));
		listaDePersonasGlobal.add(new Colaborador("Pedro Lopez", "pedro.lopez@example.com", "Colaborador", "123"));
		listaDePersonasGlobal.add(new Colaborador("Maria Guzman", "maria.garcia@example.com", "Colaborador", "123"));
		
	}
	//crearEjemplosPersona
	
	public boolean asignarTarea(Persona persona) {//TODO: Crear lista de personas global
		if (persona.getRol().equalsIgnoreCase("Colaborador")) {
			if (persona.verificarDisponibilidad(recorrerTarea(persona))) {
				Vista.mostrarMensaje("El colaborador esta disponible para realizar la tarea");
				return true;
			}else {
				Vista.mostrarMensaje("El colaborador no esta disponible para realizar la tarea");
				return false;
			}
		}
		return true;
	}
	// asignarTarea
	
	public int recorrerTarea(Persona PersonaComparar) {
		int canTareas = 0;
		for (Tarea tarea : listaDeTareasGlobal) {
			ArrayList<Persona> listaDelegados = tarea.getListaDelegados();
			for (Persona delegado : listaDelegados) {
				if (delegado.getCorreo().equalsIgnoreCase(PersonaComparar.getCorreo())) {	
					canTareas++;
					break;  // Rompe el ciclo si ya se encontró la persona en los delegados.
				}
			}
		}
		return canTareas;
	} 
	// recorrerTarea
	
	public static String toCapitalCase(String text) {
	    if (text == null || text.isEmpty()) {
	        return text; // Retorna el texto original si es nulo o vacío
	    }

	    String[] words = text.trim().split("\\s+"); // Divide el texto por espacios
	    StringBuilder capitalizedText = new StringBuilder();

	    for (String word : words) {
	        if (word.length() > 0) {
	            capitalizedText.append(Character.toUpperCase(word.charAt(0))) // Primera letra en mayúscula
	                          .append(word.substring(1).toLowerCase())        // Resto en minúscula
	                          .append(" ");                                  // Añade un espacio
	        }
	    }

	    return capitalizedText.toString().trim(); // Elimina el último espacio
	}
	//toCapitalCase

	/*
	 * Verificar funcionalidad de este tablero porque esta heavy, toca crear metodos
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
	
	
	
	
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // ACTIONS- // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
	//LOGIN
	
	//Abre: actionBtnContinuarLogin
	public void actionBtnContinuarLogin() {
		
		//PARPADEO ROJO:
		//ESTE PARPADEO ES ESPECIAL NO COPIAR.
		JTextField txtCorreo = Login.getTxtLoginCorreo();
		JPasswordField pwd = Login.getPwdContraseña();
		
		String placeholderCorreo = Login.getMensajeIngresarCorreoLogin();
		String placeholderContraseña = Login.getMensajeIngresarContraseñaLogin();
		
		JButton btn = Login.getBtnLoginContinuar();
		Color colorDelBtn = morado;
		
		char [] contraseñaChar= pwd.getPassword();
		String contraseña= new String (contraseñaChar);
		String correoBusqueda= txtCorreo.getText();
		boolean validacion = verificarCredenciales(contraseña, correoBusqueda);
		
			
		if(txtCorreo.getText().equals(placeholderCorreo) 
			|| txtCorreo.getText().equals("")
			|| contraseña.equals(placeholderContraseña)
			|| contraseña.equals("")
			|| validacion == false){
			
			//Set Bordes
			Border bordeRojo = BorderFactory.createLineBorder(rojo, 2);
			Border bordeGris = BorderFactory.createLineBorder(gris, 2);
			
			//Primera vez Bordes y Colores
			txtCorreo.setBorder(bordeRojo);
			txtCorreo.setForeground(rojo);
			
			pwd.setBorder(bordeRojo);
			pwd.setForeground(rojo);
			
			btn.setBorder(bordeRojo);
			btn.setBackground(rojo);
			
			final int[] contador= {0};
			
			//Parpadeo
			Timer timer = new Timer(150, event -> { // Cambia cada 150 ms
				if (contador[0] < 6) { // Se repetirá 3 veces, 3 rojas y 3 azules = 6
					Border bordeActual = (contador[0] % 2 == 0) ? bordeRojo : bordeGris; //Op ternario
	                Color colorBtn = (contador[0] % 2 == 0) ? rojo : colorDelBtn; //Op ternario x2
	                Color colorTxt = (contador[0] % 2 == 0) ? rojo : gris ; //Op ternario x3
	                
			        txtCorreo.setBorder(bordeActual);
			        txtCorreo.setForeground(colorTxt);
			        
			        pwd.setBorder(bordeActual);
			        pwd.setForeground(colorTxt);
			        
			        btn.setBackground(colorBtn);
			        btn.revalidate();
			                
		          	contador[0]++;
	            } else {
	                ((Timer) event.getSource()).stop(); //Detiene el Timer
	            }
				
	            btn.setBorder(null);
	        });
				
			timer.start();
			
		} else {
			
			if (validacion) {
				
				Login.getFrameLogin().dispose();//Cierra el frame login
				new Principal(this);	
			
			//String nombreLista = toCapitalCase(txtField.getText());//Obtiene el texto y lo transfoma a Capital
			//listaAbierta = crearLista(nombreLista);//Envía el nombre al método crearLista
			
			
			}
			//if validacion
		}
		//if parpadeo
	}
	//Cierra: actionBtnContinuarLogin
	
	//Abre: actionBtnCrearCuentaLogin
	public void actionBtnCrearCuentaLogin() {
		Login.getCardLayout().show(Login.getContenedor(), "panelRegisterBody");
	}
	//Cierra: actionBtnCrearCuentaLogin
	
	//Abre: verificarCredenciales
	public boolean verificarCredenciales(String contraseña, String correoBusqueda) {
		for (Persona persona : listaDePersonasGlobal) {
			if (persona.getCorreo().equalsIgnoreCase(correoBusqueda) && persona.getContraseña().equals(contraseña)) {
				administradorAbierto=(Administrador) persona;
				return true;
			}
		}
		return false;
	}
	//Cierra: verificarCredenciales
	
	
	
	//REGISTER
	
	//Abre: actionBtnRegresarRegister
	public void actionBtnRegresarRegister() {
		Login.getCardLayout().show(Login.getContenedor(), "panelLoginBody");
	}
	//Cierra: actionBtnRegresarRegister
	
	//Abre: actionBtnRegisterCrearCuenta
	public void actionBtnRegisterCrearCuenta() {
		JTextField txtCorreo= Login.getTxtRegisterCorreo();
		JTextField txtNombre= Login.getTxtRegisterNombre();
		JPasswordField pwdReContraseña= Login.getPwdReContraseña();
		JPasswordField pwdReContraseñaDos= Login.getPwdReContraseñaDos();
		
		String placeholderCorreo = Login.getIngresarCorreoRegister();
		String placeholderNombre = Login.getIngresarNombreRegister();
		String  placeholderReContraseña = Login.getIngresarContraseñaRegister();
		String placeholderReContraseñaDos = Login.getIngresarReContraseñaRegister();	
		
		JButton btn= Login.getBtnRegisterCrearCuenta();
		Color colorDelBtn= morado;
		
		
		if (txtCorreo.getText().equals(placeholderCorreo)
			 || txtCorreo.getText().equals("")
			 || txtNombre.getText().equals(placeholderNombre)
			 || txtNombre.getText().equals("")
			 || pwdReContraseña.getPassword().equals(placeholderReContraseña)
			 || pwdReContraseña.getPassword().equals("")
			 || pwdReContraseñaDos.getPassword().equals(placeholderReContraseñaDos)
			 || pwdReContraseñaDos.getPassword().equals("")) {
			
				//Set Bordes
				Border bordeRojo = BorderFactory.createLineBorder(rojo, 2);
				Border bordeGris = BorderFactory.createLineBorder(gris, 2);
				
				//Primera vez Bordes y Colores
				txtCorreo.setBorder(bordeRojo);
				txtCorreo.setForeground(rojo);
				
				txtNombre.setBorder(bordeRojo);
				txtNombre.setForeground(rojo);
				
				pwdReContraseña.setBorder(bordeRojo);
				pwdReContraseña.setForeground(rojo);
				
				pwdReContraseñaDos.setBorder(bordeRojo);
				pwdReContraseñaDos.setForeground(rojo);
				
				btn.setBorder(bordeRojo);
				btn.setBackground(rojo);
				
				final int[] contador= {0};
				
				//Parpadeo
				Timer timer = new Timer(150, event -> { // Cambia cada 150 ms
					if (contador[0] < 6) { // Se repetirá 3 veces, 3 rojas y 3 azules = 6
						Border bordeActual = (contador[0] % 2 == 0) ? bordeRojo : bordeGris; //Op ternario
		                Color colorBtn = (contador[0] % 2 == 0) ? rojo : colorDelBtn; //Op ternario x2
		                Color colorTxt = (contador[0] % 2 == 0) ? rojo : gris ; //Op ternario x3
		                
				        txtCorreo.setBorder(bordeActual);
				        txtCorreo.setForeground(colorTxt);
				        
				        txtNombre.setBorder(bordeActual);
						txtNombre.setForeground(colorTxt);
						
						pwdReContraseña.setBorder(bordeActual);
						pwdReContraseña.setForeground(colorTxt);
						
						pwdReContraseñaDos.setBorder(bordeActual);
						pwdReContraseñaDos.setForeground(colorTxt);
						
				        
				        btn.setBackground(colorBtn);
				        btn.revalidate();
				                
			          	contador[0]++;
		            } else {
		                ((Timer) event.getSource()).stop(); //Detiene el Timer
		            }
					
		            btn.setBorder(null);
		        });
				
				timer.start();
				
		} else {
			String correo = txtCorreo.getText();
			String nombre = txtNombre.getText();
			char [] reContraseñaChar = pwdReContraseña.getPassword();
			String reContraseña = new String(reContraseñaChar);
			char [] reContraseñaDosChar = pwdReContraseñaDos.getPassword();
			String reContraseñaDos= new String(reContraseñaDosChar);
			if (reContraseña.equals(reContraseñaDos)) {
				listaDePersonasGlobal.add(crearPersona(nombre, correo, "administrador", reContraseña));
				Login.getCardLayout().show(Login.getContenedor(), "panelLoginBody");
			} else {
				
				//Set Bordes
				Border bordeRojo = BorderFactory.createLineBorder(rojo, 2);
				Border bordeGris = BorderFactory.createLineBorder(gris, 2);
				
				//Primera vez Bordes y Colores
				pwdReContraseña.setBorder(bordeRojo);
				pwdReContraseña.setForeground(rojo);
				
				pwdReContraseñaDos.setBorder(bordeRojo);
				pwdReContraseñaDos.setForeground(rojo);
				
				btn.setBorder(bordeRojo);
				btn.setBackground(rojo);
				
				final int[] contador= {0};
				
				//Parpadeo
				Timer timer = new Timer(150, event -> { // Cambia cada 150 ms
					if (contador[0] < 6) { // Se repetirá 3 veces, 3 rojas y 3 azules = 6
						Border bordeActual = (contador[0] % 2 == 0) ? bordeRojo : bordeGris; //Op ternario
		                Color colorBtn = (contador[0] % 2 == 0) ? rojo : colorDelBtn; //Op ternario x2
		                Color colorTxt = (contador[0] % 2 == 0) ? rojo : gris ; //Op ternario x3
						
						pwdReContraseña.setBorder(bordeActual);
						pwdReContraseña.setForeground(colorTxt);
						
						pwdReContraseñaDos.setBorder(bordeActual);
						pwdReContraseñaDos.setForeground(colorTxt);
						
				        
				        btn.setBackground(colorBtn);
				        btn.revalidate();
				                
			          	contador[0]++;
		            } else {
		                ((Timer) event.getSource()).stop(); //Detiene el Timer
		            }
					
		            btn.setBorder(null);
		        });
				
				timer.start();	
			}	
		}
		
	}
	//Abre: actionBtnRegisterCrearCuentaDos
	
	//VOLVER
	
	//Abre: actionVolverPrincipal
	public void actionVolverPrincipal() {
		 
		if(FrameTablero.getFrameTablero() == null) {
			//Literalmente que no haga nada
		} else if(FrameTablero.getFrameTablero().isActive()) {//Si está abierto
			FrameTablero.getFrameTablero().dispose();//Cierra el frame del tablero
		}
		
	    if(!Principal.getFramePrincipal().isActive()) {//Si no está abierto
	    	new Principal(this);//Crea nuevo, el this envía esta instancia del controlador a esa ventana.
	    }
	    
	}
	//Cierra: actionVolverPrincipal
	
	
	
	//CREAR TABLERO
	
	//Abre: actionBtnCrearTablero
	public void actionBtnCrearTablero() {
		Principal.emergenteCrearTablero();
	}
	//Cierra: actionBtnCrearTablero

	//Abre: actionEnterTxtFieldIngresarNombreEmergenteCrearTablero
	public void actionEnterTxtFieldIngresarNombreEmergenteCrearTablero() {
			
		//PARPADEO ROJO:
		//IMPORTANTE Coloca aquí tus componentes xd:
		JTextField txtField = Principal.getTxtFieldIngresarNombreEmergenteCrearTablero();
		JButton btn = Principal.getBtnCrearTableroEmergenteCrearTablero();
		String placeholder = Principal.getMensajeIngresarNombreTablero();
		Color colorDelBtn = morado2;
		int limiteTexto = 50;//Default: (50) Ajusta este valor si necesitas que los txtField tengan un tamaño pequeño para que no deforme los paneles.
		
		if(txtField.getText().equals(placeholder) 
			|| txtField.getText().equals("")
			|| txtField.getText().length() > limiteTexto){
				
			//Inicializo los bordes
			Border bordeRojo = BorderFactory.createLineBorder(rojo, 2);
			Border bordeGris = BorderFactory.createLineBorder(gris, 2);
				
			//Agrego los colores y bordes
			btn.setBackground(rojo);
			txtField.setForeground(rojo);
			txtField.setBorder(bordeRojo);
				
			//Contador para alternar bordes
			final int[] contador = {0};
			
			//Alternador de bordes (funciona casi como un ciclo)
			Timer timer = new Timer(150, event -> { // Cambia cada 150 ms
	            if (contador[0] < 6) { // Se repetirá 3 veces, 3 rojas y 3 azules = 6
	                Border bordeActual = (contador[0] % 2 == 0) ? bordeRojo : bordeGris; //Op ternario
	                Color colorBtn = (contador[0] % 2 == 0) ? rojo : colorDelBtn; //Op ternario x2
	                Color colorTxt = (contador[0] % 2 == 0) ? rojo : gris ; //Op ternario x3
	                txtField.setBorder(bordeActual);
	                txtField.setForeground(colorTxt);
	                btn.setBackground(colorBtn);
	                btn.revalidate();
	                
	                contador[0]++;
	            } else {
	                ((Timer) event.getSource()).stop(); //Detiene el Timer
	            }
	            btn.setBorder(null);
	        });
				
			timer.start();
		} else {
			String nombreTablero = toCapitalCase(Principal.getTxtFieldIngresarNombreEmergenteCrearTablero().getText()); // Obtiene el texto y lo transforma a CapitalCase
			String nombreAdministrador = administradorAbierto.getNombre();
		    tableroAbierto = crearTablero(nombreTablero, nombreAdministrador);//Crea el tablero lógico y lo guarda

		    Principal.getFramePrincipal().dispose();//Cierra el frame principal

		    new FrameTablero(this);//Crea nuevo
		    
		}//if CrearTablero
	}
	//Cierra: actionEnterTxtFieldIngresarNombreEmergenteCrearTablero

	//Abre: actionBtnCancelarEmergenteCrearTablero
	public void actionBtnCancelarEmergenteCrearTablero() {
	    Principal.getEmergenteCrearTablero().dispose();
	    Principal.setEmergenteCrearTablero(null);
	}
	//Cierra: actionBtnCancelarEmergenteCrearTablero
	
	
	
	//AGREGAR INVITADOS
	
	//Abre: actionBtnAgregarInvitados
	public void actionBtnAgregarInvitados() {
		Principal.emergenteAgregarInvitados();
	}
	//Cierra: actionBtnAgregarInvitados
	
	//Abre: actionEnterTxtFieldIngresarCorreoEmergenteAgregarInvitados
	//FIXME: Método sin implementar
	public Persona actionEnterTxtFieldIngresarCorreoEmergenteAgregarInvitados() {
			
			//PARPADEO ROJO:
			//IMPORTANTE Coloca aquí tus componentes xd:
			JTextField txtField = Principal.getTxtFieldIngresarCorreoEmergenteAgregarInvitados();
			JButton btn = Principal.getBtnAgregarInvitadoEmergenteAgregarInvitados();
			String placeholder = Principal.getMensajeIngresarCorreo();
			Color colorDelBtn = morado2;
			int limiteTexto = 50;//Default: (50) Ajusta este valor si necesitas que los txtField tengan un tamaño pequeño para que no deforme los paneles.
			
			if(txtField.getText().equals(placeholder) 
				|| txtField.getText().equals("")
				|| txtField.getText().length() > limiteTexto){
					
				//Inicializo los bordes
				Border bordeRojo = BorderFactory.createLineBorder(rojo, 2);
				Border bordeGris = BorderFactory.createLineBorder(gris, 2);
					
				//Agrego los colores y bordes
				btn.setBackground(rojo);
				txtField.setForeground(rojo);
				txtField.setBorder(bordeRojo);
					
				//Contador para alternar bordes
				final int[] contador = {0};
				
				//Alternador de bordes (funciona casi como un ciclo)
				Timer timer = new Timer(150, event -> { // Cambia cada 150 ms
		            if (contador[0] < 6) { // Se repetirá 3 veces, 3 rojas y 3 azules = 6
		                Border bordeActual = (contador[0] % 2 == 0) ? bordeRojo : bordeGris; //Op ternario
		                Color colorBtn = (contador[0] % 2 == 0) ? rojo : colorDelBtn; //Op ternario x2
		                Color colorTxt = (contador[0] % 2 == 0) ? rojo : gris ; //Op ternario x3
		                txtField.setBorder(bordeActual);
		                txtField.setForeground(colorTxt);
		                btn.setBackground(colorBtn);
		                btn.revalidate();
		                
		                contador[0]++;
		            } else {
		                ((Timer) event.getSource()).stop(); //Detiene el Timer
		            }
		            btn.setBorder(null);
		        });
					
				timer.start();
		} else {
			String correoInvitado = Principal.getTxtFieldIngresarCorreoEmergenteAgregarInvitados().getText();//Obtiene el texto
			
			for (Persona personita : listaDePersonasGlobal) {
				if(personita.getCorreo().equals(correoInvitado)) {
					actionBtnCancelarEmergenteAgregarInvitados();
					return personita;
				}
				
			}
		}//if crearTablero
		return null;
	}
	//Cierra: actionEnterTxtFieldIngresarCorreoEmergenteAgregarInvitados
	
	//Abre: actionBtnCancelarEmergenteAgregarInvitados
	public void actionBtnCancelarEmergenteAgregarInvitados() {
	    Principal.getEmergenteAgregarInvitados().dispose();
	    Principal.setEmergenteAgregarInvitados(null);
	}
	//Cierra: actionBtnCancelarEmergenteAgregarInvitados
	
	
	
	//CREAR LISTA
	
	//Abre: actionBtnCrearLista
	public void actionBtnCrearLista( ) {                                             
		FrameTablero.emergenteCrearLista();
	}
	//Cierra: actionBtnCrearLista
	
	//Abre: actionEnterTxtFieldIngresarNombreEmergenteCrearLista
	public void actionEnterTxtFieldIngresarNombreEmergenteCrearLista() {
		
		//PARPADEO ROJO:
		//IMPORTANTE Coloca aquí tus componentes xd:
		JTextField txtField = FrameTablero.getTxtFieldIngresarNombreEmergenteCrearLista();
		JButton btn = FrameTablero.getBtnCrearListaEmergenteCrearLista();
		String placeholder = FrameTablero.getMensajeIngresarNombreLista();
		Color colorDelBtn = morado2;
		int limiteTexto = 13;//Default: (50) Ajusta este valor si necesitas que los txtField tengan un tamaño pequeño para que no deforme los paneles.
		
		if(txtField.getText().equals(placeholder) 
			|| txtField.getText().equals("")
			|| txtField.getText().length() > limiteTexto){
				
			//Inicializo los bordes
			Border bordeRojo = BorderFactory.createLineBorder(rojo, 2);
			Border bordeGris = BorderFactory.createLineBorder(gris, 2);
				
			//Agrego los colores y bordes
			btn.setBackground(rojo);
			txtField.setForeground(rojo);
			txtField.setBorder(bordeRojo);
				
			//Contador para alternar bordes
			final int[] contador = {0};
			
			//Alternador de bordes (funciona casi como un ciclo)
			Timer timer = new Timer(150, event -> { // Cambia cada 150 ms
	            if (contador[0] < 6) { // Se repetirá 3 veces, 3 rojas y 3 azules = 6
	                Border bordeActual = (contador[0] % 2 == 0) ? bordeRojo : bordeGris; //Op ternario
	                Color colorBtn = (contador[0] % 2 == 0) ? rojo : colorDelBtn; //Op ternario x2
	                Color colorTxt = (contador[0] % 2 == 0) ? rojo : gris ; //Op ternario x3
	                txtField.setBorder(bordeActual);
	                txtField.setForeground(colorTxt);
	                btn.setBackground(colorBtn);
	                btn.revalidate();
	                
	                contador[0]++;
	            } else {
	                ((Timer) event.getSource()).stop(); //Detiene el Timer
	            }
	            btn.setBorder(null);
	        });
				
			timer.start();
		} else {
			
			String nombreLista = toCapitalCase(txtField.getText());//Obtiene el texto y lo transfoma a Capital
			listaAbierta = crearLista(nombreLista);//Envía el nombre al método crearLista
			
			FrameTablero.getEmergenteCrearLista().dispose();//Cierra el frame principal
			
			FrameTablero.panelLista();//Crea y añade el panelLista al panelTableroBody
			
		}//if crearLista
	}
	//Cierra: actionEnterTxtFieldIngresarNombreEmergenteCrearLista
	
	//Abre: actionBtnCancelarEmergenteCrearLista
	public void actionBtnCancelarEmergenteCrearLista() {
		FrameTablero.getEmergenteCrearLista().dispose();
	}
	//Cierra: actionBtnCancelarEmergenteCrearLista
	
	
	
	//EDITAR TABLERO
		
	//Abre: actionBtnEditarTablero
	public void actionLblEditarTablero() {                                             
		FrameTablero.emergenteEditarTablero();
	}
	//Cierra: actionBtnEditarTablero
		
	//Abre: txtFieldIngresarNombreEmergenteEditarTablero
	public void txtFieldIngresarNombreEmergenteEditarTablero() {
			
		//PARPADEO ROJO:
		//IMPORTANTE Coloca aquí tus componentes xd:
		JTextField txtField = FrameTablero.getTxtFieldIngresarNombreEmergenteEditarTablero();
		JButton btn = FrameTablero.getBtnGuardarEmergenteEditarTablero();
		String placeholder = FrameTablero.getMensajeEditarNombreTablero();
		Color colorDelBtn = limon;
		
		if(txtField.getText().equals(placeholder) 
			|| txtField.getText().equals("")){
				
			//Inicializo los bordes
			Border bordeRojo = BorderFactory.createLineBorder(rojo, 2);
			Border bordeGris = BorderFactory.createLineBorder(gris, 2);
				
			//Agrego los colores y bordes
			btn.setBackground(rojo);
			txtField.setForeground(rojo);
			txtField.setBorder(bordeRojo);
				
			//Contador para alternar bordes
			final int[] contador = {0};
			
			//Alternador de bordes (funciona casi como un ciclo)
			Timer timer = new Timer(150, event -> { // Cambia cada 150 ms
	            if (contador[0] < 6) { // Se repetirá 3 veces, 3 rojas y 3 azules = 6
	                Border bordeActual = (contador[0] % 2 == 0) ? bordeRojo : bordeGris; //Op ternario
	                Color colorBtn = (contador[0] % 2 == 0) ? rojo : colorDelBtn; //Op ternario x2
	                Color colorTxt = (contador[0] % 2 == 0) ? rojo : gris ; //Op ternario x3
	                txtField.setBorder(bordeActual);
	                txtField.setForeground(colorTxt);
	                btn.setBackground(colorBtn);
	                btn.revalidate();
	                
	                contador[0]++;
	            } else {
	                ((Timer) event.getSource()).stop(); //Detiene el Timer
	            }
	            btn.setBorder(null);
	        });
				
			timer.start();
		} else {
			//String nuevoNombreTablero = FrameTablero.getTxtFieldIngresarNombreEmergenteEditarTablero().getText();//Obtiene el texto
			//TODO: no existe método de editar tablero
		}//if editarTablero
	}
	//Cierra: txtFieldIngresarNombreEmergenteEditarTablero
		
	//Abre: actionBtnColaboradoresEmergenteEditarTablero
	public void actionBtnColaboradoresEmergenteEditarTablero() {
		FrameTablero.emergenteColaboradores();
	}
	//Cierra: actionBtnColaboradoresEmergenteEditarTablero
	
	//Abre: actionBtnEliminarEmergenteEditarTablero
	public void actionBtnEliminarEmergenteEditarTablero() {
		FrameTablero.emergenteEliminar();
	}
	//Cierra: actionBtnEliminarEmergenteEditarTablero
		
	//Abre: actionBtnCancelarEmergenteEditarTablero
	public void actionBtnCancelarEmergenteEditarTablero() {
		FrameTablero.getEmergenteEditarTablero().dispose();
	}
	//Cierra: actionBtnCancelarEmergenteEditarTablero
	
	//COLABORADORES TABLERO
		
	//Abre: txtFieldIngresarCorreoEmergenteColaboradores//FIXME: Parpadeo
	public void txtFieldIngresarCorreoEmergenteColaboradores() {
		
		String placeholder = FrameTablero.getMensajeCorreoColaboradores();
		
		if(FrameTablero.getTxtFieldIngresarCorreoEmergenteColaboradores().getText().equals(placeholder) 
				|| FrameTablero.getTxtFieldIngresarCorreoEmergenteColaboradores().getText().equals("")){
			//IMPORTANTE: Este if es el que hace parpadear de rojo xd, el else crea el tablero
			//Inicializo colores
			Color rojo = FrameTablero.getRojo();
			Color negro = FrameTablero.getNegro();
			Color limon = FrameTablero.getLimon();
				
			//Inicializo los bordes
			Border bordeRojo = BorderFactory.createLineBorder(rojo, 2);
			Border bordeNegro = BorderFactory.createLineBorder(negro, 1);
				
			//Agrego los colores y bordes
			FrameTablero.getBtnConfirmarEmergenteColaboradores().setBorder(bordeRojo);
			FrameTablero.getBtnConfirmarEmergenteColaboradores().setBackground(rojo);
			FrameTablero.getTxtFieldIngresarCorreoEmergenteColaboradores().setBorder(bordeRojo);
				
			//Contador para alternar bordes
			final int[] contador = {0};
			
			//Alternador de bordes (funciona casi como un ciclo)
			Timer timer = new Timer(150, event -> { // Cambia cada 150 ms
	            if (contador[0] < 6) { // Se repetirá 3 veces, 3 rojas y 3 azules = 6
	                Border bordeActual = (contador[0] % 2 == 0) ? bordeRojo : bordeNegro; //Op ternario
	                Color colorActual = (contador[0] % 2 == 0) ? rojo : limon; //Op ternario x2
	                FrameTablero.getTxtFieldIngresarCorreoEmergenteColaboradores().setBorder(bordeActual);
	                FrameTablero.getBtnConfirmarEmergenteColaboradores().setBorder(bordeActual);
	                FrameTablero.getBtnConfirmarEmergenteColaboradores().setBackground(colorActual);
	                
	                contador[0]++;
	            } else {
	                ((Timer) event.getSource()).stop(); //Detiene el Timer
	            }
	        });
			
			timer.start();
		} else {
			//String nuevoNombreTablero = FrameTablero.getBtnConfirmarEmergenteColaboradores().getText();//Obtiene el texto
			//TODO: no se que método va aca:)
		}//if crearLista
	}
	//Cierra: txtFieldIngresarNombreEmergenteEditarTablero
	
	//Abre: actionBtnCancelarEmergenteColaboradores
	public void actionBtnCancelarEmergenteColaboradores() {
		FrameTablero.getEmergenteColaboradores().dispose();
	}
	//Cierra: actionBtnCancelarEmergenteColaboradores
	
	//ELIMINAR TABLERO
		
	//Abre: actionBtnCancelarEmergenteEliminar
	public void actionBtnCancelarEmergenteEliminar() {
		FrameTablero.getEmergenteEliminar().dispose();
	}
	//Cierra: actionBtnCancelarEmergenteEliminar
	
	//CREAR TAREA
	
	//Abre: actionBtnNuevaTarea
	public void actionLblNuevaTarea() {
		FrameTablero.emergenteCrearTarea();
	}
	//Cierra: actionBtnNuevaTarea
	
	//Abre: actionBtnCancelarEmergenteCrearTarea
	public void actionBtnCancelarEmergenteCrearTarea() {
	    FrameTablero.getEmergenteCrearTarea().dispose();
	    FrameTablero.setEmergenteCrearTarea(null);
	}
	//Cierra: actionBtnCancelarEmergenteCrearTarea
	
	//EDITAR LISTA
	
	//Abre: actionBtnEditarLista
	public void actionLblEditarLista() {                                             
		FrameTablero.emergenteEditarLista();
	}
	//Cierra: actionBtnEditarLista
	
	//Abre: txtFieldIngresarNombreEmergenteEditarLista
		public void txtFieldIngresarNombreEmergenteEditarLista() {
				
			//PARPADEO ROJO:
			//IMPORTANTE Coloca aquí tus componentes xd:
			JTextField txtField = FrameTablero.getTxtFieldIngresarNombreEmergenteEditarLista();
			JButton btn = FrameTablero.getBtnGuardarEmergenteEditarLista();
			String placeholder = FrameTablero.getMensajeEditarNombreTablero();
			Color colorDelBtn = limon;
			
			if(txtField.getText().equals(placeholder) 
				|| txtField.getText().equals("")){
					
				//Inicializo los bordes
				Border bordeRojo = BorderFactory.createLineBorder(rojo, 2);
				Border bordeGris = BorderFactory.createLineBorder(gris, 2);
					
				//Agrego los colores y bordes
				btn.setBackground(rojo);
				txtField.setForeground(rojo);
				txtField.setBorder(bordeRojo);
					
				//Contador para alternar bordes
				final int[] contador = {0};
				
				//Alternador de bordes (funciona casi como un ciclo)
				Timer timer = new Timer(150, event -> { // Cambia cada 150 ms
		            if (contador[0] < 6) { // Se repetirá 3 veces, 3 rojas y 3 azules = 6
		                Border bordeActual = (contador[0] % 2 == 0) ? bordeRojo : bordeGris; //Op ternario
		                Color colorBtn = (contador[0] % 2 == 0) ? rojo : colorDelBtn; //Op ternario x2
		                Color colorTxt = (contador[0] % 2 == 0) ? rojo : gris ; //Op ternario x3
		                txtField.setBorder(bordeActual);
		                txtField.setForeground(colorTxt);
		                btn.setBackground(colorBtn);
		                btn.revalidate();
		                
		                contador[0]++;
		            } else {
		                ((Timer) event.getSource()).stop(); //Detiene el Timer
		            }
		            btn.setBorder(null);
		        });
					
				timer.start();
			} else {
				//String nuevoNombreLista = FrameTablero.getTxtFieldIngresarNombreEmergenteEditarLista().getText();//Obtiene el texto
				//TODO: no existe método de editar tablero
			}//if editarTablero
		}
		//Cierra: TxtFieldIngresarNombreEmergenteEditarLista
	
	//Abre: actionBtnEliminarListaEmergenteEditarLista
	public void actionBtnEliminarListaEmergenteEditarLista() {
		FrameTablero.emergenteEliminarLista();
	}
	//Cierra: actionBtnEliminarEmergenteEditarTablero
	
	//Abre: actionBtnCancelarEmergenteEditarLista
	public void actionBtnCancelarEmergenteEditarLista() {
		FrameTablero.getEmergenteEditarLista().dispose();
	}
	//Cierra: actionBtnCancelarEmergenteEditarLista
		
	//ELIMINAR LISTA
	
	//Abre: actionBtnCancelarEmergenteEliminarLista
	public void actionBtnCancelarEmergenteEliminarLista() {
		FrameTablero.getEmergenteEliminarLista().dispose();
	}
	//Cierra: actionBtnCancelarEmergenteEliminar
	
	//ELIMINAR TAREA
	
	//Abre: actionBtnCancelarEmergenteEliminarLista
	public void actionBtnCancelarEmergenteEliminarTarea() {
		FrameTablero.getEmergenteEliminarTarea().dispose();
	}
	//Cierra: actionBtnCancelarEmergenteEliminar
}	
//class
