package Logic;

import Graphics.GUIPowerUp;

/** 
 * Clase que representa los PowerUps del tipo Bombality.
 */
public class Bombality extends PowerUp
  {/** 
    * Constructor del PowerUp del tio Bombality.
    * @param g Juego en el que esta el PowerUp.
    */
    public Bombality(Game g,Level l,int x,int y)
    {game=g;
     guiPowerUp=new GUIPowerUp(l.getGUILevel());
     guiPowerUp.insertBombality(x, y);
    }
    
    /**
     * Incrementa uno la cantidad de bombas que puede poner el Bomberman.
     */
    public void operate()
      {Bomberman p=(Bomberman)game.getPlayer();
       int [] position=p.getPosition();
       int x=position[0];
       int y=position[1];
       guiPowerUp.removePowerUp(x,y);
       p.incrementScore(35);
       p.setCantBombCanPut(1);
      }
}