import javax.swing.*;
import sun.audio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Option extends JFrame {
	
	private JLabel optionLabel1 = new JLabel ("Player");
	private JTextField nameField = new JTextField("Player");
	private JButton saveBtn =new JButton("Save");
	private static String name = "Player";
  
	public Option()
  {
	super("Zombie-Option");
	setSize(800,600);
	setVisible(true);
	setLayout(null);
	setLocationRelativeTo(null);
	setResizable(false);
	getContentPane().setBackground(Color.black);
	
	/*Option Label*/
	optionLabel1.setBounds(70,60,200,35);
	optionLabel1.setFont(new Font ("Tahoma", Font.BOLD,20));
	optionLabel1.setForeground(Color.red);
	setContentPane(new JLabel(new ImageIcon("img\\optionimg.jpg")));
	add(optionLabel1);
	
	/*Name Text-Field*/
	nameField.setBounds(220,60,300,35);
	nameField.setBackground(Color.darkGray);
	nameField.setForeground(Color.green);
	nameField.setFont(new Font ("Bates Shower", Font.BOLD,20));
	nameField.setBorder(BorderFactory.createBevelBorder(0,Color.red,Color.orange,Color.red,Color.orange));
	add(nameField);
	
	/**/
	saveBtn.setBounds(220,150, 150, 60);
	saveBtn.setBackground(Color.darkGray);
	saveBtn.setForeground(Color.red);
	saveBtn.setFont(new Font ("Bates Shower", Font.BOLD,20));
	saveBtn.setFocusPainted(false);
	saveBtn.setBorderPainted(true);
	saveBtn.setBorder(BorderFactory.createBevelBorder(0,Color.red,Color.orange,Color.red,Color.orange));
	saveBtn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			
		  setVisible(false);
		  name = nameField.getText();
		}
	});
	add(saveBtn);
	
	  
  }
  public static String getPlayerName()
  {
	  return name;
  }
}
