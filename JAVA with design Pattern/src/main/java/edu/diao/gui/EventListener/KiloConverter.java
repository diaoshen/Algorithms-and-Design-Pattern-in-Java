/*
 * AUTHOR : DIAO
 * DATE 10/23/2018 
 * 
 * Basics of Making GUI AND Event Driven Programming
 * -Concepts Shown in this tutorial :
 * 1.Inner Class
 * 2.Event Listener Class 
 * 3.Register Event Listener
 * 4.Create simple JFrame/Container/Window
 * 5.ContentPane and JPanel
 * 6.JComponents 
 * 
 * Tutorial FLOW: 
 * 1. Create JComponents .. such as JButton , JLabel...
 * 2. Create JPanel and add JComponents in 
 * 3. Slap JPanel into JFrame's content Pane to display
 * 4. Creates Event Listener Class to handle button event
 */


package edu.diao.gui.EventListener;


import java.awt.event.*; // For Event Listener 
import javax.swing.*; // To use all swing classes


public class KiloConverter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // UNKNOWN ?
	private JPanel panel;					//To reference a panel
	private JLabel messageLabel;			//To reference a label
	private JTextField inputTextField; 		//To rerference a textfield
	private JButton calButton;				//To reference a button
	private final int WINDOW_WIDTH = 400;  //Window width in pixel
	private final int WINDOW_HEIGHT = 100;  //Window height in pixel
	
	/*
	 * Constructor 
	 */
	KiloConverter(){
		//Set Window Title
		setTitle("Kilometer Converter");
		
		//Set the size of the window
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		//Specify what happens when the close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Build JPanel Object with components added to JPanel
		buildJPanel();
		
		//Add JPanel to JFrame's content pane , Same as doing JFrame.add(Component)
		add(panel); 
		
		//Display the window
		this.setVisible(true);
	}
	
	/*
	 * Creates a JPanel Object and adds all other swing Components to JPanel Object
	 */
	private void buildJPanel() {
		//Create a label to display instructions.
		messageLabel = new JLabel("Enter a distance " + "in kilometers");
		
		//Create a text field 10 characters wide
		inputTextField = new JTextField(10);
		
		//Create a button with the caption "Calculate"
		calButton = new JButton("Calculate");
		
		//Register listener to button , so button knows who to send notification to
		calButton.addActionListener(new buttonListener());
		
		//Create a JPanel object and let the panel field reference it
		panel = new JPanel();
		
		//Add Components to JPanel
		panel.add(messageLabel);
		panel.add(calButton);
		panel.add(inputTextField);
	}
	
	/*
	 * Java Allows Inner Class 
	 * 
	 * Writing Event Listener as Private Inner Class
	 * There are other ways to write Event Listener
	 * 
	 * When JButton is clicked, it  generates a object of type/class namely = " ActionEvent " 
	 * The class that can handle this type of event is namely = " ActionListener "
	 * Different Component generate different types/class of event
	 * Different types of event will use different type of interface to handle
	 */
	 private class buttonListener implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
	 
			 /*
			  * Technically you can do whatever you want when ActionEvent object 
			  * is passed into this function
			  * 
			  * I just choose to setText ... because I'm Lazy.
			  */
			  calButton.setText("DONE");
		 }
	 }
	 

	
	/*
	 * Creates an anonymous kiloConverter Object 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KiloConverter();
	}

}
