package Logic;

import Graphics.*;

/**
 * Clase abstracta que representa a las armas del jugador.
 */
public abstract class Weapon extends Thread
  {protected Player player;// Jugador al que le pertenece el arma.
   protected int positionX;// Posici�n en de la fila del arma.
   protected int positionY;// Posici�n en de la columna del arma.
   protected int power;// Poder del arma.
   protected GUIWeapon guiWeapon;//Grafica del arma.
   /**
    * Devuelve el jugador al que pertenece el arma.
    * @return El jugador al que pertenece el arma.
    */
   public Player getPlayer()
     {return player;	   
     }
   
   /**
    * Devuelve la posici�n donde se ubica el arma.
    * @return La posici�n  donde se ubica el arma.
    */
   public int[] getPosition()
     {int[] p=new int[2];
      p[0]=positionX;
      p[1]=positionY;
      return p;
     }
   
   /** 
    * Devuelve el poder del arma.
    */
   public int getPower()
     {return power;
     }
      
   /**
    * Setea el poder del arma.
    * @param p
    */
   public void setPower(int p)
     {power=p;	   
     }
  }
