package src;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.GridBagLayout;


public class Money extends RestaurantGamePaint{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;
    private static JFrame f;
    private static JTextField text;
    private static JLabel questionLabel;
    private static JPanel activePanel;
    private double db;

    public Money (double db2) {
        db = db2;
    }

    public Money () {
        db = 0.00;
    }

    public static JPanel makeOptionPanel(double cost) {
        JPanel p = new JPanel(new GridBagLayout());
        int option1 = (int)cost + (int) (Math.random() * 5);
        int option2 = (int)cost - (int) (Math.random() * 5);
        int option3 = ((int)cost) + 1; //fix

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

        return p;
    }

    private static JPanel makeQuestionPanel() {
        JPanel p = new JPanel(new GridBagLayout());
        questionLabel = new JLabel("Welcome! Type how many pizzas: ");
        text = new JTextField("",2);
        text.addKeyListener(new Money().new MyKeyListener());
        p.add(questionLabel);
        p.add(text);
        p.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        return p;
    }

    private static JPanel makeButtons() {
        JPanel p = new JPanel(new GridBagLayout());
        JButton button = new JButton("NEXT");
        JButton b2 = new JButton("PREVIOUS");
        JButton b3 = new JButton("HOME");
        b2.addActionListener(new Money().new QuestionPanel());
        // b3.addActionListener(new HomePanel());
        p.add(b2);
        //button.addActionListener(new RestaurantGamePaint.PizzaPanel());
        p.add(b3);
        p.add(button);

        return p;
    }

    // private static void swapPanels(JPanel newPanel) {
    //     f.getContentPane().removeAll(); //remove all panels on frame instead of components on panel such as jlabel 
    //     f.add(newPanel);
    //     f.validate();
    //     f.repaint();
    // }

    public static Component chooseOptions() {
        JPanel p = new JPanel(); 
        activePanel = makeQuestionPanel();
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

    public class Selection implements ActionListener {
        public void actionPerformed(ActionEvent e){
            // tryNumber += 1;
            // if (tryNumber == 1 && e.getActionCommand().equals("button3")) {
            //     points += 100;
            //     System.out.println("correct!");
            // } else if (e.getActionCommand().equals("button3")) {
            //     points += 50;
            // } else {
            //     System.out.println ("try again"); 
            // }

            // if (points >= 200) {
            if (e.getActionCommand().equals("button3")) {
                ImageIcon winMeme = Pizza.resizeImage("images/WinMeme.png", 200, 200);
                JLabel winLabel = new JLabel(winMeme);
                // points -= 200;
                JFrame newFrame = new JFrame("Money Game");
                activePanel = makeQuestionPanel();
                GridLayout gl = new GridLayout(1,0);
                newFrame.setLayout(gl);
                // JPanel winPanel = Pizza.createOverlayPanel(winLabel);
                // winPanel.add(winLabel);
                newFrame.setSize(200, 200);
                newFrame.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
                newFrame.setVisible(true);
                newFrame.setLocationRelativeTo(null);
                newFrame.pack(); 
            } else {
                //add
            }


            // JButton button = new JButton(resizeImage("_____ ", 50, 50));
            // button.setPreferredSize(new DimensionUIResource(50, 50));
            // JLabel button2 = new JLabel(resizeImage(" ", 50, 50));
            // button2.setPreferredSize(new DimensionUIResource(50, 50));
            // JLabel button3 = new JLabel(resizeImage(" ", 50, 50));
            // button3.setPreferredSize(new DimensionUIResource(50, 50));
            // //  Setting location
            // button.setLocation(100, 100);
            // button2.setLocation(150, 200);
            // button3.setLocation(200, 300);
            // p.add(button);
            // p.add(button2);
            // p.add(button3);
            // p.revalidate();
            // p.repaint();
            


        }
    }

    public class MyKeyListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()== KeyEvent.VK_ENTER) {
                String s = text.getText();
                try {
                    Double i = Double.parseDouble(s);
                    questionLabel = new JLabel("Dollar up the price of " + Calculator.getPrice(i),SwingConstants.CENTER);
                    JPanel questionPanel = new JPanel();
                    questionPanel.add(questionLabel);
                    activePanel = makeOptionPanel(i * 15.25);

                    f.getContentPane().removeAll();
                    f.add(questionPanel);
                    f.add(activePanel);
                    f.add(makeButtons());
                    f.validate();
                    f.repaint();
                } catch (NumberFormatException n) {
                    questionLabel = new JLabel("Sorry, that's not a number! Please go back and try again.", SwingConstants.CENTER);
                    activePanel.revalidate();
                    activePanel.repaint();
                    f.repaint();
                }
            }
        }

        public void keyTyped(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
        }
    }

    public class QuestionPanel implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "No questions found to go back to", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // public class ClickDollar implements ActionListener {
    //     public void actionPerformed(ActionEvent e){
    //         JLabel oneDollar = new JLabel(resizeImage("images/one-dollar.png", 50, 50));
    //         oneDollar.setPreferredSize(new DimensionUIResource(50, 50));
           
    //         //  Setting location
    //         oneDollar.setLocation(100, 100);
    //         oneDollar.setLocation(150, 200);
    //         p.add(oneDollar);
    //         p.revalidate();
    //         p.repaint();
    //     }
    // }

    // public class ClickTen impelements ActionListener {
    //     public void actionPerformed(ActionEvent e){
    //         JLabel tenDollar = new JLabel(resizeImage("images/ten-dollar.png", 50, 50));
    //         tenDollar.setPreferredSize(new DimensionUIResource(50, 50));
    //         //  Setting location
    //         tomatoLabel1.setLocation(100, 100);
    //         tomatoLabel2.setLocation(150, 200);
    //         p.add(tenDollar);
    //         p.revalidate();
    //         p.repaint();
    //     }
    // }

    // public static void payMoney() {

    //     JLabel picLabel = new JLabel(new ImageIcon("__"));

    //     JButton tenDollar = new JButton(resizeImage("images/ten-dollar.png", 100, 100));
    //     button.setPreferredSize(new DimensionUIResource(100, 100));

    //     JButton fiveDollar = new JButton(resizeImage("images/five-dollar.png", 100, 100));
    //     button1.setPreferredSize(new DimensionUIResource(100, 100));

    //     JButton oneDollar = new JButton(resizeImage("images/one-dollar.png", 100, 100));
    //     button2.setPreferredSize(new DimensionUIResource(100, 100));

    //     JButton quarter = new JButton(resizeImage("images/quarter.jpg", 100, 100));
    //     button3.setPreferredSize(new DimensionUIResource(100, 100));

    //     Jbutton dime = new JButton(resizeImage("images/dime.jpg," 100, 100));
    //     button4.setPreferredSize(new DimensionUIResource(100, 100)); 

    //     p.add(button);
    //     p.add(button1);
    //     p.add(button2);
    //     p.add(button3);
    //     p.add(button4);

    // }

    //add next button 
}
