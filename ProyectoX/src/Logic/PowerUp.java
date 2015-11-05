package Logic;

/**
 * Clase abstracta que representa a los PowerUps. 
 */
public abstract class PowerUp extends Thread
  {protected Game game;// Juego en el que esta el PowerUp.
   /**
    * Retorna el juego al que pertenece el PowerUp.
    * @return El juego al que pertenece el PowerUp.
    */
   public Game getGame()
	 {return game;
	 }
   
   /**
    * Realiza los cambios en el juego provocados cuando el jugador agarra el PoweUp.
    */
   public abstract void operate();
  }
