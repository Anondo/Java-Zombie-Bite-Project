import javax.swing.*;
import sun.audio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Option extends JFrame {
	
	private JLabel optionLabel1 = new JLabel ("Player Name");
	private JTextField nameField = new JTextField();
	private JButton saveBtn =new JButton("Save");
  
	public Option()
  {
	super("Zombie-Option");
	setSize(800,600);
	setVisible(true);
	setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		  dispose();
		  Main m1 =new Main();
		}
	});
	add(saveBtn);
	
	  
  }
}
