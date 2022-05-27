package src;
import javax.swing.*;
import javax.swing.plaf.*;

public class RestaurantGame{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;
    
    public static void main(String[] args) {
		new RestaurantGame().start();
	}

    public void start(){
        try {}
        catch (Exception e) {
            System.out.println("ERROR!!!");
        }
        RestaurantGamePaint rgp = new RestaurantGamePaint();
        rgp.setVisible(true);
        rgp.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
        rgp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        rgp.pack();
        rgp.setLocationRelativeTo(null);
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

