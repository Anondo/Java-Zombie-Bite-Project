import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame{
	private JLabel[] data;
	private JLabel heading = new JLabel("  Name------------------------------Score------------------------Date");
	private int rowNumber;
	private Database db = new Database();
	private JButton clearButton = new JButton("CLEAR");
	public Score()
	{
		super("Top 10 Scores");
		setLayout(null);
		setSize(780,650);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("img\\score.png")));
		rowNumber = db.getRowNumber();
		data = new JLabel[rowNumber];
		setData();
		setVisible(true);
		setLabels();
		setButtons();
		
		
	    
		
	}
	public void setLabels()
	{
		heading.setBounds(0 , 0 , 780, 30);
		heading.setFont(new Font ("Tahoma", Font.BOLD,20));
		heading.setForeground(Color.red);
		add(heading);
	}
	public void setButtons()
	{
		clearButton.setBounds(300,520,150,60);
		clearButton.setForeground(Color.green);
		clearButton.setFocusPainted(false);
		clearButton.setBorderPainted(true);
		clearButton.setBackground(Color.darkGray);
		clearButton.setFont(new Font ("Bates Shower", Font.BOLD,15));
		clearButton.setBorder(BorderFactory.createBevelBorder(0,Color.red,Color.orange,Color.red,Color.orange));
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				db.clearData();
				setVisible(false);
			}
		}
		);
		add(clearButton);
	}
	public void setData()
	{
		for(int i = 0 , y = 30; i < rowNumber; i++ , y+=50)
		{
			data[i] = new JLabel();
			data[i].setBounds(10 , y , 780,30);
			data[i].setFont(new Font ("Tahoma", Font.BOLD,20));
			data[i].setForeground(Color.red);
			data[i].setText(i+1 +"."+ db.getData(i+1));
		    add(data[i]);
		}
	}
}
