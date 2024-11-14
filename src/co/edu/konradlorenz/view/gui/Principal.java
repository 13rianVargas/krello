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
	JPanel panelInvisible = new JPanel();//Este JPanel permite que el autofocus no sea el primer campo de texto.
	JPanel panelPrincipalHead;
	JPanel panelPrincipalMiddle;
	JPanel panelPrincipalBody;
	
	//TEXTFIELDS
	JTextField txtFieldIngresarNombreEmergenteCrearTablero;
	
	//PASSWORDFIELDS
	
	
	//BUTTONS
	JButton btnCrearTablero;
	JButton btnAbrirTablero1;
	JButton btnAbrirTablero2;
	JButton btnAbrirTablero3;
	JButton btnAgregarInvitados;
	JButton btnCancelarEmergenteCrearTablero;
	JButton btnCrearTableroEmergenteCrearTablero;
		
	//COLORS
	Color blanco = new Color(255, 255, 255);
	Color rosa = new Color(243, 178, 177);
	Color cyan = new Color(117, 251, 253);
	Color rojo = new Color(255, 0, 0);
	Color verde = new Color(117, 251, 76);
	Color millos = new Color(0, 0, 255);
	Color gris = new Color(154, 154, 154);
	Color grisClaro = new Color(217, 217, 217);
	Color aguacate = new Color(102, 181, 127);
	Color morado = new Color(98, 20, 109);
	Color negro = new Color(0, 0, 0);
	Color petroleo = new Color(0, 151, 149);
	Color limon = new Color(206, 220, 23);
	Color limon2 = new Color(180, 200, 0);//Para los títulos de las emergentes
	
	//BORDER
	Border border = BorderFactory.createLineBorder(negro, 1);//Borde de 1px

	//MOSTRAR DETALLES
	boolean detalles = false;//true -> mostrar / false -> ocultar
	
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
    //*/Principal
    
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
    //*/panelPrincipalHead
    
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
    //*/panelPrincipalMiddle
    
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
            	actionBtnCrearTablero(evento);
            }
        });
   
    	
        btnAbrirTablero1 = new JButton("Abrir Tablero 1");
        btnAbrirTablero1.setBackground(petroleo); 
        btnAbrirTablero1.setForeground(Color.WHITE); 
        btnAbrirTablero1.setFocusPainted(false);
        btnAbrirTablero1.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
        btnAbrirTablero1.setFont(new Font("Inter", Font.BOLD, 18));//Cambia la letra del interior
        //2 lineas para macOS:
        btnAbrirTablero1.setOpaque(true);
		btnAbrirTablero1.setBorder(border);
        
        btnAbrirTablero2 = new JButton("Abrir Tablero 2");
        btnAbrirTablero2.setBackground(petroleo); 
        btnAbrirTablero2.setForeground(Color.WHITE); 
        btnAbrirTablero2.setFocusPainted(false);
        btnAbrirTablero2.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
        btnAbrirTablero2.setFont(new Font("Inter", Font.BOLD, 18));//Cambia la letra del interior
        //2 lineas para macOS:
        btnAbrirTablero2.setOpaque(true);
		btnAbrirTablero2.setBorder(border);
        
        btnAbrirTablero3 = new JButton("Abrir Tablero 3");
        btnAbrirTablero3.setBackground(petroleo); 
        btnAbrirTablero3.setForeground(Color.WHITE);
        btnAbrirTablero3.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right -> Ajusta un borde por pixeles
        btnAbrirTablero3.setFont(new Font("Inter", Font.BOLD, 18));//Cambia la letra del interior
        btnAbrirTablero3.setFocusPainted(false);
        //2 lineas para macOS:
        btnAbrirTablero3.setOpaque(true);
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
    
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- //EMERGENTES// -- // -- //
	// -- // -- // -- // -- // -- // -- //
    
    //Método para crear ventana emergente crear tablero
    public JDialog emergenteCrearTablero() {
    	//Emergente Crear Tablero
    	JDialog emergenteCrearTablero = new JDialog(framePrincipal, "Crear Tablero", true);//JDialog hace que framePrincipal no sea interactivo hasta que se cierre la emergente.
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
		        txtFieldIngresarNombreEmergenteCrearTablero = new JTextField();
		        //TODO: Agregar mensaje previo.
		        
		        txtFieldIngresarNombreEmergenteCrearTablero.setPreferredSize(new Dimension(400, 30));
		        txtFieldIngresarNombreEmergenteCrearTablero.setFont(new Font("Arial", Font.PLAIN, 20));//Tamaño del texto interno del txtField
		        txtFieldIngresarNombreEmergenteCrearTablero.setBackground(grisClaro);//Color de fondo
		        txtFieldIngresarNombreEmergenteCrearTablero.setOpaque(true);
		        txtFieldIngresarNombreEmergenteCrearTablero.setBorder(border);
	    		//TODO: Agregar acción (Tomar datos del txtFieldIngresarNombreEmergenteCrearTablero y crear el tablero).
		        
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
	    		//TODO: Agregar acción (nueva ventana emergente para agregar invitados).
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
	    		//TODO: Agregar acción (Cerrar emergente)
	    		
		        btnCrearTableroEmergenteCrearTablero = new JButton("Crear Tablero");
		        btnCrearTableroEmergenteCrearTablero.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
		        btnCrearTableroEmergenteCrearTablero.setPreferredSize(new Dimension(200, 40));
		        btnCrearTableroEmergenteCrearTablero.setBackground(limon);//Color de fondo
		        //2 lineas para macOS:
		        btnCrearTableroEmergenteCrearTablero.setOpaque(true);
	    		btnCrearTableroEmergenteCrearTablero.setBorder(border);
	    		//TODO: Agregar acción (Tomar datos del txtFieldIngresarNombreEmergenteCrearTablero y crear el tablero).
	    		
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
    //*/emergenteCrearTablero
    
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // ACTIONS- // -- // -- //
	// -- // -- // -- // -- // -- // -- //
    
    //Método para gestionar la acción del btnCrearTablero
    public void actionBtnCrearTablero(ActionEvent evento) {                                             
    	emergenteCrearTablero();
    }
    //*/actionBtnCrearTablero
    
}
//class