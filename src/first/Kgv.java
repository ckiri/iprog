package first;

import java.math.BigInteger;

/**
 * das zwei beliebig große Zahlen (BigInteger) x und y kommentiert einliest 
 * und anschließend sowohl das kleinste gemeinsame Vielfache (kgV) von x und y 
 * als auch den Rest bei der Division von x durch y korrekt berechnet und kommentiert ausgibt. 
 * Hinweis: kgV(x,y) = x*y/ggT(x,y)
 * 
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 25.10.2021
 */

public class Kgv
{
    public static BigInteger getKgV (BigInteger x, BigInteger y) 
    {
        return ( x.multiply( y.divide( getGgt(x, y) )));    //"BigInteger x.gcd(y)" gibt auch den GgT/ "greatest common divisor" aus.
    }

    public static BigInteger getGgt (BigInteger x, BigInteger y) 
    {
        if( x.equals(y) || y.equals(BigInteger.ZERO)) return x;
        else return getGgt(y, x.mod(y));
    }

    public static BigInteger getRest(BigInteger x, BigInteger y) 
    {
        return x.mod(y);
    }

    public static void main (String[] args)
    {
        System.out.println("Berechnung des kleinsten gemeinsamen Vielfaches (kgV) von zwei Zahlen:");
        BigInteger x = new BigInteger( MyIO.promtAndRead("x = ").trim() );
        BigInteger y = new BigInteger( MyIO.promtAndRead("y = ").trim() );

        System.out.println("Das kleinste gemeinsame Vielfache von " + x + " und " + y + " beträgt " + getKgV(x, y));
        System.out.println("Der Rest der Division von " + x + " und " + y + " beträgt " + getRest(x, y));
    }
}