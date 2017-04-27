
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame /*implements actionListener*/{
	private JButton sGameButton = new JButton("Start Game");
	private JButton optButton = new JButton("Options");
	private JButton scoreButton = new JButton("Scores");
   
	public Main()
	{
		super("Zombie-Bite");
		setSize(1366,768);
		setVisible(true);
		setLayout(null);
		getContentPane().setBackground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setButtons();
	 
	}
	public void setButtons()
	{
		sGameButton.setBounds(600,450,150,60);
		sGameButton.setOpaque(true);
	    add(sGameButton);
		 
		optButton.setBounds(600,520,150,60);
	    add(optButton);
		 
	    scoreButton.setBounds(600,590,150,60);
	    add(scoreButton);
	}

	public static void main(String[] args)
	{
		Main m = new Main();
	}
	
}
