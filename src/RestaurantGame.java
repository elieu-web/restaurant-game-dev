package src;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;

public class RestaurantGame{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;
    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JTextField text;
    private JLabel label;
    private JButton button;
    private ArrayList<JFrame> frameList;
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
        button = new JButton("MONEY MODE");
        JButton button2 = new JButton("PIZZA MODE");
        label = new JLabel("Welcome to Restaurant Game!", SwingConstants.CENTER);
        panel2 = new JPanel();
        frame.setVisible(true);
        Font helvetica = new Font("Helvetica", Font.PLAIN, 30);
        label.setFont(helvetica);
        button.setFont(helvetica);
        button.addActionListener(new MyActionListener());
        button2.setFont(helvetica);
        button2.addActionListener(new PizzaPanel());
        frame.setLayout(gl);
        panel.add(label);
        panel2.add(button);
        panel2.add(button2);
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
            JButton b2 = new JButton("PREVIOUS");
            JButton b3 = new JButton("HOME");
            b2.addActionListener(new QuestionPanel());
            b3.addActionListener(new HomePanel());
            button = new JButton("NEXT");
            panel2.add(b2);
            button.addActionListener(new PizzaPanel());
            panel2.add(b3);
            panel2.add(button);
            panel2.revalidate();
            panel2.repaint();
        }  
    }  

    public class HomePanel implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                label = new JLabel("Welcome to Restaurant Game!", SwingConstants.CENTER);
                Font helvetica = new Font("Helvetica", Font.PLAIN, 30);
                button = new JButton("MONEY MODE");
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
            if (e.getKeyCode()== KeyEvent.VK_ENTER) {
                panel.removeAll();
                GridLayout gl = new GridLayout(1,5);
                GridLayout gl2 = new GridLayout(3,1);
                frame.setLayout(gl2);
                JPanel panel3 = new JPanel();
                panel3.setLayout(gl);
                panel3.setBackground(Color.BLACK);
                frame.add(panel3);
                String s = text.getText();
                try {
                    Double i = Double.parseDouble(s.substring(s.indexOf(":")+2));
                    label = new JLabel("Round up the price of " + Calculator.getPrice(i),SwingConstants.CENTER);
                } catch (NumberFormatException n) {
                    label = new JLabel("Sorry, that's not a number! Please go back and try again.", SwingConstants.CENTER);
                }
                panel.add(label);
                panel.revalidate();
                panel.repaint();
                frame.revalidate();
                frame.repaint();
            }
        }

        public void keyTyped(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e) {
           
        }
    }

    public class QuestionPanel implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "No questions found to go back to", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public class PizzaPanel implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Pizza.makePizza();
        }
    }

}