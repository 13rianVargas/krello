package co.edu.konradlorenz.view.gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")//TODO: Revisar ese warning en el futuro
public class Ventana extends JFrame {
	

	//Confifuración base del primer menú
	public static int guiMenuPrincipal(){//Si te preguntas porque retorna int, no sé, solo me guié de "menuPrincipal" de la Vista, porque ese menú retorna una opción int, pero probablemente este método deba ser void ya que se interactua con botones y cajas de texto.
		JFrame menuPrincipal = new JFrame();
		
		menuPrincipal.setVisible(true);
		menuPrincipal.setBounds(100,100,1280,720);
		menuPrincipal.setTitle("KRELLO");
		
		int opcion = 0;
		return opcion;
	}
	
	//Supongo que se tienen que crear más en el futuro de la misma forma que el primero
	public int guiMenuTablero(){
		return 0;
	}
	
	public int guiMenuLista(){
		return 0;
	}
	
	public int guiMenuTarea(){
		return 0;
	}
		
}
