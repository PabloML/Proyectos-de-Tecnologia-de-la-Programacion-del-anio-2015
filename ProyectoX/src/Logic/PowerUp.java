package Logic;

import Graphics.*;

/**
 * Clase abstracta que representa a los PowerUps. 
 */
public abstract class PowerUp extends Thread
  {protected Game game;// Juego en el que esta el PowerUp.
   protected GUIPowerUp guiPowerUp;//Grafica de los powerUps.
     
   /**
    * Realiza los cambios en el juego provocados cuando el jugador agarra el PoweUp.
    */
   public abstract void operate();
  }
