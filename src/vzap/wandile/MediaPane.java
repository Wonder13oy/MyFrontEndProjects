package vzap.wandile;

import javax.swing.*;

public class MediaPane extends JTabbedPane
{
	private JPanel musicP, gameP, movieP;
	
	public MediaPane()
	{
		musicP = new JPanel();
		gameP = new JPanel();
		movieP = new JPanel();
		
		this.add("Games", gameP);
		this.add("Movies", movieP);
		this.add("Music", musicP);
		this.setVisible(true);
	}
}
