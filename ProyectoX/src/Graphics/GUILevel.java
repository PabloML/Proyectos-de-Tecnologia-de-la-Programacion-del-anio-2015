package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logic.*;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

/**
 * Clase que representa la ventana grafica del nivel del juego.
 */
public class GUILevel extends JFrame 
  {protected JPanel level;
   protected JLabel passableCells;
   protected JLabel [][] cells;
   protected Player player;
   
   /**
    * Inicializa la matriz de los muros destruibles.
    */
   private void initializeCells()
     {for (int i=0;i<15;i++)
    	for (int j=0;j<11;j++)
          cells[i][j]=null;
          
     }
   
   /**
	* Create the frame.
	*/
   public GUILevel(Player p) 
	 {// Creo la ventana del nivel.
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setBounds(100, 100, 1024, 768);
	   
	  //Crea el panel que contedra los componentes del nivel.
	  level = new JPanel();
	  level.setBorder(new EmptyBorder(5, 5, 5, 5));
	  setContentPane(level);
	  level.setLayout(null);
	  
	  //Crea e inicializa la matriz de las celdas.
	  cells=new JLabel[15][11];
	  this.initializeCells();
	  
	  //Inicializo la grafica del jugador.
	  player=p;
	  player.initGUIPlayer(this);
	  
	  level.addKeyListener(new KeyAdapter() 
	    {public void keyReleased(KeyEvent e) 
	       {player.keyPressed(e);
		   }
		});
	 }
   
   /**
    * Devuelve el panel donde se grafica el nivel.
    * @return El panel donde se grafica el nivel.
    */
   public JPanel getLevel()
     {return level;
     }
   
   /**
    * Devuelve las celdas transitables.
    * @return Las celdas transitables.
    */
   public JLabel getPassableCells()
     {return passableCells;
     }
   /**
	* Inserta una pared de las que indican los limites del nivel en la posici�n dada por parametro.
	* @param x Posici�n en el eje x en la que se ubicara la pared.
	* @param y Posici�n ene l eje y donde se ubicara la pared.
	*/
   public void insertlimitCell(int x,int y)
	 {JLabel limitCell = new JLabel("");
	  limitCell.setIcon(new ImageIcon(GUILevel.class.getResource("/Image/celdas/celdaND.jpg")));
	  limitCell.setBounds(x*64, y*64, 64, 64);
	  level.add(limitCell);
	 }
	
   /**
	* Inserta una pared intransitable en la posici�n dada por parametro.
	* @param x Posici�n en el eje x en la que se ubicara la pared.
	* @param y Posici�n en el eje y donde se ubicara la pared.
	*/
   public void insertImpassableCell(int x, int y)
	 {JLabel impassableCell = new JLabel("");
	  impassableCell.setIcon(new ImageIcon(GUILevel.class.getResource("/Image/celdas/celdaND.gif")));
	  impassableCell.setBounds(x*64, y*64, 64, 64);
	  level.add(impassableCell);
	 }
	
   /**
	* Inserta una pared destruible en la posici�n dada por parametro.
	* @param x Posici�n en el eje x en la que se ubicara la pared.
	* @param y Posici�n en el eje y en la que se ubicara la pared. 
	*/
   public void insertDestructibleWall(int x,int y)
	 {JLabel destructibleWall = new JLabel("");
	  destructibleWall.setIcon(new ImageIcon(GUILevel.class.getResource("/Image/celdas/celdoD.jpg")));
	  destructibleWall.setBounds(x*64, y*64, 64, 64);
	  level.add(destructibleWall);
	  cells[x][y]=destructibleWall;
	 }
	
   /**
	* Inserta las celdas transitables en la posici�n dada por parametro.
	* @param x Posici�n en el eje x en la que se ubicara la pared.
	* @param y Posici�n en el eje y en la que se ubicara la pared. 
	*/
   public void insertPassableCells()
	 {passableCells = new JLabel("");
	  passableCells.setBounds(0, 0, 1007, 728);	 
	  passableCells.setIcon(new ImageIcon(GUILevel.class.getResource("/Image/celdas/mapa.jpg")));
	  level.add(passableCells);
	 }      
  }
