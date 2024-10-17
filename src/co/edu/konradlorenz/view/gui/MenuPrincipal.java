package co.edu.konradlorenz.view.gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")//TODO: Revisar ese warning en el futuro
public class MenuPrincipal extends JFrame {
	
	//Constructor
	public MenuPrincipal(){
		JFrame mp = new JFrame();
		
		mp.setVisible(true);
		mp.setBounds(0,0,1280,720);
		mp.setLocationRelativeTo(null);//Centra la ventana
		mp.setTitle("KRELLO");
		mp.setDefaultCloseOperation(EXIT_ON_CLOSE);//Terminar la ejecución si se cierra la ventana

	}
	//guiMenuPrincipal
}
//class