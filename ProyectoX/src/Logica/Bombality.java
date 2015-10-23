package Logica;

/** 
 * Clase que representa los PowerUps del tipo Bombality.
 */
public class Bombality extends PowerUp
  {/** 
    * Constructor del PowerUp del tio Bombality.
    * @param g Juego en el que esta el PowerUp.
    */
    public Bombality(Game g)
    {game=g;
    }
    
    /**
     * Incrementa uno la cantidad de bombas que puede poner el Bomberman.
     */
    public void operate()
      {Bomberman p=(Bomberman)game.getPlayer();
       p.setCantBombCanPut(1);
      }
}