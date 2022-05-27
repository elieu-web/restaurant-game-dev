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
    private static final int HEIGHT = 600;
    private static JFrame f;
    // private static JFrame lf;
    private static JPanel p;
    // private static boolean placeOl = false;
    // private static boolean placeTom = false;
    // private static boolean placeBP = false;
    // private static boolean placeBr = false;
    // private static JLayeredPane lp;
    private static JTextField text = new JTextField("Click on the circle topping to place on the pizza! ");
    private static JTextField text1 = new JTextField("Click on the triangle topping to place on the pizza! ");
    private static JTextField text2 = new JTextField("Click on the green topping to place on the pizza! ");
    private static JTextField text3 = new JTextField("Click on the yellow topping to place on the pizza! ");
    private static JButton olives = new JButton(resizeImage("images/nobg_olives.png", 100, 100));
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
        // lp = new JLayeredPane();
        p = new JPanel();
        p.setLayout(null);
        picLabel.setBounds(75, 35, 300, 300);
        olives.setBounds(20, 350,100,100);
        tomato.setBounds(120, 350,100,100);
        pepper.setBounds(220, 350,100,100);
        brocoli.setBounds(320, 350,100,100);
        text.setBounds(60, 480, 330, 60);
        sound.setBounds(400, 500, 25, 25);
        p.add(picLabel);
        // p.add(pizza);
        p.add(olives);
        p.add(tomato);
        p.add(pepper);
        p.add(brocoli);
        p.add(text);
        p.add(sound);

        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        p.setBackground(Color.WHITE);
        f.setSize(200, 200);
        f.setVisible(true);
		f.add(p);
        p.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        f.pack(); 
        olives.addActionListener(new Pizza().new PlaceOlive());
        tomato.addActionListener(new Pizza().new PlaceTomato());
        pepper.addActionListener(new Pizza().new PlaceBP());
        brocoli.addActionListener(new Pizza().new PlaceBrocoli());
        sound.addActionListener(new Pizza().new textSound());
    }

    public class PlaceOlive implements ActionListener {
        public void actionPerformed(ActionEvent e){
        JLabel oliveLabel = new JLabel(resizeImage("images/nobg_olives.png", 50, 50));
        oliveLabel.setPreferredSize(new DimensionUIResource(50, 50));
        oliveLabel.setBounds((int)(Math.random()*100+200),(int)(Math.random()*100+60), 50, 50);
        // placeOl = true;
        // if (placeOl) {
        //     p.add(oliveLabel);
        // }
        // p.add(oliveLabel1, JLayeredPane.PALETTE_LAYER);
        p.add(oliveLabel);
        JLabel oliveLabel2 = new JLabel(resizeImage("images/nobg_olives.png", 50, 50));
        oliveLabel2.setPreferredSize(new DimensionUIResource(50, 50));
        p.remove(text); // remove circle
        text3.setBounds(60, 480, 330, 60);
        p.add(text3); // add yellow
        p.revalidate();
        p.repaint();
        }
    }

    public class PlaceTomato implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JLabel tomatoLabel = new JLabel(resizeImage("images/nobg_tomato.png", 50, 50));
            tomatoLabel.setPreferredSize(new DimensionUIResource(50, 50));
            tomatoLabel.setBounds((int)(Math.random()*100+200),(int)(Math.random()*100+100), 50, 50);
            // placeTom = true;
            // if (placeTom){
            //     p.add(tomatoLabel);
            // }
            p.add(tomatoLabel);
            p.remove(text2); //remove triangle
            text1.setBounds(60, 480, 330, 60);
            p.add(text1); // add green
            p.revalidate();
            p.repaint();
        }
    }

    public class PlaceBP implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JLabel BPLabel = new JLabel(resizeImage("images/nobg_bp.png", 50, 50));
            BPLabel.setPreferredSize(new DimensionUIResource(50, 50));
            BPLabel.setBounds((int)(Math.random()*100+200),(int)(Math.random()*100+50), 50, 50);
            // placeBP = true;
            // if (placeBP){
            //     p.add(BPLabel);
            // }
            p.add(BPLabel);
            p.remove(text3); // remove green
            text2.setBounds(60, 480, 330, 60);
            p.add(text2); // add yellow
            p.revalidate();
            p.repaint();
        }
    }

    public class PlaceBrocoli implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JLabel brocoliLabel = new JLabel(resizeImage("images/nobg_brocoli.png", 50, 50));
            brocoliLabel.setPreferredSize(new DimensionUIResource(50, 50));
            brocoliLabel.setBounds((int)(Math.random()*100+200),(int)(Math.random()*100+40), 50, 50);
            // placeBr = true;
            // if (placeBr){
            //     p.add(brocoliLabel);
            // }
            p.add(brocoliLabel);
            p.remove(text2);
            text1.setBounds(60, 480, 330, 60);
            p.add(text1);
            p.revalidate();
            p.repaint();
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

    //makePizza method
     
        // JButton jButton1 = new JButton("Open");
        // jButton1.setIcon(resizeImage("images/yellow_bellpepper.jpeg", 100, 100));
        // jButton1.setBackground(Color.green);
        // jButton1.setBounds(175, 50, 150, 100);
        // // lp.add(jButton1, JLayeredPane.DEFAULT_LAYER);

        // JButton jButton2 = new JButton("Open");
        // JButton jButton3 = new JButton("Close");
        // jButton2.setVisible(false);
        // jButton3.setVisible(false);
        // jButton2.setBackground(Color.RED);
        // jButton3.setBackground(Color.RED);
        // jButton2.setBounds(75, 125, 150, 100);
        // jButton3.setBounds(275, 125, 150, 100);
        // lp.add(jButton2, JLayeredPane.PALETTE_LAYER);
        // lp.add(jButton3, JLayeredPane.PALETTE_LAYER);
        // lp.add(picLabel, JLayeredPane.DEFAULT_LAYER);
        // lp.add(olives, JLayeredPane.POPUP_LAYER);
        // lp.add(tomato, JLayeredPane.POPUP_LAYER);
        // lp.add(pepper, JLayeredPane.POPUP_LAYER);
        // lp.add(brocolli, JLayeredPane.POPUP_LAYER);
        // lp.add(text);
        // lf.setVisible(true);
        // lf.add(lp);
        // // lp.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // lf.pack(); 
        // lf.setVisible(true);
        // jButton1.addActionListener(e -> {
        //     jButton2.setVisible(true);
        //     jButton3.setVisible(true);
        // });

        // f.setLocationRelativeTo(null);
        // olives.setVisible(true);
        // tomato.setVisible(true);
        // pepper.setVisible(true);
        // brocolli.setVisible(true);
}
