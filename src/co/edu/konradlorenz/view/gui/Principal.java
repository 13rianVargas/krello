package co.edu.konradlorenz.view.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	//FRAMES
	JFrame framePrincipal = new JFrame();
	
	//PANELS
	//JPanel panelInvisible = new JPanel(); //PENDIENTE -> Este JPanel permite que el autofocus no sea el primer campo de texto. 
	JPanel panelPrincipalHead;
	JPanel panelPrincipalMiddle;
	JPanel panelPrincipalBody;
	
	//TEXTFIELDS
	
	
	//PASSWORDFIELDS
	
	
	//BUTTONS
	JButton btnCrearTablero;
	JButton btnAbrirTablero1;
	JButton btnAbrirTablero2;
	JButton btnAbrirTablero3;
		
	//COLORS
	Color fondoFrame = Color.GRAY;//Fondo del JFrame
	Color fondoPanel = Color.LIGHT_GRAY;//Fondo de todos los JPanel
	
    //Método constructor del frame Principal
    public Principal(){

    	framePrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE); //Terminar la ejecución si se cierra la ventana
    	framePrincipal.setTitle("Krello - Mis Tableros");//Título de la ventana
    	framePrincipal.setSize(1280, 720);//ancho, alto
    	framePrincipal.setLocationRelativeTo(null); //Centra la ventana
    	framePrincipal.setLayout(null);//Desactiva el control automático de paneles
    	framePrincipal.setResizable(false);//No permite modificar el tamaño de la ventana
    	framePrincipal.setBackground(Color.CYAN);//Color de la barra de la ventana
    	framePrincipal.getContentPane().setBackground(fondoFrame);//Color del fondo

    	panelPrincipalHead = panelPrincipalHead();
    	framePrincipal.add(panelPrincipalHead);
	
    	panelPrincipalMiddle = panelPrincipalMiddle();
    	framePrincipal.add(panelPrincipalMiddle);
	        
	        
    	framePrincipal.setVisible(true); //IMPORTANTE dejar esta línea de últimas al cerrar el constructor para que carguen las pinches imagenes (llevo 3 horas tratando de ver porque no salía la imagen y es por esta babosada T-T )
    }
    //Principal
    
    //Método para crear panelPrincipalHead
	public JPanel panelPrincipalHead() {
    	
        panelPrincipalHead = new JPanel();
        panelPrincipalHead.setBounds(40, 40, 1200, 80);
        panelPrincipalHead.setBackground(fondoPanel);
        //panelPrincipalHead.setLayout(new FlowLayout(FlowLayout.CENTER, 0, FlowLayout.CENTER));//Alinea en el centro vertical y horizontal
        panelPrincipalHead.setLayout(null);//Desactiva el control automático de paneles

	        JLabel lblKrelloLogo = new JLabel();
	        lblKrelloLogo.setIcon(new ImageIcon(getClass().getResource("/co/edu/konradlorenz/view/img/KrelloLogo187x60.png")));
	        lblKrelloLogo.setBounds(10, 10, 187, 60);
	        
        panelPrincipalHead.add(lblKrelloLogo);
	        
	        JLabel lblHola = new JLabel("¡Hola ");
	        lblHola.setFont(new Font("Arial", Font.PLAIN, 20));

	        JLabel lblUser = new JLabel("@@@@@"); //TODO: Aquí va el nombre del usuario en el futuro
	        lblUser.setFont(new Font("Arial", Font.ITALIC, 20));
	        
	        JLabel lblAdmiracion = new JLabel("!");//IMPORTANTE, dirás, para que se separa en 3 lbl?, es para que solo el lblUser se muestre en Italic y quede guapo
	        lblAdmiracion.setFont(new Font("Arial", Font.PLAIN, 20));

	        JPanel lblHolaUser = new JPanel();//Sí, esto es un Panel anidado xd
	        lblHolaUser.setLayout(new BoxLayout(lblHolaUser, BoxLayout.X_AXIS));//El BoxLayout.X_AXIS es para que se ordenen Horizontalmente, cambia la X por la Y para que lo notes.
	        lblHolaUser.add(lblHola);
	        lblHolaUser.add(lblUser);
	        lblHolaUser.add(lblAdmiracion);
	        lblHolaUser.setForeground(Color.BLACK);//Color de la letra
	        lblHolaUser.setBounds(207, 10, 400, 60);//x,y,ancho,alto
	        lblHolaUser.setOpaque(false);//false -> transparente
	     
        panelPrincipalHead.add(lblHolaUser);
	        
	        JLabel lblCerrarSesion = new JLabel("Cerrar sesión");
	        lblCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 20));
	        lblCerrarSesion.setForeground(Color.BLACK);//Color de la letra
	        lblCerrarSesion.setBounds(1050, 10, 120, 16);//x,y,ancho,alto
	        lblCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));//Cambia el cursor a una mano cuando pase por encima
	        
	        //Acción
	        lblCerrarSesion.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                //TODO: Acción para volver a Ventana Iniciar Sesión

	            	framePrincipal.dispose(); // Cierra Ventana Principal
	            }
	        });
	        
        panelPrincipalHead.add(lblCerrarSesion);
	        
    	return panelPrincipalHead;
    }
    //*/panelPrincipalHead
    
    //Método para crear panelPrincipalMiddle
    public JPanel panelPrincipalMiddle() {
    	
        panelPrincipalMiddle = new JPanel();
        panelPrincipalMiddle.setVisible(true);
        panelPrincipalMiddle.setBounds(40, 140, 1200, 80);
        panelPrincipalMiddle.setBackground(fondoPanel);
        
	        JLabel lblMisTableros = new JLabel("Mis Tableros");
	        lblMisTableros.setFont(new Font("Arial", Font.PLAIN, 30));
	        //misTableros.setLayout(new BoxLayout(misTableros, BoxLayout.X_AXIS));
	        lblMisTableros.setLayout(new BoxLayout(lblMisTableros, BoxLayout.Y_AXIS));
	        lblMisTableros.setBounds(0, 0, 1200, 80);
        
	        panelPrincipalMiddle.add(lblMisTableros);
	        
    	return panelPrincipalMiddle;
    }
    //*/panelPrincipalMiddle
    
    
}
//class