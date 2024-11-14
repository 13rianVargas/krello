package co.edu.konradlorenz.view.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import co.edu.konradlorenz.controller.Controlador;

@SuppressWarnings("serial")
public class Principal extends JFrame {
	
	private static Controlador ctrl = new Controlador();

	//FRAMES
	private static JFrame framePrincipal = new JFrame();
	
	//EMERGENTES
	private static JDialog emergenteCrearTablero;
	private static JDialog emergenteAgregarInvitados;
	
	//PANELS
	private static JPanel panelInvisible = new JPanel();//Este JPanel permite que el autofocus no sea el primer campo de texto.
	private static JPanel panelPrincipalHead;
	private static JPanel panelPrincipalMiddle;
	private static JPanel panelPrincipalBody;
	
	//TEXTFIELDS
	private static JTextField txtFieldIngresarNombreEmergenteCrearTablero;
	
	//PASSWORDFIELDS
	
	
	//BUTTONS
	private static JButton btnCrearTablero;
	private static JButton btnAbrirTablero1;
	private static JButton btnAbrirTablero2;
	private static JButton btnAbrirTablero3;
	private static JButton btnAgregarInvitados;
	private static JButton btnCancelarEmergenteCrearTablero;
	private static JButton btnCrearTableroEmergenteCrearTablero;
		
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
	
	//BORDER
	private static Border border = BorderFactory.createLineBorder(negro, 1);//Borde de 1px

	//MOSTRAR DETALLES
	private static boolean detalles = false;//true -> mostrar / false -> ocultar
	
	//STRINGS
	private static String mensajeIngresarNombreTablero = " Ingrese nombre del tablero...";
	
	
	
	
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // VENTANAS // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
    //Constructor del frame Principal
    public Principal(){

    	framePrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE); //Terminar la ejecución si se cierra la ventana
    	framePrincipal.setTitle("Krello - Mis Tableros");//Título de la ventana
    	framePrincipal.setSize(1280, 720);//ancho, alto
    	framePrincipal.setMinimumSize(new Dimension(1280, 720));//Tamaño mínimo al que se puede ajustar
    	framePrincipal.setLocationRelativeTo(null); //Centra la ventana
    	framePrincipal.setLayout(new BorderLayout());//Hace el frame responsivo a los ajustes de tamaño
    	framePrincipal.setBackground(Color.CYAN);//Color de la barra de la ventana
    	framePrincipal.getContentPane().setBackground(blanco);//Color del fondo

    	panelPrincipalHead = panelPrincipalHead();
    	framePrincipal.add(panelPrincipalHead, BorderLayout.NORTH);//Lo añade y hace el panel responsivo
	
    	panelPrincipalMiddle = panelPrincipalMiddle();
    	framePrincipal.add(panelPrincipalMiddle, BorderLayout.CENTER);//Lo añade y hace el panel responsivo
    	
    	panelPrincipalBody = panelPrincipalBody();
    	framePrincipal.add(panelPrincipalBody, BorderLayout.SOUTH);//Lo añade y hace el panel responsivo
	        
