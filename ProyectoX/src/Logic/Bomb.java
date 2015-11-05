package Logic;

/** 
 * Clase que representa la bomba que tiene el personaje.
 */
public class Bomb extends Weapon
  {protected int power;
   /** 
    * Constructor de la bomba.
    * @param p Personaje que contiene  la bomba. 
    */
    public Bomb(Player p)
    {player=p;
     power=1;
     int [] pos=player.getPosition();
     positionX=pos[0];
     positionY=pos[1];
    }
    
    /** 
     * Explota la bomba.
     */
    public void exploit()
      {
      }
}
