package c_lib;

public class cal {
    public static double sum(double a, double b) {
        return a + b;
    };
    public static double sub(double a, double b) { 
        return a - b;
    };
    public static double mul(double a, double b ) {
        if (a == 0 || b == 0) return 0;
        return a * b;
    };
    @SuppressWarnings("null")
    public static double div(double a, double b) {
        if (b == 0) return (Double) null;
        else return a/b;
    }
    public static double sqroot(double x) {
        return Math.sqrt(x);
    }
}
