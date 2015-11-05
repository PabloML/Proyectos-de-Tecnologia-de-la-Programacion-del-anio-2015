package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
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
   protected JLabel [] playerLabels;
   protected JLabel player;
   protected JLabel passableCells;
   protected JLabel [][] cells;
   protected JLabel [][] powerUps;
   /**
	* Launch the application.
    */
   public static void main(String[] args) 
     {EventQueue.invokeLater(new Runnable() 
        {public void run() 
           {try {GUILevel frame = new GUILevel();
				 frame.setVisible(true);				 
				} catch (Exception e) 
                    {e.printStackTrace();
				    }
		   }
		});
	 }
   
   /**
    * Inicializa el arreglo de imagenes del jugador.
    */
   private void initializePlayer()
     {for (int i=0;i<9;i++)
    	{JLabel p=new JLabel("");
    	 playerLabels[i]=p;
    	}
      playerLabels[0].setIcon(new ImageIcon(GUILevel.class.getResource("/Image/Bomberman/PB1.gif")));
      playerLabels[1].setIcon(new ImageIcon(GUILevel.class.getResource("/Image/Bomberman/PBa.gif")));
      playerLabels[2].setIcon(new ImageIcon(GUILevel.class.getResource("/Image/Bomberman/PB2.gif")));
      playerLabels[3].setIcon(new ImageIcon(GUILevel.class.getResource("/Image/Bomberman/PBar.gif")));
      playerLabels[4].setIcon(new ImageIcon(GUILevel.class.getResource("/Image/Bomberman/PB3.gif")));
      playerLabels[5].setIcon(new ImageIcon(GUILevel.class.getResource("/Image/Bomberman/PBd.gif")));
      playerLabels[6].setIcon(new ImageIcon(GUILevel.class.getResource("/Image/Bomberman/PB4.gif")));
      playerLabels[7].setIcon(new ImageIcon(GUILevel.class.getResource("/Image/Bomberman/PBi.gif")));
      playerLabels[8].setIcon(new ImageIcon(GUILevel.class.getResource("/Image/Bomberman/PBM.gif")));
     }
   
   /**
    * Cambia la imagen que aparece en pantalla del jugador. 
    * @param n La posición de la nueva imagen del jugador dentro del arreglo de imagenes.
    */
   private void changePlayer(int n)
     {int x=player.getX();
      int y=player.getY();
      level.remove(passableCells);
	  level.remove(player);
      player=playerLabels[n];
      player.setBounds(x,y,64,64);
      level.add(player);
      level.add(passableCells);
     }
   /**
    * Inicializa la matriz de los muros destruibles.
    */
   private void initializeCells()
     {for (int i=0;i<15;i++)
    	for (int j=0;j<11;j++)
          {cells[i][j]=null;
           powerUps[i][j]=null;
          }
     }
   
   /**
	* Create the frame.
	*/
   public GUILevel() 
	 {// Creo la ventana del nivel.
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setBounds(100, 100, 1024, 768);
	   
	  //Crea el panel que contedra los componentes del nivel.
	  level = new JPanel();
	  level.setBorder(new EmptyBorder(5, 5, 5, 5));
	  setContentPane(level);
	  level.setLayout(null);
	  
	  //Crea el arreglo de imagenes del jugador.
	  playerLabels=new JLabel[9];
	  this.initializePlayer();
	  
	  //Crea e inicializa la matriz de las celdas.
	  cells=new JLabel[15][11];
	  powerUps=new JLabel[15][11];
	  this.initializeCells();
	 }
	
   /**
	* Inserta al jugador en el nivel.
    */
   public void insertPlayer()
	 {player=playerLabels[0];
	  player.setBounds(64, 64, 64, 64);
	  level.add(player);
	 }
	
   /**
	* Inserta una pared de las que indican los limites del nivel en la posición dada por parametro.
	* @param x Posición en el eje x en la que se ubicara la pared.
	* @param y Posición ene l eje y donde se ubicara la pared.
	*/
   public void insertlimitCell(int x,int y)
	 {JLabel limitCell = new JLabel("");
	  limitCell.setIcon(new ImageIcon(GUILevel.class.getResource("/Image/celdas/celdaND.jpg")));
	  limitCell.setBounds(x*64, y*64, 64, 64);
	  level.add(limitCell);
	 }
	
   /**
	* Inserta una pared intransitable en la posición dada por parametro.
	* @param x Posición en el eje x en la que se ubicara la pared.
	* @param y Posición en el eje y donde se ubicara la pared.
	*/
   public void insertImpassableCell(int x, int y)
	 {JLabel impassableCell = new JLabel("");
	  impassableCell.setIcon(new ImageIcon(GUILevel.class.getResource("/Image/celdas/celdaND.gif")));
	  impassableCell.setBounds(x*64, y*64, 64, 64);
	  level.add(impassableCell);
	 }
	
   /**
	* Inserta una pared destruible en la posición dada por parametro.
	* @param x Posición en el eje x en la que se ubicara la pared.
	* @param y Posición en el eje y en la que se ubicara la pared. 
	*/
   public void insertDestructibleWall(int x,int y)
	 {JLabel destructibleWall = new JLabel("");
	  destructibleWall.setIcon(new ImageIcon(GUILevel.class.getResource("/Image/celdas/celdoD.jpg")));
	  destructibleWall.setBounds(x*64, y*64, 64, 64);
	  level.add(destructibleWall);
	  cells[x][y]=destructibleWall;
	 }
	
   /**
	* Inserta las celdas transitables en la posición dada por parametro.
	* @param x Posición en el eje x en la que se ubicara la pared.
	* @param y Posición en el eje y en la que se ubicara la pared. 
	*/
   public void insertPassableCells()
	 {passableCells = new JLabel("");
	  passableCells.setBounds(0, 0, 1007, 728);	 
	  passableCells.setIcon(new ImageIcon(GUILevel.class.getResource("/Image/celdas/mapa.jpg")));
	  level.add(passableCells);
	 }
   
   /**
    * Inserta el powrUp speedUp en la posición dada por parametro
    * @param x Posición ene l eje x donde se posicionara el powerUp
    * @param y Posición en el eje y donde se posicionara el powerUp.
    */
   public void insertSpeedUp(int x,int y)
     {JLabel speedUp = new JLabel("");
	  speedUp.setIcon(new ImageIcon(GUILevel.class.getResource("/Image/PowerUps/PoW1.jpg")));
	  speedUp.setBounds(x*64, y*64, 64, 64);
	  level.add(speedUp);
	  powerUps[x][y]=speedUp;
     }
   
   /**
    * Inserta el powrUp fatality en la posición dada por parametro
    * @param x Posición ene l eje x donde se posicionara el powerUp
    * @param y Posición en el eje y donde se posicionara el powerUp.
    */
   public void insertFatality(int x,int y)
     {JLabel fatality = new JLabel("");
	  fatality.setIcon(new ImageIcon(GUILevel.class.getResource("/Image/PowerUps/PoW2.jpg")));
	  fatality.setBounds(x*64, y*64, 64, 64);
	  level.add(fatality);
	  powerUps[x][y]=fatality;
     }
   
   /**
    * Inserta el powrUp bombality en la posición dada por parametro
    * @param x Posición ene l eje x donde se posicionara el powerUp
    * @param y Posición en el eje y donde se posicionara el powerUp.
    */
   public void insertBombality(int x,int y)
     {JLabel bombality = new JLabel("");
	  bombality.setIcon(new ImageIcon(GUILevel.class.getResource("/Image/PowerUps/PoW3.jpg")));
	  bombality.setBounds(x*64, y*64, 64, 64);
	  level.add(bombality);
	  powerUps[x][y]=bombality;
     }
   
   /**
    * Inserta el powrUp masarality en la posición dada por parametro
    * @param x Posición ene l eje x donde se posicionara el powerUp
    * @param y Posición en el eje y donde se posicionara el powerUp.
    */
   public void insertMasacrality(int x,int y)
     {JLabel masacrality = new JLabel("");
	  masacrality.setIcon(new ImageIcon(GUILevel.class.getResource("/Image/PowerUps/PoW4.jpg")));
	  masacrality.setBounds(x*64, y*64, 64, 64);
	  level.add(masacrality);
	  powerUps[x][y]=masacrality;
     }
   
   /**
    * Inserta una bomba e la posición donde esta el jugador.
    */
   public void insertBomb()
     {level.remove(passableCells);
	  JLabel bomb = new JLabel("");
	  bomb.setIcon(new ImageIcon(GUILevel.class.getResource("/Image/Bomba/bomba.gif")));
	  bomb.setBounds(player.getX(), player.getY(), 64, 64);
	  level.add(bomb);
	  this.insertPassableCells();
     }
   
   public void movePlayer(int d,int s,boolean c)
     {int cant=0;  
      int positionX=player.getX();
      int positionY=player.getY();
	  switch (d)
	    {case 1:{while (cant<64)
	               {this.changePlayer(1);
	    	        cant= cant+s;
	    	        if (c)
	    	           player.setBounds(positionX, positionY-s, player.getWidth(), player.getHeight());
	    	        try {Thread.sleep(1000);
				        }
	    	        catch (InterruptedException e) 
	    	          {e.printStackTrace();
				      }
	               }
	             this.changePlayer(0);
	             break;
	    	    }
	     case 2:{while (cant<64)
	    	       {this.changePlayer(3);
	                cant=cant+s;
	                if (c)
	                   player.setBounds(positionX, positionY+s, player.getWidth(), player.getHeight());
	                try {Thread.sleep(1000);
		                }
	                catch (InterruptedException e) 
	                  {e.printStackTrace();
		              }
                   }
	            this.changePlayer(2);
                break;
	           }
	     case 3:{while (cant<64)
                   {this.changePlayer(5);
                    cant=cant+s;
                    if (c)
                       player.setBounds(positionX+s, positionY, player.getWidth(), player.getHeight());
                    try {Thread.sleep(1000);
                        }
                    catch (InterruptedException e) 
                      {e.printStackTrace();
                      }
                   }
	             this.changePlayer(4);
                 break;
                }
	     case 4:{while (cant<64)
                   {this.changePlayer(7);
                    cant=cant+s;
                    if (c)
                       player.setBounds(positionX+s, positionY, player.getWidth(), player.getHeight());
                    try {Thread.sleep(1000);
                        }
                    catch (InterruptedException e) 
                      {e.printStackTrace();
                      }
                   }
	             this.changePlayer(6);
                 break;
                }
	    }
     }
   public void killPlayer(int s)
     {this.changePlayer(8);
      try {Thread.sleep(2000);
	      } 
      catch (InterruptedException e) 
        {e.printStackTrace();
	    }
      JOptionPane.showMessageDialog(null,"Se acumulo un total de "+ s +"puntos.","PERDISTE",JOptionPane.ERROR_MESSAGE);
      level.remove(player);
     }
  }
