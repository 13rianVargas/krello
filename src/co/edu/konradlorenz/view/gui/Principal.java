package co.edu.konradlorenz.view.gui;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")//TODO: Revisar ese warning en el futuro
public class Principal extends JFrame {
	
	//Constructor
	public Principal(){
		JFrame principal = new JFrame();
		
		Color fondoPanel = Color.CYAN;
		
		principal.setVisible(true);
		principal.setBounds(0,0,1280,720);
		principal.setLocationRelativeTo(null);//Centra la ventana
		principal.setTitle("KRELLO");
		principal.setDefaultCloseOperation(EXIT_ON_CLOSE);//Terminar la ejecución si se cierra la ventana
		
		principal.setLayout(null);

		JPanel head = new JPanel();
		
		head.setVisible(true);
		head.setBounds(40,37,1210,60);
		head.setBackground(fondoPanel);
		
		principal.add(head);

	}
	//guiMenuPrincipal
}
//class