package Logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import Graphics.*;

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
		{powerUps[pos]=null;
		 pos++;
		}
     }
   /**
    * Mueve al jugador en la direcci�n dada por par�metro.
    * @param d La direcc�n a la que se movera el jugador.
    */
   private void movePlayer(int d)
     {Level level=game.getLevel();
      Cell [][] cells=level.getCells();
      switch (d)
        {case 1:{if (cells[positionX][positionY+1]!=null)
 	                {positionY++;
 	                 guiPlayer.move(d,speed,true);
 	                }
                 else guiPlayer.move(d,speed,false);
                 break;
                }
         case 2:{if (cells[positionX][positionY-1]!=null)
                    {positionY--;
 	                 guiPlayer.move(d,speed,true);
                    }
                 else guiPlayer.move(d,speed,false);
                 break;
                }
         case 3:{if (cells[positionX+1][positionY]!=null)
                    {positionX++;
                     guiPlayer.move(d,speed,true);
                    }
                 else guiPlayer.move(d,speed,false);
                 break;
                }
         case 4:{if (cells[positionX-1][positionY]!=null)
                    {positionX--;
                     guiPlayer.move(d,speed,true);
                    }
                 else guiPlayer.move(d,speed,false);
                 break;
                }
        }
     }
   /**
    * Contructor del Bomberman.
    * @param n Nombre del jugador que maneja el Bomberman.
    * @param g Juego en el qeu esta el Bomberman.
    */
   public Bomberman(String n)
     {name=n;
      positionX=1;
      positionY=1;
      speed=3;
      life=true;
      weapons=new LinkedList <Weapon>();
      weapons.addFirst(new Bomb(this));
      powerUps=new PowerUp[4];
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
      {if (pass)
          {this.movePlayer(d);
           //this.checkedEnemies();
           this.checkedPowerUp();
          }
       else super.move(d);
      }
    
    public void attack()
      {if (cantBombCanPut!=0) 
          {Bomb bomb=(Bomb)weapons.getFirst();
           bomb.exploit();
          }
      }	
  }
