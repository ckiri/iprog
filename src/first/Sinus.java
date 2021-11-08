package first;

import javax.sound.sampled.LineListener;

/**
 * das die sin-Funktion für einen eingelesenen x-Wert entsprechend dieser Summe approximiert und ausgibt:
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 08.11.2021
 */

public class Sinus 
{
    public static void main(String[] args) 
    {
        long x = MyIO.readLong("x = ");
        int k = 0, n = 1, maxIterations = 10000;
        double maxError = 1e-10, xn = 1.0, xnSumme = 0;

        while( Math.abs((xnSumme - xn)) >= maxError && n < maxIterations)
        {
            xn = (-1)*x*x / (2*k) / (2*(k+1));
            xnSumme = xnSumme + xn;
            k++; n++;
        }
    }   
}
