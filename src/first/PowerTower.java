package first;

/**
 * das Folgendes leistet: Es werden eine reelle Zahl (double) und eine ganze Zahle n (int) kommentiert (also mit Prompt) eingelesen, 
 * und dann wird der PowerTower-Funktionswert von x und n ausgegeben
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 18.10.2021
 */

public class PowerTower 
{
    public static double f (double x, int n)
    {
        return n <= 0 ? 1 : Math.pow(x, f(x, n-1));  
    }

    public static double f (double x, int n, int a)
    {
        a++;
        double e = Math.pow(x, x);
        return a == n ? e : Math.pow( e, f(x, n, a) ); 
    }

    public static void main (String[] args)
    {
        double x = MyIO.readDouble("Wert für x: ");
        int n = MyIO.readInt("Wert für n: ");

        System.out.println( f(x, n) );
    }
}