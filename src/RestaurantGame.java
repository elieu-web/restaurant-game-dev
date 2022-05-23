//package src;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;

public class RestaurantGame{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;
    private Font helvetica = new Font("Helvetica", Font.PLAIN, 30);
    private JFrame frame = new JFrame("Restaurant Game");
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    // private JTextField text;
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
        draw();
     }

    private void draw() {
        button = new JButton("MONEY MODE");
        JButton button2 = new JButton("PIZZA MODE");
        label = new JLabel("Welcome to Restaurant Game!", SwingConstants.CENTER);
        GridLayout gl = new GridLayout(2,0);
        frame.setLayout(gl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
        label.setFont(helvetica);
        button.setFont(helvetica);
        button.addActionListener(new MoneyPanel());
        button2.setFont(helvetica);
        button2.addActionListener(new PizzaPanel());
        panel.add(label);
        panel2.add(button);
        panel2.add(button2);
		frame.add(panel);
        panel.setBackground(new ColorUIResource(255,255,102));
        frame.add(panel2);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public class MoneyPanel implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Money.chooseOptions();
            // label = new JLabel("Round up the price of " + 14.35, SwingConstants.CENTER);
            // label.setFont(helvetica);
            // GridLayout gl2 = new GridLayout(1,0);
            // // text.addKeyListener(new MyKeyListener());
            // panel.removeAll();
            // panel.add(label);
            // panel.setLayout(gl2);
            // panel.revalidate();
            // panel.repaint();
            // panel2.removeAll();
            // GridLayout gl = new GridLayout(1,3);
            // panel2.setLayout(gl);
            // JButton b2 = new JButton("PREVIOUS");
            // JButton b3 = new JButton("HOME");
            // b2.addActionListener(new QuestionPanel());
            // b3.addActionListener(new HomePanel());
            // button = new JButton("NEXT");
            // panel2.add(b2);
            // //button.addActionListener(new PizzaPanel());
            // panel2.add(b3);
            // panel2.add(button);
            // panel2.revalidate();
            // panel2.repaint();
        }  
    }  

    // public class HomePanel implements ActionListener {
    //         public void actionPerformed(ActionEvent e) {
    //             panel.removeAll();
    //             panel2.removeAll();
    //             draw();
    //             panel.revalidate();
    //             panel.repaint();
    //             panel2.revalidate();
    //             panel2.repaint();
    //             frame.revalidate();
    //             frame.repaint();
    //         }
    //     }

    // public class MyKeyListener implements KeyListener {
    //     public void keyPressed(KeyEvent e) {
    //         if (e.getKeyCode()== KeyEvent.VK_ENTER) {
    //             panel.removeAll();
    //             GridLayout gl = new GridLayout(1,5);
    //             GridLayout gl2 = new GridLayout(3,1);
    //             frame.setLayout(gl2);
    //             JPanel panel3 = new JPanel();
    //             panel3.setLayout(gl);
    //             panel3.setBackground(Color.BLACK);
    //             frame.add(panel3);
    //             String s = text.getText();
    //             try {
    //                 Double i = Double.parseDouble(s.substring(s.indexOf(":")+2));
    //                 label = new JLabel("Round up the price of " + Calculator.getPrice(i),SwingConstants.CENTER);
    //             } catch (NumberFormatException n) {
    //                 label = new JLabel("Sorry, that's not a number! Please go back and try again.", SwingConstants.CENTER);
    //             }
    //             panel.add(label);
    //             panel.revalidate();
    //             panel.repaint();
    //             frame.revalidate();
    //             frame.repaint();
    //         }
    //     }

    //     public void keyTyped(KeyEvent e) {

    //     }

    //     public void keyReleased(KeyEvent e) {
           
    //     }
    // }

    // public class QuestionPanel implements ActionListener {
    //     public void actionPerformed(ActionEvent e) {
    //         JOptionPane.showMessageDialog(null, "No questions found to go back to", "error", JOptionPane.ERROR_MESSAGE);
    //     }
    // }

    public static class PizzaPanel implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Pizza.makePizza();
        }
    }

}
