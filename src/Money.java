package src;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.GridBagLayout;


public class Money extends RestaurantGamePaint {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 600;
    private static JFrame frame = new JFrame();
    //private static JTextField text;
    private static JLabel questionLabel;
    private static JPanel activePanel;
    // private double db;

    private static double cost = (int)((Math.random() * 900) + 100) / 100.0; 


    // public Money () {
    //     db = 0.00;
    // }

    public static JPanel makeOptionsPanel() {
        System.out.println("OPTIONS");
        JPanel p = new JPanel(new GridBagLayout());
        int option1 = (int)cost + (int) (Math.random() * 5);
        int option2 = (int)cost - (int) (Math.random() * 5);
        int option3 = ((int)cost) + 1 ; //fix

        if (option3 == option1) {
            option1 = (int)cost + (int) (Math.random() * 6);
        }

        questionLabel = new JLabel("Dollar up the price of $" + cost);
        p.add(questionLabel); 
        //p.set(questionLabel);


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
        p.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // activePanel = p;
        return p;
    }

    private static JPanel makeIntroPanel() {
        JPanel p = new JPanel(new GridBagLayout());
        //questionLabel = new JLabel("Welcome! Type how many pizzas: ");
        //JLabel label = new JLabel("Welcome! This is your number: " + (int) ((Math.random() * 900) + 100) / 100.0);
        JLabel label = new JLabel("Welcome! This is your number: " + cost);
        p.add(label);

        JButton button = new JButton("NEXT");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JPanel p = makeOptionsPanel();
                setNewPanel(p);
            }
        });
        p.add(button);
        p.setPreferredSize(new Dimension(WIDTH, HEIGHT));

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
        JPanel p = new JPanel(); 
        activePanel = makeIntroPanel();
        GridLayout gl = new GridLayout(3,0);
        p.setLayout(gl);
        p.add(activePanel);
        p.setSize(200, 200);
        p.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
        // p.setVisible(true);
        // p.setLocationRelativeTo(null);
        // p.pack(); 
        return p;
    }

    //new 
    // private static JPanel makeMoneyPanel() {
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

    private static void setNewPanel(JPanel p) {
        activePanel = p;
        GridLayout gl = new GridLayout(3,0);
        frame.setLayout(gl);
        frame.add(activePanel);
        frame.setSize(200, 200);
        frame.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.pack();
    }

    public static void openIntro() {
        JPanel p = makeIntroPanel();
        setNewPanel(p);
    }


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
                setNewPanel(winPanel);
                // newFrame.setSize(200, 200);
                // newFrame.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
                // newFrame.setVisible(true);
                // newFrame.setLocationRelativeTo(null);
                // newFrame.pack(); 
            } else {
                //add
            }



        }
    }

    // public class MyKeyListener implements KeyListener {
    //     public void keyPressed(KeyEvent e) {
    //         if (e.getKeyCode()== KeyEvent.VK_ENTER) {
    //             String s = text.getText();
    //             try {
    //                 Double i = Double.parseDouble(s);
    //                 //questionLabel = new JLabel("Dollar up the price of " + Calculator.getPrice(i),SwingConstants.CENTER);
    //                 questionLabel = new JLabel("Dollar up the price of " + cost);

    //                 JPanel questionPanel = new JPanel();
    //                 questionPanel.add(questionLabel);
    //                 activePanel = Money.makeOptionPanel();

    //                 f.getContentPane().removeAll();
    //                 f.add(questionPanel);
    //                 f.add(activePanel);
    //                 f.add(makeButtons());
    //                 f.validate();
    //                 f.repaint();
    //             } catch (NumberFormatException n) {
    //                 questionLabel = new JLabel("Sorry, that's not a number! Please go back and try again.", SwingConstants.CENTER);
    //                 activePanel.revalidate();
    //                 activePanel.repaint();
    //                 f.repaint();
    //             }
    //         }
    //     }

        // public void keyTyped(KeyEvent e) {
        // }

        // public void keyReleased(KeyEvent e) {
        // }
    // }

    public class QuestionPanel implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "No questions found to go back to", "error", JOptionPane.ERROR_MESSAGE);
        }
    }


    
}
