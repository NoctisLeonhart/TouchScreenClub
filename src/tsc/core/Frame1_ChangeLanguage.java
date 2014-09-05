package tsc.core;

import tsc.Functions.Language;
import tsc.Functions.TSCConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Noctis on 23.07.14.
 */
public class Frame1_ChangeLanguage extends JFrame {

    private JLabel mainLabel;
    private JLabel ChangeLanguageLabel;
    private List<JButton> Button_LNG_List = new LinkedList<JButton>();
    private List<JLabel> ButtonsNames = new LinkedList<JLabel>();
    private final JFrame LinkMainFrame = this;
    private TSCConfig configuration = new TSCConfig();
    private Language langCh;
    private List<String> DefaultLanguageList = new LinkedList<String>();

    public Frame1_ChangeLanguage(){
        initFrameComponents();
    }

    private void initFrameComponents(){
        langCh = new Language(getLanguageID(configuration.getDefaultLanguage()));
        DefaultLanguageList = langCh.getLanguage();
        mainLabel = new JLabel(DefaultLanguageList.get(0));
        ChangeLanguageLabel = new JLabel(DefaultLanguageList.get(1));
        setLayout(null);
        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(1366, 768));
        this.setPreferredSize(new Dimension(1366, 768));
        this.setLocation(new Point(this.getX()-this.getWidth()/2,this.getY()-this.getHeight()/2));
        this.setContentPane(new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/" + "CRM Unit_Screen_1.jpg")).getImage().getScaledInstance(1366, 768, Image.SCALE_SMOOTH))));
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                ChangeLanguageLabel.setLocation(new Point(
                        e.getComponent().getWidth() / 10 -
                        ChangeLanguageLabel.getWidth() / 2, 610));
                for(int i = 0; i<8; i++) {
                    Button_LNG_List.get(i).setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/" + (i + 1) + ".jpg")).getImage().getScaledInstance(
                            (int) Button_LNG_List.get(i).getSize().getWidth(),
                            (int) Button_LNG_List.get(i).getSize().getHeight(),
                            Image.SCALE_SMOOTH)));
                    //       Button_LNG_List.get(i).setSize(new Dimension(Button_LNG_List.get(i).getPreferredSize()));
                }
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

        mainLabel.setFont(new Font(null, Font.ROMAN_BASELINE, 40));
        mainLabel.setSize(mainLabel.getPreferredSize());
        mainLabel.setLocation(new Point(
                (int)this.getSize().getWidth()/2-
                (int)mainLabel.getSize().getWidth()/2,
                (int)this.getSize().getHeight()/4));

        ChangeLanguageLabel.setFont(new Font(null, Font.BOLD, 16));
        ChangeLanguageLabel.setSize(ChangeLanguageLabel.getPreferredSize());
        ChangeLanguageLabel.setLocation(new Point(
                this.getWidth() / 2 -
                ChangeLanguageLabel.getWidth() / 2, 5));


        for(int i = 0, j=0; i<8; i++, j++) {
            Button_LNG_List.add(setDefaultButtonSettings(i));
            Button_LNG_List.get(i).setLocation(new Point(70 * (i + j + 2), 650));
            ButtonsNames.add(getLabel(i));
            ButtonsNames.get(i).setLocation(new Point(
                    (int)Button_LNG_List.get(i).getLocation().getX()+
                    (int)Button_LNG_List.get(i).getSize().getWidth()/2-
                    ButtonsNames.get(i).getSize().width/2,Button_LNG_List.get(i).getY()+
                    (int)Button_LNG_List.get(i).getSize().getHeight()+5));
            this.getContentPane().add(Button_LNG_List.get(i));
            this.getContentPane().add(ButtonsNames.get(i));
        }
        this.pack();
        this.setVisible(true);

        this.getContentPane().add(mainLabel);
        this.getContentPane().add(ChangeLanguageLabel);
    }

    private JButton setDefaultButtonSettings(final int IndLanguage){
        JButton settingsButton = new JButton("");
        settingsButton.setSize(new Dimension(54,45));
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame2_QuestionnairePage(IndLanguage,
                        (int)LinkMainFrame.getSize().getWidth(),
                        (int)LinkMainFrame.getSize().getHeight(),
                        (int)LinkMainFrame.getLocation().getX(),
                        (int)LinkMainFrame.getLocation().getY());
                LinkMainFrame.setVisible(false);
            }
        });
        return settingsButton;
    }

    private JLabel getLabel(final int IndLanguage){
        JLabel label = new JLabel();
        switch (IndLanguage){
            case 0:label.setText("ENGLISH");break;
            case 1:label.setText("עברית");break;
            case 2:label.setText("DEUTSCH");break;
            case 3:label.setText("FRANÇAIS");break;
            case 4:label.setText("ITALIANO");break;
            case 5:label.setText("ESPAÑOL");break;
            case 6:label.setText("РУССКИЙ");break;
            case 7:label.setText("中文");break;
        }
        label.setSize(label.getPreferredSize());
        return label;
    }

    private int getLanguageID(String DefLanguage){
        if(DefLanguage.equals("English"))
            return 0;
        else if(DefLanguage.equals("עברית"))
            return 1;
        else if(DefLanguage.equals("German"))
            return 2;
        else if(DefLanguage.equals("French"))
            return 3;
        else if(DefLanguage.equals("Italian"))
            return 4;
        else if(DefLanguage.equals("Spanish"))
            return 5;
        else if(DefLanguage.equals("Russian"))
            return 6;
        else if(DefLanguage.equals("Chinese"))
            return 7;
        return 0;
    }
}
