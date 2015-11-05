package Logic;

import Graphics.GUILevel;

/** 
 * Clase que representa al Bomberman.
 */
public class Bomberman extends Player
  {protected boolean pass;
   protected int cantBombCanPut;
   
   /**
    * Inicializa la lista de powerUps.
    */
   private void initialicePowerUps()
     {int pos=0;
	  while (pos<powerUps.length)
		powerUps[pos]=null;
     }
   
   /**
    * Contructor del Bomberman.
    * @param n Nombre del jugador que maneja el Bomberman.
    * @param g Juego en el qeu esta el Bomberman.
    */
   public void Bomberman(String n, Game g)
     {name=n;
      game=g;
      positionX=1;
      positionY=1;
      speed=3;
      life=true;
      weapons.add(new Bomb(this));
      this.initialicePowerUps();
     }
   /**
    * Devuelve la cantidad de bombas que puede poner al mismo tiempo.
    * @return La cantidad de bombas que puede poner al mismo tiempo.
    */
   public int getCantBombCanPut()
     {return cantBombCanPut;
     }
    
    /** 
     * Devuelve si esta bajo el efecto del PowerUp Masacralty 
     */
    public boolean canPass()
      {return pass;
      }
    
    /** 
     * Setea el valor de si esta o no bajo el efecto de Masacrality
     *
     */
    public void setPass(boolean p)
      {pass=p;
      }
    
    /** 
     * Setea la cantidad de bombas que puede insertar al mismo tiempo.
     */
    public void setCantBombCanPut(int c)
      {cantBombCanPut=c;
      }
    
    /**
     * Mueve el jugador.
     */
    public void move(int d)
      {Level level=game.getLevel();
       Cell [][] cells=level.getCells();
       GUILevel guiLevel=level.getGUILevel();
       Enemy [] enemies=level.getEnemies();
       if (pass)
          {switch (d)
             {case 1:{if (cells[positionX][positionY+1]!=null)
        	             {positionY++;
        	              guiLevel.movePlayer(d,speed,true);
        	             }
                       else guiLevel.movePlayer(d,speed,false);
                       break;
                      }
              case 2:{if (cells[positionX][positionY-1]!=null)
 	                     {positionY--;
        	              guiLevel.movePlayer(d,speed,true);
 	                     }
                      else guiLevel.movePlayer(d,speed,false);
                      break;
                     }
              case 3:{if (cells[positionX+1][positionY]!=null)
                         {positionX++;
	                      guiLevel.movePlayer(d,speed,true);
                         }
                      else guiLevel.movePlayer(d,speed,false);
                      break;
                     }
              case 4:{if (cells[positionX-1][positionY]!=null)
                         {positionX--;
	                      guiLevel.movePlayer(d,speed,true);
                         }
                      else guiLevel.movePlayer(d,speed,false);
                      break;
                     }
             }
           for (int i=0;i<enemies.length;i++)
    	     if (positionX==enemies[i].getPosition[0] && positionY==enemies.getPosition[1])
    	        {life=false;
    	         guiLevel.killPlayer(score);
    	        }
          }
       else super.move(d);
      }
  }
