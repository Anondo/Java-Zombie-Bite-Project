import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AboutZombie extends JFrame {

	private JTextArea msgArea = new JTextArea();
	private JButton backButton = new JButton("Back");
	private JLabel hLabel = new JLabel("About Zombie-Bite");
	private JLabel creditLabel = new JLabel("Credits");
	private JLabel nameLabel1 = new JLabel ("# Ahmad Ananda Anabil");
	private JLabel nameLabel2 = new JLabel("# Imtiaz Ahmed");
	String message = "Hello there!!! " + 
	                 "Wellcome to the challenging Zombie World. " + 
			         "You think you are fast enough to kill them"+"\n"+
	                 "all before you get a poisionous bite!! "+
	                 "Why wait then!! Grab the mouse, keep pressing left button and"+ "\n" +"create demolition"+
			         " and also dont forget to thank the developer team. Enjoy the Game....\nAnd o ya aim for the head ;)";
	public AboutZombie()
	{
		super("About Zombie-Bite");
		setSize(800,600);
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("img\\score.png")));
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("img\\hand.png").getImage(),
				new Point(0,0),"custom cursor"));
		
		
		
		/*Head Label*/
		hLabel.setBounds(300,30,200,35);
		hLabel.setForeground(Color.red);
		hLabel.setFont(new Font("Tahoma", Font.BOLD,20));
		add(hLabel);
		
		/*Credits label*/
		creditLabel.setBounds(350,250,200,35);
		creditLabel.setForeground(Color.red);
		creditLabel.setFont(new Font("Tahoma", Font.BOLD,20));
		add(creditLabel);
		
		/*Name Label 1*/
		nameLabel1.setBounds(70,300,400,35);
		nameLabel1.setForeground(Color.orange);
		nameLabel1.setFont(new Font("Baghdad", Font.BOLD,25));
		add(nameLabel1);
		
		/*Name Label 2*/
		nameLabel2.setBounds(70,350,400,35);
		nameLabel2.setForeground(Color.orange);
		nameLabel2.setFont(new Font("Baghdad", Font.BOLD,25));
		add(nameLabel2);
		
		
		/*Textarea addition*/
		msgArea = new JTextArea(message);
		msgArea.setBounds(40,70,700,150);
		msgArea.setBackground(Color.darkGray);
		msgArea.setForeground(Color.green);
		msgArea.setFont(new Font("Bates Shower", Font.BOLD,15));
		msgArea.setEditable(false);
		add(msgArea);
		
		/*Back Button */
		backButton.setBounds(320,420,150,60);
		backButton.setBackground(Color.darkGray);
		backButton.setForeground(Color.red);
		backButton.setFont(new Font("Bates Shower", Font.BOLD,20));
		backButton.setFocusPainted(false);
		backButton.setBorderPainted(true);
		backButton.setBorder(BorderFactory.createBevelBorder(0,Color.red,Color.orange,Color.red,Color.orange));
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			  setVisible(false);
			}
		});
		add(backButton);
		
	}
}
