package Logica;

/** 
 * Clase que representa los PowerUps del tipo SpeedUp.
 */
public class SpeedUp extends PowerUp
  {/** 
    * Constructor del PowerUp del tio SpeedUp.
    * @param g Juego en el que esta el PowerUp.
    */
    public SpeedUp(Game g)
    {game=g;
    }
    
    /**
     * Duplica la velocidad del jugador.
     */
    public void operate()
    {Player p=game.getPlayer();
     int s=p.getSpeed();
     p.setSpeed(2*s);
    }
}
