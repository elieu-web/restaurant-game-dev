package src;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

public class Pizza {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 800;
    private static JFrame f;
    // private static JFrame lf;
    private static JPanel p;
    // private static JLayeredPane lp;
    private static JTextField text = new JTextField("Click on the circle topping to place on the pizza! ");
    private static JTextField text1 = new JTextField("Click on the triangle topping to place on the pizza! ");
    private static JTextField text2 = new JTextField("Click on the green topping to place on the pizza! ");
    private static JTextField text3 = new JTextField("Click on the yellow topping to place on the pizza! ");
   

    public static ImageIcon resizeImage(String imagePath, int length, int width){
        ImageIcon imgIcon = new ImageIcon(imagePath);
        Image img = imgIcon.getImage();
        Image resizedImg = img.getScaledInstance(length, width, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    } 

    public static JButton createButton(String imagePath){
        JButton button = new JButton(resizeImage(imagePath, 100, 100));
        // button.setBackground(Color.green);
        // button.setPreferredSize(new DimensionUIResource(100, 100));
        return button;
    }

    public static Component makePizza() {
        JLabel picLabel = new JLabel(new ImageIcon("images/pizza.png"));
       // f = new JFrame("Start Making Pizza");
        // lf = new JFrame("Layered Frame");
        // lp = new JLayeredPane();
        p = new JPanel();
        JButton olives = new JButton(resizeImage("images/olives.png", 100, 100));
        JButton tomato = new JButton(resizeImage("images/new_tomato.png", 100, 100));
        JButton pepper = new JButton(resizeImage("images/yellow_bellpepper.jpeg", 100, 100));
        JButton brocolli = new JButton(resizeImage("images/brocoli.png", 100, 100));

        p.add(picLabel);
        p.add(olives);
        p.add(tomato);
        p.add(pepper);
        p.add(brocolli);
        p.add(text);

        //f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        p.setBackground(Color.WHITE);
        //f.setSize(200, 200);
       // f.setVisible(true);
		//f.add(p);
        p.setPreferredSize(new Dimension(WIDTH, HEIGHT));
       // f.pack(); 

        // lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // lf.setSize(520, 530);
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
        olives.addActionListener(new Pizza().new PlaceOlive());
        tomato.addActionListener(new Pizza().new PlaceTomato());
        pepper.addActionListener(new Pizza().new PlaceBP());
        brocolli.addActionListener(new Pizza().new PlaceBrocoli());
        return p;
    }

    public class PlaceOlive implements ActionListener {
        public void actionPerformed(ActionEvent e){
        JLabel oliveLabel1 = new JLabel(resizeImage("images/olives.png", 50, 50));
        oliveLabel1.setPreferredSize(new DimensionUIResource(50, 50));
        JLabel oliveLabel2 = new JLabel(resizeImage("images/olives.png", 50, 50));
        oliveLabel2.setPreferredSize(new DimensionUIResource(50, 50));
        JLabel oliveLabel3 = new JLabel(resizeImage("images/olives.png", 50, 50));
        oliveLabel3.setPreferredSize(new DimensionUIResource(50, 50));
        p.add(oliveLabel1);
        p.add(oliveLabel2);
        p.add(oliveLabel3);
            // for(int i=0; i<2; i++){
            //         JLabel oliveLabel = new JLabel(resizeImage("images/olives.png", 50, 50));
            //         oliveLabel.setPreferredSize(new DimensionUIResource(50, 50));
            //         // lp.add(oliveLabel);
            //         oliveLabel.setVisible(true);
            // }
        p.remove(text); // remove circle
        p.add(text3); // add yellow
        p.revalidate();
        p.repaint();
        }
    }

    // public class JavaJLayeredPane implements ActionListener {
        
    // }

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
            p.remove(text2); //remove triangle
            p.add(text1); // add green
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
            p.remove(text3); // remove green
            p.add(text2); // add yellow
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
            p.remove(text2);
            p.add(text1);
            p.revalidate();
            p.repaint();
        }
    }
}
