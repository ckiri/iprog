package first;

import java.math.BigInteger;

/**
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 24.11.2021
 */

public class Fraction extends Number implements Comparable<Fraction>
{
    private BigInteger zaehler;
    private BigInteger nenner;

    public Fraction(BigInteger a, BigInteger b)
    {
        this.zaehler = a;
        this.nenner = b;
    }

    public BigInteger getNenner() 
    {
        return this.nenner;
    }

    public BigInteger getZaehler() 
    {
        return this.zaehler;    
    }

    public Fraction add(Fraction o) 
    {
        Fraction x = new Fraction(BigInteger.ONE, BigInteger.ONE);
        if ( nenner.equals(o.nenner) )
        {
            x.nenner = nenner;
            x.zaehler = zaehler.add(o.zaehler);
        }
        else
        {
            x.nenner = getKgV( nenner, o.nenner);
            x.zaehler = zaehler.multiply(nenner.divide(x.nenner)).add(o.zaehler.multiply(o.nenner.divide(x.nenner)));
        }
        return x;
    }

    public Fraction subtract(Fraction o) 
    {
        Fraction x = new Fraction(BigInteger.ONE, BigInteger.ONE);
        if ( nenner.equals(o.nenner) )
        {
            x.nenner = nenner;
            x.zaehler = zaehler.add(o.zaehler);
        }
        else
        {
            x.nenner = getKgV( nenner, o.nenner);
            x.zaehler = zaehler.multiply(nenner.divide(x.nenner)).subtract(o.zaehler.multiply(o.nenner.divide(x.nenner)));
        }
        return x;
    }

    public static BigInteger getKgV (BigInteger x, BigInteger y) 
    {
        return ( x.multiply( y.divide( x.gcd(y) )));
    }

    public Fraction multiply(Fraction o) 
    {
        Fraction x = new Fraction(BigInteger.ONE, BigInteger.ONE);
        
        x.nenner = nenner.multiply(o.nenner);
        x.zaehler = zaehler.multiply(o.zaehler);

        x.nenner = x.nenner.divide(x.zaehler.gcd(x.nenner));
        x.zaehler = x.zaehler.divide(x.zaehler.gcd(x.nenner));

        return x;
    }
    
    public Fraction divide(Fraction o) 
    {
        Fraction x = new Fraction(BigInteger.ONE, BigInteger.ONE);
        
        x.nenner = nenner.multiply(o.zaehler);
        x.zaehler = zaehler.multiply(o.nenner);

        x.nenner = x.nenner.divide(x.zaehler.gcd(x.nenner));
        x.zaehler = x.zaehler.divide(x.zaehler.gcd(x.nenner));

        return x;
    }

    public boolean isInteger()
    {
        BigInteger x = BigInteger.valueOf(0);
        return zaehler.mod(nenner).equals(x);
    }

    @Override
    public String toString() 
    {
        if ( nenner.equals(BigInteger.ONE) ) return zaehler + ""; 
        else return zaehler + "/" + nenner;
    }

    @Override
    public int intValue()
    {
        return (zaehler.divide(nenner)).intValue();
    }

    @Override
    public long longValue() 
    {
        return (zaehler.divide(nenner)).longValue();
    }

    @Override
    public float floatValue() 
    {
        return (zaehler.divide(nenner)).floatValue();
    }

    @Override
    public double doubleValue() 
    {
        return (zaehler.divide(nenner)).doubleValue();
    }

    /**
     * @return -1, 0 or 1 as this Fraction is numerically less than, equal
     *         to, or greater than other Fracton.
     */
    @Override
    public int compareTo(Fraction other) 
    {
        if ( ((this.zaehler).divide(this.nenner)).equals( other.zaehler.divide(other.nenner)) )
        {
            return 0;
        }
        else
        {
            if (zaehler.divide(nenner) == zaehler.divide(nenner).max( other.zaehler.divide(other.nenner) ))
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
    }
}