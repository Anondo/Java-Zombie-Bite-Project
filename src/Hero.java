import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hero extends JLabel{
	private Timer entrance;
	private int heroPosX = 1366;
	private int heroPosY = 550;
	public Hero()
	{
		super(new ImageIcon("img\\hero.png"));
		setBounds(heroPosX , heroPosY , 150 , 150);
		setTimer();
		makeEntrance();
	}
	public void setTimer()
	{
		entrance = new Timer(50 , new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				enter();
			}
		});
	}
	public void makeEntrance()
	{
		entrance.start();
	}
	public void enter()
	{
		if(heroPosX > 1100)
			heroPosX -= 3;
		setBounds(heroPosX , heroPosY , 150 , 150);
	}
	public void scream()
	{
		ZombieBite.playSound("./music/scream.wav");
	}
}
