package co.edu.konradlorenz.view.gui;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial") //TODO: Revisar ese warning en el futuro
public class Principal extends JFrame {

    //Constructor
    public Principal(){
    	
    	JFrame principal = new JFrame();

    	principal.setDefaultCloseOperation(EXIT_ON_CLOSE); //Terminar la ejecución si se cierra la ventana
    	principal.setTitle("KRELLO");
    	principal.setSize(1280, 720);
    	principal.setLocationRelativeTo(null); // Centra la ventana
    	principal.setLayout(null);

	        // - HEAD - //
	        JPanel head = new JPanel();
	        head.setBounds(40, 40, 1200, 70);
	        head.setBackground(Color.CYAN);
	        head.setLayout(new FlowLayout(FlowLayout.LEFT)); //Posiciona los componentes a la izquierda
	
		        // Imagen K
		        JLabel krelloLogo = new JLabel();
		        krelloLogo.setIcon(new ImageIcon(getClass().getResource("/co/edu/konradlorenz/view/img/KrelloLogo187x60.png")));
		        head.add(krelloLogo);
		        //*/
		
	        principal.add(head);
	
	        // - MIDDLE - //
	        JPanel middle = new JPanel();
	        middle.setVisible(true);
	        middle.setBounds(40, 120, 1200, 70);
	        middle.setBackground(Color.CYAN);
	        
	        principal.add(middle);
	        
	        // - BODY - //
	        
	        //TODO:Aquí te toca Aleja
	        
	        
	        
	        principal.setVisible(true); //IMPORTANTE dejar esta línea de últimas al cerrar el constructor para que carguen las pinches imagenes (llevo 3 horas tratando de ver porque no salía la imagen y es por esta babosada T-T )
    }
    //Principal
    
}
//class