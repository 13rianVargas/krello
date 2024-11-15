package co.edu.konradlorenz.view.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import co.edu.konradlorenz.controller.Controlador;

@SuppressWarnings("serial")
public class Principal extends JFrame {
	
	//MOSTRAR DETALLES
	private static boolean detalles = true;//true -> mostrar / false -> ocultar
	private static boolean macOS = true;//true -> macOS / false -> Windows
		
	//CONTROLADOR
	private static Controlador ctrl = new Controlador();

	//FRAMES
	private static JFrame framePrincipal = new JFrame();
	
	//EMERGENTES
	private static JDialog emergenteCrearTablero;
	private static JDialog emergenteAgregarInvitados;
	
	//PANELS
	private static JPanel panelPrincipalHead;
	private static JPanel panelPrincipalMiddle;
	private static JPanel panelPrincipalBody;
	
	//TEXTFIELDS
	private static JTextField txtFieldIngresarNombreEmergenteCrearTablero;
	private static JTextField txtFieldIngresarCorreoEmergenteAñadirInvitados;
	
	//PASSWORDFIELDS
	
	
	//BUTTONS
	private static JButton btnCrearTablero;
	private static JButton btnAbrirTablero1;
	private static JButton btnAbrirTablero2;
	private static JButton btnAbrirTablero3;
	private static JButton btnAgregarInvitados;
	private static JButton btnCancelarEmergenteCrearTablero;
	private static JButton btnCrearTableroEmergenteCrearTablero;
	private static JButton btnCancelarEmergenteAñadirInvitados;
	private static JButton btnAgregarInvitadoEmergenteAñadirInvitados;
		
	//COLORS
	private static Color blanco = new Color(255, 255, 255);
	private static Color rosa = new Color(243, 178, 177);
	private static Color cyan = new Color(117, 251, 253);
	private static Color rojo = new Color(255, 0, 0);
	private static Color verde = new Color(117, 251, 76);
	private static Color millos = new Color(0, 0, 255);
	private static Color gris = new Color(154, 154, 154);
	private static Color grisClaro = new Color(217, 217, 217);
	private static Color aguacate = new Color(102, 181, 127);
	private static Color morado = new Color(98, 20, 109);
	private static Color negro = new Color(0, 0, 0);
	private static Color petroleo = new Color(0, 151, 149);
	private static Color limon = new Color(206, 220, 23);
	private static Color limon2 = new Color(180, 200, 0);//Para los títulos de las emergentes
	
	//BORDER macOS
	private static Border macOSBorde = BorderFactory.createLineBorder(negro, 1);//Borde de 1px para mac :)

	//STRINGS
	private static String mensajeIngresarNombreTablero = " Ingrese nombre del tablero...";
	private static String mensajeIngresarCorreo = " Ingrese correo electrónico...";
	
	
	
	
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // VENTANAS // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
    //Abre: Constructor del frame Principal
    public Principal(){

    	framePrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE); //Terminar la ejecución si se cierra la ventana
    	framePrincipal.setTitle("Krello - Mis Tableros");//Título de la ventana
    	framePrincipal.setSize(1280, 720);//ancho, alto
    	framePrincipal.setMinimumSize(new Dimension(1280, 720));//Tamaño mínimo al que se puede ajustar
    	framePrincipal.setLocationRelativeTo(null); //Centra la ventana
    	framePrincipal.setLayout(new BorderLayout());//Diseño
    	framePrincipal.setBackground(morado);//Color de la barra superior de la ventana
    	framePrincipal.getContentPane().setBackground(blanco);//Color del fondo del frame

    		panelPrincipalHead = panelPrincipalHead();//Crea el head
    	
		framePrincipal.add(panelPrincipalHead, BorderLayout.NORTH);//Lo añade y lo ubica arriba
	
    		panelPrincipalMiddle = panelPrincipalMiddle();//Crea el middle
    	
		framePrincipal.add(panelPrincipalMiddle, BorderLayout.CENTER);//Lo añade y lo ubica al centro
    	
    		panelPrincipalBody = panelPrincipalBody();//Crea el body
    	
