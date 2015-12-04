package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logic.*;

import java.awt.Color;
import javax.swing.JButton;

public class GUIGame extends JFrame 
  {protected JPanel contentPane;
   protected Game game;
   protected Player player;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIGame frame = new GUIGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIGame() 
	  {this.initGame();
	  }
    private void initGame()
      {setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(100, 100, 450, 300);
	   contentPane = new JPanel();
	   contentPane.setBackground(Color.BLACK);
	   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   setContentPane(contentPane);
	   contentPane.setLayout(null);
	   
	   JButton playButton = new JButton("Jugar");
	   playButton.setForeground(new Color(0, 255, 0));
	   playButton.setBackground(Color.BLACK);
	   playButton.setBounds(156, 88, 100, 64);	   
	   contentPane.add(playButton);
	   OyentePlay oyentePlay=new OyentePlay();
	   playButton.addActionListener(oyentePlay);
      }
    
    private class OyentePlay implements ActionListener
      {public void actionPerformed(ActionEvent arg0) 
    	 {JOptionPane dialog=new JOptionPane();
    	  dispose();
    	  String name= dialog.showInputDialog("Ingrese nombre del jugador");
    	  player=new Bomberman(name);
    	  game=new Game(player);
    	  player.setGame(game);    	      	  
		 }
	  }
    
    
  }
