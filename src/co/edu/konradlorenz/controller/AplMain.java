package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.view.gui.Ventana;

public class AplMain {

	public static void main(String[] args) {
		mostrarGUI();
		
		/*/ <- Quita el * entre las barras para descomentar la sección.
		Controlador objControlador = new Controlador();
		objControlador.run();
		//*/
	}
	
	// <- Agrega un * entre las barras para comentar el método.
	// Solo creo este método para hacer visible la GUI y no interferir en el controller aún.
	public static void mostrarGUI() {
		Ventana.guiMenuPrincipal();
	}
	//*/
}
