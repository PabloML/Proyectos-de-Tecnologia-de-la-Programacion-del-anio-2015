package Graphics;

import javax.swing.*;

import Logic.*;

public class GUIPlayer
  {protected JLabel [] playerLabels;//Arreglo de las imagenes de los jugadores.
   protected JLabel player;//Imagen actual del jugador.
   protected GUILevel guiLevel;//Grafica del nivel.
   protected JPanel level;//Panel donde se desarrolla el nivel del juego.
   
   /**
    * Crea el arreglo de imagenes del jugador.
    */
   private void createPlayer()
     {playerLabels=new JLabel[9];	
	  for (int i=0;i<9;i++)
    	{JLabel p=new JLabel("");
    	 playerLabels[i]=p;
    	}
      playerLabels[0].setIcon(new ImageIcon(GUIPlayer.class.getResource("/Image/Bomberman/PB1.gif")));
      playerLabels[1].setIcon(new ImageIcon(GUIPlayer.class.getResource("/Image/Bomberman/PBa.gif")));
      playerLabels[2].setIcon(new ImageIcon(GUIPlayer.class.getResource("/Image/Bomberman/PB2.gif")));
      playerLabels[3].setIcon(new ImageIcon(GUIPlayer.class.getResource("/Image/Bomberman/PBar.gif")));
      playerLabels[4].setIcon(new ImageIcon(GUIPlayer.class.getResource("/Image/Bomberman/PB3.gif")));
      playerLabels[5].setIcon(new ImageIcon(GUIPlayer.class.getResource("/Image/Bomberman/PBd.gif")));
      playerLabels[6].setIcon(new ImageIcon(GUIPlayer.class.getResource("/Image/Bomberman/PB4.gif")));
      playerLabels[7].setIcon(new ImageIcon(GUIPlayer.class.getResource("/Image/Bomberman/PBi.gif")));
      playerLabels[8].setIcon(new ImageIcon(GUIPlayer.class.getResource("/Image/Bomberman/PBM.gif")));
     }
   
   /**
	* Inserta al jugador en el nivel.
    */
   private void insertPlayer()
	 {player=playerLabels[0];
	  player.setBounds(64, 64, 64, 64);
	  level.add(player);
	 }
   
   /**
    * Cambia la imagen que aparece en pantalla del jugador. 
    * @param n La posición de la nueva imagen del jugador dentro del arreglo de imagenes.
    */
   private void changePlayer(int n)
     {int x=player.getX();
      int y=player.getY();
      JLabel passableCells=guiLevel.getPassableCells();
      level.remove(passableCells);
	  level.remove(player);
      player=playerLabels[n];
      player.setBounds(x,y,64,64);
      level.add(player);
      level.add(passableCells);
     }
   /**
    * Crea la grafica del jugador.
    * @param l Panel del nivel donde va estar el jugador.
    */
   public GUIPlayer(GUILevel l,Player p)
	 {guiLevel=l;
	  level=guiLevel.getLevel();
	  this.createPlayer();
	  this.insertPlayer();
        
	 }
   
   public void move(int d,int s,boolean c)
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
   /**
    * Mata al jugador.
    * @param s Es el puntaje acumulado por el jugador.
    */
   public void kill(int s)
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
