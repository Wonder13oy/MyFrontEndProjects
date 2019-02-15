package vzap.wandile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockThread implements Runnable
{
	private String timeFormat;
	private Thread thread;
	public ClockThread()
	{
		this.thread = new Thread(this);
		this.timeFormat = new SimpleDateFormat("HH:mm:ss").format(new Date());
		//time.applyLocalizedPattern(" a");
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 60; i++)
		{
			//this.timeFormat = new SimpleDateFormat("HH:mm:ss").format(new Date());
			System.out.println(timeFormat);
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				e.getStackTrace();
			}
		}		
	}
	public Thread getThread()
	{
		return this.thread;
	}
	public static void main(String[] args)
	{
		ClockThread clock = new ClockThread();
		clock.run();

	}

}
