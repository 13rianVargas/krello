package co.edu.konradlorenz.view.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import co.edu.konradlorenz.controller.*;

@SuppressWarnings("serial")
public class FrameTablero extends JFrame{
	
	//CONTROLADOR
	private static Controlador ctrl;
	
	//MOSTRAR DETALLES
	private static boolean detalles;

	//FRAMES
	private static JFrame frameTablero;
	
	//EMERGENTES
	private static JDialog emergenteCrearLista;
	private static JDialog emergenteEditarTablero;
	private static JDialog emergenteColaboradores;
	private static JDialog emergenteEliminar;
	private static JDialog emergenteEditarLista;
	private static JDialog emergenteEliminarLista;
	
	//PANELS 
    public static JPanel panelTableroContent;
	private static JPanel panelTableroHead;
	private static JPanel panelTableroMiddle;
	private static JPanel panelLista;
	
	//SCROLL PANEL
	public static JScrollPane panelTableroBody;
	
	//TEXTFIELDS
	private static JTextField txtFieldIngresarNombreEmergenteCrearLista;
	private static JTextField txtFieldIngresarNombreEmergenteEditarTablero;
	private static JTextField txtFieldIngresarCorreoEmergenteColaboradores;
	
	//BUTTONS
	private static JButton btnCrearLista;
	private static JButton btnCancelarEmergenteCrearLista;
	private static JButton btnCrearListaEmergenteCrearLista;
	private static JButton btnCancelarEmergenteEditarTablero;
	private static JButton btnGuardarEmergenteEditarTablero;
	private static JButton btnColaboradoresEmergenteEditarTablero;
	private static JButton btnEliminarEmergenteEditarTablero;
	private static JButton btnCancelarEmergenteColaboradores;
	private static JButton btnConfirmarEmergenteColaboradores;
	private static JButton btnCancelarEmergenteEliminar;
	private static JButton btnBorrarEmergenteEliminar;
	private static JButton btnPendientesListaEmergenteEditarLista;
	private static JButton btnMoverListaEmergenteEditarLista;
	private static JButton btnEliminarListaEmergenteEditarLista;
	private static JButton btnCancelarEmergenteEditarLista;
	private static JButton btnGuardarEmergenteEditarLista;
	private static JButton btnCancelarEmergenteEliminarLista;
	private static JButton btnBorrarEmergenteEliminarLista;
	
	//LABELS (Actuan como botón)
	private static JLabel lblEditarTablero;
	private static JLabel lblEditarLista;
	private static JLabel lblNuevaTarea;
	private static JLabel lblEditarTarea;
		
	//COLORS (Se crean en el Controller)
	private static Color negro;
	private static Color blanco;
	private static Color rojo;
	private static Color verde;
	private static Color millos;
	private static Color azulito;
	private static Color rosa;
	private static Color rosa2;
	private static Color cyan;
	private static Color cyan2;
	private static Color gris;
	private static Color gris2;
	private static Color morado;
	private static Color morado2;
	private static Color morado3;
	private static Color aguacate;
	private static Color petroleo;
	private static Color petroleo2;
	private static Color limon;
	private static Color limon2;
	private static Color limon3;

