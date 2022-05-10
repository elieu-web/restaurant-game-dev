import java.util.*;

public abstract class Money {
    private double cost;

    public Money() {
        cost = 0.0;
    }

    public Money(double val) {
        cost = val;
    }

    public getCost() {
        return cost;
    }
}