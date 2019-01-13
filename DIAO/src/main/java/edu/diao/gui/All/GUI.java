package edu.diao.gui.All;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/*
 * Abstract Windowing Toolkit(AWT)
 * Java Swing
 * Java FX // Newest GUI maker
 * 
 * 
 * GUI Terminology 
 * 
 * Window : a first-class citizen of the graphical desktop 
 * 			ex. frame , dialog box , applet 
 * Component : An interative GUI Object that resides in a window
 * 			ex. button , text area, checkbox , label , canvas 
 * Container : A logical grouping for storing component 
 * 			ex. panel , table , box , scroll pane
 */
public class GUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton button1,button2,button3,clearButton,addButton,fileOpenButton;
	private JPanel  panel1,panel2,panel3,panel4,panel5,panel6;
	@SuppressWarnings("unused")
	private JLabel 	label1,label2,label3,label4;
	private ButtonGroup	group;
	private JRadioButton radio1,radio2,radio3;
	private JCheckBox check1,check2,check3;
	private JTextField text1,inputTextBox;
	private JList<String> nameList;
	private JScrollPane scrollPane,scroll2;
	private final int WINDOW_WIDTH = 1200;	//Window width
	private final int WINDOW_HEIGHT = 200;	//Window height
	private DefaultListModel<String> names;
	private JList<String> list2;
	private JComboBox<String> nameBox;
	private JMenuBar menuBar;
	private JMenuItem exitItem;
	private JMenu fileMenu;
	private JRadioButtonMenuItem blackItem;
	private JRadioButtonMenuItem redItem;
	private JCheckBoxMenuItem visibleItem;
	private JMenu textMenu;
	private JTextArea area1;
	private JSlider slider1,slider2;

	
	/*
	 * Constructor
	 */
	public GUI() {
		//Set title bar text
		setTitle("GUI Demo");	
		//Set size of the window
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);		
		//Set default close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set Layout
		setLayout(new GridLayout(1,4));

		
		
		//Create 3 label
		label1 = new JLabel("Butt1");
		label2 = new JLabel("Butt2");
		label3 = new JLabel("Butt3");



		/*
		 * Column 1
		 */
		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		button3 = new JButton("Button 3");
		button1.addActionListener(new listener());
		button2.addActionListener(new listener());
		button3.addActionListener(new listener());
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,0));
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);	
		/*
		 * Column 2
		 */
		radio1 = new JRadioButton("1/2" , true);
		radio2 = new JRadioButton("2/2", true);
		radio3 = new JRadioButton("Radio3", true);
		group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,0));
		panel2.add(radio1);
		panel2.add(radio2);
		panel2.add(radio3);
		/*
		 * Column 3
		 */
		label4 = new JLabel("Output");

		
		text1 = new JTextField(10);
		text1.setEditable(false);

		
		area1 = new JTextArea("Blah" , 3 , 3);
		area1.setLineWrap(true);
		area1.setFont(new Font("Serif" , Font.BOLD + Font.ITALIC , 24));
		scroll2 = new JScrollPane(area1);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(3,0));
		panel3.add(label4);
		panel3.add(text1);
		panel3.add(scroll2);


		/*
		 * Column 4
		 */
		check1 = new JCheckBox("Check1");
		check2 = new JCheckBox("Check2");
		check3 = new JCheckBox("Check3");
		check1.addItemListener(new listener());
		check2.addItemListener(new listener());
		check3.addItemListener(new listener());
		panel4 = new JPanel();
		panel4.setLayout(new GridLayout(3,0));
		panel4.add(check1);
		panel4.add(check2);
		panel4.add(check3);
		
		/*
		 * Column 5
		 */
		String names2[] = {"Bill" , "Geril" , "Greg" , "Jean" , "Kirk" , "Susan" ,"Bob" , "Aiden"};
		names = new DefaultListModel<String>();
		for(int i = 0 ; i < names2.length ; i++) {
			names.addElement(names2[i]);
		}
		nameList = new JList<String>(names);
		nameList.addListSelectionListener(new listener());
		nameList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		nameList.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		nameList.setVisibleRowCount(3);
		scrollPane = new JScrollPane(nameList);
		
		nameBox = new JComboBox<String>(names2);
		nameBox.addActionListener(new listener());
		

		addButton = new JButton("Add");
		addButton.addActionListener(new listener());
		addButton.setMnemonic(KeyEvent.VK_A);
		addButton.setToolTipText("Click to add item to JLIST");
		clearButton = new JButton("Clear");
		clearButton.setMnemonic(KeyEvent.VK_C);
		clearButton.addActionListener(new listener());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0,2));
		buttonPanel.add(addButton);
		buttonPanel.add(clearButton);
		
		inputTextBox = new JTextField(10);
		inputTextBox.setBorder(BorderFactory.createTitledBorder("Enter text below"));
		
		list2 = new JList<String>();
		list2.setBorder(BorderFactory.createTitledBorder("Selected Values"));
		
		
		panel5 = new JPanel();
		panel5.add(scrollPane);
		panel5.add(nameBox);
