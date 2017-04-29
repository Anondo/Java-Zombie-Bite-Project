import javax.swing.*;
import sun.audio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ZombieBite extends JFrame{
	private Zombie[] zombie = {new Zombie() , new Zombie() , new Zombie() , new Zombie()};
	private boolean play = true;
	private Timer timer1;
	private Timer timer2;
	private int zombieCounter = 0;
	private int zombieBorn;
	private Zombie2[] zombie2 = {new Zombie2() , new Zombie2()  };
	private int zombie2Counter;
	private int zombie2Born;
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
		setContentPane(new JLabel(new ImageIcon("img\\background.png")));
		initiateZombie();
		setTimer();
		setLabels();
		timer1.start();
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("img\\cursor.png").getImage(),
				new Point(0,0),"custom cursor"));
		addMouseListener(new CustomMouseListener(){
			public void mousePressed(MouseEvent e)
			{
				playSound("./music/gunshot.wav");
			}
		});
		setResizable(false);
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
		timer1 = new Timer(50 , new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				startGame();
			}
		}
		);
		timer1.setRepeats(true);
		timer2 = new Timer(50 , new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				zombieWave2();
			}
		}
		);
		timer2.setRepeats(true);
		
		
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
		if(score == 150)
		{
			add(zombie2[zombie2Counter]);
			timer2.start();
		}
		if(score==100 || score==200)
		{
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
	    	System.out.println(e);
	    	
	    }
	}
	public static void scoreUp()
	{
		score += 10;
		scoreLabel.setText("Score: " + score);
	}
	public void zombieWave2()
	{
		if(play)
		{
			for(int i = 0; i <= zombie2Born; i++)
			{
				zombie2[i].walk();
			}
	    }
		if(zombie2[zombie2Counter].kills() || zombie2[zombie2Counter].isDead())
		{
			zombie2[zombie2Counter].resurrect();
		}
		if(zombie2[zombie2Counter].XPosition() > 700)
		{
			try
			{
				zombie2Counter++;
				if(zombie2Born < 1)
					zombie2Born++;
				add(zombie2[zombie2Counter]);
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				zombie2Counter = 0;
			}
			
		}
		
	}
}
