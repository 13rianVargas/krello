package co.edu.konradlorenz.view.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import co.edu.konradlorenz.controller.Controlador;

@SuppressWarnings("serial")
public class FrameTablero extends JFrame{
	
	private static Controlador ctrl = new Controlador();
	
		//FRAMES
		private static JFrame frameTablero = new JFrame();
		
		//EMERGENTES
		private static JDialog emergenteCrearLista;
		private static JDialog emergenteEditarTablero;
		private static JDialog emergenteColaboradores;
		private static JDialog emergenteEliminar;
		
		//PANELS
		//JPanel panelInvisible = new JPanel(); //PENDIENTE -> Este JPanel permite que el autofocus no sea el primer campo de texto. 
		private static JPanel panelTableroHead;
		private static JPanel panelTableroMiddle;
		private static JPanel panelTableroTitulo;
		private static JPanel panelTableroBody;
		private static JPanel panelTablero;
		private static JPanel panelInvisible;
		
		//TEXTFIELDS
		private static JTextField txtFieldIngresarNombreEmergenteCrearLista;
		
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
		
		//BORDER
		private static Border border = BorderFactory.createLineBorder(negro, 1);//Borde de 1px
		
		//MOSTRAR DETALLES
		private static boolean detalles = true;//true -> mostrar / false -> ocultar
		
		//STRINGS
		private static String mensajeIngresarNombreLista = " Ingrese nombre de la lista...";
		
