// Fraction class
import java.util.*;
import java.lang.Integer;

public class Fraction
{
    // instance varibles for numerator and denominator
    private int num;
    private int den;

    // Constructor
    // two-parameter
    public Fraction(int num, int den)
    {
        this.num = num;
        // Illegal Argument Exception of denominator is 0
        this.den = den;
        try
        {
            int n = num / den;
        }
        catch (ArithmeticException e)
        {
            throw new ArithmeticException("This fraction is undefined.");
        }
        // negative goes to numerator or cancels
        if (this.den < 0)
        {
            this.num = num * -1;
            this.den = den * -1;
        }
    }
    // one parameter (only numerator)
    public Fraction(int num)
    {
        this(num, 1);
    }
    // no parameters (0)
    public Fraction()
    {
        this(0, 1);
    }

    // Methods
    // get numerator and denomintor
    private int getNumerator()
    {
        return this.num;
    }
    private int getDenominator()
    {
        return this.den;
    }
    // String representation of fraction
    public String toString()
    {
        String numerator = Integer.toString(this.num);
        String denominator = Integer.toString(this.den);
        // return whole number if denominator is 1
        if (this.den == 1)
        {
            return numerator;
        }
        else
        {
            return numerator + "/" + denominator;
        }
    }
    // result
    private double toDouble()
    {
        double quotient = this.num / this.den;
        return quotient;
    }
    // addition
    public Fraction add(Fraction other)
    {
        int newNum = (this.num * other.getDenominator()) + (other.getNumerator() * this.den);
        int newDen = this.den * other.getDenominator();
        Fraction total = new Fraction(newNum, newDen);
        return total;
    }
    // subtraction
    public Fraction subtract(Fraction other)
    {
        int newNum = (this.num * other.getDenominator()) - (other.getNumerator() * this.den);
        int newDen = this.den * other.getDenominator();
        Fraction total = new Fraction(newNum, newDen);
        return total;
    }
}