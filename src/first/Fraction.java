package first;

import java.math.BigInteger;

/**
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 24.11.2021
 */

public class Fraction extends Number implements Comparable<Fraction>
{
    /**
     * Not a Number: special value ... after division by 0
     */
    final static Fraction NaN = new Fraction(BigInteger.ZERO, BigInteger.ZERO); //when we divide by 0 

    private BigInteger numerator;
    private BigInteger denominator;

    /**
     * @return the numerator
     */
    public BigInteger getNenner() 
    {
        return this.denominator;
    }

    /**
     * @return the denominator
     */
    public BigInteger getZaehler() 
    {
        return this.numerator;    
    }

    /**
     * will construct a reduced and normalized Fraction or special value NaN if this is impossible
     * @param a numerator
     * @param b denominator 
     */
    public Fraction(BigInteger a, BigInteger b)
    {
        numerator = a;
        denominator = b;
        switch ( denominator.signum() ) //now normalize 
        {
            case 0:
                numerator = BigInteger.ZERO;    //it is NaN
                break;
            case -1:    ////switch signs
                numerator = numerator.negate();
                denominator = denominator.negate(); //no break here
            case 1:
                BigInteger x = numerator.gcd(denominator);  //compute gcd
                numerator = numerator.divide(x);    //reduce with gcd
                denominator = denominator.divide(x);
                break;
        }
    }

    public Fraction(long a, long b) 
    {
        numerator = BigInteger.valueOf(a); 
        denominator = BigInteger.valueOf(b);
        
        switch ( denominator.signum() ) //now normalize 
        {
            case 0:
                numerator = BigInteger.ZERO;    //it is NaN
                break;
            case -1:    ////switch signs
                numerator = numerator.negate();
                denominator = denominator.negate(); //no break here
            case 1:
                BigInteger x = numerator.gcd(denominator);  //compute gcd
                numerator = numerator.divide(x);    //reduce with gcd
                denominator = denominator.divide(x);
                break;
        }
    }

    public Fraction add(Fraction o) 
    {
        Fraction x = new Fraction(BigInteger.ONE, BigInteger.ONE);
        if ( denominator.equals(o.denominator) )
        {
            x.denominator = denominator;
            x.numerator = numerator.add(o.numerator);
        }
        else
        {
            x.denominator = getKgV( denominator, o.denominator);
            x.numerator = numerator.multiply(x.denominator.divide(denominator)).add(o.numerator.multiply(x.denominator.divide(o.denominator)));
        }

        BigInteger g = x.numerator.gcd(x.denominator);
        x.denominator = x.denominator.divide(g);
        x.numerator = x.numerator.divide(g);
        return x;
    }

    public Fraction subtract(Fraction o) 
    {
        Fraction x = new Fraction(BigInteger.ONE, BigInteger.ONE);
        if ( denominator.equals(o.denominator) )
        {
            x.denominator = denominator;
            x.numerator = numerator.subtract(o.numerator);
        }
        else
        {
            x.denominator = getKgV( denominator, o.denominator);
            x.numerator = numerator.multiply(x.denominator.divide(denominator)).subtract(o.numerator.multiply(x.denominator.divide(o.denominator)));
        }
        
        BigInteger g = x.numerator.gcd(x.denominator);
        x.denominator = x.denominator.divide(g);
        x.numerator = x.numerator.divide(g);
        return x;
    }

    public static BigInteger getKgV (BigInteger x, BigInteger y) 
    {
        return ( x.multiply( y.divide( x.gcd(y) )));
    }

    public Fraction multiply(Fraction o) 
    {
        Fraction x = new Fraction(BigInteger.ONE, BigInteger.ONE);
        
        x.denominator = denominator.multiply(o.denominator);
        x.numerator = numerator.multiply(o.numerator);

        BigInteger g = x.numerator.gcd(x.denominator);
        x.denominator = x.denominator.divide(g);
        x.numerator = x.numerator.divide(g);

        return x;
    }
    
    public Fraction divide(Fraction o) 
    {
        Fraction x = new Fraction(BigInteger.ONE, BigInteger.ONE);
        
        x.denominator = denominator.multiply(o.numerator);
        x.numerator = numerator.multiply(o.denominator);

        BigInteger g = x.numerator.gcd(x.denominator);
        x.denominator = x.denominator.divide(g);
        x.numerator = x.numerator.divide(g);

        return x;
    }

    public boolean isInteger()
    {
        BigInteger x = BigInteger.valueOf(0);
        return numerator.mod(denominator).equals(x);
    }

    @Override
    public String toString() 
    {
        return denominator.signum() == 0 ? "NaN" : numerator + (denominator.equals(BigInteger.ONE) ? "" : "/" + denominator);
    }

    @Override
    public int intValue()
    {
        return numerator.intValue() / denominator.intValue();
    }

    @Override
    public long longValue() 
    {
        return numerator.longValue() / denominator.longValue();
    }

    @Override
    public float floatValue() 
    {
        return numerator.floatValue() / denominator.floatValue();
    }

    @Override
    public double doubleValue() 
    {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    /**
     * @return -1, 0 or 1 as this Fraction is numerically less than, equal to, or greater than other Fracton.
     */
    @Override
    public int compareTo(Fraction o) 
    {
        if ( this.equals(NaN) && o.equals(NaN) ) {return 0;}
        if ( this.equals(NaN) ) {return -1;}
        if ( o.equals(NaN)) {return 1;}

        return numerator.multiply(o.denominator).compareTo(o.numerator.multiply(denominator));   
    }
}