		framePrincipal.add(panelPrincipalBody, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
	        
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

        	//Abre: Imagen Krello
	        JLabel lblKrelloLogo = new JLabel();//Crea nuevo
	        lblKrelloLogo.setIcon(new ImageIcon(Principal.class.getResource("/co/edu/konradlorenz/view/img/KrelloLogo187x60.png")));//Ruta de la imagen
	        lblKrelloLogo.setBorder(new EmptyBorder(30, 30, 30, 30));//top, left, bottom, right -> Ajusta un borde por pixeles
	        lblKrelloLogo.setBackground(verde);//Color de fondo
	        lblKrelloLogo.setOpaque(detalles);//Mostrar detalles
	        //Cierra: Imagen Krello
	        
        panelPrincipalHead.add(lblKrelloLogo, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
	        
	        //Abre: lblHolaUser
        	JPanel lblHolaUser = new JPanel();//Crea nuevo
        	lblHolaUser.setLayout(new BoxLayout(lblHolaUser, BoxLayout.X_AXIS));//Diseño: El BoxLayout.X_AXIS es para que se ubiquen HORIZONTALMENTE una al lado de la otra.
        	lblHolaUser.setForeground(negro);//Color de letra
	        lblHolaUser.setBorder(new EmptyBorder(30, 0, 30, 0));//top, left, bottom, right -> Ajusta un borde por pixeles
	        lblHolaUser.setBackground(millos);//Color de fondo
	        lblHolaUser.setOpaque(detalles);//Mostrar detalles
        	
        	//Dirás... ¿para que se hacen 3 labels? Es para que solo el lblUser se muestre en Italic y los demás normal, así queda más bonito.
	        
	        	//Abrir: lblHola
	        	JLabel lblHola = new JLabel("¡Hola ");//Crea nuevo
		        lblHola.setFont(new Font("Arial", Font.PLAIN, 22));//Cambia la letra del interior
	        	//Cerrar: lblHola
		        
	        lblHolaUser.add(lblHola);//Añade lblHola

        		//Abrir: lblUser
		        JLabel lblUser = new JLabel("Aquí va un nombre genérico, si tan solo tuvieramos uno T-T");//Crea nuevo //TODO: Agregar nombre genérico xd
		        lblUser.setFont(new Font("Arial", Font.ITALIC, 22));//Cambia la letra del interior
	        	//Cerrar: lblUser
		        
	        lblHolaUser.add(lblUser);//Añade lblUser
		        
        		//Abrir: lblAdmiracion
		        JLabel lblAdmiracion = new JLabel("!");//Crea nuevo
		        lblAdmiracion.setFont(new Font("Arial", Font.PLAIN, 22));//Cambia la letra del interior
	        	//Cerrar: lblAdmiracion
		        
	        lblHolaUser.add(lblAdmiracion);//Añade lblAdmiracion
	        //Cierra: lblHolaUser
	        
        panelPrincipalHead.add(lblHolaUser, BorderLayout.CENTER);//Lo añade y lo ubica al centro
	        
	      	//Abre: panelCerrarSesion
	        JPanel panelCerrarSesion = new JPanel();//Crea nuevo
	        panelCerrarSesion.setLayout(new BoxLayout(panelCerrarSesion, BoxLayout.X_AXIS));//Diseño: El BoxLayout.X_AXIS es para que se ubiquen HORIZONTALMENTE una al lado de la otra.
	        panelCerrarSesion.setBorder(BorderFactory.createEmptyBorder(50, 30, 50, 30));//top, left, bottom, right -> Ajusta un borde por pixeles
	        panelCerrarSesion.setBackground(rojo);//Color de fondo
	        panelCerrarSesion.setOpaque(detalles);//Mostrar detalles
	        
	        	//Abre: lblCerrarSesion (Este lbl contiene una acción)
		        JLabel lblCerrarSesion = new JLabel("Cerrar sesión");//Crea nuevo
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
    
    //Abre: Método para crear el panelPrincipalMiddle
    public static JPanel panelPrincipalMiddle() {
    	
        panelPrincipalMiddle = new JPanel();//Crea nuevo
        panelPrincipalMiddle.setBackground(cyan);//Color de fondo
        panelPrincipalMiddle.setOpaque(detalles);//Mostrar detalles
        
        	//Abre: lblMisTableros
	        JLabel lblMisTableros = new JLabel("Mis Tableros");//Crea nuevo
	        lblMisTableros.setFont(new Font("Arial", Font.PLAIN, 30));//Cambia la letra del interior
	        
	        //TODO: Al hacer la ventana completa o ajustar la ventana, se desproporciona.
	        // Guíate del panel "lblCerrarSesion" del head,
	        // fijate que "lblCerrarSesion" con fondo cyan está dentro de "panelCerrarSesion" de fondo rojo,
	        // eso con el fin de centrar el "lblCerrarSesion".
	        
        	//Cierra: lblMisTableros
        
        panelPrincipalMiddle.add(lblMisTableros);//Lo añade
	        
    	return panelPrincipalMiddle;
    }
    //Cierra: Método para crear el panelPrincipalMiddle
    
    //Abre: Método para crear el panelPrincipalBody
    public static JPanel panelPrincipalBody() {
    	
        panelPrincipalBody = new JPanel();//Crear nuevo    
        panelPrincipalBody.setBackground(rosa);//Color de fondo
        panelPrincipalBody.setOpaque(detalles);//Mostrar detalles
        panelPrincipalBody.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 150));//Diseño: Flujo Centrado (espacio horizontal),(espacio vertical)

        Dimension buttonSize = new Dimension(200, 200);//Establece variable de tamaño para los botones
        
	        //Abre: btnCrearTablero
	        btnCrearTablero = new JButton("+");//Crea nuevo
	        btnCrearTablero.setBackground(petroleo);//Color de fondo
	        btnCrearTablero.setForeground(blanco);//Color de letra
	    	btnCrearTablero.setFont(new Font("Arial", Font.PLAIN, 80));//Cambia la letra del interior
	    	btnCrearTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	    	btnCrearTablero.setPreferredSize(buttonSize);//Tamaño botón
	    	if(macOS) {
	    		btnCrearTablero.setOpaque(true);//No transparente
	    		btnCrearTablero.setBorder(macOSBorde);//Borde negro fino
	    	}
	    	
				//Abre: Acción del btnCrearTablero
				btnCrearTablero.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent evento) {
		            	ctrl.actionBtnCrearTablero(evento);//Se llama el método del Controller que gestiona el evento.
		            }
		        });
				//Cierra: Acción del btnCrearTablero
				
			//Cierra: btnCrearTablero
    	
		panelPrincipalBody.add(btnCrearTablero);//Añade btnCrearTablero
				
			//Abre: btnAbrirTablero1
	        btnAbrirTablero1 = new JButton("Abrir Tablero 1");//Crea nuevo
	        btnAbrirTablero1.setBackground(petroleo);//Color de fondo
	        btnAbrirTablero1.setForeground(blanco);//Color de letra
	        btnAbrirTablero1.setFont(new Font("Inter", Font.BOLD, 18));//Cambia la letra del interior
			btnAbrirTablero1.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
			btnAbrirTablero1.setPreferredSize(buttonSize);//Tamaño botón
			if(macOS) {
				btnAbrirTablero1.setOpaque(true);//No transparente
				btnAbrirTablero1.setBorder(macOSBorde);//Borde negro fino
			}
			
		      	//Abre: Acción del btnAbrirTablero1
	        	btnAbrirTablero1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent evento) {
		            	//TODO:Crear método en el Controller
		            	//ctrl.actionBtnAbrirTablero1(evento);//Se llama el método del Controller que gestiona el evento. 
		            }
		        });
				//Cierra: Acción del btnAbrirTablero1
	        
			//Cierra: btnAbrirTablero1
        
    	panelPrincipalBody.add(btnAbrirTablero1);//Añade btnAbrirTablero1
	        
			//Abre: btnAbrirTablero2
	        btnAbrirTablero2 = new JButton("Abrir Tablero 2");//Crea nuevo
	        btnAbrirTablero2.setBackground(petroleo);//Color de fondo
	        btnAbrirTablero2.setForeground(blanco);//Color de letra
	        btnAbrirTablero2.setFont(new Font("Inter", Font.BOLD, 18));//Cambia la letra del interior
	        btnAbrirTablero2.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	        btnAbrirTablero2.setPreferredSize(buttonSize);//Tamaño botón
	        if(macOS) {
	        	btnAbrirTablero2.setOpaque(true);//No transparente
	        	btnAbrirTablero2.setBorder(macOSBorde);//Borde negro fino
	        }
			
		      	//Abre: Acción del btnAbrirTablero2
				btnAbrirTablero2.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent evento) {
		            	//TODO:Crear método en el Controller
		            	//ctrl.actionBtnAbrirTablero2(evento);//Se llama el método del Controller que gestiona el evento. 
		            }
		        });
				//Cierra: Acción del btnAbrirTablero2
	        	
			//Cierra: btnAbrirTablero2

        panelPrincipalBody.add(btnAbrirTablero2);//Añade btnAbrirTablero2
				
			//Abre: btnAbrirTablero3
	        btnAbrirTablero3 = new JButton("Abrir Tablero 3");//Crea nuevo
	        btnAbrirTablero3.setBackground(petroleo);//Color de fondo
	        btnAbrirTablero3.setForeground(blanco);//Color de letra
	        btnAbrirTablero3.setFont(new Font("Inter", Font.BOLD, 18));//Cambia la letra del interior
	        btnAbrirTablero3.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	        btnAbrirTablero3.setPreferredSize(buttonSize);//Tamaño botón
	        if(macOS) {
	        	btnAbrirTablero3.setOpaque(true);//No transparente
	        	btnAbrirTablero3.setBorder(macOSBorde);//Borde negro fino
	        }
	        
		      	//Abre: Acción del btnAbrirTablero3
				btnAbrirTablero3.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent evento) {
		            	//TODO:Crear método en el Controller
		            	//ctrl.actionBtnAbrirTablero3(evento);//Se llama el método del Controller que gestiona el evento. 
		            }
		        });
				//Cierra: Acción del btnAbrirTablero3
			
			//Cierra: btnAbrirTablero3

        panelPrincipalBody.add(btnAbrirTablero3);//Añade btnAbrirTablero3

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
        emergenteCrearTablero.setBackground(blanco);//Color de fondo
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
		        lblTituloCrearTablero.setFont(new Font("Arial", Font.BOLD, 40));//Cambia la letra del interior
		        lblTituloCrearTablero.setForeground(limon2);//Color de letra
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
		        lblNombre.setFont(new Font("Arial", Font.PLAIN, 20));//Cambia la letra del interior
	        	//Cierra: lblNombre
		        
	        panelIngresarNombreTablero.add(lblNombre);//Añade lblNombre
		        
	        	//Abre: txtFieldIngresarNombreEmergenteCrearTablero
		        txtFieldIngresarNombreEmergenteCrearTablero = new JTextField(mensajeIngresarNombreTablero);//Crea nuevo
		        txtFieldIngresarNombreEmergenteCrearTablero.setForeground(gris);//Color de letra
		        txtFieldIngresarNombreEmergenteCrearTablero.setPreferredSize(new Dimension(400, 30));
		        txtFieldIngresarNombreEmergenteCrearTablero.setFont(new Font("Arial", Font.PLAIN, 20));//Cambia la letra del interior
		        txtFieldIngresarNombreEmergenteCrearTablero.setBackground(grisClaro);//Color de fondo
		        txtFieldIngresarNombreEmergenteCrearTablero.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor modo escritura
		        if(macOS) {
		        	txtFieldIngresarNombreEmergenteCrearTablero.setOpaque(true);//No transparente
		        	txtFieldIngresarNombreEmergenteCrearTablero.setBorder(macOSBorde);//Borde negro fino
		        }
		        
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
			            	ctrl.actionEnterTxtFieldIngresarNombreEmergenteCrearTablero(evento);//Se llama el método del Controller que gestiona el evento.
			            }
			        });
			        //Cierra: Acción del txtFieldIngresarNombreEmergenteCrearTablero
		        
		        //Cierra: txtFieldIngresarNombreEmergenteCrearTablero
		        
	        panelIngresarNombreTablero.add(txtFieldIngresarNombreEmergenteCrearTablero);//Agrega txtFieldIngresarNombreEmergenteCrearTablero
	        
	        panelIngresarNombreTablero.add(Box.createVerticalStrut(10));//Espacio entre componentes (lbl y txtField)
	        panelIngresarNombreTablero.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));// top, left, bottom, right -> Ajusta un borde por pixeles
	        //Cierra: panelIngresarNombreTablero
	        
	        
        emergenteCrearTablero.add(panelIngresarNombreTablero, BorderLayout.CENTER);//Lo añade y lo ubica al centro

        
        	//Abre: panelInferior
        	JPanel panelInferior = new JPanel(new BorderLayout());//Crea nuevo
        	panelInferior.setBackground(blanco);//Color de fondo
        	panelInferior.setOpaque(detalles);//Mostrar detalles
        	
        	
		        //Abre: panelAgregarInvitados
		        JPanel panelAgregarInvitados = new JPanel();//Crea nuevo
		        panelAgregarInvitados.setBackground(rosa);//Color de fondo
		        panelAgregarInvitados.setOpaque(detalles);//Mostrar detalles
		        
		        	//Abre: btnAgregarInvitados
		        	btnAgregarInvitados = new JButton("Agregar Invitados");//Crea nuevo
		        	btnAgregarInvitados.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
		        	btnAgregarInvitados.setPreferredSize(new Dimension(200, 40));//Tamaño botón
		        	btnAgregarInvitados.setBackground(aguacate);//Color de fondo
		        	btnAgregarInvitados.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        	if(macOS) {
		        		btnAgregarInvitados.setOpaque(true);//No transparente
		        		btnAgregarInvitados.setBorder(macOSBorde);//Borde negro fino
		        	}
		        		//Abre: Acción del btnAgregarInvitados
			    		btnAgregarInvitados.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	ctrl.actionBtnAgregarInvitados(evento);//Se llama el método del Controller que gestiona el evento.
				            }
				        });
		        		//Cierra: Acción del btnAgregarInvitados
			    		
			    	//Cierra: btnAgregarInvitados
			    		
		        panelAgregarInvitados.add(btnAgregarInvitados);//Agrega btnAgregarInvitados
		        panelAgregarInvitados.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));// top, left, bottom, right -> Ajusta un borde por pixeles
		    	//Cierra: panelAgregarInvitados

	        
		        //Abre: panelBotonesBasicos
		        JPanel panelBotonesBasicos = new JPanel(new BorderLayout());
		        panelBotonesBasicos.setBackground(cyan);//Color de fondo
		        panelBotonesBasicos.setOpaque(detalles);//Mostrar detalles
		        
		        	//Abre: btnCancelarEmergenteCrearTablero
			        btnCancelarEmergenteCrearTablero = new JButton("Cancelar");//Crea nuevo
			        btnCancelarEmergenteCrearTablero.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
			        btnCancelarEmergenteCrearTablero.setPreferredSize(new Dimension(200, 40));//Tamaño botón
			        btnCancelarEmergenteCrearTablero.setBackground(limon);//Color de fondo
			        btnCancelarEmergenteCrearTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
			        if(macOS) {
			        	btnCancelarEmergenteCrearTablero.setOpaque(true);//No transparente
			        	btnCancelarEmergenteCrearTablero.setBorder(macOSBorde);//Borde negro fino
			        }
			        
		    			//Abre: Acción del btnCancelarEmergenteCrearTablero
			    		btnCancelarEmergenteCrearTablero.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	ctrl.actionBtnCancelarEmergenteCrearTablero(evento);//Se llama el método del Controller que gestiona el evento.
				            }
				        });
		    			//Cierra: Acción del btnCancelarEmergenteCrearTablero
		    		
		        	//Cierra: btnCancelarEmergenteCrearTablero
		    		
	    			//Abre: btnCrearTableroEmergenteCrearTablero	
			        btnCrearTableroEmergenteCrearTablero = new JButton("Crear Tablero");//Crear nuevo
			        btnCrearTableroEmergenteCrearTablero.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
			        btnCrearTableroEmergenteCrearTablero.setPreferredSize(new Dimension(200, 40));
			        btnCrearTableroEmergenteCrearTablero.setBackground(limon);//Color de fondo
			        btnCrearTableroEmergenteCrearTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
			        if(macOS) {
			        	btnCrearTableroEmergenteCrearTablero.setOpaque(true);//No transparente
			        	btnCrearTableroEmergenteCrearTablero.setBorder(macOSBorde);//Borde negro fino
			        }
			        
			        	//Abre: Acción del btnCrearTableroEmergenteCrearTablero
			    		btnCrearTableroEmergenteCrearTablero.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	ctrl.actionEnterTxtFieldIngresarNombreEmergenteCrearTablero(evento);//Se llama el método del Controller que gestiona el evento.
				            }
				        });
				        //Cierra: Acción del btnCrearTableroEmergenteCrearTablero
		    		
	    			//Cierra: btnCrearTableroEmergenteCrearTablero
		    		
		        panelBotonesBasicos.add(btnCancelarEmergenteCrearTablero, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
		        panelBotonesBasicos.add(btnCrearTableroEmergenteCrearTablero, BorderLayout.EAST);//Lo añade y lo ubica a la derecha
		        panelBotonesBasicos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));//top, left, bottom, right -> Ajusta un borde por pixeles
		        //Cierra: panelBotonesBasicos

		        
	        panelInferior.add(panelAgregarInvitados, BorderLayout.NORTH);//Lo añade y lo ubica arriba
	        panelInferior.add(panelBotonesBasicos, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
        	//Cierra: panelInferior

	        
        emergenteCrearTablero.add(panelInferior, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
    	
        
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
	    	
	    		//Abre: txtFieldIngresarCorreoEmergenteAñadirInvitados
		    	txtFieldIngresarCorreoEmergenteAñadirInvitados = new JTextField(mensajeIngresarCorreo);//Crea nuevo
		    	txtFieldIngresarCorreoEmergenteAñadirInvitados.setForeground(gris);//Color de letra
		    	txtFieldIngresarCorreoEmergenteAñadirInvitados.setPreferredSize(new Dimension(400, 30));//Tamaño
		        txtFieldIngresarCorreoEmergenteAñadirInvitados.setFont(new Font("Arial", Font.PLAIN, 20));//Cambia la letra del interior
		        txtFieldIngresarCorreoEmergenteAñadirInvitados.setBackground(grisClaro);//Color de fondo
		        txtFieldIngresarCorreoEmergenteAñadirInvitados.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor modo escritura
		        if(macOS) {
		        	txtFieldIngresarCorreoEmergenteAñadirInvitados.setOpaque(true);//No transparente
		        	txtFieldIngresarCorreoEmergenteAñadirInvitados.setBorder(macOSBorde);//Borde negro fino
		        }
		        
			        //Abre: Placeholder "mensaje previo"
			    	txtFieldIngresarCorreoEmergenteAñadirInvitados.addFocusListener(new FocusListener() {
			            @Override
			            public void focusGained(FocusEvent e) {
			                if (txtFieldIngresarCorreoEmergenteAñadirInvitados.getText().equals(mensajeIngresarCorreo)) {
			                	txtFieldIngresarCorreoEmergenteAñadirInvitados.setText("");//Cambia el contenido del txtField
			                	txtFieldIngresarCorreoEmergenteAñadirInvitados.setForeground(negro);//Color de letra
			                }
			            }
			            @Override
			            public void focusLost(FocusEvent e) {
			                //Si el campo de texto está vacío al perder el foco, restaura el placeholder
			                if (txtFieldIngresarCorreoEmergenteAñadirInvitados.getText().isEmpty()) {
			                	txtFieldIngresarCorreoEmergenteAñadirInvitados.setText(mensajeIngresarCorreo);//Cambia el contenido del txtField
			                	txtFieldIngresarCorreoEmergenteAñadirInvitados.setForeground(gris);//Color de letra
			                }
			            }
			        });
			        //Cierra: Placeholder "mensaje previo"
		        
			    	//Abre: Acción del txtFieldIngresarCorreoEmergenteAñadirInvitados
			        txtFieldIngresarCorreoEmergenteAñadirInvitados.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.actionEnterTxtFieldIngresarCorreoEmergenteAñadirInvitados(evento);//Se llama el método del Controller que gestiona el evento.
			            }
			        });
			    	//Cierra: Acción del txtFieldIngresarCorreoEmergenteAñadirInvitados
	        
	    		//Cierra: txtFieldIngresarCorreoEmergenteAñadirInvitados
			        
	        panelIngresarCorreo.add(Box.createVerticalGlue());//Agrega espacio flexible antes
	        panelIngresarCorreo.add(txtFieldIngresarCorreoEmergenteAñadirInvitados);//Añade txtFieldIngresarCorreoEmergenteAñadirInvitados
	        panelIngresarCorreo.add(Box.createVerticalGlue());//Agrega espacio flexible después
	        panelIngresarCorreo.setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0));// top, left, bottom, right -> Ajusta un borde por pixeles
		    //Cierra: panelIngresarCorreo
        
	        
	    emergenteAgregarInvitados.add(panelIngresarCorreo, BorderLayout.CENTER);//Lo añade y lo ubica al centro
	    
	    
		    //Abre: panelBotonesBasicos
	        JPanel panelBotonesBasicos = new JPanel();//Crea nuevo
	        panelBotonesBasicos.setLayout(new BorderLayout());//Diseño
	        panelBotonesBasicos.setBackground(cyan);//Color de fondo
	        panelBotonesBasicos.setOpaque(detalles);//Mostrar detalles
	        
	        	//Abre: btnCancelarEmergenteAñadirInvitados
		        btnCancelarEmergenteAñadirInvitados = new JButton("Cancelar");//Crea nuevo
		        btnCancelarEmergenteAñadirInvitados.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
		        btnCancelarEmergenteAñadirInvitados.setPreferredSize(new Dimension(200, 40));//Tamaño
		        btnCancelarEmergenteAñadirInvitados.setBackground(limon);//Color de fondo
		        btnCancelarEmergenteAñadirInvitados.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        if(macOS) {
		        	btnCancelarEmergenteAñadirInvitados.setOpaque(true);//No transparente
		        	btnCancelarEmergenteAñadirInvitados.setBorder(macOSBorde);//Borde negro fino
		        }
		        
		        	//Abre: Acción del btnCancelarEmergenteAñadirInvitados
			        btnCancelarEmergenteAñadirInvitados.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.actionBtnCancelarEmergenteAñadirInvitados(evento);//Se llama el método del Controller que gestiona el evento.
			            }
			        });
		        	//Cierra: Acción del btnCancelarEmergenteAñadirInvitados
			        
	        	//Cierra: btnCancelarEmergenteAñadirInvitados
		        
			    //Abre: btnAgregarInvitadoEmergenteAñadirInvitados
		        btnAgregarInvitadoEmergenteAñadirInvitados = new JButton("Agregar Invitado");//Crea nuevo
		        btnAgregarInvitadoEmergenteAñadirInvitados.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
		        btnAgregarInvitadoEmergenteAñadirInvitados.setPreferredSize(new Dimension(200, 40));//Tamaño
		        btnAgregarInvitadoEmergenteAñadirInvitados.setBackground(limon);//Color de fondo
		        btnAgregarInvitadoEmergenteAñadirInvitados.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        if(macOS) {
		        	btnAgregarInvitadoEmergenteAñadirInvitados.setOpaque(true);//No transparente
		        	btnAgregarInvitadoEmergenteAñadirInvitados.setBorder(macOSBorde);//Borde negro fino
		        }
		        
		        	//Abre: Acción del btnAgregarInvitadoEmergenteAñadirInvitados
			        btnAgregarInvitadoEmergenteAñadirInvitados.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			                //IMPORTANTE -> Aquí se llama a un método que maneja el evento desde el Controller.
			            	ctrl.actionEnterTxtFieldIngresarCorreoEmergenteAñadirInvitados(evento);
			            }
			        });
		        	//Cierra: Acción del btnAgregarInvitadoEmergenteAñadirInvitados
		        
		        //Cierra: btnAgregarInvitadoEmergenteAñadirInvitados
			        
	        panelBotonesBasicos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));// top, left, bottom, right -> Ajusta un borde por pixeles
	        panelBotonesBasicos.add(btnCancelarEmergenteAñadirInvitados, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
	        panelBotonesBasicos.add(btnAgregarInvitadoEmergenteAñadirInvitados, BorderLayout.EAST);//Lo añade y lo ubica a la derecha
		    //Cierra: panelBotonesBasicos
	        
        emergenteAgregarInvitados.add(panelBotonesBasicos, BorderLayout.SOUTH);//Lo añade y lo ubica abajo

        //Abre: Funcionalidad cambiar el foco automático al abrir la emergente
        txtFieldIngresarCorreoEmergenteAñadirInvitados.setEnabled(false);
        Timer timer = new Timer(100, e -> {
        	txtFieldIngresarCorreoEmergenteAñadirInvitados.setEnabled(true);
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

	public static boolean isDetalles() {
		return detalles;
	}

	public static void setDetalles(boolean detalles) {
		Principal.detalles = detalles;
	}

	public static boolean isMacOS() {
		return macOS;
	}

	public static void setMacOS(boolean macOS) {
		Principal.macOS = macOS;
	}

	public static Controlador getCtrl() {
		return ctrl;
	}

	public static void setCtrl(Controlador ctrl) {
		Principal.ctrl = ctrl;
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

	public static JTextField getTxtFieldIngresarCorreoEmergenteAñadirInvitados() {
		return txtFieldIngresarCorreoEmergenteAñadirInvitados;
	}

	public static void setTxtFieldIngresarCorreoEmergenteAñadirInvitados(
			JTextField txtFieldIngresarCorreoEmergenteAñadirInvitados) {
		Principal.txtFieldIngresarCorreoEmergenteAñadirInvitados = txtFieldIngresarCorreoEmergenteAñadirInvitados;
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

	public static JButton getBtnCancelarEmergenteAñadirInvitados() {
		return btnCancelarEmergenteAñadirInvitados;
	}

	public static void setBtnCancelarEmergenteAñadirInvitados(JButton btnCancelarEmergenteAñadirInvitados) {
		Principal.btnCancelarEmergenteAñadirInvitados = btnCancelarEmergenteAñadirInvitados;
	}

	public static JButton getBtnAgregarInvitadoEmergenteAñadirInvitados() {
		return btnAgregarInvitadoEmergenteAñadirInvitados;
	}

	public static void setBtnAgregarInvitadoEmergenteAñadirInvitados(
			JButton btnAgregarInvitadoEmergenteAñadirInvitados) {
		Principal.btnAgregarInvitadoEmergenteAñadirInvitados = btnAgregarInvitadoEmergenteAñadirInvitados;
	}

	public static Color getBlanco() {
		return blanco;
	}

	public static void setBlanco(Color blanco) {
		Principal.blanco = blanco;
	}

	public static Color getRosa() {
		return rosa;
	}

	public static void setRosa(Color rosa) {
		Principal.rosa = rosa;
	}

	public static Color getCyan() {
		return cyan;
	}

	public static void setCyan(Color cyan) {
		Principal.cyan = cyan;
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

	public static Color getGris() {
		return gris;
	}

	public static void setGris(Color gris) {
		Principal.gris = gris;
	}

	public static Color getGrisClaro() {
		return grisClaro;
	}

	public static void setGrisClaro(Color grisClaro) {
		Principal.grisClaro = grisClaro;
	}

	public static Color getAguacate() {
		return aguacate;
	}

	public static void setAguacate(Color aguacate) {
		Principal.aguacate = aguacate;
	}

	public static Color getMorado() {
		return morado;
	}

	public static void setMorado(Color morado) {
		Principal.morado = morado;
	}

	public static Color getNegro() {
		return negro;
	}

	public static void setNegro(Color negro) {
		Principal.negro = negro;
	}

	public static Color getPetroleo() {
		return petroleo;
	}

	public static void setPetroleo(Color petroleo) {
		Principal.petroleo = petroleo;
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

	public static Border getMacOSBorde() {
		return macOSBorde;
	}

	public static void setMacOSBorde(Border macOSBorde) {
		Principal.macOSBorde = macOSBorde;
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