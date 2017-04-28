import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Zombie extends JLabel{
	private int zombiePosX = 10;
	private boolean dead = false;
	public Zombie()
	{
		super(new ImageIcon("img\\zombie.gif"));
		setBounds(zombiePosX , 353 ,300 , 400);
		addMouseListener(new CustomMouseListener(){
			public void mousePressed(MouseEvent e)
			{
				setVisible(false);
				dead = true;
			}
		});
	}
	public void walk()
	{
		zombiePosX += 5;
		setBounds(zombiePosX , 353 , 300 , 400);
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
		setBounds(zombiePosX , 353 ,300 , 400);
		setVisible(true);
		dead = false;
	}
	public int position()
	{
		return zombiePosX;
	}
}
