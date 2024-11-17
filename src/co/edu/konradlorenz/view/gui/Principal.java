package co.edu.konradlorenz.view.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import co.edu.konradlorenz.controller.*;

@SuppressWarnings("serial")
public class Principal extends JFrame {
	
	//CONTROLADOR
	private static Controlador ctrl;
	
	//MOSTRAR DETALLES
	private static boolean detalles;

	//FRAMES
	private static JFrame framePrincipal;
	
	//EMERGENTES
	private static JDialog emergenteCrearTablero;
	private static JDialog emergenteAgregarInvitados;
	
	//PANELS
	private static JPanel panelPrincipalHead;
	private static JPanel panelPrincipalMiddle;
	private static JPanel panelPrincipalBody;
	
	//TEXTFIELDS
	private static JTextField txtFieldIngresarNombreEmergenteCrearTablero;
	private static JTextField txtFieldIngresarCorreoEmergenteAgregarInvitados;
	
	//LABELS (Actuan como botón)
	private static JLabel lblKrelloLogo;
	private static JLabel lblCasaLogo;
	private static JLabel lblCerrarSesion;
	
	//BUTTONS
	private static JButton btnCrearTablero;
	private static JButton btnAbrirTablero1;
	private static JButton btnAbrirTablero2;
	private static JButton btnAbrirTablero3;
	private static JButton btnAgregarInvitados;
	private static JButton btnCancelarEmergenteCrearTablero;
	private static JButton btnCrearTableroEmergenteCrearTablero;
	private static JButton btnCancelarEmergenteAgregarInvitados;
	private static JButton btnAgregarInvitadoEmergenteAgregarInvitados;
		
	//COLORS
	private static Color negro = new Color(0, 0, 0);
	private static Color blanco = new Color(255, 255, 255);
	private static Color rojo = new Color(255, 0, 0);
	private static Color verde = new Color(117, 251, 76);
	private static Color millos = new Color(0, 0, 255);
	private static Color rosa = new Color(243, 178, 177);
	private static Color rosa2 = new Color(235, 116, 116);
	private static Color cyan = new Color(117, 251, 253);
	private static Color cyan2 = new Color(81, 174, 173);
	private static Color gris = new Color(154, 154, 154);
	private static Color gris2 = new Color(217, 217, 217);
	private static Color morado = new Color(98, 20, 109);
	private static Color morado2 = new Color(173, 16, 195);
	private static Color morado3 = new Color(161, 114, 167);
	private static Color aguacate = new Color(102, 181, 127);
	private static Color petroleo = new Color(0, 151, 149);
	private static Color petroleo2 = new Color(83, 181, 179);
	private static Color limon = new Color(206, 220, 23);
	private static Color limon2 = new Color(180, 200, 0);
	private static Color limon3 = new Color(162, 168, 0);

	//STRINGS
	private static String mensajeIngresarNombreTablero = " Ingrese nombre del tablero...";
	private static String mensajeIngresarCorreo = " Ingrese correo electrónico...";
	


	
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // VENTANAS // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
    //Abre: Constructor del frame Principal
    public Principal(Controlador controlador){

    	ctrl = controlador;//Llama al controller del AplMain
    	detalles = ctrl.detalles;//Ahora se cambia en el Controller para que actue en todo el GUI.
    	
    	framePrincipal = new JFrame();
    	framePrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE); //Terminar la ejecución si se cierra la ventana
    	framePrincipal.setTitle("Krello - Mis Tableros");//Título de la ventana
    	framePrincipal.setSize(1280, 720);//ancho, alto
    	framePrincipal.setMinimumSize(new Dimension(1280, 720));//Tamaño mínimo al que se puede ajustar
    	framePrincipal.setLocationRelativeTo(null); //Centra la ventana
    	framePrincipal.setLayout(new BorderLayout());//Diseño
    	framePrincipal.setBackground(blanco);//Color de la barra superior de la ventana
    	framePrincipal.getContentPane().setBackground(blanco);//Color del fondo del frame

    		panelPrincipalHead = panelPrincipalHead();//Crea el head
    	
		framePrincipal.add(panelPrincipalHead, BorderLayout.NORTH);//Lo añade y lo ubica arriba
    	
    		panelPrincipalBody = panelPrincipalBody();//Crea el body
    	
		framePrincipal.add(panelPrincipalBody, BorderLayout.CENTER);//Lo añade y lo ubica al centro
	        
