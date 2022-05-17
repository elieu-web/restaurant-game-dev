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
import javax.swing.plaf.DimensionUIResource;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;


public class Pizza {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    private JFrame f;
    private JPanel p;
    public static void main(String[] args) {
		new Pizza().makePizza();
	}

    public void makePizza(){
        f = new JFrame("Start Making Pizza");
        p = new JPanel();
        JTextField text = new JTextField("Click on the circle toppings to place on the pizza! ");
        JButton button = new JButton(new ImageIcon("images/olives.png"));
        button.setPreferredSize(new DimensionUIResource(100, 100));
        JButton button1 = new JButton(new ImageIcon("images/tomato.png"));
        button1.setPreferredSize(new DimensionUIResource(100, 100));
        JButton button2 = new JButton(new ImageIcon("images/yellow_bellpepper.jpeg"));
        button2.setPreferredSize(new DimensionUIResource(100, 100));
        JButton button3 = new JButton(new ImageIcon("images/brocoli.png"));
        button3.setPreferredSize(new DimensionUIResource(100, 100));
        JLabel picLabel = new JLabel(new ImageIcon("images/pizza.png"));
        p.add(picLabel);
        p.add(button);

        p.add(button1);
        p.add(button2);
        p.add(button3);
        p.add(text);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        p.setBackground(Color.WHITE);
        f.setSize(200, 200);
        f.setVisible(true);
		f.add(p);
        p.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        f.setLocationRelativeTo(null);
        f.pack(); 
        

        // BufferedImage myPicture = ImageIO.read(this.getClass().getResource("images/five-dollar.jpg"));
    }
}
