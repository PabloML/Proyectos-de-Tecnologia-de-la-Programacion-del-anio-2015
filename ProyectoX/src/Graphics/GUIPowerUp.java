package Graphics;

import javax.swing.*;

/**
 * Clase que representa la grafica de los PowerUps.
 */
public class GUIPowerUp 
  {protected JLabel [] powerUps;//Imagenes de los powerUps.
   protected JLabel [][] pUps;
   protected GUILevel guiLevel;//Grafica del nivel.
   protected JPanel level;//Panel del nivel.
   
   /**
    * Inicializa las imagenes de los powerUps.
    */
   protected void initializePowerUps()
     {for (int i=0;i<4;i++)
	    {JLabel p=new JLabel();
	     powerUps[i]=p;
    	}
      powerUps[0].setIcon(new ImageIcon(GUIPowerUp.class.getResource("/Image/PowerUps/PoW1.jpg")));
      powerUps[1].setIcon(new ImageIcon(GUIPowerUp.class.getResource("/Image/PowerUps/PoW2.jpg")));
      //powerUps[2].setIcon(new ImageIcon(GUIPowerUp.class.getResource("/Image/PowerUps/PoW3.jpg")));
      //powerUps[3].setIcon(new ImageIcon(GUIPowerUp.class.getResource("/Image/PowerUps/PoW4.jpg")));
     }
   
   /**
    * Inicializa la matriz de celdas donde se ubicara las graficas de los PowerUps.
    */
   protected void initializePUps()
     {for (int i=0;i<15;i++)
        for (int j=0;j<11;j++)
          pUps[i][j]=null;
     }
   
   /**
    * Crea la clase que grafica los powerUps.
    * @param l Clase que representa la grafica del nivel.
    */
   public GUIPowerUp(GUILevel l)
     {guiLevel=l;
      level=guiLevel.getLevel();
      powerUps=new JLabel [4];
      this.initializePowerUps();
      pUps=new JLabel[15][11];
      this.initializePUps();
     }
   
   /**
    * Inserta el powrUp speedUp en la posición dada por parametro
    * @param x Posición ene l eje x donde se posicionara el powerUp
    * @param y Posición en el eje y donde se posicionara el powerUp.
    */
   public void insertSpeedUp(int x,int y)
     {JLabel speedUp = powerUps[0];
	  speedUp.setBounds(x*64, y*64, 64, 64);
	  level.add(speedUp);
	  pUps[x][y]=speedUp;
     }
   
   /**
    * Inserta el powrUp fatality en la posición dada por parametro
    * @param x Posición ene l eje x donde se posicionara el powerUp
    * @param y Posición en el eje y donde se posicionara el powerUp.
    */
   public void insertFatality(int x,int y)
     {JLabel fatality =powerUps[1];
	  fatality.setBounds(x*64, y*64, 64, 64);
	  level.add(fatality);
	  pUps[x][y]=fatality;
     }
   
   /**
    * Inserta el powrUp bombality en la posición dada por parametro
    * @param x Posición de la fila donde se posicionara el powerUp
    * @param y Posición de la columna donde se posicionara el powerUp.
    */
   public void insertBombality(int x,int y)
     {JLabel bombality = powerUps[2];
	  bombality.setBounds(x*64, y*64, 64, 64);
	  level.add(bombality);
	  pUps[x][y]=bombality;
     }
   
   /**
    * Inserta el powrUp masarality en la posición dada por parametro
    * @param x Posición ene l eje x donde se posicionara el powerUp
    * @param y Posición en el eje y donde se posicionara el powerUp.
    */
   public void insertMasacrality(int x,int y)
     {JLabel masacrality = powerUps[3];
	  masacrality.setBounds(x*64, y*64, 64, 64);
	  level.add(masacrality);
	  pUps[x][y]=masacrality;
     }
   
   public void removePowerUp(int x,int y)
     {level.remove(pUps[x][y]);	   
     }
  }