    	framePrincipal.setVisible(true); //IMPORTANTE -> Siempre hacer dejar esto de últimas.
    }
    //Cierra: Constructor del frame Principal
    
    
    
    
    
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // PANELES  // -- // -- //
	// -- // -- // -- // -- // -- // -- //
    
    //Abre: Método para crear el panelPrincipalHead
	public static JPanel panelPrincipalHead() {
    	
        panelPrincipalHead = new JPanel();//Crea nuevo
        panelPrincipalHead.setBackground(rosa);//Color de fondo
        panelPrincipalHead.setOpaque(detalles);//Mostrar detalles
        panelPrincipalHead.setLayout(new BorderLayout(10, 0));//Diseño: (espacio horizontal),(espacio vertical)

	      //Abre: panelKrelloLogo
	    	JPanel panelKrelloLogo = new JPanel();//Crea nuevo
	    	panelKrelloLogo.setLayout(new BoxLayout(panelKrelloLogo, BoxLayout.X_AXIS));//Diseño: El BoxLayout.X_AXIS es para que se ubiquen HORIZONTALMENTE una al lado de la otra.
	    	panelKrelloLogo.setBorder(new EmptyBorder(30, 30, 30, 30));//top, left, bottom, right -> Ajusta un borde por pixeles
	    	panelKrelloLogo.setBackground(morado);//Color de fondo
	    	panelKrelloLogo.setOpaque(detalles);//Mostrar detalles
        
	        	//Abre: Imagen Krello
		        lblKrelloLogo = new JLabel();//Crea nuevo
		        lblKrelloLogo.setIcon(new ImageIcon(Principal.class.getResource("/co/edu/konradlorenz/view/img/KrelloLogo187x60.png")));//Ruta de la imagen
		        lblKrelloLogo.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        lblKrelloLogo.setBackground(verde);//Color de fondo
		        lblKrelloLogo.setOpaque(detalles);//Mostrar detalles
		        
			        //Abre: Acción de lblCerrarSesion
		        	lblKrelloLogo.addMouseListener(new MouseAdapter() {
			            @Override
			        	public void mouseClicked(MouseEvent e) {
			                ctrl.actionVolverPrincipal();
			            }
			        });
		        	//Cierra: Acción de lblCerrarSesion
		        	
		        //Cierra: Imagen Krello
	        
        	panelKrelloLogo.add(lblKrelloLogo);
	        //Cierra: panelKrelloLogo
        	
        panelPrincipalHead.add(panelKrelloLogo, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
	        
	        //Abre: panelHolaUser
        	JPanel panelHolaUser = new JPanel();//Crea nuevo
        	panelHolaUser.setLayout(new BoxLayout(panelHolaUser, BoxLayout.X_AXIS));//Diseño: El BoxLayout.X_AXIS es para que se ubiquen HORIZONTALMENTE una al lado de la otra.
        	panelHolaUser.setForeground(negro);//Color de letra
	        panelHolaUser.setBorder(new EmptyBorder(30, 0, 30, 0));//top, left, bottom, right -> Ajusta un borde por pixeles
	        panelHolaUser.setBackground(millos);//Color de fondo
	        panelHolaUser.setOpaque(detalles);//Mostrar detalles
        	
        	//Dirás... ¿para que se hacen 3 labels? Es para que solo el lblUser se muestre en Italic y los demás normal, así queda más bonito.
	        
	        	//Abrir: lblHola
	        	JLabel lblHola = new JLabel("¡ Hola ");//Crea nuevo
		        lblHola.setFont(new Font("Arial", Font.PLAIN, 22));//Cambia la letra del interior
		        lblHola.setBackground(limon);//Color de fondo
		        lblHola.setOpaque(detalles);//Mostrar detalles
	        	//Cerrar: lblHola
		        
	        panelHolaUser.add(lblHola);//Añade lblHola

        		//Abrir: lblUser
	        	String nombreUsuario = ctrl.getNombreAdministradorAbierto();
		        JLabel lblUser = new JLabel(nombreUsuario);//Crea nuevo //TODO: Agregar nombre genérico xd
		        lblUser.setFont(new Font("Arial", Font.ITALIC, 22));//Cambia la letra del interior
		        lblUser.setBackground(petroleo);//Color de fondo
		        lblUser.setOpaque(detalles);//Mostrar detalles
	        	//Cerrar: lblUser
		        
	        panelHolaUser.add(lblUser);//Añade lblUser
		        
        		//Abrir: lblAdmiracion
		        JLabel lblAdmiracion = new JLabel(" !");//Crea nuevo
		        lblAdmiracion.setFont(new Font("Arial", Font.PLAIN, 22));//Cambia la letra del interior
		        lblAdmiracion.setBackground(aguacate);//Color de fondo
		        lblAdmiracion.setOpaque(detalles);//Mostrar detalles
	        	//Cerrar: lblAdmiracion
		        
	        panelHolaUser.add(lblAdmiracion);//Añade lblAdmiracion
	        //Cierra: panelHolaUser
	        
        panelPrincipalHead.add(panelHolaUser, BorderLayout.CENTER);//Lo añade y lo ubica al centro
	        
	      	//Abre: panelCerrarSesion
	        JPanel panelCerrarSesion = new JPanel();//Crea nuevo
	        panelCerrarSesion.setLayout(new FlowLayout(FlowLayout.CENTER,30, 50));//Diseño: Flujo centrado (espacio horizontal),(espacio vertical)
	        panelCerrarSesion.setBackground(rojo);//Color de fondo
	        panelCerrarSesion.setOpaque(detalles);//Mostrar detalles
	        
		      	//Abre: Imagen Casa
		        lblCasaLogo = new JLabel();//Crea nuevo
		        lblCasaLogo.setIcon(new ImageIcon(Principal.class.getResource("/co/edu/konradlorenz/view/img/CasaLogo38x38.png")));//Ruta de la imagen
		        lblCasaLogo.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        lblCasaLogo.setBackground(verde);//Color de fondo
		        lblCasaLogo.setOpaque(detalles);//Mostrar detalles
		        lblCasaLogo.setToolTipText("Volver al Menú Principal");
		        
			      	//Abre: Acción de lblCerrarSesion
		        	lblCasaLogo.addMouseListener(new MouseAdapter() {
			            @Override
			        	public void mouseClicked(MouseEvent e) {
			            	ctrl.actionVolverPrincipal();
			            }
			        });
		        	//Cierra: Acción de lblCerrarSesion
		        
		        //Cierra: Imagen Casa
		        
	        panelCerrarSesion.add(lblCasaLogo);//Agrega lblCasaLogo
	        
	        	//Abre: lblCerrarSesion (Este lbl contiene una acción)
		        lblCerrarSesion = new JLabel("Cerrar sesión");//Crea nuevo
		        lblCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 22));//Cambia la letra del interior
		        lblCerrarSesion.setForeground(negro);//Color de letra
		        lblCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        lblCerrarSesion.setBackground(cyan);//Color de fondo
		        lblCerrarSesion.setOpaque(detalles);//Mostrar detalles
		        
		        	//Abre: Acción de lblCerrarSesion
		        	lblCerrarSesion.addMouseListener(new MouseAdapter() {
		        		@Override
		        		public void mouseEntered(MouseEvent e) {
		        			lblCerrarSesion.setText("<html><u>Cerrar sesión</u></html>");//Lo subraya al poner el cursor encima
		        		}
			            @Override
			            public void mouseExited(MouseEvent e) {
			                lblCerrarSesion.setText("Cerrar sesión");//Elimina el subrayado cuando el mouse no está encima
			            }
			            @Override
			        	public void mouseClicked(MouseEvent e) {
			                //TODO: Acción para volver al Login
			            }
			        });
		        	//Cierra: Acción de lblCerrarSesion
			        
	        	//Cierra: lblCerrarSesion
		        	
	        panelCerrarSesion.add(lblCerrarSesion);//Agrega lblCerrarSesion
		        
	        //Cierra: panelCerrarSesion
	        
        panelPrincipalHead.add(panelCerrarSesion, BorderLayout.EAST);//Lo añade y lo ubica a la derecha
	        
    	return panelPrincipalHead;
    }
	//Cierra: Método para crear el panelPrincipalHead
    
    //Abre: Método para crear el panelPrincipalBody
    public static JPanel panelPrincipalBody() {
    	
        panelPrincipalBody = new JPanel();//Crear nuevo    
        panelPrincipalBody.setBackground(rosa);//Color de fondo
        panelPrincipalBody.setOpaque(detalles);//Mostrar detalles
        panelPrincipalBody.setLayout(new BoxLayout(panelPrincipalBody, BoxLayout.Y_AXIS));

	      	//Abre: panelBotonesTableros
	    	JPanel panelMisTableros = new JPanel();//Crear nuevo
	    	panelMisTableros.setLayout(new BoxLayout(panelMisTableros, BoxLayout.X_AXIS));//Diseño: El BoxLayout.X_AXIS es para que se ubiquen HORIZONTALMENTE una al lado de la otra.
	    	panelMisTableros.setBorder(new EmptyBorder(10, 0, 10, 0));//top, left, bottom, right -> Ajusta un borde por pixeles
	    	panelMisTableros.setBackground(limon);//Color de fondo
	    	panelMisTableros.setOpaque(detalles);//Mostrar detalles
    	
	        	//Abre: lblMisTableros
		        JLabel lblMisTableros = new JLabel("MIS TABLEROS");//Crea nuevo
		        lblMisTableros.setFont(new Font("Inter", Font.PLAIN, 40));//Cambia la letra del interior
		        lblMisTableros.setBackground(limon);//Color de fondo
		        lblMisTableros.setOpaque(detalles);//Mostrar detalles
		    	//Cierra: lblMisTableros
		        
	        panelMisTableros.add(lblMisTableros);
        
        panelPrincipalBody.add(panelMisTableros, BorderLayout.NORTH);//Lo añade y lo ubica arriba
        
        	//Abre: panelBotonesTableros
        	JPanel panelBotonesTableros = new JPanel();//Crear nuevo
        	panelBotonesTableros.setLayout(new GridBagLayout());
        	panelBotonesTableros.setBackground(aguacate);//Color de fondo
        	panelBotonesTableros.setOpaque(detalles);//Mostrar detalles
        	
        	Dimension buttonSize = new Dimension(250, 250);//Establece variable de tamaño para los botones
        	
        	GridBagConstraints gbc = new GridBagConstraints();
        	gbc.gridy = 0; //Todos los botones estarán en la misma fila
        	gbc.insets = new Insets(30, 30, 30, 30); //Espaciado entre botones (arriba, izquierda, abajo, derecha)
        	gbc.anchor = GridBagConstraints.CENTER; //Centra los botones dentro de sus celdas
        	
		        //Abre: btnCrearTablero
		        btnCrearTablero = new JButton("+");//Crea nuevo
		        btnCrearTablero.setBackground(petroleo);//Color de fondo
		        btnCrearTablero.setForeground(blanco);//Color de letra
		    	btnCrearTablero.setFont(new Font("Arial", Font.PLAIN, 80));//Cambia la letra del interior
		    	btnCrearTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		    	btnCrearTablero.setPreferredSize(buttonSize);//Tamaño botón
		    	
					//Abre: Acción del btnCrearTablero
					btnCrearTablero.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.actionBtnCrearTablero();//Se llama el método del Controller que gestiona el evento.
			            }
			        });
					//Cierra: Acción del btnCrearTablero
					
				//Cierra: btnCrearTablero
			
			gbc.gridx = 0; // Primera columna
			panelBotonesTableros.add(btnCrearTablero, gbc);//Añade btnCrearTablero
					
				//Abre: btnAbrirTablero1
		        btnAbrirTablero1 = new JButton("Abrir Tablero 1");//Crea nuevo
		        btnAbrirTablero1.setBackground(petroleo);//Color de fondo
		        btnAbrirTablero1.setForeground(blanco);//Color de letra
		        btnAbrirTablero1.setFont(new Font("Inter", Font.BOLD, 18));//Cambia la letra del interior
				btnAbrirTablero1.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
				btnAbrirTablero1.setPreferredSize(buttonSize);//Tamaño botón
				
			      	//Abre: Acción del btnAbrirTablero1
		        	btnAbrirTablero1.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	//TODO:Crear método en el Controller
			            	//ctrl.actionBtnAbrirTablero1();//Se llama el método del Controller que gestiona el evento. 
			            }
			        });
					//Cierra: Acción del btnAbrirTablero1
		        
				//Cierra: btnAbrirTablero1
	        
        	gbc.gridx = 1; // Segunda columna
        	panelBotonesTableros.add(btnAbrirTablero1, gbc);//Añade btnAbrirTablero1
		        
				//Abre: btnAbrirTablero2
		        btnAbrirTablero2 = new JButton("Abrir Tablero 2");//Crea nuevo
		        btnAbrirTablero2.setBackground(petroleo);//Color de fondo
		        btnAbrirTablero2.setForeground(blanco);//Color de letra
		        btnAbrirTablero2.setFont(new Font("Inter", Font.BOLD, 18));//Cambia la letra del interior
		        btnAbrirTablero2.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        btnAbrirTablero2.setPreferredSize(buttonSize);//Tamaño botón
				
			      	//Abre: Acción del btnAbrirTablero2
					btnAbrirTablero2.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	//TODO:Crear método en el Controller
			            	//ctrl.actionBtnAbrirTablero2();//Se llama el método del Controller que gestiona el evento. 
			            }
			        });
					//Cierra: Acción del btnAbrirTablero2
		        	
				//Cierra: btnAbrirTablero2
	
			gbc.gridx = 2; // Tercera columna
			panelBotonesTableros.add(btnAbrirTablero2, gbc);//Añade btnAbrirTablero2
					
				//Abre: btnAbrirTablero3
		        btnAbrirTablero3 = new JButton("Abrir Tablero 3");//Crea nuevo
		        btnAbrirTablero3.setBackground(petroleo);//Color de fondo
		        btnAbrirTablero3.setForeground(blanco);//Color de letra
		        btnAbrirTablero3.setFont(new Font("Inter", Font.BOLD, 18));//Cambia la letra del interior
		        btnAbrirTablero3.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        btnAbrirTablero3.setPreferredSize(buttonSize);//Tamaño botón
		        
			      	//Abre: Acción del btnAbrirTablero3
					btnAbrirTablero3.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	//TODO:Crear método en el Controller
			            	//ctrl.actionBtnAbrirTablero3();//Se llama el método del Controller que gestiona el evento. 
			            }
			        });
					//Cierra: Acción del btnAbrirTablero3
				
				//Cierra: btnAbrirTablero3
			
			gbc.gridx = 3; // Cuarta columna
			panelBotonesTableros.add(btnAbrirTablero3, gbc);//Añade btnAbrirTablero3
        	//Cierra: panelBotonesTableros
			
		panelPrincipalBody.add(panelBotonesTableros, BorderLayout.CENTER);//Lo añade y lo ubica abajo

        return panelPrincipalBody;
    }
    //Cierra: Método para crear el panelPrincipalBody
    
    
    
    
    
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- //EMERGENTES// -- // -- //
	// -- // -- // -- // -- // -- // -- //
    
    //Abre: Método para crear emergenteCrearTablero
    public static void emergenteCrearTablero() {
    	
    	//JDialog hace que solo la emergente sea interactiva, las demás ventanas se bloquean.
    	emergenteCrearTablero = new JDialog(framePrincipal, "Crear Tablero", true);//Crea nuevo (Dueño), (Título), (Bloquea interacción mientras esté abierta)
        emergenteCrearTablero.setSize(600, 300);//Tamaño
        emergenteCrearTablero.setBackground(morado2);//Color de la barra superior
        emergenteCrearTablero.getContentPane().setBackground(blanco);//Color del fondo del frame
        emergenteCrearTablero.setResizable(false);//No permite modificar el tamaño de la ventana
        emergenteCrearTablero.setLocationRelativeTo(framePrincipal);//Se centra según el framePrincipal
        emergenteCrearTablero.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Se cierra al dar click en la X
        emergenteCrearTablero.setLayout(new BorderLayout());//Diseño
	        
        
	    	//Abre: panelTituloCrearTablero
	        JPanel panelTituloCrearTablero = new JPanel();//Crea nuevo
	        panelTituloCrearTablero.setLayout(new BoxLayout(panelTituloCrearTablero, BoxLayout.Y_AXIS));//Diseño: El BoxLayout.Y_AXIS es para que se ubiquen VERTICALMENTE una encima de la otra.
	        panelTituloCrearTablero.setBackground(morado);//Color de fondo
	        panelTituloCrearTablero.setOpaque(detalles);//Mostrar detalles
	        panelTituloCrearTablero.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));// top, left, bottom, right -> Ajusta un borde por pixeles
	        
	        	//Abre: lblTituloCrearTablero
		        JLabel lblTituloCrearTablero = new JLabel("Crear Tablero");//Crea nuevo
		        lblTituloCrearTablero.setFont(new Font("Inter", Font.BOLD, 40));//Cambia la letra del interior
		        lblTituloCrearTablero.setForeground(morado2);//Color de letra
		        lblTituloCrearTablero.setAlignmentX(Component.CENTER_ALIGNMENT);//Centra horizontalmente
		        lblTituloCrearTablero.setBackground(gris);//Color de fondo
		        lblTituloCrearTablero.setOpaque(detalles);//Mostrar detalles
		        //Cierra: lblTituloCrearTablero
	        
	        panelTituloCrearTablero.add(Box.createVerticalGlue());//Agrega espacio flexible antes del JLabel
	        panelTituloCrearTablero.add(lblTituloCrearTablero);//Añade lblTituloCrearTablero
	        panelTituloCrearTablero.add(Box.createVerticalGlue());//Agrega espacio flexible después del JLabel
	        //Cierra: panelTituloCrearTablero
	        
		    
        emergenteCrearTablero.add(panelTituloCrearTablero, BorderLayout.NORTH);//Lo añade y lo ubica a arriba
        
        
	        //Abre: panelIngresarNombreTablero
        	JPanel panelIngresarNombreTablero = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));//Diseño: Flujo Centrado (espacio horizontal),(espacio vertical)
	        panelIngresarNombreTablero.setBackground(millos);//Color de fondo
	        panelIngresarNombreTablero.setOpaque(detalles);//Mostrar detalles
	        
	        	//Abre: lblNombre
		        JLabel lblNombre = new JLabel("Nombre:");//Crea nuevo
		        lblNombre.setFont(new Font("Inter", Font.PLAIN, 25));//Cambia la letra del interior
	        	//Cierra: lblNombre
		        
	        panelIngresarNombreTablero.add(lblNombre);//Añade lblNombre
		        
	        	//Abre: txtFieldIngresarNombreEmergenteCrearTablero
		        txtFieldIngresarNombreEmergenteCrearTablero = new JTextField(mensajeIngresarNombreTablero);//Crea nuevo
		        txtFieldIngresarNombreEmergenteCrearTablero.setForeground(gris);//Color de letra
		        txtFieldIngresarNombreEmergenteCrearTablero.setPreferredSize(new Dimension(400, 40));
		        txtFieldIngresarNombreEmergenteCrearTablero.setFont(new Font("Inter", Font.PLAIN, 20));//Cambia la letra del interior
		        txtFieldIngresarNombreEmergenteCrearTablero.setBackground(gris2);//Color de fondo
		        txtFieldIngresarNombreEmergenteCrearTablero.setBorder(BorderFactory.createLineBorder(gris, 2));//Color del borde
		        txtFieldIngresarNombreEmergenteCrearTablero.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor modo escritura
		        
			        //Abre: Placeholder "mensaje previo"
			        txtFieldIngresarNombreEmergenteCrearTablero.addFocusListener(new FocusListener() {
			            @Override
			            public void focusGained(FocusEvent e) {
			                if (txtFieldIngresarNombreEmergenteCrearTablero.getText().equals(mensajeIngresarNombreTablero)) {
			                	txtFieldIngresarNombreEmergenteCrearTablero.setText("");//Cambia el contenido del txtField
			                	txtFieldIngresarNombreEmergenteCrearTablero.setForeground(negro);//Color de letra
			                }
			            }
			            @Override
			            public void focusLost(FocusEvent e) {
			                //Si el campo de texto está vacío al perder el foco, restaura el placeholder
			                if (txtFieldIngresarNombreEmergenteCrearTablero.getText().isEmpty()) {
			                	txtFieldIngresarNombreEmergenteCrearTablero.setText(mensajeIngresarNombreTablero);//Cambia el contenido del txtField
			                	txtFieldIngresarNombreEmergenteCrearTablero.setForeground(gris);//Color de letra
			                }
			            }
			        });
			        //Cierra: Placeholder "mensaje previo"
		        
			        //Abre: Acción del txtFieldIngresarNombreEmergenteCrearTablero
			        txtFieldIngresarNombreEmergenteCrearTablero.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.actionEnterTxtFieldIngresarNombreEmergenteCrearTablero();//Se llama el método del Controller que gestiona el evento.
			            }
			        });
			        //Cierra: Acción del txtFieldIngresarNombreEmergenteCrearTablero
		        
		        //Cierra: txtFieldIngresarNombreEmergenteCrearTablero
		        
	        panelIngresarNombreTablero.add(txtFieldIngresarNombreEmergenteCrearTablero);//Agrega txtFieldIngresarNombreEmergenteCrearTablero
	        
	        panelIngresarNombreTablero.add(Box.createVerticalStrut(10));//Espacio entre componentes (lbl y txtField)
	        panelIngresarNombreTablero.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));// top, left, bottom, right -> Ajusta un borde por pixeles
	        //Cierra: panelIngresarNombreTablero
	        
	        
        emergenteCrearTablero.add(panelIngresarNombreTablero, BorderLayout.CENTER);//Lo añade y lo ubica al centro
	        
        
	        //Abre: panelBotonesBasicos
	        JPanel panelBotonesBasicos = new JPanel(new BorderLayout());
	        panelBotonesBasicos.setBackground(cyan);//Color de fondo
	        panelBotonesBasicos.setOpaque(detalles);//Mostrar detalles
	        
	        	//Abre: btnCancelarEmergenteCrearTablero
		        btnCancelarEmergenteCrearTablero = new JButton("Cancelar");//Crea nuevo
		        btnCancelarEmergenteCrearTablero.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
		        btnCancelarEmergenteCrearTablero.setPreferredSize(new Dimension(200, 40));//Tamaño botón
		        btnCancelarEmergenteCrearTablero.setBackground(morado2);//Color de fondo
		        btnCancelarEmergenteCrearTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        
	    			//Abre: Acción del btnCancelarEmergenteCrearTablero
		    		btnCancelarEmergenteCrearTablero.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.actionBtnCancelarEmergenteCrearTablero();//Se llama el método del Controller que gestiona el evento.
			            }
			        });
	    			//Cierra: Acción del btnCancelarEmergenteCrearTablero
	    		
	        	//Cierra: btnCancelarEmergenteCrearTablero
	    		
    			//Abre: btnCrearTableroEmergenteCrearTablero	
		        btnCrearTableroEmergenteCrearTablero = new JButton("Crear Tablero");//Crear nuevo
		        btnCrearTableroEmergenteCrearTablero.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
		        btnCrearTableroEmergenteCrearTablero.setPreferredSize(new Dimension(200, 40));
		        btnCrearTableroEmergenteCrearTablero.setBackground(morado2);//Color de fondo
		        btnCrearTableroEmergenteCrearTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        
		        	//Abre: Acción del btnCrearTableroEmergenteCrearTablero
		    		btnCrearTableroEmergenteCrearTablero.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.actionEnterTxtFieldIngresarNombreEmergenteCrearTablero();//Se llama el método del Controller que gestiona el evento.
			            }
			        });
			        //Cierra: Acción del btnCrearTableroEmergenteCrearTablero
	    		
    			//Cierra: btnCrearTableroEmergenteCrearTablero
	    		
	        panelBotonesBasicos.add(btnCancelarEmergenteCrearTablero, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
	        panelBotonesBasicos.add(btnCrearTableroEmergenteCrearTablero, BorderLayout.EAST);//Lo añade y lo ubica a la derecha
	        panelBotonesBasicos.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));//top, left, bottom, right -> Ajusta un borde por pixeles
	        //Cierra: panelBotonesBasicos
	        
	        
        emergenteCrearTablero.add(panelBotonesBasicos, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
    	
        
        //Abre: Funcionalidad cambiar el foco automático al abrir la emergente
        txtFieldIngresarNombreEmergenteCrearTablero.setEnabled(false);
        Timer timer = new Timer(100, e -> {
            txtFieldIngresarNombreEmergenteCrearTablero.setEnabled(true);
        });//Temporizador
        timer.setRepeats(false);//Evita que el temporizador se repita
        timer.start();//Inicia el temporizador
        //Cierra: Funcionalidad cambiar el foco automático al abrir la emergente
        
        
        emergenteCrearTablero.setVisible(true);//Hace visible la emergente
	    	
    }
    //Cierra: Método para crear emergenteCrearTablero
    
    //Abre: Método para crear emergenteAgregarInvitados
    public static void emergenteAgregarInvitados() {
    	
    	//JDialog hace que solo la emergente sea interactiva, las demás ventanas se bloquean.
    	emergenteAgregarInvitados = new JDialog(framePrincipal, "Agregar Invitados", true);//Crea nuevo (Dueño), (Título), (Bloquea interacción mientras esté abierta)
    	emergenteAgregarInvitados.setSize(600, 300);//Tamaño
    	emergenteAgregarInvitados.setBackground(blanco);//Color de fondo
        emergenteAgregarInvitados.setResizable(false);//No permite modificar el tamaño de la ventana
        emergenteAgregarInvitados.setLocationRelativeTo(framePrincipal);//Se centra según el framePrincipal
        emergenteAgregarInvitados.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Se cierra al dar click en la X
        emergenteAgregarInvitados.setLayout(new BorderLayout());//Diseño

        
	      	//Abre: panelTituloInvitados
	        JPanel panelTituloInvitados = new JPanel();
	        panelTituloInvitados.setLayout(new BoxLayout(panelTituloInvitados, BoxLayout.Y_AXIS));//Se ordena verticalmente
	        panelTituloInvitados.setBackground(morado);//Color de fondo
	        panelTituloInvitados.setOpaque(detalles);//Mostrar detalles
	        panelTituloInvitados.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));// top, left, bottom, right -> Ajusta un borde por pixeles
	        
		        //Abre: lblTituloInvitados
		        JLabel lblTituloInvitados = new JLabel("Agregar Invitados");//Crea nuevo
		        lblTituloInvitados.setFont(new Font("Arial", Font.BOLD, 40));//Cambia la letra del interior
		        lblTituloInvitados.setForeground(limon2);//Color de letra
		        lblTituloInvitados.setAlignmentX(Component.CENTER_ALIGNMENT);//Centra horizontalmente
		        lblTituloInvitados.setBackground(gris);//Color de fondo
		        lblTituloInvitados.setOpaque(detalles);//Mostrar detalles
		        //Cierra: lblTituloInvitados

	        panelTituloInvitados.add(Box.createVerticalGlue());//Agrega espacio flexible antes del JLabel
	        panelTituloInvitados.add(lblTituloInvitados);//Agrega lblTituloInvitados
	        panelTituloInvitados.add(Box.createVerticalGlue());//Agrega espacio flexible después del JLabel
	      	//Cierra: panelTituloInvitados
        
	        
	    emergenteAgregarInvitados.add(panelTituloInvitados, BorderLayout.NORTH);//Lo añade y lo ubica arriba
        
	    
		    //Abre: panelIngresarCorreo
	    	JPanel panelIngresarCorreo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));//Diseño: Flujo Centrado (espacio horizontal),(espacio vertical)
	    	panelIngresarCorreo.setBackground(millos);//Color de fondo
	    	panelIngresarCorreo.setOpaque(detalles);//Mostrar detalles
	    	
	    		//Abre: txtFieldIngresarCorreoEmergenteAgregarInvitados
	    		txtFieldIngresarCorreoEmergenteAgregarInvitados = new JTextField(mensajeIngresarCorreo);//Crea nuevo
		    	txtFieldIngresarCorreoEmergenteAgregarInvitados.setForeground(gris);//Color de letra
		    	txtFieldIngresarCorreoEmergenteAgregarInvitados.setPreferredSize(new Dimension(400, 30));//Tamaño
		    	txtFieldIngresarCorreoEmergenteAgregarInvitados.setFont(new Font("Arial", Font.PLAIN, 20));//Cambia la letra del interior
		        txtFieldIngresarCorreoEmergenteAgregarInvitados.setBackground(gris2);//Color de fondo
		        txtFieldIngresarCorreoEmergenteAgregarInvitados.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor modo escritura
		        
			        //Abre: Placeholder "mensaje previo"
		        	txtFieldIngresarCorreoEmergenteAgregarInvitados.addFocusListener(new FocusListener() {
			            @Override
			            public void focusGained(FocusEvent e) {
			                if (txtFieldIngresarCorreoEmergenteAgregarInvitados.getText().equals(mensajeIngresarCorreo)) {
			                	txtFieldIngresarCorreoEmergenteAgregarInvitados.setText("");//Cambia el contenido del txtField
			                	txtFieldIngresarCorreoEmergenteAgregarInvitados.setForeground(negro);//Color de letra
			                }
			            }
			            @Override
			            public void focusLost(FocusEvent e) {
			                //Si el campo de texto está vacío al perder el foco, restaura el placeholder
			                if (txtFieldIngresarCorreoEmergenteAgregarInvitados.getText().isEmpty()) {
			                	txtFieldIngresarCorreoEmergenteAgregarInvitados.setText(mensajeIngresarCorreo);//Cambia el contenido del txtField
			                	txtFieldIngresarCorreoEmergenteAgregarInvitados.setForeground(gris);//Color de letra
			                }
			            }
			        });
			        //Cierra: Placeholder "mensaje previo"
		        
			    	//Abre: Acción del txtFieldIngresarCorreoEmergenteAgregarInvitados
		        	txtFieldIngresarCorreoEmergenteAgregarInvitados.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.actionEnterTxtFieldIngresarCorreoEmergenteAgregarInvitados();//Se llama el método del Controller que gestiona el evento.
			            }
			        });
			    	//Cierra: Acción del txtFieldIngresarCorreoEmergenteAgregarInvitados
	        
	    		//Cierra: txtFieldIngresarCorreoEmergenteAgregarInvitados
			        
	        panelIngresarCorreo.add(Box.createVerticalGlue());//Agrega espacio flexible antes
	        panelIngresarCorreo.add(txtFieldIngresarCorreoEmergenteAgregarInvitados);//Añade txtFieldIngresarCorreoEmergenteAgregarInvitados
	        panelIngresarCorreo.add(Box.createVerticalGlue());//Agrega espacio flexible después
	        panelIngresarCorreo.setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0));// top, left, bottom, right -> Ajusta un borde por pixeles
		    //Cierra: panelIngresarCorreo
        
	        
	    emergenteAgregarInvitados.add(panelIngresarCorreo, BorderLayout.CENTER);//Lo añade y lo ubica al centro
	    
	    
		    //Abre: panelBotonesBasicos
	        JPanel panelBotonesBasicos = new JPanel();//Crea nuevo
	        panelBotonesBasicos.setLayout(new BorderLayout());//Diseño
	        panelBotonesBasicos.setBackground(cyan);//Color de fondo
	        panelBotonesBasicos.setOpaque(detalles);//Mostrar detalles
	        
	        	//Abre: btnCancelarEmergenteAgregarInvitados
		        btnCancelarEmergenteAgregarInvitados = new JButton("Cancelar");//Crea nuevo
		        btnCancelarEmergenteAgregarInvitados.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
		        btnCancelarEmergenteAgregarInvitados.setPreferredSize(new Dimension(200, 40));//Tamaño
		        btnCancelarEmergenteAgregarInvitados.setBackground(limon);//Color de fondo
		        btnCancelarEmergenteAgregarInvitados.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        
		        	//Abre: Acción del btnCancelarEmergenteAgregarInvitados
			        btnCancelarEmergenteAgregarInvitados.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.actionBtnCancelarEmergenteAgregarInvitados();//Se llama el método del Controller que gestiona el evento.
			            }
			        });
		        	//Cierra: Acción del btnCancelarEmergenteAgregarInvitados
			        
	        	//Cierra: btnCancelarEmergenteAgregarInvitados
		        
			    //Abre: btnAgregarInvitadoEmergenteAgregarInvitados
		        btnAgregarInvitadoEmergenteAgregarInvitados = new JButton("Agregar Invitado");//Crea nuevo
		        btnAgregarInvitadoEmergenteAgregarInvitados.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
		        btnAgregarInvitadoEmergenteAgregarInvitados.setPreferredSize(new Dimension(200, 40));//Tamaño
		        btnAgregarInvitadoEmergenteAgregarInvitados.setBackground(limon);//Color de fondo
		        btnAgregarInvitadoEmergenteAgregarInvitados.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        
		        	//Abre: Acción del btnAgregarInvitadoEmergenteAgregarInvitados
		        	btnAgregarInvitadoEmergenteAgregarInvitados.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			                //IMPORTANTE -> Aquí se llama a un método que maneja el evento desde el Controller.
			            	ctrl.actionEnterTxtFieldIngresarCorreoEmergenteAgregarInvitados();
			            }
			        });
		        	//Cierra: Acción del btnAgregarInvitadoEmergenteAgregarInvitados
		        
		        //Cierra: btnAgregarInvitadoEmergenteAgregarInvitados
			        
	        panelBotonesBasicos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));// top, left, bottom, right -> Ajusta un borde por pixeles
	        panelBotonesBasicos.add(btnCancelarEmergenteAgregarInvitados, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
	        panelBotonesBasicos.add(btnAgregarInvitadoEmergenteAgregarInvitados, BorderLayout.EAST);//Lo añade y lo ubica a la derecha
		    //Cierra: panelBotonesBasicos
	        
        emergenteAgregarInvitados.add(panelBotonesBasicos, BorderLayout.SOUTH);//Lo añade y lo ubica abajo

        //Abre: Funcionalidad cambiar el foco automático al abrir la emergente
        txtFieldIngresarCorreoEmergenteAgregarInvitados.setEnabled(false);
        Timer timer = new Timer(100, e -> {
        	txtFieldIngresarCorreoEmergenteAgregarInvitados.setEnabled(true);
        });//Temporizador
        timer.setRepeats(false);//Evita que el temporizador se repita
        timer.start();//Inicia el temporizador
        //Cierra: Funcionalidad cambiar el foco automático al abrir la emergente
        
	    
        emergenteAgregarInvitados.setVisible(true);
        
    }
    //Cierra: Método para crear emergenteAgregarInvitados





	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // GET & SET// -- // -- //
	// -- // -- // -- // -- // -- // -- //
    
    public static Controlador getCtrl() {
    	return ctrl;
    }
    
    public static void setCtrl(Controlador ctrl) {
    	Principal.ctrl = ctrl;
    }
    
    public static boolean isDetalles() {
    	return detalles;
    }
    
    public static void setDetalles(boolean detalles) {
    	Principal.detalles = detalles;
    }
    
    public static JFrame getFramePrincipal() {
    	return framePrincipal;
    }
    
    public static void setFramePrincipal(JFrame framePrincipal) {
    	Principal.framePrincipal = framePrincipal;
    }
    
    public static JDialog getEmergenteCrearTablero() {
    	return emergenteCrearTablero;
    }
    
    public static void setEmergenteCrearTablero(JDialog emergenteCrearTablero) {
    	Principal.emergenteCrearTablero = emergenteCrearTablero;
    }
    
    public static JDialog getEmergenteAgregarInvitados() {
    	return emergenteAgregarInvitados;
    }
    
    public static void setEmergenteAgregarInvitados(JDialog emergenteAgregarInvitados) {
    	Principal.emergenteAgregarInvitados = emergenteAgregarInvitados;
    }
    
    public static JPanel getPanelPrincipalHead() {
    	return panelPrincipalHead;
    }
    
    public static void setPanelPrincipalHead(JPanel panelPrincipalHead) {
    	Principal.panelPrincipalHead = panelPrincipalHead;
    }
    
    public static JPanel getPanelPrincipalMiddle() {
    	return panelPrincipalMiddle;
    }
    
    public static void setPanelPrincipalMiddle(JPanel panelPrincipalMiddle) {
    	Principal.panelPrincipalMiddle = panelPrincipalMiddle;
    }
    
    public static JPanel getPanelPrincipalBody() {
    	return panelPrincipalBody;
    }
    
    public static void setPanelPrincipalBody(JPanel panelPrincipalBody) {
    	Principal.panelPrincipalBody = panelPrincipalBody;
    }
    
    public static JTextField getTxtFieldIngresarNombreEmergenteCrearTablero() {
    	return txtFieldIngresarNombreEmergenteCrearTablero;
    }
    
    public static void setTxtFieldIngresarNombreEmergenteCrearTablero(
    		JTextField txtFieldIngresarNombreEmergenteCrearTablero) {
    	Principal.txtFieldIngresarNombreEmergenteCrearTablero = txtFieldIngresarNombreEmergenteCrearTablero;
    }
    
    public static JTextField getTxtFieldIngresarCorreoEmergenteAgregarInvitados() {
    	return txtFieldIngresarCorreoEmergenteAgregarInvitados;
    }
    
    public static void setTxtFieldIngresarCorreoEmergenteAgregarInvitados(
    		JTextField txtFieldIngresarCorreoEmergenteAgregarInvitados) {
    	Principal.txtFieldIngresarCorreoEmergenteAgregarInvitados = txtFieldIngresarCorreoEmergenteAgregarInvitados;
    }
    
    public static JLabel getLblKrelloLogo() {
    	return lblKrelloLogo;
    }
    
    public static void setLblKrelloLogo(JLabel lblKrelloLogo) {
    	Principal.lblKrelloLogo = lblKrelloLogo;
    }
    
    public static JLabel getLblCasaLogo() {
    	return lblCasaLogo;
    }
    
    public static void setLblCasaLogo(JLabel lblCasaLogo) {
    	Principal.lblCasaLogo = lblCasaLogo;
    }
    
    public static JLabel getLblCerrarSesion() {
    	return lblCerrarSesion;
    }
    
    public static void setLblCerrarSesion(JLabel lblCerrarSesion) {
    	Principal.lblCerrarSesion = lblCerrarSesion;
    }
    
    public static JButton getBtnCrearTablero() {
    	return btnCrearTablero;
    }
    
    public static void setBtnCrearTablero(JButton btnCrearTablero) {
    	Principal.btnCrearTablero = btnCrearTablero;
    }
    
    public static JButton getBtnAbrirTablero1() {
    	return btnAbrirTablero1;
    }
    
    public static void setBtnAbrirTablero1(JButton btnAbrirTablero1) {
    	Principal.btnAbrirTablero1 = btnAbrirTablero1;
    }
    
    public static JButton getBtnAbrirTablero2() {
    	return btnAbrirTablero2;
    }
    
    public static void setBtnAbrirTablero2(JButton btnAbrirTablero2) {
    	Principal.btnAbrirTablero2 = btnAbrirTablero2;
    }
    
    public static JButton getBtnAbrirTablero3() {
    	return btnAbrirTablero3;
    }
    
    public static void setBtnAbrirTablero3(JButton btnAbrirTablero3) {
    	Principal.btnAbrirTablero3 = btnAbrirTablero3;
    }
    
    public static JButton getBtnAgregarInvitados() {
    	return btnAgregarInvitados;
    }
    
    public static void setBtnAgregarInvitados(JButton btnAgregarInvitados) {
    	Principal.btnAgregarInvitados = btnAgregarInvitados;
    }
    
    public static JButton getBtnCancelarEmergenteCrearTablero() {
    	return btnCancelarEmergenteCrearTablero;
    }
    
    public static void setBtnCancelarEmergenteCrearTablero(JButton btnCancelarEmergenteCrearTablero) {
    	Principal.btnCancelarEmergenteCrearTablero = btnCancelarEmergenteCrearTablero;
    }
    
    public static JButton getBtnCrearTableroEmergenteCrearTablero() {
    	return btnCrearTableroEmergenteCrearTablero;
    }
    
    public static void setBtnCrearTableroEmergenteCrearTablero(JButton btnCrearTableroEmergenteCrearTablero) {
    	Principal.btnCrearTableroEmergenteCrearTablero = btnCrearTableroEmergenteCrearTablero;
    }
    
    public static JButton getBtnCancelarEmergenteAgregarInvitados() {
    	return btnCancelarEmergenteAgregarInvitados;
    }
    
    public static void setBtnCancelarEmergenteAgregarInvitados(JButton btnCancelarEmergenteAgregarInvitados) {
    	Principal.btnCancelarEmergenteAgregarInvitados = btnCancelarEmergenteAgregarInvitados;
    }
    
    public static JButton getBtnAgregarInvitadoEmergenteAgregarInvitados() {
    	return btnAgregarInvitadoEmergenteAgregarInvitados;
    }
    
    public static void setBtnAgregarInvitadoEmergenteAgregarInvitados(
    		JButton btnAgregarInvitadoEmergenteAgregarInvitados) {
    	Principal.btnAgregarInvitadoEmergenteAgregarInvitados = btnAgregarInvitadoEmergenteAgregarInvitados;
    }
    
    public static Color getNegro() {
    	return negro;
    }
    
    public static void setNegro(Color negro) {
    	Principal.negro = negro;
    }
    
    public static Color getBlanco() {
    	return blanco;
    }
    
    public static void setBlanco(Color blanco) {
    	Principal.blanco = blanco;
    }
    
    public static Color getRojo() {
    	return rojo;
    }
    
    public static void setRojo(Color rojo) {
    	Principal.rojo = rojo;
    }
    
    public static Color getVerde() {
    	return verde;
    }
    
    public static void setVerde(Color verde) {
    	Principal.verde = verde;
    }
    
    public static Color getMillos() {
    	return millos;
    }
    
    public static void setMillos(Color millos) {
    	Principal.millos = millos;
    }
    
    public static Color getRosa() {
    	return rosa;
    }
    
    public static void setRosa(Color rosa) {
    	Principal.rosa = rosa;
    }
    
    public static Color getRosa2() {
    	return rosa2;
    }
    
    public static void setRosa2(Color rosa2) {
    	Principal.rosa2 = rosa2;
    }
    
    public static Color getCyan() {
    	return cyan;
    }
    
    public static void setCyan(Color cyan) {
    	Principal.cyan = cyan;
    }
    
    public static Color getCyan2() {
    	return cyan2;
    }
    
    public static void setCyan2(Color cyan2) {
    	Principal.cyan2 = cyan2;
    }
    
    public static Color getGris() {
    	return gris;
    }
    
    public static void setGris(Color gris) {
    	Principal.gris = gris;
    }
    
    public static Color getGris2() {
    	return gris2;
    }
    
    public static void setGris2(Color gris2) {
    	Principal.gris2 = gris2;
    }
    
    public static Color getMorado() {
    	return morado;
    }
    
    public static void setMorado(Color morado) {
    	Principal.morado = morado;
    }
    
    public static Color getMorado2() {
    	return morado2;
    }
    
    public static void setMorado2(Color morado2) {
    	Principal.morado2 = morado2;
    }
    
    public static Color getMorado3() {
    	return morado3;
    }
    
    public static void setMorado3(Color morado3) {
    	Principal.morado3 = morado3;
    }
    
    public static Color getAguacate() {
    	return aguacate;
    }
    
    public static void setAguacate(Color aguacate) {
    	Principal.aguacate = aguacate;
    }
    
    public static Color getPetroleo() {
    	return petroleo;
    }
    
    public static void setPetroleo(Color petroleo) {
    	Principal.petroleo = petroleo;
    }
    
    public static Color getPetroleo2() {
    	return petroleo2;
    }
    
    public static void setPetroleo2(Color petroleo2) {
    	Principal.petroleo2 = petroleo2;
    }
    
    public static Color getLimon() {
    	return limon;
    }
    
    public static void setLimon(Color limon) {
    	Principal.limon = limon;
    }
    
    public static Color getLimon2() {
    	return limon2;
    }
    
    public static void setLimon2(Color limon2) {
    	Principal.limon2 = limon2;
    }
    
    public static String getMensajeIngresarNombreTablero() {
    	return mensajeIngresarNombreTablero;
    }
    
    public static void setMensajeIngresarNombreTablero(String mensajeIngresarNombreTablero) {
    	Principal.mensajeIngresarNombreTablero = mensajeIngresarNombreTablero;
    }
    
    public static String getMensajeIngresarCorreo() {
    	return mensajeIngresarCorreo;
    }
    
    public static void setMensajeIngresarCorreo(String mensajeIngresarCorreo) {
    	Principal.mensajeIngresarCorreo = mensajeIngresarCorreo;
    }
    
}
//class