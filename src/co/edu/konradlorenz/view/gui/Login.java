package co.edu.konradlorenz.view.gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.*;

import co.edu.konradlorenz.controller.FocusEvent;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	
	//FRAMES
	JFrame frameLogin = new JFrame();
	
	//PANELS
	//JPanel invisiblePanel = new JPanel(); //PENDIENTE -> Este JPanel permite que el autofocus no sea el primer campo de texto. 
	JPanel panelLoginHead;
	JPanel panelLoginBody;
	JPanel panelRegisterBody;
	
	//LABELS
	JLabel lblLogin;
	
	//TEXTFIELDS
	JTextField txtLoginCorreo;
	JTextField txtLoginNombre;
	JTextField txtRegisterCorreo;
	JTextField txtRegisterNombre;
	
	//PASSWORDFIELDS
	JPasswordField pwdContraseña;
	JPasswordField pwdReContraseña;
	JPasswordField pwdReContraseñaDos;
	
	//BUTTONS
	JButton btnLoginContinuar;
	JButton btnLoginPanelCrearCuenta;
	JButton btnLoginCrearCuenta;
	JButton btnLoginRegresar;
	JButton btnRegisterCrearCuenta;
	
	//Colores
	private static Color blanquito = new Color(255, 255, 255);
	private static Color moradito = new Color(98, 20, 109); 
	private static Color azulito = new Color(31, 165, 163);
	
	//Strings
	private String mensajeIniciarSesionLogin="Inicia sesión para continuar", mensajeIngresarCorreoLogin="Ingresa tu correo", mensajeIngresarContraseñaLogin="Ingresa tu contraseña"
			, mensajeBtnContinuarLogin="Continuar", mensajeBtnCrearCuentaLogin="Crear cuenta";
	private String mensajeCrearCuentaRegister="Crear una cuenta", ingresarCorreoRegister="Ingresa tu correo", ingresarNombreRegister="Ingresa tu nombre",
			ingresarContraseñaRegister="Ingresa tu contraseña", ingresarReContraseñaRegister="Re-ingresa tu contraseña", mensajeBtnCrearCuentaRegister="Crear cuenta", mensajeBtnRegresarRegistrar="< Regresar";
	
	//Método constructor del frame Login
	public Login () {
		
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
	private JPanel panelLoginHead() {
		
		JPanel panelLoginHead = new JPanel();
		panelLoginHead.setLayout(null);//Desactiva el control automático de paneles	   
		panelLoginHead.setBounds(0, 0, 405, 150);//x,y,ancho,alto
		panelLoginHead.setBackground(Color.white);//Fondo del panel
		panelLoginHead.setOpaque(true);//false -> transparente
		
			JLabel lblKrelloLogo = new JLabel();
			ImageIcon logo= new ImageIcon(getClass().getResource("/co/edu/konradlorenz/view/img/KrelloLogo187x60.png"));//Ruta de la imagen
			Image logored= logo.getImage();
			logored= logored.getScaledInstance(220, 70, logored.SCALE_SMOOTH);
			lblKrelloLogo.setIcon(new ImageIcon(logored));
			lblKrelloLogo.setBounds(0, 5, 405, 150);//x,y,ancho,altura
			lblKrelloLogo.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
	        
			panelLoginHead.add(lblKrelloLogo);
	        
		return panelLoginHead;
	}
	//*/panelLoginHead
	
	//Método para crear panelLoginBody
	private JPanel panelLoginBody() {
		
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
			
		panelLoginBody.add(txtLoginCorreo);
		
		
			//Revisar el focus para que el mensaje se revise correctamente :)
			pwdContraseña= new JPasswordField(mensajeIngresarContraseñaLogin);
			pwdContraseña.setHorizontalAlignment(SwingConstants.CENTER);
			pwdContraseña.setBackground(Color.LIGHT_GRAY);
			pwdContraseña.setBounds(47, 220, 295, 40);
			pwdContraseña.setFont(new Font("Calibri", Font.ITALIC, 15));
			pwdContraseña.setForeground(Color.gray);
		
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
		
		return panelLoginBody;
	}	
	
	//Register
		//Panel registerBody
	private JPanel panelRegisterBody() {
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
			
			panelRegisterBody.add(txtRegisterCorreo);
			
			txtRegisterNombre= new JTextField(ingresarNombreRegister);
			txtRegisterNombre.setHorizontalAlignment(SwingConstants.CENTER);
			txtRegisterNombre.setBackground(Color.lightGray);
			txtRegisterNombre.setBounds(47, 200, 295, 40);
			txtRegisterNombre.setFont(new Font("Arial", Font.ITALIC, 15));
			txtRegisterNombre.setForeground(Color.gray);
			
			panelRegisterBody.add(txtRegisterNombre);
			
			pwdReContraseña= new JPasswordField(ingresarContraseñaRegister);
			pwdReContraseña.setHorizontalAlignment(SwingConstants.CENTER);
			pwdReContraseña.setBackground(Color.LIGHT_GRAY);
			pwdReContraseña.setBounds(47, 260, 295, 40);
			pwdReContraseña.setFont(new Font("Calibri", Font.ITALIC, 15));
			pwdReContraseña.setForeground(Color.GRAY);
			
			panelRegisterBody.add(pwdReContraseña);
			
			pwdReContraseñaDos= new JPasswordField(ingresarReContraseñaRegister);
			pwdReContraseñaDos.setHorizontalAlignment(SwingConstants.CENTER);
			pwdReContraseñaDos.setBackground(Color.LIGHT_GRAY);
			pwdReContraseñaDos.setBounds(47, 320, 295, 40);
			pwdReContraseñaDos.setFont(new Font("Calibri", Font.ITALIC, 15));
			pwdReContraseñaDos.setForeground(Color.GRAY);
			
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

	
	
	public JFrame getFrameLogin() {
		return frameLogin;
	}

	public void setFrameLogin(JFrame frameLogin) {
		this.frameLogin = frameLogin;
	}

	public JPanel getPanelLoginHead() {
		return panelLoginHead;
	}

	public void setPanelLoginHead(JPanel panelLoginHead) {
		this.panelLoginHead = panelLoginHead;
	}

	public JPanel getPanelLoginBody() {
		return panelLoginBody;
	}

	public void setPanelLoginBody(JPanel panelLoginBody) {
		this.panelLoginBody = panelLoginBody;
	}

	public JPanel getPanelRegisterBody() {
		return panelRegisterBody;
	}

	public void setPanelRegisterBody(JPanel panelRegisterBody) {
		this.panelRegisterBody = panelRegisterBody;
	}

	public JLabel getLblLogin() {
		return lblLogin;
	}

	public void setLblLogin(JLabel lblLogin) {
		this.lblLogin = lblLogin;
	}

	public JTextField getTxtLoginCorreo() {
		return txtLoginCorreo;
	}

	public void setTxtLoginCorreo(JTextField txtLoginCorreo) {
		this.txtLoginCorreo = txtLoginCorreo;
	}

	public JTextField getTxtLoginNombre() {
		return txtLoginNombre;
	}

	public void setTxtLoginNombre(JTextField txtLoginNombre) {
		this.txtLoginNombre = txtLoginNombre;
	}

	public JTextField getTxtRegisterCorreo() {
		return txtRegisterCorreo;
	}

	public void setTxtRegisterCorreo(JTextField txtRegisterCorreo) {
		this.txtRegisterCorreo = txtRegisterCorreo;
	}

	public JTextField getTxtRegisterNombre() {
		return txtRegisterNombre;
	}

	public void setTxtRegisterNombre(JTextField txtRegisterNombre) {
		this.txtRegisterNombre = txtRegisterNombre;
	}

	public JPasswordField getPwdContraseña() {
		return pwdContraseña;
	}

	public void setPwdContraseña(JPasswordField pwdContraseña) {
		this.pwdContraseña = pwdContraseña;
	}

	public JPasswordField getPwdReContraseña() {
		return pwdReContraseña;
	}

	public void setPwdReContraseña(JPasswordField pwdReContraseña) {
		this.pwdReContraseña = pwdReContraseña;
	}

	public JPasswordField getPwdReContraseñaDos() {
		return pwdReContraseñaDos;
	}

	public void setPwdReContraseñaDos(JPasswordField pwdReContraseñaDos) {
		this.pwdReContraseñaDos = pwdReContraseñaDos;
	}

	public JButton getBtnLoginContinuar() {
		return btnLoginContinuar;
	}

	public void setBtnLoginContinuar(JButton btnLoginContinuar) {
		this.btnLoginContinuar = btnLoginContinuar;
	}

	public JButton getBtnLoginPanelCrearCuenta() {
		return btnLoginPanelCrearCuenta;
	}

	public void setBtnLoginPanelCrearCuenta(JButton btnLoginPanelCrearCuenta) {
		this.btnLoginPanelCrearCuenta = btnLoginPanelCrearCuenta;
	}

	public JButton getBtnLoginCrearCuenta() {
		return btnLoginCrearCuenta;
	}

	public void setBtnLoginCrearCuenta(JButton btnLoginCrearCuenta) {
		this.btnLoginCrearCuenta = btnLoginCrearCuenta;
	}

	public JButton getBtnLoginRegresar() {
		return btnLoginRegresar;
	}

	public void setBtnLoginRegresar(JButton btnLoginRegresar) {
		this.btnLoginRegresar = btnLoginRegresar;
	}

	public JButton getBtnRegisterCrearCuenta() {
		return btnRegisterCrearCuenta;
	}

	public void setBtnRegisterCrearCuenta(JButton btnRegisterCrearCuenta) {
		this.btnRegisterCrearCuenta = btnRegisterCrearCuenta;
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

	public void setMensajeIniciarSesionLogin(String mensajeIniciarSesionLogin) {
		this.mensajeIniciarSesionLogin = mensajeIniciarSesionLogin;
	}

	public String getMensajeIngresarCorreoLogin() {
		return mensajeIngresarCorreoLogin;
	}

	public void setMensajeIngresarCorreoLogin(String mensajeIngresarCorreoLogin) {
		this.mensajeIngresarCorreoLogin = mensajeIngresarCorreoLogin;
	}



	public String getMensajeBtnContinuarLogin() {
		return mensajeBtnContinuarLogin;
	}

	public void setMensajeBtnContinuarLogin(String mensajeBtnContinuarLogin) {
		this.mensajeBtnContinuarLogin = mensajeBtnContinuarLogin;
	}

	public String getMensajeBtnCrearCuentaLogin() {
		return mensajeBtnCrearCuentaLogin;
	}

	public void setMensajeBtnCrearCuentaLogin(String mensajeBtnCrearCuentaLogin) {
		this.mensajeBtnCrearCuentaLogin = mensajeBtnCrearCuentaLogin;
	}

	public String getMensajeCrearCuentaRegister() {
		return mensajeCrearCuentaRegister;
	}

	public void setMensajeCrearCuentaRegister(String mensajeCrearCuentaRegister) {
		this.mensajeCrearCuentaRegister = mensajeCrearCuentaRegister;
	}

	public String getIngresarCorreoRegister() {
		return ingresarCorreoRegister;
	}

	public void setIngresarCorreoRegister(String ingresarCorreoRegister) {
		this.ingresarCorreoRegister = ingresarCorreoRegister;
	}

	public String getIngresarNombreRegister() {
		return ingresarNombreRegister;
	}

	public void setIngresarNombreRegister(String ingresarNombreRegister) {
		this.ingresarNombreRegister = ingresarNombreRegister;
	}

	public String getIngresarContraseñaRegister() {
		return ingresarContraseñaRegister;
	}

	public void setIngresarContraseñaRegister(String ingresarContraseñaRegister) {
		this.ingresarContraseñaRegister = ingresarContraseñaRegister;
	}

	public String getIngresarReContraseñaRegister() {
		return ingresarReContraseñaRegister;
	}

	public void setIngresarReContraseñaRegister(String ingresarReContraseñaRegister) {
		this.ingresarReContraseñaRegister = ingresarReContraseñaRegister;
	}

	public String getMensajeBtnCrearCuentaRegister() {
		return mensajeBtnCrearCuentaRegister;
	}

	public void setMensajeBtnCrearCuentaRegister(String mensajeBtnCrearCuentaRegister) {
		this.mensajeBtnCrearCuentaRegister = mensajeBtnCrearCuentaRegister;
	}

	public String getMensajeIngresarContraseñaLogin() {
		return mensajeIngresarContraseñaLogin;
	}

	public void setMensajeIngresarContraseñaLogin(String mensajeIngresarContraseñaLogin) {
		this.mensajeIngresarContraseñaLogin = mensajeIngresarContraseñaLogin;
	}

	public String getMensajeBtnRegresarRegistrar() {
		return mensajeBtnRegresarRegistrar;
	}

	public void setMensajeBtnRegresarRegistrar(String mensajeBtnRegresarRegistrar) {
		this.mensajeBtnRegresarRegistrar = mensajeBtnRegresarRegistrar;
	}
}	

