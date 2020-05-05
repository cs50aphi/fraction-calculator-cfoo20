// Fraction class
import java.util.*;
import java.lang.Integer;
import java.lang.Math;

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
        double quotient = (double) this.num / (double) this.den;
        return quotient;
    }
    // addition
    public Fraction add(Fraction other)
    {
        int newNum = (this.num * other.getDenominator()) + (other.getNumerator() * this.den);
        int newDen = this.den * other.getDenominator();
        Fraction total = new Fraction(newNum, newDen);
        total.toLowestTerms();
        return total;
    }
    // subtraction
    public Fraction subtract(Fraction other)
    {
        int newNum = (this.num * other.getDenominator()) - (other.getNumerator() * this.den);
        int newDen = this.den * other.getDenominator();
        Fraction total = new Fraction(newNum, newDen);
        total.toLowestTerms();
        return total;
    }
    // multiplication
    public Fraction multiply(Fraction other)
    {
        int newNum = this.num * other.getNumerator();
        int newDen = this.den * other.getDenominator();
        Fraction product = new Fraction(newNum, newDen);
        product.toLowestTerms();
        return product;
    }
    // divison
    public Fraction divide(Fraction other)
    {
        if (other.getNumerator() == 0)
        {
            throw new IllegalArgumentException("Dividing by 0 is undefined");
        }
        int newNum = this.num * other.getDenominator();
        int newDen = this.den * other.getNumerator();
        Fraction quotient = new Fraction(newNum, newDen);
        quotient.toLowestTerms();
        return quotient;
    }
    // check if the two fractions are equal
    public boolean equals(Object other)
    {
        double first = toDouble();
        // check if other is a Fraction
        if (other instanceof Fraction)
        {
            // cast Object to Fraction
            Fraction f2 = (Fraction) other;
            double second = f2.toDouble();
            if (first == second)
            {
                return true;
            }
            return false;
        }
        else return false;
    }
    // convert fraction to lowest terms
    public void toLowestTerms()
    {
        // find gcd
        int gcd = gcd(this.num, this.den);
        // divide numerator and denominator by gcd
        if (gcd != 0)
        {
            this.num = this.num / gcd;
            this.den = this.den / gcd;
        }
    }
    // greatest common denominator
    public static int gcd(int a, int b)
    {
        // make integers positive
        a = Math.abs(a);
        b = Math.abs(b);
        // while a and b are not zero
        while (a != 0 && b != 0)
        {
            // find the remainder of a divided by b
            int remainder = a % b;
            // set a to b
            a = b;
            // set b to the remainder you found
            b = remainder;
        }
        // return a
        return a;
    }
}