package first;

import java.math.BigInteger;

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

    @Override
    public String toString() 
    {
        return this.zaehler + "/" + this.nenner;
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

    @Override
    public int compareTo(Fraction o) 
    {
        return 0;
    }
}