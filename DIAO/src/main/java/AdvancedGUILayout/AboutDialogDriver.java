package AdvancedGUILayout;

import java.awt.*;

import AdvancedGUILayout.AboutDialog;



/**
 * An example that uses the AboutDialog
 *
 */
public class AboutDialogDriver
{

    /**
     * The entry point
     *
     * @param args  The command line arguments
     */
    public static void main(String[] args)
    {
        AboutDialog           about;
        CloseableFrame        f;



        f = new CloseableFrame();
        about = new AboutDialog(f, "Sac State",
                                "California State University, Sacramento\n"+
                                "is a public comprehensive university in\n"+
                                "Sacramento, the capital city of the \n"+
                                "U.S. state of California. Founded in\n"+
                                "1947 as Sacramento State College, it is\n"+
                                "the eleventh oldest school in the \n"+
                                "23-campus California State University \n"+
                                "System."
                                );
        about.setVisible(true);

    }


}

