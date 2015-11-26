package Logic;

/** 
 * Clase que representa los PowerUps del tipo SpeedUp.
 */
public class SpeedUp extends PowerUp
  {/** 
    * Constructor del PowerUp del tio SpeedUp.
    * @param g Juego en el que esta el PowerUp.
    */
    public SpeedUp(Game g,int x,int y)
    {game=g;
     guiPowerUp.insertSpeedUp(x, y);
    }
    
    /**
     * Duplica la velocidad del jugador.
     */
    public void operate()
    {Player p=game.getPlayer();
     int [] position=p.getPosition();
     int x=position[0];
     int y=position[1];
     guiPowerUp.removePowerUp(x,y);
     p.incrementScore(30);
     int s=p.getSpeed();
     p.setSpeed(2*s);
    }
}
