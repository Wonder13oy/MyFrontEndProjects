package vzap.wandile;

import javax.swing.JDialog;

public class ClockGUIDialog extends JDialog
{
	public ClockGUIDialog()
	{
		setup();
	}
	private void setup()
	{
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new ClockGUIDialog();
	}

}
