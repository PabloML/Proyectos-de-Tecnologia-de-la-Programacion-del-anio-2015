package src.Proyecto0;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JLabel;
/**
 * Interfaz grafica que muestra un boton con la imagen de Bart Simpson que al hacer click sobre él se escribe una frase tipica de él al lado de dicho boto.
 * @author Pablo Lencina
 */
public class GUISimpson extends JFrame 
  {private JPanel contentPane;// Panel dónde estan contenidos el boton y el label.
   private JButton bartButton; // Boton que ejecuta la operación.
   private JLabel bartLabel; // Label en la que se escribe la frase caracteristica del personaje del boton.
   private int num;//Valor utilizado para que no se repita la frase impresa.
	/**
	 * Método que ejecuta la interfaz grafica.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISimpson frame = new GUISimpson();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la interfaz.
	 */
	public GUISimpson() 
	  {super();

	   this.initGUI();
	  }
	/**
	 * Inicializa la interfaz Grafica.
	 */
	private void initGUI()
	  {//Configuración del cierre y tamaño del frame.
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setBounds(100, 100, 397, 87);
		
	   //Puesta del titulo del programa.
	   setTitle("Proyecto 0 - Pablo Lencina - LU: 82001");
		
	   //Creación del contentPane.
	   contentPane = new JPanel();
	   contentPane.setBackground(new Color(255, 255, 255));
	   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   contentPane.setLayout(new BorderLayout(0, 0));
	   setContentPane(contentPane);
	   
	   //Creación del bartButton.
	   bartButton = new JButton();
	   bartButton.setForeground(new Color(0, 0, 0));
	   bartButton.setIcon(new ImageIcon(GUISimpson.class.getResource("/src/Imagen/Bart.jpg")));
	   bartButton.setBackground(new Color(255, 255, 255));
	   bartButton.addActionListener(new OyenteBart());
	   contentPane.add(bartButton, BorderLayout.WEST);
		
	   //Creación del bartLabel.
	   bartLabel = new JLabel();
	   bartLabel.setBackground(new Color(255, 255, 255));
	   contentPane.add(bartLabel, BorderLayout.EAST);
	   
	   //Inicialización de la variable num.
	   num=-1;
	  }
	/**
	 * Clase oyente que se ejecuta cuando hago click en bartButton.
	 *
	 */
	private class OyenteBart implements ActionListener
	  {/**
	    * Método que escribe la frase de Bart al clickear bartButton.
	    * @param argo Evento que se genera al clickear bartButton.
	    */
	   public void actionPerformed(ActionEvent arg0)
		 {Random rnd=new Random();
		  int n=Math.abs(rnd.nextInt()%15);
		  while (n==num)
			n=Math.abs(rnd.nextInt()%15);
		  num=n;
		  switch (n)
		    {case 0: bartLabel.setText("¡Ay, caramba!");
		             break;
		     case 1: bartLabel.setText("Multiplicate por cero.");
                     break;
		     case 2: bartLabel.setText("¡De pelos!");
                     break;
		     case 3: bartLabel.setText("Cowabunga");
                     break;
		     case 4: bartLabel.setText("Yo no fui! ");
                     break;
		     case 5: bartLabel.setText("¡Besa mi trasero amarillo!");
                     break;
		     case 6: bartLabel.setText("Cómete mis pantalones");
                     break;
		     case 7: bartLabel.setText("Upss...!!!");
                     break;
		     case 8: bartLabel.setText("Tope!");
                     break;
		     case 9: bartLabel.setText("Esto esta de pelos");
                     break;
		     case 10: bartLabel.setText("!Changos!");
                      break;
		     case 11: bartLabel.setText("!Orale!");
                      break;
		     case 12: bartLabel.setText("¿Que te paso Viejo? Antes eras chevere");
                      break;
		     case 13: bartLabel.setText("Homero");
                      break;
		     case 14: bartLabel.setText("Apestas como mi trasero");
                      break;
		     case 15: bartLabel.setText("Este es el tipo que nos creo");
                      break;
		    }
		 }
	    
	  }	
	}
