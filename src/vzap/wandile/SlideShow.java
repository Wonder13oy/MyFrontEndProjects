package vzap.wandile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SlideShow extends JPanel implements ActionListener
{
	private JPanel nPanel, sPanel, cPanel;
	private JButton nextBut, prevBut, firstBut, lastBut, startBut, stopBut;
	private JScrollPane canvas;
	private JLabel imageCanvas;
	private Icon image1, image2, image3, image4, image5, image6, image7, image8, image9;
	private Icon [] images;
	int i = 0;
	private ThreadClass tc;
	
	public SlideShow()
	{
		tc = new ThreadClass();
		
		northPanel();
		centerPanel();
		southPanel();
		setupPanel();
	}
	private void northPanel()
	{
		nPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		startBut = new JButton("Start Slideshow");
		startBut.addActionListener(this);
		stopBut = new JButton("Stop Slideshow");
		stopBut.addActionListener(this);
		
		nPanel.add(startBut);
		nPanel.add(stopBut);
	}
	private void imageAlbum()
	{
		image1 = new ImageIcon("images/Cape1.jpg");
		image2 = new ImageIcon("images/Cape2.jpg");
		image3 = new ImageIcon("images/Cape3.jpg");
		image4 = new ImageIcon("images/Cape4.jpg");
		image5 = new ImageIcon("images/Cape5.jpg");
		image6 = new ImageIcon("images/Cape6.jpg");
		image7 = new ImageIcon("images/Cape7.jpg");
		image8 = new ImageIcon("images/Cape8.jpg");
		image9 = new ImageIcon("images/Cape9.jpg");
	}
	private void centerPanel()
	{
		cPanel = new JPanel(new GridLayout(1, 1));
		imageAlbum();
		images = new Icon []{image1,image2, image3, image4, image5, image6, image7, image8, image9};
		imageCanvas = new JLabel(images[0]);
		canvas = new JScrollPane(imageCanvas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		cPanel.add(canvas);
	}
	private void southPanel()
	{
		sPanel = new JPanel(new FlowLayout());
		nextBut = new JButton("Next");
		nextBut.addActionListener(this);
		prevBut = new JButton("Previous");
		prevBut.addActionListener(this);
		prevBut.setEnabled(false);
		firstBut = new JButton("First Image");
		firstBut.addActionListener(this);
		lastBut = new JButton("Last Image");
		lastBut.addActionListener(this);
		
		sPanel.add(firstBut);
		sPanel.add(prevBut);
		sPanel.add(nextBut);
		sPanel.add(lastBut);
	}
	private void setupPanel()
	{
		this.setLayout(new BorderLayout());
		this.setSize(new Dimension(1200, 800));
		this.add(nPanel, BorderLayout.NORTH);
		this.add(cPanel, BorderLayout.CENTER);
		this.add(sPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new SlideShow();
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Object source = ae.getSource();
		
		if(source == nextBut)
		{
			i++;
			if(i == 8)
			{
				nextBut.setEnabled(false);
			}
			prevBut.setEnabled(true);
			imageCanvas = new JLabel(images[i]);
			canvas = new JScrollPane(imageCanvas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			cPanel.removeAll();
			cPanel.validate();
			cPanel.repaint();
			cPanel.add(canvas);
			cPanel.validate();
			cPanel.repaint();
		}
		if(source == prevBut)
		{
			i--;
			if(i == 0)
			{
				prevBut.setEnabled(false);
			}
			nextBut.setEnabled(true);
			imageCanvas = new JLabel(images[i]);
			canvas = new JScrollPane(imageCanvas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			cPanel.removeAll();
			cPanel.validate();
			cPanel.repaint();
			cPanel.add(canvas);
			cPanel.validate();
			cPanel.repaint();
		}
		if(source == firstBut)
		{
			imageCanvas = new JLabel(image1);
			canvas = new JScrollPane(imageCanvas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			cPanel.removeAll();
			cPanel.validate();
			cPanel.repaint();
			cPanel.add(canvas);
			cPanel.validate();
			cPanel.repaint();
			prevBut.setEnabled(false);
			i = 0;
		}
		if(source == lastBut)
		{
			imageCanvas = new JLabel(image9);
			canvas = new JScrollPane(imageCanvas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			cPanel.removeAll();
			cPanel.validate();
			cPanel.repaint();
			cPanel.add(canvas);
			cPanel.validate();
			cPanel.repaint();
			prevBut.setEnabled(true);
			nextBut.setEnabled(false);
			i = 8;
		}
		if(source == startBut)
		{
			startBut.setEnabled(false);
			firstBut.setEnabled(false);
			prevBut.setEnabled(false);
			nextBut.setEnabled(false);
			lastBut.setEnabled(false);
			
			tc.start();
		}
		if(source == stopBut)
		{
			tc.stopThread();
			
			stopBut.setEnabled(false);
			startBut.setEnabled(true);
			firstBut.setEnabled(true);
			prevBut.setEnabled(true);
			nextBut.setEnabled(true);
			lastBut.setEnabled(true);
		}
	}
	class ThreadClass extends Thread
	{
		private boolean runThread;
		
		public ThreadClass()
		{
			runThread = true;
			i = 0;
		}
		public void stopThread()
		{
			runThread = false;
		}
		
		@Override
		public void run()
		{
			while(runThread == true)
			{
				i++;
					imageCanvas.setIcon(images[i]);
					canvas.getViewport().add(imageCanvas);
				try
				{
					Thread.sleep(3000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
