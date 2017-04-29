import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import sun.audio.*;

public class Zombie2 extends Zombie{
	
	public Zombie2()
	{
		super("img\\zombie2.gif");
		positionOverRide();
	}
	public void positionOverRide()
	{
		zombiePosX = 500;
		zombiePosY = 720;
		setBounds(zombiePosX , zombiePosY , 80 ,120);
	}
	public void walk()
	{
		zombiePosX += 5;
		if(zombiePosY > 560)
			zombiePosY -= 5;
		setBounds(zombiePosX , zombiePosY , 80 , 120);
	}
	public void resurrect()
	{
		zombiePosX = 500;
		zombiePosY = 720;
		zombieSpeed = 5;
		setBounds(zombiePosX , zombiePosY ,80 , 120);
		setVisible(true);
		dead = false;
	}
}
