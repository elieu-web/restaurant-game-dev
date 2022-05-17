package src;

public abstract class Calculator {
    private int total;
    private static final double COST = 15.75;

    public static double getPrice(Double i) {
        String c = Double.toString(i*COST);
        String x = c.substring(c.indexOf(".")+1);
        int lens = x.length();
        if (lens>2) {
            while (lens!=2) {
                
            }
        }
        else if (lens<2) x += "0";
    }

}
