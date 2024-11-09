package co.edu.konradlorenz.view.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class Tablero extends JFrame{
	
	//FRAMES
		JFrame frameTablero = new JFrame();
		
		//PANELS
		//JPanel panelInvisible = new JPanel(); //PENDIENTE -> Este JPanel permite que el autofocus no sea el primer campo de texto. 
		JPanel panelTableroHead;
		JPanel panelTableroBody;
		JPanel panelTableroTitulo;
		JPanel panelTablero;
		
		//BUTTONS
		JButton btnCrearLista;
			
		//COLORS
		Color fondoFrame = Color.GRAY;//Fondo del JFrame
		Color fondoPanel = Color.LIGHT_GRAY;//Fondo de todos los JPanel
		
		//MOSTRAR DETALLES
		boolean detalles = true;//true -> mostrar / false -> ocultar
		
		public Tablero(){

			frameTablero.setDefaultCloseOperation(EXIT_ON_CLOSE); //Terminar la ejecución si se cierra la ventana
			frameTablero.setTitle("Krello - Tablero");//Título de la ventana
			frameTablero.setSize(1280, 720);//ancho, alto
			frameTablero.setMinimumSize(new Dimension(1280, 720));//Tamaño mínimo al que se puede ajustar
			frameTablero.setLocationRelativeTo(null); //Centra la ventana
			frameTablero.setLayout(new BorderLayout());//Hace el frame responsivo a los ajustes de tamaño
			frameTablero.setBackground(Color.CYAN);//Color de la barra de la ventana
			frameTablero.getContentPane().setBackground(fondoFrame);//Color del fondo

			panelTableroHead = panelTableroHead();
	    	//frameTablero.add(panelTableroHead);//Solo lo añade
			frameTablero.add(panelTableroHead, BorderLayout.NORTH);//Lo añade y hace el panel responsivo
		
	    	//panelTableroMiddle = panelTableroMiddle();
	    	//frameTablero.add(panelTableroMiddle);//Solo lo añade
	    	//frameTablero.add(panelTableroMiddle, BorderLayout.CENTER);//Lo añade y hace el panel responsivo
		      
			panelTableroBody = panelTableroBody();
			frameTablero.add(panelTableroBody, BorderLayout.CENTER);
			
			frameTablero.setVisible(true); //IMPORTANTE dejar esta línea de últimas al cerrar el constructor para que carguen las pinches imagenes (llevo 3 horas tratando de ver porque no salía la imagen y es por esta babosada T-T )
	    }
		
		//Método para crear panelTableroHead
		public JPanel panelTableroHead() {
	    	
			panelTableroHead = new JPanel();
			panelTableroHead.setBackground(Color.PINK);
			panelTableroHead.setOpaque(detalles);//Mostrar detalles
			panelTableroHead.setLayout(new BorderLayout(10, 0));//Espacio horizontal y vertical entre los componentes

	        	//LOGO KRELLO
		        JLabel lblKrelloLogo = new JLabel();
		        lblKrelloLogo.setIcon(new ImageIcon(getClass().getResource("/co/edu/konradlorenz/view/img/KrelloLogo187x60.png")));
		        lblKrelloLogo.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
		        lblKrelloLogo.setBackground(Color.GREEN);
		        lblKrelloLogo.setOpaque(detalles);//Mostrar detalles
		        
		        panelTableroHead.add(lblKrelloLogo, BorderLayout.WEST);//Ubica automáticamente a la izquierda
		        
		        //FRASE CENTRAL
		        JLabel lblHola = new JLabel("¡Hola ");
		        lblHola.setFont(new Font("Arial", Font.PLAIN, 22));

		        JLabel lblUser = new JLabel("Aquí va un nombre genérico, si tan solo tuvieramos uno T-T"); //TODO: Agregar nombre genérico xd
		        lblUser.setFont(new Font("Arial", Font.ITALIC, 22));
		        
		        JLabel lblAdmiracion = new JLabel("!");//IMPORTANTE, dirás, para que se separa en 3 lbl?, es para que solo el lblUser se muestre en Italic y quede guapo
		        lblAdmiracion.setFont(new Font("Arial", Font.PLAIN, 22));

		        JPanel lblHolaUser = new JPanel();//Sí, esto es un Panel anidado xd
		        lblHolaUser.setLayout(new BoxLayout(lblHolaUser, BoxLayout.X_AXIS));//El BoxLayout.X_AXIS es para que se ordenen Horizontalmente, cambia la X por la Y para que lo notes.
		        lblHolaUser.add(lblHola);
		        lblHolaUser.add(lblUser);
		        lblHolaUser.add(lblAdmiracion);
		        lblHolaUser.setForeground(Color.BLACK);//Color de la letra
		        lblHolaUser.setBorder(new EmptyBorder(30, 0, 30, 0)); // top, left, bottom, right -> Ajusta un borde por pixeles
		        lblHolaUser.setBackground(Color.BLUE);
		        lblHolaUser.setOpaque(detalles);//Mostrar detalles
		        
		        panelTableroHead.add(lblHolaUser, BorderLayout.CENTER);//Ubica automáticamente al centro
		        
	        	//"BOTÓN" CERRAR SESIÓN
		        JLabel lblCerrarSesion = new JLabel("Cerrar sesión");
		        lblCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 22));
		        lblCerrarSesion.setForeground(Color.BLACK);//Color de la letra
		        lblCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));//Cambia el cursor a una mano cuando pase por encima
		        lblCerrarSesion.setBackground(Color.CYAN);
		        lblCerrarSesion.setOpaque(detalles);//Mostrar detalles
		        
		        //Acción al pasar el mouse
		        lblCerrarSesion.addMouseListener(new MouseAdapter() {
		        	@Override
		            public void mouseEntered(MouseEvent e) {
		                lblCerrarSesion.setText("<html><u>Cerrar sesión</u></html>");//Lo subraya al poner el cursor encima
		            }
		            @Override
		            public void mouseExited(MouseEvent e) {
		                lblCerrarSesion.setText("Cerrar sesión");//Elimina el subrayado cuando el mouse sale
		            }
		            @Override
		        	public void mouseClicked(MouseEvent e) {
		                //TODO: Acción para volver a Ventana Iniciar Sesión
		            	
		            }
		        });
		        	
		        	//Este panel es para ajustar mejor el lblCerrarSesion y centrarlo
			        JPanel panelCerrarSesion = new JPanel();
			        panelCerrarSesion.setLayout(new BoxLayout(panelCerrarSesion, BoxLayout.Y_AXIS));//Se ordena verticalmente
			        panelCerrarSesion.setBackground(Color.RED);
			        panelCerrarSesion.setOpaque(detalles);//Mostrar detalles
			        panelCerrarSesion.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
		
			        panelCerrarSesion.add(Box.createVerticalGlue());//Agrega espacio flexible antes del JLabel
			        panelCerrarSesion.add(lblCerrarSesion);
			        panelCerrarSesion.add(Box.createVerticalGlue());//Agrega espacio flexible después del JLabel
		        
			        panelTableroHead.add(panelCerrarSesion, BorderLayout.EAST);//Ubica automáticamente a la derecha
	        //Posdata: Que heavy fue poner ese pinche botón de CerrarSesión T-T
		        
	    	return panelTableroHead;
	    }
	    
	    public JPanel panelTableroBody() {
	    	
	    	panelTableroBody = new JPanel();
	    	panelTableroBody.setLayout(new BorderLayout());
	    	panelTableroBody.setBackground(Color.WHITE);
	    	panelTableroBody.setBorder(new EmptyBorder(10,20,10,20));
	    	
	    	JLabel lblTituloTablero = new JLabel("Proyecto Final Técnicas II");//Nombre que esta en los MockUps
	    	lblTituloTablero.setFont(new Font("Arial", Font.BOLD, 24));
	    	lblTituloTablero.setForeground(Color.BLACK);
	    	
	    	panelTableroTitulo = new JPanel(new BorderLayout());
	    	panelTableroTitulo.setOpaque(false);
	    	panelTableroTitulo.add(lblTituloTablero, BorderLayout.WEST);
	    	
	    	//Boton para crear lista
	    	btnCrearLista = new JButton("Crear Lista");
	    	btnCrearLista.setBackground(new Color(102, 204, 255));
	    	btnCrearLista.setForeground(Color.WHITE);
	    	btnCrearLista.setFocusPainted(false);
	    	btnCrearLista.setFont(new Font("Arial", Font.PLAIN, 18));
	    	
	    	JPanel panelBoton = new JPanel();
	        panelBoton.setOpaque(false);
	        panelBoton.add(btnCrearLista);
	    	
	        panelTableroTitulo.add(panelBoton, BorderLayout.EAST);
	        panelTableroBody.add(panelTableroTitulo, BorderLayout.NORTH);
	        
	    	panelTablero = new JPanel();
	    	panelTablero.setBackground(fondoPanel);
	    	panelTableroBody.add(panelTablero, BorderLayout.CENTER);
	    	
	    	return panelTableroBody;
	    }
}
