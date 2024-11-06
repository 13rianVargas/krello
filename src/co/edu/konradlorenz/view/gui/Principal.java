package co.edu.konradlorenz.view.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	JFrame principal = new JFrame();
	
	Color fondoPanel = Color.LIGHT_GRAY;//Fondo de todos los JPanel
	Color fondoFrame = Color.GRAY;//Fondo del JFrame
	
    //Constructor
    public Principal(){

    	principal.setDefaultCloseOperation(EXIT_ON_CLOSE); //Terminar la ejecución si se cierra la ventana
    	principal.setTitle("KRELLO");
    	principal.setSize(1280, 720);
    	principal.setLocationRelativeTo(null); // Centra la ventana
    	principal.setLayout(null);//Desactivar layout automático para usar setBounds()
    	principal.setResizable(false);//No permite modificar el tamaño de la ventana
    	principal.setBackground(Color.CYAN);//Color del Titulo de la ventana
    	principal.getContentPane().setBackground(fondoFrame);

    		
	        principal.add(head());
	
	        
	        principal.add(middle());
	        
	        // - BODY - //
	        
	        //TODO:Aquí te toca Aleja
	        
	        
	        
	        principal.setVisible(true); //IMPORTANTE dejar esta línea de últimas al cerrar el constructor para que carguen las pinches imagenes (llevo 3 horas tratando de ver porque no salía la imagen y es por esta babosada T-T )
    }
    //Principal
    
    //Método para crear head
    @SuppressWarnings("exports")
	public JPanel head() {
    	// - HEAD - //
        JPanel head = new JPanel();
        head.setBounds(40, 40, 1200, 80);
        head.setBackground(fondoPanel);
        head.setLayout(null);//Desactivar layout automático para usar setBounds()
        //*/

	        // Krello Logo
	        JLabel krelloLogo = new JLabel();
	        krelloLogo.setIcon(new ImageIcon(getClass().getResource("/co/edu/konradlorenz/view/img/KrelloLogo187x60.png")));
	        krelloLogo.setBounds(10, 10, 187, 60);
	        
	        head.add(krelloLogo);
	        
	        //Hola
	        JLabel hola = new JLabel("¡Hola ");
	        hola.setFont(new Font("Arial", Font.PLAIN, 20));

	        //User
	        JLabel user = new JLabel("User Genérico"); //TODO: Aquí va el nombre del usuario en el futuro
	        user.setFont(new Font("Arial", Font.ITALIC, 20));
	        
	        //!
	        JLabel admiracion = new JLabel("!");
	        admiracion.setFont(new Font("Arial", Font.PLAIN, 20));

	        //Hola User !
	        JPanel holaUser = new JPanel();
	        holaUser.setLayout(new BoxLayout(holaUser, BoxLayout.X_AXIS));
	        holaUser.add(hola);
	        holaUser.add(user);
	        holaUser.add(admiracion);
	        holaUser.setForeground(Color.BLACK);
	        holaUser.setBounds(207, 10, 400, 60);
	        holaUser.setOpaque(false);
	     
	        head.add(holaUser);
	        
	        //Cerrar Sesión
	        JLabel cerrarSesion = new JLabel("Cerrar sesión");
	        cerrarSesion.setFont(new Font("Arial", Font.PLAIN, 20));
	        cerrarSesion.setForeground(Color.BLACK);
	        cerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambia el cursor a una mano cuando pase por encima
	        cerrarSesion.setBounds(1050, 10, 150, 60);
	        
	        cerrarSesion.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                //TODO: Acción para volver a Ventana Iniciar Sesión

	                principal.dispose(); // Cierra Ventana Principal
	            }
	        });
	        
	        head.add(cerrarSesion);
	        
    	return head;
    }
    //*/head
    
    //middle
    @SuppressWarnings("exports")
    public JPanel middle() {
    	 // - MIDDLE - //
        JPanel middle = new JPanel();
        middle.setVisible(true);
        middle.setBounds(40, 140, 1200, 80);
        middle.setBackground(fondoPanel);
        
	        //Mis Tableros
	        JLabel misTableros = new JLabel("Mis Tableros");
	        misTableros.setFont(new Font("Arial", Font.PLAIN, 30));
	        //misTableros.setLayout(new BoxLayout(misTableros, BoxLayout.X_AXIS));
	        misTableros.setLayout(new BoxLayout(misTableros, BoxLayout.Y_AXIS));
	        misTableros.setBounds(0, 0, 1200, 80);
        
        middle.add(misTableros);
    	return middle;
    }
    //*/middle
    
    
}
//class