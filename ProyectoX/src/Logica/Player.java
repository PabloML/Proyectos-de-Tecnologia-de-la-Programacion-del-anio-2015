package Logica;

import java.util.LinkedList;
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
   protected LinkedList <Weapon> weapons;
   
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
  }
