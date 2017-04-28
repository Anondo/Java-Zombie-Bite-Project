import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ZombieBite extends JFrame{
	private Zombie[] zombie = {new Zombie() , new Zombie() , new Zombie() , new Zombie()};
	private boolean play = true;
	private Timer gameTime;
	private int zombieCounter = 0;
	private int zombieBorn;
	private JLabel scoreLabel = new JLabel("Score: 0");
	private JLabel Name = new JLabel("Player: ");
	
	public ZombieBite()
	{
		super("Zombie Bite!!");
		setSize(1366,720);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("img\\background.jpg")));
		initiateZombie();
		setTimer();
		setLabels();
		gameTime.start();
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("img\\cursor.png").getImage(),
				new Point(0,0),"custom cursor"));
		
	}
	public void setLabels()
	{
		//do this
	}
	public void initiateZombie()
	{
		//zombie.setBounds(zombiePosX, 353 ,300 , 400);
		add(zombie[zombieCounter]);
	}
	public void setTimer()
	{
		gameTime = new Timer(50 , new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				startGame();
			}
		}
		);
		gameTime.setRepeats(true);
	}
	public void startGame()
	{
		if(play)
		{
			for(int i = 0; i <= zombieBorn; i++)
			{
				zombie[i].walk();
			}
	    }
		if(zombie[zombieCounter].kills() || zombie[zombieCounter].isDead())
		{
			zombie[zombieCounter].resurrect();
		}
		if(zombie[zombieCounter].position() > 200)
		{
			try
			{
				zombieCounter++;
				if(zombieBorn < 3)
					zombieBorn++;
				add(zombie[zombieCounter]);
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				zombieCounter = 0;
			}
			
		}
		
	}
}
