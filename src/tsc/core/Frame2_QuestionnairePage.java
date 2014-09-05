package tsc.core;

import com.scc.calendar.datepicker.DatePicker;
import tsc.Functions.Language;
import tsc.Net.Connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 * Created by Noctis on 23.07.14.
 */
public class Frame2_QuestionnairePage extends JFrame {

    private Connect connection = new Connect();

    private JFrame LinkThisForm;
    private int CHANGE_LANGUAGE = 0;
    private JLabel MainLabel;
    private JLabel FirstN_LB;
    private JLabel LastN_LB;
    private JLabel Email_First_LB;
    private JLabel jlDog = new JLabel("@");
    private JLabel Address_LB;
    private JLabel City_LB;
    private JLabel State_LB;
    private JLabel Country_LB;
    private JLabel DateOfBirth_LB;
    private JLabel Phone_LB;
    private JLabel requriedFlds;
    private JTextField FirstN_TF = new JTextField(15);
    private JTextField LastN_TF = new JTextField(15);
    private JTextField Email_First_TF = new JTextField();
    private JTextField Email_Last_TF = new JTextField();
    private JTextField Address_TF = new JTextField();
    private JTextField City_TF = new JTextField();
    private JTextField State_TF = new JTextField();
    private JTextField Country_TF = new JTextField();
    private ObservingTextField  DateOfBirth_TF = new ObservingTextField ();
    private JTextField Phone_TF = new JTextField();
    private JPanel QuestionnairePage_Panel;
    private Font TextFont = new Font(null, Font.BOLD, 16);
    private final Locale locale = getLocale(null);

    private JCheckBox Agree_CB;
//    private GridLayout Frame1Layout = new GridLayout(9,2,2,2); //Лучше юзать GridBagLayout http://skipy.ru/technics/layouts.html#grid_bag
    private JButton Submit_Button;

    public Frame2_QuestionnairePage(int chLang, int formW, int formH, int x, int y){
        LinkThisForm = this;
        this.CHANGE_LANGUAGE = chLang;
        initFrameComponents(formW,formH, x, y, new Language(chLang).getLanguage());
    }

    private void initFrameComponents(final int formW,final int formH,final int x,final int y, final List<String> LanguageList){

        MainLabel = new JLabel(LanguageList.get(2),JLabel.CENTER);
        Address_LB = new JLabel(LanguageList.get(6));
        FirstN_LB = new JLabel(LanguageList.get(3));
        LastN_LB = new JLabel(LanguageList.get(4));
        Email_First_LB = new JLabel(LanguageList.get(5));
        City_LB = new JLabel(LanguageList.get(7));
        State_LB = new JLabel(LanguageList.get(8));
        Country_LB = new JLabel(LanguageList.get(9));
        DateOfBirth_LB = new JLabel(LanguageList.get(10));
        Phone_LB = new JLabel(LanguageList.get(11));
        Agree_CB = new JCheckBox(LanguageList.get(12));
        Submit_Button = new JButton(LanguageList.get(13));
        requriedFlds = new JLabel(LanguageList.get(14));
        QuestionnairePage_Panel = new JPanel_With_Background(new ImageIcon(new ImageIcon(getClass().getResource("/" + "CRM Unit_Screen_2.jpg")).getImage().getScaledInstance(1366, 768, Image.SCALE_SMOOTH)).getImage());

        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(formW,formH));
        this.setPreferredSize(new Dimension(formW, formH));
        this.setLocation(new Point(x,y));

        MainLabel.setFont(new Font(null, Font.BOLD, 28));
        MainLabel.setSize(MainLabel.getPreferredSize());

