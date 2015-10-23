package Logica;

/** 
 * Clase que representa los PowerUps del tipo Masacrality.
 */
public class Masacrality extends PowerUp
  {/** 
    * Constructor del PowerUp del tio Masacrality.
    * @param g Juego en el que esta el PowerUp.
    */
    public Masacrality(Game g)
    {game=g;
    }
    
    /**
     * .
     */
    public void operate()
      {Bomberman p=(Bomberman)game.getPlayer();
       p.setPass(true);
       try {PowerUp.sleep(5000);
	       }  
       catch (InterruptedException e) 
         {e.printStackTrace();
	     }
       p.setPass(false);
      }
}