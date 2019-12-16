package edu.diao.applet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JApplet;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class AppletDemo extends JApplet {
	/*
	 * The init method sets up the applet, much like a constructor
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JCheckBox[] checkBoxes;
	private String[] titles = { "Line" , "Rectangle" ,
								"Filled Rectangle" ,
								"Oval" , "Filled Oval",
								"Arc", "Filled Arc" };
	private JPanel checkBoxPanel;
	private DrawingPanel drawingPanel;
	

	public void init() {
		buildCheckBoxPanel();
		drawingPanel = new DrawingPanel(checkBoxes);
		add(checkBoxPanel,BorderLayout.EAST);
		add(drawingPanel,BorderLayout.CENTER);
	}
	
	private void buildCheckBoxPanel() {
		
		checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new GridLayout(7,1));
		
		checkBoxes = new JCheckBox[7];
		for(int i = 0 ; i < checkBoxes.length ; i++) {
			checkBoxes[i] = new JCheckBox(titles[i]);
			checkBoxes[i].addItemListener(new listener());
			checkBoxPanel.add(checkBoxes[i]);
		}
	}
	
	public void paint(Graphics g) {
		//This is full window canvas
		super.paint(g);
		System.out.println("In full window paint");
	}
	
	private class listener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Calling repaint()");
			drawingPanel.repaint();
		}
		
	}
	
	private class DrawingPanel extends JPanel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JCheckBox[] checkBoxArray;
		public DrawingPanel(JCheckBox[] inputArray) {
			checkBoxArray = inputArray;
			setBackground(Color.white);
			setPreferredSize(new Dimension(300,200));
		}
		
		//g is panel's graphics object , this method is called when repaint() is called or auto call when this component DrawingPanel/JPanel 
		//need to redisplay.
		
		public void paintComponent(Graphics g) {
			System.out.println("in paintComponent()");
			super.paintComponent(g);
			
			if(checkBoxArray[0].isSelected()) {
				g.setColor(Color.black);
				g.drawLine(10, 10, 290, 190);
			}
		}
		
	}
	
}
