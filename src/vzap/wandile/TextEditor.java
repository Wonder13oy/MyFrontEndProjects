package vzap.wandile;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class TextEditor extends JPanel implements ActionListener, CaretListener
{
	private JPanel nPan, sPan, cPan;
	private JButton openFile, saveFile, exit;
	private JTextField filePathJTF;
	private JLabel filePath;
	private JTextField textF;
	private Font font;
	private JScrollPane scroll;
	private JTextArea txtArea;
	private File file;
	private BufferedReader br;
	private PrintWriter pw;
	private JOptionPane fileSaved;
	private JFileChooser fileChosen;
	
	public TextEditor()
	{
		font = new Font("Arial", Font.BOLD, 28);
		NorthPanel();
		CenterPanel();
		SouthPanel();
		SetupFrame();
		
		fileSaved = new JOptionPane();
		fileSaved.setLocation(new Point(500, 500));
		file = new File(filePathJTF.getText());
		
//		fileChosen = new JFileChooser(filePathJTF.getText());
//		fileChosen.setDialogTitle("Open File");
//		fileChosen.showOpenDialog(openFile);
//		fileChosen.showSaveDialog(saveFile);
//		fileChosen.setVisible(false);
	}
	public void NorthPanel()
	{
		nPan = new JPanel();
		filePath= new JLabel("File Path: ");
		filePath.setFont(font);
		filePathJTF = new JTextField(20);
		filePathJTF.setFont(font);
		filePathJTF.addActionListener(this);
		nPan.add(filePath);
		nPan.add(filePathJTF);
	}
	public void CenterPanel()
	{
		cPan = new JPanel(new GridLayout(1, 1));
		cPan.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), BorderFactory.createTitledBorder("Enter Text")));
		txtArea = new JTextArea();
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		scroll = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		cPan.add(scroll);
	}
	public void SouthPanel()
	{
		sPan = new JPanel();
		openFile = new JButton("Open File");
		openFile.setEnabled(false);
		openFile.setFont(font);
		openFile.addActionListener(this);
		saveFile = new JButton("Save File");
		saveFile.setEnabled(false);
		saveFile.setFont(font);
		saveFile.addActionListener(this);
		exit = new JButton("Exit");
		exit.setEnabled(true);
		exit.setFont(font);
		exit.addActionListener(this);
		sPan.add(openFile);
		sPan.add(saveFile);
		sPan.add(exit);
	}
	public void SetupFrame()
	{
		this.setLayout(new BorderLayout());
		this.add(nPan, BorderLayout.NORTH);
		this.add(cPan, BorderLayout.CENTER);
		this.add(sPan, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	public static void main(String[] args)
	{
		new TextEditor();
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Object source = ae.getSource();
		String str = null;
		if(source == filePathJTF)
		{
			if(filePathJTF.getText() == " ")
			{
				return;
			}
			fileChosen = new JFileChooser(filePathJTF.getText());
			fileChosen.addActionListener(this);
			openFile.setEnabled(true);
		}
		if(source == exit)
		{
			System.exit(0);
		}
//		if(source == )
		if(source == saveFile)
		{
			fileChosen.showSaveDialog(txtArea);
			try
			{
				pw = new PrintWriter(new FileWriter(fileChosen.getSelectedFile()));
				pw.write(txtArea.getText());
				pw.flush();
				pw.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(txtArea,"File Saved!");
			txtArea.setText(" ");
			saveFile.setEnabled(false);
			openFile.setEnabled(true);
		}
		if(source == openFile)
		{
			fileChosen.showOpenDialog(txtArea);
			fileChosen.setVisible(true);
			
			try
			{
				br = new BufferedReader(new FileReader(fileChosen.getSelectedFile()));
					while((str = br.readLine()) != null)
					{
						txtArea.setText(txtArea.getText() + str + "\n");
					}
				br.close();
				txtArea.addCaretListener(this);
			} catch (IOException e)
			{
				e.printStackTrace();
			} 
			saveFile.setEnabled(true);
			openFile.setEnabled(false);
		}
	}
	@Override
	public void caretUpdate(CaretEvent arg0)
	{
		
	}
}
