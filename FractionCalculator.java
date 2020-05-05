// Fraction Calculator by Cheyenne Foo
import java.util.Scanner;

public class FractionCalculator
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        // Print intro
        System.out.println("Welcome to the Fraction Calculator!");
        System.out.println("It will add, subtract, multiply, and divide fractions until you type Q to quit.\nPlease enter your fractions in the form a/b where a and b are both integers.");
        System.out.println("-----------------------------");
        boolean quit = false;
        while (!quit)
        {
            String test = getOperation(kb);
            System.out.println(test);
            if (test.equals("Q"))
            {
                quit = true;
            }
        }
    }

    private static String getOperation(Scanner kb)
    {
        // Ask for mathmatical operation
        System.out.print("Please enter an operation (+, -, *, /, = or Q to Quit): ");
        boolean valid = false;
        String operation;
        // repeat until input is valid
        while (!valid)
        {
            operation = kb.next();
            switch (operation)
            {
                case "+": return "+";
                case "-": return "-";
                case "*": return "*";
                case "/": return "/";
                case "q":
                case "Q":
                    return "Q";
                default:
                    System.out.print("Invalid input (+, -, *, /, = or Q to Quit): ");
                    break;
            }
        }
        return "error";
    }
}