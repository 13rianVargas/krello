package co.edu.konradlorenz.view.gui;

import java.awt.Color;

import javax.swing.*;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	JFrame login = new JFrame();
	
	//JPanel invisiblePanel;
	JPanel pnlLoginHead;
	JPanel pnlLoginbody;
	ImageIcon imgKrelloLogo;
	JLabel lblLogin;
	JTextField txtLoginCorreo;
	JTextField txtLoginNombre;
	JPasswordField pwdContraseña;
	JPasswordField pwdReContraseña;
	JButton btnLoginContinuar;
	JButton btnLoginPanelCrearCuenta;
	JButton btnLoginCrearCuenta;
	JButton btnLoginRegresar;
	
	public Login () {
		
		login.setDefaultCloseOperation(EXIT_ON_CLOSE);//Terminar la ejecución si se cierra la ventana
		login.setTitle("KRELLO");//Título de la ventana
		login.setSize(405,720);
		login.setLocationRelativeTo(null);//Centra la ventana
		login.setLayout(null);//Desactiva el control automático de paneles
		login.setResizable(false);//No permite modificar el tamaño de la ventana
		login.setBackground(Color.MAGENTA);//Color de la barra de la ventana
		
		pnlLoginHead = pnlLoginHead();
		//pnlLoginbody = pnlLoginbody();
		
		login.add(pnlLoginHead);
		//login.add(pnlLoginbody);
		
		login.setVisible(true);
	}
	
	private JPanel pnlLoginHead() {
		JPanel pnlLoginHead = new JPanel();
		pnlLoginHead.setLayout(null);//Desactiva el control automático de paneles	   
		pnlLoginHead.setBounds(0, 0, 405, 100);//x,y,ancho,altura
		pnlLoginHead.setBackground(Color.CYAN);
		pnlLoginHead.setOpaque(true);//false transparente
		
			JLabel lblKrelloLogo = new JLabel();
			lblKrelloLogo.setIcon(new ImageIcon(getClass().getResource("/co/edu/konradlorenz/view/img/KrelloLogo187x60.png")));
			lblKrelloLogo.setBounds(0, 20, 405, 60);
			lblKrelloLogo.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
	        
			pnlLoginHead.add(lblKrelloLogo);
	        
		return pnlLoginHead;
	}

	private JPanel pnlLoginbody() {
		
		
		
		return null;
	}

	
}
