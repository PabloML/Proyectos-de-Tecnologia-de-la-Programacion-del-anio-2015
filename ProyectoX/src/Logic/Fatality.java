package Logic;

/** 
 * Clase que representa los PowerUps del tipo Fatality.
 */
public class Fatality extends PowerUp
  {/** 
    * Constructor del PowerUp del tio Fatality.
    * @param g Juego en el que esta el PowerUp.
    */
    public Fatality(Game g,int x,int y)
    {game=g;
     guiPowerUp.insertFatality(x, y);
    }
    
    /**
     * Duplica el el poder del arma del jugador.
     */
    public void operate()
      {Player p=game.getPlayer();
       int [] position=p.getPosition();
       int x=position[0];
       int y=position[1];
       guiPowerUp.removePowerUp(x,y);
       p.incrementScore(35);
       Weapon w=p.getWeapons().getFirst();
       int power=w.getPower();
       w.setPower(2*power);
      }
}

