import java.util.ArrayList;
import java.util.Scanner;
import c_lib.cal;


public class App {

    static ArrayList<String[]> history = new ArrayList<String[]>();
    static String x = String.valueOf(0);
    public static int counter = 0;

    static void initialize(Scanner inp) {
        
        if (!history.isEmpty()) {
            history.clear();
            System.out.print("\nPlease enter your initial value ->");
            double initial = inp.nextDouble();


            String[] arr = {"Initial Digits",String.valueOf(initial)};

            history.add(arr);
        }

    };

    static String method(int x) {
        String toReturn = "x";

        switch(x) {
            case(1):
                toReturn="Addition";
                break;
            case(2):
                toReturn="Subtraction";
                break;
            case(3):
                toReturn="Multiplication";
                break;
            case(4):
                toReturn="Division";
                break;
            case(5):
                toReturn="Square Root";
                break;
        }

        return toReturn;
    }

    static void HistoryCheck() {
        for(String[] x : history) {
            System.out.println(x[0] + "->" +  x[1]);
        }
    }

    public static void main(String[] args) {
        
        // Creating Strings for the format
        String initialString = "Welcome to this CLI Calculator !!! \nNote: This calculator can take up to 999 instructions";
        String calculate = "1 -> Addition\n2 -> Subtraction\n3 -> Multiplication\n4 -> Division\n5 -> Square Root\n0 -> History\n\n\n9 -> Reset";
        String valueInsert = "Please enter the next value";
        String expInsert = "Please Select the Expression";

        // Initializing

        // Printing this initial statement then creating this goody ahh scanner
        System.out.println(initialString);

        Scanner inp = new Scanner(System.in);

        // Try and catch block because the code below are now risky ones where errors could occur
        try {

            System.out.print("\nPlease enter your initial value ->");
            double initial = inp.nextDouble();

            String[] arr = {"Initial Digits",String.valueOf(initial)};

            history.add(arr);
            

            while (true && counter < 999) {
                
                System.out.print("\n"+calculate+"\n"+expInsert);
                int val = inp.nextInt();

                if (val != 6 || val != 7 || val != 8) { // I forgot about how to check if a variable is in a array or not
                    
                    System.out.println("\n Not a valid option... please try again...");
                    continue;

                } else if (val == 9) {

                    System.out.println("Reinitiallizing....");
                    initialize(inp);
                    System.gc();
                    continue;

                } else if (val == 6) {
                    HistoryCheck();
                    continue;
                } else {

                    // Code for the calculations
                
                }

            }



        } catch (ArithmeticException e) {

            System.out.println("Error: Arthmetic Expression was out of bounds\nRestart the application");
            inp.close();

        } catch (Exception e) {

            System.out.println("Internal Error Occurred");
            inp.close();

        }
        

    };

     
};