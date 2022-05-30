package src;
import java.awt.Color;
// import java.awt.Component;
import java.awt.Dimension;
// import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
// import java.awt.Graphics;
import java.awt.event.*;   
import javax.swing.*;
// import javax.swing.event.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.Image;
// import java.awt.image.BufferedImage;
// import javax.imageio.ImageIO;
// import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;  
// import java.util.*;    
   

public class Pizza {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 800;
    private static JFrame f;
    // private static JFrame lf;
    private static JLayeredPane lp;
    // private static JPanel p;
    // private static boolean placeOl = false;
    // private static boolean placeTom = false;
    // private static boolean placeBP = false;
    // private static boolean placeBr = false;
    // private static JLayeredPane lp;
    private static JTextField text = new JTextField("Click on the circle topping to place on the pizza! ");
    private static JTextField text1 = new JTextField("Click on the triangle topping to place on the pizza! ");
    private static JTextField text2 = new JTextField("Click on the green topping to place on the pizza! ");
    private static JTextField text3 = new JTextField("Click on the yellow topping to place on the pizza! ");
    private static JButton olives = new JButton(resizeImage("images/olives.png", 100, 100));
    private static JButton tomato = new JButton(resizeImage("images/nobg_tomato.png", 100, 100));
    private static JButton pepper = new JButton(resizeImage("images/nobg_bp.png", 100, 100));
    private static JButton brocoli = new JButton(resizeImage("images/nobg_brocoli.png", 100, 100));
    private static JButton sound = new JButton(resizeImage("images/nobg_sound.png", 25, 25));

