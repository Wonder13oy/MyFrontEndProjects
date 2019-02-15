package vzap.wandile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageSplitter extends JFrame
{
	private JPanel leftPanel, rightPanel;
	private JLabel can1, can2;
	private JScrollPane pane1, pane2;
	private Icon image1, image2;
	
	public ImageSplitter()
	{
		leftPanel();
		rightPanel();
		setupFrame();
	}
	private void leftPanel()
	{
		leftPanel = new JPanel(new GridLayout(1, 1));
		image1 = new ImageIcon("images/Cape1.jpg");
		can1 = new JLabel(image1);
		pane1 = new JScrollPane(can1);
	}
	private void rightPanel()
	{
		rightPanel = new JPanel(new GridLayout(1, 1));
		image2 = new ImageIcon("images/Cape2.jpg");
		can2 = new JLabel(image2);
		pane2 = new JScrollPane(can2);
	}
	private void setupFrame()
	{
		this.setTitle("Image Splitter");
		this.setSize(500, 600);
		this.add(pane1, BorderLayout.LINE_START);
		this.add(pane2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new ImageSplitter();
	}

}
