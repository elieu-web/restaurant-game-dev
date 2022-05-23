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
    private JTextField text;
    private JLabel label;
    private JButton button;
    boolean b = false;
    public static void main(String[] args) {
		new RestaurantGame().start();
	}

    public void start(){
        try {}
        catch (Exception e) {
            System.out.println("ERROR!!!");
        }
        draw();
     }

    private void draw() {
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
            text = new JTextField("Welcome! Type how many pizzas: ",2);
            GridLayout gl2 = new GridLayout(1,0);
            text.addKeyListener(new MyKeyListener());
            panel.removeAll();
            panel.add(text);
            panel.setLayout(gl2);
            panel.revalidate();
            panel.repaint();
            panel2.removeAll();
            GridLayout gl = new GridLayout(1,3);
            panel2.setLayout(gl);
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

    public class MyKeyListener implements KeyListener {
        public void keyPressed(KeyEvent e) {

        }

        public void keyTyped(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode()== KeyEvent.VK_ENTER) {
                panel.removeAll();
                String s = text.getText();
                Double i = Double.parseDouble(s.substring(s.indexOf(":")+2));
                i = Calculator.getPrice(i);
                label = new JLabel(i.toString(),SwingConstants.CENTER);
                panel.add(label);
                panel.revalidate();
                panel.repaint();
            }
        }
    }
    }
   
}