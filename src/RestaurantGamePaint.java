package src;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class RestaurantGamePaint extends JFrame{
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 600;
    public static Font font = new Font("Helvetica", Font.PLAIN, 30);
    protected static JFrame frame = new JFrame("Restaurant Game");
    protected static JPanel panel = new JPanel();
    public static Container main;
    public static CardLayout cl;
    private JPanel panel2 = new JPanel();
    // private JTextField text;
    private JLabel label;
    private JButton button;

    RestaurantGamePaint() {
        button = new JButton("MONEY MODE");
        JButton button2 = new JButton("PIZZA MODE");
        label = new JLabel("Welcome to Restaurant Game!", SwingConstants.CENTER);
        GridLayout gl = new GridLayout(2,1);
        panel.setLayout(gl);
        cl = new CardLayout();
        main = getContentPane();
        main.setLayout(cl);
        label.setFont(font);
        button.setFont(font);
        button.addActionListener(new MoneyPanel());
        button2.setFont(font);
        button2.addActionListener(new PizzaPanel());
        panel.add(label);
        panel.setBackground(new ColorUIResource(255,255,102));
        panel2.add(button);
        panel2.add(button2);
        panel.add(panel2);
        main.add(panel, "Home");
        main.add(Pizza.makePizza(), "Pizza");
        main.add(Money.chooseOptions(), "Money");
        main.add(Money.makeOptionsPanel(), "MONEY CHOICE");
        cl.first(main);
        this.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
    }

    public static JPanel makeHomePanel() {
            JButton b1 = new JButton("<--");
            JButton b2 = new JButton("HOME");
            JButton b3 = new JButton("-->");
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cl.first(main);
                }
            });
            JPanel p = new JPanel();
            GridLayout gl2 = new GridLayout(1,3);
            p.setLayout(gl2);
            p.add(b1);
            p.add(b2);
            p.add(b3);
            return p;
    }

    class PizzaPanel implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cl.show(main,"Pizza");
        }
    }

    class MoneyPanel implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        cl.show(main,"Money");
        }  
    }
}
