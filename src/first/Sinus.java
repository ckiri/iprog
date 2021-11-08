package first;

/**
 * das die sin-Funktion für einen eingelesenen x-Wert entsprechend dieser Summe approximiert und ausgibt:
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 08.11.2021
 */

public class Sinus 
{
    public static double sin(long x, int k) 
    {
        return (-1) * x * x / (2*k) / (2*(k+1));
    }

    public static void main(String[] args) 
    {
        long x = MyIO.readLong("x = ");
        int k = 1, n = 10000;
        double maxError = 1e-10;
        double xn = (long) x, xnPlus1 = xn;
        int i = 0;

        do
        {
            xn = xnPlus1;
            xnPlus1 = xn + sin(x, k);
            k++;
            System.out.println(i++);
        }
        while( Math.abs(xnPlus1 - xn) >= maxError && k < n);
        
        System.out.println(xn + " " + xnPlus1);
    }   
}