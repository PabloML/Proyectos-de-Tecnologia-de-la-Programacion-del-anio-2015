package Logic;

import Graphics.GUIWeapon;

/** 
 * Clase que representa la bomba que tiene el personaje.
 */
public class Bomb extends Weapon
  {protected void checkeadEnemies()
     {Enemy [] enemies=player.getGame().getLevel().getEnemies();
      
     }
  
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
      {((Bomberman)player).setCantBombCanPut(((Bomberman)player).getCantBombCanPut()-1);
       Cell [][] cells=player.getGame().getLevel().getCells();           
       guiWeapon=new GUIWeapon(positionX,positionY,player.getGame().getLevel().getGUILevel());
       try {Weapon.sleep(60000);
	       }
       catch (InterruptedException e) 
         {e.printStackTrace();
	     }
       
      }
}
