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

    private static boolean validFraction(String input)
    {
        // numerator and denominator
        String num;
        String den;
        int negative = input.indexOf("-");
        if (negative > 0)
        {
            return false;
        }
        if (negative == 0)
        {
            input = input.substring(1);
        }
        // if contains "/", separate numerator and denominator
        int divide = input.indexOf("/");
        if (divide > 0)
        {
            num = input.substring(0, divide);
            den = input.substring(divide);
        }
        else
        {
            num = input;
            den = "1";
        }
        if (!isNumber(num) || !isNumber(den) || den.equals("0"))
        {
            return false;
        }
        return true;
    }

    private static boolean isNumber(String input)
    {
        try
        {
            int i = Integer.parseInt(input);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }
}