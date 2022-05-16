import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

public class Restaurant{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;
    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JLabel label;
    private JButton button;
    public static void main(String[] args) {
		new Restaurant().start();
	}

    public void start(){
        try {
            System.out.println("WORKS!");
        } catch (Exception e) {
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
            Font helvetica = new FontUIResource("Helvetica", Font.PLAIN, 20);
            JTextField text = new JTextField("Welcome! Type how many pizzas: ");
            text.setBounds(50,50,200,200);
            panel.removeAll();
            panel.add(text);
            panel.revalidate();
            panel.repaint();
            GridLayout gl2 = new GridLayout(1,2);
            panel2.setLayout(gl2);
            JButton b2 = new JButton("NEW");
            b2.setFont(helvetica);
            panel2.add(b2);
        }    
    }
   
}