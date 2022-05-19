import java.util.*;

import javax.swing.JOptionPane; //imports
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.swingImageIcon; 

import javax.swing.JPanel;  


public abstract class Money {

    // JFrame f = new JFrame(); //creates jframe f

    // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //this is your screen size

    // f.setUndecorated(true); //removes the surrounding border

    // ImageIcon image = new ImageIcon("IMAGEURL.jpg"); //imports the image

    // JLabel lbl = new JLabel(image); //puts the image into a jlabel

    // f.getContentPane().add(lbl); //puts label inside the jframe

    // f.setSize(image.getIconWidth(), image.getIconHeight()); //gets h and w of image and sets jframe to the size

    // int x = (screenSize.width - f.getSize().width)/2; //These two lines are the dimensions
    // int y = (screenSize.height - f.getSize().height)/2;//of the center of the screen

    // f.setLocation(x, y); //sets the location of the jframe
    // f.setVisible(true); //makes the jframe visible
    


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

        button = new JButton(option1);
        button2 = new JButton(option2);
        button3 = new JButton(option3);

        // System.out.print(option1);
        // System.out.print(option2);
        // System.out.print(option3);
        // System.out.print(option3 + " is the correct answer!");
    }

    public void selection {
        if (user selects button) {
            points += 100;
        } 
        while (user selects button2 || button3) {
            System.out.println ("try again"); 
            if (user selects option 3) {
                points += 50; 
            }
        }
    
        if (points == 200) {
            ImageIcon winMeme = new ImageIcon ("WinMeme.png");
            points -= 200; 
        }
    }

    
}