	//STRINGS
	private static String mensajeIngresarNombreLista = " Ingrese nombre de la lista...";
	private static String mensajeEditarNombreTablero = " Nombre ";
	private static String mensajeCorreoColaboradores = " Ingrese correo del colaborador...";
	
	
	
	
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // VENTANAS // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
    //Abre: Constructor del frame Tablero
 	public FrameTablero(Controlador controlador){
 		
 		//Inicializaciones que dependen del Controlador
    	ctrl = controlador;//Llama al controller del AplMain
    	detalles = ctrl.detalles;
    	negro = ctrl.negro;
    	blanco = ctrl.blanco;
    	rojo = ctrl.rojo;
    	verde = ctrl.verde;
    	millos = ctrl.millos;
    	azulito = ctrl.azulito;
    	rosa = ctrl.rosa;
    	rosa2 = ctrl.rosa2;
    	cyan = ctrl.cyan;
    	cyan2 = ctrl.cyan2;
    	gris = ctrl.gris;
    	gris2 = ctrl.gris2;
    	morado = ctrl.morado;
    	morado2 = ctrl.morado2;
    	morado3 = ctrl.morado3;
    	aguacate = ctrl.aguacate;
    	petroleo = ctrl.petroleo;
    	petroleo2 = ctrl.petroleo2;
    	limon = ctrl.limon;
    	limon2 = ctrl.limon2;
    	limon3 = ctrl.limon3;

    	//Aquí inicia el verdadero Constructor de la ventana
 		frameTablero = new JFrame();
		frameTablero.setDefaultCloseOperation(EXIT_ON_CLOSE); //Terminar la ejecución si se cierra la ventana
		String nombreTableroAbierto = ctrl.getNombreTableroAbierto();
		frameTablero.setTitle("Krello - " + nombreTableroAbierto);//Título de la ventana
		frameTablero.setSize(1280, 720);//ancho, alto
		frameTablero.setMinimumSize(new Dimension(1280, 720));//Tamaño mínimo al que se puede ajustar
		frameTablero.setLocationRelativeTo(null); //Centra la ventana
		frameTablero.setLayout(new BorderLayout());//Diseño
		frameTablero.setBackground(blanco);//Color de la barra de la ventana
		frameTablero.getContentPane().setBackground(blanco);//Color de fondo (solo ventanas)

			panelTableroHead = Principal.panelPrincipalHead();//Llama el head del Frame Principal
		
		frameTablero.add(panelTableroHead, BorderLayout.NORTH);//Lo añade y lo ubica arriba
		 
			panelTableroMiddle = panelTableroMiddle();//Crea el middle
		
		frameTablero.add(panelTableroMiddle, BorderLayout.CENTER);//Lo añade y lo ubica al centro
			
		frameTablero.setVisible(true); //IMPORTANTE -> Siempre dejar esto de últimas.
		
		SwingUtilities.invokeLater(() -> btnCrearLista.requestFocusInWindow());//Enfoca un componente específico al abrir la ventana
    }
	//Cierra: Constructor del frame Tablero
        
 	
 	
 	
 	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // PANELES  // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
	//Abre: Método para crear el panelTableroMiddle
    public static JPanel panelTableroMiddle() {
    	
    	panelTableroMiddle = new JPanel();//Crea nuevo
    	panelTableroMiddle.setLayout(new BorderLayout());//Diseño
    	panelTableroMiddle.setBorder(new EmptyBorder(0,20,20,20));//top, left, bottom, right -> Ajusta un borde por pixeles
    	panelTableroMiddle.setBackground(aguacate);//Color de fondo
    	panelTableroMiddle.setOpaque(detalles);//Mostrar detalles

	    	//Abre: panelSuperior
	    	JPanel panelSuperior = new JPanel();//Crea nuevo
	    	panelSuperior.setLayout(new BorderLayout());//Diseño
	    	panelSuperior.setBackground(gris);//Color de fondo
	    	panelSuperior.setOpaque(detalles);//Mostrar detalles
	    	
		    	//Abre: separator (Linea fea)
		        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
		        separador.setForeground(negro);//Color de letra
		        separador.setBorder(new EmptyBorder(0, 0, 0, 0));//top, left, bottom, right -> Ajusta un borde por pixeles
		        //Cierra: separator (Linea fea)
		        
	        panelSuperior.add(separador, BorderLayout.NORTH);//Añade separatorSuperior
	    	
	    		//Abre: panelTitulos
		    	JPanel panelTitulos = new JPanel();//Crea nuevo
		    	panelTitulos.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));//Diseño: Flujo a la izquierda (espacio horizontal),(espacio vertical)
		    	panelTitulos.setBackground(petroleo);//Color de fondo
		    	panelTitulos.setOpaque(detalles);//Mostrar detalles

	        
		        	//Abre: lblTituloTablero
		    		String nombreTablerto = ctrl.getNombreTableroAbierto(); 
			    	JLabel lblTituloTablero = new JLabel(nombreTablerto);//Crea nuevo
			    	lblTituloTablero.setFont(new Font("Calibri", Font.PLAIN, 24));//Cambia la letra del interior
			    	lblTituloTablero.setForeground(negro);//Color de letra
			    	lblTituloTablero.setBackground(verde);//Color de fondo
			    	lblTituloTablero.setOpaque(detalles);//Mostrar detalles
			    	//Cierra: lblTituloTablero
			    	
		    	panelTitulos.add(lblTituloTablero);//Añade lblTituloTablero
			    	
			    	//Abre: lblAdminTablero
		    		String nombreAdministrador = ctrl.getNombreAdministradorDeTableroAbierto();
			    	JLabel lblAdminTablero = new JLabel("Tablero de: " + nombreAdministrador);//Crea nuevo
			    	lblAdminTablero.setFont(new Font("Calibri", Font.ITALIC, 18));//Cambia la letra del interior
			    	lblAdminTablero.setForeground(gris);//Color de letra
			    	lblAdminTablero.setBackground(negro);//Color de fondo
			    	lblAdminTablero.setOpaque(detalles);//Mostrar detalles
			    	//Cierra: lblAdminTablero
	    	
		    	panelTitulos.add(lblAdminTablero);//Añade lblAdminTablero
		    	//Cierra: panelTitulos
	        
	        panelSuperior.add(panelTitulos, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
	    	
		        //Abre: panelBotones
		    	JPanel panelBotones = new JPanel();//Crea nuevo
		    	panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT,15, 0));//Diseño: Flujo a la derecha (espacio horizontal),(espacio vertical)
		    	panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));//top, left, bottom, right -> Ajusta un borde por pixeles
		    	panelBotones.setBackground(limon2);//Color de fondo
		    	panelBotones.setOpaque(detalles);//Mostrar detalles
		        
			    	//Abre: lblEditarTablero
			    	lblEditarTablero = new JLabel();//Crea nuevo
			    	lblEditarTablero.setBackground(blanco);//Color de fondo
			    	lblEditarTablero.setOpaque(detalles);//Mostrar detalles
			    	lblEditarTablero.setIcon(new ImageIcon(Principal.class.getResource("/co/edu/konradlorenz/view/img/Tuerca25x25.png")));//Ruta de la imagen
			    	lblEditarTablero.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
			    	lblEditarTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
			    	lblEditarTablero.setToolTipText("Editar Tablero");
			    	
			    		//Abrir: Acción del lblEditarTablero
			    		lblEditarTablero.addMouseListener(new MouseAdapter() {
			    			public void mouseClicked(MouseEvent e) {
			    				ctrl.actionLblEditarTablero();//Se llama el método del Controller que gestiona el evento.
			    			}
			    		});
			    		//Cierra: Acción del lblEditarTablero
			    		
			    	//Cierra: lblEditarTablero
			    	
		    	panelBotones.add(lblEditarTablero, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
			    	
			    	//Abre: btnCrearLista
			    	btnCrearLista = new JButton("Nueva Lista");//Crea nuevo
			    	btnCrearLista.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
			    	btnCrearLista.setBackground(cyan);//Color de fondo
			    	btnCrearLista.setForeground(cyan2);//Color de letra
			    	btnCrearLista.setFocusPainted(false);//Evita que se muestre un borde cuando el componente tiene el foco.
			    	btnCrearLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
			    	
			    		//Abrir: Acción del btnCrearLista
				    	btnCrearLista.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	ctrl.actionBtnCrearLista();//Se llama el método del Controller que gestiona el evento.
				            }
				        });
				    	//Cierra: Acción del btnCrearLista
				    	
			    	//Cierra: btnCrearLista
		    	
		        panelBotones.add(btnCrearLista, BorderLayout.EAST);//Lo añade y lo ubica a la derecha
		        
	        panelSuperior.add(panelBotones, BorderLayout.EAST);//Lo añade y lo ubica al centro
	    	//Cierra: panelSuperior
        
        panelTableroMiddle.add(panelSuperior, BorderLayout.NORTH);//Lo añade y lo ubica arriba
        
	        //Abre: panelIntermedio
	        JPanel panelIntermedio = new JPanel();//Crea nuevo
	        panelIntermedio.setLayout(new BorderLayout());//Diseño
	        panelIntermedio.setBackground(rojo);//Color de fondo
	        panelIntermedio.setOpaque(detalles);//Mostrar detalles
	        
	        	panelTableroBody();//Crea el panelTableroBody
	    	
	    	panelIntermedio.add(panelTableroBody, BorderLayout.CENTER);//Lo añade y lo ubica en el centro
	    	//Cierra: panelIntermedio
        
        panelTableroMiddle.add(panelIntermedio, BorderLayout.CENTER);//Lo añade y lo ubica abajo
    	
    	return panelTableroMiddle;
    }
    //Cierra: Método para crear el panelTableroMiddle
    
    //Abre: Método para crear el panelTableroBody
    public static void panelTableroBody() {
    	panelTableroContent = new JPanel();
        panelTableroContent.setBackground(gris2);
        panelTableroContent.setBorder(new EmptyBorder(5, 5,5, 5));//top, left, bottom, right -> Ajusta un borde por pixeles
        panelTableroContent.setBorder(BorderFactory.createLineBorder(gris, 3));
        panelTableroContent.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        
        panelTableroBody = new JScrollPane(panelTableroContent, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelTableroBody.setBorder(null); // Elimina el borde del JScrollPane
        panelTableroBody.getHorizontalScrollBar().setUnitIncrement(16); // Ajusta la velocidad del scroll
    }
    //Cierra: Método para crear el panelTableroBody
    
    //Abre: Método para crear el panelLista
	public static void panelLista() {
		
		JPanel panelLista = new JPanel();
		panelLista.setBackground(petroleo2);
		panelLista.setForeground(negro);
		panelLista.setFont(new Font("Calibri", Font.PLAIN, 80));
		panelLista.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelLista.setBorder(BorderFactory.createLineBorder(petroleo, 4));
		panelLista.setPreferredSize(new Dimension(280, 420)); //Tamaño fijo, no hay de otra
		panelLista.setAlignmentY(CENTER_ALIGNMENT);

			//Abre: panelSuperior
			JPanel panelSuperior = new JPanel();//Crea nuevo
			panelSuperior.setLayout(new BorderLayout()); // Diseño para ajustar los elementos
			panelSuperior.setBackground(rojo);//Color de fondo
			panelSuperior.setOpaque(detalles);//Mostrar detalles

				//Abre: panelTitulos
		    	JPanel panelTitulo = new JPanel();//Crea nuevo
		    	panelTitulo.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));//Diseño: Flujo a la izquierda
		    	panelTitulo.setBackground(rosa);//Color de fondo
		    	panelTitulo.setOpaque(detalles);//Mostrar detalles
		    	
				    String nombreLista  = ctrl.getNombreListaAbierta();
				    JLabel lblTitulo = new JLabel("• " + nombreLista);
				    lblTitulo.setFont(new Font("Calibri", Font.BOLD, 19));
				    lblTitulo.setForeground(blanco);
				    
			    panelTitulo.add(lblTitulo);
			    
		    panelSuperior.add(panelTitulo, BorderLayout.WEST);
		  
		    	//Abre: panelBotones
			    JPanel panelBotones = new JPanel();//Crea nuevo
			    panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));//Diseño: Flujo a la derecha
			    panelBotones.setBackground(verde);//Color de fondo
			    panelBotones.setOpaque(detalles);//Mostrar detalles
			    
			    	//Abre: lblNuevaTarea
				    lblNuevaTarea = new JLabel();//Crea nuevo
				    lblNuevaTarea.setBackground(negro);//Color de fondo
				    lblNuevaTarea.setOpaque(detalles);//Mostrar detalles
				    lblNuevaTarea.setIcon(new ImageIcon(Principal.class.getResource("/co/edu/konradlorenz/view/img/Mas25x25.png")));//Ruta de la imagen
				    lblNuevaTarea.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
				    lblNuevaTarea.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
				    lblNuevaTarea.setToolTipText("Nueva Tarea");
			    	
			    		//Abrir: Acción del lblNuevaTarea
			    		lblNuevaTarea.addMouseListener(new MouseAdapter() {
			    			public void mouseClicked(MouseEvent e) {
			    				//ctrl.actionLblEditarLista();//Se llama el método del Controller que gestiona el evento.
			    			}
			    		});
			    		//Cierra: Acción del lblNuevaTarea
			    		
			    	//Cierra: lblNuevaTarea
			    
		    	panelBotones.add(lblNuevaTarea);
			
			    	//Abre: lblEditarLista
			    	lblEditarLista = new JLabel();//Crea nuevo
			    	lblEditarLista.setBackground(blanco);//Color de fondo
			    	lblEditarLista.setOpaque(detalles);//Mostrar detalles
			    	lblEditarLista.setIcon(new ImageIcon(Principal.class.getResource("/co/edu/konradlorenz/view/img/Tuerca25x25.png")));//Ruta de la imagen
			    	lblEditarLista.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
			    	lblEditarLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
			    	lblEditarLista.setToolTipText("Editar Lista");
			    	
			    		//Abrir: Acción del lblEditarLista
			    		lblEditarTablero.addMouseListener(new MouseAdapter() {
			    			public void mouseClicked(MouseEvent e) {
			    				ctrl.actionLblEditarLista();//Se llama el método del Controller que gestiona el evento.
			    			}
			    		});
			    		//Cierra: Acción del lblEditarLista
			    		
			    	//Cierra: lblEditarLista
	
	    		panelBotones.add(lblEditarLista);
		    	//Cierra: panelBotones
		    		
			panelSuperior.add(panelBotones, BorderLayout.EAST);
			
			 	//Abre: panelFlexible
			    JPanel panelFlexible = new JPanel();
			    panelFlexible.setBackground(blanco);
			    panelFlexible.setOpaque(detalles); // No mostrar detalles
			    panelFlexible.setPreferredSize(new Dimension(270, 1)); // Máximo tamaño
			 	//Cierra: panelFlexible

		    panelSuperior.add(panelFlexible, BorderLayout.NORTH);//Añade el panelFlexible abajo
			//Cierra: panelSuperior

	    panelLista.add(panelSuperior, BorderLayout.NORTH);
		
	    panelTarea(panelLista); //Se utilizaria cuando se realice el evento boton crear tarea, pero lo dejo para que vean como quedo
	    panelTarea(panelLista); 
	    panelTarea(panelLista); 
	    panelTarea(panelLista);
	    panelTarea(panelLista); 
	    panelTarea(panelLista); 
	    panelTarea(panelLista);
	    panelTarea(panelLista);
	    panelTarea(panelLista);
	    panelTarea(panelLista);//TODO: Máximo 8 tareas o hacer un ScrollPanel para las tareas y añadirlas ahí.
	    
	    panelTableroContent.add(panelLista);//Añade el panelLista al panelTableroBody
	    
	    panelTableroContent.revalidate();//Recarga el panelTableroBody para que se muestre la lista nueva
	    panelTableroContent.repaint();
		   
	}
	// Cierra: Método para crear el panelLista
	
	// Abre: Método para crear el panelTarea
	public static void panelTarea(JPanel panelLista) {
		
	    JPanel panelTarea = new JPanel();
	    panelTarea.setLayout(new FlowLayout(FlowLayout.LEFT));//Diseño de flujo hacia la izquierda
	    panelTarea.setBackground(limon2);//Color de fondo
	    panelTarea.setBorder(BorderFactory.createLineBorder(limon3, 3));//Linea de borde

		    //Abrir: checkBoxTarea
		    JCheckBox checkBoxTarea = new JCheckBox();
		    //Cerrar: checkBoxTarea
		    
	    panelTarea.add(checkBoxTarea);//Añade checkBoxTarea

	    	//Abrir: lblNombreTarea
	    	String nombreTarea = "Test";//TODO: Agarrar lo del txtField de la emergente
		    JLabel lblNombreTarea = new JLabel(nombreTarea);
		    lblNombreTarea.setFont(new Font("Calibri", Font.PLAIN, 15));
		    lblNombreTarea.setForeground(negro);
	    	//Cerrar: lblNombreTarea
		    
	    panelTarea.add(lblNombreTarea);//Añade lblNombreTarea

		    //Abre: lblEditarTarea
		    lblEditarTarea = new JLabel();
		    lblEditarTarea.setBackground(blanco);//Color de fondo
		    lblEditarTarea.setOpaque(detalles);//Mostrar detalles
		    lblEditarTarea.setIcon(new ImageIcon(Principal.class.getResource("/co/edu/konradlorenz/view/img/Tuerca20x20.png")));//Ruta de la imagen
		    lblEditarTarea.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
		    lblEditarTarea.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		    lblEditarTarea.setToolTipText("Editar Tarea");
	    	
	    		//Abrir: Acción del lblEditarTarea
		    	lblEditarTarea.addMouseListener(new MouseAdapter() {
	    			public void mouseClicked(MouseEvent e) {
	    				//ctrl.actionLblEditarTarea();//Se llama el método del Controller que gestiona el evento.
	    			}
	    		});
	    		//Cierra: Acción del lblEditarTarea
	    
		    //Cierra: lblEditarTarea
		    	
	    panelTarea.add(Box.createHorizontalStrut(100)); //TODO: Creo que aquí va a tocar igual que el panelSuperior del panelLista, para que sea responsivo.

	    // Agregar el botón de editar después del espacio
	    panelTarea.add(lblEditarTarea);

	    // Añadir el panelTarea al panelLista en la sección central
	    panelLista.add(panelTarea, BorderLayout.CENTER);
	}
	// Cierra: Método para crear el panelTarea


   
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- //EMERGENTES// -- // -- //
	// -- // -- // -- // -- // -- // -- //
    
    //Abre: Método para crear la emergenteCrearLista
    public static void emergenteCrearLista() {
    	
    	//JDialog hace que solo la emergente sea interactiva, las demás ventanas se bloquean.
		emergenteCrearLista = new JDialog(frameTablero, "Crear Lista", true);//Crea nuevo (Dueño), (Título), (Bloquea interacción mientras esté abierta)
		emergenteCrearLista.setSize(600, 300);//Tamaño
		emergenteCrearLista.setBackground(morado3);//Color de la barra superior
		emergenteCrearLista.getContentPane().setBackground(blanco);//Color del fondo del frame
		emergenteCrearLista.setResizable(false);//No permite modificar el tamaño de la ventana
		emergenteCrearLista.setLocationRelativeTo(frameTablero);//Se centra según el framePrincipal
		emergenteCrearLista.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Se cierra al dar click en la X
		emergenteCrearLista.setLayout(new BorderLayout());//Diseño
		
		
    		//Abre: panelTituloCrearLista
	        JPanel panelTituloCrearLista = new JPanel();//Crea nuevo
	        panelTituloCrearLista.setLayout(new BoxLayout(panelTituloCrearLista, BoxLayout.Y_AXIS));//Diseño: El BoxLayout.Y_AXIS es para que se ubiquen VERTICALMENTE una encima de la otra.
	        panelTituloCrearLista.setBackground(morado);//Color de fondo
	        panelTituloCrearLista.setOpaque(detalles);//Mostrar detalles
	        panelTituloCrearLista.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));//top, left, bottom, right -> Ajusta un borde por pixeles

        		//Abre: lblTituloCrearLista
		        JLabel lblTituloCrearLista = new JLabel("Crear Lista");//Crea nuevo
		        lblTituloCrearLista.setFont(new Font("Calibri", Font.BOLD, 40));//Cambia la letra del interior
		        lblTituloCrearLista.setForeground(morado3);//Color de la letra
		        lblTituloCrearLista.setAlignmentX(Component.CENTER_ALIGNMENT);//Centra horizontalmente
		        lblTituloCrearLista.setBackground(gris);//Color de fondo
		        lblTituloCrearLista.setOpaque(detalles);//Mostrar detalles
        		//Cierra: lblTituloCrearLista
		        
	        panelTituloCrearLista.add(Box.createVerticalGlue());//Agrega espacio flexible antes del JLabel
	        panelTituloCrearLista.add(lblTituloCrearLista);//Añade lblTituloCrearLista
	        panelTituloCrearLista.add(Box.createVerticalGlue());//Agrega espacio flexible antes del JLabel
	    	//Cierra: panelTituloCrearLista
        
        emergenteCrearLista.add(panelTituloCrearLista, BorderLayout.NORTH);//Ubica arriba
        
	        //Abre: panelIngresarNombreLista
	    	JPanel panelIngresarNombreLista = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));//Diseño: Flujo Centrado (espacio horizontal),(espacio vertical)
	    	panelIngresarNombreLista.setBackground(millos);//Color de fondo
	    	panelIngresarNombreLista.setOpaque(detalles);//Mostrar detalles
		        
        		//Abre: lblNombre
	    		JLabel lblNombre = new JLabel("Nombre:");//Crea nuevo
		        lblNombre.setFont(new Font("Calibri", Font.PLAIN, 25));//Cambia la letra del interior
	        	//Cierra: lblNombre
		        
	        panelIngresarNombreLista.add(lblNombre);//Añade lblNombre
	        
	        	//Abre: txtFieldIngresarNombreEmergenteCrearLista
		        txtFieldIngresarNombreEmergenteCrearLista = new JTextField(mensajeIngresarNombreLista);//Crea nuevo
		        txtFieldIngresarNombreEmergenteCrearLista.setForeground(gris);//Color de letra
		        txtFieldIngresarNombreEmergenteCrearLista.setPreferredSize(new Dimension(400, 40));//Tamaño
		        txtFieldIngresarNombreEmergenteCrearLista.setFont(new Font("Calibri", Font.PLAIN, 20));//Cambia la letra del interior
		        txtFieldIngresarNombreEmergenteCrearLista.setBackground(gris2);//Color de fondo
		        txtFieldIngresarNombreEmergenteCrearLista.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor modo escritura
		        
		        	//Abre: Placeholder "mensaje previo"
		        	txtFieldIngresarNombreEmergenteCrearLista.addFocusListener(new FocusListener() {
			            @Override
			            public void focusGained(FocusEvent e) {
			                if (txtFieldIngresarNombreEmergenteCrearLista.getText().equals(mensajeIngresarNombreLista)) {
			                	txtFieldIngresarNombreEmergenteCrearLista.setText("");//Cambia el contenido del txtField
			                	txtFieldIngresarNombreEmergenteCrearLista.setForeground(negro);//Color de letra
			                }
			            }
			            @Override
			            public void focusLost(FocusEvent e) {
			                //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
			                if (txtFieldIngresarNombreEmergenteCrearLista.getText().isEmpty()) {
			                	txtFieldIngresarNombreEmergenteCrearLista.setText(mensajeIngresarNombreLista);//Cambia el contenido del txtField
			                	txtFieldIngresarNombreEmergenteCrearLista.setForeground(gris);//Color de letra
			                }
			            }
			        });
			        //Cierra: Placeholder "mensaje previo"
		        
			        //Abre: Acción del txtFieldIngresarNombreEmergenteCrearLista
			        txtFieldIngresarNombreEmergenteCrearLista.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.actionEnterTxtFieldIngresarNombreEmergenteCrearLista();//Se llama el método del Controller que gestiona el evento.
			            }
			        });
			        //Cierra: Acción del txtFieldIngresarNombreEmergenteCrearLista
		        
		        //Cierra: txtFieldIngresarNombreEmergenteCrearLista
		    
			panelIngresarNombreLista.add(txtFieldIngresarNombreEmergenteCrearLista);
		    panelIngresarNombreLista.add(Box.createVerticalStrut(10));//Espacio entre la etiqueta y el campo de texto
		    panelIngresarNombreLista.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));// top, left, bottom, right -> Ajusta un borde por pixeles
	        //Cierra: panelIngresarNombreLista
		    
	    emergenteCrearLista.add(panelIngresarNombreLista, BorderLayout.CENTER);//Ubica centro
        
	    	//Abre: panelInferior
	    	JPanel panelInferior = new JPanel(new BorderLayout());//Crea nuevo
	    	panelInferior.setBackground(cyan);//Color de fondo
	    	panelInferior.setOpaque(detalles);//Mostrar detalles
    
		        //Abre: panelBotonesBasicos
		        JPanel panelBotonesBasicos = new JPanel(new BorderLayout());
		        panelBotonesBasicos.setBackground(cyan);//Color de fondo
		        panelBotonesBasicos.setOpaque(detalles);//Mostrar detalles
	        
		        	//Abre: btnCancelarEmergenteCrearLista
			        btnCancelarEmergenteCrearLista = new JButton("Cancelar");//Crea nuevo
			        btnCancelarEmergenteCrearLista.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
			        btnCancelarEmergenteCrearLista.setPreferredSize(new Dimension(200, 40));//Tamaño botón
			        btnCancelarEmergenteCrearLista.setBackground(morado2);//Color de fondo
			        btnCancelarEmergenteCrearLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        
	    				//Abre: Acción del btnCancelarEmergenteCrearLista
				        btnCancelarEmergenteCrearLista.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	ctrl.actionBtnCancelarEmergenteCrearLista();//Se llama el método del Controller que gestiona el evento.
				            }
				        });
	    				//Cierra: Acción del btnCancelarEmergenteCrearLista
				        
				    //Cierra: btnCancelarEmergenteCrearLista
	    		
			        //Abre: btnCrearListaEmergenteCrearLista    
			        btnCrearListaEmergenteCrearLista = new JButton("Crear Lista");//Crea nuevo
			        btnCrearListaEmergenteCrearLista.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
			        btnCrearListaEmergenteCrearLista.setPreferredSize(new Dimension(200, 40));//Tamaño
			        btnCrearListaEmergenteCrearLista.setBackground(morado2);//Color de fondo
			        btnCrearListaEmergenteCrearLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        
			        	//Abre: Acción del btnCrearListaEmergenteCrearLista
			        	btnCrearListaEmergenteCrearLista.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	ctrl.actionEnterTxtFieldIngresarNombreEmergenteCrearLista();//Se llama el método del Controller que gestiona el evento.
				            }
				        });
						//Cierra: Acción del btnCrearListaEmergenteCrearLista
		        
			        //Cierra: btnCrearListaEmergenteCrearLista
	    		
		        panelBotonesBasicos.add(btnCancelarEmergenteCrearLista, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
		        panelBotonesBasicos.add(btnCrearListaEmergenteCrearLista, BorderLayout.EAST);//Lo añade y lo ubica a la derecha
		        panelBotonesBasicos.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));// top, left, bottom, right -> Ajusta un borde por pixeles
		        //Cierra: panelBotonesBasicos

	        panelInferior.add(panelBotonesBasicos, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
        	//Cierra: panelInferior

        emergenteCrearLista.add(panelInferior, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
        
        //Abre: Funcionalidad cambiar el foco automático al abrir la emergente
        txtFieldIngresarNombreEmergenteCrearLista.setEnabled(false);
        Timer timer = new Timer(100, e -> {
        	txtFieldIngresarNombreEmergenteCrearLista.setEnabled(true);
        });//Temporizador
        timer.setRepeats(false);//Evita que el temporizador se repita
        timer.start();//Inicia el temporizador
        //Cierra: Funcionalidad cambiar el foco automático al abrir la emergente
        
        emergenteCrearLista.setVisible(true);//Hace visible la emergente
        
        SwingUtilities.invokeLater(() -> btnCancelarEmergenteCrearLista.requestFocusInWindow());//Enfoca un componente específico al abrir la ventana
        
    }
    //Cierra: Método para crear la emergenteCrearLista
    
    //Abre: Método para crear emergenteEditarTablero
    public static void emergenteEditarTablero() {
    	
    	//JDialog hace que solo la emergente sea interactiva, las demás ventanas se bloquean.
    	emergenteEditarTablero = new JDialog(frameTablero, "Editar Tablero", true);//Crea nuevo (Dueño), (Título), (Bloquea interacción mientras esté abierta)
    	emergenteEditarTablero.setSize(600, 432);//Tamaño
    	emergenteEditarTablero.setBackground(blanco);//Color de fondo
    	emergenteEditarTablero.setResizable(false);//No permite modificar el tamaño de la ventana
    	emergenteEditarTablero.setLocationRelativeTo(frameTablero);//Se centra según el framePrincipal
    	emergenteEditarTablero.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Se cierra al dar click en la X
    	emergenteEditarTablero.setLayout(new BorderLayout());//Diseño
    	
    		//Abre: panelTituloEditarTablero
        	JPanel panelTituloEditarTablero = new JPanel();//Crea nuevo
        	panelTituloEditarTablero.setLayout(new BoxLayout(panelTituloEditarTablero, BoxLayout.Y_AXIS));//Diseño: El BoxLayout.Y_AXIS es para que se ubiquen VERTICALMENTE una encima de la otra.
        	panelTituloEditarTablero.setBackground(morado);//Color de fondo
        	panelTituloEditarTablero.setOpaque(detalles);//Mostrar detalles
        	panelTituloEditarTablero.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 30));//top, left, bottom, right -> Ajusta un borde por pixeles

    			//Abre: lblTituloEditarTablero
	        	JLabel lblTituloEditarTablero = new JLabel("Editar Tablero");//Crea nuevo
	        	lblTituloEditarTablero.setFont(new Font("Calibri", Font.BOLD, 40));//Cambia la letra del interior
	        	lblTituloEditarTablero.setForeground(limon2);//Color de la letra
	        	lblTituloEditarTablero.setAlignmentX(Component.CENTER_ALIGNMENT);//Centra horizontalmente
	        	lblTituloEditarTablero.setBackground(gris);//Color de fondo
	        	lblTituloEditarTablero.setOpaque(detalles);//Mostrar detalles
	        	//Cierra: lblTituloCrearLista
	        
        	panelTituloEditarTablero.add(lblTituloEditarTablero);
        	//Cierra: panelTituloEditarTablero
    
	    emergenteEditarTablero.add(panelTituloEditarTablero, BorderLayout.NORTH);//Ubica arriba
    	
	    
	    	//Abre: panelCentral
			JPanel panelCentral = new JPanel();//Crea nuevo
			panelCentral.setLayout(new BoxLayout(panelCentral ,BoxLayout.Y_AXIS));
			panelCentral.setBackground(blanco);//Color de fondo
			panelCentral.setOpaque(detalles);//Mostrar detalles
			
			
				//Abre: txtFieldIngresarNombreEmergenteEditarTablero
				txtFieldIngresarNombreEmergenteEditarTablero = new JTextField(mensajeEditarNombreTablero);//Crea nuevo
				txtFieldIngresarNombreEmergenteEditarTablero.setForeground(blanco);//Color de letra
				//txtFieldIngresarNombreEmergenteEditarTablero.setPreferredSize(new Dimension(198, 42));
				txtFieldIngresarNombreEmergenteEditarTablero.setHorizontalAlignment(JTextField.CENTER);
				txtFieldIngresarNombreEmergenteEditarTablero.setMaximumSize(new Dimension(250, 50));
				txtFieldIngresarNombreEmergenteEditarTablero.setFont(new Font("Calibri", Font.PLAIN, 20));//Cambia la letra del interior
				txtFieldIngresarNombreEmergenteEditarTablero.setBackground(morado3);//Color de fondo
				txtFieldIngresarNombreEmergenteEditarTablero.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor modo escritura
				txtFieldIngresarNombreEmergenteEditarTablero.setAlignmentX(Component.CENTER_ALIGNMENT);//lo centra???
				
			        //Abre: Placeholder "mensaje previo"
					txtFieldIngresarNombreEmergenteEditarTablero.addFocusListener(new FocusListener() {
			            @Override
			            public void focusGained(FocusEvent e) {
			                if (txtFieldIngresarNombreEmergenteEditarTablero.getText().equals(mensajeEditarNombreTablero)) {
			                	txtFieldIngresarNombreEmergenteEditarTablero.setText("");//Cambia el contenido del txtField
			                	txtFieldIngresarNombreEmergenteEditarTablero.setForeground(negro);//Color de letra
			                }
			            }
			            @Override
			            public void focusLost(FocusEvent e) {
			                //Si el campo de texto está vacío al perder el foco, restaura el placeholder
			                if (txtFieldIngresarNombreEmergenteEditarTablero.getText().isEmpty()) {
			                	txtFieldIngresarNombreEmergenteEditarTablero.setText(mensajeEditarNombreTablero);//Cambia el contenido del txtField
			                	txtFieldIngresarNombreEmergenteEditarTablero.setForeground(gris);//Color de letra
			                }
			            }
			        });
			        //Cierra: Placeholder "mensaje previo"
		        
			        //Abre: Acción del txtFieldIngresarNombreEmergenteCrearTablero
					txtFieldIngresarNombreEmergenteEditarTablero.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.txtFieldIngresarNombreEmergenteEditarTablero();//Se llama el método del Controller que gestiona el evento.
			            }
			        });
			        //Cierra: Acción del txtFieldIngresarNombreEmergenteCrearTablero
		        
		        //Cierra: txtFieldIngresarNombreEmergenteCrearTablero
				
				panelCentral.add(txtFieldIngresarNombreEmergenteEditarTablero, BorderLayout.NORTH);
				panelCentral.add(Box.createRigidArea(new Dimension(0, 20)));
				
				//Abre: btnColaboradoresEmergenteEditarTablero
				btnColaboradoresEmergenteEditarTablero = new JButton("Colaboradores");//Crea nuevo
				btnColaboradoresEmergenteEditarTablero.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
				//btnColaboradoresEmergenteEditarTablero.setPreferredSize(new Dimension(198, 42));//Tamaño botón
				btnColaboradoresEmergenteEditarTablero.setMaximumSize(new Dimension(250, 50));
				btnColaboradoresEmergenteEditarTablero.setBackground(rosa2);//Color de fondo
				btnColaboradoresEmergenteEditarTablero.setForeground(blanco);
				btnColaboradoresEmergenteEditarTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
				btnColaboradoresEmergenteEditarTablero.setAlignmentX(Component.CENTER_ALIGNMENT);//lo centra???
				
	        		//Abre: Acción del btnColaboradoresEmergenteEditarTablero
					btnColaboradoresEmergenteEditarTablero.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.actionBtnColaboradoresEmergenteEditarTablero();//Se llama el método del Controller que gestiona el evento.
			            }
			        });
	        		//Cierra: Acción del btnColaboradoresEmergenteEditarTablero
		    		
		    	//Cierra: btnColaboradoresEmergenteEditarTablero
		    		
				panelCentral.add(btnColaboradoresEmergenteEditarTablero, BorderLayout.CENTER);
				panelCentral.add(Box.createRigidArea(new Dimension(0, 20)));
	
				//Abre: btnEliminarEmergenteEditarTablero
				btnEliminarEmergenteEditarTablero = new JButton("Eliminar");//Crea nuevo
				btnEliminarEmergenteEditarTablero.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
				//btnEliminarEmergenteEditarTablero.setPreferredSize(new Dimension(198, 42));//Tamaño botón
				btnEliminarEmergenteEditarTablero.setMaximumSize(new Dimension(250, 50));
				btnEliminarEmergenteEditarTablero.setBackground(morado3);//Color de fondo
				btnEliminarEmergenteEditarTablero.setForeground(blanco);
				btnEliminarEmergenteEditarTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
				btnEliminarEmergenteEditarTablero.setAlignmentX(Component.CENTER_ALIGNMENT);//lo centra???
				
	        		//Abre: Acción del btnEliminarEmergenteEditarTablero
					btnEliminarEmergenteEditarTablero.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.actionBtnEliminarEmergenteEditarTablero();//Se llama el método del Controller que gestiona el evento.
			            }
			        });
	        		//Cierra: Acción del btnEliminarEmergenteEditarTablero
		    		
		    	//Cierra: btnEliminarEmergenteEditarTablero
		    		
				panelCentral.add(btnEliminarEmergenteEditarTablero, BorderLayout.SOUTH);
				panelCentral.add(Box.createRigidArea(new Dimension(0, 30)));
				
				//panelCentral.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));// top, left, bottom, right -> Ajusta un borde por pixeles

			//Cierra: panelCentral
			
		emergenteEditarTablero.add(panelCentral, BorderLayout.CENTER);//Lo añade y lo ubica abajo
		    
			
	    
	    	//Abre: panelInferior
    		JPanel panelInferior = new JPanel(new BorderLayout());//Crea nuevo
    		panelInferior.setBackground(blanco);//Color de fondo
    		panelInferior.setOpaque(detalles);//Mostrar detalles

	    		//Abre: panelBotonesBasicos
	    		JPanel panelBotonesBasicos = new JPanel(new BorderLayout());
	    		panelBotonesBasicos.setBackground(cyan);//Color de fondo
	    		panelBotonesBasicos.setOpaque(detalles);//Mostrar detalles
	    
	        		//Abre: btnCancelarEmergenteEditarTablero
		        	btnCancelarEmergenteEditarTablero = new JButton("Cancelar");//Crea nuevo
		        	btnCancelarEmergenteEditarTablero.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
		        	btnCancelarEmergenteEditarTablero.setPreferredSize(new Dimension(200, 40));//Tamaño botón
		        	btnCancelarEmergenteEditarTablero.setBackground(limon);//Color de fondo
		        	btnCancelarEmergenteEditarTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	        
						//Abre: Acción del btnCancelarEmergenteEditarTablero
			        	btnCancelarEmergenteEditarTablero.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	ctrl.actionBtnCancelarEmergenteEditarTablero();//Se llama el método del Controller que gestiona el evento.
				            }
				        });
						//Cierra: Acción del btnCancelarEmergenteEditarTablero
			        
		        	//Cierra: btnCancelarEmergenteEditarTablero
			
			        //Abre: btnEliminarEmergenteEditarTablero    
			        btnGuardarEmergenteEditarTablero = new JButton("Guardar");//Crea nuevo
			        btnGuardarEmergenteEditarTablero.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
			        btnGuardarEmergenteEditarTablero.setPreferredSize(new Dimension(200, 40));//Tamaño
			        btnGuardarEmergenteEditarTablero.setBackground(limon);//Color de fondo
			        btnGuardarEmergenteEditarTablero.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	        
			        	//Abre: Acción del btnCrearListaEmergenteCrearLista
				        btnGuardarEmergenteEditarTablero.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	//TODO:Crear método en el Controller
				            	//ctrl.GuardarEmergenteEditarTablero();//Se llama el método del Controller que gestiona el evento. 
				            }
				        });
						//Cierra: Acción del btnCrearListaEmergenteCrearLista
	        
			        //Cierra: btnGuardarEmergenteEditarTablero
			
		       	panelBotonesBasicos.add(btnCancelarEmergenteEditarTablero, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
		        panelBotonesBasicos.add(btnGuardarEmergenteEditarTablero, BorderLayout.EAST);//Lo añade y lo ubica a la derecha
		        panelBotonesBasicos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));// top, left, bottom, right -> Ajusta un borde por pixeles
		        //Cierra: panelBotonesBasicos

	        panelInferior.add(panelBotonesBasicos, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
	        //Cierra: panelInferior

	    emergenteEditarTablero.add(panelInferior, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
    
	    //Abre: Funcionalidad cambiar el foco automático al abrir la emergente
	    txtFieldIngresarNombreEmergenteEditarTablero.setEnabled(false);
	    Timer timer = new Timer(100, e -> {
	    	txtFieldIngresarNombreEmergenteEditarTablero.setEnabled(true);
	    });//Temporizador
	    timer.setRepeats(false);//Evita que el temporizador se repita
	    timer.start();//Inicia el temporizador
	    //Cierra: Funcionalidad cambiar el foco automático al abrir la emergente
    
	    emergenteEditarTablero.setVisible(true);//Hace visible la emergente
	    
	    SwingUtilities.invokeLater(() -> btnCancelarEmergenteEditarTablero.requestFocusInWindow());//Enfoca un componente específico al abrir la ventana
    }
    //Cierra: Método para crear emergenteEditarTablero
    
    //Abre: Método para crear emergenteColaboradores
    public static void emergenteColaboradores() {
    	
    	//JDialog hace que solo la emergente sea interactiva, las demás ventanas se bloquean.
    	emergenteColaboradores = new JDialog(frameTablero, "Editar Colaboradores", true);//Crea nuevo (Dueño), (Título), (Bloquea interacción mientras esté abierta)
    	emergenteColaboradores.setSize(600, 300);// (600, 432)Tamaño
    	emergenteColaboradores.setBackground(blanco);//Color de fondo
    	emergenteColaboradores.setResizable(false);//No permite modificar el tamaño de la ventana
    	emergenteColaboradores.setLocationRelativeTo(frameTablero);//Se centra según el framePrincipal
    	emergenteColaboradores.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Se cierra al dar click en la X
    	emergenteColaboradores.setLayout(new BorderLayout());//Diseño
    	
    		//Abre: panelTituloEditarColaboradores
        	JPanel panelTituloEditarColaboradores = new JPanel();//Crea nuevo
        	panelTituloEditarColaboradores.setLayout(new BoxLayout(panelTituloEditarColaboradores, BoxLayout.Y_AXIS));//Diseño: El BoxLayout.Y_AXIS es para que se ubiquen VERTICALMENTE una encima de la otra.
        	panelTituloEditarColaboradores.setBackground(morado);//Color de fondo
        	panelTituloEditarColaboradores.setOpaque(detalles);//Mostrar detalles
        	panelTituloEditarColaboradores.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 30));//top, left, bottom, right -> Ajusta un borde por pixeles

    			//Abre: lblTituloEditarColaboradores
	        	JLabel lblTituloEditarColaboradores = new JLabel("Colaboradores");//Crea nuevo
	        	lblTituloEditarColaboradores.setFont(new Font("Calibri", Font.BOLD, 40));//Cambia la letra del interior
	        	lblTituloEditarColaboradores.setForeground(limon2);//Color de la letra
	        	lblTituloEditarColaboradores.setAlignmentX(Component.CENTER_ALIGNMENT);//Centra horizontalmente
	        	lblTituloEditarColaboradores.setBackground(gris);//Color de fondo
	        	lblTituloEditarColaboradores.setOpaque(detalles);//Mostrar detalles
	        	//Cierra: lblTituloEditarColaboradores
	        
	        	panelTituloEditarColaboradores.add(lblTituloEditarColaboradores);
	        	//Cierra: panelTituloEditarColaboradores
    
	        emergenteColaboradores.add(panelTituloEditarColaboradores, BorderLayout.NORTH);//Ubica arriba
	        
	        
	        //Abre: panelCentral
			JPanel panelCentral = new JPanel();//Crea nuevo
			panelCentral.setLayout(new BoxLayout(panelCentral ,BoxLayout.Y_AXIS));
			panelCentral.setBackground(blanco);//Color de fondo
			panelCentral.setOpaque(detalles);//Mostrar detalles
			panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Margen interno
			//Cierra: panelCentral
			
			//TODO: Panel central de la emergente
			
				//Espaciado superior
				panelCentral.add(Box.createVerticalStrut(20));
			
				//Abre: txtFieldIngresarCorreoEmergenteColaboradores
				txtFieldIngresarCorreoEmergenteColaboradores = new JTextField(mensajeCorreoColaboradores);//Crea nuevo
				txtFieldIngresarCorreoEmergenteColaboradores.setForeground(gris);//Color de letra
				//txtFieldIngresarCorreoEmergenteColaboradores.setPreferredSize(new Dimension(198, 42));
				txtFieldIngresarCorreoEmergenteColaboradores.setHorizontalAlignment(JTextField.CENTER);
				txtFieldIngresarCorreoEmergenteColaboradores.setMaximumSize(new Dimension(400, 50));
				txtFieldIngresarCorreoEmergenteColaboradores.setFont(new Font("Calibri", Font.PLAIN, 20));//Cambia la letra del interior
				txtFieldIngresarCorreoEmergenteColaboradores.setBackground(gris2);//Color de fondo
				txtFieldIngresarCorreoEmergenteColaboradores.setBorder(BorderFactory.createLineBorder(gris, 2));//Color del borde
				txtFieldIngresarCorreoEmergenteColaboradores.setAlignmentX(Component.CENTER_ALIGNMENT); // Alineación
				txtFieldIngresarCorreoEmergenteColaboradores.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor modo escritura
				//txtFieldIngresarCorreoEmergenteColaboradores.setAlignmentX(Component.CENTER_ALIGNMENT);//lo centra???
				
			        //Abre: Placeholder "mensaje previo"
					txtFieldIngresarCorreoEmergenteColaboradores.addFocusListener(new FocusListener() {
			            @Override
			            public void focusGained(FocusEvent e) {
			                if (txtFieldIngresarCorreoEmergenteColaboradores.getText().equals(mensajeCorreoColaboradores)) {
			                	txtFieldIngresarCorreoEmergenteColaboradores.setText("");//Cambia el contenido del txtField
			                	txtFieldIngresarCorreoEmergenteColaboradores.setForeground(negro);//Color de letra
			                }
			            }
			            @Override
			            public void focusLost(FocusEvent e) {
			                //Si el campo de texto está vacío al perder el foco, restaura el placeholder
			                if (txtFieldIngresarCorreoEmergenteColaboradores.getText().isEmpty()) {
			                	txtFieldIngresarCorreoEmergenteColaboradores.setText(mensajeCorreoColaboradores);//Cambia el contenido del txtField
			                	txtFieldIngresarCorreoEmergenteColaboradores.setForeground(gris);//Color de letra
			                }
			            }
			        });
			        //Cierra: Placeholder "mensaje previo"
		        
			        //Abre: Acción del txtFieldIngresarCorreoEmergenteColaboradores
					txtFieldIngresarCorreoEmergenteColaboradores.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.txtFieldIngresarCorreoEmergenteColaboradores();//Se llama el método del Controller que gestiona el evento.
			            }
			        });
			        //Cierra: Acción del txtFieldIngresarCorreoEmergenteColaboradores
		        
		        //Cierra: txtFieldIngresarCorreoEmergenteColaboradores
				
				panelCentral.add(txtFieldIngresarCorreoEmergenteColaboradores);
				panelCentral.setBorder(BorderFactory.createEmptyBorder(15, 110, 15, 90));// top, left, bottom, right -> Ajusta un borde por pixeles
			
				//Espaciado inferior
				panelCentral.add(Box.createVerticalStrut(20));
				
			//Abre: panelInferior
    		JPanel panelInferior = new JPanel(new BorderLayout());//Crea nuevo
    		panelInferior.setBackground(blanco);//Color de fondo
    		panelInferior.setOpaque(detalles);//Mostrar detalles

	    		//Abre: panelBotonesBasicos
	    		JPanel panelBotonesBasicos = new JPanel(new BorderLayout());
	    		panelBotonesBasicos.setBackground(cyan);//Color de fondo
	    		panelBotonesBasicos.setOpaque(detalles);//Mostrar detalles
	    
	        		//Abre: btnCancelarEmergenteEditarTablero
		        	btnCancelarEmergenteColaboradores = new JButton("Cancelar");//Crea nuevo
		        	btnCancelarEmergenteColaboradores.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
		        	btnCancelarEmergenteColaboradores.setPreferredSize(new Dimension(200, 40));//Tamaño botón
		        	btnCancelarEmergenteColaboradores.setBackground(limon);//Color de fondo
		        	btnCancelarEmergenteColaboradores.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	        
						//Abre: Acción del btnCancelarEmergenteColaboradores
			        	btnCancelarEmergenteColaboradores.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	ctrl.actionBtnCancelarEmergenteColaboradores();//Se llama el método del Controller que gestiona el evento.
				            }
				        });
						//Cierra: Acción del btnCancelarEmergenteColaboradores
			        
		        	//Cierra: btnCancelarEmergenteColaboradores
			
			        //Abre: btnConfirmarEmergenteColaboradores    
		        	btnConfirmarEmergenteColaboradores = new JButton("Confirmar");//Crea nuevo
		        	btnConfirmarEmergenteColaboradores.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
		        	btnConfirmarEmergenteColaboradores.setPreferredSize(new Dimension(200, 40));//Tamaño
		        	btnConfirmarEmergenteColaboradores.setBackground(limon);//Color de fondo
		        	btnConfirmarEmergenteColaboradores.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	        
			        	//Abre: Acción del btnCrearListaEmergenteCrearLista
				        btnConfirmarEmergenteColaboradores.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	//TODO:Crear método en el Controller
				            	//ctrl.ConfirmarEmergenteColaboradores();//Se llama el método del Controller que gestiona el evento. 
				            }
				        });
						//Cierra: Acción del btnConfirmarEmergenteColaboradores
	        
			        //Cierra: btnConfirmarEmergenteColaboradores
			
		       	panelBotonesBasicos.add(btnCancelarEmergenteColaboradores, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
		        panelBotonesBasicos.add(btnConfirmarEmergenteColaboradores, BorderLayout.EAST);//Lo añade y lo ubica a la derecha
		        panelBotonesBasicos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));// top, left, bottom, right -> Ajusta un borde por pixeles
		        //Cierra: panelBotonesBasicos

	        panelInferior.add(panelBotonesBasicos, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
	        //Cierra: panelInferior
			
	        emergenteColaboradores.add(panelCentral, BorderLayout.CENTER);//Lo añade y lo ubica abajo
	        emergenteColaboradores.add(panelInferior, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
	        
		    //Abre: Funcionalidad cambiar el foco automático al abrir la emergente
	        txtFieldIngresarCorreoEmergenteColaboradores.setEnabled(false);
		    Timer timer = new Timer(100, e -> {
		    	txtFieldIngresarCorreoEmergenteColaboradores.setEnabled(true);
		    });//Temporizador
		    timer.setRepeats(false);//Evita que el temporizador se repita
		    timer.start();//Inicia el temporizador
		    //Cierra: Funcionalidad cambiar el foco automático al abrir la emergente
	    
	        emergenteColaboradores.setVisible(true);//Hace visible la emergente
    }
    //Cierra: Método para crear emergenteColaboradores

    //Abre: Método para crear emergenteEliminar
    public static void emergenteEliminar() {
    	
    	//JDialog hace que solo la emergente sea interactiva, las demás ventanas se bloquean.
    	emergenteEliminar = new JDialog(frameTablero, "Eliminar Tablero", true);//Crea nuevo (Dueño), (Título), (Bloquea interacción mientras esté abierta)
    	emergenteEliminar.setSize(600, 295);//Tamaño
    	emergenteEliminar.setBackground(blanco);//Color de fondo
    	emergenteEliminar.setResizable(false);//No permite modificar el tamaño de la ventana
    	emergenteEliminar.setLocationRelativeTo(frameTablero);//Se centra según el framePrincipal
    	emergenteEliminar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Se cierra al dar click en la X
    	emergenteEliminar.setLayout(new BorderLayout());//Diseño
    	
    		//Abre: panelTituloEliminarTablero
        	JPanel panelTituloEliminarTablero = new JPanel();//Crea nuevo
        	panelTituloEliminarTablero.setLayout(new BoxLayout(panelTituloEliminarTablero, BoxLayout.Y_AXIS));//Diseño: El BoxLayout.Y_AXIS es para que se ubiquen VERTICALMENTE una encima de la otra.
        	panelTituloEliminarTablero.setBackground(morado);//Color de fondo
        	panelTituloEliminarTablero.setOpaque(detalles);//Mostrar detalles
        	panelTituloEliminarTablero.setBorder(BorderFactory.createEmptyBorder(80, 20, 80, 20));//top, left, bottom, right -> Ajusta un borde por pixeles

    			//Abre: lblTituloEliminarTablero
	        	JLabel lblTituloEliminarTablero = new JLabel("¿Seguro desea borrar el tablero?");//Crea nuevo
	        	lblTituloEliminarTablero.setFont(new Font("Calibri", Font.BOLD, 30));//Cambia la letra del interior
	        	lblTituloEliminarTablero.setForeground(limon2);//Color de la letra
	        	lblTituloEliminarTablero.setAlignmentX(Component.CENTER_ALIGNMENT);//Centra horizontalmente
	        	lblTituloEliminarTablero.setBackground(gris);//Color de fondo
	        	lblTituloEliminarTablero.setOpaque(detalles);//Mostrar detalles
	        	//Cierra: lblTituloEliminarTablero
	        
        	panelTituloEliminarTablero.add(lblTituloEliminarTablero);
        	//Cierra: panelTituloEliminarTablero
    
	        emergenteEliminar.add(panelTituloEliminarTablero, BorderLayout.CENTER);//Ubica arriba
	        
	        //Abre: panelInferior
    		JPanel panelInferior = new JPanel(new BorderLayout());//Crea nuevo
    		panelInferior.setBackground(blanco);//Color de fondo
    		panelInferior.setOpaque(detalles);//Mostrar detalles

	    		//Abre: panelBotonesBasicos
	    		JPanel panelBotonesBasicos = new JPanel(new BorderLayout());
	    		panelBotonesBasicos.setBackground(cyan);//Color de fondo
	    		panelBotonesBasicos.setOpaque(detalles);//Mostrar detalles
	    
	        		//Abre: btnCancelarEmergenteEditarTablero
		        	btnCancelarEmergenteEliminar = new JButton("Cancelar");//Crea nuevo
		        	btnCancelarEmergenteEliminar.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
		        	btnCancelarEmergenteEliminar.setPreferredSize(new Dimension(200, 40));//Tamaño botón
		        	btnCancelarEmergenteEliminar.setBackground(limon);//Color de fondo
		        	btnCancelarEmergenteEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	        
						//Abre: Acción del btnCancelarEmergenteEliminar
			        	btnCancelarEmergenteEliminar.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	ctrl.actionBtnCancelarEmergenteEliminar();//Se llama el método del Controller que gestiona el evento.
				            }
				        });
						//Cierra: Acción del btnCancelarEmergenteEliminar
			        
			        //Cierra: btnCancelarEmergenteEliminar
			
			        //Abre: btnBorrarEmergenteEliminar    
		        	btnBorrarEmergenteEliminar = new JButton("Borrar");//Crea nuevo
		        	btnBorrarEmergenteEliminar.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
		        	btnBorrarEmergenteEliminar.setPreferredSize(new Dimension(200, 40));//Tamaño
		        	btnBorrarEmergenteEliminar.setBackground(rojo);//Color de fondo
		        	btnBorrarEmergenteEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	        
			        	//Abre: Acción del btnCrearListaEmergenteCrearLista
				        btnBorrarEmergenteEliminar.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	//TODO:Crear método en el Controller
				            	//ctrl.BorrarEmergenteEliminar();//Se llama el método del Controller que gestiona el evento. 
				            }
				        });
						//Cierra: Acción del btnBorrarEmergenteEliminar
	        
			        //Cierra: btnBorrarEmergenteEliminar
			
		       	panelBotonesBasicos.add(btnCancelarEmergenteEliminar, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
		        panelBotonesBasicos.add(btnBorrarEmergenteEliminar, BorderLayout.EAST);//Lo añade y lo ubica a la derecha
		        panelBotonesBasicos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));// top, left, bottom, right -> Ajusta un borde por pixeles
		        //Cierra: panelBotonesBasicos

	        panelInferior.add(panelBotonesBasicos, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
	        //Cierra: panelInferior
			
	        emergenteEliminar.add(panelInferior, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
	        
	        emergenteEliminar.setVisible(true);//Hace visible la emergente
    }
    //Cierra: Método para crear emergenteEliminar
    
  //Abre: Método para crear emergenteEditarLista
    public static void emergenteEditarLista() {
    	
    	//JDialog hace que solo la emergente sea interactiva, las demás ventanas se bloquean.
    	emergenteEditarLista = new JDialog(frameTablero, "Editar Lista", true);//Crea nuevo (Dueño), (Título), (Bloquea interacción mientras esté abierta)
    	emergenteEditarLista.setSize(600, 432);//Tamaño
    	emergenteEditarLista.setBackground(blanco);//Color de fondo
    	emergenteEditarLista.setResizable(false);//No permite modificar el tamaño de la ventana
    	emergenteEditarLista.setLocationRelativeTo(frameTablero);//Se centra según el framePrincipal
    	emergenteEditarLista.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Se cierra al dar click en la X
    	emergenteEditarLista.setLayout(new BorderLayout());//Diseño
    	
    		//Abre: panelTituloEditarLista
        	JPanel panelTituloEditarLista = new JPanel();//Crea nuevo
        	panelTituloEditarLista.setLayout(new BoxLayout(panelTituloEditarLista, BoxLayout.Y_AXIS));//Diseño: El BoxLayout.Y_AXIS es para que se ubiquen VERTICALMENTE una encima de la otra.
        	panelTituloEditarLista.setBackground(morado);//Color de fondo
        	panelTituloEditarLista.setOpaque(detalles);//Mostrar detalles
        	panelTituloEditarLista.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 30));//top, left, bottom, right -> Ajusta un borde por pixeles

    			//Abre: lblTituloEditarLista
	        	JLabel lblTituloEditarLista = new JLabel("Editar Lista");//Crea nuevo
	        	lblTituloEditarLista.setFont(new Font("Calibri", Font.BOLD, 40));//Cambia la letra del interior
	        	lblTituloEditarLista.setForeground(limon2);//Color de la letra
	        	lblTituloEditarLista.setAlignmentX(Component.CENTER_ALIGNMENT);//Centra horizontalmente
	        	lblTituloEditarLista.setBackground(gris);//Color de fondo
	        	lblTituloEditarLista.setOpaque(detalles);//Mostrar detalles
	        	//Cierra: lblTituloCrearLista
	        
	        panelTituloEditarLista.add(lblTituloEditarLista);
        	//Cierra: panelTituloEditarLista
    
	    emergenteEditarLista.add(panelTituloEditarLista, BorderLayout.NORTH);//Ubica arriba
    	
	    
	    	//Abre: panelCentral
			JPanel panelCentral = new JPanel();//Crea nuevo
			panelCentral.setLayout(new BoxLayout(panelCentral ,BoxLayout.Y_AXIS));
			panelCentral.setBackground(blanco);//Color de fondo
			panelCentral.setOpaque(detalles);//Mostrar detalles
			
			
				//Abre: btnPendientesListaEmergenteEditarLista
				btnPendientesListaEmergenteEditarLista = new JButton("Pendientes");//Crea nuevo
				btnPendientesListaEmergenteEditarLista.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
				//btnPendientesListaEmergenteEditarLista.setPreferredSize(new Dimension(198, 42));//Tamaño botón
				btnPendientesListaEmergenteEditarLista.setMaximumSize(new Dimension(250, 50));
				btnPendientesListaEmergenteEditarLista.setBackground(morado3);//Color de fondo
				btnPendientesListaEmergenteEditarLista.setForeground(blanco);
				btnPendientesListaEmergenteEditarLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
				btnPendientesListaEmergenteEditarLista.setAlignmentX(Component.CENTER_ALIGNMENT);//lo centra???
			
        			//Abre: Acción del btnPendientesListaEmergenteEditarLista
					btnPendientesListaEmergenteEditarLista.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evento) {
							//ctrl.actionBtnPendientesListaEmergenteEditarLista();//TODO: Se llama el método del Controller que gestiona el evento.
		            	}
		        	});
        			//Cierra: Acción del btnPendientesListaEmergenteEditarLista
	    		
				//Cierra: btnPendientesListaEmergenteEditarLista
	    		
				panelCentral.add(btnPendientesListaEmergenteEditarLista, BorderLayout.NORTH);
				panelCentral.add(Box.createRigidArea(new Dimension(0, 20)));
				
				//Abre: btnMoverListaEmergenteEditarLista
				btnMoverListaEmergenteEditarLista = new JButton("Mover Lista");//Crea nuevo
				btnMoverListaEmergenteEditarLista.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
				//btnMoverListaEmergenteEditarLista.setPreferredSize(new Dimension(198, 42));//Tamaño botón
				btnMoverListaEmergenteEditarLista.setMaximumSize(new Dimension(250, 50));
				btnMoverListaEmergenteEditarLista.setBackground(rosa2);//Color de fondo
				btnMoverListaEmergenteEditarLista.setForeground(blanco);
				btnMoverListaEmergenteEditarLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
				btnMoverListaEmergenteEditarLista.setAlignmentX(Component.CENTER_ALIGNMENT);//lo centra???
				
	        		//Abre: Acción del btnMoverListaEmergenteEditarLista
					btnMoverListaEmergenteEditarLista.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	//ctrl.actionBtnMoverListaEmergenteEditarLista();//TODO: Se llama el método del Controller que gestiona el evento.
			            }
			        });
	        		//Cierra: Acción del btnMoverListaEmergenteEditarLista
		    		
		    	//Cierra: btnMoverListaEmergenteEditarLista
		    		
				panelCentral.add(btnMoverListaEmergenteEditarLista, BorderLayout.CENTER);
				panelCentral.add(Box.createRigidArea(new Dimension(0, 20)));
	
				//Abre: btnEliminarListaEmergenteEditarLista
				btnEliminarListaEmergenteEditarLista = new JButton("Eliminar Lista");//Crea nuevo
				btnEliminarListaEmergenteEditarLista.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
				//btnEliminarListaEmergenteEditarLista.setPreferredSize(new Dimension(198, 42));//Tamaño botón
				btnEliminarListaEmergenteEditarLista.setMaximumSize(new Dimension(250, 50));
				btnEliminarListaEmergenteEditarLista.setBackground(morado3);//Color de fondo
				btnEliminarListaEmergenteEditarLista.setForeground(blanco);
				btnEliminarListaEmergenteEditarLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
				btnEliminarListaEmergenteEditarLista.setAlignmentX(Component.CENTER_ALIGNMENT);//lo centra???
				
	        		//Abre: Acción del btnEliminarListaEmergenteEditarLista
					btnEliminarListaEmergenteEditarLista.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.actionBtnEliminarListaEmergenteEditarLista();//Se llama el método del Controller que gestiona el evento.
			            }
			        });
	        		//Cierra: Acción del btnEliminarEmergenteEditarTablero
		    		
		    	//Cierra: btnEliminarListaEmergenteEditarLista
		    		
				panelCentral.add(btnEliminarListaEmergenteEditarLista, BorderLayout.SOUTH);
				panelCentral.add(Box.createRigidArea(new Dimension(0, 30)));
				
				//panelCentral.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));// top, left, bottom, right -> Ajusta un borde por pixeles

			//Cierra: panelCentral
			
		emergenteEditarLista.add(panelCentral, BorderLayout.CENTER);//Lo añade y lo ubica abajo
		    
			
	    
	    	//Abre: panelInferior
    		JPanel panelInferior = new JPanel(new BorderLayout());//Crea nuevo
    		panelInferior.setBackground(blanco);//Color de fondo
    		panelInferior.setOpaque(detalles);//Mostrar detalles

	    		//Abre: panelBotonesBasicos
	    		JPanel panelBotonesBasicos = new JPanel(new BorderLayout());
	    		panelBotonesBasicos.setBackground(cyan);//Color de fondo
	    		panelBotonesBasicos.setOpaque(detalles);//Mostrar detalles
	    
	        		//Abre: btnCancelarEmergenteEditarLista
	    			btnCancelarEmergenteEditarLista = new JButton("Cancelar");//Crea nuevo
	    			btnCancelarEmergenteEditarLista.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
	    			btnCancelarEmergenteEditarLista.setPreferredSize(new Dimension(200, 40));//Tamaño botón
	    			btnCancelarEmergenteEditarLista.setBackground(limon);//Color de fondo
	    			btnCancelarEmergenteEditarLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	        
						//Abre: Acción del btnCancelarEmergenteEditarLista
	    				btnCancelarEmergenteEditarLista.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	ctrl.actionBtnCancelarEmergenteEditarLista();//Se llama el método del Controller que gestiona el evento.
				            }
				        });
						//Cierra: Acción del btnCancelarEmergenteEditarLista
			        
		        	//Cierra: btnCancelarEmergenteEditarLista
			
			        //Abre: btnGuardarEmergenteEditarLista
	    			btnGuardarEmergenteEditarLista = new JButton("Guardar");//Crea nuevo
	    			btnGuardarEmergenteEditarLista.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
	    			btnGuardarEmergenteEditarLista.setPreferredSize(new Dimension(200, 40));//Tamaño
	    			btnGuardarEmergenteEditarLista.setBackground(limon);//Color de fondo
	    			btnGuardarEmergenteEditarLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	        
			        	//Abre: Acción del btnGuardarEmergenteEditarLista
	    				btnGuardarEmergenteEditarLista.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	//TODO:Crear método en el Controller
				            	//ctrl.GuardarEmergenteEditarLista();//Se llama el método del Controller que gestiona el evento. 
				            }
				        });
						//Cierra: Acción del btnGuardarEmergenteEditarLista
	        
			        //Cierra: btnGuardarEmergenteEditarLista
			
		       	panelBotonesBasicos.add(btnCancelarEmergenteEditarLista, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
		        panelBotonesBasicos.add(btnGuardarEmergenteEditarLista, BorderLayout.EAST);//Lo añade y lo ubica a la derecha
		        panelBotonesBasicos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));// top, left, bottom, right -> Ajusta un borde por pixeles
		        //Cierra: panelBotonesBasicos

	        panelInferior.add(panelBotonesBasicos, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
	        //Cierra: panelInferior

	    emergenteEditarLista.add(panelInferior, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
    
	    //Abre: Funcionalidad cambiar el foco automático al abrir la emergente
	    //txtFieldIngresarNombreEmergenteEditarTablero.setEnabled(false);
	    //Timer timer = new Timer(100, e -> {
	    	//txtFieldIngresarNombreEmergenteEditarTablero.setEnabled(true);
	    //});//Temporizador
	    //timer.setRepeats(false);//Evita que el temporizador se repita
	    //timer.start();//Inicia el temporizador
	    //Cierra: Funcionalidad cambiar el foco automático al abrir la emergente
    
	    emergenteEditarLista.setVisible(true);//Hace visible la emergente
	    
	    SwingUtilities.invokeLater(() -> btnCancelarEmergenteEditarLista.requestFocusInWindow());//Enfoca un componente específico al abrir la ventana
    }
    //Cierra: Método para crear emergenteEditarLista
    
  //Abre: Método para crear emergenteEliminarLista
    public static void emergenteEliminarLista() {
    	
    	//JDialog hace que solo la emergente sea interactiva, las demás ventanas se bloquean.
    	emergenteEliminarLista = new JDialog(frameTablero, "Eliminar Lista", true);//Crea nuevo (Dueño), (Título), (Bloquea interacción mientras esté abierta)
    	emergenteEliminarLista.setSize(600, 295);//Tamaño
    	emergenteEliminarLista.setBackground(blanco);//Color de fondo
    	emergenteEliminarLista.setResizable(false);//No permite modificar el tamaño de la ventana
    	emergenteEliminarLista.setLocationRelativeTo(frameTablero);//Se centra según el framePrincipal
    	emergenteEliminarLista.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Se cierra al dar click en la X
    	emergenteEliminarLista.setLayout(new BorderLayout());//Diseño
    	
    		//Abre: panelTituloEliminarLista
        	JPanel panelTituloEliminarLista = new JPanel();//Crea nuevo
        	panelTituloEliminarLista.setLayout(new BoxLayout(panelTituloEliminarLista, BoxLayout.Y_AXIS));//Diseño: El BoxLayout.Y_AXIS es para que se ubiquen VERTICALMENTE una encima de la otra.
        	panelTituloEliminarLista.setBackground(morado);//Color de fondo
        	panelTituloEliminarLista.setOpaque(detalles);//Mostrar detalles
        	panelTituloEliminarLista.setBorder(BorderFactory.createEmptyBorder(80, 20, 80, 20));//top, left, bottom, right -> Ajusta un borde por pixeles

    			//Abre: lblTituloEliminarLista
	        	JLabel lblTituloEliminarLista = new JLabel("¿Seguro desea borrar la lista?");//Crea nuevo
	        	lblTituloEliminarLista.setFont(new Font("Calibri", Font.BOLD, 30));//Cambia la letra del interior
	        	lblTituloEliminarLista.setForeground(limon2);//Color de la letra
	        	lblTituloEliminarLista.setAlignmentX(Component.CENTER_ALIGNMENT);//Centra horizontalmente
	        	lblTituloEliminarLista.setBackground(gris);//Color de fondo
	        	lblTituloEliminarLista.setOpaque(detalles);//Mostrar detalles
	        	//Cierra: lblTituloEliminarLista
	        
	        	panelTituloEliminarLista.add(lblTituloEliminarLista);
        	//Cierra: panelTituloEliminarLista
    
	        emergenteEliminar.add(panelTituloEliminarLista, BorderLayout.CENTER);//Ubica arriba
	        
	        //Abre: panelInferior
    		JPanel panelInferior = new JPanel(new BorderLayout());//Crea nuevo
    		panelInferior.setBackground(blanco);//Color de fondo
    		panelInferior.setOpaque(detalles);//Mostrar detalles

	    		//Abre: panelBotonesBasicos
	    		JPanel panelBotonesBasicos = new JPanel(new BorderLayout());
	    		panelBotonesBasicos.setBackground(cyan);//Color de fondo
	    		panelBotonesBasicos.setOpaque(detalles);//Mostrar detalles
	    
	        		//Abre: btnCancelarEmergenteEliminarLista
		        	btnCancelarEmergenteEliminarLista = new JButton("Cancelar");//Crea nuevo
		        	btnCancelarEmergenteEliminarLista.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
		        	btnCancelarEmergenteEliminarLista.setPreferredSize(new Dimension(200, 40));//Tamaño botón
		        	btnCancelarEmergenteEliminarLista.setBackground(limon);//Color de fondo
		        	btnCancelarEmergenteEliminarLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	        
						//Abre: Acción del btnCancelarEmergenteEliminarLista
		        		btnCancelarEmergenteEliminarLista.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	ctrl.actionBtnCancelarEmergenteEliminarLista();//Se llama el método del Controller que gestiona el evento.
				            }
				        });
						//Cierra: Acción del btnCancelarEmergenteEliminarLista
			        
			        //Cierra: btnCancelarEmergenteEliminarLista
			
			        //Abre: btnBorrarEmergenteEliminarLista    
			        btnBorrarEmergenteEliminarLista = new JButton("Borrar");//Crea nuevo
			        btnBorrarEmergenteEliminarLista.setFont(new Font("Calibri", Font.PLAIN, 18));//Cambia la letra del interior
			        btnBorrarEmergenteEliminarLista.setPreferredSize(new Dimension(200, 40));//Tamaño
			        btnBorrarEmergenteEliminarLista.setBackground(rojo);//Color de fondo
			        btnBorrarEmergenteEliminarLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
	        
			        	//Abre: Acción del btnBorrarEmergenteEliminarLista
				        btnBorrarEmergenteEliminarLista.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	//TODO:Crear método en el Controller
				            	//ctrl.BorrarEmergenteEliminarLista();//Se llama el método del Controller que gestiona el evento. 
				            }
				        });
						//Cierra: Acción del btnBorrarEmergenteEliminarLista
	        
			        //Cierra: btnBorrarEmergenteEliminarLista
			
		       	panelBotonesBasicos.add(btnCancelarEmergenteEliminarLista, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
		        panelBotonesBasicos.add(btnBorrarEmergenteEliminarLista, BorderLayout.EAST);//Lo añade y lo ubica a la derecha
		        panelBotonesBasicos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));// top, left, bottom, right -> Ajusta un borde por pixeles
		        //Cierra: panelBotonesBasicos

	        panelInferior.add(panelBotonesBasicos, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
	        //Cierra: panelInferior
			
	        emergenteEliminarLista.add(panelInferior, BorderLayout.SOUTH);//Lo añade y lo ubica abajo
	        
	        emergenteEliminarLista.setVisible(true);//Hace visible la emergente
    }
    //Cierra: Método para crear emergenteEliminar
    
    
    
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // GET & SET// -- // -- //
	// -- // -- // -- // -- // -- // -- //

	public static Controlador getCtrl() {
		return ctrl;
	}

	public static void setCtrl(Controlador ctrl) {
		FrameTablero.ctrl = ctrl;
	}

	public static boolean isDetalles() {
		return detalles;
	}

	public static void setDetalles(boolean detalles) {
		FrameTablero.detalles = detalles;
	}

	public static JFrame getFrameTablero() {
		return frameTablero;
	}

	public static void setFrameTablero(JFrame frameTablero) {
		FrameTablero.frameTablero = frameTablero;
	}

	public static JDialog getEmergenteCrearLista() {
		return emergenteCrearLista;
	}

	public static void setEmergenteCrearLista(JDialog emergenteCrearLista) {
		FrameTablero.emergenteCrearLista = emergenteCrearLista;
	}

	public static JDialog getEmergenteEditarTablero() {
		return emergenteEditarTablero;
	}

	public static void setEmergenteEditarTablero(JDialog emergenteEditarTablero) {
		FrameTablero.emergenteEditarTablero = emergenteEditarTablero;
	}

	public static JDialog getEmergenteColaboradores() {
		return emergenteColaboradores;
	}

	public static void setEmergenteColaboradores(JDialog emergenteColaboradores) {
		FrameTablero.emergenteColaboradores = emergenteColaboradores;
	}

	public static JDialog getEmergenteEliminar() {
		return emergenteEliminar;
	}

	public static void setEmergenteEliminar(JDialog emergenteEliminar) {
		FrameTablero.emergenteEliminar = emergenteEliminar;
	}

	public static JDialog getEmergenteEditarLista() {
		return emergenteEditarLista;
	}

	public static void setEmergenteEditarLista(JDialog emergenteEditarLista) {
		FrameTablero.emergenteEditarLista = emergenteEditarLista;
	}

	public static JDialog getEmergenteEliminarLista() {
		return emergenteEliminarLista;
	}

	public static void setEmergenteEliminarLista(JDialog emergenteEliminarLista) {
		FrameTablero.emergenteEliminarLista = emergenteEliminarLista;
	}

	public static JPanel getPanelTableroContent() {
		return panelTableroContent;
	}

	public static void setPanelTableroContent(JPanel panelTableroContent) {
		FrameTablero.panelTableroContent = panelTableroContent;
	}

	public static JPanel getPanelTableroHead() {
		return panelTableroHead;
	}

	public static void setPanelTableroHead(JPanel panelTableroHead) {
		FrameTablero.panelTableroHead = panelTableroHead;
	}

	public static JPanel getPanelTableroMiddle() {
		return panelTableroMiddle;
	}

	public static void setPanelTableroMiddle(JPanel panelTableroMiddle) {
		FrameTablero.panelTableroMiddle = panelTableroMiddle;
	}

	public static JPanel getPanelLista() {
		return panelLista;
	}

	public static void setPanelLista(JPanel panelLista) {
		FrameTablero.panelLista = panelLista;
	}

	public static JScrollPane getPanelTableroBody() {
		return panelTableroBody;
	}

	public static void setPanelTableroBody(JScrollPane panelTableroBody) {
		FrameTablero.panelTableroBody = panelTableroBody;
	}

	public static JTextField getTxtFieldIngresarNombreEmergenteCrearLista() {
		return txtFieldIngresarNombreEmergenteCrearLista;
	}

	public static void setTxtFieldIngresarNombreEmergenteCrearLista(
			JTextField txtFieldIngresarNombreEmergenteCrearLista) {
		FrameTablero.txtFieldIngresarNombreEmergenteCrearLista = txtFieldIngresarNombreEmergenteCrearLista;
	}

	public static JTextField getTxtFieldIngresarNombreEmergenteEditarTablero() {
		return txtFieldIngresarNombreEmergenteEditarTablero;
	}

	public static void setTxtFieldIngresarNombreEmergenteEditarTablero(
			JTextField txtFieldIngresarNombreEmergenteEditarTablero) {
		FrameTablero.txtFieldIngresarNombreEmergenteEditarTablero = txtFieldIngresarNombreEmergenteEditarTablero;
	}

	public static JTextField getTxtFieldIngresarCorreoEmergenteColaboradores() {
		return txtFieldIngresarCorreoEmergenteColaboradores;
	}

	public static void setTxtFieldIngresarCorreoEmergenteColaboradores(
			JTextField txtFieldIngresarCorreoEmergenteColaboradores) {
		FrameTablero.txtFieldIngresarCorreoEmergenteColaboradores = txtFieldIngresarCorreoEmergenteColaboradores;
	}

	public static JButton getBtnCrearLista() {
		return btnCrearLista;
	}

	public static void setBtnCrearLista(JButton btnCrearLista) {
		FrameTablero.btnCrearLista = btnCrearLista;
	}

	public static JButton getBtnCancelarEmergenteCrearLista() {
		return btnCancelarEmergenteCrearLista;
	}

	public static void setBtnCancelarEmergenteCrearLista(JButton btnCancelarEmergenteCrearLista) {
		FrameTablero.btnCancelarEmergenteCrearLista = btnCancelarEmergenteCrearLista;
	}

	public static JButton getBtnCrearListaEmergenteCrearLista() {
		return btnCrearListaEmergenteCrearLista;
	}

	public static void setBtnCrearListaEmergenteCrearLista(JButton btnCrearListaEmergenteCrearLista) {
		FrameTablero.btnCrearListaEmergenteCrearLista = btnCrearListaEmergenteCrearLista;
	}

	public static JButton getBtnCancelarEmergenteEditarTablero() {
		return btnCancelarEmergenteEditarTablero;
	}

	public static void setBtnCancelarEmergenteEditarTablero(JButton btnCancelarEmergenteEditarTablero) {
		FrameTablero.btnCancelarEmergenteEditarTablero = btnCancelarEmergenteEditarTablero;
	}

	public static JButton getBtnGuardarEmergenteEditarTablero() {
		return btnGuardarEmergenteEditarTablero;
	}

	public static void setBtnGuardarEmergenteEditarTablero(JButton btnGuardarEmergenteEditarTablero) {
		FrameTablero.btnGuardarEmergenteEditarTablero = btnGuardarEmergenteEditarTablero;
	}

	public static JButton getBtnColaboradoresEmergenteEditarTablero() {
		return btnColaboradoresEmergenteEditarTablero;
	}

	public static void setBtnColaboradoresEmergenteEditarTablero(JButton btnColaboradoresEmergenteEditarTablero) {
		FrameTablero.btnColaboradoresEmergenteEditarTablero = btnColaboradoresEmergenteEditarTablero;
	}

	public static JButton getBtnEliminarEmergenteEditarTablero() {
		return btnEliminarEmergenteEditarTablero;
	}

	public static void setBtnEliminarEmergenteEditarTablero(JButton btnEliminarEmergenteEditarTablero) {
		FrameTablero.btnEliminarEmergenteEditarTablero = btnEliminarEmergenteEditarTablero;
	}

	public static JButton getBtnCancelarEmergenteColaboradores() {
		return btnCancelarEmergenteColaboradores;
	}

	public static void setBtnCancelarEmergenteColaboradores(JButton btnCancelarEmergenteColaboradores) {
		FrameTablero.btnCancelarEmergenteColaboradores = btnCancelarEmergenteColaboradores;
	}

	public static JButton getBtnConfirmarEmergenteColaboradores() {
		return btnConfirmarEmergenteColaboradores;
	}

	public static void setBtnConfirmarEmergenteColaboradores(JButton btnConfirmarEmergenteColaboradores) {
		FrameTablero.btnConfirmarEmergenteColaboradores = btnConfirmarEmergenteColaboradores;
	}

	public static JButton getBtnCancelarEmergenteEliminar() {
		return btnCancelarEmergenteEliminar;
	}

	public static void setBtnCancelarEmergenteEliminar(JButton btnCancelarEmergenteEliminar) {
		FrameTablero.btnCancelarEmergenteEliminar = btnCancelarEmergenteEliminar;
	}

	public static JButton getBtnBorrarEmergenteEliminar() {
		return btnBorrarEmergenteEliminar;
	}

	public static void setBtnBorrarEmergenteEliminar(JButton btnBorrarEmergenteEliminar) {
		FrameTablero.btnBorrarEmergenteEliminar = btnBorrarEmergenteEliminar;
	}

	public static JLabel getLblEditarTablero() {
		return lblEditarTablero;
	}

	public static void setLblEditarTablero(JLabel lblEditarTablero) {
		FrameTablero.lblEditarTablero = lblEditarTablero;
	}

	public static JLabel getLblEditarLista() {
		return lblEditarLista;
	}

	public static void setLblEditarLista(JLabel lblEditarLista) {
		FrameTablero.lblEditarLista = lblEditarLista;
	}

	public static JLabel getLblNuevaTarea() {
		return lblNuevaTarea;
	}

	public static void setLblNuevaTarea(JLabel lblNuevaTarea) {
		FrameTablero.lblNuevaTarea = lblNuevaTarea;
	}

	public static JLabel getLblEditarTarea() {
		return lblEditarTarea;
	}

	public static void setLblEditarTarea(JLabel lblEditarTarea) {
		FrameTablero.lblEditarTarea = lblEditarTarea;
	}

	public static Color getNegro() {
		return negro;
	}

	public static void setNegro(Color negro) {
		FrameTablero.negro = negro;
	}

	public static Color getBlanco() {
		return blanco;
	}

	public static void setBlanco(Color blanco) {
		FrameTablero.blanco = blanco;
	}

	public static Color getRojo() {
		return rojo;
	}

	public static void setRojo(Color rojo) {
		FrameTablero.rojo = rojo;
	}

	public static Color getVerde() {
		return verde;
	}

	public static void setVerde(Color verde) {
		FrameTablero.verde = verde;
	}

	public static Color getMillos() {
		return millos;
	}

	public static void setMillos(Color millos) {
		FrameTablero.millos = millos;
	}

	public static Color getAzulito() {
		return azulito;
	}

	public static void setAzulito(Color azulito) {
		FrameTablero.azulito = azulito;
	}

	public static Color getRosa() {
		return rosa;
	}

	public static void setRosa(Color rosa) {
		FrameTablero.rosa = rosa;
	}

	public static Color getRosa2() {
		return rosa2;
	}

	public static void setRosa2(Color rosa2) {
		FrameTablero.rosa2 = rosa2;
	}

	public static Color getCyan() {
		return cyan;
	}

	public static void setCyan(Color cyan) {
		FrameTablero.cyan = cyan;
	}

	public static Color getCyan2() {
		return cyan2;
	}

	public static void setCyan2(Color cyan2) {
		FrameTablero.cyan2 = cyan2;
	}

	public static Color getGris() {
		return gris;
	}

	public static void setGris(Color gris) {
		FrameTablero.gris = gris;
	}

	public static Color getGris2() {
		return gris2;
	}

	public static void setGris2(Color gris2) {
		FrameTablero.gris2 = gris2;
	}

	public static Color getMorado() {
		return morado;
	}

	public static void setMorado(Color morado) {
		FrameTablero.morado = morado;
	}

	public static Color getMorado2() {
		return morado2;
	}

	public static void setMorado2(Color morado2) {
		FrameTablero.morado2 = morado2;
	}

	public static Color getMorado3() {
		return morado3;
	}

	public static void setMorado3(Color morado3) {
		FrameTablero.morado3 = morado3;
	}

	public static Color getAguacate() {
		return aguacate;
	}

	public static void setAguacate(Color aguacate) {
		FrameTablero.aguacate = aguacate;
	}

	public static Color getPetroleo() {
		return petroleo;
	}

	public static void setPetroleo(Color petroleo) {
		FrameTablero.petroleo = petroleo;
	}

	public static Color getPetroleo2() {
		return petroleo2;
	}

	public static void setPetroleo2(Color petroleo2) {
		FrameTablero.petroleo2 = petroleo2;
	}

	public static Color getLimon() {
		return limon;
	}

	public static void setLimon(Color limon) {
		FrameTablero.limon = limon;
	}

	public static Color getLimon2() {
		return limon2;
	}

	public static void setLimon2(Color limon2) {
		FrameTablero.limon2 = limon2;
	}

	public static Color getLimon3() {
		return limon3;
	}

	public static void setLimon3(Color limon3) {
		FrameTablero.limon3 = limon3;
	}

	public static String getMensajeIngresarNombreLista() {
		return mensajeIngresarNombreLista;
	}

	public static void setMensajeIngresarNombreLista(String mensajeIngresarNombreLista) {
		FrameTablero.mensajeIngresarNombreLista = mensajeIngresarNombreLista;
	}

	public static String getMensajeEditarNombreTablero() {
		return mensajeEditarNombreTablero;
	}

	public static void setMensajeEditarNombreTablero(String mensajeEditarNombreTablero) {
		FrameTablero.mensajeEditarNombreTablero = mensajeEditarNombreTablero;
	}

	public static String getMensajeCorreoColaboradores() {
		return mensajeCorreoColaboradores;
	}

	public static void setMensajeCorreoColaboradores(String mensajeCorreoColaboradores) {
		FrameTablero.mensajeCorreoColaboradores = mensajeCorreoColaboradores;
	}

}    
//class