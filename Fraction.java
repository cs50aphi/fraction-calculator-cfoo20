// Fraction class
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
        // negative goes to numerator or cancels
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
    public int getNumerator()
    {

    }
}