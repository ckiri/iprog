package first;

import java.math.BigInteger;
import java.util.Arrays;

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
        System.out.println(Arrays.toString(L));
        System.out.println();

        Fraction b = new Fraction(2, 1);    //Unsere Startzahl: 2 
        Fraction max = b;   //Das bisherige Maximum
        int maxp = 1;   //... und seine Position in der Liste

        Fraction i11362 = new Fraction(0, 0);

        System.out.println("Die ersten 2375 Zahlen von b:");
        for (int i = 1; i <= 23065; i++)
        {
            if (i <= 2375 || i == 23065)
            {
                System.out.println( i + " " + b.toString());
            }

            for (Fraction f : L)    //die nächsten Zahlen berechnen
            {
                Fraction z = b.multiply(f);
                if (z.isInteger())
                {
                    b = z;
                    break;  //nächste Zahl gefunden ... 
                }
            }

            if (i <= 11362 && b.compareTo(max) > 0) //max und maxpos updaten ...
            {
                max = b;
                maxp = i;
            }

            if (i == 11362) 
            {
                i11362 = b;    
            }
        }

        System.out.println("An der 11362-te Stelle steht die Zahl: " + i11362.toString());
        System.out.println("Die größte Zahl ist " + max.toString() + " an der " + maxp + ". Stelle");
    }    
}