import java.awt.Color;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Restaurant{
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
        JLabel label = new JLabel("Welcome!!!");
        JButton button = new JButton("WELCOME");
        panel.add(label);
        panel.add(button);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        panel.setBackground(Color.GRAY);
        frame.setSize(300, 400);
        panel.setSize(300, 400);
        frame.setVisible(true);
		frame.add(panel);
        //frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.pack();
    }
}