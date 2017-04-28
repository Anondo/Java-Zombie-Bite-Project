import javax.swing.*;
import sun.audio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ZombieBite extends JFrame{
	private Zombie[] zombie = {new Zombie() , new Zombie() , new Zombie() , new Zombie()};
	private boolean play = true;
	private Timer gameTime;
	private int zombieCounter = 0;
	private int zombieBorn;
	private static int score = 0;
	private static JLabel scoreLabel = new JLabel("Score: 0");
	private JLabel[] life;
	
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
		addMouseListener(new CustomMouseListener(){
			public void mousePressed(MouseEvent e)
			{
				playSound("./music/gunshot.wav");
			}
		});
		addWindowListener(new WindowAdapter(){
			public void windowActivated(WindowEvent e)
			{
				playSound("./music/background.wav");
			}
		});
		
	}
	public void setLabels()
	{
		scoreLabel.setBounds(0 , 0 ,500 , 100);
		scoreLabel.setForeground(Color.red);
		scoreLabel.setFont(new Font ("Tahoma", Font.BOLD,20));
		add(scoreLabel);
	}
	public void initiateZombie()
	{
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
				if(score < 200)
					zombie[i].walk();
				else
					zombie[i].walkAndJump();
			}
	    }
		if(zombie[zombieCounter].kills() || zombie[zombieCounter].isDead())
		{
			zombie[zombieCounter].resurrect();
		}
		if(zombie[zombieCounter].XPosition() > 100)
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
		if(score==100 || score==200)
		{
			System.out.println(zombieBorn);
			for(int i = 0 ; i<= zombieBorn; i++)
				zombie[i].upgrade();
			score += 10;
		}
		
	}
	public static void playSound(String fileName)
	{
	    InputStream in;
	    try
	    {
	    	in = new FileInputStream(new File(fileName));
	    	AudioStream audioStream = new AudioStream(in);
	    	AudioPlayer.player.start(audioStream);
	    }
	    catch(Exception e)
	    {
	    	
	    	
	    }
	}
	public static void scoreUp()
	{
		score += 10;
		scoreLabel.setText("Score: " + score);
	}
}
