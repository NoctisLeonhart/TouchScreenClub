package tsc.core;

import tsc.Functions.Printer_Work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.*;

/**
 * Created by Noctis on 24.07.2014.
 */
public class Frame3_LastPage extends JFrame{
    private JLabel Thx;
    private JLabel DontForg;
    private JLabel UplYourFav;

    public Frame3_LastPage(int formW, int formH, int x, int y, java.util.List<String> LanguageList){
        Thx = new JLabel(LanguageList.get(16));
        DontForg = new JLabel(LanguageList.get(17));
        UplYourFav = new JLabel(LanguageList.get(18));

        setLayout(null);
        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(formW,formH));
        this.setPreferredSize(new Dimension(formW, formH));
        this.setLocation(new Point(x,y));
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                Thx.setLocation(new Point((int)e.getComponent().getSize().getWidth()/2-(int)Thx.getSize().getWidth()/2,(int)e.getComponent().getSize().getHeight()/3));
                DontForg.setLocation(new Point(
                        (int)e.getComponent().getSize().getWidth()/2-
                        (int)DontForg.getSize().getWidth()/2,
                        (int)Thx.getLocation().getY()+
                        (int)Thx.getSize().getHeight()+10));
                UplYourFav.setLocation(new Point(
                        (int)e.getComponent().getSize().getWidth()/2-
                        (int)UplYourFav.getSize().getWidth()/2,
                        (int)DontForg.getLocation().getY()+
                        (int)DontForg.getSize().getHeight()+10));

            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });

        Thx.setFont(new Font(null, Font.BOLD, 38));
        Thx.setSize(Thx.getPreferredSize());
        DontForg.setFont(new Font(null, Font.BOLD, 20));
        DontForg.setSize(DontForg.getPreferredSize());
        UplYourFav.setFont(new Font(null, Font.BOLD, 20));
        UplYourFav.setSize(UplYourFav.getPreferredSize());

        this.pack();
        this.setVisible(true);

        this.getContentPane().add(Thx);
        this.getContentPane().add(DontForg);
        this.getContentPane().add(UplYourFav);
        new Printer_Work(LanguageList.get(20)+";"+LanguageList.get(20));
    }
}
