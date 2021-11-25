package first;

import java.math.BigInteger;

/**
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 24.11.2021
 */

public class Fractrain
{
    public static void main(String[] args) 
    {
        Fraction[] L = {
            new Fraction(BigInteger.valueOf(17), BigInteger.valueOf(91)),
            new Fraction(BigInteger.valueOf(78), BigInteger.valueOf(85)),
            new Fraction(BigInteger.valueOf(19), BigInteger.valueOf(51)),
            new Fraction(BigInteger.valueOf(23), BigInteger.valueOf(38)),
            new Fraction(BigInteger.valueOf(29), BigInteger.valueOf(33)),
            new Fraction(BigInteger.valueOf(77), BigInteger.valueOf(29)),
            new Fraction(BigInteger.valueOf(95), BigInteger.valueOf(23)),
            new Fraction(BigInteger.valueOf(77), BigInteger.valueOf(19)),
            new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(17)),
            new Fraction(BigInteger.valueOf(11), BigInteger.valueOf(13)),
            new Fraction(BigInteger.valueOf(13), BigInteger.valueOf(11)),
            new Fraction(BigInteger.valueOf(15), BigInteger.valueOf(2)),
            new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(7)),
            new Fraction(BigInteger.valueOf(55), BigInteger.valueOf(1))
        };

        System.out.println("Liste von Fractions:");
        for (int i = 0; i < L.length -1; i++)
        {
            System.out.print(L[i].toString() + ", ");
        }
        System.out.println(L[L.length -1].toString());
        System.out.println();

        Fraction b = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(1));
        Fraction i11362 = b;
        Fraction max = b;
        int maxp = 1;

        System.out.println("Die ersten 2375 Zahlen und die 23065-te Zahl von b:");
        for (int i = 23060; i < 23065; i++)
        {
            if (i < 2375 || i == 23064)
            {
                System.out.println(b.toString() + ", ");
            }

            if (i == 11361)
            {
                i11362 = b;
            }

            if (i < 11362 && b.compareTo(max) < 0)
            {
                max = b;
                maxp = i;
            }

            for (Fraction f : L)
            {
                Fraction z = b.multiply(f);
                if (z.isInteger())
                {
                    b = z;
                    break; 
                }
            }
        }

        System.out.println("Die 11362-te Zahl ist: " + i11362.toString());
        System.out.println("Die größte Zahl ist " + max.toString() + " an der " + maxp + ". Stelle");
        System.out.println( new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(1)).multiply(
            new Fraction(BigInteger.valueOf(15), BigInteger.valueOf(2))).toString() );
    }    
}