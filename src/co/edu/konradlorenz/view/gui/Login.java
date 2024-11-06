package co.edu.konradlorenz.view.gui;

import java.awt.Color;

import javax.swing.*;

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
		frameLogin.setSize(405,720);//ancho, alto
		frameLogin.setLocationRelativeTo(null);//Centra la ventana
		frameLogin.setLayout(null);//Desactiva el control automático de paneles
		frameLogin.setResizable(false);//No permite modificar el tamaño de la ventana
		frameLogin.setBackground(Color.MAGENTA);//Color de la barra de la ventana
		
		panelLoginHead = panelLoginHead();
		frameLogin.add(panelLoginHead);
		
		//panelLoginBody = panelLoginBody();
		//frameLogin.add(panelLoginBody);
		
		frameLogin.setVisible(true);
	}
	//*/Login
	
	//Método para crear panelLoginHead
	private JPanel panelLoginHead() {
		
		JPanel panelLoginHead = new JPanel();
		panelLoginHead.setLayout(null);//Desactiva el control automático de paneles	   
		panelLoginHead.setBounds(0, 0, 405, 100);//x,y,ancho,alto
		panelLoginHead.setBackground(Color.CYAN);//Fondo del panel
		panelLoginHead.setOpaque(true);//false -> transparente
		
			JLabel lblKrelloLogo = new JLabel();
			lblKrelloLogo.setIcon(new ImageIcon(getClass().getResource("/co/edu/konradlorenz/view/img/KrelloLogo187x60.png")));//Ruta de la imagen
			lblKrelloLogo.setBounds(0, 20, 405, 60);//x,y,ancho,altura
			lblKrelloLogo.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
	        
			panelLoginHead.add(lblKrelloLogo);
	        
		return panelLoginHead;
	}
	//*/panelLoginHead
	
	//Método para crear panelLoginBody
	private JPanel panelLoginBody() {
		
		
		
		return null;
	}
	//*/panelLoginBody

	
}
