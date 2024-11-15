package co.edu.konradlorenz.view.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import co.edu.konradlorenz.controller.Controlador;

@SuppressWarnings("serial")
public class FrameTablero extends JFrame{
	
	//MOSTRAR DETALLES
	private static boolean detalles = true;//true -> mostrar / false -> ocultar
	private static boolean macOS = true;//true -> macOS / false -> Windows
		
	//CONTROLADOR
	private static Controlador ctrl = new Controlador();

	//FRAMES
	private static JFrame frameTablero = new JFrame();
	
	//EMERGENTES
	private static JDialog emergenteCrearLista;
	private static JDialog emergenteEditarTablero;
	private static JDialog emergenteColaboradores;
	private static JDialog emergenteEliminar;
	
	//PANELS 
	private static JPanel panelTableroHead;
	private static JPanel panelTableroMiddle;
	private static JPanel panelTableroBody;
	
	//TEXTFIELDS
	private static JTextField txtFieldIngresarNombreEmergenteCrearLista;
	
	//PASSWORDFIELDS
	
	
	//BUTTONS
	private static JButton btnCrearLista;
	private static JButton btnEditarTablero;
	private static JButton btnCancelarEmergenteCrearLista;
	private static JButton btnCrearListaEmergenteCrearLista;
		
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
	private static String mensajeIngresarNombreLista = " Ingrese nombre de la lista...";
	
	
	
	
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // VENTANAS // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
    //Abre: Constructor del frame Tablero
	public FrameTablero(){

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
    public JPanel panelTableroMiddle() {
    	
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
		    	JPanel panelTitulos = new JPanel(new FlowLayout(FlowLayout.LEFT));//Diseño: Flujo a la izquierda
		    	panelTitulos.setBackground(petroleo);//Color de fondo
		    	panelTitulos.setOpaque(detalles);//Mostrar detalles
	        
		        	//Abre: lblTituloTablero
			    	JLabel lblTituloTablero = new JLabel("Proyecto Final Técnicas II");//Crea nuevo
			    	lblTituloTablero.setFont(new Font("Arial", Font.BOLD, 24));//Cambia la letra del interior
			    	lblTituloTablero.setForeground(negro);//Color de letra
			    	lblTituloTablero.setBackground(verde);//Color de fondo
			    	lblTituloTablero.setOpaque(detalles);//Mostrar detalles
			    	//Cierra: lblTituloTablero
			    	
		    	panelTitulos.add(lblTituloTablero);//Añade lblTituloTablero
			    	
			    	//Abre: lblAdminTablero
			    	JLabel lblAdminTablero = new JLabel("Tablero de: "+" administrador :(");//Crea nuevo //TODO: Agregar el nombre del dueño
			    	lblAdminTablero.setFont(new Font("Arial", Font.ITALIC, 14));//Cambia la letra del interior
			    	lblAdminTablero.setForeground(grisClaro);//Color de letra
			    	lblAdminTablero.setBackground(negro);//Color de fondo
			    	lblAdminTablero.setOpaque(detalles);//Mostrar detalles
			    	//Cierra: lblAdminTablero
	    	
		    	panelTitulos.add(lblAdminTablero);//Añade lblAdminTablero
		    	//Cierra: panelTitulos
	        
	        panelSuperior.add(panelTitulos, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
	    	
		        //Abre: panelBotones
		    	JPanel panelBotones = new JPanel();//Crea nuevo
		    	panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT,10, 0));//Diseño: Flujo a la derecha (espacio horizontal),(espacio vertical)
		    	if(macOS) {
		    		panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 47, 10, 47));//top, left, bottom, right -> Ajusta un borde por pixeles
		    		panelBotones.setLayout(new BorderLayout(12, 0));//Diseño: (espacio horizontal),(espacio vertical)
		    	} else panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));//top, left, bottom, right -> Ajusta un borde por pixeles
		    	panelBotones.setBackground(limon2);//Color de fondo
		    	panelBotones.setOpaque(detalles);//Mostrar detalles
		        
			    	//Abre: btnEditarTablero
			    	btnEditarTablero = new JButton("...");//Crea nuevo
			    	btnEditarTablero.setBackground(morado);//Color de fondo
			    	btnEditarTablero.setForeground(blanco);//Color de letra
			    	btnEditarTablero.setFocusPainted(false);//Evita que se muestre un borde cuando el componente tiene el foco.
			    	btnEditarTablero.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
			    	if(macOS){
			    		btnEditarTablero.setPreferredSize(new Dimension(60, 22));//Tamaño botón
			    		btnEditarTablero.setOpaque(true);//No transparente
			    		btnEditarTablero.setBorder(macOSBorde);//Borde negro fino
			    	}
			    	//Cierra: btnEditarTablero
			    	
		    	panelBotones.add(btnEditarTablero, BorderLayout.WEST);//Lo añade y lo ubica a la izquierda
			    	
			    	//Abre: btnCrearLista
			    	btnCrearLista = new JButton("Crear Lista");//Crea nuevo
			    	btnCrearLista.setBackground(new Color(89, 187, 186));//Color de fondo //TODO: Poner este color global :D
			    	btnCrearLista.setForeground(blanco);//Color de letra
			    	btnCrearLista.setFocusPainted(false);//Evita que se muestre un borde cuando el componente tiene el foco.
			    	btnCrearLista.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
			    	if(macOS){
			    		btnCrearLista.setPreferredSize(new Dimension(120, 22));//Tamaño botón
				    	btnCrearLista.setOpaque(true);//No transparente
				    	btnCrearLista.setBorder(macOSBorde);//Borde negro fino
			    	}
			    	
			    		//Abrir: Acción del btnCrearLista
				    	btnCrearLista.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent evento) {
				            	ctrl.actionBtnCrearLista(evento);//Se llama el método del Controller que gestiona el evento.
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
	        
	        	panelTableroBody();
	    	
	    	panelIntermedio.add(panelTableroBody, BorderLayout.CENTER);//Lo añade y lo ubica en el centro
	    	//Cierra: panelIntermedio
        
        panelTableroMiddle.add(panelIntermedio, BorderLayout.CENTER);//Lo añade y lo ubica abajo
    	
    	return panelTableroMiddle;
    }
    //Cierra: Método para crear el panelTableroMiddle
    
    //Abre: Método para crear el panelTableroBody
    public void panelTableroBody() {
    	
    	panelTableroBody = new JPanel();//Crea nuevo
    	panelTableroBody.setBackground(grisClaro);//Color de fondo
    	panelTableroBody.setBorder(new EmptyBorder(10, 0, 0, 0));//top, left, bottom, right -> Ajusta un borde por pixeles
    	panelTableroBody.setPreferredSize(new Dimension(800, 400));//Tamaño
    	
    }
    //Cierra: Método para crear el panelTableroBody
    
    
    
    
    
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
		        if(macOS){
			        txtFieldIngresarNombreEmergenteCrearLista.setOpaque(true);//No transparente
			        txtFieldIngresarNombreEmergenteCrearLista.setBorder(macOSBorde);//Borde negro fino
		        }
		        
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
			            	ctrl.actionEnterTxtFieldIngresarNombreEmergenteCrearLista(evento);//Se llama el método del Controller que gestiona el evento.
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
		        if(macOS){
		        	btnCancelarEmergenteCrearLista.setOpaque(true);//No transparente
		        	btnCancelarEmergenteCrearLista.setBorder(macOSBorde);//Borde negro fino
		        }
	        
    				//Abre: Acción del btnCancelarEmergenteCrearLista
			        btnCancelarEmergenteCrearLista.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	ctrl.actionBtnCancelarEmergenteCrearLista(evento);//Se llama el método del Controller que gestiona el evento.
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
		        if(macOS){
		        	btnCrearListaEmergenteCrearLista.setOpaque(true);//No transparente
		        	btnCrearListaEmergenteCrearLista.setBorder(macOSBorde);//Borde negro fino
		        }
	        
		        	//Abre: Acción del btnCrearListaEmergenteCrearLista
		        	btnCrearListaEmergenteCrearLista.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	//TODO:Crear método en el Controller
			            	//ctrl.actionbtnCrearListaEmergenteCrearLista(evento);//Se llama el método del Controller que gestiona el evento. 
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
    
    
    
    
    
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // GET & SET// -- // -- //
	// -- // -- // -- // -- // -- // -- //

	public static boolean isDetalles() {
		return detalles;
	}

	public static void setDetalles(boolean detalles) {
		FrameTablero.detalles = detalles;
	}

	public static boolean isMacOS() {
		return macOS;
	}

	public static void setMacOS(boolean macOS) {
		FrameTablero.macOS = macOS;
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

	public static JPanel getPanelTableroBody() {
		return panelTableroBody;
	}

	public static void setPanelTableroBody(JPanel panelTableroBody) {
		FrameTablero.panelTableroBody = panelTableroBody;
	}

	public static JTextField getTxtFieldIngresarNombreEmergenteCrearLista() {
		return txtFieldIngresarNombreEmergenteCrearLista;
	}

	public static void setTxtFieldIngresarNombreEmergenteCrearLista(
			JTextField txtFieldIngresarNombreEmergenteCrearLista) {
		FrameTablero.txtFieldIngresarNombreEmergenteCrearLista = txtFieldIngresarNombreEmergenteCrearLista;
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
	    
}
//class