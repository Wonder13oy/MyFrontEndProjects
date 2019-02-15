package vzap.wandile;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class BinaryEditor extends JFrame implements ActionListener
{
	private JSplitPane splitPane;
	private JTextArea leftText, rightText;
	private JScrollPane lSPane, rSPane;
	private JPanel lPanel, rPanel, southPanel, lsPanel, rsPanel;
	private JButton open, exit;
	private JFileChooser file;
	private FileInputStream fis;
	private InputStreamReader isr;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public BinaryEditor()
	{
		leftPanel();
		rightPanel();
		southPanel();
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lPanel, rPanel);
		splitPane.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		splitPane.setResizeWeight(0.5);
		
		
		setup();
	}
	public void leftPanel()
	{
		lPanel = new JPanel(new GridLayout(1, 1));
		leftText = new JTextArea();
		lSPane = new JScrollPane(leftText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		lPanel.add(lSPane);
		lPanel.setSize(100, 100);
	}
	public void rightPanel()
	{
		rPanel = new JPanel(new GridLayout(1, 1));
		rightText = new JTextArea();
		rSPane = new JScrollPane(rightText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		rPanel.add(rSPane);
		rPanel.setSize(100, 100);
	}
	public void southPanel()
	{
		southPanel = new JPanel(new GridLayout(1, 2));
		open = new JButton("Open file");
		open.addActionListener(this);
		exit = new JButton("Exit");
		lsPanel = new JPanel();
		rsPanel = new JPanel();
		lsPanel.add(open);
		rsPanel.add(exit);
		
		southPanel.add(lsPanel);
		southPanel.add(rsPanel);
	}
	public void setup()
	{
		this.setTitle("Binary Editor");
		this.pack();
		this.setSize(screenSize);
		this.add(splitPane);
		this.add(southPanel, BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new BinaryEditor();
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Object source = ae.getSource();
		int x = 0;
		int i = 0;
		char [] chars = new char[5000];
		
		if(source == open)
		{
			leftText.setText(" ");
			rightText.setText(" ");
			file = new JFileChooser("C:\\Users\\Wandile Nxumalo\\Documents\\Sept 2018\\eclipseWorkSpace\\SwingProject\\resources");
			file.showOpenDialog(lPanel);
			try
			{
				fis = new FileInputStream(file.getSelectedFile());
				isr = new InputStreamReader(fis);
				while((x = fis.read()) != -1)
				{
					leftText.append(Integer.toBinaryString(x));
					chars[i] = (char)x;
					rightText.append("" + isr.read());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
