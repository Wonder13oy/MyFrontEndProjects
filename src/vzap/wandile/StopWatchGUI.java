package vzap.wandile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class StopWatchGUI extends JFrame implements ActionListener, Runnable
{
	private JPanel mainPanel, southPanel;
	private JLabel display;
	private JTextArea ltLabel;
	private Vector<String> lapTimes;
	private JButton reset, stop, lap, start;
	private Thread thread;
	private String stopWatch;
	private boolean running;
	
	public StopWatchGUI()
	{
		
		thread = new Thread(this);
		running = true;
		lapTimes = new Vector<String>();
		
		mainPanel();
		southPanel();
		setup();
	}
	private void mainPanel()
	{
		mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		display = new JLabel(stopWatch);
		display.setFont(new Font("Arial", Font.BOLD, 100));
		
		mainPanel.add(display);
		mainPanel.setBackground(Color.BLACK);
	}
	private void southPanel()
	{
		southPanel = new JPanel(new GridLayout(1, 4));
		reset = new JButton("Reset");
		reset.addActionListener(this);
		stop = new JButton("Stop");
		stop.addActionListener(this);
		start = new JButton("Start");
		start.addActionListener(this);
		lap = new JButton("Lap");
		lap.addActionListener(this);
		
		southPanel.add(reset);
		southPanel.add(stop);
		southPanel.add(start);
		southPanel.add(lap);
	}
	private void setup()
	{
		this.setTitle("Stopwatch");
		this.setSize(600, 300);
		this.add(mainPanel);
		this.add(southPanel, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Object source = ae.getSource();
		if(source == reset)
		{
			
		}
		if(source == start)
		{
			stopWatch = new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis() * 0);
			thread.start();
		}
		if(source == stop)
		{
			stop();
			ltLabel = new JTextArea(lapTimes.toString());
			if (lapTimes.isEmpty() == false) {
				mainPanel.removeAll();
				mainPanel.validate();
				mainPanel.repaint();
				mainPanel.add(ltLabel);
				mainPanel.validate();
				mainPanel.repaint();
			}
			thread = new Thread(this);
		}
		if(source == lap)
		{
			lapTimes.add("Laptime: " + stopWatch + "\n");
		}
	}
	public void stop()
	{
		running = false;
	}
	
	@Override
	public void run()
	{
			for (int i = 0; i < 60; i++)
			{
				if (running == true)
				{
					stopWatch = new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis());
					display.setText(stopWatch);
					mainPanel.removeAll();
					mainPanel.validate();
					mainPanel.repaint();
					mainPanel.add(display);
					mainPanel.validate();
					mainPanel.repaint();
					try
					{
						Thread.sleep(1000);

					} catch (InterruptedException e)
					{
						e.getStackTrace();
					} 
				}
			} 
	}
	
	public static void main(String [] args)
	{
		new StopWatchGUI();
	}
}