//		panel5.add(addButton);
//		panel5.add(clearButton);
		panel5.add(buttonPanel);
		panel5.add(inputTextBox);
		panel5.add(list2);
		panel5.setLayout(new GridLayout(5,0));
		
		/*
		 * Column 6 / Choosers
		 */
		fileOpenButton = new JButton("Open");
		fileOpenButton.addActionListener(new listener());
		
		slider1 = new JSlider(JSlider.HORIZONTAL, 0 , 50 ,25);
		slider1.setMajorTickSpacing(10);
		slider1.setMinorTickSpacing(2);
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.addChangeListener(new listener());
		slider2 = new JSlider(JSlider.VERTICAL, 0 , 50 , 25);
		
		panel6 = new JPanel();
		panel6.setLayout(new GridLayout(3,0));
		panel6.add(fileOpenButton);
		panel6.add(slider1);
		panel6.add(slider2);
		/*
		 * Borders
		 */
		panel1.setBorder(BorderFactory.createTitledBorder("JButton"));
		panel2.setBorder(BorderFactory.createTitledBorder("JRadioButton"));
		panel3.setBorder(BorderFactory.createTitledBorder("JLabel,JTextField/Area"));
		panel4.setBorder(BorderFactory.createTitledBorder("JCheckBox"));
		panel5.setBorder(BorderFactory.createTitledBorder("Column 5"));
		panel6.setBorder(BorderFactory.createTitledBorder("Choosers"));
		
		/*
		 * Menus 
		 */

		//File Menu
		exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.addActionListener(new listener());
		
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.add(exitItem);
		
		//Text Menu
		blackItem = new JRadioButtonMenuItem("Black", true);
		blackItem.addActionListener(new listener());
		
		redItem = new JRadioButtonMenuItem("Red");
		redItem.addActionListener(new listener());
		
		ButtonGroup radioMenuGroup = new ButtonGroup();
		radioMenuGroup.add(blackItem);
		radioMenuGroup.add(redItem);
		
		visibleItem = new JCheckBoxMenuItem("Visible", true);
		visibleItem.addActionListener(new listener());
		
		textMenu = new JMenu("Text");
		textMenu.add(blackItem);
		textMenu.add(redItem);
		textMenu.addSeparator();
		textMenu.add(visibleItem);
		
		
		
		//MenuBar
		menuBar = new JMenuBar(); //MenuBar	
		
		menuBar.add(fileMenu);
		menuBar.add(textMenu);
		
		setJMenuBar(menuBar);
		
		
		
		
		
		
		//Add JPanel to ContentPane
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
		//Display window
		pack();
		setVisible(true);	
	}
	
	/*
	 * Private Inner Class 
	 */
	private class listener implements ActionListener , ItemListener , ListSelectionListener , ChangeListener{

		@SuppressWarnings("unused")
		@Override
		public void actionPerformed(ActionEvent e) {
			Object x = e.getSource();
			//Determine which button was clicked and display a message
			if(x == button1) {
				JOptionPane.showMessageDialog(null, "First button clicked");
			}
			else if(x == button2)
			{
				JOptionPane.showMessageDialog(null, "Second button clicked");
			}
			else if(x == button3)
			{
				JOptionPane.showMessageDialog(null, "Third button clicked");
			}
			else if(x == addButton) {
				names.addElement((String)inputTextBox.getText());
			}
			else if(x == clearButton) {
				names.clear();
			}
			else if(x == nameBox) {
				text1.setText((String) nameBox.getSelectedItem());
			}
			else if(x == fileOpenButton) {
				JFileChooser chooser = new JFileChooser();
				int status = chooser.showOpenDialog(null);
				if(status == JFileChooser.APPROVE_OPTION) {
					text1.setText(chooser.getSelectedFile().getPath());
				}
				int status2 = chooser.showSaveDialog(null);
				text1.setText(chooser.getSelectedFile().getPath());
			}
			else if(x == exitItem) {
				System.exit(0);
			}
			else if(x == blackItem) {
				text1.setForeground(Color.BLACK);
			}
			else if(x == redItem) {
				text1.setForeground(Color.RED);
			}
			else if(x == visibleItem) {
				if(visibleItem.isSelected() == true) {
					getContentPane().setVisible(true);
				}else {
					getContentPane().setVisible(false);
				}
			}
			pack();
			
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == check1) {
				if(check1.isSelected()) {
					text1.setText("Check1 true");
				}else {
					text1.setText("Check1 false");
				}
			}
			else if(e.getSource() == check2) {
				if(check2.isSelected()) {
					text1.setText("Check2 true");
				}else {
					text1.setText("Check2 false");
				}
			}
			else if(e.getSource() == check3) {
				if(check3.isSelected()) {
					text1.setText("Check3 true");
				}else {
					text1.setText("Check3 false");
				}
			}
			pack();
		}
		@SuppressWarnings({ "deprecation" })
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			//String[] selectedName = (String[]) nameList.getSelectedValues();
			//text1.setText(selectedName);
			String all = "";
			for(String s : nameList.getSelectedValuesList()) {
				all  += (s + "\r\n");
			}
			text1.setText(all);
			list2.setListData((String[]) nameList.getSelectedValues());
			pack();
		}
		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			Object x = e.getSource();
			if(x == slider1) {
				area1.append(Integer.toString(slider1.getValue()) + "\n");
			}
		}
	}
	
	
	
	/*
	 * paint() is called when app is first launched.
	 * paint() is called whenever windows need to redisplayed
	 *  canvas size = whole app window
	 *  
	 *  similar method is the drawComponent(Graphics g) which is in every JComponents for redisplaying components
	 */
	public void paint(Graphics g) {
		//Call superclass paint()
		super.paint(g);
		
		//draw a red line from (20,20) to (280,280)
		g.setColor(Color.RED);
		g.drawLine(20,20,280,280);
		
		//draw a blue line from (280,20) to (20,280)
		g.setColor(Color.blue);
		g.drawLine(280, 20, 20, 280);
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();
	}

}
