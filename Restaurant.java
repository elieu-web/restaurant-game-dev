import java.awt.Color;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Restaurant{
    private JFrame frame = new JFrame("Restaurant");
    private JPanel panel;
    private JLabel label;
    public static void main(String[] args) {
		new Restaurant().start();
	}

    public void start(){
        try {
            System.out.println("WORKS!");
        } catch (Exception e) {
            System.out.println("ERROR!!!");
        }
        panel = new JPanel();
        label = new JLabel("Welcome!!!");
        panel.add(label);
        panel.setBackground(Color.GRAY);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}