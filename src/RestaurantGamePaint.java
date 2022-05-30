package src;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class RestaurantGamePaint extends JFrame{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 600;
    private Font font = new Font("Helvetica", Font.PLAIN, 30);
    protected static JFrame frame = new JFrame("Restaurant Game");
    protected static JPanel panel = new JPanel();
    protected static Container main;
    private CardLayout cl;
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
        cl.first(main);
        this.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
    }

    class PizzaPanel implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // panel.removeAll();
            // //panel2.removeAll();      
            // Pizza.makePizza();
            // panel.revalidate();
            // panel.repaint();
            cl.show(main,"Pizza");
        }
    }

    class MoneyPanel implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        cl.show(main,"Money");
        // Money.chooseOptions();
    }  
}

}
