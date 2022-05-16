package src;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

public class RestaurantGame{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;
    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JLabel label;
    private JButton button;
    public static void main(String[] args) {
		new RestaurantGame().start();
	}

    public void start(){
        try {}
        catch (Exception e) {
            System.out.println("ERROR!!!");
        }
        GridLayout gl = new GridLayout(2,0);
        frame = new JFrame("Restaurant Game");
        panel = new JPanel();
        button = new JButton("NEXT");
        label = new JLabel("Welcome to Restaurant Game!", SwingConstants.CENTER);
        panel2 = new JPanel();
        frame.setVisible(true);
        Font helvetica = new Font("Helvetica", Font.PLAIN, 30);
        label.setFont(helvetica);
        button.setFont(helvetica);
        button.addActionListener(new MyActionListener());
        frame.setLayout(gl);
        panel.add(label);
        panel2.add(button);
		frame.add(panel);
        panel.setBackground(new ColorUIResource(255,255,102));
        frame.add(panel2);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
        frame.setLocationRelativeTo(null);
        frame.pack();
    }

    public class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JTextField text = new JTextField("Welcome! Type how many pizzas: ");
            GridLayout gl2 = new GridLayout(1,0);
            panel.removeAll();
            panel.add(text);
            panel.setLayout(gl2);
            panel.revalidate();
            panel.repaint();
            panel2.removeAll();
            GridLayout gl = new GridLayout(1,3);
            panel2.setLayout(gl2);
            JButton b2 = new JButton("HOME");
            b2.addActionListener(new HomePanel());
            JButton b3 = new JButton("PREVIOUS");
            button = new JButton("NEXT");
            panel2.add(b2);
            panel2.add(b3);
            panel2.add(button);
            panel2.revalidate();
            panel2.repaint();
        }    

    public class HomePanel implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                label = new JLabel("Welcome to Restaurant Game!", SwingConstants.CENTER);
                Font helvetica = new Font("Helvetica", Font.PLAIN, 30);
                button = new JButton("NEXT");
                button.addActionListener(new MyActionListener());
                label.setFont(helvetica);
                panel.add(label);
                panel.setBackground(new ColorUIResource(255,255,102));
                panel.revalidate();
                panel.repaint();
                panel2.removeAll();
                panel2.add(button);
                panel2.revalidate();
                panel2.repaint();
            }
   }
        
    }
   
}