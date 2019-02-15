package vzap.wandile;

import java.awt.Dimension;

import javax.swing.*;

public class TestJDialog
{

	public static void main(String[] args)
	{
		JButton b1, b2;
		b1 = new JButton("Button 1");
		b2 = new JButton("Button 2");
		
		JFrame frame = new JFrame("Dialog Frame");
		frame.setSize(600, 800);
		frame.add(b1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JDialog dialog = new JDialog(frame, "Dialog", true);//Dialog belong to the frame
		dialog.setSize(new Dimension(400, 300));
		dialog.add(b2);
//		dialog.setModal(true);
		JOptionPane.showInputDialog(frame, "Input Value");
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}

}
