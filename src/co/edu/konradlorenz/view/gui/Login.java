package co.edu.konradlorenz.view.gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.*;

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
		
		//panelLoginBody = panelLoginBody();
		//frameLogin.add(panelLoginBody);
		
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
		
			lblLogin = new JLabel("Inicia sesión para continuar");
			lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogin.setBackground(Color.black);
			lblLogin.setBounds(67, 60, 250, 100);
			lblLogin.setFont(new Font("Calibri", Font.BOLD, 18));
			
		panelLoginBody.add(lblLogin);
		
			//Revisar para que se borre el mensaje al escribir
			txtLoginCorreo= new JTextField("Ingresa tu correo");
			txtLoginCorreo.setHorizontalAlignment(SwingConstants.CENTER);
			txtLoginCorreo.setBackground(Color.LIGHT_GRAY);
			txtLoginCorreo.setBounds(47, 140, 295, 40);
			txtLoginCorreo.setFont(new Font("Calibri", Font.ITALIC, 15));
			txtLoginCorreo.setForeground(Color.gray);
			
		panelLoginBody.add(txtLoginCorreo);
		
		
			//Revisar el focus para que el mensaje se revise correctamente :)
			pwdContraseña= new JPasswordField("Ingresa tu contraseña");
			pwdContraseña.setHorizontalAlignment(SwingConstants.CENTER);
			pwdContraseña.setBackground(Color.LIGHT_GRAY);
			pwdContraseña.setBounds(47, 220, 295, 40);
			pwdContraseña.setFont(new Font("Calibri", Font.ITALIC, 15));
			pwdContraseña.setForeground(Color.gray);
		
		panelLoginBody.add(pwdContraseña);
		
			btnLoginContinuar = new JButton("Continuar");
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
		
			btnLoginCrearCuenta= new JButton("Crear una cuenta");
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
			
			lblLogin = new JLabel("Crear una cuenta");
			lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogin.setBackground(Color.black);
			lblLogin.setBounds(67, 60, 250, 100);
			lblLogin.setFont(new Font("Calibri", Font.BOLD, 18));
			
			panelRegisterBody.add(lblLogin);
			
			txtRegisterCorreo= new JTextField("Ingresa tu correo");
			txtRegisterCorreo.setHorizontalAlignment(SwingConstants.CENTER);
			txtRegisterCorreo.setBackground(Color.lightGray);
			txtRegisterCorreo.setBounds(47, 140, 295, 40);
			txtRegisterCorreo.setFont(new Font("Arial", Font.ITALIC, 15));
			txtRegisterCorreo.setForeground(Color.gray);
			
			panelRegisterBody.add(txtRegisterCorreo);
			
			txtRegisterNombre= new JTextField("Ingresa tu nombre");
			txtRegisterNombre.setHorizontalAlignment(SwingConstants.CENTER);
			txtRegisterNombre.setBackground(Color.lightGray);
			txtRegisterNombre.setBounds(47, 200, 295, 40);
			txtRegisterNombre.setFont(new Font("Arial", Font.ITALIC, 15));
			txtRegisterNombre.setForeground(Color.gray);
			
			panelRegisterBody.add(txtRegisterNombre);
			
			pwdReContraseña= new JPasswordField("Ingresa tu contraseña");
			pwdReContraseña.setHorizontalAlignment(SwingConstants.CENTER);
			pwdReContraseña.setBackground(Color.LIGHT_GRAY);
			pwdReContraseña.setBounds(47, 260, 295, 40);
			pwdReContraseña.setFont(new Font("Calibri", Font.ITALIC, 15));
			pwdReContraseña.setForeground(Color.GRAY);
			
			panelRegisterBody.add(pwdReContraseña);
			
			pwdReContraseñaDos= new JPasswordField("Ingresa tu contraseña");
			pwdReContraseñaDos.setHorizontalAlignment(SwingConstants.CENTER);
			pwdReContraseñaDos.setBackground(Color.LIGHT_GRAY);
			pwdReContraseñaDos.setBounds(47, 320, 295, 40);
			pwdReContraseñaDos.setFont(new Font("Calibri", Font.ITALIC, 15));
			pwdReContraseñaDos.setForeground(Color.GRAY);
			
			panelRegisterBody.add(pwdReContraseñaDos);
		
			btnRegisterCrearCuenta= new JButton("Crear cuenta");
			btnRegisterCrearCuenta.setHorizontalAlignment(SwingConstants.CENTER);
			btnRegisterCrearCuenta.setBackground(moradito);
			btnRegisterCrearCuenta.setBounds(47, 380, 295, 40);
			btnRegisterCrearCuenta.setFont(new Font("Calibri", Font.PLAIN, 15));
			btnRegisterCrearCuenta.setForeground(Color.WHITE);
			
			panelRegisterBody.add(btnRegisterCrearCuenta);
		
			btnLoginRegresar= new JButton("< Regresar");
			btnLoginRegresar.setHorizontalAlignment(SwingConstants.LEFT);
			btnLoginRegresar.setBackground(Color.WHITE);
			btnLoginRegresar.setBounds(47, 460, 295, 40);
			btnLoginRegresar.setFont(new Font("Calibri", Font.PLAIN, 15));
			btnLoginRegresar.setForeground(azulito);
			btnLoginRegresar.setBorder(null);	
			
			panelRegisterBody.add(btnLoginRegresar);
			
			return panelRegisterBody;		
	}

}	

