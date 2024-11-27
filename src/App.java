import java.util.ArrayList;
import java.util.Scanner;
import c_lib.cal;


public class App {

    static ArrayList<String[]> history = new ArrayList<String[]>();
    static String x = String.valueOf(0);
    public static int counter = 0;

    static double initialize(Scanner inp) {
        
        if (!history.isEmpty()) {
            history.clear(); // Clearing the List
        }

        System.out.print("\nPlease enter your initial value ->");

        double initial = inp.nextDouble();

        String[] arr = {"Initial Digits",String.valueOf(initial)};
    
        history.add(arr);

        return initial;

    };

    static void HistoryCheck() {
        for(String[] x : history) {
            System.out.println(x[0] + "->" +  x[1]);
        }
    }

    public static void main(String[] args) {
        
        // Creating Strings for the format
        String initialString = "Welcome to this CLI Calculator !!! \nNote: This calculator can take up to 999 instructions";
        String calculate = "1 -> Addition\n2 -> Subtraction\n3 -> Multiplication\n4 -> Division\n5 -> Square Root\n0 -> History\n\n\n9 -> Reset\n10 -> Exit";
        String valueInsert = "Please enter the next value\n -> ";
        String expInsert = "Please Select the Expression\n -> ";

        // Initializing

        // Printing this initial statement then creating this goody ahh scanner
        System.out.println(initialString);

        Scanner inp = new Scanner(System.in);

        // Try and catch block because the code below are now risky ones where errors could occur

        try {

            double value = initialize(inp); // Initializing

            while (true && counter < 999) {

                System.out.println("Current Value --> "+value+"\nCurrent Counter -> "+counter);
                
                System.out.print("\n"+calculate+"\n"+expInsert);
                int val = inp.nextInt();

                if (val == 9) {

                    System.out.println("Reinitiallizing....");

                    value = initialize(inp); // Restarting the calculator
                    System.gc(); // Clearing some garbage just in case

                    continue;

                } else if (val == 0) {

                    HistoryCheck(); // Using that HistoryCheck functionm
                    continue;

                } else if (val == 5) { // Special Case for Square Root Function

                    double res = cal.sqroot(value);
                    String[] theResult = {String.valueOf(res),"Square Root"};
                    history.add(theResult);
                    value = res;
                    counter++;
                    continue;

                } else if (val == 10) {
                    
                    System.out.println("Thanks for using the program");
                    System.exit(0);

                } else if (val == 1 || val == 2 || val ==3 || val==4 ) {

                    System.out.print("\n"+valueInsert);
                    double toUse = inp.nextDouble();

                    double newValue = 0; // Just for the initializing sake, It will be changed in the following switch case

                    switch((int) val) {
                        case(1):
                            newValue = cal.sum(toUse,value);
                            // Using Primitive value coz I am bored (I know I could've used StringBuffer but it's boring....)
                            String[] toAdd = {String.valueOf(newValue),"Addition with "+String.valueOf(toUse)};
                            history.add(toAdd);
                            break;
                        case(2):
                            newValue = cal.sub(value, toUse);
                            String[] toSub = {String.valueOf(newValue),"Subtraction with "+String.valueOf(toUse)};
                            history.add(toSub);
                            break;
                        case(3):
                            newValue = cal.mul(value, toUse);
                            String[] toMultiply = {String.valueOf(newValue),"Multiplication with "+String.valueOf(toUse)};
                            history.add(toMultiply);
                            break;
                        case(4):
                            
                            if (value == 0) {System.out.println("Error: Divided by 0");} // Adding this line to make sure it doesn't crash right away.

                            newValue = cal.div(value, toUse);
                            String[] toDivide = {String.valueOf(newValue),"Division with "+String.valueOf(toUse)};
                            history.add(toDivide);
                            break;
                    }
                    value = newValue;
                    counter++;
                    continue;


                } else { // This is for default
                    System.out.println("\n Not a valid option... please try again...");
                    continue;
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