package c_lib;

public class cal {
    public double sum(double a, double b) {
        return a + b;
    };
    public double sub(double a, double b) { 
        return a - b;
    };
    public double mul(double a, double b ) {
        if (a == 0 || b == 0) return 0;
        return a * b;
    };
    @SuppressWarnings("null")
    public double div(double a, double b) {
        if (b == 0) return (Double) null;
        else return a/b;
    }
}
