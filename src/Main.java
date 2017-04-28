import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame /*implements actionListener*/
{
	private JButton sGameButton = new JButton("Start Game");
	private JButton optionButton = new JButton("Options");
    private JButton scoreButton  = new JButton ("Score");
	
	public Main()
	{
		super("Zombie-Bite");
		setSize(1366,720);
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setButtons();
		addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e)
			{
				ZombieBite.playSound("./music/intro.wav");
			}
		});
		
	}
	public void setButtons()
	{
		/*Start Game Button*/
		sGameButton.setBounds(600,450,150,60);
		sGameButton.setForeground(Color.green);
		sGameButton.setFocusPainted(false);
		sGameButton.setBorderPainted(true);
		sGameButton.setBackground(Color.darkGray);
		sGameButton.setFont(new Font ("Tahoma", Font.BOLD,15));
		sGameButton.setBorder(BorderFactory.createBevelBorder(0,Color.magenta,Color.orange,Color.magenta,Color.orange));
		sGameButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				ZombieBite game = new ZombieBite();
			}
		}
		);
		add(sGameButton);
		
		/*Option Button*/
		optionButton.setBounds(600,520,150,60);
		optionButton.setForeground(Color.green);
		optionButton.setFocusPainted(false);
		optionButton.setBorderPainted(true);
		optionButton.setBackground(Color.darkGray);
		optionButton.setFont(new Font ("Tahoma", Font.BOLD,15));
		optionButton.setBorder(BorderFactory.createBevelBorder(0,Color.magenta,Color.orange,Color.magenta,Color.orange));
		add(optionButton);
		
		/*Score Button*/
		scoreButton.setBounds(600,590,150,60);
		scoreButton.setForeground(Color.green);
		scoreButton.setFocusPainted(false);
		scoreButton.setBorderPainted(true);
		scoreButton.setBackground(Color.darkGray);
		scoreButton.setFont(new Font ("Tahoma", Font.BOLD,15));
		scoreButton.setBorder(BorderFactory.createBevelBorder(0,Color.magenta,Color.orange,Color.magenta,Color.orange));
		add(scoreButton);
	}
	
	public static void main(String [] args)
	{
		Main m = new Main();
	}
}