package edu.diao.applet;

import java.awt.FlowLayout;

import javax.swing.JApplet;
import javax.swing.JLabel;

public class AppletDemo extends JApplet {
	/*
	 * The init method sets up the applet, much like a constructor
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
		
		//Create a label.
		JLabel label = new JLabel("First applet");
		
		//Layout
		setLayout(new FlowLayout());
		
		// Add label to content pane
		add(label);
	}
}
