package src;
import javax.swing.*;
import java.awt.Dimension;
import javax.swing.ImageIcon; 
import javax.swing.JButton;
import javax.swing.JPanel;  
import java.awt.GridBagLayout;
import java.awt.event.*;


public class Money {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;
    private int points; 
    private double cost;
    private int tryNumber = 0;
    private static JFrame f;
    private static JPanel p;

    public Money() {
        cost = 0.0;
    }

    public Money(double val) {
        cost = val;
    }

    public double getCost() {
        return cost;
    }

    public JPanel chooseOptions() {
        f = new JFrame("Money Game");
        p = new JPanel(new GridBagLayout());

        int option1 = ((int)Math.random() * 11) + (int)cost;
        int option2 = ((int)Math.random() * 11) + (int)cost;
        int option3 = ((int)cost) + 1;

        JButton button = new JButton(Integer.toString(option1));
        button.setActionCommand("button1");
        JButton button2 = new JButton(Integer.toString(option2));
        button2.setActionCommand("button2");
        JButton button3 = new JButton(Integer.toString(option3));
        button3.setActionCommand("button3");
        button.addActionListener(new Selection());
        button2.addActionListener(new Selection());
        button3.addActionListener(new Selection());

        p.add(button);
        p.add(button2);
        p.add(button3);
        p.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        f.setSize(200, 200);
        f.setVisible(true);
        f.add(p);
        f.setLocationRelativeTo(null);
        f.pack(); 
        return p;
    }

    public class Selection implements ActionListener {
        public void actionPerformed(ActionEvent e){
            tryNumber += 1;
            if (tryNumber == 1 && e.getActionCommand().equals("button3")) {
                points += 100;
            } else if (e.getActionCommand().equals("button3")) {
                points += 50;
            } else {
                System.out.println ("try again"); 
            }

            if (points >= 200) {
                ImageIcon winMeme = new ImageIcon ("WinMeme.png");
                points -= 200;
                // maybe set new correct option / cost here
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

    public static void payMoney() {

        // JLabel picLabel = new JLabel(new ImageIcon("__"));

        // JButton button = new JButton(resizeImage("images/ten-dollar.png", 100, 100));
        // button.setPreferredSize(new DimensionUIResource(100, 100));
        // JButton button1 = new JButton(resizeImage("images/five-dollar.png", 100, 100));
        // button1.setPreferredSize(new DimensionUIResource(100, 100));
        // JButton button2 = new JButton(resizeImage("images/yellow_bellpepper.jpeg", 100, 100));
        // button2.setPreferredSize(new DimensionUIResource(100, 100));
        // JButton button3 = new JButton(resizeImage("images/brocoli.png", 100, 100));
        // button3.setPreferredSize(new DimensionUIResource(100, 100));

    }

    //add next button 
}
