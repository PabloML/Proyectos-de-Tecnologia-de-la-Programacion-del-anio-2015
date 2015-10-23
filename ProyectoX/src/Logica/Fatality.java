package Logica;

/** 
 * Clase que representa los PowerUps del tipo Fatality.
 */
public class Fatality extends PowerUp
  {/** 
    * Constructor del PowerUp del tio Fatality.
    * @param g Juego en el que esta el PowerUp.
    */
    public Fatality(Game g)
    {game=g;
    }
    
    /**
     * Duplica el el poder del arma del jugador.
     */
    public void operate()
      {Player p=game.getPlayer();
       Weapon w=p.getWeapons().getFirst();
       int power=w.getPower();
        w.setPower(2*power);
      }
}

