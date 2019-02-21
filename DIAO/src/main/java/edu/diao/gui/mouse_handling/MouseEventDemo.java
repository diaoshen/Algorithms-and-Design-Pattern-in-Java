package edu.diao.gui.mouse_handling;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class MouseEventDemo extends JFrame implements MouseListener , MouseMotionListener , ActionListener{

	
	private JTextField[] mouseStates;
	private String[] text  = { "Pressed" , "Clicked" , "Released" , "Entered" , "Exited" , "Dragged" , "X:" , "Y:" };
	private int currentX = 0;
	private int currentY = 0;
	@SuppressWarnings("unused")
	private int width = 0;
	@SuppressWarnings("unused")
	private int height = 0;
	
	
	//Timer Variables
	private final int X = 109;
	private int Y = 400;
	private final int WIDTH = 40;
	private final int HEIGHT = 40;
	private final int TIME_DELAY = 300;
	private final int MOVE = 15;
	private final int MIN_Y = 99;
	private final int MAX_Y = 426;
	private boolean goingUp = true;
	private Timer timer;
	
	
	/*
	 * Constructor
	 */
	public MouseEventDemo() {
		setLayout(new FlowLayout());
		
		mouseStates = new JTextField[8];
		for(int i = 0 ; i< mouseStates.length; i++) {
			mouseStates[i] = new JTextField(text[i],10);
			mouseStates[i].setEditable(false);
			add(mouseStates[i]); //Add to content pane
		}
		
		//addMouseListener(this);
	//	addMouseMotionListener(this);
		timer = new Timer(TIME_DELAY , this);
		timer.start();
		
		setVisible(true);
		//pack();
		setSize(500, 600);
		
	}
	
	/**
	 * 
	 * set all of the text bg to light gray
	 */
	public void clearTextFields() {
		for(int i = 0 ; i< 6 ; i++) {
			mouseStates[i].setBackground(Color.LIGHT_GRAY);
		}
	}
	
	/*
	 * paint method
	 * @param g The app's Graphics object
	 */
	public void paint(Graphics g) {
		super.paint(g);
		//g.drawRect(currentX, currentY, width, height);
		
		g.setColor(Color.red);
		
		
		g.fillOval(X, Y, WIDTH, HEIGHT);
	}
	
	public static void main(String[] args) {
		new MouseEventDemo();
	}
	
	
	
	
	

	

	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		clearTextFields();
		mouseStates[1].setBackground(Color.yellow);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		clearTextFields();
		mouseStates[3].setBackground(Color.yellow);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		clearTextFields();
		mouseStates[4].setBackground(Color.yellow);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		clearTextFields();
		mouseStates[0].setBackground(Color.yellow);
		currentX = e.getX();
		currentY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		clearTextFields();
		mouseStates[2].setBackground(Color.yellow);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	//	clearTextFields();
		mouseStates[5].setBackground(Color.YELLOW);
		width = e.getX() - currentX;
		height = e.getY() - currentY;
		
		//repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseStates[6].setText("X: " + e.getX());
		mouseStates[7].setText("Y: " + e.getY());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(goingUp) {
			if( Y > MIN_Y ) {
				Y -= MOVE;
			}else {
				goingUp = false;
			}
		}else {
			if(Y < MAX_Y) {
				Y += MOVE;
			}else {
				goingUp = true;
			}
		}
		System.out.println("LALA");
		repaint();
	}

}
