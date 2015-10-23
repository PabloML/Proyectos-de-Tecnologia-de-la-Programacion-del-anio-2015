package Logica;
/**
 * Clase abstracta que representa a las armas del jugador.
 */
public abstract class Weapon extends Thread
  {protected Player player;// Jugador al que le pertenece el arma.
   protected int positionX;// Posición en el eje x del arma.
   protected int positionY;// Posición en el eje y del arma.
   protected int power;// Poder del arma.
   /**
    * Devuelve el jugador al que pertenece el arma.
    * @return El jugador al que pertenece el arma.
    */
   public Player getPlayer()
     {return player;	   
     }
   
   /**
    * Devuelve la posición donde se ubica el arma.
    * @return La posición  donde se ubica el arma.
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