        FirstN_LB.setFont(TextFont);
        FirstN_LB.setSize(FirstN_LB.getPreferredSize());
        FirstN_LB.setLocation(new Point(120, (int) this.getSize().getHeight() / 5));
        FirstN_TF.setFont(TextFont);
        FirstN_TF.setSize(new Dimension((int) this.getSize().getWidth() / 3, 30));
        FirstN_TF.setLocation(new Point(120,
                (int) FirstN_LB.getLocation().getY() +
                        (int) FirstN_LB.getSize().getHeight() + 5));
        LastN_LB.setFont(TextFont);
        LastN_LB.setSize(LastN_LB.getPreferredSize());
        LastN_LB.setLocation(new Point(
                (int) this.getSize().getWidth() / 2 + 10,
                (int) FirstN_LB.getLocation().getY()));
        LastN_TF.setFont(TextFont);
        LastN_TF.setSize(new Dimension((int) this.getSize().getWidth() / 3, 30));
        LastN_TF.setLocation(new Point(
                (int) this.getSize().getWidth() / 2 + 10,
                (int) LastN_LB.getLocation().getY() +
                (int) LastN_LB.getSize().getHeight() + 5));
        Email_First_LB.setFont(TextFont);
        Email_First_LB.setSize(Email_First_LB.getPreferredSize());
        Email_First_LB.setLocation(new Point(
                (int) FirstN_TF.getLocation().getX(),
                (int) FirstN_TF.getLocation().getY() +
                        (int) FirstN_TF.getSize().getHeight() + 10));
        Email_First_TF.setFont(TextFont);
        Email_First_TF.setSize(new Dimension((int) this.getSize().getWidth() / 3, 30));
        Email_First_TF.setLocation(new Point(
                (int)Email_First_LB.getLocation().getX(),
                (int)Email_First_LB.getLocation().getY()+
                (int)Email_First_LB.getSize().getHeight()+5));
        Email_Last_TF.setFont(TextFont);
        Email_Last_TF.setSize(new Dimension((int) this.getSize().getWidth() / 3, 30));
        Email_Last_TF.setLocation(new Point(
                (int) LastN_TF.getLocation().getX(),
                (int) Email_First_LB.getLocation().getY()+
                (int) Email_First_LB.getSize().getHeight()+5));
        jlDog.setFont(TextFont);
        jlDog.setSize(jlDog.getPreferredSize());
        jlDog.setLocation(new Point(
                (int)Email_First_TF.getLocation().getX()+
                (int)Email_First_TF.getSize().getWidth() +
                (int)(Email_Last_TF.getLocation().getX()-
                (Email_First_TF.getLocation().getX()+(int)Email_First_TF.getSize().getWidth()))/2-
                (int)jlDog.getSize().getWidth()/2
                ,
                (int) Email_First_TF.getLocation().getY()));
        Address_LB.setFont(TextFont);
        Address_LB.setSize(Address_LB.getPreferredSize());
        Address_LB.setLocation(new Point(
                (int) Email_First_TF.getLocation().getX(),
                (int) Email_First_TF.getLocation().getY() +
                (int) Email_First_TF.getSize().getHeight() + 10));
        Address_TF.setFont(TextFont);
        Address_TF.setSize(new Dimension((int) this.getSize().getWidth() / 3, 30));
        Address_TF.setLocation(
                (int)Address_LB.getLocation().getX(),
                (int)Address_LB.getLocation().getY()+
                (int)Address_LB.getSize().getHeight()+5);
        City_LB.setFont(TextFont);
        City_LB.setSize(City_LB.getPreferredSize());
        City_LB.setLocation(
                (int) Address_TF.getLocation().getX(),
                (int) Address_TF.getLocation().getY() +
                (int) Address_TF.getSize().getHeight() + 10);
        City_TF.setFont(TextFont);
        City_TF.setSize(new Dimension((int) this.getSize().getWidth() / 4, 30));
        City_TF.setLocation(
                (int)City_LB.getLocation().getX(),
                (int)City_LB.getLocation().getY()+
                (int)City_LB.getSize().getHeight()+5);
        State_LB.setFont(TextFont);
        State_LB.setSize(State_LB.getPreferredSize());
        State_LB.setLocation(
                (int)City_LB.getLocation().getX()+
                (int)City_TF.getSize().getWidth()+70,
                (int)City_LB.getLocation().getY());
        State_TF.setFont(TextFont);
        State_TF.setSize(new Dimension((int) this.getSize().getWidth() / 5, 30));
        State_TF.setLocation(
                (int)State_LB.getLocation().getX(),
                (int)State_LB.getLocation().getY()+
                (int)State_LB.getSize().getHeight()+5);
        Country_LB.setFont(TextFont);
        Country_LB.setSize(Country_LB.getPreferredSize());
        Country_LB.setLocation(
                (int)State_LB.getLocation().getX()+
                (int)State_TF.getSize().getWidth()+70,
                (int)State_LB.getLocation().getY());
        Country_TF.setFont(TextFont);
        Country_TF.setSize(new Dimension((int) this.getSize().getWidth() / 5, 30));
        Country_TF.setLocation(
                (int)Country_LB.getLocation().getX(),
                (int)Country_LB.getLocation().getY()+
                (int)Country_LB.getSize().getHeight()+5);
        DateOfBirth_LB.setFont(TextFont);
        DateOfBirth_LB.setSize(DateOfBirth_LB.getPreferredSize());
        DateOfBirth_LB.setLocation(
                (int) City_TF.getLocation().getX(),
                (int) City_TF.getLocation().getY() +
                (int) City_TF.getSize().getHeight() + 10);
        DateOfBirth_TF.setFont(TextFont);
        DateOfBirth_TF.setEditable(false);
        DateOfBirth_TF.setSize(new Dimension((int) this.getSize().getWidth() / 5, 30));
        DateOfBirth_TF.setLocation(
                (int)DateOfBirth_LB.getLocation().getX(),
                (int)DateOfBirth_LB.getLocation().getY()+
                (int)DateOfBirth_LB.getSize().getHeight()+5);
        DateOfBirth_TF.setColumns(20);
        DateOfBirth_TF.setBackground(Color.white);
        DateOfBirth_TF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        DateOfBirth_TF.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // instantiate the DatePicker
                DatePicker dp = new DatePicker(LinkThisForm, DateOfBirth_TF, locale);
                // previously selected date
                Date selectedDate = dp.parseDate(DateOfBirth_TF.getText());
                dp.setSelectedDate(selectedDate);
                dp.start(null);
            }
        });
        Phone_LB.setFont(TextFont);
        Phone_LB.setSize(Phone_LB.getPreferredSize());
        Phone_LB.setLocation(
                (int) State_TF.getLocation().getX(),
                (int) State_TF.getLocation().getY() +
                (int) State_TF.getSize().getHeight() + 10);
        Phone_TF.setFont(TextFont);
        Phone_TF.setSize(new Dimension((int) this.getSize().getWidth() / 5, 30));
        Phone_TF.setLocation(
                (int)Phone_LB.getLocation().getX(),
                (int)Phone_LB.getLocation().getY()+
                (int)Phone_LB.getSize().getHeight()+5);
        requriedFlds.setFont(new Font(null, Font.BOLD, 16));
        requriedFlds.setSize(requriedFlds.getPreferredSize());


        QuestionnairePage_Panel.setLayout(null);
        QuestionnairePage_Panel.setSize(new Dimension(this.getWidth(), this.getHeight()));
        QuestionnairePage_Panel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
        QuestionnairePage_Panel.setLocation(new Point(0, 0));

        Agree_CB.setFont(new Font(null, Font.BOLD, 24));
        Agree_CB.setSize(Agree_CB.getPreferredSize());
        Agree_CB.setLocation(new Point(
                (int) DateOfBirth_TF.getLocation().getX(),
                (int) DateOfBirth_TF.getLocation().getY() +
                        (int) DateOfBirth_TF.getSize().getHeight() + 10));
        Agree_CB.setSelected(true);
        requriedFlds.setLocation(
                (int) Country_TF.getLocation().getX() +
                        (int) (Country_TF.getSize().getWidth() - requriedFlds.getSize().getWidth()),
                (int) Agree_CB.getLocation().getY());
        Submit_Button.setFont(new Font(null, Font.BOLD, 24));
        Submit_Button.setForeground(Color.WHITE);
        Submit_Button.setSize(
                (int) requriedFlds.getLocation().getX() +
                        (int) requriedFlds.getSize().getWidth(),
                (int) DateOfBirth_TF.getSize().getHeight() * 2);
        Submit_Button.setLocation(new Point(
                (int) Agree_CB.getLocation().getX(),
                (int) Agree_CB.getLocation().getY() +
                        (int) Agree_CB.getSize().getHeight() + 10));
        Submit_Button.setBackground(new Color(52,180,227));
        Submit_Button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckFields()) {
                    if (connection.sendData(connection.getPacket(FirstN_TF.getText(), LastN_TF.getText(), Email_First_TF.getText(), Address_TF.getText(),
                            City_TF.getText(),State_TF.getText(), Country_TF.getText(), DateOfBirth_TF.getText(), Phone_TF.getText(),
                            Agree_CB.isSelected(), getLanguage(CHANGE_LANGUAGE)))) {
                        new Frame3_LastPage(formW, formH, x, y, LanguageList);
                        LinkThisForm.setVisible(false);
                    } else
                        JOptionPane.showMessageDialog(null, "Server is temporarily unavailable");
                }else{
                    JOptionPane.showMessageDialog(null, "Please fill out all fields.");
                }
            }
        });

        FirstN_TF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                FirstN_TF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        LastN_TF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                LastN_TF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        Email_First_TF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                Email_First_TF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        City_TF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                City_TF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        State_TF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                State_TF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        Country_TF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                Country_TF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        DateOfBirth_TF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                DateOfBirth_TF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        Phone_TF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                Phone_TF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        QuestionnairePage_Panel.add(FirstN_LB);
        QuestionnairePage_Panel.add(FirstN_TF);
        QuestionnairePage_Panel.add(LastN_LB);
        QuestionnairePage_Panel.add(LastN_TF);
        QuestionnairePage_Panel.add(Email_First_LB);
        QuestionnairePage_Panel.add(Email_First_TF);
        QuestionnairePage_Panel.add(jlDog);
        QuestionnairePage_Panel.add(Email_Last_TF);
        QuestionnairePage_Panel.add(Address_LB);
        QuestionnairePage_Panel.add(Address_TF);
        QuestionnairePage_Panel.add(City_LB);
        QuestionnairePage_Panel.add(City_TF);
        QuestionnairePage_Panel.add(State_LB);
        QuestionnairePage_Panel.add(State_TF);
        QuestionnairePage_Panel.add(Country_LB);
        QuestionnairePage_Panel.add(Country_TF);
        QuestionnairePage_Panel.add(DateOfBirth_LB);
        QuestionnairePage_Panel.add(DateOfBirth_TF);
        QuestionnairePage_Panel.add(Phone_LB);
        QuestionnairePage_Panel.add(Phone_TF);
        QuestionnairePage_Panel.add(MainLabel);
        QuestionnairePage_Panel.add(Agree_CB);
        QuestionnairePage_Panel.add(Submit_Button);
        QuestionnairePage_Panel.add(requriedFlds);

        this.pack();
        this.setVisible(true);


        this.getContentPane().add(QuestionnairePage_Panel);
    }

    private String getLanguage(int intLang){
        switch (intLang){
            case 0:return "English";
            case 1:return "עברית";
            case 2:return "GERMAN";
            case 3:return "FRENCH";
            case 4:return "ITALIAN";
            case 5:return "SPANISH";
            case 6:return "RUSSIAN";
            case 7:return "CHINEESE";
        }
        return "English";
    }

    private boolean CheckFields(){
        boolean swch = true;
        if(FirstN_TF.getText().length()<1) {
            swch = false;
            FirstN_TF.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        if(LastN_TF.getText().length()<1) {
            swch = false;
            LastN_TF.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        if(Email_First_TF.getText().length()<5) {
            swch = false;
            Email_First_TF.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        if(City_TF.getText().length()<2) {
            swch = false;
            City_TF.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        if(State_TF.getText().length()<2) {
            swch = false;
            State_TF.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        if(Country_TF .getText().length()<2) {
            swch = false;
            Country_TF.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        if(DateOfBirth_TF.getText().length()<4) {
            swch = false;
            DateOfBirth_TF.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        if(Phone_TF.getText().length()<4) {
            swch = false;
            Phone_TF.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        return swch;
    }
    private static Locale getLocale(String loc) {
        if (loc != null && loc.length() > 0)
            return new Locale(loc);
        else
            return Locale.US;
    }

    class ObservingTextField extends JTextField implements Observer {
        private static final long serialVersionUID = -9121215994812342536L;

        public void update(Observable o, Object arg) {
            DatePicker dp = (DatePicker) o;
            Calendar calendar = (Calendar) arg;
            setText(dp.formatDate(calendar));
        }
    }
}

 class JPanel_With_Background extends JPanel{

     private Image img;

     public JPanel_With_Background(String img) {
         this(new ImageIcon(img).getImage());
     }

     public JPanel_With_Background(Image img) {
         this.img = img;
         Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
         setPreferredSize(size);
         setMinimumSize(size);
         setMaximumSize(size);
         setSize(size);
         setLayout(null);
     }

     public void paintComponent(Graphics g) {
         g.drawImage(img, 0, 0, null);
     }
}
