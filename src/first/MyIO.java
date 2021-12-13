package first;

import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 3, 13.12.2021
 */

public final class MyIO
{
    private MyIO() {} 

    /**
     * Scanner sc liest von Tastatur uns steht allen Methoden zur Verfügung
     */
    static Scanner sc = new Scanner(System.in);

    public static String promtAndRead (String prompt)
    {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static int readInt (String prompt)
    {
        while(true)
        {
            try 
            {
                System.out.print(prompt);
                return Integer.parseInt( sc.nextLine().trim() );   
            } 
            catch (Exception e) 
            {
                System.out.println("Keine Datentyp-Int gerechte Zahl!");
            }
        }
    }

    public static long readLong (String prompt)
    {
        while(true)
        {
            try 
            {
                System.out.print(prompt);
                return Long.parseLong( sc.nextLine().trim() );   
            } 
            catch (Exception e) 
            {
                System.out.println("Keine Daentyp-Long gerechte Zahl!");
            }
        }
    }

    public static BigInteger readBigInteger (String prompt)
    {
        while(true)
        {
            try 
            {
                System.out.print(prompt);
                return new BigInteger( sc.nextLine().trim() );   
            } 
            catch (Exception e) 
            {
                System.out.println("Keine Datentyp-BigInteger gerechte Zahl!");
            }
        }
    }

    public static float readFloat (String prompt)
    {
        while(true)
        {
            try 
            {
                System.out.print(prompt);
                return Float.parseFloat( sc.nextLine().trim() );   
            } 
            catch (Exception e) 
            {
                System.out.println("Keine Datentyp-Float gerechte Zahl!");
            }
        }
    }

    public static double readDouble (String prompt)
    {
        while(true)
        {
            try 
            {
                System.out.print(prompt);
                return Double.parseDouble( sc.nextLine().trim() );   
            } 
            catch (Exception e) 
            {
                System.out.println("Keine Datentyp-Double gerechte Zahl!");
            }
        }
    }

    public static BigDecimal readBigDecimal (String prompt)
    {
        while(true)
        {
            try 
            {
                System.out.print(prompt);
                return new BigDecimal( sc.nextLine().trim() );   
            } 
            catch (Exception e) 
            {
                System.out.println("Keine Datentyp-BigDecimal gerechte Zahl!");
            }
        }
    }

    public static Fraction readFraction (String prompt){
        while(true)
        {
            try
            {
                System.out.println(prompt);
                return new Fraction(readBigInteger("Nenner: "),  readBigInteger("Zähler: "));
            } 
            catch (Exception e)
            {
                System.out.println("Kein Datentyp-Fraction gerechte Zahl!");
            }
        }
    }

    public static void write (String s)
    {
        System.out.print(s);
    }

    public static void writeln (String s)
    {
        System.out.println(s);
    }
}