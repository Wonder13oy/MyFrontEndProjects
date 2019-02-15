package vzap.wandile;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SecondGUI extends JFrame implements ActionListener, ListSelectionListener//Step 1 -
{
	private JPanel centerPanel;
	private JButton redButton, greenButton, blueButton;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel westPanel;
	private JPanel eastPanel, eastPanelUp, eastPanelDwn;
	private ImageIcon icon;
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	private JLabel infoLabel;
	private JTextField userNameJTF;
	private JTextField infoJTF;
	private JPasswordField pswField;
	private Color defaultcolor;
	private Color randomColor;
	private int count;
	private JCheckBox jb1, jb2, jb3;
	private JRadioButton jrb1, jrb2, jrb3;
	private JList<String> list;
	private Vector<String> listVector;
	private JScrollPane pane;
	private JButton yesBut, noBut;
	private JComboBox<String> comboBox;
	
	public SecondGUI()
	{
		centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		centerPanel.setBackground(Color.BLACK);
		count = 0;
		
		southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		southPanel.setBorder(BorderFactory.createEtchedBorder(Color.CYAN, Color.GREEN));
		southPanel.setBackground(Color.BLACK);
		icon = new ImageIcon("images/dice1.gif");
		redButton = new JButton("Red Button", icon);
		redButton.addActionListener(this);//Step 2
		redButton.addMouseListener(new MyMouseListener());
		redButton.setToolTipText("This is button throws the dice.");
//		redButton.setEnabled(true);
		greenButton = new JButton("Green Button");
		greenButton.addMouseListener(new MyMouseListener());
		greenButton.addActionListener(this);
		blueButton = new JButton("Blue Button");
		blueButton.addMouseListener(new MyMouseListener());
		blueButton.addActionListener(this);
		yesBut = new JButton("Add");
		yesBut.addActionListener(this);
		noBut = new JButton("Delete");
		noBut.addActionListener(this);
		defaultcolor = redButton.getBackground();
		
		centerPanel.add(redButton);
		centerPanel.add(blueButton);
		centerPanel.add(greenButton);
		
		northPanel = new JPanel(new GridLayout(2, 2, 10, 15));
		northPanel.setBackground(Color.BLACK);
		northPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), 
																BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.CYAN),
																								"Username & Password",
																								TitledBorder.TOP,
																								TitledBorder.CENTER,
																								new Font("Arial", Font.BOLD, 24),
																								Color.CYAN)));
		userNameLabel = new JLabel("Username: ", SwingConstants.LEFT);
		userNameLabel.setFont(new Font("dialog", Font.BOLD, 24));
		northPanel.add(userNameLabel);
		
		userNameJTF = new JTextField(20);
		userNameJTF.setFont(new Font("dialog", Font.BOLD, 24));
		userNameJTF.addActionListener(this);
		userNameJTF.addKeyListener(new MyKeyListener());
		northPanel.add(userNameJTF);
		
		passwordLabel = new JLabel("Password: ", SwingConstants.LEFT);
		passwordLabel.setFont(new Font("dialog", Font.BOLD, 24));
		pswField = new JPasswordField(15);
		pswField.setFont(new Font("dialog", Font.BOLD, 24));
		pswField.addActionListener(this);
		northPanel.add(passwordLabel);
		northPanel.add(pswField);
		
		infoLabel = new JLabel("Info: ", SwingConstants.CENTER);
		infoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		infoJTF = new JTextField(20);
		MyFocusListener mfl = new MyFocusListener();
		infoJTF.addFocusListener(mfl);
		infoJTF.setFont(new Font("Arial", Font.ITALIC, 12));
		infoJTF.addActionListener(this);
		southPanel.add(infoLabel);
		southPanel.add(infoJTF);
		
		listVector = new Vector<String>();
		listVector.add("Nissan");
		listVector.add("BMW");
		listVector.add("Ford");
		listVector.add("Aston Martin");
		listVector.add("Ferrari");
		listVector.add("Mazda");
		listVector.add("Audi");
		listVector.add("Chevrolet");
		listVector.add("Mini Cooper");
		listVector.add("Maserati");
		
		list = new JList<>(listVector);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(2);
		pane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.setBackground(Color.BLACK);
		
		comboBox = new JComboBox<>(listVector);
		comboBox.addActionListener(this);
		comboBox.setMaximumRowCount(3);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 22));
		comboBox.addItem("Wandile");
		comboBox.addItem("Greg");
		comboBox.addItem("Bongi");
		comboBox.addItem("Imraan");
		comboBox.addItem("Sami");
		comboBox.addItem("Kimesh");
		comboBox.addItem("Mohammed");
		comboBox.addItem("Jono");
		comboBox.addItem("Jonathan");
		comboBox.addItem("Blake");
		comboBox.addItem("Warren");
		
		westPanel();
		eastPanel();
		setupFrame();
	}
	public void westPanel()
	{
		westPanel = new JPanel(new GridLayout(2, 3, 10, 10));
		westPanel.setBackground(Color.BLACK);
		westPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
		ButtonGroup bg = new ButtonGroup();
		Font f = new Font("Arial", Font.BOLD, 32);
		jb1 = new JCheckBox("Music");
		jb2 = new JCheckBox("Game");
		jb3 = new JCheckBox("Movie");
		bg.add(jb1);
		bg.add(jb2);
		bg.add(jb3);
		jb1.setFont(f);
		jb2.setFont(f);
		jb3.setFont(f);
		
		jrb1 = new JRadioButton("Durban");
		jrb1.addActionListener(this);
		jrb2 = new JRadioButton("Cape Town");
		jrb2.addActionListener(this);
		jrb3 = new JRadioButton("Eshowe");
		jrb3.addActionListener(this);
		
		westPanel.add(jb1);
		westPanel.add(jb2);
		westPanel.add(jb3);
		westPanel.add(jrb1);
		westPanel.add(jrb2);
		westPanel.add(jrb3);
	}
	public void eastPanel()
	{
		eastPanel = new JPanel(new GridLayout(2, 1));
		eastPanel.setBackground(Color.BLACK);
		eastPanel.setBorder(BorderFactory.createEtchedBorder());
		eastPanelUp = new JPanel(new GridLayout(1, 1));
		eastPanelUp.setBackground(Color.BLACK);
		eastPanelUp.add(list);
		eastPanelUp.add(comboBox);
		eastPanelDwn = new JPanel();
		eastPanelDwn.setBackground(Color.BLACK);
		eastPanelDwn.add(yesBut);
		eastPanelDwn.add(noBut);
		eastPanel.add(eastPanelUp);
		eastPanel.add(eastPanelDwn);
	}
	public void randomColor()
	{
		switch((int)(Math.random() * 12 + 1))
		{
			case 1	:	centerPanel.setBackground(Color.BLACK);
						break;
			case 2	:	centerPanel.setBackground(Color.BLUE);
						break;
			case 3	:	centerPanel.setBackground(Color.CYAN);
						break;
			case 4	:	centerPanel.setBackground(Color.DARK_GRAY);
						break;
			case 5	:	centerPanel.setBackground(Color.GREEN);
						break;
			case 6	:	centerPanel.setBackground(Color.LIGHT_GRAY);
						break;
			case 7	:	centerPanel.setBackground(Color.MAGENTA);
						break;
			case 8	:	centerPanel.setBackground(Color.ORANGE);
						break;
			case 9	:	centerPanel.setBackground(Color.PINK);
						break;
			case 10	:	centerPanel.setBackground(Color.RED);
						break;
			case 11	:	centerPanel.setBackground(Color.YELLOW);
						break;
			case 12	:	centerPanel.setBackground(Color.WHITE);
						break;
		}
	}
	public void setupFrame()
	{
		this.setTitle("Second GUI");
		this.setSize(750, 500);
		this.setLocation(400, 250);
		this.add(centerPanel);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(westPanel, BorderLayout.WEST);
		this.add(eastPanel, BorderLayout.EAST);
		this.addWindowListener(new MyWindowListener());
		this.setVisible(true);
//		for (int i = 0; i < 100; i++)
//		{
//			if(i == 25 || 1 == 50 || 1 == 75)
//			{
//				try
//				{
//					redButton.doClick();
//					Thread.sleep(500);
//				} catch (InterruptedException e)
//				{
//					e.printStackTrace();
//				}
//			}
//		}
	}
	public void setButtons()
	{
//		redButton.setBackground(Color.BLUE);
//		
//		blueButton.setBackground(Color.DARK_GRAY);
//		
//		greenButton.setBackground(Color.DARK_GRAY);
	}
	//Step 3 - Override the abstract method
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == jrb1 || source == jrb2 || source == jrb3)
		{
			if(jrb1.isSelected())
			{
				infoJTF.setText("Durban Selected");
			}
			if(jrb2.isSelected())
			{
				infoJTF.setText("Cape Town Selected");
			}
			if(jrb3.isSelected())
			{
				infoJTF.setText("Eshowe Selected");
			}
		}
		if(source == redButton)
		{
			centerPanel.setBackground(Color.RED);
		}
		if(source == blueButton)
		{
			count++;
			infoJTF.setText("count= " + count);
			randomColor();
		}
		if(source == greenButton)
		{
			count--;
			infoJTF.setText("count= " + count);
			centerPanel.setBackground(Color.GREEN);
		}
		if(source == userNameJTF)
		{
			infoJTF.setText(userNameJTF.getText().toUpperCase());
		}
		if(source == pswField)
		{
			infoJTF.setText(new String(pswField.getPassword()));
		}
		if(source == yesBut)
		{
			list.removeListSelectionListener(this);
				if(list != null)
				{
					listVector.add(infoJTF.getText());
					list.setListData(listVector);
				}
			list.addListSelectionListener(this);
			comboBox.removeActionListener(this);
				if(comboBox != null)
				{
					comboBox.insertItemAt(infoJTF.getText(), 0);
				}
			comboBox.addActionListener(this);
		}
		if(source == noBut)
		{
			list.removeListSelectionListener(this);
			listVector.remove(list.getSelectedValue());
			list.setListData(listVector);
			list.addListSelectionListener(this);
			comboBox.removeActionListener(this);
			comboBox.removeItem(comboBox.getSelectedItem());
			comboBox.addActionListener(this);
		}
	}
	
	public static void main(String[] args)
	{
		SecondGUI sg = new SecondGUI();
		sg.setButtons();
		sg.setupFrame();
		
	}
	private class MyKeyListener extends KeyAdapter
	{
		@Override
		public void keyTyped(KeyEvent key)
		{
			char ch = key.getKeyChar();
			if((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z'))
			{
				key.consume();
			}
		}
	}
	private class MyWindowListener extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent arg0)
		{
			System.exit(0);
		}
	}
	private class MyFocusListener extends FocusAdapter
	{
		@Override
		public void focusGained(FocusEvent fe)
		{
			infoJTF.setText("");
		}
	}
	private class MyMouseListener extends MouseAdapter
	{
		@Override
		public void mouseEntered(MouseEvent me)
		{
			Object source = me.getSource();
			if(source == redButton)
			{
				redButton.setBackground(Color.RED);
			}
			if(source == blueButton)
			{
				blueButton.setBackground(Color.BLUE);
			}
			if(source == greenButton)
			{
				greenButton.setBackground(Color.GREEN);
			}
		}
		@Override
		public void mouseExited(MouseEvent me)
		{
			Object source = me.getSource();
			if(source == redButton)
			{
				redButton.setBackground(defaultcolor);
			}
			if(source == blueButton)
			{
				blueButton.setBackground(defaultcolor);
			}
			if(source == greenButton)
			{
				greenButton.setBackground(defaultcolor);
			}
		}
		@Override
		public void mouseClicked(MouseEvent me)
		{
			
		}
	}
	@Override
	public void valueChanged(ListSelectionEvent frikkie)
	{
		Object source = frikkie.getSource();
		if(frikkie.getValueIsAdjusting())
		{
			return;
		}
		int index = list.getSelectedIndex();
		String car = list.getSelectedValue();
		infoJTF.setText("Car: " + car + " index: " + index);
	}
}
