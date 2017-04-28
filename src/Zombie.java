import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import sun.audio.*;

public class Zombie extends JLabel{
	private int zombiePosX = 10;
	private int zombiePosY = 505;
	private boolean dead = false;
	private int zombieSpeed = 5;
	private int initialSpeed = 5;
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
				zombiePosY = 505;
		}
			
		setBounds(zombiePosX , zombiePosY , 80 , 120);
		
	}
	public void die()
	{
		setVisible(false);
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
}
