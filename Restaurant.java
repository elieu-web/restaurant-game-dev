import java.awt.Color;
import java.awt.Dimension;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Restaurant{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;
    private JFrame frame;
    private JPanel panel;
    public static void main(String[] args) {
		new Restaurant().start();
	}

    public void start(){
        try {
            System.out.println("WORKS!");
        } catch (Exception e) {
            System.out.println("ERROR!!!");
        }
        frame = new JFrame("Restaurant Game");
        panel = new JPanel();
        JTextField text = new JTextField("Welcome! Type how many pizzas: ");
        JButton button = new JButton("WELCOME");
        button.addActionListener(new MyActionListener());
        panel.add(button);
        panel.add(text);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        panel.setBackground(Color.GRAY);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setSize(300, 400);
        frame.setVisible(true);
		frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.pack();
    }

    public class MyActionListener implements ActionListener{
        public void ActionPerformed(ActionEvent e) {
            JFrame f = new JFrame();
            f.setVisible(true);
            f.setBackground(Color.green);
            f.setSize(200, 200);
        }    
    }
   
}