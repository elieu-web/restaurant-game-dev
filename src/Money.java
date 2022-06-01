package src;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class Money  {
    private static JLabel questionLabel;
    private static JPanel activePanel;
    private static double cost;  

    public static Component makeOptionsPanel() {
        cost = (int)((Math.random() * 900) + 100) / 100.0;
        GridLayout gl = new GridLayout(4,1);
        GridLayout gl2 = new GridLayout(1,3);
        JPanel p = new JPanel();
        p.setLayout(gl2);
        activePanel = new JPanel();
        activePanel.setLayout(gl);
        int option1 = (int)cost + (int) (Math.random() * 5);
        int option2 = (int)cost - (int) (Math.random() * 5);
        int option3 = ((int)cost) + 1 ; //fix

        if (option3 == option1) {
            option1 = (int)cost + (int) (Math.random() * 6);
        }

        questionLabel = new JLabel("Dollar up the price of $" + cost, SwingConstants.CENTER);
        activePanel.add(questionLabel); 

        JButton button = new JButton(Integer.toString(option1));
        button.setActionCommand("button1");
        JButton button2 = new JButton(Integer.toString(option2));
        button2.setActionCommand("button2");
        JButton button3 = new JButton(Integer.toString(option3));
        button3.setActionCommand("button3");
        button.addActionListener(new Money().new Selection());
        button2.addActionListener(new Money().new Selection());
        button3.addActionListener(new Money().new Selection());

        p.add(button);
        p.add(button2);
        p.add(button3);
        activePanel.add(p);
        activePanel.add(RestaurantGamePaint.makeMoneyHomePanel());
        return activePanel;
    }

    private static JPanel makeIntroPanel() {
        //JTextPane textPane = new JTextPane();
        JPanel p = new JPanel(new GridBagLayout());
        // StyledDocument doc = textPane.getStyledDocument();
        // SimpleAttributeSet center = new SimpleAttributeSet();
        // StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        //doc.setParagraphAttributes(0, doc.getLength(), center, false);
        JTextArea jta = new JTextArea("Welcome to Money Mode! Here, you can practice dollar up by clicking the right answer. Good luck!");
        jta.setFont(RestaurantGamePaint.font);
        jta.setWrapStyleWord(true);
        jta.setLineWrap(true);
        p.add(jta);
        JButton button = new JButton("NEXT");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RestaurantGamePaint.cl.show(RestaurantGamePaint.main,"MONEY CHOICE");
            }
        });
        p.add(button);
        return p;
    }
    
    // private static JPanel makeButtons() {
    //     JPanel p = new JPanel(new GridBagLayout());
    //     JButton button = new JButton("NEXT");
    //     JButton b2 = new JButton("PREVIOUS");
    //     JButton b3 = new JButton("HOME");
    //     b2.addActionListener(new Money().new QuestionPanel());
    //     // b3.addActionListener(new HomePanel());
    //     p.add(b2);
         
    //     p.add(b3);
    //     p.add(button);

    //     return p;
    // }

    public static Component chooseOptions() {
        GridLayout gl = new GridLayout(3,0);
        activePanel = makeIntroPanel();
        activePanel.setLayout(gl);
        activePanel.add(RestaurantGamePaint.makeMoneyHomePanel());
        return activePanel;
    }

    // private static void setNewPanel(JPanel p) {
    //     activePanel = p;
    //     GridLayout gl = new GridLayout(3,0);
    // }

    public class Selection implements ActionListener {
        public void actionPerformed(ActionEvent e){
        
            if (e.getActionCommand().equals("button3")) {
                JPanel winPanel = new JPanel(new GridBagLayout());
                ImageIcon winMeme = Pizza.resizeImage("images/WinMeme.png", 190, 190);
                JLabel winLabel = new JLabel(winMeme);
                // points -= 200;
                // JFrame newFrame = new JFrame("Money Game");
                // activePanel = makeQuestionPanel();
                // GridLayout gl = new GridLayout(1,0);
                // newFrame.setLayout(gl);
                // JPanel winPanel = Pizza.createOverlayPanel(winLabel);
                winPanel.add(winLabel);
                activePanel.add(winPanel);
                activePanel.revalidate();
                activePanel.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "So close! Try again!", "Wrong Answer", JOptionPane.ERROR_MESSAGE);
            }
        }
    }  
    
    private static JPanel makeMoneyPanel() {
    //     JPanel p = new JPanel(new GridBagLayout());
       
    //     JLabel label = new JLabel("Choose the dollar types to make up " + cost);
    //     JButton tenDollar = new JButton(resizeImage("images/ten-dollar.png", 100, 100));

    //     tenDollar.addActionListener(new Money().new QuestionPanel());


    //     //text = new JTextField("",2);
    //     text.addKeyListener(new Money().new MyKeyListener());
    //     p.add(label);
    //     //p.add(text);
    //     p.add(tenDollar); 

    //     p.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    //     return p;
    // }


    // private static void swapPanels(JPanel newPanel) {
    //     f.getContentPane().removeAll(); //remove all panels on frame instead of components on panel such as jlabel 
    //     f.add(newPanel);
    //     f.validate();
    //     f.repaint();
    // }
}
