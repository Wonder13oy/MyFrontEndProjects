package vzap.wandile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class FirstGUI
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("First GUI Frame");
		frame.setSize(400, 200);//Size in pixels
		
		JButton button = new JButton("This is a button");
		JButton nB, sB, wB, eB;
		nB = new JButton("North Button");
		sB = new JButton("South Button");
		wB = new JButton("West Button");
		eB = new JButton("East Button");
		
		nB.setPreferredSize(new Dimension(80, 140));
		wB.setPreferredSize(new Dimension(200, 0));
		button.setFont(new Font("Arial", Font.PLAIN, 22));
		button.setForeground(Color.BLUE);
		button.setBackground(new Color(0, 0, 150));
		
		frame.add(button);
		frame.add(nB, BorderLayout.NORTH);
		frame.add(sB, BorderLayout.SOUTH);
		frame.add(wB, BorderLayout.WEST);
		frame.add(eB, BorderLayout.EAST);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);//Frame is set as invisible by default and is always last
	}

}