		public FrameTablero(){

			frameTablero.setDefaultCloseOperation(EXIT_ON_CLOSE); //Terminar la ejecución si se cierra la ventana
			frameTablero.setTitle("Krello - Tablero");//Título de la ventana
			frameTablero.setSize(1280, 720);//ancho, alto
			frameTablero.setMinimumSize(new Dimension(1280, 720));//Tamaño mínimo al que se puede ajustar
			frameTablero.setLocationRelativeTo(null); //Centra la ventana
			frameTablero.setLayout(new BorderLayout());//Hace el frame responsivo a los ajustes de tamaño
			frameTablero.setBackground(Color.CYAN);//Color de la barra de la ventana
			frameTablero.getContentPane().setBackground(blanco);//Color del fondo

			panelTableroHead = panelTableroHead();
	    	//frameTablero.add(panelTableroHead);//Solo lo añade
			frameTablero.add(panelTableroHead, BorderLayout.NORTH);//Lo añade y hace el panel responsivo
		
	    	//panelTableroMiddle = panelTableroMiddle();
	    	//frameTablero.add(panelTableroMiddle);//Solo lo añade
	    	//frameTablero.add(panelTableroMiddle, BorderLayout.CENTER);//Lo añade y hace el panel responsivo
		      
			panelTableroMiddle = panelTableroMiddle();
			frameTablero.add(panelTableroMiddle, BorderLayout.CENTER);
			
			//panelTableroBody = panelTableroBody();
			//frameTablero.add(panelTableroBody, BorderLayout.SOUTH);
			
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
		
	    public JPanel panelTableroMiddle() {
	    	
	    	panelTableroMiddle = new JPanel();
	    	panelTableroMiddle.setLayout(new BorderLayout());
	    	panelTableroMiddle.setBackground(Color.WHITE);
	    	panelTableroMiddle.setBorder(new EmptyBorder(10,20,10,20));
	    	
	    	//panelesSupInf
	    	JPanel panelSuperior = new JPanel(new BorderLayout());
	    	panelSuperior.setOpaque(false);
	    	
	    	
	    	
	    	//Titulo tablero
	    	JLabel lblTituloTablero = new JLabel("Proyecto Final Técnicas II");//Nombre que esta en los MockUps
	    	lblTituloTablero.setFont(new Font("Arial", Font.BOLD, 24));
	    	lblTituloTablero.setForeground(Color.BLACK);
	    	
	    	JLabel lblAdminTablero = new JLabel("Tablero de: "+" administrador :(");//TODO: revisar nombre del dueño
	    	lblAdminTablero.setFont(new Font("Arial", Font.ITALIC, 14));
	    	lblAdminTablero.setForeground(Color.LIGHT_GRAY);
	    	
	    	JPanel panelTitulos = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        panelTitulos.setOpaque(false);
	        panelTitulos.add(lblTituloTablero);
	        panelTitulos.add(lblAdminTablero);
	        
	        panelSuperior.add(panelTitulos, BorderLayout.WEST);
	    	
	    	//Boton para crear lista
	    	btnEditarTablero = new JButton("...");
	    	btnEditarTablero.setBackground(new Color(98, 20, 109));
	    	btnEditarTablero.setForeground(Color.WHITE);
	    	btnEditarTablero.setFocusPainted(false);
	    	btnEditarTablero.setFont(new Font("Arial", Font.PLAIN, 18));
	    	
	    	btnCrearLista = new JButton("Crear Lista");
	    	btnCrearLista.setBackground(new Color(89, 187, 186));
	    	btnCrearLista.setForeground(Color.WHITE);
	    	btnCrearLista.setFocusPainted(false);
	    	btnCrearLista.setFont(new Font("Arial", Font.PLAIN, 18));
	    	//Acción del botón:
	    	btnCrearLista.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evento) {
	                //IMPORTANTE -> Aquí se llama a un otro método que maneja el evento para poder llamarlo también desde el Controller.
	            	ctrl.actionBtnCrearLista(evento);
	            }
	        });
	    	
	    	//Panel boton
	    	JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
	        panelBotones.setOpaque(false);
	        panelBotones.add(btnEditarTablero);
	        panelBotones.add(btnCrearLista);
	    	
	        panelSuperior.add(panelBotones, BorderLayout.EAST);
	        
	        panelTableroMiddle.add(panelSuperior, BorderLayout.NORTH);
	        
	        JPanel panelIntermedio = new JPanel();
	        panelIntermedio.setLayout(new BorderLayout());
	        panelIntermedio.setOpaque(false);
	        
	        //Linea fea
	        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
	        separator.setForeground(Color.BLACK);
	        panelIntermedio.add(separator, BorderLayout.PAGE_START);
	        
	        panelTableroBody = panelTableroBody();
	        panelIntermedio.add(panelTableroBody, BorderLayout.CENTER);
	        
	        panelTableroMiddle.add(panelIntermedio, BorderLayout.CENTER);
	    	
	    	return panelTableroMiddle;
	    }
	    
	    public JPanel panelTableroBody() {
	    	
	    	panelTableroBody = new JPanel();
	    	panelTableroBody.setBackground(Color.LIGHT_GRAY);
	    	panelTableroBody.setBorder(new EmptyBorder(10, 0, 0, 0));
	    	panelTableroBody.setPreferredSize(new Dimension(800, 400));
	    	
	    	return panelTableroBody;
	    }
	    
	    public static void emergenteCrearLista() {
	    		emergenteCrearLista = new JDialog(frameTablero, "Crear Lista", true);
	    		emergenteCrearLista.setSize(600, 300);
	    		emergenteCrearLista.setBackground(blanco);
	    		emergenteCrearLista.setResizable(false);
	    		emergenteCrearLista.setLocationRelativeTo(frameTablero);
	    		emergenteCrearLista.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    		emergenteCrearLista.setLayout(new BorderLayout());
	    		
	    		
	    		
	    		//Label del Título
		        JLabel lblTituloCrearLista = new JLabel("Crear Lista");
		        lblTituloCrearLista.setFont(new Font("Arial", Font.BOLD, 40));//Cambia la letra del interior
		        lblTituloCrearLista.setForeground(limon2);//Color de la letra
		        lblTituloCrearLista.setAlignmentX(Component.CENTER_ALIGNMENT);//Centra horizontalmente
		        lblTituloCrearLista.setBackground(gris);//Color de fondo
		        lblTituloCrearLista.setOpaque(detalles);//Mostrar detalles
		        
		      //Panel del Título
		        JPanel panelTituloCrearLista = new JPanel();
		        panelTituloCrearLista.setLayout(new BoxLayout(panelTituloCrearLista, BoxLayout.Y_AXIS));//Se ordena verticalmente
		        panelTituloCrearLista.setBackground(morado);//Color de fondo
		        panelTituloCrearLista.setOpaque(detalles);//Mostrar detalles
		        panelTituloCrearLista.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));// top, left, bottom, right -> Ajusta un borde por pixeles
		        panelTituloCrearLista.add(Box.createVerticalGlue());//Agrega espacio flexible antes del JLabel
		        panelTituloCrearLista.add(lblTituloCrearLista);
		        panelTituloCrearLista.add(Box.createVerticalGlue());//Agrega espacio flexible después del JLabel
		        
		        emergenteCrearLista.add(panelTituloCrearLista, BorderLayout.NORTH);//Ubica arriba
		        
		      //Panel Ingresar Nombre de la lista.
	        	JPanel panelIngresarNombreLista = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));//Usa FlowLayout: (alineación), (espacio horizontal entre los componentes), (espacio vertical entre las filas de componentes).
	        	panelIngresarNombreLista.setBackground(millos);//Color de fondo
	        	panelIngresarNombreLista.setOpaque(detalles);//Mostrar detalles
			        JLabel lblNombre = new JLabel("Nombre:");
			        lblNombre.setFont(new Font("Arial", Font.PLAIN, 20));//Cambia la letra del interior
			        txtFieldIngresarNombreEmergenteCrearLista = new JTextField(mensajeIngresarNombreLista);
			        txtFieldIngresarNombreEmergenteCrearLista.setForeground(gris);
			        
			        //Placeholder "mensaje previo"
			        txtFieldIngresarNombreEmergenteCrearLista.addFocusListener(new FocusListener() {
			            @Override
			            public void focusGained(FocusEvent e) {
			                if (txtFieldIngresarNombreEmergenteCrearLista.getText().equals(mensajeIngresarNombreLista)) {
			                	txtFieldIngresarNombreEmergenteCrearLista.setText("");
			                	txtFieldIngresarNombreEmergenteCrearLista.setForeground(negro);
			                }
			            }
			            @Override
			            public void focusLost(FocusEvent e) {
			                //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
			                if (txtFieldIngresarNombreEmergenteCrearLista.getText().isEmpty()) {
			                	txtFieldIngresarNombreEmergenteCrearLista.setForeground(gris);
			                	txtFieldIngresarNombreEmergenteCrearLista.setText(mensajeIngresarNombreLista);
			                }
			            }
			        });
			        //Placeholder
			        
			        txtFieldIngresarNombreEmergenteCrearLista.setPreferredSize(new Dimension(400, 30));
			        txtFieldIngresarNombreEmergenteCrearLista.setFont(new Font("Arial", Font.PLAIN, 20));//Tamaño del texto interno del txtField
			        txtFieldIngresarNombreEmergenteCrearLista.setBackground(grisClaro);//Color de fondo
			        txtFieldIngresarNombreEmergenteCrearLista.setOpaque(true);
			        txtFieldIngresarNombreEmergenteCrearLista.setBorder(border);
			        txtFieldIngresarNombreEmergenteCrearLista.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			            	//IMPORTANTE -> Aquí se llama a un método que maneja el evento desde el Controller.
			            	ctrl.actionEnterTxtFieldIngresarNombreEmergenteCrearLista(evento);
			            }
			        });
			        txtFieldIngresarNombreEmergenteCrearLista.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor modo escritura
			        
			    panelIngresarNombreLista.add(lblNombre);
			    panelIngresarNombreLista.add(Box.createVerticalStrut(10));//Espacio entre la etiqueta y el campo de texto
			    panelIngresarNombreLista.add(txtFieldIngresarNombreEmergenteCrearLista);
			    panelIngresarNombreLista.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));// top, left, bottom, right -> Ajusta un borde por pixeles
		        
			    //Panel Botones Básicos Emergente
		        JPanel panelBotonesBasicos = new JPanel(new BorderLayout());
		        panelBotonesBasicos.setBackground(cyan);//Color de fondo
		        panelBotonesBasicos.setOpaque(detalles);//Mostrar detalles
		        
			        btnCancelarEmergenteCrearLista = new JButton("Cancelar");
			        btnCancelarEmergenteCrearLista.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
			        btnCancelarEmergenteCrearLista.setPreferredSize(new Dimension(200, 40));
			        btnCancelarEmergenteCrearLista.setBackground(limon);//Color de fondo
			        //2 lineas para macOS:
			        btnCancelarEmergenteCrearLista.setOpaque(true);
			        btnCancelarEmergenteCrearLista.setBorder(border);
			        btnCancelarEmergenteCrearLista.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			                //IMPORTANTE -> Aquí se llama a un método que maneja el evento desde el Controller.
			            	ctrl.actionBtnCancelarEmergenteCrearLista(evento);
			            }
			        });
		    		btnCancelarEmergenteCrearLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		    		
			        btnCrearListaEmergenteCrearLista = new JButton("Crear Lista");
			        btnCrearListaEmergenteCrearLista.setFont(new Font("Arial", Font.PLAIN, 18));//Cambia la letra del interior
			        btnCrearListaEmergenteCrearLista.setPreferredSize(new Dimension(200, 40));
			        btnCrearListaEmergenteCrearLista.setBackground(limon);//Color de fondo
			        //2 lineas para macOS:
			        btnCrearListaEmergenteCrearLista.setOpaque(true);
			        btnCrearListaEmergenteCrearLista.setBorder(border);
			        btnCrearListaEmergenteCrearLista.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent evento) {
			                //IMPORTANTE -> Aquí se llama a un método que maneja el evento desde el Controller.
			            	ctrl.actionEnterTxtFieldIngresarNombreEmergenteCrearLista(evento);
			            }
			        });
			        btnCrearListaEmergenteCrearLista.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
		    		
		        panelBotonesBasicos.add(btnCancelarEmergenteCrearLista, BorderLayout.WEST);
		        panelBotonesBasicos.add(btnCrearListaEmergenteCrearLista, BorderLayout.EAST);
		        panelBotonesBasicos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));// top, left, bottom, right -> Ajusta un borde por pixeles

			        //Para que los botones cancelar y creat queden alineados, uso un panel extra abajo
			        JPanel panelInferior = new JPanel(new BorderLayout());
			        panelInferior.setBackground(blanco);//Color de fondo
			        panelInferior.setOpaque(detalles);//Mostrar detalles
			        panelInferior.add(panelBotonesBasicos, BorderLayout.SOUTH);

	        emergenteCrearLista.add(panelInferior, BorderLayout.SOUTH);
	        
	        emergenteCrearLista.setVisible(true);
			    
	        emergenteCrearLista.add(panelIngresarNombreLista, BorderLayout.CENTER);//Ubica centro
	    	
	    }

	      // -- // -- // -- // -- // -- // -- //
		 // -- // -- // GET & SET// -- // -- //
		// -- // -- // -- // -- // -- // -- //
	    
	    
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

		public static JPanel getPanelTableroTitulo() {
			return panelTableroTitulo;
		}

		public static void setPanelTableroTitulo(JPanel panelTableroTitulo) {
			FrameTablero.panelTableroTitulo = panelTableroTitulo;
		}

		public static JPanel getPanelTableroBody() {
			return panelTableroBody;
		}

		public static void setPanelTableroBody(JPanel panelTableroBody) {
			FrameTablero.panelTableroBody = panelTableroBody;
		}

		public static JPanel getPanelTablero() {
			return panelTablero;
		}

		public static void setPanelTablero(JPanel panelTablero) {
			FrameTablero.panelTablero = panelTablero;
		}

		public static JPanel getPanelInvisible() {
			return panelInvisible;
		}

		public static void setPanelInvisible(JPanel panelInvisible) {
			FrameTablero.panelInvisible = panelInvisible;
		}

		public static JTextField getTxtFieldIngresarNombreEmergenteCrearLista() {
			return txtFieldIngresarNombreEmergenteCrearLista;
		}

		public static void setTxtFieldIngresarNombreEmergenteCrearLista(JTextField txtFieldIngresarNombreEmergenteCrearLista) {
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

		public static Border getBorder() {
			return border;
		}

		public static void setBorder(Border border) {
			FrameTablero.border = border;
		}

		public static boolean isDetalles() {
			return detalles;
		}

		public static void setDetalles(boolean detalles) {
			FrameTablero.detalles = detalles;
		}

		public static String getMensajeIngresarNombreLista() {
			return mensajeIngresarNombreLista;
		}

		public static void setMensajeIngresarNombreLista(String mensajeIngresarNombreLista) {
			FrameTablero.mensajeIngresarNombreLista = mensajeIngresarNombreLista;
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
		
		
	    
}
