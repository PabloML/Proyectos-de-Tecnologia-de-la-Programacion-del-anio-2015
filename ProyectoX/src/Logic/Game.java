package Logic;

/** 
 * Clase que reperesenta el control logico del juego.
 */
public class Game
  {protected Player player;//Jugador del juego.
   protected Level level;//Nivel del juego.
   protected Time time;//Tiempo del juego.
    
   /** 
    * Constructor del juego.
    * @param p Jugador del juego. 
    */
    public void Game(Player p)
      {player=p;
       level=new Level(this);
       time=new Time();
      }
    
    /** 
     * Retorna el juegador del juego.
     * @return El jugador del juego. 
     */
    public Player getPlayer()
      {return player;
      }
    
    /** 
     * Retorna el nivel del juego.
     * @return El nivel del juego. 
     */
    public Level getLevel()
      {return level;
      }
    
    /** 
     * Retorna el tiempo del juego.
     * @return El tiempo del juego.
     */
    public Time getTime()
      {return time;
      }
}
