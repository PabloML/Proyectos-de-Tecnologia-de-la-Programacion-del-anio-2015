package Logic;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

import Graphics.*;
/**
 * Clase abstracta que representa al jugador.
 */
public abstract class Player
  {protected String name;// Nombre del jugador
   protected int score;// Puntaje del jugador.
   protected int positionX;// Posición en el eje x del jugador.
   protected int positionY;// Posición en el eje y del jugador.
   protected int speed;// Velocidad del jugador.
   protected boolean life;// Vida del jugador. 
   protected Game game;//Juego en el que esta el jugador.
   protected LinkedList <Weapon> weapons;// Armas que tiene el jugador.
   protected PowerUp[] powerUps;
   
   /**
    * Devuelve el nombre del jugador.
    * @return El nombre del jugador.
    */
    public String getName()
      {return name;	   
      }
   
    /**
    * Devuelve el puntaje del jugador.
    * @return El puntaje del jugador.
    */
    public int getScore()
      {return score;	   
      }
   
    /**
     * Devuelve el juego en el que esta el jugador
     * @return El juego en el que esta el jugador.
     */
    public Game getGame()
      {return game;
      }
   
    /**
     * Devuelve un arreglo con la posición en el eje x e y del personaje.
     * @return Un arreglo con la posición en el eje x e y del personaje.
     */
    public int[] getPosition()
      {int [] p=new int[2];
       p[0]=positionX;
       p[1]=positionY;
       return p;
      }
    
    /**
     * Devuelve la velocidad del jugador.
     * @return
     */
    public int getSpeed()
      {return speed;
      }
    
    /**
     * Devuelve una lista de las armas del jugador.
     * @return Una lista de las armas del jugador.
     */
    public LinkedList <Weapon> getWeapons()
      {return weapons;    	
      }
    /**
     * Devuelve un arreglo de que contiene los PowerUps que tiene el jugador.
     * @return Un arreglo de que contiene los PowerUps que tiene el jugador.
     */
    public PowerUp [] getPowerUps()
      {return powerUps;
      }
    
    /**
     * Devuelve si el jugador esta vivo.
     * @return Verdadero si el jugador esta vivo, falso en caso contrario.
     */
    public boolean isLife()
      {return life;    	
      }
    
    /**
     * Mata al jugador.
     */
    public void killplayer()
      {life=false;
      }
    
    /**
     * Devuelve si el jugaro tiene algun PowerUp.
     * @return Verdadero si tiene un powerUp, falso en caso contrario.
     */
    public boolean havePowerUpp()
      {return powerUps[0]!=null;    	
      }
    
    /**
     * Agrega un powerUp a los que tiene el jugador y activa los cambios que produce.
     * @param p PowerUp que agarra el jugador.
     */
    public void addPowerUp(PowerUp p)
      {int cant=0;
       while (cant!=powerUps.length && powerUps[cant]!=null)
    	 cant++;
       powerUps[cant]=p;
       p.operate();
      }
    
    /**
     * Incrementa el puntaje con el puntaje dado por parametro.
     * @param s Puntaje que se le incrementa al puntaje del jugador.
     */
    public void incrementScore(int s)
      {score=score+s;    	
      }
    
    /**
     * Setea la velocidad del jugador.
     * @param s La nueva velocidad del jugador.
     */
    public void setSpeed(int s)
      {speed=s;    	
      }
    
    public void keyPressed(KeyEvent e) 
      {int key = e.getKeyCode();
       switch (key)
         {case KeyEvent.VK_DOWN:{this.move(1);
                                 break;
                                }
          case KeyEvent.VK_UP:{this.move(2);
                               break;
                              }
          case KeyEvent.VK_RIGHT:{this.move(3);
                                  break;
                                 }
          case KeyEvent.VK_LEFT:{this.move(4);
                                 break;
                                }
          case KeyEvent.VK_SPACE:{this.attack();
                                  break;
                                 }
        }
      }
    /**
     * Mueve el jugador.
     */
    public void move(int d)
      {Level level=game.getLevel();
       Cell [][] cells=level.getCells();
       GUILevel guiLevel=level.getGUILevel();
       Enemy [] enemies=level.getEnemies();
       switch (d)
         {case 1:{if (cells[positionX][positionY+1]!=null && !cells[positionX][positionY+1].haveWall())
        	         {positionY++;
        	          guiLevel.movePlayer(d,speed,true);
        	         }
                  else guiLevel.movePlayer(d,speed,false);
                  break;
                 }
          case 2:{if (cells[positionX][positionY-1]!=null && !cells[positionX][positionY-1].haveWall())
 	                 {positionY--;
        	          guiLevel.movePlayer(d,speed,true);
 	                 }
                  else guiLevel.movePlayer(d,speed,false);
                  break;
                 }
          case 3:{if (cells[positionX+1][positionY]!=null && !cells[positionX+1][positionY].haveWall())
                     {positionX++;
	                  guiLevel.movePlayer(d,speed,true);
                     }
                  else guiLevel.movePlayer(d,speed,false);
                  break;
                 }
          case 4:{if (cells[positionX-1][positionY]!=null && !cells[positionX-1][positionY].haveWall())
                     {positionX--;
	                  guiLevel.movePlayer(d,speed,true);
                     }
                  else guiLevel.movePlayer(d,speed,false);
                  break;
                 }
         }
       for (int i=0;i<enemies.length;i++)
    	 if (positionX==enemies[i].getPosition[0] && positionY==enemies.getPosition[1])
    	    {life=false;
    	     guiLevel.killPlayer(score);
    	    }
      }
    public void attack()
      {
      }
  }
