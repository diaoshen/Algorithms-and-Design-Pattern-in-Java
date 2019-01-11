package edu.diao.gui.All;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
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
	private JButton button1,button2,button3;
	private JPanel  panel1,panel2,panel3,panel4,panel5;	
	private JLabel 	label1,label2,label3,label4;
	private ButtonGroup	group;
	private JRadioButton radio1,radio2,radio3;
	private JCheckBox check1,check2,check3;
	private JTextField text1;
	private JList<String> nameList;
	private JScrollPane scrollPane;
	private final int WINDOW_WIDTH = 1200;	//Window width
	private final int WINDOW_HEIGHT = 200;	//Window height
	private JButton addButton;
	private JTextField inputTextBox;
	private DefaultListModel<String> names;
	private JButton clearButton;
	private JList list2;
	private JComboBox<String> nameBox;
	
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
		text1 = new JTextField(10);
		text1.setEditable(false);
		label4 = new JLabel("Output");

		
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(3,0));
		panel3.add(label4);
		panel3.add(text1);


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
		clearButton = new JButton("Clear");
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
		 * Borders
		 */
		panel1.setBorder(BorderFactory.createTitledBorder("Column 1"));
		panel2.setBorder(BorderFactory.createTitledBorder("Column 2"));
		panel3.setBorder(BorderFactory.createTitledBorder("Column 3"));
		panel4.setBorder(BorderFactory.createTitledBorder("Column 4"));
		panel5.setBorder(BorderFactory.createTitledBorder("Column 5"));
		
		
		
		//Add JPanel to ContentPane
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		//Display window
		pack();
		setVisible(true);	
	}
	
	/*
	 * Private Inner Class 
	 */
	private class listener implements ActionListener , ItemListener , ListSelectionListener{

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
		@SuppressWarnings({ "deprecation", "unchecked" })
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
			list2.setListData(nameList.getSelectedValues());
			pack();
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();
	}

}
