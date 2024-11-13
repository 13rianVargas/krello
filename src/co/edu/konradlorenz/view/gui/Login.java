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
	
	//LABELS
	JLabel lblLogin;
	
	//TEXTFIELDS
	JTextField txtLoginCorreo;
	JTextField txtLoginNombre;
	
	//PASSWORDFIELDS
	JPasswordField pwdContraseña;
	JPasswordField pwdReContraseña;
	
	//BUTTONS
	JButton btnLoginContinuar;
	JButton btnLoginPanelCrearCuenta;
	JButton btnLoginCrearCuenta;
	JButton btnLoginRegresar;
	
	//Método constructor del frame Login
	public Login () {
		
		frameLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);//Terminar la ejecución si se cierra la ventana
		frameLogin.setTitle("KRELLO");//Título de la ventana
		frameLogin.setSize(405,680);//ancho, alto
		frameLogin.setLocationRelativeTo(null);//Centra la ventana
		frameLogin.setLayout(null);//Desactiva el control automático de paneles
		frameLogin.setResizable(false);//No permite modificar el tamaño de la ventana
		frameLogin.setBackground(Color.MAGENTA);//Color de la barra de la ventana
		
		panelLoginHead = panelLoginHead();
		frameLogin.add(panelLoginHead);
		
		panelLoginBody = panelLoginBody();
		frameLogin.add(panelLoginBody);
		
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
		
			txtLoginCorreo= new JTextField("Ingresa tu correo");
			txtLoginCorreo.setHorizontalAlignment(SwingConstants.CENTER);
			txtLoginCorreo.setBackground(Color.LIGHT_GRAY);
			txtLoginCorreo.setBounds(47, 140, 295, 40);
			txtLoginCorreo.setFont(new Font("Calibri", Font.ITALIC, 15));
			txtLoginCorreo.setForeground(Color.gray);
			
		panelLoginBody.add(txtLoginCorreo);
		
		
			//Revisar e focus para que el mensaje se revise correctamente :)
			pwdContraseña= new JPasswordField("Ingresa tu contraseña");
			pwdContraseña.setHorizontalAlignment(SwingConstants.CENTER);
			pwdContraseña.setBackground(Color.LIGHT_GRAY);
			pwdContraseña.setBounds(47, 220, 295, 40);
			pwdContraseña.setFont(new Font("Calibri", Font.ITALIC, 15));
			pwdContraseña.setForeground(Color.gray);
		
		panelLoginBody.add(pwdContraseña);
		
			btnLoginContinuar = new JButton("Continuar");
			btnLoginContinuar.setHorizontalAlignment(SwingConstants.CENTER);
			btnLoginContinuar.setBackground(Color.MAGENTA);
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
			btnLoginCrearCuenta.setForeground(Color.blue);
			btnLoginCrearCuenta.setBorder(null);
		
		panelLoginBody.add(btnLoginCrearCuenta);
			
		return panelLoginBody;
	}
	//*/panelLoginBody

	
}