    public static ImageIcon resizeImage(String imagePath, int length, int width){
        ImageIcon imgIcon = new ImageIcon(imagePath);
        Image img = imgIcon.getImage();
        Image resizedImg = img.getScaledInstance(length, width, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    } 

    public static void makePizza() {
        JLabel picLabel = new JLabel(resizeImage("images/pizza.png", -100, 300));
        f = new JFrame("Start Making Pizza");
        // lf = new JFrame("Layered Frame");
        lp = new JLayeredPane();
        // p = new JPanel();
        lp.setLayout(null);
        picLabel.setBounds(75, 35, 300, 300);
        olives.setBounds(20, 350,100,100);
        tomato.setBounds(120, 350,100,100);
        pepper.setBounds(220, 350,100,100);
        brocoli.setBounds(320, 350,100,100);
        text.setBounds(60, 480, 330, 60);
        sound.setBounds(400, 500, 25, 25);
        lp.add(picLabel, JLayeredPane.DEFAULT_LAYER);
        // p.add(pizza);
        lp.add(olives);
        lp.add(tomato);
        lp.add(pepper);
        lp.add(brocoli);
        lp.add(text);
        lp.add(sound);

        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        lp.setBackground(Color.WHITE);
        f.setSize(200, 200);
        f.setVisible(true);
		f.add(lp);
        lp.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        f.pack(); 
        olives.addActionListener(new Pizza().new PlaceOlive());
        tomato.addActionListener(new Pizza().new PlaceTomato());
        pepper.addActionListener(new Pizza().new PlaceBP());
        brocoli.addActionListener(new Pizza().new PlaceBrocoli());
        sound.addActionListener(new Pizza().new textSound());
    }

    public class PlaceOlive implements ActionListener {
        public void actionPerformed(ActionEvent e){
        //first olive
        JLabel oliveLabel = new JLabel(resizeImage("images/nobg_olives.png", 50, 50));
        oliveLabel.setPreferredSize(new DimensionUIResource(50, 50));
        oliveLabel.setOpaque(true);
        oliveLabel.setBackground(new Color(252, 211, 147, 255));
        oliveLabel.setBounds(200, 160, 30, 30);
        //(int)(Math.random()*100+200),(int)(Math.random()*100+60), 50, 50
        //second olive
        JLabel oliveLabel1 = new JLabel(resizeImage("images/nobg_olives.png", 50, 50));
        oliveLabel1.setPreferredSize(new DimensionUIResource(50, 50));
        oliveLabel1.setOpaque(true);
        oliveLabel1.setBounds(280, 200, 30, 30);
        oliveLabel1.setBackground(new Color(252, 211, 147, 255));
        //third olive
        JLabel oliveLabel2 = new JLabel(resizeImage("images/nobg_olives.png", 50, 50));
        oliveLabel2.setPreferredSize(new DimensionUIResource(50, 50));
        oliveLabel2.setOpaque(true);
        oliveLabel2.setBounds(140, 230, 30, 30);
        oliveLabel2.setBackground(new Color(252, 211, 147, 255));
        lp.add(oliveLabel, Integer.valueOf(1));
        lp.add(oliveLabel1, Integer.valueOf(2));
        lp.add(oliveLabel2, Integer.valueOf(3));
        lp.remove(text); // remove circle
        text3.setBounds(60, 480, 330, 60);
        lp.add(text3); // add yellow
        lp.revalidate();
        lp.repaint();
        }
    }

    public class PlaceTomato implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //first tomato
            JLabel tomatoLabel = new JLabel(resizeImage("images/nobg_tomato.png", 60, 60));
            tomatoLabel.setPreferredSize(new DimensionUIResource(50, 50));
            tomatoLabel.setBounds(180, 240, 60, 60);
            tomatoLabel.setOpaque(true);
            tomatoLabel.setBackground(new Color(252, 211, 147, 255));
            // tomatoLabel.setBorderPainted(false);
            // tomatoLabel.setContentAreaFilled(false);
            //second tomato
            JLabel tomatoLabel1 = new JLabel(resizeImage("images/nobg_tomato.png", 60, 60));
            tomatoLabel1.setPreferredSize(new DimensionUIResource(50, 50));
            tomatoLabel1.setBounds(100, 180, 40, 40);
            tomatoLabel1.setBackground(new Color(252, 211, 147, 255));
            tomatoLabel1.setOpaque(true);
            //third tomato
            JLabel tomatoLabel2 = new JLabel(resizeImage("images/nobg_tomato.png", 60, 60));
            tomatoLabel2.setPreferredSize(new DimensionUIResource(50, 50));
            tomatoLabel2.setBackground(new Color(252, 211, 147, 255));
            tomatoLabel2.setBounds(260, 100, 40, 50);
            tomatoLabel2.setOpaque(true);
            //fourth tomato
            JLabel tomatoLabel3 = new JLabel(resizeImage("images/nobg_tomato.png", 60, 60));
            tomatoLabel3.setPreferredSize(new DimensionUIResource(50, 50));
            tomatoLabel3.setBackground(new Color(252, 211, 147, 255));
            tomatoLabel3.setBounds(285, 235, 40, 40);
            tomatoLabel3.setOpaque(true);
            //fifth tomato
            JLabel tomatoLabel4 = new JLabel(resizeImage("images/nobg_tomato.png", 60, 60));
            tomatoLabel4.setPreferredSize(new DimensionUIResource(50, 50));
            tomatoLabel4.setBackground(new Color(252, 211, 147, 255));
            tomatoLabel4.setBounds(230, 180, 40, 40);
            tomatoLabel4.setOpaque(true);
            // placeTom = true;
            // if (placeTom){
            //     p.add(tomatoLabel);
            // }
            lp.add(tomatoLabel, Integer.valueOf(4));
            lp.add(tomatoLabel1, Integer.valueOf(5));
            lp.add(tomatoLabel2, Integer.valueOf(6));
            lp.add(tomatoLabel3, Integer.valueOf(7));
            lp.add(tomatoLabel4, Integer.valueOf(8));
            lp.remove(text2); //remove triangle
            text1.setBounds(60, 480, 330, 60);
            lp.add(text1); // add green
            lp.revalidate();
            lp.repaint();
        }
    }

    public class PlaceBP implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //first BP
            JLabel BPLabel = new JLabel(resizeImage("images/nobg_bp.png", 50, 50));
            BPLabel.setPreferredSize(new DimensionUIResource(50, 50));
            BPLabel.setBounds(120, 100, 50, 50);
            BPLabel.setOpaque(true);
            BPLabel.setBackground(new Color(252, 211, 147, 255));
            //second BP
            JLabel BPLabel1 = new JLabel(resizeImage("images/nobg_bp.png", 50, 50));
            BPLabel1.setPreferredSize(new DimensionUIResource(50, 50));
            BPLabel1.setBounds(140, 180, 50, 50);
            BPLabel1.setOpaque(true);
            BPLabel1.setBackground(new Color(252, 211, 147, 255));
            //third BP
            JLabel BPLabel2 = new JLabel(resizeImage("images/nobg_bp.png", 50, 50));
            BPLabel2.setPreferredSize(new DimensionUIResource(50, 50));
            BPLabel2.setBounds(210, 80, 50, 50);
            BPLabel2.setOpaque(true);
            BPLabel2.setBackground(new Color(252, 211, 147, 255));
             //fourth BP
             JLabel BPLabel3 = new JLabel(resizeImage("images/nobg_bp.png", 50, 50));
             BPLabel3.setPreferredSize(new DimensionUIResource(50, 50));
             BPLabel3.setBounds(200, 210, 40, 50);
             BPLabel3.setOpaque(true);
             BPLabel3.setBackground(new Color(252, 211, 147, 255));
            // placeBP = true;
            // if (placeBP){
            //     p.add(BPLabel);
            // }
            lp.add(BPLabel, Integer.valueOf(9));
            lp.add(BPLabel1, Integer.valueOf(10));
            lp.add(BPLabel2, Integer.valueOf(11));
            lp.add(BPLabel3, Integer.valueOf(12));
            lp.remove(text3); // remove green
            text2.setBounds(60, 480, 330, 60);
            lp.add(text2); // add yellow
            lp.revalidate();
            lp.repaint();
        }
    }

    public class PlaceBrocoli implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //first brocoli
            JLabel brocoliLabel = new JLabel(resizeImage("images/nobg_brocoli.png", 40, 40));
            brocoliLabel.setPreferredSize(new DimensionUIResource(50, 50));
            brocoliLabel.setBounds(187, 60, 40, 40);
            brocoliLabel.setOpaque(true);
            brocoliLabel.setBackground(new Color(252, 211, 147, 255));
            //second brocoli
            JLabel brocoliLabel1 = new JLabel(resizeImage("images/nobg_brocoli.png", 40, 40));
            brocoliLabel1.setPreferredSize(new DimensionUIResource(50, 50));
            brocoliLabel1.setBounds(165, 130, 40, 40);
            brocoliLabel1.setOpaque(true);
            brocoliLabel1.setBackground(new Color(252, 211, 147, 255));
            //third brocoli
            JLabel brocoliLabel2 = new JLabel(resizeImage("images/nobg_brocoli.png", 40, 40));
            brocoliLabel2.setPreferredSize(new DimensionUIResource(50, 50));
            brocoliLabel2.setBounds(280, 150, 40, 40);
            brocoliLabel2.setOpaque(true);
            brocoliLabel2.setBackground(new Color(252, 211, 147, 255));
            //fourth brocoli
            JLabel brocoliLabel3 = new JLabel(resizeImage("images/nobg_brocoli.png", 40, 40));
            brocoliLabel3.setPreferredSize(new DimensionUIResource(50, 50));
            // brocoliLabel3.setBounds(270, 160, 30, 30);
            brocoliLabel3.setOpaque(true);
            brocoliLabel3.setBounds(245, 245, 40, 40);
            brocoliLabel3.setBackground(new Color(252, 211, 147, 255));
            lp.add(brocoliLabel, Integer.valueOf(13));
            lp.add(brocoliLabel1, Integer.valueOf(14));
            lp.add(brocoliLabel2, Integer.valueOf(15));
            lp.add(brocoliLabel3, Integer.valueOf(16));
            lp.remove(text2);
            text1.setBounds(60, 480, 330, 60);
            lp.add(text1);
            lp.revalidate();
            lp.repaint();
        }
    }

    public class textSound implements ActionListener {
        public void actionPerformed(ActionEvent e){
            // TextSpeech method
        }
    }
        

    // public static JButton createButton(String imagePath){
    //     JButton button = new JButton(resizeImage(imagePath, 100, 100));
    //     // button.setBackground(Color.green);
    //     // button.setPreferredSize(new DimensionUIResource(100, 100));
    //     return button;
    // }

}
