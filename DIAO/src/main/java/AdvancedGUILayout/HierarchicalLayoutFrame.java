package AdvancedGUILayout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A frame that illustrates the use of radio buttons. This version uses
 * hierarchical template layout.
 *
 * Contentpane uses BorderLayout by doing setLayout(new BorderLayout())
 * 
 * 
 *  North contains JLabel for title
 *  Center contains JTextArea for text
 *  South contains JPanel but this JPanel uses a FlowLayout
 *  and inside this JPanel there is 3 button.
 *  
 *  
 */
public class HierarchicalLayoutFrame extends JFrame implements ActionListener {
	Container contentPane;
	JButton cancelButton, noButton, yesButton;
	JLabel titleLabel;
	JTextArea textArea;

	/**
	 * Default constructor
	 */
	public HierarchicalLayoutFrame() {
		JPanel southPanel;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * setLayout(new BorderLayout()); would have worked as well since this calss Extends JFrame
		 */
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		titleLabel = new JLabel();
		titleLabel.setText("An Example of Hierarchical Layout");
		contentPane.add(titleLabel, BorderLayout.NORTH);

		textArea = new JTextArea(40, 20);
		contentPane.add(textArea, BorderLayout.CENTER);

		southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		yesButton = new JButton("Oui");
		yesButton.setActionCommand("YES_BABY");
		yesButton.setMnemonic('O');
		yesButton.addActionListener(this);
		southPanel.add(yesButton);

		noButton = new JButton("Non");
		noButton.setActionCommand("NO");
		noButton.setMnemonic('N');
		noButton.addActionListener(this);
		southPanel.add(noButton);

		cancelButton = new JButton("Anuller");
		cancelButton.setActionCommand("CANCEL");
		cancelButton.setMnemonic('A');
		cancelButton.addActionListener(this);
		southPanel.add(cancelButton);

		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		//Pack contents of the window and display it
		pack();
		setVisible(true);

	}

	/**
	 * Handle actionPerformed messages
	 *
	 * @param ae
	 *            The ActionEvent that generated the message
	 */
	public void actionPerformed(ActionEvent ae) {
		textArea.append(ae.getActionCommand() + "\n");
	}

}
