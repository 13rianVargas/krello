package co.edu.konradlorenz.view.gui;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import co.edu.konradlorenz.controller.*;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	//CONTROLADOR
	private static Controlador ctrl;
	
	//MOSTRAR DETALLES
	private static boolean detalles;
	
	//FRAMES
	private static JFrame frameLogin = new JFrame();
	
	//PANELS
	//JPanel invisiblePanel = new JPanel(); //PENDIENTE -> Este JPanel permite que el autofocus no sea el primer campo de texto. 
	private static JPanel panelLoginHead;
	private static JPanel panelLoginBody;
	private static JPanel panelRegisterBody;
	
	//LABELS
	private static JLabel lblLogin;
	
	//TEXTFIELDS
	private static JTextField txtLoginCorreo;
	private static JTextField txtLoginNombre;
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
	private static JButton btnLoginRegresar;
	private static JButton btnRegisterCrearCuenta;
	
	//Colores
	private static Color blanquito = new Color(255, 255, 255);
	private static Color moradito = new Color(98, 20, 109); 
	private static Color azulito = new Color(31, 165, 163);
	
	//Strings
		private static String mensajeIniciarSesionLogin="Inicia sesión para continuar", mensajeIngresarCorreoLogin="Ingresa tu correo", mensajeIngresarContraseñaLogin="Ingresa tu contraseña"
				, mensajeBtnContinuarLogin="Continuar", mensajeBtnCrearCuentaLogin="Crear cuenta";
		private static String mensajeCrearCuentaRegister="Crear una cuenta", ingresarCorreoRegister="Ingresa tu correo", ingresarNombreRegister="Ingresa tu nombre",
				ingresarContraseñaRegister="Ingresa tu contraseña", ingresarReContraseñaRegister="Re-ingresa tu contraseña", mensajeBtnCrearCuentaRegister="Crear cuenta", mensajeBtnRegresarRegistrar="< Regresar";
		
	
	//Método constructor del frame Login
	public Login (Controlador controlador) {
		
    	ctrl = controlador;//Llama al controller del AplMain
    	detalles = ctrl.detalles;//Ahora se cambia en el Controller para que actue en todo el GUI.
		
		frameLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);//Terminar la ejecución si se cierra la ventana
		frameLogin.setTitle("KRELLO");//Título de la ventana
		frameLogin.setSize(405,680);//ancho, alto
		frameLogin.setLocationRelativeTo(null);//Centra la ventana
		frameLogin.setLayout(null);//Desactiva el control automático de paneles
		frameLogin.setResizable(false);//No permite modificar el tamaño de la ventana
		frameLogin.setBackground(moradito);//Color de la barra de la ventana
		
		panelLoginHead = panelLoginHead();
		frameLogin.add(panelLoginHead);
		
		panelLoginBody = panelLoginBody();
		frameLogin.add(panelLoginBody);
		
		panelRegisterBody = panelRegisterBody();
		frameLogin.add(panelRegisterBody);
		
		frameLogin.setVisible(true);
	}
	//*/Login
	
	//Método para crear panelLoginHead
	public static JPanel panelLoginHead() {
	    JPanel panelLoginHead = new JPanel();
	    panelLoginHead.setLayout(null); // Desactiva el control automático de paneles
	    panelLoginHead.setBounds(0, 0, 405, 150); // x, y, ancho, alto
	    panelLoginHead.setBackground(Color.white); // Fondo del panel
	    panelLoginHead.setOpaque(true); // false -> transparente

	    JLabel lblKrelloLogo = new JLabel();
	    // Usa la clase específica en lugar de getClass()
	    ImageIcon logo = new ImageIcon(Login.class.getResource("/co/edu/konradlorenz/view/img/KrelloLogo187x60.png"));
	    if (logo.getImage() == null) {
	        System.err.println("No se pudo cargar el recurso: KrelloLogo187x60.png");
	    }
	    Image logored = logo.getImage();
	    logored = logored.getScaledInstance(220, 70, Image.SCALE_SMOOTH); // Cambiar "logored.SCALE_SMOOTH" a "Image.SCALE_SMOOTH"
	    lblKrelloLogo.setIcon(new ImageIcon(logored));
	    lblKrelloLogo.setBounds(0, 5, 405, 150); // x, y, ancho, altura
	    lblKrelloLogo.setHorizontalAlignment(SwingConstants.CENTER); // Centrar Horizontalmente

	    panelLoginHead.add(lblKrelloLogo);

	    return panelLoginHead;
	} 
	//*/panelLoginHead
	
	//Método para crear panelLoginBody
	public static JPanel panelLoginBody() {
		
		JPanel panelLoginBody= new JPanel();
		panelLoginBody.setLayout(null);//Desacriva el control automatico de paneles
		panelLoginBody.setBounds(0, 100, 405, 530);//x,y,ancho,alto
		panelLoginBody.setBackground(Color.white);//Fondo del panel
		panelLoginBody.setOpaque(true);//false -> transparente
		
		
			lblLogin = new JLabel(mensajeIniciarSesionLogin);
			lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogin.setBackground(Color.black);
			lblLogin.setBounds(67, 60, 250, 100);
			lblLogin.setFont(new Font("Calibri", Font.BOLD, 18));
			
		panelLoginBody.add(lblLogin);
		
			//Revisar para que se borre el mensaje al escribir
			txtLoginCorreo= new JTextField(mensajeIngresarCorreoLogin);
			txtLoginCorreo.setHorizontalAlignment(SwingConstants.CENTER);
			txtLoginCorreo.setBackground(Color.LIGHT_GRAY);
			txtLoginCorreo.setBounds(47, 140, 295, 40);
			txtLoginCorreo.setFont(new Font("Calibri", Font.ITALIC, 15));
			txtLoginCorreo.setForeground(Color.gray);
			
			txtLoginCorreo.addFocusListener(new FocusListener() {
		        @Override
		        public void focusGained(FocusEvent e) {
		            if (new String(txtLoginCorreo.getText()).equals(mensajeIngresarCorreoLogin)) {
		            	txtLoginCorreo.setText("");
		            	txtLoginCorreo.setForeground(Color.BLACK);
		            }
		        }

		        @Override
		        public void focusLost(FocusEvent e) {
		            //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
		            if (txtLoginCorreo.getText().length() == 0) {
		            	txtLoginCorreo.setForeground(Color.GRAY);
		            	txtLoginCorreo.setText(mensajeIngresarCorreoLogin);//Restaurar el texto placeholder
		            }
		        }
		    });
		    //TODO
			//txtLoginCorreo.addActionListener(enterLogin);
			
		panelLoginBody.add(txtLoginCorreo);
		
			pwdContraseña= new JPasswordField(mensajeIngresarContraseñaLogin);
			pwdContraseña.setHorizontalAlignment(SwingConstants.CENTER);
			pwdContraseña.setBackground(Color.LIGHT_GRAY);
			pwdContraseña.setBounds(47, 220, 295, 40);
			pwdContraseña.setFont(new Font("Calibri", Font.ITALIC, 15));
			pwdContraseña.setForeground(Color.gray);
			
			pwdContraseña.addFocusListener(new FocusListener() {
		        @Override
		        public void focusGained(FocusEvent e) {
		            if (new String(pwdContraseña.getPassword()).equals(mensajeIngresarContraseñaLogin)) {
		            	pwdContraseña.setText("");
		            	pwdContraseña.setForeground(Color.BLACK);
		            	pwdContraseña.setEchoChar('•');//Mostrar puntos
		            }
		        }

		        @Override
		        public void focusLost(FocusEvent e) {
		            //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
		            if (pwdContraseña.getPassword().length == 0) {
		            	pwdContraseña.setForeground(Color.GRAY);
		            	pwdContraseña.setText(mensajeIngresarContraseñaLogin);//Restaurar el texto placeholder
		            	pwdContraseña.setEchoChar((char) 0);//No mostrar puntos
		            }
		        }
		    });
		    //TODO
			//pwdContraseña.addActionListener(enterLogin);		
		panelLoginBody.add(pwdContraseña);
		
			btnLoginContinuar = new JButton(mensajeBtnContinuarLogin);
			btnLoginContinuar.setHorizontalAlignment(SwingConstants.CENTER);
			btnLoginContinuar.setBackground(moradito);
			btnLoginContinuar.setBounds(47, 300, 295, 40);
			btnLoginContinuar.setFont(new Font("Calibri", Font.ITALIC, 15));
			btnLoginContinuar.setForeground(Color.white);
			
			//Estas 3 lineas permiten que se pueda visualizar en macOS
			btnLoginContinuar.setOpaque(true);
			Border border = BorderFactory.createLineBorder(Color.MAGENTA, 2);
			btnLoginContinuar.setBorder(border);
			
		panelLoginBody.add(btnLoginContinuar);
		
			btnLoginCrearCuenta= new JButton(mensajeBtnCrearCuentaLogin);
			btnLoginCrearCuenta.setHorizontalAlignment(SwingConstants.CENTER);
			btnLoginCrearCuenta.setBackground(Color.WHITE);
			btnLoginCrearCuenta.setBounds(47, 360, 295, 40);
			btnLoginCrearCuenta.setFont(new Font("Calibri", Font.PLAIN, 15));
			btnLoginCrearCuenta.setForeground(azulito);
			btnLoginCrearCuenta.setBorder(null);
		
		panelLoginBody.add(btnLoginCrearCuenta);
		
		btnLoginContinuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.actionbtnContinuarLogin();
				
			}
		});
		
		return panelLoginBody;
	}
	
	//Register
		//Panel registerBody
	public static  JPanel panelRegisterBody() {
		JPanel panelRegisterBody= new JPanel();
		panelRegisterBody.setLayout(null);
		panelRegisterBody.setBounds(0, 100, 405, 530);
		panelRegisterBody.setBackground(blanquito);
		panelRegisterBody.setOpaque(true);
			
			lblLogin = new JLabel(mensajeCrearCuentaRegister);
			lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogin.setBackground(Color.black);
			lblLogin.setBounds(67, 60, 250, 100);
			lblLogin.setFont(new Font("Calibri", Font.BOLD, 18));
			
			panelRegisterBody.add(lblLogin);
			
			txtRegisterCorreo= new JTextField(ingresarCorreoRegister);
			txtRegisterCorreo.setHorizontalAlignment(SwingConstants.CENTER);
			txtRegisterCorreo.setBackground(Color.lightGray);
			txtRegisterCorreo.setBounds(47, 140, 295, 40);
			txtRegisterCorreo.setFont(new Font("Arial", Font.ITALIC, 15));
			txtRegisterCorreo.setForeground(Color.gray);
			
			txtRegisterCorreo.addFocusListener(new FocusListener() {
		        @Override
		        public void focusGained(FocusEvent e) {
		            if (new String(txtRegisterCorreo.getText()).equals(ingresarCorreoRegister)) {
		            	txtRegisterCorreo.setText("");
		            	txtRegisterCorreo.setForeground(Color.BLACK);
		            }
		        }

		        @Override
		        public void focusLost(FocusEvent e) {
		            //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
		            if (txtRegisterCorreo.getText().length() == 0) {
		            	txtRegisterCorreo.setForeground(Color.GRAY);
		            	txtRegisterCorreo.setText(ingresarCorreoRegister);//Restaurar el texto placeholder
		            }
		        }
		    });
		    //TODO
			//txtRegisterCorreo.addActionListener(enterLogin);
			
			panelRegisterBody.add(txtRegisterCorreo);
			
			txtRegisterNombre= new JTextField(ingresarNombreRegister);
			txtRegisterNombre.setHorizontalAlignment(SwingConstants.CENTER);
			txtRegisterNombre.setBackground(Color.lightGray);
			txtRegisterNombre.setBounds(47, 200, 295, 40);
			txtRegisterNombre.setFont(new Font("Arial", Font.ITALIC, 15));
			txtRegisterNombre.setForeground(Color.gray);
			
			txtRegisterNombre.addFocusListener(new FocusListener() {
		        @Override
		        public void focusGained(FocusEvent e) {
		            if (new String(txtRegisterNombre.getText()).equals(ingresarNombreRegister)) {
		            	txtRegisterNombre.setText("");
		            	txtRegisterNombre.setForeground(Color.BLACK);
		            }
		        }

		        @Override
		        public void focusLost(FocusEvent e) {
		            //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
		            if (txtRegisterNombre.getText().length() == 0) {
		            	txtRegisterNombre.setForeground(Color.GRAY);
		            	txtRegisterNombre.setText(ingresarNombreRegister);//Restaurar el texto placeholder
		            }
		        }
		    });
		    //TODO
		    //pwdField.addActionListener(enterLogin);

			panelRegisterBody.add(txtRegisterNombre);
			
			pwdReContraseña= new JPasswordField(ingresarContraseñaRegister);
			pwdReContraseña.setHorizontalAlignment(SwingConstants.CENTER);
			pwdReContraseña.setBackground(Color.LIGHT_GRAY);
			pwdReContraseña.setBounds(47, 260, 295, 40);
			pwdReContraseña.setFont(new Font("Calibri", Font.ITALIC, 15));
			pwdReContraseña.setForeground(Color.GRAY);
			
			pwdReContraseña.addFocusListener(new FocusListener() {
		        @Override
		        public void focusGained(FocusEvent e) {
		            if (new String(pwdReContraseña.getPassword()).equals(ingresarContraseñaRegister)) {
		            	pwdReContraseña.setText("");
		            	pwdReContraseña.setForeground(Color.BLACK);
		            	pwdReContraseña.setEchoChar('•');//Mostrar puntos
		            }
		        }

		        @Override
		        public void focusLost(FocusEvent e) {
		            //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
		            if (pwdReContraseña.getPassword().length == 0) {
		            	pwdReContraseña.setForeground(Color.GRAY);
		                pwdReContraseña.setText(ingresarContraseñaRegister);//Restaurar el texto placeholder
		                pwdReContraseña.setEchoChar((char) 0);//No mostrar puntos
		            }
		        }
		    });
		    //TODO crear metodo para que parpadee
			//pwdReContraseña.addActionListener(enterLogin);
			
			
			panelRegisterBody.add(pwdReContraseña);
			
			pwdReContraseñaDos= new JPasswordField(ingresarReContraseñaRegister);
			pwdReContraseñaDos.setHorizontalAlignment(SwingConstants.CENTER);
			pwdReContraseñaDos.setBackground(Color.LIGHT_GRAY);
			pwdReContraseñaDos.setBounds(47, 320, 295, 40);
			pwdReContraseñaDos.setFont(new Font("Calibri", Font.ITALIC, 15));
			pwdReContraseñaDos.setForeground(Color.GRAY);
			
			pwdReContraseñaDos.addFocusListener(new FocusListener() {
		        @Override
		        public void focusGained(FocusEvent e) {
		            if (new String(pwdReContraseñaDos.getPassword()).equals(ingresarReContraseñaRegister)) {
		            	pwdReContraseñaDos.setText("");
		            	pwdReContraseñaDos.setForeground(Color.BLACK);
		            	pwdReContraseñaDos.setEchoChar('•');//Mostrar puntos
		            }
		        }

		        @Override
		        public void focusLost(FocusEvent e) {
		            //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
		            if (pwdReContraseñaDos.getPassword().length == 0) {
		            	pwdReContraseñaDos.setForeground(Color.GRAY);
		            	pwdReContraseñaDos.setText(ingresarReContraseñaRegister);//Restaurar el texto placeholder
		            	pwdReContraseñaDos.setEchoChar((char) 0);//No mostrar puntos
		            }
		        }
		    });
		    
			//TODO
			//pwdReContraseñaDos.addActionListener(enterLogin);
			panelRegisterBody.add(pwdReContraseñaDos);
		
			btnRegisterCrearCuenta= new JButton(mensajeBtnCrearCuentaRegister);
			btnRegisterCrearCuenta.setHorizontalAlignment(SwingConstants.CENTER);
			btnRegisterCrearCuenta.setBackground(moradito);
			btnRegisterCrearCuenta.setBounds(47, 380, 295, 40);
			btnRegisterCrearCuenta.setFont(new Font("Calibri", Font.PLAIN, 15));
			btnRegisterCrearCuenta.setForeground(Color.WHITE);
			
			panelRegisterBody.add(btnRegisterCrearCuenta);
		
			btnLoginRegresar= new JButton(mensajeBtnRegresarRegistrar);
			btnLoginRegresar.setHorizontalAlignment(SwingConstants.LEFT);
			btnLoginRegresar.setBackground(Color.WHITE);
			btnLoginRegresar.setBounds(47, 460, 295, 40);
			btnLoginRegresar.setFont(new Font("Calibri", Font.PLAIN, 15));
			btnLoginRegresar.setForeground(azulito);
			btnLoginRegresar.setBorder(null);	
			
			panelRegisterBody.add(btnLoginRegresar);
			
			return panelRegisterBody;		
	}

	//Getters and Setters
	public static JFrame getFrameLogin() {
		return frameLogin;
	}

	public static void setFrameLogin(JFrame frameLogin) {
		Login.frameLogin = frameLogin;
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

	public static JLabel getLblLogin() {
		return lblLogin;
	}

	public static void setLblLogin(JLabel lblLogin) {
		Login.lblLogin = lblLogin;
	}

	public static JTextField getTxtLoginCorreo() {
		return txtLoginCorreo;
	}

	public static void setTxtLoginCorreo(JTextField txtLoginCorreo) {
		Login.txtLoginCorreo = txtLoginCorreo;
	}

	public static JTextField getTxtLoginNombre() {
		return txtLoginNombre;
	}

	public static void setTxtLoginNombre(JTextField txtLoginNombre) {
		Login.txtLoginNombre = txtLoginNombre;
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

	public static JButton getBtnLoginRegresar() {
		return btnLoginRegresar;
	}

	public static void setBtnLoginRegresar(JButton btnLoginRegresar) {
		Login.btnLoginRegresar = btnLoginRegresar;
	}

	public static JButton getBtnRegisterCrearCuenta() {
		return btnRegisterCrearCuenta;
	}

	public static void setBtnRegisterCrearCuenta(JButton btnRegisterCrearCuenta) {
		Login.btnRegisterCrearCuenta = btnRegisterCrearCuenta;
	}

	public static Color getBlanquito() {
		return blanquito;
	}

	public static void setBlanquito(Color blanquito) {
		Login.blanquito = blanquito;
	}

	public static Color getMoradito() {
		return moradito;
	}

	public static void setMoradito(Color moradito) {
		Login.moradito = moradito;
	}

	public static Color getAzulito() {
		return azulito;
	}

	public static void setAzulito(Color azulito) {
		Login.azulito = azulito;
	}

	public String getMensajeIniciarSesionLogin() {
		return mensajeIniciarSesionLogin;
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

	public static void setMensajeIniciarSesionLogin(String mensajeIniciarSesionLogin) {
		Login.mensajeIniciarSesionLogin = mensajeIniciarSesionLogin;
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

	//Mensajes y textos
	
}	

