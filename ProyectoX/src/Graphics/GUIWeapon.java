package Graphics;

import javax.swing.*;

/**
 * Clase que representa la grafica de la Bomba.
 */
public class GUIWeapon 
  {protected JLabel weapon;
   protected GUILevel guiLevel;
   protected JPanel level;
   
   /**
    * Inserta la bomba en la posición dadas por parámetro.
    * @param x Posición donde se ubicara la bomba de la fila.
    * @param y Posición donde se ubicara la bomba de la columna.
    */
   private void insertWeapon(int x,int y)
     {weapon=new JLabel();
      weapon.setIcon(new ImageIcon(GUIWeapon.class.getResource("/Image/Bomba/bomba.jpg")));
      JLabel passableCells=guiLevel.getPassableCells();
      level.remove(passableCells);
	  weapon.setBounds(x*64, y*64, 64, 64);
	  level.add(weapon);
	  level.add(passableCells);
     }
   /**
    * Crea la grafica de la bomba.
    * @param x Posición de la fila donde se ubicara la bomba.
    * @param y Posición de la columna donde se ubicara la bomba.
    * @param l Grafica del nivel del juego.
    */ 
   public GUIWeapon(int x, int y, GUILevel l)
     {guiLevel=l;
      level=guiLevel.getLevel();
      this.insertWeapon(x, y);
     }
   
   public void exploit(int n)
     {switch (n)
	    {case 1:{
	            }
	   }
     }
  }
