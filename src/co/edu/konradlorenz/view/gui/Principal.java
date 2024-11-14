package co.edu.konradlorenz.view.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

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
	Color fondoFrame = Color.WHITE;//Fondo del JFrame
	Color fondoPanel1 = Color.PINK;//Fondo de todos los JPanel1
	Color fondoPanel2 = Color.CYAN;//Fondo de todos los JPanel2
	Color btns = new Color(0, 151, 149);// con transparencia pero funciona raro (0, 151, 149, 89); -> Sin transparencia y mejor con setOpaque :v

	//MOSTRAR DETALLES
	boolean detalles = true;//true -> mostrar / false -> ocultar
	
    //Constructor del frame Principal
    public Principal(){

    	framePrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE); //Terminar la ejecución si se cierra la ventana
    	framePrincipal.setTitle("Krello - Mis Tableros");//Título de la ventana
    	framePrincipal.setSize(1280, 720);//ancho, alto
    	framePrincipal.setMinimumSize(new Dimension(1280, 720));//Tamaño mínimo al que se puede ajustar
    	framePrincipal.setLocationRelativeTo(null); //Centra la ventana
    	framePrincipal.setLayout(new BorderLayout());//Hace el frame responsivo a los ajustes de tamaño
    	framePrincipal.setBackground(Color.CYAN);//Color de la barra de la ventana
    	framePrincipal.getContentPane().setBackground(fondoFrame);//Color del fondo

    	panelPrincipalHead = panelPrincipalHead();
    	framePrincipal.add(panelPrincipalHead, BorderLayout.NORTH);//Lo añade y hace el panel responsivo
	
    	panelPrincipalMiddle = panelPrincipalMiddle();
    	framePrincipal.add(panelPrincipalMiddle, BorderLayout.CENTER);//Lo añade y hace el panel responsivo
    	
    	panelPrincipalBody = panelPrincipalBody();
    	framePrincipal.add(panelPrincipalBody, BorderLayout.SOUTH);//Lo añade y hace el panel responsivo
	        
    	framePrincipal.setVisible(true); //IMPORTANTE Siempre hacer dejar esto de últimas.
    }
    //*/Principal
    
    //Método para crear panelPrincipalHead
	public JPanel panelPrincipalHead() {
    	
        panelPrincipalHead = new JPanel();
        panelPrincipalHead.setBackground(fondoPanel1);
        panelPrincipalHead.setOpaque(detalles);//Mostrar detalles
        panelPrincipalHead.setLayout(new BorderLayout(10, 0));//Espacio horizontal y vertical entre los componentes

        	//LOGO KRELLO
	        JLabel lblKrelloLogo = new JLabel();
	        //No me esta sirviendo la img
	        lblKrelloLogo.setIcon(new ImageIcon(getClass().getResource("/co/edu/konradlorenz/view/img/KrelloLogo187x60.png")));
	        lblKrelloLogo.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
	        lblKrelloLogo.setBackground(Color.GREEN);
	        lblKrelloLogo.setOpaque(detalles);//Mostrar detalles
	        
        panelPrincipalHead.add(lblKrelloLogo, BorderLayout.WEST);//Ubica automáticamente a la izquierda
	        
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
	        
        panelPrincipalHead.add(lblHolaUser, BorderLayout.CENTER);//Ubica automáticamente al centro
	        
        	//"BOTÓN" (guiño guiño) CERRAR SESIÓN
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
	            	
	            	//Voy a usar este botoncito mientras para crear la emergente del nuevo tablero.
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
	        
        panelPrincipalHead.add(panelCerrarSesion, BorderLayout.EAST);//Ubica automáticamente a la derecha
        //Posdata: Que heavy fue poner ese pinche botón de CerrarSesión T-T
	        
    	return panelPrincipalHead;
    }
    //*/panelPrincipalHead
    
    //Método para crear panelPrincipalMiddle
    public JPanel panelPrincipalMiddle() {
    	
        panelPrincipalMiddle = new JPanel();       
        //panelPrincipalMiddle.setBounds(40, 140, 1200, 80);
        panelPrincipalMiddle.setBackground(fondoPanel2);
        panelPrincipalMiddle.setOpaque(detalles);//Mostrar detalles
        
	        JLabel lblMisTableros = new JLabel("Mis Tableros");
	        lblMisTableros.setFont(new Font("Arial", Font.PLAIN, 30));
	        //lblMisTableros.setLayout(new BoxLayout(lblMisTableros, BoxLayout.X_AXIS));
	        //lblMisTableros.setLayout(new BoxLayout(lblMisTableros, BoxLayout.Y_AXIS));
	        //lblMisTableros.setBounds(0, 0, 1280, 720);
	        //TODO: Al hacer la ventana completa o ajustar la ventana, se desproporciona.
	        // Guíate del panel "lblCerrarSesion" del head,
	        // fijate que "lblCerrarSesion" con fondo cyan está dentro de "panelCerrarSesion" de fondo rojo,
	        // eso con el fin de centrar el "lblCerrarSesion".
        
	        panelPrincipalMiddle.add(lblMisTableros);
	        
    	return panelPrincipalMiddle;
    }
    //*/panelPrincipalMiddle
    
    //Método para crear panelPrincipalBody
    public JPanel panelPrincipalBody() {
    	
        panelPrincipalBody = new JPanel();       
        panelPrincipalBody.setBackground(fondoPanel1);
        panelPrincipalBody.setOpaque(detalles);//Mostrar detalles

        panelPrincipalBody.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 150));  // Espacio entre los botones

        
        btnCrearTablero = new JButton("+");
        btnCrearTablero.setBackground(btns); 
        btnCrearTablero.setForeground(Color.WHITE);
    	btnCrearTablero.setFocusPainted(false);
    	btnCrearTablero.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
    	btnCrearTablero.setFont(new Font("Arial", Font.PLAIN, 80));
    	//3 lineas para macOS:
    	btnCrearTablero.setOpaque(true);
		Border border = BorderFactory.createLineBorder(btns, 2);
		btnCrearTablero.setBorder(border);
   
    	
        btnAbrirTablero1 = new JButton("Abrir Tablero 1");
        btnAbrirTablero1.setBackground(btns); 
        btnAbrirTablero1.setForeground(Color.WHITE); 
        btnAbrirTablero1.setFocusPainted(false);
        btnAbrirTablero1.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
        btnAbrirTablero1.setFont(new Font("Inter", Font.BOLD, 18));
        //3 lineas para macOS:
        btnAbrirTablero1.setOpaque(true);
		border = BorderFactory.createLineBorder(btns, 2);
		btnAbrirTablero1.setBorder(border);
        
        btnAbrirTablero2 = new JButton("Abrir Tablero 2");
        btnAbrirTablero2.setBackground(btns); 
        btnAbrirTablero2.setForeground(Color.WHITE); 
        btnAbrirTablero2.setFocusPainted(false);
        btnAbrirTablero2.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
        btnAbrirTablero2.setFont(new Font("Inter", Font.BOLD, 18));
        //3 lineas para macOS:
        btnAbrirTablero2.setOpaque(true);
		border = BorderFactory.createLineBorder(btns, 2);
		btnAbrirTablero2.setBorder(border);
        
        btnAbrirTablero3 = new JButton("Abrir Tablero 3");
        btnAbrirTablero3.setBackground(btns); 
        btnAbrirTablero3.setForeground(Color.WHITE);
        btnAbrirTablero3.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
        btnAbrirTablero3.setFont(new Font("Inter", Font.BOLD, 18));
        btnAbrirTablero3.setFocusPainted(false);
        //3 lineas para macOS:
        btnAbrirTablero3.setOpaque(true);
		border = BorderFactory.createLineBorder(btns, 2);
		btnAbrirTablero3.setBorder(border);

        
        Dimension buttonSize = new Dimension(200, 200);        
        btnCrearTablero.setPreferredSize(buttonSize);
        btnAbrirTablero1.setPreferredSize(buttonSize);
        btnAbrirTablero2.setPreferredSize(buttonSize);
        btnAbrirTablero3.setPreferredSize(buttonSize);


        panelPrincipalBody.add(btnCrearTablero);
        panelPrincipalBody.add(btnAbrirTablero1);
        panelPrincipalBody.add(btnAbrirTablero2);
        panelPrincipalBody.add(btnAbrirTablero3);


        
        return panelPrincipalBody;

    }
    //*/panelPrincipalBody
    
    
    
}
//class