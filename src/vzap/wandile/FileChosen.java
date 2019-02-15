package vzap.wandile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FileChosen extends JPanel
{
	private JFileChooser fileChosen;
	
	public FileChosen()
	{
		fileChosen = new JFileChooser("C:\\Users\\Wandile Nxumalo\\Documents\\Sept 2018\\eclipseWorkSpace\\SwingProject\\resources");
		fileChosen.setDialogTitle("Open File");
		fileChosen.showOpenDialog(new TextEditor());
		fileChosen.showSaveDialog(new TextEditor());
		fileChosen.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new FileChosen();
	}
}
