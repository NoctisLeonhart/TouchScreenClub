package tsc.core;

import javax.swing.*;

/**
 * Created by Noctis on 23.07.14.
 */
public class mainClass {

    public static void main(String[] args) throws UnsupportedLookAndFeelException
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                new Frame1_ChangeLanguage();
            }
        });

    }
}
