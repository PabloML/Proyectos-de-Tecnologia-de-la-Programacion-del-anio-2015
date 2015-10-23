package Logica;

import java.util.Random;

/** 
 * Clase que representa al nivel que ejecuta el juego.
 */
public class Level
  {protected int quantityWall; //Cantidad de muros destruibles.
   protected Enemy [] enemies; //Enemigos en el nivel.
   protected Game game; //Juego en el que se esta ejecutando el nivel.
   protected Cell [][] cells; //Celdas del nivel.
   
   /**
    * Crea los enemigos.
    */
   private void CreateEnemies()
     {for (int i=0;i<3;i++)
        enemies[1]=new Rugulo(this);
       for (int i=3;i<5;i++)
         enemies[i]=new Atair(this);
       enemies[5]=new Sirius(this);
     }
   
   /**
    * Crea los PowerUps del tipo SpeedUp del nivel.
    */
   private void createSpeedUp()
     {Random rnd=new Random();
      int x=1;
      int y=1;
      int s=0;
      boolean hp;
      while (s<5 && x<14 && y<10)
    	{if (cells[x][y]!=null && cells[x][y].haveWall() && !cells[x][y].havePowerUp())
    	    {hp=rnd.nextBoolean();
    		 if (hp)
    		    {cells[x][y].setPowerUp(new SpeedUp(game));
    		     s++;
    		    }
    	    }
    	 x++;
    	 y++;
    	}
     }
   
   /**
    * Crea los PowerUps del tipo Fatality del nivel.
    */
   private void createFatality()
     {Random rnd=new Random();
      int x=1;
      int y=1;
      int f=0;
      boolean hp;
      while (f<4 && x<14 && y<10)
    	{if (cells[x][y]!=null && cells[x][y].haveWall() && !cells[x][y].havePowerUp())
    	    {hp=rnd.nextBoolean();
    		 if (hp)
    		    {cells[x][y].setPowerUp(new Fatality(game));
    		     f++;
    		    }
    	    }
    	 x++;
    	 y++;
    	}
     }
   
   /**
    * Crea los PowerUps del tipo Bombality del nivel.
    */
   private void createBombality()
     {Random rnd=new Random();
      int x=1;
      int y=1;
      int b=0;
      boolean hp;
      while (b<4 && x<14 && y<10)
    	{if (cells[x][y]!=null && cells[x][y].haveWall() && !cells[x][y].havePowerUp())
    	    {hp=rnd.nextBoolean();
    		 if (hp)
    		    {cells[x][y].setPowerUp(new Bombality(game));
    		     b++;
    		    }
    	    }
    	 x++;
    	 y++;
    	}
     }
   
   /**
    * Crea los PowerUps del tipo Masacrality del nivel.
    */
   private void creatMasacrality()
     {Random rnd=new Random();
      int x=1;
      int y=1;
      int m=0;
      boolean hp;
      while (m<2 && x<14 && y<10)
    	{if (cells[x][y]!=null && cells[x][y].haveWall() && !cells[x][y].havePowerUp())
    	    {hp=rnd.nextBoolean();
    		 if (hp)
    		    {cells[x][y].setPowerUp(new Masacrality(game));
    		     m++;
    		    }
    	    }
    	 x++;
    	 y++;
    	}
     }
   
   /**
    * Crea los PowerUps del nivel.
    */
   private void createPoweUps()
     {this.createSpeedUp();
      this.createFatality();
      this.createBombality();
      this.creatMasacrality();
     }
   
   /**
    * Pone nulo a las posiciones donde graficamente estaran los muros indestructibles del nivel.
    */
   private void createIndestructibleWall()
     {for (int i=0;i<12;i++)
	    {cells[0][i]=null;
	     cells[15][i]=null;
	    }
      for (int i=0;i<16;i++)
	    {cells[i][0]=null;
	     cells[12][i]=null;
	    }
      for (int i=2;i<14;i++)
      	for (int j=2;j<10;i++)
          if (i%2==0 && j%2==0)
             cells[i][j]=null;     
     }
   
   /**
    * Crea los muros destruibles del nivel.
    */
   private void createDetruibleWall()
     {int x=1;
      int y=1;
      Random rnd=new Random();
      boolean hw;
      while (quantityWall<49 && x<14 && y<10)
        {if (cells[x][y]!=null)
            {hw=rnd.nextBoolean();
               if (hw)
                   if ((!(x==1 && y==1)) || (!(x==1 && y==2)) || (!(x==2 && y==1)))
                      {cells[x][y].setHaveWall(hw);
                       quantityWall++;
                      }              
            }
         x++;
         y++;
        }
     }
 
   /**
    * Crea las celdas.
    */
   private void CreateCells()
     {this.createIndestructibleWall();       	 
      for (int i=1;i<11;i++)
    	{cells[1][i]=new Cell(this,1,i);
    	 cells[14][i]=new Cell(this,14,i);
    	}
      for (int i=1;i<15;i++)
        {cells[i][1]=new Cell(this,i,1);
         cells[i][10]=new Cell(this,i,10);
        }
      for (int i=2;i<14;i++)
    	for (int j=2;j<10;i++)
          if (i%2!=0 && j%2!=0)
             cells[i][j]=new Cell(this,i,j);
      this.createDetruibleWall();
      this.createPoweUps();
     }
   
    /** 
     * Constructor del nivel.
     * @param g Juego en el que se ejecuta el nivel. 
     */
    public Level(Game g)
      {game=g;
       quantityWall=0;
       enemies=new Enemy[6];
       this.CreateEnemies();
       cells=new Cell[16][12];
       this.CreateEnemies();
      }
    
    /** 
     * Devuelve la cantidad de muros destruibles en el nivel 
     */
    public int getQuantityWall1()
      {return quantityWall;
      }
    
    /** 
     * Retorna el juego al que pertenece el nivel. 
     */
    public Game getGame()
      {return game;
      }
    
    /** 
     * Retorna las celdas del nivel. 
     */
    public Cell[][] getCells()
      {return cells;
      }
    
    /** 
     * Retorna los enemigos. 
     */
    public Enemy[] getEnemies()
      {return enemies;
      }
    
    /** 
     * Decrementa en uno la cantidad de muros. 
     */
    public void decrementQuantityWall()
      {quantityWall--;
      }
  }
