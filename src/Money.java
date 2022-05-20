package src;
import javax.swing.ImageIcon;
import javax.swing.*;

public abstract class Money {
    private int points; 
    private double cost;

    public Money() {
        cost = 0.0;
    }

    public Money (double val) {
        cost = val;
    }

    public double getCost() {
        return cost;
    }
    
    public void roundUp(double amount){

        int option1 = ((int)Math.random() * 11) + (int)amount;
        int option2 = ((int)Math.random() * 11) + (int)amount;
        int option3 = ((int)amount) + 1;

        JButton button = new JButton(Integer.toString(option1));
        JButton button2 = new JButton(Integer.toString(option2));
        JButton button3 = new JButton(Integer.toString(option3));

        // System.out.print(option1);
        // System.out.print(option2);
        // System.out.print(option3);
        // System.out.print(option3 + " is the correct answer!");
    }

    public void selection() {
        //if (user selects button) {
            points += 100;

        // while (user selects button2 || button3) {
        //     System.out.println ("try again"); 
        //     if (user selects option 3) {
        //         points += 50; 
        //     }
        // }
    
        if (points == 200) {
            ImageIcon winMeme = new ImageIcon ("WinMeme.png");
            points -= 200; 
        }
    }

    public static double randomPrice() {
        return 14.34;
    }
}
