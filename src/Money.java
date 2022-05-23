package src;
import java.util.*;

public abstract class Money {
    private double cost;

    public Money() {
        cost = 0.0;
    }

    public Money(double val) {
        cost = val;
    }

    public double getCost() {
        return cost;
    }
    
    public void roundUp(double amount){
    int option1 = ((int)Math.random() * 11) + (int)amount;
    int option2 = ((int)Math.random() * 11) + (int)amount;
    int option3 = ((int)amount) + 1;
    System.out.print(option1);
    System.out.print(option2);
    System.out.print(option3);
    System.out.print(option3 + " is the correct answer!");
}
}
