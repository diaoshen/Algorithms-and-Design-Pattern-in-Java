package AdvancedGUILayout;

import java.awt.*;
import javax.swing.*;

/**
 * A frame that illustrates the use of a JTabbedPane.
 *
 */
public class JTabbedPaneFrame extends JFrame
{
    



    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public JTabbedPaneFrame()
    {
       Container     contentPane;
       JPanel        complements, criticisms;
       JTabbedPane   tabbedPane;


       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       contentPane = getContentPane();

       contentPane.setLayout(new BorderLayout());
       tabbedPane = new JTabbedPane();
       contentPane.add(tabbedPane, BorderLayout.CENTER);

       complements = new JPanel();
       complements.setLayout(new BorderLayout());
       complements.add(new JLabel("Things you like about this class:"),
                       BorderLayout.NORTH);
       complements.add(new JTextArea(), BorderLayout.CENTER);

       criticisms = new JPanel();
       criticisms.setLayout(new BorderLayout());
       criticisms.add(new JLabel("Things you dislike about this class:"),
                      BorderLayout.NORTH);

        
       tabbedPane.addTab("Complements", complements);
       tabbedPane.addTab("Criticisms",  criticisms);
    }


}
