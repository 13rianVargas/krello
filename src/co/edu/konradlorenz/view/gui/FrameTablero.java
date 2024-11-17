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
	
	//PANELS 

    public static JPanel panelTableroContent; 
	private static JPanel panelTableroHead;
	private static JPanel panelTableroMiddle;
	private static JPanel panelLista;
	
	//SCROLL PANEL
	public static JScrollPane panelTableroBody; // Lo cambie a JScrollPane antes era panel
	
	//TEXTFIELDS
	private static JTextField txtFieldIngresarNombreEmergenteCrearLista;
	private static JTextField txtFieldIngresarNombreEmergenteEditarTablero;
	private static JTextField txtFieldIngresarCorreoEmergenteColaboradores;
	
	//PASSWORDFIELDS
	
	
	//BUTTONS
	private static JButton btnCrearLista;
	private static JButton btnEditarTablero;
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
	private static Color petroleoOscuro = new Color(83, 181, 179);
	private static Color limon = new Color(206, 220, 23);
	private static Color limon2 = new Color(180, 200, 0);//Para los títulos de las emergentes
	private static Color rosita = new Color(235, 116, 116);
	private static Color moradito = new Color(161, 114, 167);
	
	//BORDER macOS
	private static Border macOSBorde = BorderFactory.createLineBorder(negro, 1);//Borde de 1px para mac :)

	//STRINGS
	private static String mensajeIngresarNombreLista = " Ingrese nombre de la lista...";
	private static String mensajeEditarNombreTablero = " Nombre ";
	private static String mensajeCorreoColaboradores = " Ingrese correo del colaborador ";
	
	
	
	
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // VENTANAS // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
    //Abre: Constructor del frame Tablero
 	public FrameTablero(Controlador controlador){
 		
    	ctrl = controlador;//Llama al controller del AplMain
    	detalles = ctrl.detalles;//Ahora se cambia en el Controller para que actue en todo el GUI.

 		frameTablero = new JFrame();
		frameTablero.setDefaultCloseOperation(EXIT_ON_CLOSE); //Terminar la ejecución si se cierra la ventana
		frameTablero.setTitle("Krello - Tablero");//Título de la ventana
		frameTablero.setSize(1280, 720);//ancho, alto
		frameTablero.setMinimumSize(new Dimension(1280, 720));//Tamaño mínimo al que se puede ajustar
		frameTablero.setLocationRelativeTo(null); //Centra la ventana
		frameTablero.setLayout(new BorderLayout());//Diseño
		frameTablero.setBackground(cyan);//Color de la barra de la ventana
		frameTablero.getContentPane().setBackground(blanco);//Color del fondo del frame

			panelTableroHead = Principal.panelPrincipalHead();//Llama el head del Frame Principal
		
		frameTablero.add(panelTableroHead, BorderLayout.NORTH);//Lo añade y lo ubica arriba
		 
			panelTableroMiddle = panelTableroMiddle();//Crea el middle
		
		frameTablero.add(panelTableroMiddle, BorderLayout.CENTER);//Lo añade y lo ubica al centro
			
		frameTablero.setVisible(true); //IMPORTANTE -> Siempre dejar esto de últimas.
    }
	//Cierra: Constructor del frame Tablero
        
 	
 	
 	
 	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // PANELES  // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
	//Abre: Método para crear el panelTableroMiddle
    public static JPanel panelTableroMiddle() {
    	
    	panelTableroMiddle = new JPanel();//Crea nuevo
    	panelTableroMiddle.setLayout(new BorderLayout());//Diseño
    	panelTableroMiddle.setBorder(new EmptyBorder(10,20,20,20));//top, left, bottom, right -> Ajusta un borde por pixeles
    	panelTableroMiddle.setBackground(aguacate);//Color de fondo
    	panelTableroMiddle.setOpaque(detalles);//Mostrar detalles
    	
	    	//Abre: panelSuperior
	    	JPanel panelSuperior = new JPanel();//Crea nuevo
	    	panelSuperior.setLayout(new BorderLayout());//Diseño
	    	panelSuperior.setBackground(rosa);//Color de fondo
	    	panelSuperior.setOpaque(detalles);//Mostrar detalles
	    	
	    		//Abre: panelTitulos
		    	JPanel panelTitulos = new JPanel();//Crea nuevo
		    	panelTitulos.setLayout(new FlowLayout(FlowLayout.LEFT));//Diseño: Flujo a la izquierda (espacio horizontal),(espacio vertical)
		    	panelTitulos.setBackground(petroleo);//Color de fondo
		    	panelTitulos.setOpaque(detalles);//Mostrar detalles
	        
		        	//Abre: lblTituloTablero
		    		String nombreTablerto = ctrl.getNombreTableroAbierto();
			    	JLabel lblTituloTablero = new JLabel(nombreTablerto);//Crea nuevo
			    	lblTituloTablero.setFont(new Font("Arial", Font.BOLD, 24));//Cambia la letra del interior
			    	lblTituloTablero.setForeground(negro);//Color de letra
			    	lblTituloTablero.setBackground(verde);//Color de fondo
			    	lblTituloTablero.setOpaque(detalles);//Mostrar detalles
			    	//Cierra: lblTituloTablero
			    	
		    	panelTitulos.add(lblTituloTablero);//Añade lblTituloTablero
			    	
			    	//Abre: lblAdminTablero
		    		String nombreAdministrador = ctrl.getNombreAdministradorDeTableroAbierto();
			    	JLabel lblAdminTablero = new JLabel("Tablero de: " + nombreAdministrador);//Crea nuevo //TODO: Agregar el nombre del dueño
			    	lblAdminTablero.setFont(new Font("Arial", Font.ITALIC, 14));//Cambia la letra del interior
			    	lblAdminTablero.setForeground(gris);//Color de letra
			    	lblAdminTablero.setBackground(negro);//Color de fondo
			    	lblAdminTablero.setOpaque(detalles);//Mostrar detalles
			    	//Cierra: lblAdminTablero
	    	
		    	panelTitulos.add(lblAdminTablero);//Añade lblAdminTablero
		    	//Cierra: panelTitulos
	        
	        panelSuperior.add(panelTitulos, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
	    	
		        //Abre: panelBotones
		    	JPanel panelBotones = new JPanel();//Crea nuevo
		    	panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT,10, 0));//Diseño: Flujo a la derecha (espacio horizontal),(espacio vertical)
		    	panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));//top, left, bottom, right -> Ajusta un borde por pixeles
		    	panelBotones.setBackground(limon2);//Color de fondo
		    	panelBotones.setOpaque(detalles);//Mostrar detalles
		        
			    	//Abre: btnEditarTablero
			    	btnEditarTablero = new JButton("...");//Crea nuevo
			    	btnEditarTablero.setBackground(morado);//Color de fondo
			    	btnEditarTablero.setForeground(blanco);//Color de letra
			    	btnEditarTablero.setFocusPainted(false);//Evita que se muestre un borde cuando el componente tiene el foco.
			    	btnEditarTablero.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
			    	
			    		//Abrir: Acción del btnCrearLista
			    	btnEditarTablero.addActionListener(new ActionListener() {
			    			public void actionPerformed(ActionEvent evento) {
			    				ctrl.actionBtnEditarTablero();//Se llama el método del Controller que gestiona el evento.
			    			}
			    		});
			    		//Cierra: Acción del btnCrearLista
			    		
			    	//Cierra: btnEditarTablero
			    	
		    	panelBotones.add(btnEditarTablero, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
			    	
			    	//Abre: btnCrearLista
			    	btnCrearLista = new JButton("Crear Lista");//Crea nuevo
			    	btnCrearLista.setBackground(new Color(89, 187, 186));//Color de fondo //TODO: Poner este color global :D
			    	btnCrearLista.setForeground(blanco);//Color de letra
			    	btnCrearLista.setFocusPainted(false);//Evita que se muestre un borde cuando el componente tiene el foco.
			    	btnCrearLista.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
			    	
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
	        Color color = detalles ? cyan : blanco;//Ternario para el Separador
	        panelIntermedio.setBackground(color);//Color de fondo
	        panelIntermedio.setOpaque(detalles);//Mostrar detalles
	        
		        //Abre: separator (Linea fea)
		        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		        separator.setForeground(negro);//Color de letra
		        //Cierra: separator (Linea fea)
	        
	        panelIntermedio.add(separator, BorderLayout.PAGE_START);//Lo añade y lo ubica arriba
	        
	        	panelTableroBody();//Crea el panelTableroBody
	    	
	    	panelIntermedio.add(panelTableroBody, BorderLayout.CENTER);//Lo añade y lo ubica en el centro
	    	//Cierra: panelIntermedio
        
        panelTableroMiddle.add(panelIntermedio, BorderLayout.CENTER);//Lo añade y lo ubica abajo
    	
    	return panelTableroMiddle;
    }
    //Cierra: Método para crear el panelTableroMiddle
    
    //Abre: Método para crear el panelTableroBody
    public static void panelTableroBody() {
        // Crear el panel interno
        panelTableroContent = new JPanel();
        panelTableroContent.setBackground(grisClaro);
        panelTableroContent.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelTableroContent.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        panelTableroBody = new JScrollPane(panelTableroContent, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelTableroBody.setBorder(null); // Elimina el borde del JScrollPane
        panelTableroBody.getHorizontalScrollBar().setUnitIncrement(16); // Ajusta la velocidad del scroll
    }
    //Abre: Cierra metodo para crear el panelTableroBody

    //Abre: Método para crear el panelLista
    public static void panelLista() {
        panelLista = new JPanel();
        panelLista.setBackground(petroleoOscuro);
        panelLista.setForeground(negro);
        panelLista.setFont(new Font("Arial", Font.PLAIN, 80));
        panelLista.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLista.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelLista.setPreferredSize(new Dimension(280, 420));
        panelLista.setAlignmentY(CENTER_ALIGNMENT);

        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelSuperior.setOpaque(false);

        String nombreLista  = ctrl.getNombreListaAbierta();
        JLabel titulo = new JLabel(nombreLista);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(Color.WHITE);

        JButton btnCrear = new JButton("+");
        JButton btnEditar = new JButton("･･･");

        btnCrear.setBackground(limon);
        btnCrear.setForeground(negro);
        btnEditar.setBackground(morado);
        btnEditar.setForeground(blanco);

        panelSuperior.add(titulo);
        panelSuperior.add(Box.createHorizontalStrut(100)); // Espacio entre el título y los botones
        panelSuperior.add(btnCrear);
        panelSuperior.add(btnEditar);

       panelLista.add(panelSuperior);
		
	    panelTarea(panelLista); //Se utilizaria cuando se realice el evento boton crear tarea, pero lo dejo para que vean como quedo
        panelTableroContent.add(panelLista);

        panelTableroContent.revalidate();
        panelTableroContent.repaint();
    }
	// Cierra: Método para crear el panelLista
	
	// Abre: Método para crear el panelTarea
	public static void panelTarea(JPanel panelLista) {
	    // Crear un nuevo panel para la tarea
	    JPanel panelTarea = new JPanel();
	    panelTarea.setLayout(new FlowLayout(FlowLayout.LEFT)); // Alineación hacia la izquierda
	    panelTarea.setBackground(limon2); // Fondo para la tarea
	    panelTarea.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Borde gris

	    // Crear un JCheckBox para la tarea
	    JCheckBox checkBoxTarea = new JCheckBox();
	    panelTarea.add(checkBoxTarea).setBackground(limon2); // Agregar el checkbox al panel de tarea

	    // Crear una etiqueta con el nombre de la tarea
	    JLabel tareaLabel = new JLabel("Tarea");
	    tareaLabel.setFont(new Font("Arial", Font.PLAIN, 15));
	    tareaLabel.setForeground(negro);
	    panelTarea.add(tareaLabel); // Agregar la etiqueta al panel de tarea

	    // Crear el botón de editar tarea
	    JButton btnEditar = new JButton("･･･");
	    btnEditar.setBackground(morado); // Color de fondo para el botón
	    btnEditar.setForeground(blanco); // Color de texto para el botón
	    
	    panelTarea.add(Box.createHorizontalStrut(100)); // Espacio  entre la tarea y el botón

	    // Agregar el botón de editar después del espacio
	    panelTarea.add(btnEditar);

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
		emergenteCrearLista.setBackground(blanco);//Color de fondo
		emergenteCrearLista.setResizable(false);//No permite modificar el tamaño de la ventana
		emergenteCrearLista.setLocationRelativeTo(frameTablero);//Se centra según el framePrincipal
		emergenteCrearLista.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Se cierra al dar click en la X
		emergenteCrearLista.setLayout(new BorderLayout());//Diseño
		
		
    		//Abre: panelTituloCrearLista
	        JPanel panelTituloCrearLista = new JPanel();//Crea nuevo
	        panelTituloCrearLista.setLayout(new BoxLayout(panelTituloCrearLista, BoxLayout.Y_AXIS));//Diseño: El BoxLayout.Y_AXIS es para que se ubiquen VERTICALMENTE una encima de la otra.
	        panelTituloCrearLista.setBackground(morado);//Color de fondo
	        panelTituloCrearLista.setOpaque(detalles);//Mostrar detalles
	        panelTituloCrearLista.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 30));//top, left, bottom, right -> Ajusta un borde por pixeles

        		//Abre: lblTituloCrearLista
		        JLabel lblTituloCrearLista = new JLabel("Crear Lista");//Crea nuevo
		        lblTituloCrearLista.setFont(new Font("Arial", Font.BOLD, 40));//Cambia la letra del interior
		        lblTituloCrearLista.setForeground(limon2);//Color de la letra
		        lblTituloCrearLista.setAlignmentX(Component.CENTER_ALIGNMENT);//Centra horizontalmente
		        lblTituloCrearLista.setBackground(gris);//Color de fondo
		        lblTituloCrearLista.setOpaque(detalles);//Mostrar detalles
        		//Cierra: lblTituloCrearLista
		        
	        panelTituloCrearLista.add(lblTituloCrearLista);
	    	//Cierra: panelTituloCrearLista
        
        emergenteCrearLista.add(panelTituloCrearLista, BorderLayout.NORTH);//Ubica arriba
        
	        //Abre: panelIngresarNombreLista
	    	JPanel panelIngresarNombreLista = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));//Diseño: Flujo Centrado (espacio horizontal),(espacio vertical)
	    	panelIngresarNombreLista.setBackground(millos);//Color de fondo
	    	panelIngresarNombreLista.setOpaque(detalles);//Mostrar detalles
		        
        		//Abre: lblNombre
	    		JLabel lblNombre = new JLabel("Nombre:");//Crea nuevo
		        lblNombre.setFont(new Font("Arial", Font.PLAIN, 20));//Cambia la letra del interior
	        	//Cierra: lblNombre
		        
	        panelIngresarNombreLista.add(lblNombre);//Añade lblNombre
	        
	        	//Abre: txtFieldIngresarNombreEmergenteCrearLista
		        txtFieldIngresarNombreEmergenteCrearLista = new JTextField(mensajeIngresarNombreLista);//Crea nuevo
		        txtFieldIngresarNombreEmergenteCrearLista.setForeground(gris);//Color de letra
		        txtFieldIngresarNombreEmergenteCrearLista.setPreferredSize(new Dimension(400, 30));//Tamaño
		        txtFieldIngresarNombreEmergenteCrearLista.setFont(new Font("Arial", Font.PLAIN, 20));//Cambia la letra del interior
		        txtFieldIngresarNombreEmergenteCrearLista.setBackground(grisClaro);//Color de fondo
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
		    panelIngresarNombreLista.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));// top, left, bottom, right -> Ajusta un borde por pixeles
	        //Cierra: panelIngresarNombreLista
		    
	    emergenteCrearLista.add(panelIngresarNombreLista, BorderLayout.CENTER);//Ubica centro
        
	    	//Abre: panelInferior
	    	JPanel panelInferior = new JPanel(new BorderLayout());//Crea nuevo
	    	panelInferior.setBackground(blanco);//Color de fondo
	    	panelInferior.setOpaque(detalles);//Mostrar detalles
    
		        //Abre: panelBotonesBasicos
		        JPanel panelBotonesBasicos = new JPanel(new BorderLayout());
		        panelBotonesBasicos.setBackground(cyan);//Color de fondo
		        panelBotonesBasicos.setOpaque(detalles);//Mostrar detalles
	        
		        	//Abre: btnCancelarEmergenteCrearTablero
			        btnCancelarEmergenteCrearLista = new JButton("Cancelar");//Crea nuevo
			        btnCancelarEmergenteCrearLista.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
			        btnCancelarEmergenteCrearLista.setPreferredSize(new Dimension(200, 40));//Tamaño botón
			        btnCancelarEmergenteCrearLista.setBackground(limon);//Color de fondo
			        btnCancelarEmergenteCrearLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		        
	    				//Abre: Acción del btnCancelarEmergenteCrearLista
				        btnCancelarEmergenteCrearLista.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	ctrl.actionBtnCancelarEmergenteCrearLista();//Se llama el método del Controller que gestiona el evento.
				            }
				        });
	    				//Cierra: Acción del btnCancelarEmergenteCrearLista
				        
				    //Cierra: btnCancelarEmergenteCrearTablero
	    		
			        //Abre: btnCrearListaEmergenteCrearLista    
			        btnCrearListaEmergenteCrearLista = new JButton("Crear Lista");//Crea nuevo
			        btnCrearListaEmergenteCrearLista.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
			        btnCrearListaEmergenteCrearLista.setPreferredSize(new Dimension(200, 40));//Tamaño
			        btnCrearListaEmergenteCrearLista.setBackground(limon);//Color de fondo
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
		        panelBotonesBasicos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));// top, left, bottom, right -> Ajusta un borde por pixeles
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
	        	lblTituloEditarTablero.setFont(new Font("Arial", Font.BOLD, 40));//Cambia la letra del interior
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
				txtFieldIngresarNombreEmergenteEditarTablero.setFont(new Font("Arial", Font.PLAIN, 20));//Cambia la letra del interior
				txtFieldIngresarNombreEmergenteEditarTablero.setBackground(moradito);//Color de fondo
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
				btnColaboradoresEmergenteEditarTablero.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
				//btnColaboradoresEmergenteEditarTablero.setPreferredSize(new Dimension(198, 42));//Tamaño botón
				btnColaboradoresEmergenteEditarTablero.setMaximumSize(new Dimension(250, 50));
				btnColaboradoresEmergenteEditarTablero.setBackground(rosita);//Color de fondo
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
				btnEliminarEmergenteEditarTablero.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
				//btnEliminarEmergenteEditarTablero.setPreferredSize(new Dimension(198, 42));//Tamaño botón
				btnEliminarEmergenteEditarTablero.setMaximumSize(new Dimension(250, 50));
				btnEliminarEmergenteEditarTablero.setBackground(moradito);//Color de fondo
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
		        	btnCancelarEmergenteEditarTablero.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
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
			        btnGuardarEmergenteEditarTablero.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
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
    }
    //Cierra: Método para crear emergenteEditarTablero
    
    //Abre: Método para crear emergenteColaboradores
    public static void emergenteColaboradores() {
    	
    	//JDialog hace que solo la emergente sea interactiva, las demás ventanas se bloquean.
    	emergenteColaboradores = new JDialog(frameTablero, "Editar Colaboradores", true);//Crea nuevo (Dueño), (Título), (Bloquea interacción mientras esté abierta)
    	emergenteColaboradores.setSize(600, 432);//Tamaño
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
	        	lblTituloEditarColaboradores.setFont(new Font("Arial", Font.BOLD, 40));//Cambia la letra del interior
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
			//Cierra: panelCentral
			
			//TODO: Panel central de la emergente
			
				//Abre: txtFieldIngresarCorreoEmergenteColaboradores
				txtFieldIngresarCorreoEmergenteColaboradores = new JTextField(mensajeCorreoColaboradores);//Crea nuevo
				txtFieldIngresarCorreoEmergenteColaboradores.setForeground(blanco);//Color de letra
				//txtFieldIngresarCorreoEmergenteColaboradores.setPreferredSize(new Dimension(198, 42));
				txtFieldIngresarCorreoEmergenteColaboradores.setHorizontalAlignment(JTextField.CENTER);
				txtFieldIngresarCorreoEmergenteColaboradores.setMaximumSize(new Dimension(400, 35));
				txtFieldIngresarCorreoEmergenteColaboradores.setFont(new Font("Arial", Font.PLAIN, 20));//Cambia la letra del interior
				txtFieldIngresarCorreoEmergenteColaboradores.setBackground(gris);//Color de fondo
				txtFieldIngresarCorreoEmergenteColaboradores.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor modo escritura
				txtFieldIngresarCorreoEmergenteColaboradores.setAlignmentX(Component.CENTER_ALIGNMENT);//lo centra???
				
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
				
				panelCentral.add(txtFieldIngresarCorreoEmergenteColaboradores, BorderLayout.NORTH);
				panelCentral.add(Box.createRigidArea(new Dimension(0, 20)));
			
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
		        	btnCancelarEmergenteColaboradores.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
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
		        	btnConfirmarEmergenteColaboradores.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
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
        	panelTituloEliminarTablero.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 30));//top, left, bottom, right -> Ajusta un borde por pixeles

    			//Abre: lblTituloEliminarTablero
	        	JLabel lblTituloEliminarTablero = new JLabel("¿Seguro desea borrar el tablero?");//Crea nuevo
	        	lblTituloEliminarTablero.setFont(new Font("Arial", Font.BOLD, 40));//Cambia la letra del interior
	        	lblTituloEliminarTablero.setForeground(limon2);//Color de la letra
	        	lblTituloEliminarTablero.setAlignmentX(Component.CENTER_ALIGNMENT);//Centra horizontalmente
	        	lblTituloEliminarTablero.setBackground(gris);//Color de fondo
	        	lblTituloEliminarTablero.setOpaque(detalles);//Mostrar detalles
	        	//Cierra: lblTituloEliminarTablero
	        
        	panelTituloEliminarTablero.add(lblTituloEliminarTablero);
        	//Cierra: panelTituloEliminarTablero
    
	        emergenteEliminar.add(panelTituloEliminarTablero, BorderLayout.NORTH);//Ubica arriba
	        
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
		        	btnCancelarEmergenteEliminar.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
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
		        	btnBorrarEmergenteEliminar.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
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
	        
		    //Abre: Funcionalidad cambiar el foco automático al abrir la emergente
		    //txtFieldIngresarNombreEmergenteEditarTablero.setEnabled(false);
		    //Timer timer = new Timer(100, e -> {
		    	//txtFieldIngresarNombreEmergenteEditarTablero.setEnabled(true);
		    //});//Temporizador
		    //timer.setRepeats(false);//Evita que el temporizador se repita
		    //timer.start();//Inicia el temporizador
		    //Cierra: Funcionalidad cambiar el foco automático al abrir la emergente
	    
	        emergenteEliminar.setVisible(true);//Hace visible la emergente
    }
    //Cierra: Método para crear emergenteEliminar
    
    
    
    
    
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // GET & SET// -- // -- //
	// -- // -- // -- // -- // -- // -- //

	public static boolean isDetalles() {
		return detalles;
	}

	public static void setDetalles(boolean detalles) {
		FrameTablero.detalles = detalles;
	}

	public static Controlador getCtrl() {
		return ctrl;
	}

	public static void setCtrl(Controlador ctrl) {
		FrameTablero.ctrl = ctrl;
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

	public static JButton getBtnEditarTablero() {
		return btnEditarTablero;
	}

	public static void setBtnEditarTablero(JButton btnEditarTablero) {
		FrameTablero.btnEditarTablero = btnEditarTablero;
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

	public static Color getBlanco() {
		return blanco;
	}

	public static void setBlanco(Color blanco) {
		FrameTablero.blanco = blanco;
	}

	public static Color getRosa() {
		return rosa;
	}

	public static void setRosa(Color rosa) {
		FrameTablero.rosa = rosa;
	}

	public static Color getCyan() {
		return cyan;
	}

	public static void setCyan(Color cyan) {
		FrameTablero.cyan = cyan;
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

	public static Color getGris() {
		return gris;
	}

	public static void setGris(Color gris) {
		FrameTablero.gris = gris;
	}

	public static Color getGrisClaro() {
		return grisClaro;
	}

	public static void setGrisClaro(Color grisClaro) {
		FrameTablero.grisClaro = grisClaro;
	}

	public static Color getAguacate() {
		return aguacate;
	}

	public static void setAguacate(Color aguacate) {
		FrameTablero.aguacate = aguacate;
	}

	public static Color getMorado() {
		return morado;
	}

	public static void setMorado(Color morado) {
		FrameTablero.morado = morado;
	}

	public static Color getNegro() {
		return negro;
	}

	public static void setNegro(Color negro) {
		FrameTablero.negro = negro;
	}

	public static Color getPetroleo() {
		return petroleo;
	}

	public static void setPetroleo(Color petroleo) {
		FrameTablero.petroleo = petroleo;
	}
	
	public static Color getPetroleoOscuro() {
		return petroleoOscuro;
	}

	public static void setPetroleoOscuro(Color petroleoOscuro) {
		FrameTablero.petroleoOscuro = petroleoOscuro;
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

	public static Border getMacOSBorde() {
		return macOSBorde;
	}

	public static void setMacOSBorde(Border macOSBorde) {
		FrameTablero.macOSBorde = macOSBorde;
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