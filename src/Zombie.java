import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import sun.audio.*;

public class Zombie extends JLabel{
	protected int zombiePosX = 10;
	protected int zombiePosY = 560;
	protected boolean dead = false;
	protected int zombieSpeed = 5;
	protected int initialSpeed = 5;
	public Zombie()
	{
		super(new ImageIcon("img\\zombie.gif"));
		setBounds(zombiePosX , zombiePosY ,80 , 120);
		addMouseListener(new CustomMouseListener(){
			public void mousePressed(MouseEvent e)
			{
				ZombieBite.playSound("./music/gunshot.wav");
				if(e.getY() < 8)
				{
					die();
					dead = true;
					ZombieBite.scoreUp();
				}
				else
				{
				   if(zombieSpeed > 1)	
					zombieSpeed--;
				}
			}
		});
	}
	public Zombie(String zombieFile)
	{
		super(new ImageIcon(zombieFile));
		setBounds(zombiePosX , zombiePosY ,80 , 120);
		addMouseListener(new CustomMouseListener(){
			public void mousePressed(MouseEvent e)
			{
				ZombieBite.playSound("./music/gunshot.wav");
				if(e.getY() > 37 && e.getY() < 73)
				{
					die();
					dead = true;
					ZombieBite.scoreUp();
				}
				else
				{
				   if(zombieSpeed > 1)	
					zombieSpeed--;
				}
			}
		});
	}
	public void walk()
	{
		zombiePosX += zombieSpeed;
		setBounds(zombiePosX , zombiePosY , 80 , 120);
	}
	public void walkAndJump()
	{
		zombiePosX += zombieSpeed;
		if(zombiePosX > 200 && zombiePosX < 500)
		{
			zombiePosY -= 5;
		}
		else if(zombiePosX > 500)
		{
			zombiePosY += 5;
			if(505 - zombiePosY < 5)
				zombiePosY = 560;
		}
			
		setBounds(zombiePosX , zombiePosY , 80 , 120);
		
	}
	public void die()
	{
		setVisible(false);
		roar();
	}
	public boolean kills()
	{
		if(zombiePosX >= 1000)
			return true;
		else
			return false;
	}
	public boolean isDead()
	{
		if(dead)
			return true;
		else
			return false;
	}
	public void resurrect()
	{
		zombiePosX = 10;
		zombieSpeed = initialSpeed;
		setBounds(zombiePosX , zombiePosY ,80 , 120);
		setVisible(true);
		dead = false;
	}
	public int XPosition()
	{
		return zombiePosX;
	}
	public void upgrade()
	{
		zombieSpeed = initialSpeed + 5;
		initialSpeed += 5;
	}
	public void roar()
	{
		
		ZombieBite.playSound("./music/roar.wav");
	}
}