    	framePrincipal.setVisible(true); //IMPORTANTE Siempre hacer dejar esto de últimas.
    }
    //*///Principal
    
    
    
    
    
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // PANELES  // -- // -- //
	// -- // -- // -- // -- // -- // -- //
    
    //Método para crear panelPrincipalHead
	public JPanel panelPrincipalHead() {
    	
        panelPrincipalHead = new JPanel();
        panelPrincipalHead.setBackground(rosa);
        panelPrincipalHead.setOpaque(detalles);//Mostrar detalles
        panelPrincipalHead.setLayout(new BorderLayout(10, 0));//Espacio horizontal y vertical entre los componentes

        	//LOGO KRELLO
	        JLabel lblKrelloLogo = new JLabel();
	        //No me esta sirviendo la img
	        lblKrelloLogo.setIcon(new ImageIcon(getClass().getResource("/co/edu/konradlorenz/view/img/KrelloLogo187x60.png")));
	        lblKrelloLogo.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
	        lblKrelloLogo.setBackground(verde);
	        lblKrelloLogo.setOpaque(detalles);//Mostrar detalles
	        
        panelPrincipalHead.add(lblKrelloLogo, BorderLayout.WEST);//Ubica automáticamente a la izquierda
	        
	        //FRASE CENTRAL
	        JLabel lblHola = new JLabel("¡Hola ");
	        lblHola.setFont(new Font("Arial", Font.PLAIN, 22));//Cambia la letra del interior

	        JLabel lblUser = new JLabel("Aquí va un nombre genérico, si tan solo tuvieramos uno T-T");//TODO: Agregar nombre genérico xd
	        lblUser.setFont(new Font("Arial", Font.ITALIC, 22));//Cambia la letra del interior
	        
	        JLabel lblAdmiracion = new JLabel("!");//IMPORTANTE, dirás, para que se separa en 3 lbl?, es para que solo el lblUser se muestre en Italic y quede guapo
	        lblAdmiracion.setFont(new Font("Arial", Font.PLAIN, 22));//Cambia la letra del interior

	        JPanel lblHolaUser = new JPanel();//Sí, esto es un Panel anidado xd
	        lblHolaUser.setLayout(new BoxLayout(lblHolaUser, BoxLayout.X_AXIS));//El BoxLayout.X_AXIS es para que se ordenen Horizontalmente, cambia la X por la Y para que lo notes.
	        lblHolaUser.add(lblHola);
	        lblHolaUser.add(lblUser);
	        lblHolaUser.add(lblAdmiracion);
	        lblHolaUser.setForeground(Color.BLACK);//Color de la letra
	        lblHolaUser.setBorder(new EmptyBorder(30, 0, 30, 0)); // top, left, bottom, right -> Ajusta un borde por pixeles
	        lblHolaUser.setBackground(millos);
	        lblHolaUser.setOpaque(detalles);//Mostrar detalles
	        
        panelPrincipalHead.add(lblHolaUser, BorderLayout.CENTER);//Ubica automáticamente al centro
	        
        	//"BOTÓN" (guiño guiño) CERRAR SESIÓN
	        JLabel lblCerrarSesion = new JLabel("Cerrar sesión");
	        lblCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 22));//Cambia la letra del interior
	        lblCerrarSesion.setForeground(Color.BLACK);//Color de la letra
	        lblCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));//Cambia el cursor a una mano cuando pase por encima
	        lblCerrarSesion.setBackground(cyan);
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
		        panelCerrarSesion.setBackground(rojo);
		        panelCerrarSesion.setOpaque(detalles);//Mostrar detalles
		        panelCerrarSesion.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
	
		        panelCerrarSesion.add(Box.createVerticalGlue());//Agrega espacio flexible antes del JLabel
		        panelCerrarSesion.add(lblCerrarSesion);
		        panelCerrarSesion.add(Box.createVerticalGlue());//Agrega espacio flexible después del JLabel
	        
        panelPrincipalHead.add(panelCerrarSesion, BorderLayout.EAST);//Ubica automáticamente a la derecha
	        
    	return panelPrincipalHead;
    }
	//*///panelPrincipalHead
    
    //Método para crear panelPrincipalMiddle
    public JPanel panelPrincipalMiddle() {
    	
        panelPrincipalMiddle = new JPanel();       
        //panelPrincipalMiddle.setBounds(40, 140, 1200, 80);
        panelPrincipalMiddle.setBackground(cyan);
        panelPrincipalMiddle.setOpaque(detalles);//Mostrar detalles
        
	        JLabel lblMisTableros = new JLabel("Mis Tableros");
	        lblMisTableros.setFont(new Font("Arial", Font.PLAIN, 30));//Cambia la letra del interior
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
    //*///panelPrincipalMiddle
    
    //Método para crear panelPrincipalBody
    public JPanel panelPrincipalBody() {
    	
        panelPrincipalBody = new JPanel();       
        panelPrincipalBody.setBackground(rosa);
        panelPrincipalBody.setOpaque(detalles);//Mostrar detalles

        panelPrincipalBody.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 150));  // Espacio entre los botones

        
        btnCrearTablero = new JButton("+");
        btnCrearTablero.setBackground(petroleo); 
        btnCrearTablero.setForeground(Color.WHITE);
    	btnCrearTablero.setFocusPainted(false);
    	btnCrearTablero.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
    	btnCrearTablero.setFont(new Font("Arial", Font.PLAIN, 80));//Cambia la letra del interior
    	//3 lineas para macOS:
    	btnCrearTablero.setOpaque(true);
		btnCrearTablero.setBorder(border);
		//Acción del botón:
		btnCrearTablero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                //IMPORTANTE -> Aquí se llama a un otro método que maneja el evento para poder llamarlo también desde el Controller.
            	ctrl.actionBtnCrearTablero(evento);
            }
        });
		btnCrearTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
   
    	
        btnAbrirTablero1 = new JButton("Abrir Tablero 1");
        btnAbrirTablero1.setBackground(petroleo); 
        btnAbrirTablero1.setForeground(Color.WHITE); 
        btnAbrirTablero1.setFocusPainted(false);
        btnAbrirTablero1.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
        btnAbrirTablero1.setFont(new Font("Inter", Font.BOLD, 18));//Cambia la letra del interior
        //2 lineas para macOS:
        btnAbrirTablero1.setOpaque(true);
		btnAbrirTablero1.setBorder(border);
		btnAbrirTablero1.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
        
        btnAbrirTablero2 = new JButton("Abrir Tablero 2");
        btnAbrirTablero2.setBackground(petroleo); 
        btnAbrirTablero2.setForeground(Color.WHITE); 
        btnAbrirTablero2.setFocusPainted(false);
        btnAbrirTablero2.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
        btnAbrirTablero2.setFont(new Font("Inter", Font.BOLD, 18));//Cambia la letra del interior
        //2 lineas para macOS:
        btnAbrirTablero2.setOpaque(true);
		btnAbrirTablero2.setBorder(border);
		btnAbrirTablero2.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
        
        btnAbrirTablero3 = new JButton("Abrir Tablero 3");
        btnAbrirTablero3.setBackground(petroleo); 
        btnAbrirTablero3.setForeground(Color.WHITE);
        btnAbrirTablero3.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
        btnAbrirTablero3.setFont(new Font("Inter", Font.BOLD, 18));//Cambia la letra del interior
        btnAbrirTablero3.setFocusPainted(false);
        //2 lineas para macOS:
        btnAbrirTablero3.setOpaque(true);
		btnAbrirTablero3.setBorder(border);
		btnAbrirTablero3.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita

        
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
    //*///panelPrincipalBody
    
    
    
    
    
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- //EMERGENTES// -- // -- //
	// -- // -- // -- // -- // -- // -- //
    
    //Método para crear ventana emergente crear tablero
    public static JDialog emergenteCrearTablero() {
    	//Emergente Crear Tablero
    	emergenteCrearTablero = new JDialog(framePrincipal, "Crear Tablero", true);//JDialog hace que framePrincipal no sea interactivo hasta que se cierre la emergente.
        emergenteCrearTablero.setSize(600, 300);//Tamaño
        emergenteCrearTablero.setBackground(blanco);
        emergenteCrearTablero.setResizable(false);//No permite modificar el tamaño
        emergenteCrearTablero.setLocationRelativeTo(framePrincipal);//Se centra según el framePrincipal
        emergenteCrearTablero.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Se cierra solo la emergente
        emergenteCrearTablero.setLayout(new BorderLayout());//Asegura usar BorderLayout
        
        //Panel Invisible
        panelInvisible.setFocusable(true);
        panelInvisible.setVisible(true);
        emergenteCrearTablero.add(panelInvisible);
        
        	//Label del Título
	        JLabel lblTituloCrearTablero = new JLabel("Crear Tablero");
	        lblTituloCrearTablero.setFont(new Font("Arial", Font.BOLD, 40));//Cambia la letra del interior
	        lblTituloCrearTablero.setForeground(limon2);//Color de la letra
	        lblTituloCrearTablero.setAlignmentX(Component.CENTER_ALIGNMENT);//Centra horizontalmente
	        lblTituloCrearTablero.setBackground(gris);//Color de fondo
	        lblTituloCrearTablero.setOpaque(detalles);//Mostrar detalles
	
		    	//Panel del Título
		        JPanel panelTituloCrearTablero = new JPanel();
		        panelTituloCrearTablero.setLayout(new BoxLayout(panelTituloCrearTablero, BoxLayout.Y_AXIS));//Se ordena verticalmente
		        panelTituloCrearTablero.setBackground(morado);//Color de fondo
		        panelTituloCrearTablero.setOpaque(detalles);//Mostrar detalles
		        panelTituloCrearTablero.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));// top, left, bottom, right -> Ajusta un borde por pixeles
		        panelTituloCrearTablero.add(Box.createVerticalGlue());//Agrega espacio flexible antes del JLabel
		        panelTituloCrearTablero.add(lblTituloCrearTablero);
		        panelTituloCrearTablero.add(Box.createVerticalGlue());//Agrega espacio flexible después del JLabel
	        
        emergenteCrearTablero.add(panelTituloCrearTablero, BorderLayout.NORTH);//Ubica arriba
        
	        //Panel Ingresar Nombre del tablero.
        	JPanel panelIngresarNombreTablero = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));//Usa FlowLayout: (alineación), (espacio horizontal entre los componentes), (espacio vertical entre las filas de componentes).
	        panelIngresarNombreTablero.setBackground(millos);//Color de fondo
	        panelIngresarNombreTablero.setOpaque(detalles);//Mostrar detalles
		        JLabel lblNombre = new JLabel("Nombre:");
		        lblNombre.setFont(new Font("Arial", Font.PLAIN, 20));//Cambia la letra del interior
		        txtFieldIngresarNombreEmergenteCrearTablero = new JTextField(mensajeIngresarNombreTablero);
		        txtFieldIngresarNombreEmergenteCrearTablero.setForeground(gris);
		        
		        //Placeholder "mensaje previo"
		        txtFieldIngresarNombreEmergenteCrearTablero.addFocusListener(new FocusListener() {
		            @Override
		            public void focusGained(FocusEvent e) {
		                if (txtFieldIngresarNombreEmergenteCrearTablero.getText().equals(mensajeIngresarNombreTablero)) {
		                	txtFieldIngresarNombreEmergenteCrearTablero.setText("");
		                	txtFieldIngresarNombreEmergenteCrearTablero.setForeground(negro);
		                }
		            }
		            @Override
		            public void focusLost(FocusEvent e) {
		                //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
		                if (txtFieldIngresarNombreEmergenteCrearTablero.getText().isEmpty()) {
		                	txtFieldIngresarNombreEmergenteCrearTablero.setForeground(gris);
		                	txtFieldIngresarNombreEmergenteCrearTablero.setText(mensajeIngresarNombreTablero);
		                }
		            }
		        });
		        //Placeholder
		        
		        txtFieldIngresarNombreEmergenteCrearTablero.setPreferredSize(new Dimension(400, 30));
		        txtFieldIngresarNombreEmergenteCrearTablero.setFont(new Font("Arial", Font.PLAIN, 20));//Tamaño del texto interno del txtField
		        txtFieldIngresarNombreEmergenteCrearTablero.setBackground(grisClaro);//Color de fondo
		        txtFieldIngresarNombreEmergenteCrearTablero.setOpaque(true);
		        txtFieldIngresarNombreEmergenteCrearTablero.setBorder(border);
		        txtFieldIngresarNombreEmergenteCrearTablero.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent evento) {
		            	//IMPORTANTE -> Aquí se llama a un método que maneja el evento desde el Controller.
		            	ctrl.actionEnterTxtFieldIngresarNombreEmergenteCrearTablero(evento);
		            }
		        });
		        txtFieldIngresarNombreEmergenteCrearTablero.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor modo escritura
		        
	        panelIngresarNombreTablero.add(lblNombre);
	        panelIngresarNombreTablero.add(Box.createVerticalStrut(10));//Espacio entre la etiqueta y el campo de texto
	        panelIngresarNombreTablero.add(txtFieldIngresarNombreEmergenteCrearTablero);
	        panelIngresarNombreTablero.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));// top, left, bottom, right -> Ajusta un borde por pixeles
	        
        emergenteCrearTablero.add(panelIngresarNombreTablero, BorderLayout.CENTER);//Ubica centro

	        //Panel Agregar Invitados
	        JPanel panelAgregarInvitados = new JPanel();
	        panelAgregarInvitados.setBackground(rosa);
	        panelAgregarInvitados.setOpaque(detalles);//Mostrar detalles
	        	btnAgregarInvitados = new JButton("Agregar Invitados");
	        	btnAgregarInvitados.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
	        	btnAgregarInvitados.setPreferredSize(new Dimension(200, 40));
	        	btnAgregarInvitados.setBackground(aguacate);//Color de fondo
	        	//2 lineas para macOS:
	        	btnAgregarInvitados.setOpaque(true);
	    		btnAgregarInvitados.setBorder(border);
	    		btnAgregarInvitados.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent evento) {
		            	//IMPORTANTE -> Aquí se llama a un método que maneja el evento desde el Controller.
		            	ctrl.actionBtnAgregarInvitados(evento);
		            }
		        });
	    		btnAgregarInvitados.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	    		
	        panelAgregarInvitados.add(btnAgregarInvitados);
	        panelAgregarInvitados.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	        //Panel Botones Básicos Emergente
	        JPanel panelBotonesBasicos = new JPanel(new BorderLayout());
	        panelBotonesBasicos.setBackground(cyan);//Color de fondo
	        panelBotonesBasicos.setOpaque(detalles);//Mostrar detalles
	        
		        btnCancelarEmergenteCrearTablero = new JButton("Cancelar");
		        btnCancelarEmergenteCrearTablero.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
		        btnCancelarEmergenteCrearTablero.setPreferredSize(new Dimension(200, 40));
		        btnCancelarEmergenteCrearTablero.setBackground(limon);//Color de fondo
		        //2 lineas para macOS:
		        btnCancelarEmergenteCrearTablero.setOpaque(true);
	    		btnCancelarEmergenteCrearTablero.setBorder(border);
	    		btnCancelarEmergenteCrearTablero.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent evento) {
		                //IMPORTANTE -> Aquí se llama a un método que maneja el evento desde el Controller.
		            	ctrl.actionBtnCancelarEmergenteCrearTablero(evento);
		            }
		        });
	    		btnCancelarEmergenteCrearTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	    		
		        btnCrearTableroEmergenteCrearTablero = new JButton("Crear Tablero");
		        btnCrearTableroEmergenteCrearTablero.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
		        btnCrearTableroEmergenteCrearTablero.setPreferredSize(new Dimension(200, 40));
		        btnCrearTableroEmergenteCrearTablero.setBackground(limon);//Color de fondo
		        //2 lineas para macOS:
		        btnCrearTableroEmergenteCrearTablero.setOpaque(true);
	    		btnCrearTableroEmergenteCrearTablero.setBorder(border);
	    		btnCrearTableroEmergenteCrearTablero.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent evento) {
		                //IMPORTANTE -> Aquí se llama a un método que maneja el evento desde el Controller.
		            	ctrl.actionEnterTxtFieldIngresarNombreEmergenteCrearTablero(evento);
		            }
		        });
	    		btnCrearTableroEmergenteCrearTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	    		
	        panelBotonesBasicos.add(btnCancelarEmergenteCrearTablero, BorderLayout.WEST);
	        panelBotonesBasicos.add(btnCrearTableroEmergenteCrearTablero, BorderLayout.EAST);
	        panelBotonesBasicos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));// top, left, bottom, right -> Ajusta un borde por pixeles

		        //Para que los botones cancelar y creat queden alineados, uso un panel extra abajo
		        JPanel panelInferior = new JPanel(new BorderLayout());
		        panelInferior.setBackground(blanco);//Color de fondo
		        panelInferior.setOpaque(detalles);//Mostrar detalles
		        panelInferior.add(panelAgregarInvitados, BorderLayout.NORTH);
		        panelInferior.add(panelBotonesBasicos, BorderLayout.SOUTH);

        emergenteCrearTablero.add(panelInferior, BorderLayout.SOUTH);
        
        emergenteCrearTablero.setVisible(true);
	    	
        return emergenteCrearTablero;
    }
    //*///emergenteCrearTablero
    
    //Método para crear ventana emergente agregar invitados
    public static JDialog emergenteAgregarInvitados() {
    	//Emergente Agregar Invitados
    	emergenteAgregarInvitados = new JDialog(framePrincipal, "Agregar Invitados", true);//JDialog hace que framePrincipal no sea interactivo hasta que se cierre la emergente.
    	emergenteAgregarInvitados.setSize(600, 300);//Tamaño
    	emergenteAgregarInvitados.setBackground(blanco);
        emergenteAgregarInvitados.setResizable(false);//No permite modificar el tamaño
        emergenteAgregarInvitados.setLocationRelativeTo(framePrincipal);//Se centra según el framePrincipal
        emergenteAgregarInvitados.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Se cierra solo la emergente
        emergenteAgregarInvitados.setLayout(new BorderLayout());//Asegura usar BorderLayout
        
        //Panel Invisible
        panelInvisible.setFocusable(true);
        panelInvisible.setVisible(true);
        emergenteAgregarInvitados.add(panelInvisible);
        
        emergenteAgregarInvitados.setVisible(true);
        
    	return emergenteAgregarInvitados;
    }
    //*///emergenteAgregarInvitados
    
    
    
    
    
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // GET & SET// -- // -- //
	// -- // -- // -- // -- // -- // -- //

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

	public static JPanel getPanelInvisible() {
		return panelInvisible;
	}

	public static void setPanelInvisible(JPanel panelInvisible) {
		Principal.panelInvisible = panelInvisible;
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

	public static Border getBorder() {
		return border;
	}

	public static void setBorder(Border border) {
		Principal.border = border;
	}

	public static boolean isDetalles() {
		return detalles;
	}

	public static void setDetalles(boolean detalles) {
		Principal.detalles = detalles;
	}

	public static JDialog getEmergenteCrearTablero() {
		return emergenteCrearTablero;
	}

	public static void setEmergenteCrearTablero(JDialog emergenteCrearTablero) {
		Principal.emergenteCrearTablero = emergenteCrearTablero;
	}

	public static String getMensajeIngresarNombreTablero() {
		return mensajeIngresarNombreTablero;
	}

	public static void setMensajeIngresarNombreTablero(String mensajeIngresarNombreTablero) {
		Principal.mensajeIngresarNombreTablero = mensajeIngresarNombreTablero;
	}

	public static JDialog getEmergenteAgregarInvitados() {
		return emergenteAgregarInvitados;
	}

	public static void setEmergenteAgregarInvitados(JDialog emergenteAgregarInvitados) {
		Principal.emergenteAgregarInvitados = emergenteAgregarInvitados;
	}
	
	
	
}
//class