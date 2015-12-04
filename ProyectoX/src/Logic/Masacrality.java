package Logic;

import Graphics.GUIPowerUp;

/** 
 * Clase que representa los PowerUps del tipo Masacrality.
 */
public class Masacrality extends PowerUp
  {/** 
    * Constructor del PowerUp del tio Masacrality.
    * @param g Juego en el que esta el PowerUp.
    */
    public Masacrality(Game g,Level l,int x,int y)
    {game=g;
     guiPowerUp=new GUIPowerUp(l.getGUILevel());
     guiPowerUp.insertMasacrality(x, y);
    }
    
    /**
     * .
     */
    public void operate()
      {Bomberman p=(Bomberman)game.getPlayer();
       int [] position=p.getPosition();
       int x=position[0];
       int y=position[1];
       guiPowerUp.removePowerUp(x,y);
       p.incrementScore(50);
       p.setPass(true);
       try {PowerUp.sleep(5000);
	       }  
       catch (InterruptedException e) 
         {e.printStackTrace();
	     }
       p.setPass(false);
      }
}