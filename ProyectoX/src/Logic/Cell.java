package Logic;

/** 
 * Clase que representa las celdas del juego. 
 */
public class Cell
  {protected int positionX;// Posición de la fila de la celda.
   protected int positionY;// Posición de la columna de la celda.
   public Level level;// Nivel en el que esta la celda.
   protected boolean haveWall;// Variable que dice si tiene muro destruible la celda.
   protected PowerUp powerUp;// PowerUp que tienen la celda, en el caso de no tener es nulo.
  
   /**
    * Constructor de la celda
    * @param l Nivel en el que esta la celda
    */
   public Cell(Level l,int x,int y)
     {level=l;
      positionX=x;
      positionY=y;
      haveWall=false;
      powerUp=null;
     }                  
    
    /** 
     * Devuelve el nivel en el que esta la celda.
     * @return El nivel en el que esta la celda. 
     */
    public Level getLevel()
    {return level;
    }
    
    /** 
     * Retorna un arreglo con la posición de la celda en el nivel. 
     */
    public int[] getPosition()
    {int p[]=new int[2];
     p[0]=positionX;
     p[1]=positionY;
     return p;
    }
    
    /** 
     * Retorna el muro que esta en la celda, si no tiene retorna nulo. 
     */
    public boolean haveWall()
    {return haveWall;
    }
    
    /** */
    public Boolean havePowerUp()
      {boolean h=false;
       if (powerUp!=null)
    	  h=true;
       return h;
      }
    
    /** 
     * Retorna el PowerUp. 
     */
    public PowerUp getPowerUp()
    {return powerUp;
    }
    /**
     * Setea el PowerUp de la celda.
     * @param p PowerUp que le ingreso a la celda
     */
    public void setPowerUp(PowerUp p)
      {powerUp=p;    	
      }
    /** 
     * Setea si la celda tiene muro.
     * @param hw Valor booleano que indica si la celda tiene muro.
     */
    public void setHaveWall(boolean hw)
      {haveWall=hw;
      }
  }
