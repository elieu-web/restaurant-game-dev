package src;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;


public class Pizza {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;
    private static JFrame f;
    private static JPanel p;
   

    public static JPanel createOverlayPanel(JComponent child) {
        JPanel overlayPanel = new JPanel(new GridBagLayout());
        overlayPanel.setOpaque(false);
        overlayPanel.setMaximumSize(new Dimension(500, 400));
        overlayPanel.setVisible(true);
        return overlayPanel;
    }

    public static ImageIcon resizeImage(String imagePath, int length, int width){
        ImageIcon imgIcon = new ImageIcon(imagePath);
        Image img = imgIcon.getImage();
        Image resizedImg = img.getScaledInstance(length, width, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    } 

    public static void makePizza() {
        JLabel picLabel = new JLabel(new ImageIcon("images/pizza.png"));
        f = new JFrame("Start Making Pizza");
        // p = new JPanel();
        p = createOverlayPanel(picLabel);
        JTextField text = new JTextField("Click on the circle toppings to place on the pizza! ");
        JButton button = new JButton(resizeImage("images/olives.png", 100, 100));
        button.setPreferredSize(new DimensionUIResource(100, 100));
        JButton button1 = new JButton(resizeImage("images/new_tomato.png", 100, 100));
        button1.setPreferredSize(new DimensionUIResource(100, 100));
        JButton button2 = new JButton(resizeImage("images/yellow_bellpepper.jpeg", 100, 100));
        button2.setPreferredSize(new DimensionUIResource(100, 100));
        JButton button3 = new JButton(resizeImage("images/brocoli.png", 100, 100));
        button3.setPreferredSize(new DimensionUIResource(100, 100));
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
        button.addActionListener(new Pizza().new PlaceOlive());
        button1.addActionListener(new Pizza().new PlaceTomato());
        button2.addActionListener(new Pizza().new PlaceBP());
        button3.addActionListener(new Pizza().new PlaceBrocoli());
    }

        public class PlaceOlive implements ActionListener {
            public void actionPerformed(ActionEvent e){
            JLabel oliveLabel1 = new JLabel(resizeImage("images/olives.png", 50, 50));
            oliveLabel1.setPreferredSize(new DimensionUIResource(50, 50));
            JLabel oliveLabel2 = new JLabel(resizeImage("images/olives.png", 50, 50));
            oliveLabel2.setPreferredSize(new DimensionUIResource(50, 50));
            JLabel oliveLabel3 = new JLabel(resizeImage("images/olives.png", 50, 50));
            oliveLabel3.setPreferredSize(new DimensionUIResource(50, 50));
            //  Setting location
            oliveLabel1.setLocation(100, 100);
            oliveLabel2.setLocation(150, 200);
            oliveLabel3.setLocation(200, 300);
            p.add(oliveLabel1);
            p.add(oliveLabel2);
            p.add(oliveLabel3);
            p.revalidate();
            p.repaint();
        }
    }

    public class PlaceTomato implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JLabel tomatoLabel1 = new JLabel(resizeImage("images/new_tomato.png", 50, 50));
            tomatoLabel1.setPreferredSize(new DimensionUIResource(50, 50));
            JLabel tomatoLabel2 = new JLabel(resizeImage("images/new_tomato.png", 50, 50));
            tomatoLabel2.setPreferredSize(new DimensionUIResource(50, 50));
            //  Setting location
            tomatoLabel1.setLocation(100, 100);
            tomatoLabel2.setLocation(150, 200);
            p.add(tomatoLabel1);
            p.add(tomatoLabel2);
            p.revalidate();
            p.repaint();
        }
    }

    public class PlaceBP implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JLabel BPLabel1 = new JLabel(resizeImage("images/yellow_bellpepper.jpeg", 50, 50));
            BPLabel1.setPreferredSize(new DimensionUIResource(50, 50));
            JLabel BPLabel2 = new JLabel(resizeImage("images/yellow_bellpepper.jpeg", 50, 50));
            BPLabel2.setPreferredSize(new DimensionUIResource(50, 50));
            JLabel BPLabel3 = new JLabel(resizeImage("images/yellow_bellpepper.jpeg", 50, 50));
            BPLabel3.setPreferredSize(new DimensionUIResource(50, 50));
            //  Setting location
            BPLabel1.setLocation(100, 100);
            BPLabel2.setLocation(150, 200);
            BPLabel3.setLocation(200,300);
            p.add(BPLabel1);
            p.add(BPLabel2);
            p.add(BPLabel3);
            p.revalidate();
            p.repaint();
        }
    }

    public class PlaceBrocoli implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JLabel brocoliLabel1 = new JLabel(resizeImage("images/brocoli.png", 50, 50));
            brocoliLabel1.setPreferredSize(new DimensionUIResource(50, 50));
            JLabel brocoliLabel2 = new JLabel(resizeImage("images/brocoli.png", 50, 50));
            brocoliLabel2.setPreferredSize(new DimensionUIResource(50, 50));
            //  Setting location
            brocoliLabel1.setLocation(100, 100);
            brocoliLabel2.setLocation(150, 200);
            p.add(brocoliLabel1);
            p.add(brocoliLabel2);
            p.revalidate();
            p.repaint();
        }
    }
}
