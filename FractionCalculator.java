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
        Fraction f1;
        Fraction f2;
        while (!quit)
        {
            String operation = getOperation(kb);
            if (operation.equals("Q"))
            {
                System.out.println("Goodbye!");
                quit = true;
                break;
            }
            f1 = getFraction(kb);
            f2 = getFraction(kb);
            switch (operation)
            {
                case "+":
                    System.out.println(f1 + " + " + f2 + " is " + f1.add(f2));
                case "-":
                    System.out.println(f1 + " - " + f2 + " is " + f1.subtract(f2));
                case "*":
                    System.out.println(f1 + " * " + f2 + " is " + f1.multiply(f2));
                case "/":
                    System.out.println(f1 + " / " + f2 + " is " + f1.divide(f2));
                case "=":
                    System.out.println(f1 + " is the same as " + f2 + ": " + f1.equals(f2));
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
                case "+":
                case "-":
                case "*":
                case "/":
                case "=":
                    return operation;
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

    private static Fraction getFraction(Scanner kb)
    {
        // ask for fraction
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        boolean valid = false;
        String f = "";
        while (!valid)
        {
            f = kb.next();
            if(validFraction(f))
            {
                valid = true;
            }
            else
            {
                System.out.print("Invalid fraction. Please enter (a/b) or (a) where a and b are integers and b is not zero: ");
            }
        }
        int divide = f.indexOf("/");
        int num;
        int den;
        if (divide > 0)
        {
            num = Integer.parseInt(f.substring(0, divide));
            den = Integer.parseInt(f.substring(divide));
        }
        else
        {
            num = Integer.parseInt(f);
            den = 1;
        }
        Fraction frac = new Fraction(num, den);
        return frac;
    }
}