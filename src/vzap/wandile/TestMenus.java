package vzap.wandile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestMenus extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu fileMenu, aboutMenu, mediaMenu;
	private JMenuItem fileItem, exitItem, slideShow,aboutItem, helpItem, musicItem, movieItem, gameItem;
	private JPanel basePanel;
	private Font font;
	private TextEditor te;
	
	
	public TestMenus()
	{
		font = new Font("Arial", Font.BOLD, 24);
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic('f');
		fileMenu.setFont(font);
		fileItem = new JMenuItem("Open File");
		fileItem.addActionListener(this);
		slideShow = new JMenuItem("Slide Show");
		slideShow.addActionListener(this);
		KeyStroke keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
		fileItem.setAccelerator(keyStrokeToOpen);
		basePanel = new JPanel(new GridLayout(1, 1));
		
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				System.exit(0);
			}
		});
		
		fileMenu.add(fileItem);
		fileMenu.add(slideShow);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		aboutMenu = new JMenu("About");
		aboutMenu.setFont(font);
		aboutItem = new JMenuItem("About Programmers");
		helpItem = new JMenuItem("Help");
		aboutMenu.add(aboutItem);
		aboutMenu.add(helpItem);
		
		mediaMenu = new JMenu("Media Menu");
		mediaMenu.addMouseListener(new MyMouseListener());
		mediaMenu.setFont(font);
		musicItem = new JMenuItem("Music");
		musicItem.addActionListener(this);
		movieItem = new JMenuItem("Movies");
//		gameItem = new JMenuItem("Games");
//		mediaMenu.add(musicItem);
//		mediaMenu.add(movieItem);
//		mediaMenu.add(gameItem);
		
		menuBar.add(fileMenu);
		menuBar.add(mediaMenu);
		menuBar.add(aboutMenu);
		
		this.setTitle("Checking Menus");
		this.setSize(500, 500);
		this.setLocation(200, 250);
		this.setJMenuBar(menuBar);
		this.add(basePanel, BorderLayout.CENTER);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent we)
				{
					System.exit(0);
				}
			});
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new TestMenus();
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Object source = ae.getSource();
		if(source == musicItem)
		{
			MediaPane mp = new MediaPane();
			basePanel.removeAll();
			basePanel.validate();
			basePanel.repaint();
			basePanel.add(mp);
			basePanel.validate();
			basePanel.repaint();
		}
		if(source == fileItem)
		{
			TextEditor te = new TextEditor();
			basePanel.removeAll();
			basePanel.validate();
			basePanel.repaint();
			basePanel.add(te);
			basePanel.validate();
			basePanel.repaint();
		}
		if(source == slideShow)
		{
			SlideShow slideshow = new SlideShow();
			basePanel.removeAll();
			basePanel.validate();
			basePanel.repaint();
			basePanel.add(slideshow);
			basePanel.validate();
			basePanel.repaint();
		}
	}
	class MyMouseListener extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent me)
		{
			MediaPane mp = new MediaPane();
			basePanel.removeAll();
			basePanel.validate();
			basePanel.repaint();
			basePanel.add(mp);
			basePanel.validate();
			basePanel.repaint();
		}
	}
}
