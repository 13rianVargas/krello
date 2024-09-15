package co.edu.konradlorenz.view;

import java.util.Scanner;
public class Vista {
	static Scanner sc = new Scanner(System.in);
	
	static public int pedirInt() {
		System.out.println("Ingrese la opción que desea: ");
		int opc = sc.nextInt();
		return opc;
	}
	
	static public String pedirString(String dato) {
		System.out.println("Por favor ingrese "+dato+": ");
		return sc.nextLine();
	}
	
	static public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	static public void menuPrincipal() {
		System.out.println();
		System.out.println("<> <> <> <> <> <> <> <> <> <> <>");
		System.out.println("<>       MENÚ PRINCIPAL       <>");
		System.out.println("<> [1] Crear tablero          <>");
		System.out.println("<> [2] Abrir tablero          <>");
		System.out.println("<> [3] Salir                  <>");
		System.out.println("<> <> <> <> <> <> <> <> <> <> <>");
	}
	
	static public void menuTablero() {
		System.out.println();
		System.out.println("<> <> <> <> <> <> <> <> <> <> <>");
		System.out.println("<>        MENÚ TABLERO        <>");
		System.out.println("<> [1] Agregar lista          <>");
		System.out.println("<> [2] Abrir lista            <>");
		System.out.println("<> [3] Eliminar lista         <>");
		System.out.println("<> [4] Vover                  <>");
		System.out.println("<> [5] Salir                  <>");
		System.out.println("<> <> <> <> <> <> <> <> <> <> <>");
	}
	
	static public void menuLista() {
		System.out.println();
		System.out.println("<> <> <> <> <> <> <> <> <> <> <>");
		System.out.println("<>         MENÚ LISTA         <>");
		System.out.println("<> [1] Agregar tarea          <>");
		System.out.println("<> [2] Abrir tarea            <>");
		System.out.println("<> [3] Eliminar tarea         <>");
		System.out.println("<> [4] Vover                  <>");
		System.out.println("<> [5] Salir                  <>");
		System.out.println("<> <> <> <> <> <> <> <> <> <> <>");
	}
	
	static public void menuTarea() {
		System.out.println();
		System.out.println("<> <> <> <> <> <> <> <> <> <> <>");
		System.out.println("<>         MENÚ TAREA         <>");
		System.out.println("<> [1] Modificar descripción  <>");
		System.out.println("<> [2] Modificar fecha        <>");
		System.out.println("<> [3] Modificar casilla      <>");
		System.out.println("<> [4] Mover tarea            <>");
		System.out.println("<> [5] Volver                 <>");
		System.out.println("<> [6] Salir                  <>");
		System.out.println("<> <> <> <> <> <> <> <> <> <> <>");
	}
}
