package co.edu.konradlorenz.view.gui;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import co.edu.konradlorenz.controller.*;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	//CONTROLADOR
	private static Controlador ctrl;
	
	//MOSTRAR DETALLES
	private static boolean detalles;
	
	//FRAMES
	private static JFrame frameLogin;
	
	//CARDLAYOUT
	private static CardLayout cardLayout;
	
	//PANELS 
	private static JPanel panelLoginHead;
	private static JPanel panelLoginBody;
	private static JPanel panelRegisterBody;
	private static JPanel contenedor;
	
	//LABELS
	private static JLabel lblRegisterRegresar;
	
	//TEXTFIELDS
	private static JTextField txtLoginCorreo;
	private static JTextField txtRegisterCorreo;
	private static JTextField txtRegisterNombre;
	
	//PASSWORDFIELDS
	private static JPasswordField pwdContraseña;
	private static JPasswordField pwdReContraseña;
	private static JPasswordField pwdReContraseñaDos;
	
	//BUTTONS
	private static JButton btnLoginContinuar;
	private static JButton btnLoginPanelCrearCuenta;
	private static JButton btnLoginCrearCuenta;
	private static JButton btnRegisterCrearCuenta;
	
	//COLORS (Se inicializan en el Controller)
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
	
	//STRINGS LOGIN
	private static String mensajeIniciarSesionLogin = "Inicia sesión para continuar";
	private static String mensajeIngresarCorreoLogin = "Ingresa tu correo";
	private static String mensajeIngresarContraseñaLogin = "Ingresa tu contraseña";
	private static String mensajeBtnContinuarLogin = "Continuar";
	private static String mensajeBtnCrearCuentaLogin = "Crear cuenta";

	//STRINGS REGISTER
	private static String mensajeCrearCuentaRegister = "Crear una cuenta";
	private static String ingresarCorreoRegister = "Ingresa tu correo";
	private static String ingresarNombreRegister = "Ingresa tu nombre";
	private static String ingresarContraseñaRegister = "Ingresa tu contraseña";
	private static String ingresarReContraseñaRegister = "Re-ingresa tu contraseña";
	private static String mensajeBtnCrearCuentaRegister = "Crear cuenta";
	private static String mensajeBtnRegresarRegistrar = "Regresar";
	
	
	
	
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // VENTANAS // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
    //Abre: Constructor del frame Login
	public Login (Controlador controlador) {
		
		//Inicializaciones que dependen del Controlador
    	ctrl = controlador;//Llama al controller del AplMain
    	detalles = ctrl.detalles;
    	cardLayout = new CardLayout();
    	contenedor= new JPanel(cardLayout);
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
    	frameLogin = new JFrame();
		frameLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);//Terminar la ejecución si se cierra la ventana
		frameLogin.setTitle("KRELLO");//Título de la ventana
		frameLogin.setSize(405,680);//ancho, alto
		frameLogin.setLocationRelativeTo(null);//Centra la ventana
		frameLogin.setLayout(null);//Desactiva el control automático de paneles
		frameLogin.setResizable(false);//No permite modificar el tamaño de la ventana
		frameLogin.setBackground(blanco);//Color de la barra de la ventana
		frameLogin.getContentPane().setBackground(blanco);//Color de la barra de la ventana
	
	    panelLoginHead = panelLoginHead();
	    panelLoginBody = panelLoginBody();

	    panelRegisterBody = panelRegisterBody();
	    
	    contenedor.setLayout(cardLayout);
	    contenedor.add(panelLoginBody, "panelLoginBody");
	    contenedor.add(panelRegisterBody, "panelRegisterBody");
	    contenedor.setBounds(0, 100, 405, 552);
	    contenedor.setBackground(blanco);//Color de fondo

	    frameLogin.add(panelLoginHead);
	    frameLogin.add(contenedor);

	    frameLogin.setVisible(true);
	    
	    SwingUtilities.invokeLater(() -> btnLoginContinuar.requestFocusInWindow());//Enfoca un componente específico al abrir la ventana
	    
	}
    //Cierra: Constructor del frame Login
	
	
	
	
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- //  LOGIN   // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
    //Abre: Método para crear el panelLoginHead
	public static JPanel panelLoginHead() {
	    panelLoginHead = new JPanel();
	    panelLoginHead.setLayout(null); // Desactiva el control automático de paneles
	    panelLoginHead.setBounds(0, 0, 405, 150); // x, y, ancho, alto
	    panelLoginHead.setBackground(limon);//Color de fondo
	    panelLoginHead.setOpaque(false);//Mostrar detalles

	    JLabel lblKrelloLogo = new JLabel();
	    // Usa la clase específica en lugar de getClass()
	    ImageIcon logo = new ImageIcon(Login.class.getResource("/co/edu/konradlorenz/view/img/KrelloLogo187x60.png"));
	    if (logo.getImage() == null) {
	        System.err.println("No se pudo cargar el recurso: KrelloLogo187x60.png");
	    }
	    Image logored = logo.getImage();
	    logored = logored.getScaledInstance(220, 80, Image.SCALE_SMOOTH); // Cambiar "logored.SCALE_SMOOTH" a "Image.SCALE_SMOOTH"
	    lblKrelloLogo.setIcon(new ImageIcon(logored));
	    lblKrelloLogo.setBounds(0, 5, 405, 110); // x, y, ancho, altura
	    lblKrelloLogo.setHorizontalAlignment(SwingConstants.CENTER); // Centrar Horizontalmente
	    lblKrelloLogo.setBackground(aguacate);//Color de fondo
	    lblKrelloLogo.setOpaque(false);//Mostrar detalles

	    panelLoginHead.add(lblKrelloLogo);

	    return panelLoginHead;
	} 
    //Abre: Método para crear el panelLoginHead
	
    //Abre: Método para crear el panelLoginBody
	public static JPanel panelLoginBody() {
		
		panelLoginBody= new JPanel();//570
		panelLoginBody.setLayout(null);//Desacriva el control automatico de paneles
		panelLoginBody.setBounds(0, 100, 405, 530);//x,y,ancho,alto
		panelLoginBody.setBackground(rosa);//Color de fondo
		panelLoginBody.setOpaque(false);//Mostrar detalles
		
			JLabel lblLogin = new JLabel(mensajeIniciarSesionLogin);
			lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogin.setFont(new Font("Calibri", Font.BOLD, 18));
			lblLogin.setBounds(50, 100, 305, 40);//0, 50, 100
			lblLogin.setBackground(cyan);//Color de fondo
			lblLogin.setOpaque(false);//Mostrar detalles
			
		panelLoginBody.add(lblLogin);
		
			//Revisar para que se borre el mensaje al escribir
			txtLoginCorreo= new JTextField(mensajeIngresarCorreoLogin);
			txtLoginCorreo.setHorizontalAlignment(SwingConstants.CENTER);
			txtLoginCorreo.setBackground(gris2);
			txtLoginCorreo.setBounds(50, (357/2), 305, 40);
			txtLoginCorreo.setFont(new Font("Calibri", Font.ITALIC, 15));
			txtLoginCorreo.setForeground(gris);
			txtLoginCorreo.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor para texto
			
				txtLoginCorreo.addFocusListener(new FocusListener() {
			        @Override
			        public void focusGained(FocusEvent e) {
			            if (new String(txtLoginCorreo.getText()).equals(mensajeIngresarCorreoLogin)) {
			            	txtLoginCorreo.setText("");
			            	txtLoginCorreo.setForeground(negro);
			            }
			        }
	
			        @Override
			        public void focusLost(FocusEvent e) {
			            //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
			            if (txtLoginCorreo.getText().length() == 0) {
			            	txtLoginCorreo.setForeground(gris);
			            	txtLoginCorreo.setText(mensajeIngresarCorreoLogin);//Restaurar el texto placeholder
			            }
			        }
			    });
			    
				txtLoginCorreo.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ctrl.actionBtnContinuarLogin();						
					}
				});
			
		panelLoginBody.add(txtLoginCorreo);
		
			pwdContraseña= new JPasswordField(mensajeIngresarContraseñaLogin);
			pwdContraseña.setHorizontalAlignment(SwingConstants.CENTER);
			pwdContraseña.setBackground(gris2);
			pwdContraseña.setBounds(50, 257, 305, 40);
			pwdContraseña.setFont(new Font("Calibri", Font.ITALIC, 15));
			pwdContraseña.setForeground(gris);
			pwdContraseña.setEchoChar((char) 0);
			pwdContraseña.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor para texto
			
			
				pwdContraseña.addFocusListener(new FocusListener() {
		        @Override
		        public void focusGained(FocusEvent e) {
		            if (new String(pwdContraseña.getPassword()).equals(mensajeIngresarContraseñaLogin)) {
		            	pwdContraseña.setText("");
		            	pwdContraseña.setForeground(negro);
		            	pwdContraseña.setEchoChar('•');//Mostrar puntos
		            }
		        }

		        @Override
		        public void focusLost(FocusEvent e) {
		            //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
		            if (pwdContraseña.getPassword().length == 0) {
		            	pwdContraseña.setForeground(gris);
		            	pwdContraseña.setText(mensajeIngresarContraseñaLogin);//Restaurar el texto placeholder
		            	pwdContraseña.setEchoChar((char) 0);//No mostrar puntos
		            }
		        }
		    });
			   
				pwdContraseña.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ctrl.actionBtnContinuarLogin();						
					}
				});		
		
		panelLoginBody.add(pwdContraseña);
		
			btnLoginContinuar = new JButton(mensajeBtnContinuarLogin);
			btnLoginContinuar.setHorizontalAlignment(SwingConstants.CENTER);
			btnLoginContinuar.setBackground(morado);
			btnLoginContinuar.setBounds(50, (671/2), 305, 40);
			btnLoginContinuar.setFont(new Font("Calibri", Font.ITALIC, 15));
			btnLoginContinuar.setForeground(blanco);
			btnLoginContinuar.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
			
				btnLoginContinuar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ctrl.actionBtnContinuarLogin();
				}
			});
			
		panelLoginBody.add(btnLoginContinuar);
		
			btnLoginCrearCuenta= new JButton(mensajeBtnCrearCuentaLogin);
			btnLoginCrearCuenta.setHorizontalAlignment(SwingConstants.CENTER);
			btnLoginCrearCuenta.setBackground(blanco);
			btnLoginCrearCuenta.setBounds(50, 414, 305, 40);//414, 454, 554
			btnLoginCrearCuenta.setFont(new Font("Calibri", Font.PLAIN, 15));
			btnLoginCrearCuenta.setForeground(azulito);
			btnLoginCrearCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
			
				btnLoginCrearCuenta.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ctrl.actionBtnCrearCuentaLogin();			
				}
			});
		
		panelLoginBody.add(btnLoginCrearCuenta);

		
		
		
		return panelLoginBody;
	}
    //Cierra: Método para crear el panelLoginBody
	
	
	
	
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // REGISTER // -- // -- //
	// -- // -- // -- // -- // -- // -- //
    //Abre: Método para crear el panelRegisterBody
	public static  JPanel panelRegisterBody() {
		panelRegisterBody= new JPanel();
		panelRegisterBody.setLayout(null);//Desacriva el control automatico de paneles
		panelRegisterBody.setBounds(0, 100, 405, 530);
		panelRegisterBody.setBackground(rosa);//Color de fondo
		panelRegisterBody.setOpaque(false);//Mostrar detalles
			
			JLabel lblLogin = new JLabel(mensajeCrearCuentaRegister);
			lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogin.setFont(new Font("Calibri", Font.BOLD, 18));
			lblLogin.setBounds(50, 50, 305, 40);//0, 50, 100
			lblLogin.setBackground(cyan);//Color de fondo
			lblLogin.setOpaque(false);//Mostrar detalles
			
		panelRegisterBody.add(lblLogin);//(908/13)
			
			txtRegisterCorreo= new JTextField(ingresarCorreoRegister);
			txtRegisterCorreo.setHorizontalAlignment(SwingConstants.CENTER);
			txtRegisterCorreo.setBackground(gris2);
			txtRegisterCorreo.setBounds(50, (1558/13), 305, 40);
			txtRegisterCorreo.setFont(new Font("Calibri", Font.ITALIC, 15));
			txtRegisterCorreo.setForeground(gris);
			txtRegisterCorreo.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor para texto
			
				txtRegisterCorreo.addFocusListener(new FocusListener() {
			        @Override
			        public void focusGained(FocusEvent e) {
			            if (new String(txtRegisterCorreo.getText()).equals(ingresarCorreoRegister)) {
			            	txtRegisterCorreo.setText("");
			            	txtRegisterCorreo.setForeground(negro);
			            }
			        }
	
			        @Override
			        public void focusLost(FocusEvent e) {
			            //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
			            if (txtRegisterCorreo.getText().length() == 0) {
			            	txtRegisterCorreo.setForeground(gris);
			            	txtRegisterCorreo.setText(ingresarCorreoRegister);//Restaurar el texto placeholder
			            }
			        }
			    });
			    
				txtRegisterCorreo.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ctrl.actionBtnRegisterCrearCuenta();		
					}
				});
			
		panelRegisterBody.add(txtRegisterCorreo);
			
			txtRegisterNombre= new JTextField(ingresarNombreRegister);
			txtRegisterNombre.setHorizontalAlignment(SwingConstants.CENTER);
			txtRegisterNombre.setBackground(gris2);
			txtRegisterNombre.setBounds(50, (2466/13), 305, 40);
			txtRegisterNombre.setFont(new Font("Calibri", Font.ITALIC, 15));
			txtRegisterNombre.setForeground(gris);
			txtRegisterNombre.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor para texto
			
				txtRegisterNombre.addFocusListener(new FocusListener() {
			        @Override
			        public void focusGained(FocusEvent e) {
			            if (new String(txtRegisterNombre.getText()).equals(ingresarNombreRegister)) {
			            	txtRegisterNombre.setText("");
			            	txtRegisterNombre.setForeground(negro);
			            }
			        }
	
			        @Override
			        public void focusLost(FocusEvent e) {
			            //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
			            if (txtRegisterNombre.getText().length() == 0) {
			            	txtRegisterNombre.setForeground(gris);
			            	txtRegisterNombre.setText(ingresarNombreRegister);//Restaurar el texto placeholder
			            }
			        }
			    });
			    
			    txtRegisterNombre.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ctrl.actionBtnRegisterCrearCuenta();						
					}
				});

		panelRegisterBody.add(txtRegisterNombre);
			
			pwdReContraseña= new JPasswordField(ingresarContraseñaRegister);
			pwdReContraseña.setHorizontalAlignment(SwingConstants.CENTER);
			pwdReContraseña.setBackground(gris2);
			pwdReContraseña.setBounds(50, (3374/13), 305, 40);
			pwdReContraseña.setFont(new Font("Calibri", Font.ITALIC, 15));
			pwdReContraseña.setForeground(gris);
			pwdReContraseña.setEchoChar((char) 0);
			pwdReContraseña.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor para texto
			
				pwdReContraseña.addFocusListener(new FocusListener() {
			        @Override
			        public void focusGained(FocusEvent e) {
			            if (new String(pwdReContraseña.getPassword()).equals(ingresarContraseñaRegister)) {
			            	pwdReContraseña.setText("");
			            	pwdReContraseña.setForeground(negro);
			            	pwdReContraseña.setEchoChar('•');//Mostrar puntos
			            }
			        }
	
			        @Override
			        public void focusLost(FocusEvent e) {
			            //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
			            if (pwdReContraseña.getPassword().length == 0) {
			            	pwdReContraseña.setForeground(gris);
			                pwdReContraseña.setText(ingresarContraseñaRegister);//Restaurar el texto placeholder
			                pwdReContraseña.setEchoChar((char) 0);//No mostrar puntos
			            }
			        }
			    });

				pwdReContraseña.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ctrl.actionBtnRegisterCrearCuenta();						
					}
				});
			
			
			panelRegisterBody.add(pwdReContraseña);
			
			pwdReContraseñaDos= new JPasswordField(ingresarReContraseñaRegister);
			pwdReContraseñaDos.setHorizontalAlignment(SwingConstants.CENTER);
			pwdReContraseñaDos.setBackground(gris2);
			pwdReContraseñaDos.setBounds(50, (4282/13), 305, 40);
			pwdReContraseñaDos.setFont(new Font("Calibri", Font.ITALIC, 15));
			pwdReContraseñaDos.setForeground(gris);
			pwdReContraseñaDos.setEchoChar((char) 0);
			pwdReContraseñaDos.setCursor(new Cursor(Cursor.TEXT_CURSOR));//Pone el cursor para texto
			
				pwdReContraseñaDos.addFocusListener(new FocusListener() {
			        @Override
			        public void focusGained(FocusEvent e) {
			            if (new String(pwdReContraseñaDos.getPassword()).equals(ingresarReContraseñaRegister)) {
			            	pwdReContraseñaDos.setText("");
			            	pwdReContraseñaDos.setForeground(negro);
			            	pwdReContraseñaDos.setEchoChar('•');//Mostrar puntos
			            }
			        }
	
			        @Override
			        public void focusLost(FocusEvent e) {
			            //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
			            if (pwdReContraseñaDos.getPassword().length == 0) {
			            	pwdReContraseñaDos.setForeground(gris);
			            	pwdReContraseñaDos.setText(ingresarReContraseñaRegister);//Restaurar el texto placeholder
			            	pwdReContraseñaDos.setEchoChar((char) 0);//No mostrar puntos
			            }
			        }
			    });
		    
				pwdReContraseñaDos.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ctrl.actionBtnRegisterCrearCuenta();						
					}
				});
				
				panelRegisterBody.add(pwdReContraseñaDos);
		
			btnRegisterCrearCuenta= new JButton(mensajeBtnCrearCuentaRegister);
			btnRegisterCrearCuenta.setHorizontalAlignment(SwingConstants.CENTER);
			btnRegisterCrearCuenta.setBackground(morado);
			btnRegisterCrearCuenta.setBounds(50, (5190/13), 305, 40);
			btnRegisterCrearCuenta.setFont(new Font("Calibri", Font.PLAIN, 15));
			btnRegisterCrearCuenta.setForeground(blanco);
			btnRegisterCrearCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
			
			btnRegisterCrearCuenta.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ctrl.actionBtnRegisterCrearCuenta();
				}
			});
			
			panelRegisterBody.add(btnRegisterCrearCuenta);
		
			lblRegisterRegresar= new JLabel("< " + mensajeBtnRegresarRegistrar);
			lblRegisterRegresar.setHorizontalAlignment(SwingConstants.LEFT);
			lblRegisterRegresar.setBounds(50, (6098/13), 80, 19);//464 , 504, 554
			lblRegisterRegresar.setFont(new Font("Calibri", Font.PLAIN, 15));
			lblRegisterRegresar.setForeground(azulito);
			lblRegisterRegresar.setBackground(verde);//Color de fondo
			lblRegisterRegresar.setOpaque(false);//Mostrar detalles
			lblRegisterRegresar.setCursor(new Cursor(Cursor.HAND_CURSOR));//Pone el cursor con una manita
			
			
				lblRegisterRegresar.addMouseListener(new MouseAdapter() {
	        		@Override
	        		public void mouseEntered(MouseEvent e) {
	        			lblRegisterRegresar.setText("<html><u>" + "&lt; " + "Regresar" + "</u></html>");//Lo subraya al poner el cursor encima
	        		}
		            @Override
		            public void mouseExited(MouseEvent e) {
		            	lblRegisterRegresar.setText("< " + mensajeBtnRegresarRegistrar);//Elimina el subrayado cuando el mouse no está encima
		            }
		            @Override
		        	public void mouseClicked(MouseEvent e) {
		            	ctrl.actionBtnRegresarRegister();
		            }
		        });
				
			panelRegisterBody.add(lblRegisterRegresar);
        	
			
			return panelRegisterBody;		
	}
    //Cierra: Método para crear el panelRegisterBody
	
	
	
	
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // GET & SET// -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
	public static Controlador getCtrl() {
		return ctrl;
	}
	
	public static void setCtrl(Controlador ctrl) {
		Login.ctrl = ctrl;
	}

	public static boolean isDetalles() {
		return detalles;
	}

	public static void setDetalles(boolean detalles) {
		Login.detalles = detalles;
	}

	public static JFrame getFrameLogin() {
		return frameLogin;
	}

	public static void setFrameLogin(JFrame frameLogin) {
		Login.frameLogin = frameLogin;
	}

	public static CardLayout getCardLayout() {
		return cardLayout;
	}

	public static void setCardLayout(CardLayout cardLayout) {
		Login.cardLayout = cardLayout;
	}

	public static JPanel getPanelLoginHead() {
		return panelLoginHead;
	}

	public static void setPanelLoginHead(JPanel panelLoginHead) {
		Login.panelLoginHead = panelLoginHead;
	}

	public static JPanel getPanelLoginBody() {
		return panelLoginBody;
	}

	public static void setPanelLoginBody(JPanel panelLoginBody) {
		Login.panelLoginBody = panelLoginBody;
	}

	public static JPanel getPanelRegisterBody() {
		return panelRegisterBody;
	}

	public static void setPanelRegisterBody(JPanel panelRegisterBody) {
		Login.panelRegisterBody = panelRegisterBody;
	}

	public static JPanel getContenedor() {
		return contenedor;
	}

	public static void setContenedor(JPanel contenedor) {
		Login.contenedor = contenedor;
	}
	
	public static JTextField getTxtLoginCorreo() {
		return txtLoginCorreo;
	}

	public static void setTxtLoginCorreo(JTextField txtLoginCorreo) {
		Login.txtLoginCorreo = txtLoginCorreo;
	}

	public static JTextField getTxtRegisterCorreo() {
		return txtRegisterCorreo;
	}

	public static void setTxtRegisterCorreo(JTextField txtRegisterCorreo) {
		Login.txtRegisterCorreo = txtRegisterCorreo;
	}

	public static JTextField getTxtRegisterNombre() {
		return txtRegisterNombre;
	}

	public static void setTxtRegisterNombre(JTextField txtRegisterNombre) {
		Login.txtRegisterNombre = txtRegisterNombre;
	}

	public static JPasswordField getPwdContraseña() {
		return pwdContraseña;
	}

	public static void setPwdContraseña(JPasswordField pwdContraseña) {
		Login.pwdContraseña = pwdContraseña;
	}

	public static JPasswordField getPwdReContraseña() {
		return pwdReContraseña;
	}

	public static void setPwdReContraseña(JPasswordField pwdReContraseña) {
		Login.pwdReContraseña = pwdReContraseña;
	}

	public static JPasswordField getPwdReContraseñaDos() {
		return pwdReContraseñaDos;
	}

	public static void setPwdReContraseñaDos(JPasswordField pwdReContraseñaDos) {
		Login.pwdReContraseñaDos = pwdReContraseñaDos;
	}

	public static JButton getBtnLoginContinuar() {
		return btnLoginContinuar;
	}

	public static void setBtnLoginContinuar(JButton btnLoginContinuar) {
		Login.btnLoginContinuar = btnLoginContinuar;
	}

	public static JButton getBtnLoginPanelCrearCuenta() {
		return btnLoginPanelCrearCuenta;
	}

	public static void setBtnLoginPanelCrearCuenta(JButton btnLoginPanelCrearCuenta) {
		Login.btnLoginPanelCrearCuenta = btnLoginPanelCrearCuenta;
	}

	public static JButton getBtnLoginCrearCuenta() {
		return btnLoginCrearCuenta;
	}

	public static void setBtnLoginCrearCuenta(JButton btnLoginCrearCuenta) {
		Login.btnLoginCrearCuenta = btnLoginCrearCuenta;
	}

	public static JLabel getLblRegisterRegresar() {
		return lblRegisterRegresar;
	}

	public static void setLblRegisterRegresar(JLabel lblRegisterRegresar) {
		Login.lblRegisterRegresar = lblRegisterRegresar;
	}

	public static JButton getBtnRegisterCrearCuenta() {
		return btnRegisterCrearCuenta;
	}

	public static void setBtnRegisterCrearCuenta(JButton btnRegisterCrearCuenta) {
		Login.btnRegisterCrearCuenta = btnRegisterCrearCuenta;
	}

	public static Color getNegro() {
		return negro;
	}

	public static void setNegro(Color negro) {
		Login.negro = negro;
	}

	public static Color getBlanco() {
		return blanco;
	}

	public static void setBlanco(Color blanco) {
		Login.blanco = blanco;
	}

	public static Color getRojo() {
		return rojo;
	}

	public static void setRojo(Color rojo) {
		Login.rojo = rojo;
	}

	public static Color getVerde() {
		return verde;
	}

	public static void setVerde(Color verde) {
		Login.verde = verde;
	}

	public static Color getMillos() {
		return millos;
	}

	public static void setMillos(Color millos) {
		Login.millos = millos;
	}

	public static Color getAzulito() {
		return azulito;
	}

	public static void setAzulito(Color azulito) {
		Login.azulito = azulito;
	}

	public static Color getRosa() {
		return rosa;
	}

	public static void setRosa(Color rosa) {
		Login.rosa = rosa;
	}

	public static Color getRosa2() {
		return rosa2;
	}

	public static void setRosa2(Color rosa2) {
		Login.rosa2 = rosa2;
	}

	public static Color getCyan() {
		return cyan;
	}

	public static void setCyan(Color cyan) {
		Login.cyan = cyan;
	}

	public static Color getCyan2() {
		return cyan2;
	}

	public static void setCyan2(Color cyan2) {
		Login.cyan2 = cyan2;
	}

	public static Color getGris() {
		return gris;
	}

	public static void setGris(Color gris) {
		Login.gris = gris;
	}

	public static Color getGris2() {
		return gris2;
	}

	public static void setGris2(Color gris2) {
		Login.gris2 = gris2;
	}

	public static Color getMorado() {
		return morado;
	}

	public static void setMorado(Color morado) {
		Login.morado = morado;
	}

	public static Color getMorado2() {
		return morado2;
	}

	public static void setMorado2(Color morado2) {
		Login.morado2 = morado2;
	}

	public static Color getMorado3() {
		return morado3;
	}

	public static void setMorado3(Color morado3) {
		Login.morado3 = morado3;
	}

	public static Color getAguacate() {
		return aguacate;
	}

	public static void setAguacate(Color aguacate) {
		Login.aguacate = aguacate;
	}

	public static Color getPetroleo() {
		return petroleo;
	}

	public static void setPetroleo(Color petroleo) {
		Login.petroleo = petroleo;
	}

	public static Color getPetroleo2() {
		return petroleo2;
	}

	public static void setPetroleo2(Color petroleo2) {
		Login.petroleo2 = petroleo2;
	}

	public static Color getLimon() {
		return limon;
	}

	public static void setLimon(Color limon) {
		Login.limon = limon;
	}

	public static Color getLimon2() {
		return limon2;
	}

	public static void setLimon2(Color limon2) {
		Login.limon2 = limon2;
	}

	public static Color getLimon3() {
		return limon3;
	}

	public static void setLimon3(Color limon3) {
		Login.limon3 = limon3;
	}

	public static String getMensajeIniciarSesionLogin() {
		return mensajeIniciarSesionLogin;
	}

	public static void setMensajeIniciarSesionLogin(String mensajeIniciarSesionLogin) {
		Login.mensajeIniciarSesionLogin = mensajeIniciarSesionLogin;
	}

	public static String getMensajeIngresarCorreoLogin() {
		return mensajeIngresarCorreoLogin;
	}

	public static void setMensajeIngresarCorreoLogin(String mensajeIngresarCorreoLogin) {
		Login.mensajeIngresarCorreoLogin = mensajeIngresarCorreoLogin;
	}

	public static String getMensajeIngresarContraseñaLogin() {
		return mensajeIngresarContraseñaLogin;
	}

	public static void setMensajeIngresarContraseñaLogin(String mensajeIngresarContraseñaLogin) {
		Login.mensajeIngresarContraseñaLogin = mensajeIngresarContraseñaLogin;
	}

	public static String getMensajeBtnContinuarLogin() {
		return mensajeBtnContinuarLogin;
	}

	public static void setMensajeBtnContinuarLogin(String mensajeBtnContinuarLogin) {
		Login.mensajeBtnContinuarLogin = mensajeBtnContinuarLogin;
	}

	public static String getMensajeBtnCrearCuentaLogin() {
		return mensajeBtnCrearCuentaLogin;
	}

	public static void setMensajeBtnCrearCuentaLogin(String mensajeBtnCrearCuentaLogin) {
		Login.mensajeBtnCrearCuentaLogin = mensajeBtnCrearCuentaLogin;
	}

	public static String getMensajeCrearCuentaRegister() {
		return mensajeCrearCuentaRegister;
	}

	public static void setMensajeCrearCuentaRegister(String mensajeCrearCuentaRegister) {
		Login.mensajeCrearCuentaRegister = mensajeCrearCuentaRegister;
	}

	public static String getIngresarCorreoRegister() {
		return ingresarCorreoRegister;
	}

	public static void setIngresarCorreoRegister(String ingresarCorreoRegister) {
		Login.ingresarCorreoRegister = ingresarCorreoRegister;
	}

	public static String getIngresarNombreRegister() {
		return ingresarNombreRegister;
	}

	public static void setIngresarNombreRegister(String ingresarNombreRegister) {
		Login.ingresarNombreRegister = ingresarNombreRegister;
	}

	public static String getIngresarContraseñaRegister() {
		return ingresarContraseñaRegister;
	}

	public static void setIngresarContraseñaRegister(String ingresarContraseñaRegister) {
		Login.ingresarContraseñaRegister = ingresarContraseñaRegister;
	}

	public static String getIngresarReContraseñaRegister() {
		return ingresarReContraseñaRegister;
	}

	public static void setIngresarReContraseñaRegister(String ingresarReContraseñaRegister) {
		Login.ingresarReContraseñaRegister = ingresarReContraseñaRegister;
	}

	public static String getMensajeBtnCrearCuentaRegister() {
		return mensajeBtnCrearCuentaRegister;
	}

	public static void setMensajeBtnCrearCuentaRegister(String mensajeBtnCrearCuentaRegister) {
		Login.mensajeBtnCrearCuentaRegister = mensajeBtnCrearCuentaRegister;
	}

	public static String getMensajeBtnRegresarRegistrar() {
		return mensajeBtnRegresarRegistrar;
	}

	public static void setMensajeBtnRegresarRegistrar(String mensajeBtnRegresarRegistrar) {
		Login.mensajeBtnRegresarRegistrar = mensajeBtnRegresarRegistrar;
	}

}	
//class