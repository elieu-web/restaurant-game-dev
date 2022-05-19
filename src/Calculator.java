package src;

import java.text.DecimalFormat;

public abstract class Calculator {
    private int total;
    private static final double COST = 15.75;

    public static String getPrice(Double i) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(i*COST);
    }

}
